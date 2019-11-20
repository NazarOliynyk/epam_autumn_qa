import businessObjects.FAQPageBO;
import businessObjects.LoginationBO;
import db.DbConfiguration;
import db.FAQitem;
import enums.URLs;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static sources.PropertyFileHandler.getEmail;
import static sources.PropertyFileHandler.getPassword;

public class FAQPageTest extends BaseTest{

    @Test(description = "Verify quantity and content of items on the 'FAQ' page")
    public void verifyFAQPageSection(){

        DbConfiguration dbConfiguration = new DbConfiguration();

        dbConfiguration.setConfiguration();

        List<FAQitem> faQitems = dbConfiguration.findAll();

        List<String> texts = new ArrayList<>();

        faQitems.forEach(faQitem -> texts.add(faQitem.getName()));

        texts.forEach(System.out::println);

        LoginationBO loginationBO = new LoginationBO();

        FAQPageBO  faqPageBO = new FAQPageBO();

        loginationBO.goToPageURL(URLs.MAIN_URL.getValue());

        loginationBO.logIn(getEmail(), getPassword());

        faqPageBO.getToFAQ();

        List<WebElement> items = faqPageBO.getFAQItems();
        Assert.assertTrue(items.stream().anyMatch(item->texts.contains(item.getText())),
                "The content of FAQ section does not match to the DB.  ");

        Assert.assertEquals(items.size(),11,
                "Actual quantity of items is not equal to expected. ");

        Assert.assertEquals("When does program registration start?",
                faqPageBO.getItem().getText(), "Actual content of the second item is not equal to expected. ");

    }
}
