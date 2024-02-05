package ui;

import com.codeborne.selenide.Configuration;
import config.Config;
import org.testng.annotations.*;
import static com.codeborne.selenide.Condition.*;
import static elements.LoginElements.*;
import static steps.ui.LoginPage.*;

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
        activationUsernameField().shouldBe(visible);
        logOutButton().click();
    }

    @Test(groups = "UiLoginsTest")
    @Parameters({"browserName", "headless"})
    public void negativeLoginTestInvalidUsername(@Optional("chrome") String browserName, @Optional("true") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        homePage();
        userField().setValue(Config.getInvalidUserPassword());
        passwordField().setValue(Config.getPassword());
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
        userField().setValue(Config.getUser());
        passwordField().setValue(Config.getInvalidUserPassword());
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
}



