import enums.MainEnums;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginationPage;

public class IncorrectUserCredentials extends BaseTest{

    @Test(description = "Verify logination with incorrect user credentials")
    public void verifyLoginationWithIncorrectCredentials(){

        LoginationPage loginationPage = new LoginationPage();
        loginationPage.goToPageURL(MainEnums.HOME_PAGE_URL.getValue());

        loginationPage.logIn("ivanhorintest@gmail.com", "ivanhorintestWRONGPassword");

        Assert.assertEquals("Ошибка авторизации. Пожалуйста, попробуйте еще раз.",
                loginationPage.getResponse().getText());
    }
}
