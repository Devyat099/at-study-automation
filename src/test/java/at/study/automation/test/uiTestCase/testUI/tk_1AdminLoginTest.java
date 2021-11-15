package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.allure.AllureAssert;
import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.ui.browser.BrowserUtils.isElementDisplayed;

public class tk_1AdminLoginTest extends BaseUITest {

    private User admin;

    @BeforeMethod(description = "В системе заведен пользователь с правами Админа. Открыт браузер на главной странице")
    private void prepareFixtures() {
        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser("login");
    }

    @Test(description = "Вход админом. Проверка отображения элементов")
    @Severity(SeverityLevel.MINOR)
    @Owner("Devyatkin Denis")
    public void positiveAdminLoginTest() {

        loginPage.login(admin);

        // Наличие/отсутствие элементов на странице
        AllureAssert.assertEquals(headerPage.myAccount.getText(),
                "Моя учётная запись",
                "отображение текста \"Моя учётная запись\"");
        AllureAssert.assertEquals(headerPage.whoEntered.getText(),
                "Вошли как " + admin.getLogin(),
                "отображение текста Вошли как " + admin.getLogin());
        AllureAssert.assertEquals(headerPage.homePage.getText(),
                "Домашняя страница",
                "отображение текста \"Домашняя страница\"");
        AllureAssert.assertEquals(headerPage.myPage.getText(),
                "Моя страница",
                "отображение текста \"Моя страница\"");
        AllureAssert.assertEquals(headerPage.projects.getText(),
                "Проекты",
                "отображение текста \"Проекты\"");
        AllureAssert.assertEquals(headerPage.administration.getText(),
                "Администрирование",
                "отображение текста \"Администрирование\"");
        AllureAssert.assertEquals(headerPage.help.getText(),
                "Помощь",
                "отображение текста \"Помощь\"");
        AllureAssert.assertEquals(headerPage.logout.getText(),
                "Выйти",
                "отображение текста \"Выйти\"");
        AllureAssert.assertFalse(isElementDisplayed(headerPage.loginButton),
                "кнопка \"Логин\" не отображается");
        AllureAssert.assertFalse(isElementDisplayed(headerPage.registerButton),
                "кнопка \"Зарегистрироваться\" не отображается");
        AllureAssert.assertTrue(headerPage.search.isDisplayed(),
                "\"Поиск\" есть на странице");
    }
}
