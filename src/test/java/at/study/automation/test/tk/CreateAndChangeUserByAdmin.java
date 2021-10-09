package at.study.automation.test.tk;

import at.study.automation.api.client.RestApiClient;
import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import at.study.automation.api.client.RestResponse;
import at.study.automation.api.dto.users.UserDto;
import at.study.automation.api.dto.users.UserInfoDto;
import at.study.automation.api.dto.users.UsersListDto;
import at.study.automation.api.rest_assured.RestAssuredClient;
import at.study.automation.api.rest_assured.RestAssuredRequest;
import at.study.automation.model.users.Status;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import at.study.automation.utils.StringUtils;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

public class CreateAndChangeUserByAdmin {

    private RestApiClient apiClient;
    private RestRequest request;


    @BeforeMethod
    public void createUserAdmin() {
        User user = new User(){{
            setTokens(Collections.singletonList(new Token(this)));
            setIsAdmin(true);
        }}.create();

        UserInfoDto dto = new UserInfoDto(
                new UserDto()
                .setLogin("Dev" + StringUtils.randomEnglishString(3))
                .setLastName("Tes" + StringUtils.randomEnglishString(4))
                .setFirstName(StringUtils.randomEnglishString(3))
                .setMail(StringUtils.randomEmail())
                .setPassword(StringUtils.randomEnglishString(10))
                .setStatus(Status.UNACCEPTED.statusCode)
        );

        String body = new Gson().toJson(dto);

        apiClient = new RestAssuredClient(user);

        request = new RestAssuredRequest(RestMethod.POST, "/users.json", null, null, body);

    }
        @Test
            public void createUserByAdminUserTest(){
            RestResponse response = apiClient.execute(request);

            Assert.assertEquals(response.getStatusCode(), 201);

            UsersListDto responseData = response.getPayload(UsersListDto.class);

            int findIndex = response.getPayload().indexOf("\"status\":2");
            boolean a = false;
            if (findIndex >= 0) a = true;

            Assert.assertTrue(a);





        }


}
