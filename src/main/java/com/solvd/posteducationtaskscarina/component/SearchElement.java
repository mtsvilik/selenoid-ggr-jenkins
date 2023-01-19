package com.solvd.posteducationtaskscarina.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.posteducationtaskscarina.page.SearchResultPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchElement extends AbstractUIObject {

    @FindBy(id = "twotabsearchtextbox")
    private ExtendedWebElement searchInput;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement searchButton;

    public SearchElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeInSearchInput(String text) {
        searchInput.type(text);
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage(getDriver());
    }
}
