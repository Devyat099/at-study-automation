package at.study.automation.allure;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AllureAssert {

    @Step("Проверяем {2}")
    public static void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    @Step("Проверяем соответствие:")
    public static void assertEquals(Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
    }

    @Step("Проверяем, что {1}")
    public static void assertFalse(Boolean actual, String message) {
        Assert.assertFalse(actual);
    }

    @Step("Проверяем, что {1}")
    public static void assertTrue(Boolean actual, String message) {
        Assert.assertTrue(actual);
    }

    @Step("Клик по \"{1}\"")
    public static void click(WebElement obj, String message) {
        obj.click();
    }

    @Step("Заполняем данными поле \"{2}\"")
    public static void sendKeys(WebElement obj, String send, String message) {
        obj.sendKeys(send);
    }
}
