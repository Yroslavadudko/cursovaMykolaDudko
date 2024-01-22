package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.*;

public class LocalDriver {
    private static WebDriver driver;

    public LocalDriver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserName = getProperty("browserName");
            if (browserName != null) {
                switch (browserName.toLowerCase()) {
                    case "firefox":
                        driver = new FirefoxDriver();
                        out.println("FireFox browser set");
                        break;
                    case "chrome":
                        driver = new ChromeDriver();
                        out.println("Chrome browser set");
                        break;
                    case "chromeheadless":
                        // Додайте конфігурацію для Chrome Headless
                        driver = new ChromeDriver();
                        out.println("Chrome headless browser set");
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browserName);
                }
            } else {
                driver = new ChromeDriver();
                out.println("Chrome browser set");
            }
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

