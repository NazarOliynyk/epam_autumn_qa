package businessObjects;

import org.openqa.selenium.WebElement;
import pageObjects.LoginationPage;

import static pageObjects.AbstractPage.getElement;
import static pageObjects.AbstractPage.isDisplayed;

public class LoginationBO {

    private LoginationPage loginationPage = new LoginationPage();

    public void goToPageURL(String url){
        loginationPage.goToPageURL(url);
    }


    public void logIn(String email, String password){

        getElement(loginationPage.signInForm).click();
        getElement(loginationPage.mailInput).sendKeys(email);
        getElement(loginationPage.passwordInput).sendKeys(password);
        getElement(loginationPage.signInButton).click();
    }

    public boolean isUserCredentialsDisplayed(){

        return isDisplayed(loginationPage.userCredentials);
    }

    public boolean isErrorMessageDisplayed(){

        return isDisplayed(loginationPage.errorMessage);
    }

    public WebElement getUserCredentials(){

        return getElement(loginationPage.userCredentials);
    }

    public WebElement getErrorMessage(){

        return getElement(loginationPage.errorMessage);
    }

// using @FindBy annotation-

//    public void logIn(String email, String password){
//        loginationPage.click();
//        loginationPage.mailInput.sendKeys(email);
//        loginationPage.passwordInput.sendKeys(password);
//        loginationPage.signInButton.click();
//    }

}
