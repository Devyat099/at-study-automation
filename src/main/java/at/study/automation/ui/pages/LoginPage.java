package at.study.automation.ui.pages;

import at.study.automation.model.users.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        super();
    }

    /**
     * Авторизация. ввод логина и пароля для входа в систему
     * @param login - логин пользователя
     * @param password - пароль для пользователя
     */
    @Step("Вход пользователя {0} с паролем {1}")
    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();
    }


    public void login(User user) {
        login(user.getLogin(), user.getPassword());
    }
}
