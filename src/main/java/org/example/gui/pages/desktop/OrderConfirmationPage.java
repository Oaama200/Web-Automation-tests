package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends AbstractMagentoPage {
    @FindBy(xpath = "//span[contains(text(), 'Thank you for your purchase!')]")
    private ExtendedWebElement confirmationMessage;
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderConfirmed() {
        return confirmationMessage.isElementPresent();
    }

}