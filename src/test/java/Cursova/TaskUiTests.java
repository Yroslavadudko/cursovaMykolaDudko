package Cursova;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import Base.BaseTest;

public class TaskUiTests extends BaseTest {
    @Test
    public void createTaskTest(){
        // Task creation
        loginWithValidCredentials();
        $(By.xpath("//header/div[3]/div[2]/a[1]/i[1]")).click();
        $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[4]/a[1]")).click();
        $("section.page:nth-child(2) div.table-list div.table-list-row.table-border-left div:nth-child(1) ").click();
        $(By.xpath(" //a[contains(text(),'Project Dudko')]")).click();
        $(By.xpath("//body/section[1]/section[1]/div[1]/div[1]/div[1]/a[1]/i[2]")).click();
        $(By.xpath(" //body/div[@id='dropdown']/ul[1]/li[4]/a[1]")).click();
        $("#form-title").setValue("Task#1");
        $(By.xpath("//button[contains(text(),'Save')]")).click();
        // Comment
        $(By.xpath("//tbody/tr[2]/td[1]/div[1]/div[1]/div[2]/div[2]/a[1]/i[1]")).click();
        $(By.xpath("//body/div[@id='modal-overlay']/div[@id='modal-box']/div[@id='modal-content']" +
                "/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]")).setValue("close");
        $(By.xpath("//button[contains(text(),'Save')]")).click();
        // Close
        $(By.xpath("//tbody/tr[2]/td[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/strong[1]/i[1]")).click();
        $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[15]/a[1]")).click();
        $(By.xpath("//button[@id='modal-confirm-button']")).click();

    }

    private void loginWithValidCredentials() {
        open("/");
        $("#form-username").setValue("admin");
        $("#form-password").setValue("admin");
        $(By.xpath("//body[1]/div[1]/form[1]/label[3]")).click();
        $(By.xpath("//button[contains(text(),'Sign in')]")).click();
    }

}
