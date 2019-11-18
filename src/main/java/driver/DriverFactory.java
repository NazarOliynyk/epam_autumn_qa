package driver;

import enums.DriverLocations;
import enums.Drivers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static void buildDriver(final String browserName){

        if(browserName.equalsIgnoreCase(Drivers.CHROME_DRIVER.getValue())){
            System.setProperty(Drivers.CHROME_DRIVER.getValue(),
                    DriverLocations.CHROME_DRIVER_LOCATION.getValue());
            driver=new ChromeDriver();
        }else if(browserName.equalsIgnoreCase(Drivers.FIREFOX_DRIVER.getValue())){
            System.setProperty(Drivers.FIREFOX_DRIVER.getValue(),
                    DriverLocations.FIREFOX_DRIVER_LOCATION.getValue());
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public static WebDriver getDriver() {

        return driver;
    }

    public static JavascriptExecutor getExecutor() {

        return (JavascriptExecutor)driver;
    }

    public static void quitDriver(){
        if(driver!= null){
            driver.quit();
            driver= null;
        }
    }

}