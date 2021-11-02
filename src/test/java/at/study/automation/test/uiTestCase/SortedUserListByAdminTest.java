package at.study.automation.test.uiTestCase;

import at.study.automation.model.projects.Project;
import at.study.automation.model.users.User;
import at.study.automation.ui.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortedUserListByAdminTest extends BaseUITest {

    private User admin;
    private User testUserOne;
    private User testUserSome;
    private Project project;
    private WebDriver driver;
    //private HeaderPage headerPage;
    //private LoginPage loginPage;
    private ProjectPage projectPage;
    private AdministrationPage adminPage;
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


        openBrowser();

        headerPage = new HeaderPage();
        loginPage = new LoginPage();
        adminPage = new AdministrationPage();
        usersPage = new UsersPage();

    }

    @Test
    public void sortedListUserByAdminTest() {
        headerPage.loginButton.click();
        loginPage.login(admin);
        headerPage.administration.click();

        adminPage.users.click();


        Assert.assertTrue(usersPage.isUsersPage.isDisplayed());

        Assert.assertTrue(usersPage.sortUserListByLoginDesc.isDisplayed());
        usersPage.sortUserListByLoginDesc.click();

        Assert.assertTrue(usersPage.sortUserListByLoginAsc.isDisplayed());

    }
}