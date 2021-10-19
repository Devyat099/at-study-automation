package at.study.automation.test.uiTestCase;

import at.study.automation.model.users.User;
import at.study.automation.property.Property;
import at.study.automation.ui.HeaderPage;
import at.study.automation.ui.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminLoginTestRefactor {

    private User admin;
    private WebDriver driver;
    private HeaderPage headerPage;
    private LoginPage loginPage;


    @BeforeMethod
    private void prepareFixtures() {
        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(Property.getStringProperty("url"));

        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void positiveAdminLoginTest() throws InterruptedException {

        headerPage.loginButton.click();

        Thread.sleep(1000);

        loginPage.login(admin);

        Assert.assertEquals(headerPage.myAccount.getText(), "Моя учётная запись");
        driver.quit();


    }
}
