import businessObjects.FAQPageBO;
import businessObjects.LoginationBO;
import businessObjects.NewsPageBO;
import enums.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FAQPAge;

public class FAQPageTest extends BaseTest{

    @Test(description = "Verify quantity and content of items on the 'FAQ' page")
    public void verifyFAQPageSection(){


        LoginationBO loginationBO = new LoginationBO();

        FAQPageBO  faqPageBO = new FAQPageBO();

        loginationBO.goToPageURL(URLs.MAIN_URL.getValue());

        loginationBO.logIn("ivanhorintest@gmail.com", "ivanhorintestPassword");

        faqPageBO.getToFAQ();

        Assert.assertEquals(faqPageBO.getFAQItems().size(),11,
                "Actual quantity of items is not equal to expected. ");

        Assert.assertEquals("When does program registration start?",
                faqPageBO.getItem().getText(), "Actual content of the second item is not equal to expected. ");

    }
}
