package Cursova;

import Base.BasePage;
import Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TaskUiTests extends BasePage {

    @BeforeClass
    public static void setUp() {
        BaseTest.setUpClass();
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
