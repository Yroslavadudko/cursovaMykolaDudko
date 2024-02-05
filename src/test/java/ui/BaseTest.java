package ui;

import com.codeborne.selenide.Configuration;
import config.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
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
        baseUrl = Config.getBaseUrl();
        browserSize = Config.getBrowserSize();
        fastSetValue = true;
    }
    public static void homePage() {
        open(Config.getHomePage());
    }
    @AfterMethod(alwaysRun = true)
    public static void cleanUp(){
        closeWebDriver();
    }
}


