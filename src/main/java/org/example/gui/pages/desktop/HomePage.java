package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractMagentoPage {

    @FindBy(css = ".logo")
    private ExtendedWebElement logo;

    @FindBy(css = ".navigation")
    private ExtendedWebElement navigation;

    @FindBy(css = "#search")
    private ExtendedWebElement searchInput;

    @FindBy(css = "button[title='Search']")
    private ExtendedWebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL(""); // Empty string since this is the home page
    }

    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    public boolean isNavigationPresent() {
        return navigation.isElementPresent();
    }
    public SearchResultsPage searchProduct(String productName) {
        searchInput.type(productName);
        searchButton.click();
        return new SearchResultsPage(getDriver());
    }
}