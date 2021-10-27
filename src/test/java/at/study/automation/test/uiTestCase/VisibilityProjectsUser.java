package at.study.automation.test.uiTestCase;

import at.study.automation.model.projects.Project;
import at.study.automation.model.roles.Permissions;
import at.study.automation.model.roles.Role;
import at.study.automation.model.users.User;
import at.study.automation.property.Property;
import at.study.automation.ui.pages.HeaderPage;
import at.study.automation.ui.pages.LoginPage;
import at.study.automation.ui.pages.ProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

public class VisibilityProjectsUser {

    private User user;
    private Project publicProject;
    private Project privateProject1;
    private Project privateProject2;
    private WebDriver driver;
    private HeaderPage headerPage;
    private LoginPage loginPage;
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
        user.addProject(privateProject2, Collections.singletonList(role));


        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(Property.getStringProperty("url"));

        headerPage = new HeaderPage();
        loginPage = new LoginPage();
        projectPage = new ProjectPage();
    }

    @Test
    public void VisibilityProjectTest() {
        headerPage.loginButton.click();
        loginPage.login(user);

        Assert.assertTrue(headerPage.isHomePage.isDisplayed());
        Assert.assertEquals(headerPage.isHomePage.getText(), "Домашняя страница");

        headerPage.projects.click();


        Assert.assertFalse(ProjectPage.isValidationMsg(driver.findElement(By.xpath(
                String.format("//div[@id='projects-index']//a[@href='/projects/%s']", publicProject.getIdentifier())))));



        Assert.assertTrue(ProjectPage.isValidationMsg((driver.findElement(By.xpath(
                String.format("//div[@id='projects-index']//a[@href='/projects/%s']", privateProject1.getIdentifier()))))));


        Assert.assertTrue(ProjectPage.isValidationMsg(driver.findElement(By.xpath(
                String.format("//div[@id='projects-index']//a[@href='/projects/%s']", privateProject2.getIdentifier())))));

    }


}
