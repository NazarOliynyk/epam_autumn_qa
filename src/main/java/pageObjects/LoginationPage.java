package pageObjects;

import org.openqa.selenium.By;

public class LoginationPage extends AbstractPage{

    public By signInForm = By.xpath("//p[@class='header-auth__signin']//span");

    public By mailInput = By.id("signInEmail");

    public By passwordInput = By.id("signInPassword");

    public By signInButton = By.className("popup-reg-sign-in-form__sign-in");

    public By errorMessage = By.cssSelector("div.popup__error-message.ng-binding");

    public By userCredentials = By.xpath("//div[@class='user-info__name']");

}
