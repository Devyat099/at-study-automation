package at.study.automation.test.uiTestCase;

import at.study.automation.model.users.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminLoginTestRefactor extends BaseUITest {

    private User admin;


    @BeforeMethod
    private void prepareFixtures() {
        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser("login");
    }

    @Test
    public void positiveAdminLoginTest() {

        //headerPage.loginButton.click();

        loginPage.login(admin);

        // Наличие/отсутствие элементов на странице
        Assert.assertEquals(headerPage.myAccount.getText(), "Моя учётная запись");
        Assert.assertEquals(headerPage.whoEntered.getText(), "Вошли как " + admin.getLogin());
        Assert.assertEquals(headerPage.homePage.getText(), "Домашняя страница");
        Assert.assertEquals(headerPage.myPage.getText(), "Моя страница");
        Assert.assertEquals(headerPage.projects.getText(), "Проекты");
        Assert.assertEquals(headerPage.administration.getText(), "Администрирование");
        Assert.assertEquals(headerPage.help.getText(), "Помощь");
        Assert.assertEquals(headerPage.logout.getText(), "Выйти");
        //Assert.assertTrue(headerPage.isValidationMsgNotExist(headerPage.loginButton));
        //Assert.assertTrue(headerPage.isValidationMsgNotExist(headerPage.registerButton));
        Assert.assertTrue(headerPage.search.isDisplayed());
    }
}
