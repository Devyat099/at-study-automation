package at.study.automation.test.uiTestCase;

import at.study.automation.model.projects.Project;
import at.study.automation.model.users.User;
import at.study.automation.property.Property;
import at.study.automation.ui.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortedUserListByAdminTest {

    private User admin;
    private User testUserOne;
    private User testUserSome;
    private Project project;
    private WebDriver driver;
    private HeaderPage headerPage;
    private LoginPage loginPage;
    private ProjectPage projectPage;
    private AdminisrationPage adminPage;
    private UsersPage usersPage;

    @BeforeMethod
    private void prepareFixtures() {
        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        testUserOne = new User() {{
            setIsAdmin(false);
        }}.create();

        testUserSome = new User() {{
            setIsAdmin(false);
        }}.create();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(Property.getStringProperty("url"));

        headerPage = new HeaderPage();
        loginPage = new LoginPage();
        adminPage = new AdminisrationPage(driver);
        usersPage = new UsersPage(driver);

    }

    @Test
    public void sortedListUserByAdminTest() throws InterruptedException {
        headerPage.loginButton.click();
        loginPage.login(admin);
        headerPage.administration.click();

        adminPage.users.click();
        Thread.sleep(1000);

        Assert.assertTrue(usersPage.isUsersPage.isDisplayed());

        Assert.assertTrue(usersPage.sortUserListByLoginDesc.isDisplayed());
        usersPage.sortUserListByLoginDesc.click();

        Assert.assertTrue(usersPage.sortUserListByLoginAsc.isDisplayed());


        driver.quit();
    }
}