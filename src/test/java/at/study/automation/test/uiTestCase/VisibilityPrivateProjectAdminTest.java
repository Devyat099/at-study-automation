package at.study.automation.test.uiTestCase;

import at.study.automation.model.projects.Project;
import at.study.automation.model.users.User;
import at.study.automation.property.Property;
import at.study.automation.ui.pages.HeaderPage;
import at.study.automation.ui.pages.LoginPage;
import at.study.automation.ui.pages.ProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisibilityPrivateProjectAdminTest {

    private User admin;
    private Project project;
    private WebDriver driver;
    private HeaderPage headerPage;
    private LoginPage loginPage;
    private ProjectPage projectPage;

    @BeforeMethod
    private void prepareFixtures() {
        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        project = new Project() {{
            setIsPublic(false);
        }}.create();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(Property.getStringProperty("url"));

        headerPage = new HeaderPage();
        loginPage = new LoginPage();
        projectPage = new ProjectPage();
    }

    @Test
    public void positiveVisibilityPrivetProjectTest() throws InterruptedException {
        headerPage.loginButton.click();

        Thread.sleep(1000);
        loginPage.login(admin);
        headerPage.projects.click();
        Assert.assertTrue(projectPage.checkProjectPage.isDisplayed());

        WebElement element = driver.findElement(By.xpath(
                String.format("//div[@id='projects-index']//a[@href='/projects/%s']", project.getIdentifier()))
        );

        element.click();

        driver.quit();
    }
}
