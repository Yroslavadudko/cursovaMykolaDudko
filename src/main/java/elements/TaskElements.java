package elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TaskElements {

    public static SelenideElement addNewTaskField(){
        return $x("//body/div[@id='dropdown']/ul[1]/li[4]/a[1]");
    }
    public static SelenideElement nameTaskField(){
        return $("#form-title");
    }
    public static SelenideElement dropdownTaskField() {
        return $x("//tbody/tr[2]/td[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]");
    }
    public static SelenideElement editTask(){
        return $x("//body/div[@id='dropdown']/ul[1]/li[3]/a[1]");
    }
    public static SelenideElement newCommentTask(){
        return $x("//body/div[@id='modal-overlay']/div[@id='modal-box']/div[@id='modal-content']" +
                "/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]");
    }
    public static SelenideElement dropdownColorTask (){
        return $x("//body/div[@id='modal-overlay']/div[@id='modal-box']/div[@id='modal-content']/form[1]/div[1]/div[2]/span[1]/span[1]/span[1]/span[2]");
    }
    public static SelenideElement colorTaskPurple(){
        return $x("//div[contains(text(),'Purple')]");
    }
    public static SelenideElement dropdownAssigneeTask(){
        return $("#form-owner_id");
    }
    public static SelenideElement assigneeAdminTask(){
        return $x("//option[contains(text(),'admin')]");
    }
    public static SelenideElement dropdownPriorityTask(){
        return $x(" //select[@id='form-priority']");
    }
    public static SelenideElement priorityLowTask(){
        return $x("//option[contains(text(),'1')]");
    }
    public static SelenideElement closeTask(){
        return $x("//body/div[@id='dropdown']/ul[1]/li[14]/a[1]/i[1]");
    }
    public static SelenideElement confirmButton(){
        return $x("//button[@id='modal-confirm-button']");
    }
}
