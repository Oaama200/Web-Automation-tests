package org.example.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.AbstractMagentoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractMagentoPage {

    @FindBy(xpath = "//span[@class='base' and contains(text(), 'My Account')]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//div[@class='box box-information']//div[@class='box-content']")
    private ExtendedWebElement accountInformation;

    @FindBy(xpath = "//button[@data-action='customer-menu-toggle']")
    private ExtendedWebElement customerMenuToggle;

    @FindBy(xpath = "//div[contains(@class, 'customer-menu')]//a[contains(@href, 'logout')]")
    private ExtendedWebElement signOutLink;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        setPageURL("/customer/account/");
    }

    public boolean isPageOpened() {
        return pageTitle.isElementPresent() && pageTitle.getText().contains("My Account");
    }

    public String getAccountInformation() {
        return accountInformation.getText();
    }

    public void signOut() {
        customerMenuToggle.click();
        signOutLink.click();
    }
}