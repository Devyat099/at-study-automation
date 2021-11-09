package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.model.users.Status;
import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.ui.browser.BrowserUtils.isElementDisplayed;

public class tk_2ActiveUserLoginTest extends BaseUITest {

    private User userActive;

    @BeforeMethod
    private void prepareFixtures() {
        userActive = new User() {{
            setIsAdmin(false);
            setStatus(Status.ACTIVE);
        }}.create();

        openBrowser();
    }

    @Test
    public void positiveActiveUserLoginTest() {

        headerPage.loginButton.click();
        loginPage.login(userActive);

        Assert.assertEquals(headerPage.myAccount.getText(), "Моя учётная запись");
        Assert.assertEquals(headerPage.whoEntered.getText(), "Вошли как " + userActive.getLogin());
        Assert.assertEquals(headerPage.homePage.getText(), "Домашняя страница");
        Assert.assertEquals(headerPage.myPage.getText(), "Моя страница");
        Assert.assertEquals(headerPage.projects.getText(), "Проекты");
        Assert.assertEquals(headerPage.help.getText(), "Помощь");
        Assert.assertEquals(headerPage.logout.getText(), "Выйти");

        Assert.assertFalse(isElementDisplayed(headerPage.administration));
        Assert.assertFalse(isElementDisplayed(headerPage.loginButton));
        Assert.assertFalse(isElementDisplayed(headerPage.registerButton));
        Assert.assertTrue(headerPage.search.isDisplayed());
    }
}


