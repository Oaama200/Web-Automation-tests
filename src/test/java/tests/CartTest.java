package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.HomePage;
import org.example.gui.pages.desktop.SearchResultsPage;
import org.example.gui.pages.desktop.ProductPage;
import org.example.gui.pages.desktop.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Muath")
    public void verifyAddToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        pause(2);
        Assert.assertTrue(homePage.isLogoPresent(), "Home page is not opened properly");

        SearchResultsPage searchResultsPage = homePage.searchProduct("yoga pants");
        ProductPage productPage = searchResultsPage.clickFirstProduct();
        pause(2);

        productPage.selectSize();
        productPage.selectColor();
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.isSuccessMessageDisplayed(), "Add to cart message not displayed");
        pause(2);

        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();
        Assert.assertTrue(cartPage.isCartPageOpened(), "Cart page not opened");
        Assert.assertTrue(cartPage.isProductOptionsDisplayed(), "Product not visible in cart");
    }
}