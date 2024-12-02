package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage extends AbstractMagentoPage {
    @FindBy(css = "#product-addtocart-button")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-168\"]")
    public ExtendedWebElement sizeMedium;

    @FindBy(css = "[option-label='Black']")
    public ExtendedWebElement colorBlack;

    @FindBy(css = ".message-success")
    private ExtendedWebElement successMessage;

    @FindBy(css = "iframe[src*='googleads']")
    private List<WebElement> adFrames; // Use List to handle zero or more ad frames

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectSize() {
        removeAds();
        sizeMedium.scrollTo();
        waitUntilElementClickable(sizeMedium.getElement()); // Pass WebElement
        sizeMedium.click();
    }

    private void removeAds() {
        if (adFrames != null && !adFrames.isEmpty()) {
            for (WebElement frame : adFrames) {
                if (frame.isDisplayed()) {
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].remove()", frame);
                }
            }
        }
    }

    private void waitUntilElementClickable(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void selectColor() {
        colorBlack.scrollTo();
        waitUntilElementClickable(colorBlack.getElement());
        colorBlack.click();
    }

    public void clickAddToCart() {
        addToCartButton.scrollTo();
        waitUntilElementClickable(addToCartButton.getElement());
        addToCartButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isElementPresent();
    }
}
