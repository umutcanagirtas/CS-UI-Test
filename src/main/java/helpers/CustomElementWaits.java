package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomElementWaits {
    public static void waitUntilElementFind(WebDriver driver, WebElement element) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementToClickable(WebDriver driver, WebElement element) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void visibilityOfAllElements(WebDriver driver, List<WebElement> elements) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}