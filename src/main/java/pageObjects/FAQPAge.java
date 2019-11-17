package pageObjects;

import org.openqa.selenium.By;

public class FAQPAge extends AbstractPage{

    public By FAQButton   = By.cssSelector("a[href='/#!/FAQ']");

    public By FAQItemsList   = By.xpath("//div[@ ng-repeat='item in faqItems']");

    public By FAQSecondItem  =
            By.xpath("//div[@ ng-repeat='item in faqItems'][2]/div[@class='panel']/div[@class='collapsed']/label");

}
