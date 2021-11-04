package at.study.automation.test.uiTestCase;

import at.study.automation.model.users.Status;
import at.study.automation.model.users.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.ui.browser.BrowserUtils.isElementDisplayed;


public class UnacceptedUserLoginTest extends BaseUITest {

    private User userUnaccepted;

    @BeforeMethod
    private void prepareFixtures() {

        userUnaccepted = new User() {{
            setIsAdmin(false);
            setStatus(Status.UNACCEPTED);
        }}.create();

        openBrowser();
    }

    @Test
    public void positiveUnacceptedUserLoginTest() {

        headerPage.loginButton.click();
        loginPage.login(userUnaccepted);

        Assert.assertEquals(loginPage.errorlogin.getText(), "Ваша учётная запись создана и ожидает подтверждения администратора.");

        Assert.assertFalse(isElementDisplayed(headerPage.myPage));
        Assert.assertTrue(headerPage.loginButton.isDisplayed());
        Assert.assertTrue(headerPage.registerButton.isDisplayed());
    }
}
