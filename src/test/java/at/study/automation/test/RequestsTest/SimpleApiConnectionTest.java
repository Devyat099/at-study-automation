package at.study.automation.test.RequestsTest;

import at.study.automation.api.client.RestApiClient;
import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import at.study.automation.api.client.RestResponse;
import at.study.automation.api.dto.users.UserDto;
import at.study.automation.api.dto.users.UserInfoDto;
import at.study.automation.api.dto.users.UsersListDto;
import at.study.automation.api.rest_assured.RestAssuredClient;
import at.study.automation.api.rest_assured.RestAssuredRequest;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static at.study.automation.api.rest_assured.GsonProvider.GSON;
import static io.restassured.RestAssured.given;
public class SimpleApiConnectionTest {


    private final RequestSpecification NO_AUTH_SPECIFICATION = given().baseUri("http://edu-at.dfu.i-teco.ru/");
    private final RequestSpecification ADMIN_AUTH_SPECIFICATION = given().baseUri("http://edu-at.dfu.i-teco.ru/")
            .header("X-Redmine-API-Key", "55dfd83d5c925f999826c683114e589a4dd9f7e6")
            .log().all();

    @Test
    public void restSimpleRequest() {
        given(ADMIN_AUTH_SPECIFICATION)
                .request(Method.GET, "/users.json")
                .then()
                .log().all()
                .statusCode(200);
    }


    @Test
    public void testNoAuthGetUsers() {
        given()
                .baseUri("http://edu-at.dfu.i-teco.ru/")
                .contentType(ContentType.JSON)
                .log().all()
                .request(Method.GET, "/users.json")
                .then()
                .log().all()
                .statusCode(401);
    }

    @Test
    public void testUserCreation() {
        UserInfoDto body = new UserInfoDto(
                new UserDto()
                .setLogin("login123321")
                .setLastName("firstname31223123")
                .setFirstName("lastname14124")
                .setMail("jp_l312anag@yahfodao.fr")
                .setPassword("password1231")

        );

        given(ADMIN_AUTH_SPECIFICATION).contentType(ContentType.JSON)

                .body(GSON.toJson(body))
                .request(Method.POST, "/users.json")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    public void testApiClient(){
        User user = new User(){{
            setIsAdmin(true);
            setTokens(Collections.singletonList(new Token(this)));
        }}.create();


        RestApiClient apiClient = new RestAssuredClient(user);
        RestRequest request = new RestAssuredRequest(RestMethod.GET, "/users.json", null,null,null);


        RestResponse response = apiClient.execute(request);

        Assert.assertEquals(response.getStatusCode(), 200);

        UsersListDto body = response.getPayload(UsersListDto.class);

        Assert.assertEquals(body.getLimit().intValue(), 25);
        Assert.assertEquals(body.getUsers().get(0).getLogin(), "admin");

    }

}
