package Base;

import com.codeborne.selenide.Configuration;

import static Base.BasePage.*;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public static void setUpClass() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = BROWSER_SIZE;
    }

    public static void homePage() {
        open(HOME_PAGE);
    }
}
