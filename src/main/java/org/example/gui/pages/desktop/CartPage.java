package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractMagentoPage {
    @FindBy(css = ".cart-summary")
    private ExtendedWebElement cartSummary;

    @FindBy(xpath = "//dl[@class='item-options']")
    private ExtendedWebElement itemOptions;

    @FindBy(xpath = "//button[@data-role='proceed-to-checkout']")
    private ExtendedWebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL("/checkout/cart/");
    }

    public boolean isCartPageOpened() {
        return cartSummary.isElementPresent();
    }

    public boolean isProductOptionsDisplayed() {
        return itemOptions.isElementPresent(20);
    }
    public CheckoutPage proceedToCheckout() {
        proceedToCheckoutButton.scrollTo();
        proceedToCheckoutButton.click(20);
        return new CheckoutPage(getDriver());
    }
}