import businessObjects.LocationPageBO;
import businessObjects.LoginationBO;
import enums.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;

import static sources.PropertyFileHandler.getEmail;
import static sources.PropertyFileHandler.getPassword;

public class LocationPageTest extends BaseTest{

    @Test(description = "Verify proper search in 'Locations' section")
    public void verifyLocationsSection(){


        LoginationBO loginationBO = new LoginationBO();

        LocationPageBO locationPageBO = new LocationPageBO();

        loginationBO.goToPageURL(URLs.MAIN_URL.getValue());

        loginationBO.logIn(getEmail(), getPassword());

        locationPageBO.getLocationSearchResult()
                .forEach(element -> Assert.assertTrue((element.getText().contains("Lviv")),
                        String.format("Element %s does not contain 'Lviv' word.", element)));

    }
}
