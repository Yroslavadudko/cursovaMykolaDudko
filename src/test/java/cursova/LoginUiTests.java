package cursova;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginUiTests {


    @Test
    public void positiveLoginTest() {
        // Позитивний тест для входу
        open("/"); // Головна сторінка
        $("#j_username").setValue("dudko_78");
        $("#j_password").setValue("15032005");
        $(By.xpath("//button[contains(text(),'Sign in')]")).click();
        $(By.xpath("//span[contains(text(),'Mykola Dudko')]"))
                .shouldHave(text("Mykola Dudko"));
        $(By.xpath(" //span[contains(text(),'log out')]")).click();
    }

    @Test
    public void negativeLoginTestInvalidUsername() {
        // Негативний тест для входу - невірний логін
        open("/");
        $("#j_username").setValue("invalidUsername");
        $("#j_password").setValue("15032005");
        $(By.xpath(" //button[contains(text(),'Sign in')]")).click();
        $(By.xpath("//div[contains(text(),'Invalid username or password')]"))
                .shouldHave(text("Invalid username or password"));
    }
    @Test
    public void negativeLoginTestInvalidPassword() {
        // Негативний тест для входу - невірний пароль
        open("/");
        $("#j_username").setValue("dudko_78");
        $("#j_password").setValue("invalidPassword");
        $(By.xpath(" //button[contains(text(),'Sign in')]")).click();
        $(By.xpath("//div[contains(text(),'Invalid username or password')]"))
                .shouldHave(text("Invalid username or password"));
    }

}

