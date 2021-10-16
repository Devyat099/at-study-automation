package at.study.automation.test.apiTestCase;

import at.study.automation.api.client.RestApiClient;
import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import at.study.automation.api.client.RestResponse;
import at.study.automation.api.rest_assured.RestAssuredClient;
import at.study.automation.api.rest_assured.RestAssuredRequest;
import at.study.automation.db.request.UserRequests;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

public class DeleteUsersByAPI {

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
    public void deleteUsers() {
        // 1. Запрос DELETE на удаление пользователя без ключа API - пользователь не удален
        String uriIdTestUser = String.format("/users/%s.json", testUser.getId());
        RestResponse responseFromDeleteRequestUserNotApi = apiClient.execute(request(RestMethod.DELETE, uriIdTestUser));
        Assert.assertEquals(responseFromDeleteRequestUserNotApi.getStatusCode(), 403);
        User ur = new UserRequests().read(testUser.getId());
        Assert.assertNotNull(ur);

        // 2. Запрос DELETE на удаление пользователя с ключом API (самого себя) - пользователь не удален
        String uriIdMainUser = String.format("/users/%s.json", mainUser.getId());
        RestResponse responseFromDeleteRequestUserWithApi = apiClient.execute(request(RestMethod.DELETE, uriIdMainUser));
        Assert.assertEquals(responseFromDeleteRequestUserWithApi.getStatusCode(), 403);
        User ur1 = new UserRequests().read(mainUser.getId());
        Assert.assertNotNull(ur1);
    }
}
