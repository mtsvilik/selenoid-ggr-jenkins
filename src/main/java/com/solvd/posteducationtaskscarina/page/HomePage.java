package com.solvd.posteducationtaskscarina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.posteducationtaskscarina.component.LocationElement;
import com.solvd.posteducationtaskscarina.component.SearchElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "nav-search-bar-form")
    private SearchElement searchElement;

    @FindBy(xpath = "//*[@data-toaster-type='AIS_INGRESS']")
    private LocationElement locationElement;

    @FindBy(css = "[data-nav-ref='nav_ya_signin']")
    private ExtendedWebElement signInButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private ExtendedWebElement userNameButton;

    @FindBy(id = "nav-cart")
    private ExtendedWebElement shoppingCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("/");
    }

    @Override
    public void open() {
        super.open();
        closeLocationElementIfNeed();
    }

    private void closeLocationElementIfNeed() {
        LocationElement locationElement = getLocationElement();
        if (locationElement.isUIObjectPresent()) {
            locationElement.clickDismissButton();
        }
    }

    public SearchResultPage openResultPage(String searchText) {
        searchElement.typeInSearchInput(searchText);
        searchElement.clickSearchButton();
        return new SearchResultPage(getDriver());
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage(getDriver());
    }


    public String getUserName() {
        String userName = userNameButton.getText();
        String[] array = userName.split(" ");
        userName = array[1];
        return userName;
    }

    public ShoppingCartPage clickShoppingCartButton() {
        shoppingCartButton.click();
        return new ShoppingCartPage(getDriver());
    }

    public LocationElement getLocationElement() {
        return locationElement;
    }

    public SearchElement getSearchElement() {
        return searchElement;
    }
}
