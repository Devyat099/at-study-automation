package at.study.automation.ui;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage extends Page {

    public ProjectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//div[@class='contextual']")
    public WebElement checkProjectPage;


    public static Boolean isValidationMsg(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
