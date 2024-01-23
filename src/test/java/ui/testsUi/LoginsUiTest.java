package ui.testsUi;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import static Base.BasePage.*;
import static com.codeborne.selenide.Condition.*;
import static ui.elements.LoginElements.*;
import static ui.steps.LoginPage.*;

public class LoginsUiTest extends BaseTest {
    @BeforeClass
    @Parameters({"browserName", "headless"})
    public void setUpClass(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
    }

    @Test(groups = "UiLoginsTest")
    @Parameters({"browserName", "headless"})
    public void positiveLoginTest(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        loginAsAdmin();
        dropdownUserField().click();
        activationUsernameField().shouldHave(text("admin"));
        logOutButton().click();
    }

    @Test(groups = "UiLoginsTest")
    @Parameters({"browserName", "headless"})
    public void negativeLoginTestInvalidUsername(@Optional("chrome") String browserName, @Optional("true") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        homePage();
        userField().setValue(INVALID_USER_PASSWORD);
        passwordField().setValue(PASSWORD);
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
    }

    @Test(groups = "UiLoginsTest")
    @Parameters({"browserName", "headless"})
    public void negativeLoginTestInvalidPassword(@Optional("chrome") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        homePage();
        userField().setValue(USER);
        passwordField().setValue(INVALID_USER_PASSWORD);
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
}



