package at.study.automation.test.uiTestCase;

import at.study.automation.model.users.User;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.ui.browser.BrowserUtils.isElementDisplayed;

public class AdminLoginTestRefactor extends BaseUITest {

    private User admin;


    @BeforeMethod(description = "В системе заведен пользователь с правами Админа. Открыт браузер на главной странице")
    private void prepareFixtures() {
        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser("login");
    }

    @Test(description = "Вход админом. Проверка отображения элементов")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Devyatkin Denis")
    public void positiveAdminLoginTest() {

        loginPage.login(admin);

        // Наличие/отсутствие элементов на странице
        Assert.assertEquals(headerPage.myAccount.getText(), "Моя учётная запись");
        Assert.assertEquals(headerPage.whoEntered.getText(), "Вошли как " + admin.getLogin());
        Assert.assertEquals(headerPage.homePage.getText(), "Домашняя страница");
        Assert.assertEquals(headerPage.myPage.getText(), "Моя страница");
        Assert.assertEquals(headerPage.projects.getText(), "Проекты");
        Assert.assertEquals(headerPage.administration.getText(), "Администрирование");
        Assert.assertEquals(headerPage.help.getText(), "Помощь");
        Assert.assertEquals(headerPage.logout.getText(), "Выйти");
        Assert.assertFalse(isElementDisplayed(headerPage.loginButton));
        Assert.assertFalse(isElementDisplayed(headerPage.registerButton));
        Assert.assertTrue(headerPage.search.isDisplayed());
    }
}
