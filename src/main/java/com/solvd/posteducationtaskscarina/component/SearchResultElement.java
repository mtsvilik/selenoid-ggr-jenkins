package com.solvd.posteducationtaskscarina.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultElement extends AbstractUIObject {

    @FindBy(xpath = "//*[contains(@class, 'title-instructions')]")
    private ExtendedWebElement description;

    public SearchResultElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getDescriptionText() {
        return description.getText();
    }
}
