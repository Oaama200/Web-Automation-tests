package tests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.gui.pages.desktop.CreateAccountPage;
import org.example.gui.pages.desktop.CustomerAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

public class CreateAccountTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Muath")
    public void verifyAccountCreation() {
        //Open create account page
        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        createAccountPage.open();
        Assert.assertTrue(createAccountPage.isRegistrationFormPresent(),
                "Registration form is not present");

        //Fill in registration form with random email
        String randomEmail = "test" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";

        createAccountPage.typeFirstName("John");
        createAccountPage.typeLastName("Doe");
        createAccountPage.typeEmail(randomEmail);
        createAccountPage.typePassword("Test123456!");

        //Submit form and verify account creation
        Assert.assertTrue(new CustomerAccountPage(getDriver()).isUserLoggedIn(),
                "User is not logged in after registration");
    }
}