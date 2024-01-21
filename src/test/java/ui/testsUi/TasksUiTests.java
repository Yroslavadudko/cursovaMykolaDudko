package ui.testsUi;

import api.models.dynamic.DynamicTaskTests;
import org.testng.annotations.Test;

import static ui.elements.ProjectElements.*;
import static ui.elements.TaskElements.*;
import static ui.steps.LoginPage.loginAsAdmin;

public class TasksUiTests extends BaseTest {

    @Test(priority = 4, groups = "UiProjectsTests", dataProvider = "taskData", dataProviderClass = DynamicTaskTests.class)
    public void createTaskTest(String taskName){
        // Task creation
        loginAsAdmin();
        myProjects().click();
        dropdownProjectField().click();
        addNewTaskField().click();
        nameTaskField().setValue(taskName);
        saveField().click();
        // Edit the Task
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
