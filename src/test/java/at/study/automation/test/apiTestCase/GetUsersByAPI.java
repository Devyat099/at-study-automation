package at.study.automation.test.apiTestCase;

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

        // 1. Запрос GET на получение текущего пользователя используя ключ АПИ
        String uriIdTestUser = String.format("/users/%s.json", testUser.getId());
        String uriIdMainUser = String.format("/users/%s.json", mainUser.getId());
        RestResponse responseFromGetRequestThisUser = apiClient.execute(request(RestMethod.GET, uriIdMainUser));
        Assert.assertEquals(responseFromGetRequestThisUser.getStatusCode(), 200);
        UserInfoDto responseData1 = responseFromGetRequestThisUser.getPayload(UserInfoDto.class);

        Assert.assertNotNull(responseData1.getUser().getIsAdmin());
        Assert.assertNotNull(responseData1.getUser().getApiKey());


        // 2. Запрос GET на получение другого пользователя используя ключ АПИ
        RestResponse responseFromGetRequestOtherUser = apiClient.execute(request(RestMethod.GET, uriIdTestUser));
        Assert.assertEquals(responseFromGetRequestOtherUser.getStatusCode(), 200);
        UserInfoDto responseData2 = responseFromGetRequestOtherUser.getPayload(UserInfoDto.class);

        Assert.assertNull(responseData2.getUser().getIsAdmin());
        Assert.assertNull(responseData2.getUser().getApiKey());

    }
}
