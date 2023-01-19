package com.solvd.posteducationtaskscarina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.posteducationtaskscarina.component.SearchResultElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(id = "data-csa-c-item-id")
    private List<SearchResultElement> searchResultElements;

    @FindBy(css = "[data-image-index='2']")
    private ExtendedWebElement searchResult;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<SearchResultElement> getSearchResultElements() {
        return searchResultElements;
    }

    public ProductPage clickSearchResult() {
        searchResult.click();
        return new ProductPage(getDriver());
    }
}
