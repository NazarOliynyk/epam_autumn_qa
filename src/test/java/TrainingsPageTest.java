import businessObjects.LoginationBO;
import businessObjects.TrainingsPageBO;
import enums.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;

import static sources.PropertyFileHandler.getEmail;
import static sources.PropertyFileHandler.getPassword;

public class TrainingsPageTest extends BaseTest{

    @Test(description = "Verify 'Trainings' search works properly with searching in 'Skills'\"")
    public void verifyTrainingsWithSkills(){


        LoginationBO loginationBO = new LoginationBO();

        TrainingsPageBO trainingsPageBO = new TrainingsPageBO();

        loginationBO.goToPageURL(URLs.HOME_PAGE_URL.getValue());

        loginationBO.logIn(getEmail(), getPassword());

        trainingsPageBO.getSkillsSearchResult("Minsk", "Java")
                .forEach(element -> Assert.assertTrue(element.getText().contains("JAVA"),
                String.format("Element %s does not contain 'Java' word.", element)));
    }
}
