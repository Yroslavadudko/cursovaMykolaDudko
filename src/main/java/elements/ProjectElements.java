package elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class ProjectElements {
    public static SelenideElement newProjectField(){
        return $x("//body/section[1]/section[1]/div[1]/ul[1]/li[1]/a[1]");
    }
    public static SelenideElement formNameProjectField(){
        return $("#form-name");
    }
    public static SelenideElement identifierProjectField(){
        return $x("//input[@id='form-identifier']");
    }
    public static SelenideElement columnTaskProjectField(){
        return $("div:nth-child(2) section:nth-child(1) form:nth-child(2) label:nth-child(9) > input:nth-child(1)");
    }
    public static SelenideElement formTaskLimitField(){
        return $("#form-task_limit");
    }
    public static SelenideElement saveField(){
        return $x("//button[contains(text(),'Save')]");
    }
    public static SelenideElement dropdownProjectField(){
        return $x("//body/section[1]/section[1]/div[1]/div[1]/div[1]/a[1]/i[2]");
    }
    public static SelenideElement myProjects(){
        return $x("//a[contains(text(),'ProjectDudko1')]");
    }
    public static SelenideElement configureProject(){
        return $x("//body/div[@id='dropdown']/ul[1]/li[10]/a[1]");
    }
    public static SelenideElement removeProjectField(){
        return $x("//a[contains(text(),'Remove')]");
    }
}
