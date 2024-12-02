package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class CheckoutPage extends AbstractMagentoPage {

    @FindBy(xpath = "//*[@id=\"checkout-step-shipping\"]")
    private ExtendedWebElement shippingForm;
    @FindBy(xpath = "//*[@id=\"customer-email\"]")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//*[@id=\"customer-password\"]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"customer-email-fieldset\"]/fieldset/div[2]/div[1]/button")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//input[@name='firstname']")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//input[@name='company']")
    private ExtendedWebElement companyInput;

    @FindBy(xpath = "//input[@name='street[0]']")
    private ExtendedWebElement streetAddress1Input;

    @FindBy(xpath = "//input[@name='street[1]']")
    private ExtendedWebElement streetAddress2Input;

    @FindBy(xpath = "//input[@name='street[2]']")
    private ExtendedWebElement streetAddress3Input;

    @FindBy(xpath = "//input[@name='city']")
    private ExtendedWebElement cityInput;

    @FindBy(xpath = "//select[@name='region_id']")
    private ExtendedWebElement stateSelect;

    @FindBy(xpath = "//input[@name='postcode']")
    private ExtendedWebElement zipInput;

    @FindBy(xpath = "//select[@name='country_id']")
    private ExtendedWebElement countrySelect;

    @FindBy(xpath = "//input[@name='telephone']")
    private ExtendedWebElement phoneInput;

    //@FindBy(xpath = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[2]/td[1]/input")
    @FindBy(xpath = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")
    private ExtendedWebElement bestWayShippingMethod;

    @FindBy(xpath = "//button[@data-role='opc-continue']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//*[@id=\"checkout-step-shipping\"]/div[1]/div/div/div")
    private ExtendedWebElement userInfoDisplay;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        // Wait for email field and enter email
        pause(2);
        emailInput.type(email);
        emailInput.sendKeys(Keys.TAB); // Tab out of email field to trigger form update

        pause(10);
        // Wait for password field to appear and enter password
        // if now password field, skip the following, the user is a gust
        if (!Objects.equals(password, "")) {
            passwordInput.type(password);
            signInButton.scrollTo();
            pause(7);
            // Click sign in

            signInButton.hover();
            signInButton.click();
            firstNameInput.scrollTo();
        }
        // Wait for login to complete
        pause(3);
    }

    public void fillShippingInformation(String email, String password, String firstName, String lastName, String company,
                                        String street1, String street2, String street3,
                                        String city, String state, String zip, String country, String phone) {
        login(email, password);

        if (firstNameInput.isElementPresent(20)) {
            firstNameInput.type(firstName);
            lastNameInput.type(lastName);
            companyInput.type(company);
            streetAddress1Input.type(street1);
            streetAddress2Input.type(street2);
            streetAddress3Input.type(street3);
            cityInput.type(city);

            Select stateDropdown = new Select(stateSelect.getElement());
            stateDropdown.selectByVisibleText(state);

            zipInput.type(zip);

            Select countryDropdown = new Select(countrySelect.getElement());
            countryDropdown.selectByVisibleText(country);

            phoneInput.type(phone);
        }
    }

    public void placeOrder(){
        pause(3);
        placeOrderButton.hover();
        placeOrderButton.click();
    }
    public boolean isShippingFormDisplayed() {
        return shippingForm.isElementPresent();
    }

    public void selectBestWayShipping() {
        bestWayShippingMethod.hover();
        bestWayShippingMethod.click();
    }

    public boolean isUserInfoDisplayed(){
        return userInfoDisplay.isElementPresent();
    }

    public void clickNext() {
        nextButton.hover();
        nextButton.click();
    }
}