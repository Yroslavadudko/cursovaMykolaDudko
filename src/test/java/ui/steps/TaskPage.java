package ui.steps;

import static ui.elements.ProjectElements.*;
import static ui.elements.ProjectElements.saveField;
import static ui.elements.TaskElements.*;
import static ui.elements.TaskElements.confirmButton;
import static ui.steps.LoginPage.loginAsAdmin;

public class TaskPage {
    public static void createAndEditTasks(){
        loginAsAdmin();
        myProjects().click();
        dropdownProjectField().click();
        addNewTaskField().click();
        nameTaskField().setValue("MykolaDudko1");
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
