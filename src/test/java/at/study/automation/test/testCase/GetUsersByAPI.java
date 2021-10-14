package at.study.automation.test.testCase;

import at.study.automation.api.client.RestApiClient;
import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import at.study.automation.api.client.RestResponse;
import at.study.automation.api.dto.users.UserInfoDto;
import at.study.automation.api.rest_assured.RestAssuredClient;
import at.study.automation.api.rest_assured.RestAssuredRequest;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

public class GetUsersByAPI {

    private RestApiClient apiClient;
    private User testUser;
    private User mainUser;

    /**
     * Предусловие:
     * 1. Заведен пользователь в системе
     * 2. У пользователя есть доступ к API и ключ API
     * 3. Заведен еще один пользователь в системе
     */

    @BeforeClass
    private void createTestData() {

        mainUser = new User() {{
            setIsAdmin(false);
            setTokens(Collections.singletonList(new Token(this)));
        }}.create();

        testUser = new User() {{
            setIsAdmin(false);

        }}.create();

        apiClient = new RestAssuredClient(mainUser);
    }

    private RestRequest request(RestMethod method, String uri) {
        return new RestAssuredRequest(method, uri, null, null, null);
    }


    @Test
    public void getUserTest() {

        String uriIdTestUser = String.format("/users/%s.json", testUser.getId());
        String uriIdMainUser = String.format("/users/%s.json", mainUser.getId());
        RestResponse responseCheck1 = apiClient.execute(request(RestMethod.GET, uriIdMainUser));
        Assert.assertEquals(responseCheck1.getStatusCode(), 200);
        UserInfoDto responseData1 = responseCheck1.getPayload(UserInfoDto.class);

        // проверяем что поля админ и апи доступны
        Assert.assertNotNull(responseData1.getUser().getIsAdmin());
        Assert.assertNotNull(responseData1.getUser().getApiKey());


        RestResponse responseCheck2 = apiClient.execute(request(RestMethod.GET, uriIdTestUser));
        Assert.assertEquals(responseCheck2.getStatusCode(), 200);
        UserInfoDto responseData2 = responseCheck2.getPayload(UserInfoDto.class);

        Assert.assertNull(responseData2.getUser().getIsAdmin());
        Assert.assertNull(responseData2.getUser().getApiKey());

    }
}
