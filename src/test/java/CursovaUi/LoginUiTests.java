package CursovaUi;

import Base.BasePage;
import Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;

public class LoginUiTests extends  BasePage {
    @BeforeClass
    public static void setUp() {
        BaseTest.setUpClass();
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
        BaseTest.homePage();
        getUsernameField().setValue(BasePage.INVALID_USER_PASSWORD);
        getPasswordField().setValue(BasePage.PASSWORD);
        getRememberMyField().click();
        getSignInButton().click();
        gedBadUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
    @Test (groups = "Login test")
    public void negativeLoginTestInvalidPassword() {
        // A negative login test is an incorrect password
        BaseTest.homePage();
        getUsernameField().setValue(BasePage.USER);
        getPasswordField().setValue(BasePage.INVALID_USER_PASSWORD);
        getRememberMyField().click();
        getSignInButton().click();
        gedBadUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
}

