package at.study.automation.test.uiTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumSampleTest {

    @Test
    public void seleniumTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Котики");
        Thread.sleep(5000);
        element.clear();
        element.submit();

        driver.quit();
    }


}
