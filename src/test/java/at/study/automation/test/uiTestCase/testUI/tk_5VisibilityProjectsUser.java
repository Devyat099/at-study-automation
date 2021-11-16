package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.allure.AllureAssert;
import at.study.automation.model.projects.Project;
import at.study.automation.model.roles.Permissions;
import at.study.automation.model.roles.Role;
import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import at.study.automation.ui.pages.ProjectPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

import static at.study.automation.ui.browser.BrowserUtils.isProjectDisplayed;

public class tk_5VisibilityProjectsUser extends BaseUITest {

    private User user;
    private Project publicProject;
    private Project privateProject1;
    private Project privateProject2;
    private ProjectPage projectPage;

    @BeforeMethod(description = "Заведен админ. Заведены проекты в системе")
    public void prepareFixtures() {

        publicProject = new Project() {{
            setIsPublic(true);
        }}.create();

        privateProject1 = new Project() {{
            setIsPublic(false);
        }}.create();

        privateProject2 = new Project() {{
            setIsPublic(false);
        }}.create();

        Role role = new Role() {{
            setPermissions(Collections.singletonList(Permissions.VIEW_ISSUES));
        }}.create();

        user = new User().create();
        user.setIsAdmin(true);
        user.addProject(privateProject2, Collections.singletonList(role));

        openBrowser();

        projectPage = new ProjectPage();
    }

    @Test(description = "Видимость проектов для пользователя")
    @Severity(SeverityLevel.MINOR)
    @Owner("Devyatkin Denis")
    public void VisibilityProjectTest() {

        headerPage.loginButton.click();
        loginPage.login(user);
        Assert.assertTrue(headerPage.isHomePage.isDisplayed());
        AllureAssert.assertEquals(headerPage.isHomePage.getText(), "Домашняя страница");
        headerPage.projects.click();

        AllureAssert.assertTrue(isProjectDisplayed(publicProject.getIdentifier()),
                "отображается публичный проект");
        AllureAssert.assertFalse(isProjectDisplayed(privateProject1.getIdentifier()),
                "не отображается приватный проект");
        AllureAssert.assertFalse(isProjectDisplayed(privateProject2.getIdentifier()),
                "не отображается приватный проект");
    }
}