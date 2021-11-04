package at.study.automation.test.uiTestCase;

import at.study.automation.ui.browser.Browser;
import at.study.automation.ui.browser.BrowserManager;
import at.study.automation.ui.pages.*;
import org.testng.annotations.AfterMethod;

public class BaseUITest {

    protected Browser browser;
    protected HeaderPage headerPage;
    protected LoginPage loginPage;
    protected AdministrationPage administrationPage;
    protected UserTablePage userTablePage;
    protected UsersPage usersPage;
    protected NewUserPage newUserPage;

    protected void openBrowser() {
        browser = BrowserManager.getBrowser();
        initPages();

    }

    protected void openBrowser(String uri) {
        browser = BrowserManager.getBrowser(uri);
        initPages();
    }

    private void initPages() {
        headerPage = new HeaderPage();
        loginPage = new LoginPage();
        administrationPage = new AdministrationPage();
        userTablePage = new UserTablePage();
        usersPage = new UsersPage();
        newUserPage = new NewUserPage();
    }

    @AfterMethod
    public void tearDown() {
        BrowserManager.closeBrowser();
    }
}
