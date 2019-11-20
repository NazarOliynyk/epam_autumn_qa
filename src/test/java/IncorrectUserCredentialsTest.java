import businessObjects.LoginationBO;
import enums.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;

import static sources.PropertyFileHandler.getEmail;

public class IncorrectUserCredentialsTest extends BaseTest{

    @Test(description = "Verify logination with incorrect user credentials")
    public void verifyLoginationWithIncorrectCredentials(){

        LoginationBO loginationBO = new LoginationBO();

        loginationBO.goToPageURL(URLs.HOME_PAGE_URL.getValue());

        loginationBO.logIn(getEmail(), "WRONG__Password");

//        Assert.assertTrue(
//                loginationBO.isErrorMessageDisplayed(), "Error message is NOT displayed.  "  );

        Assert.assertEquals(loginationBO.getErrorMessage().getText(),
                "Ошибка авторизации. Пожалуйста, попробуйте еще раз.",
                 "Actual error message is not equal to expected.  ");
    }
}
