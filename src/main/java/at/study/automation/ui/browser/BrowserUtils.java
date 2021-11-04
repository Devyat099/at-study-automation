package at.study.automation.ui.browser;

import at.study.automation.property.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BrowserUtils {

    /**
     * преобразуем список полученных веб элементов в список строк.
     * @return полученный список строк.
     */
    public static List<String> getElementsText(List<WebElement> elements) {
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /**
     *  проверяем отображается ли веб элемент на странице в течении 1 секунды неявного ожидания
     * @return T = элемент найден, F = элемент не найден
     */
    public static boolean isElementDisplayed(WebElement element) {
        try {
            BrowserManager.getBrowser().getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            BrowserManager.getBrowser().getDriver().manage().timeouts().implicitlyWait(Property.getIntegerProperty("element.timeout"), TimeUnit.SECONDS);
        }
    }

    public static boolean isProjectDisplayed(String identifierProject) {
        try {
            BrowserManager.getBrowser().getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            return (BrowserManager.getBrowser().getDriver().findElement(By.xpath(
                    String.format("//div[@id='projects-index']//a[@href='/projects/%s']", identifierProject)))).isDisplayed();
        }
        catch (NoSuchElementException noSuchElementException) {
            return false;
        }
        finally {
            BrowserManager.getBrowser().getDriver().manage().timeouts().implicitlyWait(Property.getIntegerProperty("element.timeout"), TimeUnit.SECONDS);
        }
    }

}
