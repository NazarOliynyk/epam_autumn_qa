package businessObjects;


import org.openqa.selenium.WebElement;
import pageObjects.LocationsPage;
import java.util.List;
import static driver.DriverFactory.getExecutor;
import static pageObjects.AbstractPage.getElement;
import static pageObjects.AbstractPage.getElements;


public class LocationPageBO {

    private LocationsPage locationsPage = new LocationsPage();

    public List<WebElement> getLocationSearchResult(){

        getExecutor()
                .executeScript("arguments[0].click();",
                        getElement(locationsPage.trainingListButton));
        getExecutor().executeScript("window.scrollBy(0,1650)");
        getExecutor()
                .executeScript("arguments[0].click();",
                        getElement(locationsPage.searchTrainingArrow));
        getElement(locationsPage.countrySelect).click();
        getElement(locationsPage.citySelect).click();

        return getElements(locationsPage.lvivPositions);
    }
}
