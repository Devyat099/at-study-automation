package at.study.automation.ui.pages;

import at.study.automation.model.users.User;
import at.study.automation.ui.browser.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='content']//div[@class='flash error']")
    public WebElement errorlogin;

    public LoginPage() {
        PageFactory.initElements(BrowserManager.getBrowser().getDriver(), this);
    }

    /**
     * Авторизация. ввод логина и пароля для входа в систему
     * @param login - логин пользователя
     * @param password - пароль для пользователя
     */
    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void login(User user) {
        login(user.getLogin(), user.getPassword());
    }
}
