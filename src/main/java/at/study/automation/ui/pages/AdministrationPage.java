package at.study.automation.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdministrationPage extends Page {

    public AdministrationPage() {
        super();
    }


    @FindBy(xpath = "//div[@id='admin-menu']//a[@class='icon icon-user users']")
    public WebElement users;

}
