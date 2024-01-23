package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TaskElements {

    public static SelenideElement addNewTaskField(){
        return $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[4]/a[1]"));
    }
    public static SelenideElement nameTaskField(){
        return $("#form-title");
    }
    public static SelenideElement dropdownTaskField() {
        return $(By.xpath("//tbody/tr[2]/td[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]"));
    }
    public static SelenideElement editTask(){
        return $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[3]/a[1]"));
    }
    public static SelenideElement newCommentTask(){
        return $(By.xpath("//body/div[@id='modal-overlay']/div[@id='modal-box']/div[@id='modal-content']" +
                "/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]"));
    }
    public static SelenideElement dropdownColorTask (){
        return $(By.xpath("//body/div[@id='modal-overlay']/div[@id='modal-box']/div[@id='modal-content']/form[1]/div[1]/div[2]/span[1]/span[1]/span[1]/span[2]"));
    }
    public static SelenideElement colorTaskPurple(){
        return $(By.xpath("//div[contains(text(),'Purple')]"));
    }
    public static SelenideElement dropdownAssigneeTask(){
        return $("#form-owner_id");
    }
    public static SelenideElement assigneeAdminTask(){
        return $(By.xpath("//option[contains(text(),'admin')]"));
    }
    public static SelenideElement dropdownPriorityTask(){
        return $(By.xpath(" //select[@id='form-priority']"));
    }
    public static SelenideElement priorityLowTask(){
        return $(By.xpath("//option[contains(text(),'1')]"));
    }
    public static SelenideElement closeTask(){
        return $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[14]/a[1]/i[1]"));
    }
    public static SelenideElement confirmButton(){
        return $(By.xpath("//button[@id='modal-confirm-button']"));
    }
}
