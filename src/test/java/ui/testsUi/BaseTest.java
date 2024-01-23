package ui.testsUi;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LocalDriver;
import static Base.BasePage.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest extends LocalDriver {
    private static final String BROWSER_TYPE = "chrome";
    @BeforeMethod
    public void setUpClass(){
        switch (BROWSER_TYPE.toLowerCase()) {
        case "firefox":
            Configuration.browser = "firefox";
            break;
        case "chrome":
            Configuration.browser = "chrome";
            break;
        case "chromeheadless":
            Configuration.browser = "chrome";
            Configuration.headless = true;
            break;
        default:
            throw new IllegalArgumentException("Unsupported browser type: " + BROWSER_TYPE);
    }
        baseUrl = BASE_URL;
        fastSetValue = true;
    }
    public static void homePage() {
        open(HOME_PAGE);
    }
    @AfterMethod(alwaysRun = true)
    public static void cleanUp(){
        closeWebDriver();
    }
}


