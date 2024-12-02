package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.*;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ExistingUserCheckoutTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Muath")
    public void verifyShippingInformation() {
        // First add item to cart
        CartTest cartTest = new CartTest();
        cartTest.verifyAddToCart();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();

        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        Assert.assertTrue(checkoutPage.isShippingFormDisplayed(), "Shipping form not displayed");

        checkoutPage.login(
                "test@example.com",
                "Password123"
        );

        Assert.assertTrue(checkoutPage.isUserInfoDisplayed(), "User info not displayed");
        checkoutPage.selectBestWayShipping();
        checkoutPage.clickNext();
    }
}