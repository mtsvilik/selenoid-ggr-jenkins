package com.solvd.posteducationtaskscarina.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LocationElement extends AbstractUIObject implements IMobileUtils {

    @FindBy(id = "nav-packard-glow-loc-icon")
    private ExtendedWebElement locationButton;

    @FindBy(css = ".a-popover-wrapper")
    private ExtendedWebElement chooseYourLocationWindow;

    @FindBy(id = "GLUXCountryList_178")
    private ExtendedWebElement country;

    @FindBy(xpath = "//*[@name='glowDoneButton']")
    private ExtendedWebElement doneButton;

    public LocationElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void chooseLocation() {
        locationButton.click();
//        ExtendedWebElement chooseYourLocationWindow = getChooseYourLocationWindow();
//        if (chooseYourLocationWindow.isElementPresent()) {

        WebElement location = driver
                .findElement(By.xpath("//*[contains(@class, 'a-icon') and contains(@class, 'a-icon-dropdown')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(location).click().build().perform();
        location.click();
        country.scrollTo();
        country.click();
        doneButton.click();
//        }
    }

    public ExtendedWebElement getChooseYourLocationWindow() {
        return chooseYourLocationWindow;
    }
}
