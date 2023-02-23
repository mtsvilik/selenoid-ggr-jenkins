package com.solvd.posteducationtaskscarina.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LocationElement extends AbstractUIObject {

    @FindBy(xpath = ".//*[@data-action-type='DISMISS']")
    private ExtendedWebElement dismissButton;

    public LocationElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickDismissButton() {
        dismissButton.click();
    }
}