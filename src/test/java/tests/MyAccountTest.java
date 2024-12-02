package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.CustomerAccountPage;
import org.example.gui.pages.desktop.HomePage;
import org.example.gui.pages.desktop.LoginPage;
import org.example.gui.pages.desktop.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Muath")
    public void verifyAccountInformation(){
        // open login page
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isLoginFormPresent(), "Login form is not present");

        //Login with valid credentials and get CustomerAccountPage
        String email = "test@example.com";
        String password = "Password123";
        CustomerAccountPage customerAccountPage = loginPage.login(email, password);
        Assert.assertTrue(customerAccountPage.isUserLoggedIn(),
                "User is not logged in successfully");

        // Navigate to My Account page and verify
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        myAccountPage.open();
        Assert.assertTrue(myAccountPage.isPageOpened(),
                "My Account page is not opened");

        //Verify account information
        String accountInfo = myAccountPage.getAccountInformation();
        Assert.assertTrue(accountInfo.contains(email),
                "Account information doesn't contain the correct email");

        // Sign out and verify return to home page
        myAccountPage.signOut();
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isLogoPresent(),
                "User is not logged out successfully");
    }
}
