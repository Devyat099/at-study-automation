package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.allure.AllureAssert;
import at.study.automation.model.projects.Project;
import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import at.study.automation.ui.pages.ProjectPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.ui.browser.BrowserUtils.isProjectDisplayed;

public class tk_4VisibilityPrivateProjectAdminTest extends BaseUITest {

    private User admin;
    private Project project;
    private ProjectPage projectPage;

    @BeforeMethod(description = "В системе заведен админ и есть приватный проект")
    private void prepareFixtures() {

        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        project = new Project() {{
            setIsPublic(false);
        }}.create();

        openBrowser();
        projectPage = new ProjectPage();
    }

    @Test(description = "Видимость приватных проектов для администратора")
    @Severity(SeverityLevel.MINOR)
    @Owner("Devyatkin Denis")
    public void positiveVisibilityPrivetProjectTest() {

        headerPage.loginButton.click();
        loginPage.login(admin);
        headerPage.projects.click();
        AllureAssert.assertTrue(projectPage.checkProjectPage.isDisplayed(),
                "находимся на странице \"Проекты\"");

        AllureAssert.assertTrue(isProjectDisplayed(project.getIdentifier()),
                "приватный проект отображается для админа");
    }
}
