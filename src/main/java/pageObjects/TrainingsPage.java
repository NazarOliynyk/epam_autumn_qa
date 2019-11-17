package pageObjects;

import org.openqa.selenium.By;

public class TrainingsPage extends AbstractPage{

    public By expandSkillsArrow = By.className("filter-toggle__arrow-icon");

    public By byLocationsButton = By.xpath("//div[contains(text(),'By locations')]");

    public By locationsSearchInput = By.xpath("//input[@name='training-filter-input']");

    public By minskCheckbox = By.xpath("//label[contains(.,'Minsk')]//span");

    public By bySkillsButton = By.xpath("//div[contains(text(),'By skills')]");

    public By skillsSearchInput = By.xpath("//input[@name='training-filter-input']");

    public By javaCheckbox  = By.xpath("//label[contains(.,'Java')]//span");

    public By collapseSkillsArrow  = By.className("filter-toggle__arrow-icon");

    public By skillsSearchResultsList  =
            By.xpath("//div[@class='training-list__container training-list__desktop']//a");

}
