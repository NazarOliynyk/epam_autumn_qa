package businessObjects;

import org.openqa.selenium.WebElement;
import pageObjects.AbstractPage;
import pageObjects.FAQPAge;
import java.util.List;

import static driver.DriverFactory.getExecutor;

public class FAQPageBO extends AbstractPage {

    private FAQPAge faqPage = new FAQPAge();

    public void getToFAQ(){
        getExecutor()
                .executeScript("arguments[0].click();",
                        getElement(faqPage.FAQButton));
    }

    public List<WebElement> getFAQItems(){
        return getElements(faqPage.FAQItemsList);
    }

    public WebElement getItem(){
        return getElement(faqPage.FAQSecondItem);
    }

}
