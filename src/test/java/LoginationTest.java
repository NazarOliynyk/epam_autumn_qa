import businessObjects.LoginationBO;
import enums.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;

import static sources.PropertyFileHandler.getEmail;
import static sources.PropertyFileHandler.getLogin;
import static sources.PropertyFileHandler.getPassword;

public class LoginationTest extends BaseTest{

    @Test(description = "Verify logination and appearance of user credentials on the page")
    public void verifyLogination(){


        LoginationBO loginationBO = new LoginationBO();

        loginationBO.goToPageURL(URLs.HOME_PAGE_URL.getValue());

        loginationBO.logIn(getEmail(), getPassword());

        Assert.assertTrue(
                loginationBO.isUserCredentialsDisplayed(), "User credentials are NOT displayed.  ");

        Assert.assertEquals(
                loginationBO.getUserCredentials().getText(),getLogin(),  "Actual user credentials are not equal to expected.  ");
    }

}
