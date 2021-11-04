package at.study.automation.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUserPage extends Page {

    public NewUserPage(){
        super();
    }

    @FindBy(xpath = "//div[@class='splitcontentleft']//input[@id='user_login']")
    public WebElement userLogin;

    @FindBy(xpath = "//div[@class='splitcontentleft']//input[@id='user_firstname']")
    public WebElement userFirstname;

    @FindBy(xpath = "//div[@class='splitcontentleft']//input[@id='user_lastname']")
    public WebElement userLastname;

    @FindBy(xpath = "//div[@class='splitcontentleft']//input[@id='user_mail']")
    public WebElement userMail;

    @FindBy(xpath = "//div[@id='password_fields']//input[@id='user_generate_password']")
    public WebElement userCreatePassword;

    @FindBy(xpath = "//p/input[@value='Создать']")
    public WebElement userCreate;

    @FindBy(xpath = "//div[@class='flash notice']/a")
    public WebElement getNameCreateUser;
}
