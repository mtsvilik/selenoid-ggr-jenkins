package com.solvd.posteducationtaskscarina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(id = "ap_email")
    private ExtendedWebElement emailField;

    @FindBy(css = ".a-button-input")
    private ExtendedWebElement continueButton;

    @FindBy(id = "ap_password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "signInSubmit")
    private ExtendedWebElement signInButton;

    @FindBy(css = ".a-list-item")
    private ExtendedWebElement signInText;

    @FindBy(xpath = "//*[@class='a-alert-heading']")
    private ExtendedWebElement signInMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailField.type(email);
        continueButton.click();
    }

    public void enterPassword(String password) {
        passwordField.type(password);
        signInButton.click();
    }

    public void enterNonExistentEmail(String email) {
        emailField.type(email);
        continueButton.click();
    }

    public String getSignInText() {
        return signInText.getText();
    }
}
