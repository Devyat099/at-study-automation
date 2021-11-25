package at.study.automation.ui.browser;

import at.study.automation.property.Property;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Getter
public class Browser {

    private WebDriver driver;
    private WebDriverWait wait;


    Browser() {
        this("");
    }

    Browser(String uri) {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        int timeout = Property.getIntegerProperty("element.timeout");
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, timeout);
        get(uri);
    }

    public void get(String uri){
        getDriver().get(Property.getStringProperty("url") + uri);
    }

    public void refresh() {
        getDriver().navigate().refresh();
    }
}
