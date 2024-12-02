package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.CartPage;
import org.example.gui.pages.desktop.CheckoutPage;
import org.example.gui.pages.desktop.OrderConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Muath")
    public void verifyOrderPlacement() {
        // First add item to cart
        CartTest cartTest = new CartTest();
        cartTest.verifyAddToCart();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();

        // Proceed to checkout and verify form is displayed
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        Assert.assertTrue(checkoutPage.isShippingFormDisplayed(), "Shipping form not displayed");

        // Fill in shipping information with login
        checkoutPage.fillShippingInformation(
                "test@example.com",
                "Password123",
                "John",
                "Doe",
                "Test Company",
                "123 Main St",
                "Apt 4B",
                "Floor 2",
                "New York",
                "New York",
                "10001",
                "United States",
                "1234567890"
        );

        // Select shipping method and proceed
        checkoutPage.selectBestWayShipping();
        checkoutPage.clickNext();

        // Additional order verification can be added here
        checkoutPage.placeOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(getDriver());
        Assert.assertTrue(orderConfirmationPage.isOrderConfirmed(),
                "Order placement was not successful");
    }
}