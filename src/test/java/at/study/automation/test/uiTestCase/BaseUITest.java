package at.study.automation.test.uiTestCase;

import at.study.automation.ui.browser.Browser;
import at.study.automation.ui.browser.BrowserManager;
import at.study.automation.ui.pages.*;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;

public class BaseUITest {

    protected Browser browser;
    protected HeaderPage headerPage;
    protected LoginPage loginPage;
    protected AdministrationPage administrationPage;
    protected UserTablePage userTablePage;
    protected UsersPage usersPage;
    protected NewUserPage newUserPage;

    @Step("Открыт браузер на главной странице")
    protected void openBrowser() {
        browser = BrowserManager.getBrowser();
        initPages();

    }
    @Step("Открыт браузер на странице /{0}")
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

    @AfterMethod(description = "Закрытие браузера")
    public void tearDown() {
        BrowserManager.closeBrowser();
    }
}
