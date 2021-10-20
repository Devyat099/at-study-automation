package at.study.automation.test.uiTestCase;

import at.study.automation.model.projects.Project;
import at.study.automation.model.users.User;
import at.study.automation.property.Property;
import at.study.automation.ui.HeaderPage;
import at.study.automation.ui.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisibilityPrivetProjectAdminTest {

    private User admin;
    private Project project;
    private WebDriver driver;
    private HeaderPage headerPage;
    private LoginPage loginPage;

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

        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void positiveVisibilityPrivetProjectTest() throws InterruptedException {
        // TODO добавить проверку на то, что находимся на странице Проектов
        headerPage.loginButton.click();

        Thread.sleep(1000);
        loginPage.login(admin);
        headerPage.projects.click();
        String description = project.getIdentifier();
        String fullPath = String.format("//div[@id='projects-index']//a[@href='/projects/%s']", description);
        WebElement el = driver.findElement(By.xpath(fullPath));
        el.click();
        Thread.sleep(10000);
    }
}
