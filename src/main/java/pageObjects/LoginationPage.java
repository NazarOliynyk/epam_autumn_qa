package pageObjects;

import org.openqa.selenium.By;

public class LoginationPage extends AbstractPage{

    private By signInForm = By.xpath("//p[@class='header-auth__signin']//span");

    private By mailInput = By.id("signInEmail");

    private By passwordInput = By.id("signInPassword");

    private By signInButton = By.className("popup-reg-sign-in-form__sign-in");

    public By errorMessage = By.cssSelector("div.popup__error-message.ng-binding");

    public By userCredentials = By.xpath("//div[@class='user-info__name']");

    public void openSignInForm(){
        getElementWithLoop(signInForm).click();
    }

    public void inputMail(String email){
        getElement(mailInput).sendKeys(email);
    }

    public void inputPassword(String password){
        getElement(passwordInput).sendKeys(password);
    }

    public void signIn(){
        getElement(signInButton).click();
    }

}