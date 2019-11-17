import businessObjects.LoginationBO;
import enums.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncorrectUserCredentials extends BaseTest{

    @Test(description = "Verify logination with incorrect user credentials")
    public void verifyLoginationWithIncorrectCredentials(){

        LoginationBO loginationBO = new LoginationBO();

        loginationBO.goToPageURL(URLs.HOME_PAGE_URL.getValue());

        loginationBO.logIn("ivanhorintest@gmail.com", "WRONG__Password");

        Assert.assertTrue(
                loginationBO.isErrorMessageDisplayed(), "Error message is NOT displayed.  "  );

        Assert.assertEquals("Ошибка авторизации. Пожалуйста, попробуйте еще раз.",
                loginationBO.getErrorMessage().getText(), "Actual error message is not equal to expected.  ");
    }
}
