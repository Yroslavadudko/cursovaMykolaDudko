package Cursova;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import Base.BaseTest;

public class LoginUiTests extends BaseTest{

    @Test (groups = "Login test")
    public void positiveLoginTest() {
        // A positive test for entry
        open("/"); // Home page
        $("#form-username").setValue("admin");
        $("#form-password").setValue("admin");
        $(By.xpath("//body/div[1]/form[1]/label[3]/input[1]")).click();
        $(By.xpath("//button[contains(text(),'Sign in')]")).click();
        $(By.xpath("//header/div[3]/div[2]/a[1]/i[1]")).click();
        $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[1]"))
                .shouldHave(text("admin"));
        $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[10]/a[1]")).click();
    }
    @Test (groups = "Login test")
    public void negativeLoginTestInvalidUsername() {
        // Negative login test - invalid login
        open("/");
        $("#form-username").setValue("invalidUsername");
        $("#form-password").setValue("admin");
        $(By.xpath("//body[1]/div[1]/form[1]/label[3]")).click();
        $(By.xpath("//button[contains(text(),'Sign in')]")).click();
        $("body:nth-child(2) div.form-login:nth-child(1) > p.alert.alert-error:nth-child(1)")
                .shouldHave(text("Bad username or password"));
    }
    @Test (groups = "Login test")
    public void negativeLoginTestInvalidPassword() {
        // A negative login test is an incorrect password
        open("/");
        $("#form-username").setValue("admin");
        $("#form-password").setValue("invalidPassword");
        $(By.xpath("//body[1]/div[1]/form[1]/label[3]")).click();
        $(By.xpath("//button[contains(text(),'Sign in')]")).click();
        $("body:nth-child(2) div.form-login:nth-child(1) > p.alert.alert-error:nth-child(1)")
                .shouldHave(text("Bad username or password"));
    }
}

