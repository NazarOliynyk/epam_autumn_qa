import businessObjects.LocationPageBO;
import businessObjects.LoginationBO;
import enums.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocationPageTest extends BaseTest{

    @Test(description = "Verify proper search in 'Locations' section")
    public void verifyLocationsSection(){


        LoginationBO loginationBO = new LoginationBO();

        LocationPageBO newsPageBO = new LocationPageBO();

        loginationBO.goToPageURL(URLs.MAIN_URL.getValue());

        loginationBO.logIn("ivanhorintest@gmail.com", "ivanhorintestPassword");

        newsPageBO.getLocationSearchResult()
                .forEach(element -> Assert.assertTrue((element.getText().contains("Lviv")),
                        String.format("Element %s does not contain 'Lviv' word.", element)));

    }
}
