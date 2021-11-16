package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.allure.AllureAssert;
import at.study.automation.db.request.UserRequests;
import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import at.study.automation.utils.StringUtils;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.utils.StringUtils.randomEmail;

public class tk_8CreateNewUserByAdmin extends BaseUITest {


    private User admin;

    @BeforeMethod(description = "Заведен администратор в системе")
    private void prepareFixtures() {

        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser();
    }

    @Test(description = "Создание нового пользователя администратором")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Devyatkin Denis")
    public void createUserByAdmin() {

        headerPage.loginButton.click();
        loginPage.login(admin);
        headerPage.administration.click();
        administrationPage.users.click();
        fillingInField();
        checkCreateUserDB();
    }

    @Step("Заполняем поля данными нового пользователя")
    private void fillingInField() {

        AllureAssert.click(usersPage.newUser, "Новый пользователь");

        AllureAssert.sendKeys(newUserPage.userLogin, StringUtils.randomEnglishString(5),"Новый пользователь");

        AllureAssert.sendKeys(newUserPage.userFirstname, StringUtils.randomEnglishString(3), "Имя");

        AllureAssert.sendKeys(newUserPage.userLastname, StringUtils.randomEnglishString(5), "Фамилия");

        AllureAssert.sendKeys(newUserPage.userMail, randomEmail(), "E-mail");

        AllureAssert.click(newUserPage.userCreatePassword, "Задать пароль для пользователя");

        AllureAssert.click(newUserPage.userCreate, "Создать пользователя");

    }

    @Step("Проверяем что пользователь создался в базе данных")
    private void checkCreateUserDB() {
        String userLogin = newUserPage.getNameCreateUser.getText();
        User us = new UserRequests().readUserByLogin(userLogin);
        AllureAssert.assertEquals(newUserPage.getNameCreateUser.getText(), us.getLogin(), "что пользователь создался в БД");
    }
}

