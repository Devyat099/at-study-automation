package at.study.automation.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends Page {

    public UsersPage() {
        super();
    }

    @FindBy(xpath = "//h2[text()='Пользователи']")
    public WebElement isUsersPage;

    @FindBy(xpath = "//a[@class='sort asc icon icon-sorted-desc' and contains(text(),'Пользователь')]")
    public WebElement sortUserListByLogin;

    @FindBy(xpath = "//a[@class='sort asc icon icon-sorted-desc' and contains(text(),'Пользователь')]")
    public WebElement sortUserListByLoginDesc;

    @FindBy(xpath = "//a[@class='sort desc icon icon-sorted-asc' and contains(text(),'Пользователь')]")
    public WebElement sortUserListByLoginAsc;

    @FindBy(xpath = "//div[@class='contextual']/a[@href='/users/new']")
    public WebElement newUser;
}
