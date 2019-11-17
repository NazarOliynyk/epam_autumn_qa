package pageObjects;

import org.openqa.selenium.By;

public class NewsPage extends AbstractPage{

    public By newsButton   = By.cssSelector("a[href='/#!/News']");
    public By successStoriesButton   = By.xpath("//span[contains(text(),'Success Stories')]");
    public By materialsButton  = By.xpath("//span[contains(text(),'Materials')]");
    public By videosButton  = By.xpath("//span[contains(text(),'Videos')]");
    public By newsBigButton  = By.xpath("//span[contains(text(),'News')]");
    public By skillsSearchResultsList  = By.cssSelector("div.news-page-item> div.news-page-item__title > a");

}
