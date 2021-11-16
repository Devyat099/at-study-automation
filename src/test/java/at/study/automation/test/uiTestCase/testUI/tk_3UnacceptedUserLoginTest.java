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


public class tk_3UnacceptedUserLoginTest extends BaseUITest {

    private User userUnaccepted;

    @BeforeMethod(description = "В системе заведен неподтвержденный пользователь")
    private void prepareFixtures() {

        userUnaccepted = new User() {{
            setIsAdmin(false);
            setStatus(Status.UNACCEPTED);
        }}.create();

        openBrowser();
    }

    @Test(description = "Вход неподтвержденным пользователем")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Devyatkin Denis")
    public void positiveUnacceptedUserLoginTest() {

        headerPage.loginButton.click();
        loginPage.login(userUnaccepted);

        AllureAssert.assertEquals(loginPage.errorlogin.getText(),
                "Ваша учётная запись создана и ожидает подтверждения администратора.",
                "что отображается " + "\"" + loginPage.errorlogin.getText() + "\"");

        AllureAssert.assertFalse(isElementDisplayed(headerPage.myPage),
                "не отображается \"Моя страница\"");
        AllureAssert.assertTrue(headerPage.loginButton.isDisplayed(),
                "отображается " + headerPage.loginButton.getText());
        AllureAssert.assertTrue(headerPage.registerButton.isDisplayed(),
                "отображается " + headerPage.registerButton.getText());

    }
}
