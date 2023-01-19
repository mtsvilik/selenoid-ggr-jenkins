package com.solvd.posteducationtaskscarina.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.posteducationtaskscarina.page.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCartElement extends AbstractUIObject {

    @FindBy(css = "[aria-labelledby='attach-sidesheet-view-cart-button-announce']")
    private ExtendedWebElement cartButton;

    public ProductCartElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductPage clickCartButton() {
        if (cartButton.isPresent()) {
            cartButton.click(10L);
        }
        return new ProductPage(getDriver());
    }

    public ExtendedWebElement getCartButton() {
        return cartButton;
    }
}
