package ui.testsUi;

import org.testng.annotations.Test;

import static Base.BasePage.*;
import static com.codeborne.selenide.Condition.*;
import static ui.elements.LoginElements.*;
import static ui.steps.LoginPage.*;

public class LoginsUiTests extends BaseTest {

    @Test (priority = 6, groups = "UiProjectsTests")
    public  void positiveLoginTest() {
        // A positive test for entry
        loginAsAdmin();
        dropdownUserField().click();
        activationUsernameField().shouldHave(text("admin"));
        logOutButton().click();
    }
    @Test (priority = 1, groups = "UiProjectsTests")
    public void negativeLoginTestInvalidUsername() {
        // Negative login test - invalid login
        homePage();
        userField().setValue(INVALID_USER_PASSWORD);
        passwordField().setValue(PASSWORD);
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
    @Test (priority = 2, groups = "UiProjectsTests")
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

