package at.study.automation.test.uiTestCase;

import at.study.automation.model.users.Status;
import at.study.automation.model.users.User;
import at.study.automation.property.Property;
import at.study.automation.ui.pages.HeaderPage;
import at.study.automation.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActiveUserLoginTest {

    private User userActive;
    private WebDriver driver;
    private HeaderPage headerPage;
    private LoginPage loginPage;


    @BeforeMethod
    private void prepareFixtures() {
        userActive = new User() {{
            setIsAdmin(false);
            setStatus(Status.ACTIVE);
        }}.create();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(Property.getStringProperty("url"));

        headerPage = new HeaderPage();
        loginPage = new LoginPage();
    }

    @Test
    public void positiveActiveUserLoginTest() throws InterruptedException {
        headerPage.loginButton.click();

        Thread.sleep(1000);

        loginPage.login(userActive);

        Assert.assertEquals(headerPage.myAccount.getText(), "Моя учётная запись");
        Assert.assertEquals(headerPage.whoEntered.getText(), "Вошли как " + userActive.getLogin());
        Assert.assertEquals(headerPage.homePage.getText(), "Домашняя страница");
        Assert.assertEquals(headerPage.myPage.getText(), "Моя страница");
        Assert.assertEquals(headerPage.projects.getText(), "Проекты");
        Assert.assertEquals(headerPage.help.getText(), "Помощь");
        Assert.assertEquals(headerPage.logout.getText(), "Выйти");
        Assert.assertTrue(headerPage.isValidationMsgNotExist(headerPage.administration));
        Assert.assertTrue(headerPage.isValidationMsgNotExist(headerPage.loginButton));
        Assert.assertTrue(headerPage.isValidationMsgNotExist(headerPage.registerButton));
        Assert.assertTrue(headerPage.search.isDisplayed());

        driver.quit();

    }
}


