package at.study.automation.test.RequestsTest;

import at.study.automation.model.table_emailAdresses.Email;
import at.study.automation.model.table_users.User;
import org.testng.annotations.Test;

public class CreateEmailTest {

   @Test
public void testCreateEmail(){
    User user = new User();
    Email email = new Email(user);
    email.setUserId(9);


}

}
