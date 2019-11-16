
import driver.DriverFactory;
import enums.Drivers;
import org.testng.annotations.*;
import java.lang.reflect.Method;

public abstract class BaseTest  {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        DriverFactory.buildDriver(Drivers.CHROME_DRIVER.getValue());

    }


    @AfterMethod(alwaysRun = true)
    public  void afterMethod(final Method method){

        DriverFactory.quitDriver();
    }
}