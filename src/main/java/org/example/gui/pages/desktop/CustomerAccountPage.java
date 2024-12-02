package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CustomerAccountPage extends AbstractMagentoPage {

    @FindBy(xpath = "//div[@class='panel header']//button[@data-action='customer-menu-toggle']")
    private ExtendedWebElement customerMenuToggle;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[contains(@href, 'logout')]")
    private ExtendedWebElement logoutLink;

    @FindBy(xpath = "//span[@class='logged-in']")
    private ExtendedWebElement welcomeMessage;

    public CustomerAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        return welcomeMessage.isElementPresent();
    }

    public HomePage logout() {
        customerMenuToggle.click();
        logoutLink.click();
        return new HomePage(getDriver());
    }
}