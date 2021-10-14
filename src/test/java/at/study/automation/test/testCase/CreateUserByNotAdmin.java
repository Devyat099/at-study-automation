package at.study.automation.test.testCase;

import at.study.automation.api.client.RestApiClient;
import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import at.study.automation.api.client.RestResponse;
import at.study.automation.api.dto.users.UserDto;
import at.study.automation.api.dto.users.UserInfoDto;
import at.study.automation.api.rest_assured.RestAssuredClient;
import at.study.automation.api.rest_assured.RestAssuredRequest;
import at.study.automation.model.users.Status;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

public class CreateUserByNotAdmin {
    /**
     * Предусловие:
     * 1. Заведен пользователь в системе
     * 2. У пользователя есть доступ к API и ключ API
     */
    private User noAdminUser;
    private User testUser;
    private RestApiClient apiClient;

    @BeforeClass
    private void createTestUsers() {

        noAdminUser = new User() {{
            setStatus(Status.ACTIVE);
            setTokens(Collections.singletonList(new Token(this)));
            setIsAdmin(false);
        }}.create();

        testUser = new User() {{
            setIsAdmin(true);
        }};

        apiClient = new RestAssuredClient(noAdminUser);

    }

    private RestRequest request(RestMethod method, String uri, String body) {
        return new RestAssuredRequest(method, uri, null, null, body);
    }

    private String bodyForRequest(User user) {
        UserInfoDto userApi = new UserInfoDto(
                new UserDto()
                        .setLogin(user.getLogin())
                        .setLastName(user.getLastName())
                        .setFirstName(user.getFirstName())
                        .setPassword(user.getPassword())
                        .setStatus(user.getStatus().statusCode));

        return new Gson().toJson(userApi);
    }

    @Test
    public void createUserByNotAdmin(){

        // 1. Запрос POST на создание пользователя не админом
        RestResponse responseCheck1 = apiClient.execute(request(RestMethod.POST, "/users.json", bodyForRequest(testUser)));
        Assert.assertEquals(responseCheck1.getStatusCode(), 403);
    }

}
