package at.study.automation.test.uiTestCase;

import at.study.automation.db.request.UserRequests;
import at.study.automation.model.users.User;
import at.study.automation.utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.utils.StringUtils.randomEmail;

public class CreateNewUserByAdmin extends BaseUITest {


    private User admin;
    private User user;

    @BeforeMethod
    private void prepareFixtures() {

        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        user = new User() {{
            setIsAdmin(false);
        }}.create();

        openBrowser();
    }

    @Test
    public void createUserByAdmin() {

        headerPage.loginButton.click();
        loginPage.login(admin);
        headerPage.administration.click();
        administrationPage.users.click();

        usersPage.newUser.click();

        newUserPage.userLogin.sendKeys(StringUtils.randomEnglishString(5));
        newUserPage.userFirstname.sendKeys(StringUtils.randomEnglishString(3));
        newUserPage.userLastname.sendKeys(StringUtils.randomEnglishString(5));
        newUserPage.userMail.sendKeys(randomEmail());
        newUserPage.userCreatePassword.click();
        newUserPage.userCreate.click();
        String userLogin = newUserPage.getNameCreateUser.getText();

        User us = new UserRequests().readUserByLogin(userLogin);

        Assert.assertEquals(newUserPage.getNameCreateUser.getText(), us.getLogin());







    }
}
