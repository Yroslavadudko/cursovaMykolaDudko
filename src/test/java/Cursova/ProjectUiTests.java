package Cursova;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import Base.BaseTest;

public class ProjectUiTests extends BaseTest {
    @Test
    public void createProjectTest() {
        // Тест для створення проекту
        loginWithValidCredentials();
        $(By.xpath("//header/div[3]/div[1]/a[1]/i[2]")).click();
        $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[1]/a[1]")).click();
        $("#form-name").setValue("Project Dudko");
//        $(By.xpath("//span[contains(text(),'Freestyle project')]")).click();
//        $("#ok-button").click();
//        $(By.xpath("//body/div[@id='page-body']/div[@id='main-panel']/form[1]/div[1]/div[2]/div[1]/div[2]/textarea[1]"))
//                .setValue("first"); // description
        $(By.xpath("//button[contains(text(),'Save')]")).click();
    }
    private void loginWithValidCredentials() {
        open("/");
        $("#form-username").setValue("admin");
        $("#form-password").setValue("admin");
        $(By.xpath("//body[1]/div[1]/form[1]/label[3]")).click();
        $(By.xpath("//button[contains(text(),'Sign in')]")).click();
    }

}
