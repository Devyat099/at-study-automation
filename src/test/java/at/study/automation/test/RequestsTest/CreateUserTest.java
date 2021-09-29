package at.study.automation.test.RequestsTest;

import at.study.automation.db.request.EmailRequests;
import at.study.automation.db.request.TokenRequests;
import at.study.automation.db.request.UserRequests;
import at.study.automation.model.table_emailAdresses.Email;
import at.study.automation.model.table_tokens.Token;
import at.study.automation.model.table_users.User;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void userCreateTest() {
        // Создание юзера в бд
        User userOne = new User();
        new UserRequests().create(userOne);
        Integer userOneId = userOne.getId();
        System.out.println(userOneId);

        // Создание токена в связке с юзером
        Token tokenOne = new Token(userOne);
        new TokenRequests().create(tokenOne);
        Integer tokenId = tokenOne.getUserId();
        System.out.println(tokenId);

        // Создание емейла в связке с юзером
        Email emailOne = new Email(userOne);
        new EmailRequests().create(emailOne);
        Integer emailId = emailOne.getUserId();
        System.out.println(emailId);


    }
}
