package at.study.automation.test.uiTestCase;

import at.study.automation.model.users.Status;
import at.study.automation.model.users.User;
import at.study.automation.property.Property;
import at.study.automation.ui.HeaderPage;
import at.study.automation.ui.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnacceptedUserLoginTest {
    private User userUnaccepted;
    private WebDriver driver;
    private HeaderPage headerPage;
    private LoginPage loginPage;

    @BeforeMethod
    private void prepareFixtures() {
        userUnaccepted = new User() {{
            setIsAdmin(false);
            setStatus(Status.UNACCEPTED);
        }}.create();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(Property.getStringProperty("url"));

        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void positiveUnacceptedUserLoginTest() throws InterruptedException {

        headerPage.loginButton.click();
        Thread.sleep(1000);
        loginPage.login(userUnaccepted);
        Assert.assertEquals(loginPage.errorlogin.getText(), "Ваша учётная запись создана и ожидает подтверждения администратора.");
        Assert.assertTrue(headerPage.isValidationMsgNotExist(headerPage.myPage));
        Assert.assertTrue(headerPage.loginButton.isDisplayed());
        Assert.assertTrue(headerPage.registerButton.isDisplayed());

        driver.quit();
    }

}
