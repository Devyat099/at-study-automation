package at.study.automation.test.testCase;

import at.study.automation.api.client.RestApiClient;
import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import at.study.automation.api.client.RestResponse;
import at.study.automation.api.dto.users.UserDto;
import at.study.automation.api.dto.users.UserErrorsDto;
import at.study.automation.api.dto.users.UserInfoDto;
import at.study.automation.api.rest_assured.RestAssuredClient;
import at.study.automation.api.rest_assured.RestAssuredRequest;
import at.study.automation.db.request.UserRequests;
import at.study.automation.model.users.Email;
import at.study.automation.model.users.Status;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

import static at.study.automation.utils.StringUtils.randomEmail;

public class CreateAndChangeUserByAdmin {

    private RestApiClient apiClient;
    private User testUser;
    private User adminUser;
    private UserInfoDto userApi;

    /**
     * Предусловие:
     * 1. Заведен пользователь в системе с правами администратора
     * 2. У пользователя есть доступ к API и ключ API
     */
    @BeforeClass
    private void createTestUsers() {

        adminUser = new User() {{
            setTokens(Collections.singletonList(new Token(this)));
            setStatus(Status.ACTIVE);
            setIsAdmin(true);
        }}.create();

        testUser = new User() {{
            setStatus(Status.UNACCEPTED);
            setIsAdmin(false);
            setEmails(Collections.singletonList(new Email(this)));
        }};

        // Добавляем заголовок "X-Redmine-API-Key" для админа
        apiClient = new RestAssuredClient(adminUser);

    }

    private RestRequest request(RestMethod method, String uri, String body) {
        return new RestAssuredRequest(method, uri, null, null, body);
    }

    private String bodyForRequest(User user) {

        userApi = new UserInfoDto(
                new UserDto()
                        .setLogin(user.getLogin())
                        .setLastName(user.getLastName())
                        .setFirstName(user.getFirstName())
                        .setMail(user.getEmails().get(0).getAddress())
                        .setPassword(user.getPassword())
                        .setStatus(user.getStatus().statusCode));

        return new Gson().toJson(userApi);

    }


    @Test
    public void createUserByAdminUserTest() {
        // 1. Запрос POST на создание пользователя, пользователь должен иметь status = 2
        RestResponse responseCheck1 = apiClient.execute(request(RestMethod.POST, "/users.json", bodyForRequest(testUser)));
        UserInfoDto responseData = responseCheck1.getPayload(UserInfoDto.class);

        Assert.assertEquals(responseCheck1.getStatusCode(), 201);
        Assert.assertEquals(responseData.getUser().getStatus().toString(), "2");

        // Проверка создания в БД пользователя
        User readUser = new UserRequests().read(responseData.getUser().getId());
        Assert.assertEquals(readUser.getFirstName(), responseData.getUser().getFirstName());
        Assert.assertEquals(readUser.getLastName(), responseData.getUser().getLastName());

        // 2. Запрос POST на создание пользователя повторно с тем же телом запроса
        RestResponse responseCheck2 = apiClient.execute(request(RestMethod.POST, "/users.json", bodyForRequest(testUser)));
        Assert.assertEquals(responseCheck2.getStatusCode(), 422);

        // проверка ожидаемых ошибок, содержащихся в ответе
        UserErrorsDto errorsDto = responseCheck2.getPayload(UserErrorsDto.class);
        Assert.assertTrue(errorsDto.getErrors().toString().contains("Email уже существует"));
        Assert.assertTrue(errorsDto.getErrors().toString().contains("Пользователь уже существует"));

        // 3. Запрос POST на создание пользователя повторно с тем же телом запроса, при этом изменив "email" на невалидный, а "password" - на строку из 4 символов
        testUser.setPassword("pass");
        testUser.getEmails().get(0).setAddress("на невалидный");
        RestResponse responseCheck3 = apiClient.execute(request(RestMethod.POST, "/users.json", bodyForRequest(testUser)));
        Assert.assertEquals(responseCheck3.getStatusCode(), 422);

        // 4. Запрос PUT на изменение пользователя. Данные из ответа запроса, выполненного в шаге №1, но поле status = 1
        testUser.setStatus(Status.ACTIVE);
        testUser.setPassword("getPassword()");
        testUser.getEmails().get(0).setAddress(randomEmail());
        String uriId = String.format("/users/%s.json", responseData.getUser().getId());
        RestResponse responseCheck4 = apiClient.execute(request(RestMethod.PUT, uriId, bodyForRequest(testUser)));

        Assert.assertEquals(responseCheck4.getStatusCode(), 204);
        User r1eadUser = new UserRequests().read(responseData.getUser().getId());
        Assert.assertEquals(testUser.getLogin(), r1eadUser.getLogin());


        // 5. Запрос GET на получение пользователя
        RestResponse responseCheck5 = apiClient.execute(request(RestMethod.GET, uriId, bodyForRequest(testUser)));
        UserInfoDto responseData1 = responseCheck5.getPayload(UserInfoDto.class);
        Assert.assertEquals(responseCheck5.getStatusCode(), 200);
        Assert.assertEquals(responseData1.getUser().getStatus().toString(), "1");


        // 6. Запрос DELETE на удаление пользователя
        RestResponse responseCheck6 = apiClient.execute(request(RestMethod.DELETE, uriId, null));
        Assert.assertEquals(responseCheck6.getStatusCode(), 204);

        // 7.Запрос DELETE на удаление пользователя повторно
        RestResponse responseCheck7 = apiClient.execute(request(RestMethod.DELETE, uriId, null));
        Assert.assertEquals(responseCheck7.getStatusCode(), 404);


    }
}
