package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.allure.AllureAssert;
import at.study.automation.model.users.Status;
import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.ui.browser.BrowserUtils.isElementDisplayed;

public class tk_2ActiveUserLoginTest extends BaseUITest {

    private User userActive;

    @BeforeMethod(description = "В системк заведен активный пользователь. Открыт браузер на главной странице")
    private void prepareFixtures() {
        userActive = new User() {{
            setIsAdmin(false);
            setStatus(Status.ACTIVE);
        }}.create();

        openBrowser();
    }

    @Test(description = "Авторизация подтвержденным пользователем")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Devyatkin Denis")
    public void positiveActiveUserLoginTest() {

        headerPage.loginButton.click();
        loginPage.login(userActive);

        AllureAssert.assertEquals(headerPage.myAccount.getText(),
                "Моя учётная запись",
                "отображение текста \"Моя учетная запись\"");

        AllureAssert.assertEquals(headerPage.whoEntered.getText(),
                "Вошли как " + userActive.getLogin(),
                "Вошли как " + userActive.getLogin());

        AllureAssert.assertEquals(headerPage.homePage.getText(),
                "Домашняя страница",
                "отображение текста \"Домашняя страница\"");

        AllureAssert.assertEquals(headerPage.myPage.getText(),
                "Моя страница",
                "отображение текста \"Моя страница\"");

        AllureAssert.assertEquals(headerPage.projects.getText(),
                "Проекты",
                "отображение текста \"Проекты\"");

        AllureAssert.assertEquals(headerPage.help.getText(),
                "Помощь",
                "отображение текста \"Помощь\"");

        AllureAssert.assertEquals(headerPage.logout.getText(),
                "Выйти",
                "отображение текста \"Выйти\"");

        AllureAssert.assertFalse(isElementDisplayed(headerPage.administration),
                "не отображается элемент Администрирование");

        AllureAssert.assertFalse(isElementDisplayed(headerPage.loginButton),
                "не отображается элемент Логин");

        AllureAssert.assertFalse(isElementDisplayed(headerPage.registerButton),
                "не отображается элемент Зарегистрироваться");

        AllureAssert.assertTrue(headerPage.search.isDisplayed(),
                "отображается элемент " + headerPage.search.getText());

    }
}


