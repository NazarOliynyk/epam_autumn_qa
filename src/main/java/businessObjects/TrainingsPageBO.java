package businessObjects;

import org.openqa.selenium.WebElement;
import pageObjects.TrainingsPage;

import java.util.List;

import static driver.DriverFactory.getExecutor;
import static pageObjects.AbstractPage.getElement;
import static pageObjects.AbstractPage.getElements;


public class TrainingsPageBO {

    private TrainingsPage trainingsPage = new TrainingsPage();

    public List<WebElement> getSkillsSearchResult(String location, String skill){

        getElement(trainingsPage.expandSkillsArrow).click();
        getElement(trainingsPage.byLocationsButton).click();
        getElement(trainingsPage.locationsSearchInput).sendKeys(location);
        getElement(trainingsPage.minskCheckbox).click();
        getElement(trainingsPage.bySkillsButton).click();
        getElement(trainingsPage.skillsSearchInput).sendKeys(skill);
        getElement(trainingsPage.javaCheckbox).click();
        getExecutor().executeScript("window.scrollBy(0,300)");
        getElement(trainingsPage.collapseSkillsArrow).click();

        return getElements(trainingsPage.skillsSearchResultsList);
    }
}
