package steps.ui;

import static elements.ProjectElements.*;
import static elements.ProjectElements.saveField;
import static elements.TaskElements.*;
import static elements.TaskElements.confirmButton;
import static steps.ui.LoginPage.loginAsAdmin;

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
