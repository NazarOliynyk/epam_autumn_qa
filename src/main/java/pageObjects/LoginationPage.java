package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginationPage extends AbstractPage{

    public By signInForm = By.xpath("//p[@class='header-auth__signin']//span");

    public By mailInput = By.id("signInEmail");

    public By passwordInput = By.id("signInPassword");

    public By signInButton = By.className("popup-reg-sign-in-form__sign-in");

    public By errorMessage = By.cssSelector("div.popup__error-message.ng-binding");

    public By userCredentials = By.xpath("//div[@class='user-info__name']");



    // using @FindBy annotation-

//    @FindBy(xpath = "//p[@class='header-auth__signin']//span")
//    public WebElement signInForm;
//
//    @FindBy(id = "signInEmail")
//    public WebElement mailInput;
//
//    @FindBy(id = "signInPassword")
//    public WebElement passwordInput;
//
//    @FindBy(className = "popup-reg-sign-in-form__sign-in")
//    public WebElement signInButton;
//
//    @FindBy(css = "div.popup__error-message.ng-binding")
//    public WebElement errorMessage;
//
//    @FindBy(xpath = "//div[@class='user-info__name']")
//    public WebElement userCredentials;

}
