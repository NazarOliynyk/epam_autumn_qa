import enums.MainEnums;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginationPage;

public class IncorrectUserCredentials extends BaseTest{

//    public IncorrectUserCredentials(String driverName, String url) {
//        super(MainEnums.CHROME_DRIVER.getValue(), MainEnums.HOME_PAGE_URL.getValue());
//    }

    @Test(description = "Verify logination with incorrect user credentials")
    public void verifyLoginationWithIncorrectCredentials(){

        LoginationPage loginationPage = new LoginationPage();

        loginationPage.logIn("ivanhorintest@gmail.com", "ivanhorintestWRONGPassword");

        Assert.assertEquals("Ошибка авторизации. Пожалуйста, попробуйте еще раз.",
                loginationPage.getResponse().getText());
    }
}
