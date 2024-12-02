package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AbstractMagentoPage {

    @FindBy(xpath = "//input[@id='firstname']")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//input[@id='email_address']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private ExtendedWebElement confirmPasswordInput;

//    @FindBy(xpath = "//button[@title='Create an Account']")
//    private ExtendedWebElement createAccountButton;

    @FindBy(xpath = "//div[contains(@class, 'message-error')]//div")
    private ExtendedWebElement errorMessage;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        setPageURL("/customer/account/create/");
    }

    public void typeFirstName(String firstName) {
        firstNameInput.type(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.type(lastName);
    }

    public void typeEmail(String email) {
        emailInput.type(email);
    }

    public void typePassword(String password) {
        passwordInput.type(password);
        confirmPasswordInput.type(password + Keys.ENTER);
    }
    public boolean isRegistrationFormPresent() {
        return firstNameInput.isElementPresent() &&
                lastNameInput.isElementPresent() &&
                emailInput.isElementPresent() &&
                passwordInput.isElementPresent();
    }
}