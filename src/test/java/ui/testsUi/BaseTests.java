package ui.testsUi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LocalDriver;

import static Base.BasePage.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseTests extends LocalDriver {

    @BeforeMethod
    public void setUpClass() {
        browser = "chrome";
        baseUrl = BASE_URL;
        fastSetValue = true;
    }
    public static void homePage() {
        open(HOME_PAGE);
    }
    @AfterMethod(alwaysRun = true)
    public static void tearDown(){
        LocalDriver.tearDown();
    }
}

