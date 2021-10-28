package at.study.automation.ui.pages;

import at.study.automation.ui.browser.BrowserManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage extends Page {

    public ProjectPage() {
        PageFactory.initElements(BrowserManager.getBrowser().getDriver(), this);
    }



    @FindBy(xpath = "//div[@class='contextual']")
    public WebElement checkProjectPage;


    public static Boolean isValidationMsg(WebElement webElement) {


        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
