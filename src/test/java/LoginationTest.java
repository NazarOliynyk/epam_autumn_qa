import enums.MainEnums;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginationPage;

public class LoginationTest extends BaseTest{


    @Test(description = "Verify logination and appearance of user credentials on the page")
    public void verifyLogination(){


        LoginationPage loginationPage = new LoginationPage();
        loginationPage.goToPageURL(MainEnums.HOME_PAGE_URL.getValue());

        loginationPage.logIn("ivanhorintest@gmail.com", "ivanhorintestPassword");

        Assert.assertEquals("ivanhorintest", loginationPage.userCredentials().getText());
    }

}
