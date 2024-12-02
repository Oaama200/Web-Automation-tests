package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.HomePage;
import org.example.gui.pages.desktop.ProductPage;
import org.example.gui.pages.desktop.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Muath")
    public void verifyProductDetails() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        SearchResultsPage searchResultsPage = homePage.searchProduct("yoga pants");
        ProductPage productPage = searchResultsPage.clickFirstProduct();

        productPage.selectSize();
        productPage.selectColor();
        Assert.assertTrue(productPage.sizeMedium.isElementPresent(), "Size Medium element is not present!");
        Assert.assertTrue(productPage.colorBlack.isElementPresent(), "Color Black element is not present!");
    }
}
