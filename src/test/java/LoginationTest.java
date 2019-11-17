import businessObjects.LoginationBO;
import enums.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginationTest extends BaseTest{

    @Test(description = "Verify logination and appearance of user credentials on the page")
    public void verifyLogination(){


        LoginationBO loginationBO = new LoginationBO();

        loginationBO.goToPageURL(URLs.HOME_PAGE_URL.getValue());

        loginationBO.logIn("ivanhorintest@gmail.com", "ivanhorintestPassword");

        Assert.assertTrue(
                loginationBO.isUserCredentialsDisplayed(), "User credentials are NOT displayed.  ");

        Assert.assertEquals(
                "ivanhorintest", loginationBO.getUserCredentials().getText(), "Actual user credentials are not equal to expected.  ");
    }

}
