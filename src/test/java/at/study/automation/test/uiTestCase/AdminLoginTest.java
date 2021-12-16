package at.study.automation.test.uiTestCase;

import at.study.automation.model.users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminLoginTest {

    @Test
    public void positiveAdminLoginTest() throws InterruptedException {
        User user = new User() {{
            setIsAdmin(true);
        }}.create();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver1.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://edu-at.dfu.i-teco.ru/");

        WebElement loginButton = driver.findElement(By.id("account"))
                .findElement(By.className("login"));
        loginButton.click();


        WebElement loginInput = driver.findElement(By.xpath("//input[@id='username']"));
        loginInput.sendKeys(user.getLogin());

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys(user.getPassword());


        WebElement signButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        signButton.click();
        Thread.sleep(1000);

        WebElement myAccount = driver.findElement(By.xpath("//div[@id='account']//a[@class='my-account']"));
        Assert.assertEquals(myAccount.getText(), "Моя учётная запись");
        driver.quit();









    }
}
