package at.study.automation.ui.browser;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class BrowserUtils {
// TODO описание

    public static List<String> getElementsText(List<WebElement> elements) {
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
