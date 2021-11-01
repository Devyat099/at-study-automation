package at.study.automation.ui.pages;

import at.study.automation.ui.browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends Page {

    public UserTablePage() {
        super();
    }

    public WebElement button (String text) {
        return BrowserManager.getBrowser().getDriver().findElement(
                By.xpath("//table[@class='list users']/thead//th[.='" + text + "']"));
    }

    @FindBy(xpath = "//table[@class='list users']/tbody//td[@class='created_on']")
    public List<WebElement> creationDates;
}
