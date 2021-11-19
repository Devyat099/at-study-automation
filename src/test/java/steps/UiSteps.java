package steps;

import at.study.automation.allure.AllureAssert;
import at.study.automation.context.Context;
import at.study.automation.model.users.User;
import at.study.automation.ui.pages.HeaderPage;
import at.study.automation.ui.pages.LoginPage;
import cucumber.api.java.ru.Дано;


public class UiSteps {

    @Дано("Авторизоватся как пользователь \"(.+)\"")
    public void authByUser(String userStashId) {
        User user = Context.getStash().get(userStashId, User.class);
        LoginPage.getPage(LoginPage.class).login(user);
    }

    @Дано("Авторизоватся по логину \"(.+)\" и паролю \"(.+)\"")
    public void authByLoginAndPassword(String login, String password) {
        LoginPage.getPage(LoginPage.class).login(login, password);
    }

    @Дано("Текст элемента Моя учетная запись - \"(.*)\"")
    public void assertMyAccountText(String expectedText) {
        AllureAssert.assertEquals(HeaderPage.getPage(HeaderPage.class).myAccount.getText(), expectedText);
    }

}
