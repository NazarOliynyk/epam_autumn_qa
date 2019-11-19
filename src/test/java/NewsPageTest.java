import businessObjects.LoginationBO;
import businessObjects.NewsPageBO;
import enums.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;

import static sources.PropertyFileHandler.getEmail;
import static sources.PropertyFileHandler.getPassword;

public class NewsPageTest extends BaseTest{

    @Test(description = "Verify 'Materials' section works properly with searching in 'News'")
    public void verifyNewsPageMaterialSection(){


        LoginationBO loginationBO = new LoginationBO();

        NewsPageBO newsPageBO = new NewsPageBO();

        loginationBO.goToPageURL(URLs.MAIN_URL.getValue());

        loginationBO.logIn(getEmail(), getPassword());
        newsPageBO.getSkillsSearchResult().forEach(element-> System.out.println(element.getText()));
        newsPageBO.getSkillsSearchResult()
                .forEach(element -> Assert.assertTrue((element.getText().contains("materials")
                                || element.getText().contains("Useful")
                                || element.getText().contains("Materials")),
                        String.format("Element %s does not contain either 'Materials' or 'Useful' word.", element)));

    }
}
