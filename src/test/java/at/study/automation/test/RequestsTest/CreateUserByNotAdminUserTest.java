package at.study.automation.test.RequestsTest;

import at.study.automation.api.client.RestApiClient;
import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import at.study.automation.api.client.RestResponse;
import at.study.automation.api.dto.users.UserDto;
import at.study.automation.api.dto.users.UserInfoDto;
import at.study.automation.api.rest_assured.RestAssuredClient;
import at.study.automation.api.rest_assured.RestAssuredRequest;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

public class CreateUserByNotAdminUserTest {

    private RestApiClient apiClient;
    private RestRequest request;



    @BeforeMethod
    public void prepareFixtures() {
        User user = new User(){{
            setTokens(Collections.singletonList(new Token(this)));
        }}.create();

        UserInfoDto dto = new UserInfoDto(
                new UserDto()
                        .setLogin("login321")
                        .setLastName("firstname23123")
                        .setFirstName("lastname14124")
                        .setMail("jp_lanag@yahfodao.fr")
                        .setPassword("password1231")
        );

        String body = new Gson().toJson(dto);


        apiClient = new RestAssuredClient(user);

        request = new RestAssuredRequest(RestMethod.POST, "/users.json", null, null, body);
    }

    @Test
    public void CreateUserByNotAdminUserTest() {

        RestResponse response = apiClient.execute(request);

        Assert.assertEquals(response.getStatusCode(), 403);


    }
}
