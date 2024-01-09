package Base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        Configuration.baseUrl = "http://127.0.0.1";
        Configuration.browserSize = "1920x1080";
    }
}

