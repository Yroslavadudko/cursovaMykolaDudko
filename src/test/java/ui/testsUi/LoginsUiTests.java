package ui.testsUi;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.LocalDriver;

import static Base.BasePage.*;
import static com.codeborne.selenide.Condition.*;
import static ui.elements.LoginElements.*;
import static ui.steps.LoginPage.*;

public class LoginsUiTests extends BaseTests {

    @Test (groups = "UiProjectsTests",priority = 6)
    public  void positiveLoginTest() {
        // A positive test for entry
        loginAsAdmin();
        dropdownUserField().click();
        activationUsernameField().shouldHave(text("admin"));
        logOutButton().click();
    }
    @Test (groups = "UiProjectsTests", priority = 1)
    public void negativeLoginTestInvalidUsername() {
        // Negative login test - invalid login
        homePage();
        userField().setValue(INVALID_USER_PASSWORD);
        passwordField().setValue(PASSWORD);
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
    @Test (groups = "UiProjectsTests", priority = 2)
    public void negativeLoginTestInvalidPassword() {
        // A negative login test is an incorrect password
        homePage();
        userField().setValue(USER);
        passwordField().setValue(INVALID_USER_PASSWORD);
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
}

