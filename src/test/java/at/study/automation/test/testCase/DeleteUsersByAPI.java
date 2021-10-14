package at.study.automation.test.testCase;

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
    public void deleteUers() {
        // 1. Запрос DELETE на удаление пользователя без ключа API
        String uriIdTestUser = String.format("/users/%s.json", testUser.getId());
        RestResponse responseCheck1 = apiClient.execute(request(RestMethod.DELETE, uriIdTestUser));
        Assert.assertEquals(responseCheck1.getStatusCode(), 403);
        User ur = new UserRequests().read(testUser.getId());
        Assert.assertNotNull(ur);

        // 2. Запрос DELETE на удаление пользователя с ключом API (самого себя)
        String uriIdMainUser = String.format("/users/%s.json", mainUser.getId());
        RestResponse responseCheck2 = apiClient.execute(request(RestMethod.DELETE, uriIdMainUser));
        Assert.assertEquals(responseCheck2.getStatusCode(), 403);
        User ur1 = new UserRequests().read(mainUser.getId());
        Assert.assertNotNull(ur1);
    }
}
