package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.model.projects.Project;
import at.study.automation.model.roles.Permissions;
import at.study.automation.model.roles.Role;
import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import at.study.automation.ui.pages.ProjectPage;
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

    @BeforeMethod
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

    @Test
    public void VisibilityProjectTest() {

        headerPage.loginButton.click();
        loginPage.login(user);
        Assert.assertTrue(headerPage.isHomePage.isDisplayed());
        Assert.assertEquals(headerPage.isHomePage.getText(), "Домашняя страница");
        headerPage.projects.click();

        Assert.assertTrue(isProjectDisplayed(publicProject.getIdentifier()));
        Assert.assertFalse(isProjectDisplayed(privateProject1.getIdentifier()));
        Assert.assertFalse(isProjectDisplayed(privateProject2.getIdentifier()));
    }
}