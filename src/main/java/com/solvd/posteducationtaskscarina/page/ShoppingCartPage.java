package com.solvd.posteducationtaskscarina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.posteducationtaskscarina.component.ProductCartElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(id = "attach-desktop-sideSheet")
    private ProductCartElement productCartElement;

    @FindBy(xpath = "//*[@class='a-row sc-your-amazon-cart-is-empty']")
    private ExtendedWebElement cartIsEmptyText;

    @FindBy(id = "nav-cart")
    private ExtendedWebElement shoppingCartButton;

    @FindBy(xpath = "//*[@class='a-truncate-cut' and contains(text(), 'iPhone')]")
    private ExtendedWebElement title;

    @FindBy(css = ".a-dropdown-prompt")
    private ExtendedWebElement value;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartIsEmptyText() {
        return cartIsEmptyText.getText();
    }

    public void clickShoppingCartButton() {
        shoppingCartButton.click();
    }

    public String getProductTitle() {
        return title.getText();
    }

    public String getValue() {
        return value.getText();
    }
}
