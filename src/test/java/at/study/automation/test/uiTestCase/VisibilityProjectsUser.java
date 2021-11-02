package at.study.automation.test.uiTestCase;

import at.study.automation.model.projects.Project;
import at.study.automation.model.roles.Permissions;
import at.study.automation.model.roles.Role;
import at.study.automation.model.users.User;
import at.study.automation.ui.browser.BrowserManager;
import at.study.automation.ui.pages.ProjectPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

public class VisibilityProjectsUser extends BaseUITest {

    private User user;
    private Project publicProject;
    private Project privateProject1;
    private Project privateProject2;
    private ProjectPage projectPage;

    @BeforeMethod
    public void prepareFixtures(){

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
        //user.addProject(privateProject2, Collections.singletonList(role));


        openBrowser();


        projectPage = new ProjectPage();
    }

    @Test
    public void VisibilityProjectTest() throws InterruptedException {
        headerPage.loginButton.click();

        loginPage.login(user);

        Assert.assertTrue(headerPage.isHomePage.isDisplayed());
        Assert.assertEquals(headerPage.isHomePage.getText(), "Домашняя страница");

        headerPage.projects.click();



        Assert.assertTrue(ProjectPage.isValidationMsg(BrowserManager.getBrowser().getDriver().findElement(By.xpath(

                String.format("//div[@id='projects-index']//a[@href='/projects/%s']", publicProject.getIdentifier())))));
//
//
//        // TODO ЧТОБЫ ТЕСТ НЕ ПАДАЛ ПРИ НЕ НАХОЖДЕНИИ
//
        Assert.assertTrue(ProjectPage.isValidationMsg((BrowserManager.getBrowser().getDriver().findElement(By.xpath(
                String.format("//div[@id='projects-index']//a[@href='/projects/%s']", privateProject1.getIdentifier()))))));
//
//
//        Assert.assertTrue(ProjectPage.isValidationMsg(driver.findElement(By.xpath(
//                String.format("//div[@id='projects-index']//a[@href='/projects/%s']", privateProject2.getIdentifier())))));

    }


}
