package utils;

import org.openqa.selenium.WebElement;

public class WebDriverUtils {

    // Click on a WebElement
    public static void clickElement(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        } else {
            throw new RuntimeException("Element is not clickable: " + element);
        }
    }

    // Send keys to a WebElement
    public static void sendKeysToElement(WebElement element, String text) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.clear(); // Clear existing text if any
            element.sendKeys(text);
        } else {
            throw new RuntimeException("Element is not interactable: " + element);
        }
    }

    // Check if a WebElement is visible
    public static boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

}
