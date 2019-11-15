package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginationPage extends AbstractPage{

//    @Override
//    void goToPageURL(String url) {
//        super.goToPageURL(url);
//    }

    private By signInForm = By.xpath("//p[@class='header-auth__signin']//span");

    private By mailInput = By.id("signInEmail");

    private By passwordInput = By.id("signInPassword");

    private By signInButton = By.className("popup-reg-sign-in-form__sign-in");

    private By responseLogination = By.cssSelector("div.popup__error-message.ng-binding");

    //div[@class='user-info__name' and contains(text(),'ivanhorintest')
    private By userInfo = By.xpath("//div[@class='user-info__name']");

    public void logIn(String email, String password){
        getElement(signInForm).click();
        getElement(mailInput).sendKeys(email);
        getElement(passwordInput).sendKeys(password);
        getElement(signInButton).click();
    }

    public WebElement userCredentials(){
        return getElement(userInfo);
    }

    // rename to errormessage
    public WebElement getResponse(){
        return getElement(responseLogination);
    }
}
