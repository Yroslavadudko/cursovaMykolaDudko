package Base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        Configuration.baseUrl = "http://localhost:8080";
        Configuration.browserSize = "1920x1080";
    }
}

