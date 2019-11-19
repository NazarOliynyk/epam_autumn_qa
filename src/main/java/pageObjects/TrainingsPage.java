package pageObjects;

import org.openqa.selenium.By;

public class TrainingsPage extends AbstractPage{

    private By expandSkillsArrow = By.className("filter-toggle__arrow-icon");

    private By byLocationsButton = By.xpath("//div[contains(text(),'By locations')]");

    private By locationsSearchInput = By.xpath("//input[@name='training-filter-input']");

    private By minskCheckbox = By.xpath("//label[contains(.,'Minsk')]//span");

    private By bySkillsButton = By.xpath("//div[contains(text(),'By skills')]");

    private By skillsSearchInput = By.xpath("//input[@name='training-filter-input']");

    private By javaCheckbox  = By.xpath("//label[contains(.,'Java')]//span");

    private By collapseSkillsArrow  = By.className("filter-toggle__arrow-icon");

    public By skillsSearchResultsList  =
            By.xpath("//div[@class='training-list__container training-list__desktop']//a");

    public void setExpandSkillsArrow(){
        getElement(expandSkillsArrow).click();
    }

    public void setByLocationsButton(){
        getElement(byLocationsButton).click();
    }

    public void setLocationsSearchInput(String location){
        getElement(locationsSearchInput).sendKeys(location);
    }

    public void setMinskCheckbox(){
        getElement(minskCheckbox).click();
    }

    public void setBySkillsButton(){
        getElement(bySkillsButton).click();
    }

    public void setSkillsSearchInput(String skill){
        getElement(skillsSearchInput).sendKeys(skill);
    }

    public void setJavaCheckbox(){
        getElement(javaCheckbox).click();
    }

    public void setCollapseSkillsArrow(){
        getElement(collapseSkillsArrow).click();
    }

}
