package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
public class SearchResultsPage extends AbstractMagentoPage {

    @FindBy(css = ".page-title")
    private ExtendedWebElement searchResultsTitle;

    @FindBy(css = ".products.list.items.product-items")
    private ExtendedWebElement productsList;

    @FindBy(css = ".product-item-link")
    private ExtendedWebElement firstProduct;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickFirstProduct() {
        // Focus on the product list first
        productsList.click(20);

        // Type TAB to navigate to the first product link and press ENTER
        firstProduct.sendKeys(Keys.TAB);
        firstProduct.sendKeys(Keys.ENTER);

        return new ProductPage(getDriver());
    }

    public boolean isProductListDisplayed() {
        return productsList.isElementPresent();
    }

    public String getSearchResultsTitle() {
        return searchResultsTitle.getText();
    }
}