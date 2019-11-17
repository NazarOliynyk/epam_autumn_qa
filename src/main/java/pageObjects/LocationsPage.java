package pageObjects;

import org.openqa.selenium.By;

public class LocationsPage extends AbstractPage{

    public By trainingListButton   = By.cssSelector("a[href='/#!/TrainingList']");
    public By searchTrainingArrow   = By.xpath("//input[@placeholder='Search for trainings']");
    public By countrySelect  = By.xpath("//li[descendant::div[ contains(text(),'Ukraine')]]");
    public By citySelect   = By.xpath("//li[descendant::text()[contains(., \"Lviv\")]]/label");
    public By lvivPositions  = By.xpath("//*[@id=\"training\"]/div[4]/div/div/div[3]");

}
