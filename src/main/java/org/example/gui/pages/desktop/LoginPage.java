package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractMagentoPage {

    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@id='pass']")
    private ExtendedWebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/customer/account/login/");
    }

    public CustomerAccountPage login(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password + Keys.ENTER);
        return new CustomerAccountPage(getDriver());
    }

    public boolean isLoginFormPresent() {
        return emailInput.isElementPresent() && passwordInput.isElementPresent();
    }
}