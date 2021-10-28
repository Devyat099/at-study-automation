package at.study.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends Page {

    public UsersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Пользователи']")
    public WebElement isUsersPage;

    @FindBy(xpath = "//a[@class='sort asc icon icon-sorted-desc' and contains(text(),'Пользователь')]")
    public WebElement sortUserListByLogin;

    @FindBy(xpath = "//a[@class='sort asc icon icon-sorted-desc' and contains(text(),'Пользователь')]")
    public WebElement sortUserListByLoginDesc;

    @FindBy(xpath = "//a[@class='sort desc icon icon-sorted-asc' and contains(text(),'Пользователь')]")
    public WebElement sortUserListByLoginAsc;
}
