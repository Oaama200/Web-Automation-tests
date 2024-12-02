package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.HomePage;
import org.example.gui.pages.desktop.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Muath")
    public void verifyProductSearch() {
        // Open home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isLogoPresent(), "Home page is not opened properly");

        //Search for a product
        String searchTerm = "yoga pants";
        SearchResultsPage searchResultsPage = homePage.searchProduct(searchTerm);

        // Verify search results
        Assert.assertTrue(searchResultsPage.isProductListDisplayed(),
                "Product list is not displayed on search results page");
        Assert.assertTrue(searchResultsPage.getSearchResultsTitle().toLowerCase().contains(searchTerm),
                "Search results title doesn't contain the search term");
    }
}