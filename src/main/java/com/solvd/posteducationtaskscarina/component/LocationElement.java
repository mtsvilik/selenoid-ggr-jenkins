package com.solvd.posteducationtaskscarina.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LocationElement extends AbstractUIObject implements IMobileUtils {

    @FindBy(id = "nav-packard-glow-loc-icon")
    private ExtendedWebElement locationButton;

    @FindBy(css = ".a-popover-wrapper")
    private ExtendedWebElement chooseYourLocationWindow;

    @FindBy(xpath = "//*[@data-action='a-dropdown-button']")
    private ExtendedWebElement location;

    @FindBy(id = "GLUXCountryList_178")
    private ExtendedWebElement country;

    @FindBy(xpath = "//*[@name='glowDoneButton']")
    private ExtendedWebElement doneButton;

    public LocationElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void chooseLocation() {
        locationButton.click();
        location.clickByJs();
        country.scrollTo();
        country.clickByJs();
        doneButton.clickByJs();
    }
}