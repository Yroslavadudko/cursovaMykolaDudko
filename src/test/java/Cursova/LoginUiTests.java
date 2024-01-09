package Cursova;

import Base.BasePage;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginUiTests extends  BasePage {
    @BeforeClass
    public static void setUp() {
        Configuration.baseUrl = "http://127.0.0.1";
        Configuration.browserSize = "1920x1080";
    }

    @Test (groups = "Login test")
    public  void positiveLoginTest() {
        // A positive test for entry
        loginAsAdmin();
        getDropdownUserField().click();
        getActivationUsernameField().shouldHave(text("admin"));
        getLogoutButton().click();
    }
    @Test (groups = "Login test")
    public void negativeLoginTestInvalidUsername() {
        // Negative login test - invalid login
        open("/"); // Home page
        getUsernameField().setValue("invalidUsername");
        getPasswordField().setValue("admin");
        getRememberMyField().click();
        getSignInButton().click();
        gedBadUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
    @Test (groups = "Login test")
    public void negativeLoginTestInvalidPassword() {
        // A negative login test is an incorrect password
        open("/"); // Home page
        getUsernameField().setValue("admin");
        getPasswordField().setValue("invalidPassword");
        getRememberMyField().click();
        getSignInButton().click();
        gedBadUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
}

