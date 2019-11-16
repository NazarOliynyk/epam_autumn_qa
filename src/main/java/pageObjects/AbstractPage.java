package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

public abstract class AbstractPage {

     private static FluentWait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver())
            .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

    public void goToPageURL(final String url) {

        DriverFactory.getDriver().get(url);
    }

    public static WebElement getElement(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    List<WebElement> getElements(By locator) {

        return DriverFactory.getDriver().findElements(locator);
    }

    public static boolean isDisplayed(By locator) {
        try {
            return DriverFactory
                    .getDriver()
                    .findElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}