package com.solvd.posteducationtaskscarina.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LocationElement extends AbstractUIObject {

    @FindBy(id = "nav-packard-glow-loc-icon")
    private ExtendedWebElement locationButton;

    @FindBy(css = ".a-popover-wrapper")
    private ExtendedWebElement chooseYourLocationWindow;

    @FindBy(css = ".a-dropdown-container")
    private ExtendedWebElement location;

    @FindBy(xpath = "//*[@name='glowDoneButton']")
    private ExtendedWebElement doneButton;

    public LocationElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void chooseLocation() {
        locationButton.click();
        ExtendedWebElement chooseYourLocationWindow = getChooseYourLocationWindow();
        if (chooseYourLocationWindow.isElementPresent()) {
            String country = "Poland";
            location.click();
            location.type(country);
            doneButton.click();
        }
    }

    public ExtendedWebElement getChooseYourLocationWindow() {
        return chooseYourLocationWindow;
    }
}
