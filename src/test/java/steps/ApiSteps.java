package steps;

import at.study.automation.api.client.RestApiClient;
import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import at.study.automation.api.client.RestResponse;
import at.study.automation.api.dto.users.UserDto;
import at.study.automation.api.dto.users.UserInfoDto;
import at.study.automation.api.rest_assured.RestAssuredClient;
import at.study.automation.api.rest_assured.RestAssuredRequest;
import at.study.automation.context.Context;
import at.study.automation.model.users.User;
import cucumber.api.java.ru.Дано;
import org.testng.Assert;

import static at.study.automation.api.rest_assured.GsonProvider.GSON;

public class ApiSteps {

    @Дано("Для пользователя \"(.+)\" заведен \"(.+)\" клиент")
    public void apiClientForUser(String userStashId, String apiStashId) {

        User user = Context.getStash().get(userStashId, User.class);
        RestApiClient apiClient = new RestAssuredClient(user);

        Context.getStash().put(apiStashId, apiClient);
    }

    @Дано("Выполнить запрос \"(.+)\", с телом \"(.+)\" с помощью клиента \"(.+)\" по адресу \"(.+)\" и получить ответ \"(.+)\"")
    public void apiRequest(String methodId, String bodyUser, String apiUser, String uri, String responseId) {
        User user = Context.getStash().get(bodyUser, User.class);

        UserInfoDto dto = new UserInfoDto(
                new UserDto()
                        .setLogin(user.getLogin())
                        .setLastName(user.getLastName())
                        .setFirstName(user.getFirstName())
                        .setMail(user.getEmails().get(0).getAddress())
                        .setPassword(user.getPassword())
                        .setStatus(user.getStatus().statusCode));

        RestApiClient apiClient = Context.getStash().get(apiUser, RestApiClient.class);

        RestRequest request = new RestAssuredRequest(RestMethod.POST, uri, null, null, GSON.toJson(dto));
        RestResponse response = apiClient.execute(request);

        Context.getStash().put(responseId, response);
        Context.getStash().put(methodId, request);

    }

    @Дано("Проверяем, что ответ \"(.+)\" имеет код \"(.+)\"")
    public void checkResponse(String responseId, String codeResponse){
        RestResponse response = Context.getStash().get(responseId, RestResponse.class);

       Assert.assertEquals(response.getStatusCode(), Integer.parseInt(codeResponse));

    }

}
