package at.study.automation.test.RequestsTest;

import at.study.automation.db.request.TokenRequests;
import at.study.automation.db.request.UserRequests;
import at.study.automation.model.table_tokens.Token;
import at.study.automation.model.table_users.User;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void userCreateTest() {
        User userOne = new User();
        new UserRequests().create(userOne);
        Integer userOneId = userOne.getId();
        System.out.println(userOneId);

        Token tokenOne = new Token(userOne);
        new TokenRequests().create(tokenOne);
        Integer tokenId = tokenOne.getUserId();
        System.out.println(tokenId);
    }
}
