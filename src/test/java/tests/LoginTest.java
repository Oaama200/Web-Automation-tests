package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.HomePage;
import org.example.gui.pages.desktop.LoginPage;
import org.example.gui.pages.desktop.CustomerAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Muath")
    public void verifyLoginLogout() {
        // 1. Open login page directly
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isLoginFormPresent(), "Login form is not present");

        // 3. Perform login
        String email = "test@example.com";
        String password = "Password123";
        CustomerAccountPage accountPage = loginPage.login(email, password);
        Assert.assertTrue(accountPage.isUserLoggedIn(), "User is not logged in successfully");

        // 5. Perform logout
        HomePage loggedOutHomePage = accountPage.logout();

        // 6. Verify successful logout
        Assert.assertTrue(loggedOutHomePage.isLogoPresent(), "User is not logged out successfully");
    }
}