package com.solvd.posteducationtaskscarina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.posteducationtaskscarina.component.ProductCartElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(id = "attach-desktop-sideSheet")
    private ProductCartElement productCartElement;

    @FindBy(xpath = "//*[@id='selectQuantity']/../../..//*[@id='add-to-cart-button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(id = "a-autoid-0")
    private ExtendedWebElement chooseQuantityButton;

    @FindBy(id = "quantity_1")
    private ExtendedWebElement quantity;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage addToCart() {
        addToCartButton.click();
        if (productCartElement.isElementNotPresent(productCartElement.getCartButton())) {
            return new ShoppingCartPage(getDriver());
        } else {
            productCartElement.clickCartButton();
        }
        return new ShoppingCartPage(getDriver());
    }

    public void chooseQuantity() {
        chooseQuantityButton.click();
        quantity.click();
    }
}
