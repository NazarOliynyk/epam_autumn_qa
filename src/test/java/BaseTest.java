
import driver.DriverFactory;
import enums.MainEnums;
import org.testng.annotations.*;
import java.lang.reflect.Method;

public abstract class BaseTest  {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        DriverFactory.buildDriver(MainEnums.CHROME_DRIVER.getValue());

    }


    @AfterMethod(alwaysRun = true)
    public  void afterMethod(final Method method){

        DriverFactory.quitDriver();
    }
}