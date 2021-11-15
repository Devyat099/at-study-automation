package at.study.automation.allure;

import io.qameta.allure.Step;
import org.testng.Assert;

public class AllureAssert {

    @Step("Проверяем {2}")
    public static void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    @Step("Проверяем равенство:")
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

}
