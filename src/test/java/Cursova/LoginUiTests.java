package Cursova;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginUiTests {

    @Test (groups = "Login test")
    public void positiveLoginTest() {
        // A positive test for entry
        open("/"); // Home page
        $("#j_username").setValue("dudko_78");
        $("#j_password").setValue("15032005");
        $(By.xpath("//button[contains(text(),'Sign in')]")).click();
        $(By.xpath("//span[contains(text(),'Mykola Dudko')]"))
                .shouldHave(text("Mykola Dudko"));
        $(By.xpath(" //span[contains(text(),'log out')]")).click();
    }
    @Test (groups = "Login test")
    public void negativeLoginTestInvalidUsername() {
        // Negative login test - invalid login
        open("/");
        $("#j_username").setValue("invalidUsername");
        $("#j_password").setValue("15032005");
        $(By.xpath(" //button[contains(text(),'Sign in')]")).click();
        $(By.xpath("//div[contains(text(),'Invalid username or password')]"))
                .shouldHave(text("Invalid username or password"));
    }
    @Test (groups = "Login test")
    public void negativeLoginTestInvalidPassword() {
        // A negative login test is an incorrect password
        open("/");
        $("#j_username").setValue("dudko_78");
        $("#j_password").setValue("invalidPassword");
        $(By.xpath(" //button[contains(text(),'Sign in')]")).click();
        $(By.xpath("//div[contains(text(),'Invalid username or password')]"))
                .shouldHave(text("Invalid username or password"));
    }
}

