package businessObjects;

import org.openqa.selenium.WebElement;
import pageObjects.TrainingsPage;
import java.util.List;
import static driver.DriverFactory.getExecutor;
import static pageObjects.AbstractPage.getElements;


public class TrainingsPageBO {

    private TrainingsPage trainingsPage = new TrainingsPage();

    public List<WebElement> getSkillsSearchResult(String location, String skill){

        trainingsPage.setExpandSkillsArrow();

        trainingsPage.setByLocationsButton();

        trainingsPage.setLocationsSearchInput(location);

        trainingsPage.setMinskCheckbox();

        trainingsPage.setBySkillsButton();

        trainingsPage.setSkillsSearchInput(skill);

        trainingsPage.setJavaCheckbox();

        getExecutor().executeScript("window.scrollBy(0,300)");

        trainingsPage.setCollapseSkillsArrow();


        return getElements(trainingsPage.skillsSearchResultsList);
    }
}
