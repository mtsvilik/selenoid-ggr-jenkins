package com.solvd.posteducationtaskscarina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.posteducationtaskscarina.component.SearchElement;
import com.solvd.posteducationtaskscarina.page.*;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTest implements IAbstractTest {

    @Test
    public void verifySearchResultsTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        SearchElement searchElement = homePage.getSearchElement();
        searchElement.typeInSearchInput("umbrella");
        SearchResultPage searchResultPage = searchElement.clickSearchButton();

        SoftAssert softAssert = new SoftAssert();
        searchResultPage.getSearchResultElements()
                .forEach(searchResultElement -> softAssert.assertTrue(searchResultElement.getDescriptionText()
                                .toLowerCase().contains("umbrella"),
                        "searchResultElement.getDescriptionText() doesn't contain text 'umbrella'"));

        softAssert.assertAll();
    }

    @Test
    public void verifySignInTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterEmail(R.TESTDATA.get("user1.email"));
        signInPage.enterPassword(R.TESTDATA.get("user1.password"));

        Assert.assertEquals(homePage.getUserName(), R.TESTDATA.get("userName"), "Name of account should contains user name");
    }

    @Test
    public void checkSignInNonExistentEmailTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterNonExistentEmail(R.TESTDATA.get("user2.email"));
        Assert.assertEquals(signInPage.getSignInText(),
                R.TESTDATA.get("signInText"), "Sign In page should contains sign in text");
    }

    @Test
    public void checkAddCartButtonIsClickableTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.getCartIsEmptyText(),
                R.TESTDATA.get("cartIsEmptyText"), "Shopping cart page should contains add to cart is empty text");
    }

    @Test
    public void verifyProductIsAddedToCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        SearchResultPage searchResultPage = homePage.openResultPage(R.TESTDATA.get("searchText"));

        ProductPage productPage = searchResultPage.clickSearchResult();

        ShoppingCartPage shoppingCartPage = productPage.addToCart();
        shoppingCartPage.clickShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getProductTitle().toLowerCase().contains(R.TESTDATA.get("productTitle")),
                "Product in shopping cart with incorrect title");
    }

    @Test
    public void checkIncreaseProductInCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        SearchResultPage searchResultPage = homePage.openResultPage(R.TESTDATA.get("searchText"));

        ProductPage productPage = searchResultPage.clickSearchResult();
        productPage.chooseQuantity();

        ShoppingCartPage shoppingCartPage = productPage.addToCart();
        shoppingCartPage.clickShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.getValue(), R.TESTDATA.get("quantity"), "Incorrect quantity product in shopping cart");
    }
}
