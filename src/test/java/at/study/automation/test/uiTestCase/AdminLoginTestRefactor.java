package at.study.automation.test.uiTestCase;

import at.study.automation.model.users.User;
import at.study.automation.ui.browser.Browser;
import at.study.automation.ui.browser.BrowserManager;
import at.study.automation.ui.pages.HeaderPage;
import at.study.automation.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminLoginTestRefactor {

    private User admin;
    private Browser browser;
    private HeaderPage headerPage;
    private LoginPage loginPage;


    @BeforeMethod
    private void prepareFixtures() {
        admin = new User() {{
            setIsAdmin(true);
        }}.create();


        browser = BrowserManager.getBrowser();
//        driver = DriverFactory.getDriver();
//        driver.manage().timeouts().implicitlyWait(5, SECONDS);
//        driver.get(Property.getStringProperty("url"));

        headerPage = new HeaderPage();
        loginPage = new LoginPage();
    }

    @Test
    public void positiveAdminLoginTest() {

        headerPage.loginButton.click();

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
        //Assert.assertTrue(headerPage.isValidationMsgNotExist(headerPage.loginButton));
        //Assert.assertTrue(headerPage.isValidationMsgNotExist(headerPage.registerButton));
        Assert.assertTrue(headerPage.search.isDisplayed());

        browser.getDriver().quit();


    }
}
