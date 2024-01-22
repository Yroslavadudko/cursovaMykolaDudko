package ui.testsUi;

import api.models.dynamic.DynamicTaskTests;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.BasePage.BASE_URL;
import static ui.elements.ProjectElements.*;
import static ui.elements.TaskElements.*;
import static ui.steps.LoginPage.loginAsAdmin;

public class TasksUiTests extends BaseTests {
    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = BASE_URL;
    }

    @Test(groups = "UiProjectsTests", priority = 4, dataProvider = "taskData", dataProviderClass = DynamicTaskTests.class)
    public void createTaskTest(String taskName){
        // Task creation
        loginAsAdmin();
        myProjects().click();
        dropdownProjectField().click();
        addNewTaskField().click();
        nameTaskField().setValue(taskName);
        saveField().click();
        // Edit
        dropdownTaskField().click();
        editTask().click();
        newCommentTask().setValue("Close this Task");
        dropdownColorTask().click();
        colorTaskPurple().click();
        dropdownAssigneeTask().click();
        assigneeAdminTask().click();
        dropdownPriorityTask().click();
        priorityLowTask().click();
        saveField().click();
        // Close
        dropdownTaskField().click();
        closeTask().click();
        confirmButton().click();
    }
}
