package Cursova;

import Base.BasePage;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TaskUiTests extends BasePage {
    @BeforeClass
    public static void setUp() {
        Configuration.baseUrl = "http://127.0.0.1";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void createTaskTest(){
        // Task creation
        loginAsAdmin();
        getDropdownUserField().click();
        getProjectsManagementField().click();
        getSearchProjectNameField().click();
        getDropdownProjectField().click();
        getAddNewTaskField().click();
        getNameTaskField().setValue("Task#1");
        getSaveField().click();
        // Comment
        getOpenTask().click();
        getNewCommentTask().setValue("close this Task");
        getSaveField().click();
        // Close
        getDropdownTaskField().click();
        getCloseTask().click();
        getConfirmButton().click();
    }

}
