package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.CartPage;
import org.example.gui.pages.desktop.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuestCheckoutTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Muath")
    public void verifyGuestCheckout() {
        // First add item to cart
        CartTest cartTest = new CartTest();
        cartTest.verifyAddToCart();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();

        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        Assert.assertTrue(checkoutPage.isShippingFormDisplayed(), "Shipping form not displayed");

        // Fill in guest shipping information (without login)
        checkoutPage.fillShippingInformation(
                "guest" + System.currentTimeMillis() + "@example.com", // Unique email for guest
                "",  // No password for guest
                "Guest",
                "User",
                "Guest Company",
                "456 Guest St",
                "Unit 789",
                "",  // No third line needed
                "Los Angeles",
                "California",
                "90001",
                "United States",
                "9876543210"
        );

        checkoutPage.selectBestWayShipping();
        checkoutPage.clickNext();
    }
}