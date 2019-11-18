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

    public static WebElement getElementWithLoop(By locator) {

        WebElement webElement = null;
        int i = 1;
        while (i<10){
            try{
                webElement =
                        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                i= 10;
            }catch (Exception e){
                i++;
            }
        }
        return webElement;
    }

    public static void executeElementWithTimeout(By locator) {

        try {
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<WebElement> getElements(By locator) {

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
