package cursova;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectUiTests {
    @Test
    public void createProjectTest() {
        // Тест для створення проекту
        loginWithValidCredentials();
        $(By.xpath("//body/div[@id='page-body']/div[@id='side-panel']/div[@id='tasks']/div[1]")).click();
        $("#name").setValue("Project Dudko");
        $(By.xpath("//span[contains(text(),'Freestyle project')]")).click();
        $("#ok-button").click();
        $(By.xpath("//body/div[@id='page-body']/div[@id='main-panel']/form[1]/div[1]/div[2]/div[1]/div[2]/textarea[1]"))
                .setValue("first"); // description
        $(By.xpath("//button[contains(text(),'Save')]")).click();
    }
    private void loginWithValidCredentials() {
        open("/");
        $("#j_username").setValue("dudko_78");
        $("#j_password").setValue("15032005");
        $(By.xpath(" //button[contains(text(),'Sign in')]")).click();
    }

}
