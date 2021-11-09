package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.model.projects.Project;
import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import at.study.automation.ui.pages.ProjectPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.ui.browser.BrowserUtils.isProjectDisplayed;

public class tk_4VisibilityPrivateProjectAdminTest extends BaseUITest {

    private User admin;
    private Project project;
    private ProjectPage projectPage;

    @BeforeMethod
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

    @Test
    public void positiveVisibilityPrivetProjectTest() {

        headerPage.loginButton.click();
        loginPage.login(admin);
        headerPage.projects.click();
        Assert.assertTrue(projectPage.checkProjectPage.isDisplayed());

        Assert.assertTrue(isProjectDisplayed(project.getIdentifier()));
    }
}
