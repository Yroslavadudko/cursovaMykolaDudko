package ui.testsUi;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Base.BasePage.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeMethod

    public static void setUpClass() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = BROWSER_SIZE;
    }
    public static void homePage() {
        open(HOME_PAGE);
    }
    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        closeWebDriver();
    }
}
