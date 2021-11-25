package steps;

import at.study.automation.ui.browser.BrowserManager;
import cucumber.api.java.After;
import cucumber.api.java.ru.Дано;

public class BrowserSteps {

    @Дано("открыт браузер на странице \"(.+)\"")
    public void openBrowserOnPage(String url) {
        BrowserManager.getBrowser(url);
    }

    @Дано("открыт браузер на главной странице")
    public void openBrowserOnMainPage() {
        BrowserManager.getBrowser();
    }

    @After
    public void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}
