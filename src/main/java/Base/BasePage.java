package Base;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ja.然し;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    public static final String BASE_URL = "http://127.0.0.1";
    public static final String BROWSER_SIZE = "1920x1080";
    public static final String HOME_PAGE = "/";
    public static final String USER = "admin";
    public static final String PASSWORD = "admin";
    public static final String INVALID_USER_PASSWORD = "invalid";
    public void loginAsAdmin() {
        open(HOME_PAGE);
        getUsernameField().setValue(USER);
        getPasswordField().setValue(PASSWORD);
        getRememberMyField().click();
        getSignInButton().click();
    }

    public SelenideElement getUsernameField(){
        return $("#form-username");
    }
    public SelenideElement getPasswordField(){
        return $("#form-password");
    }
    public SelenideElement getRememberMyField(){
        return $(By.xpath("//body[1]/div[1]/form[1]/label[3]"));
    }
    public SelenideElement getSignInButton(){
        return $(By.xpath("//button[contains(text(),'Sign in')]"));
    }
    public SelenideElement gedBadUsernamePasswordField(){
        return $("body:nth-child(2) div.form-login:nth-child(1) > p.alert.alert-error:nth-child(1)");
    }
    public SelenideElement getLogoutButton(){
        return $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[10]/a[1]"));
    }

    public SelenideElement getDropdownUserField(){
        return $(By.xpath("//header/div[3]/div[2]/a[1]/i[1]"));
    }
    public SelenideElement getActivationUsernameField(){
        return $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[1]"));
    }
    public SelenideElement getNewProjectField(){
        return $("section.page:nth-child(2) section:nth-child(1) div.page-header ul:nth-child(1) li:nth-child(1) > a.js-modal-medium");
    }
    public SelenideElement getFormNameProjectField(){
        return $("#form-name");
    }
    public SelenideElement getIdentifierProjectField(){
        return $(By.xpath("//input[@id='form-identifier']"));
    }
    public SelenideElement getColumnTaskProjectField(){
        return $("div:nth-child(2) section:nth-child(1) form:nth-child(2) label:nth-child(9) > input:nth-child(1)");
    }
    public SelenideElement getFormTaskLimitField(){
        return $("#form-task_limit");
    }
    public SelenideElement getSaveField(){
        return $(By.xpath("//button[contains(text(),'Save')]"));
    }
    public SelenideElement getProjectsManagementField(){
        return $("section.page:nth-child(2) div.table-list div.table-list-row.table-border-left div:nth-child(1)");
    }
    public SelenideElement getSearchProjectNameField(){
        return $(By.xpath("//a[contains(text(),'Project Dudko')]"));
    }
    public SelenideElement getDropdownProjectField(){
        return $(By.xpath("//body/section[1]/section[1]/div[1]/div[1]/div[1]/a[1]/i[2]"));
    }
    public SelenideElement getAddNewTaskField(){
        return $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[4]/a[1]"));
    }
    public SelenideElement getNameTaskField(){
        return $("#form-title");
    }
    public SelenideElement getOpenTask(){
        return $(By.xpath("//tbody/tr[2]/td[1]/div[1]/div[1]/div[2]/div[2]/a[1]/i[1]"));
    }
    public SelenideElement getNewCommentTask(){
        return $(By.xpath("//body/div[@id='modal-overlay']/div[@id='modal-box']/div[@id='modal-content']" +
                "/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]"));
    }
    public SelenideElement getDropdownTaskField(){
        return $(By.xpath("//tbody/tr[2]/td[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/strong[1]/i[1]"));
    }
    public SelenideElement getCloseTask(){
        return $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[15]/a[1]"));
    }
    public SelenideElement getConfirmButton(){
        return $(By.xpath("//button[@id='modal-confirm-button']"));
    }
}
