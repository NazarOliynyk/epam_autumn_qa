package businessObjects;

import org.openqa.selenium.WebElement;
import pageObjects.AbstractPage;
import pageObjects.NewsPage;
import java.util.List;
import static driver.DriverFactory.getExecutor;

public class NewsPageBO extends AbstractPage {

    private NewsPage newsPage = new NewsPage();

    public List<WebElement> getSkillsSearchResult(){

        getExecutor()
                .executeScript("arguments[0].click();",
                        getElement(newsPage.newsButton));

        getElement(newsPage.successStoriesButton).click();
        executeElementWithTimeout(newsPage.materialsButton);
        executeElementWithTimeout(newsPage.videosButton);
        executeElementWithTimeout(newsPage.newsBigButton);
        getElement(newsPage.materialsButton).click();

        return getElements(newsPage.skillsSearchResultsList);
    }
}
