package at.study.automation.test.tk;

import at.study.automation.api.client.RestApiClient;
import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import at.study.automation.api.client.RestResponse;
import at.study.automation.api.dto.users.UserDto;
import at.study.automation.api.dto.users.UserInfoDto;
import at.study.automation.api.rest_assured.RestAssuredClient;
import at.study.automation.api.rest_assured.RestAssuredRequest;
import at.study.automation.db.request.UserRequests;
import at.study.automation.model.users.Status;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import at.study.automation.utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

import static at.study.automation.api.rest_assured.GsonProvider.GSON;

public class CreateAndChangeUserByAdmin {

    private RestApiClient apiClient;
    private RestRequest request;


    @BeforeMethod
    public void createUserAdmin() {
        User user = new User() {{
            setTokens(Collections.singletonList(new Token(this)));
            setIsAdmin(true);
        }}.create();

        UserInfoDto dto = new UserInfoDto(
                new UserDto()
                        .setLogin("Myow" + StringUtils.randomEnglishString(3))
                        .setLastName("es" + StringUtils.randomEnglishString(4))
                        .setFirstName(StringUtils.randomEnglishString(3))
                        .setMail(StringUtils.randomEmail())
                        .setPassword(StringUtils.randomEnglishString(10))
                        .setStatus(Status.UNACCEPTED.statusCode)
        );

        String body = GSON.toJson(dto);

        apiClient = new RestAssuredClient(user);

        request = new RestAssuredRequest(RestMethod.POST, "/users.json", null, null, body);

    }

    @Test
    public void createUserByAdminUserTest() {
        RestResponse response = apiClient.execute(request);
        UserInfoDto responseData = response.getPayload(UserInfoDto.class);

        // проверяем статус ответа и что пользователю установлен статус "2"
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(responseData.getUser().getStatus().toString(), "2");

        User testUser = new UserRequests().read(responseData.getUser().getId());

        // действительно создался пользователь в бд и соответствует ли полученному ответу
        Assert.assertEquals(testUser.getFirstName(), responseData.getUser().getFirstName());
        Assert.assertEquals(testUser.getLastName(), responseData.getUser().getLastName());


        System.out.println(testUser.getStatus());
        System.out.println(testUser.getFirstName());
        System.out.println(testUser.getLastName());

    }
}
