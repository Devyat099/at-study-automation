package at.study.automation.test.uiTestCase;

import at.study.automation.ui.browser.Browser;
import at.study.automation.ui.browser.BrowserManager;
import at.study.automation.ui.pages.HeaderPage;
import at.study.automation.ui.pages.LoginPage;
import org.testng.annotations.AfterMethod;

public class BaseUITest {

    protected Browser browser;
    protected HeaderPage headerPage;
    protected LoginPage loginPage;

    protected void openBrowser() {
        browser = BrowserManager.getBrowser();
        headerPage = new HeaderPage();
        loginPage = new LoginPage();


    }

    protected void openBrowser(String uri) {
        browser = BrowserManager.getBrowser(uri);
        headerPage = new HeaderPage();
        loginPage = new LoginPage();

    }

    @AfterMethod
    public void tearDown() {
        BrowserManager.closeBrowser();
    }
}
