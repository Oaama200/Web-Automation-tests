package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Muath")
    public void verifyHomePageOpened() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isLogoPresent(), "Logo is not present on home page");
        Assert.assertTrue(homePage.isNavigationPresent(), "Main navigation is not present on home page");
    }
}