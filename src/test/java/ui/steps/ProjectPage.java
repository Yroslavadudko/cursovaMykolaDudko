package ui.steps;

import static elements.ProjectElements.*;
import static elements.ProjectElements.removeProjectField;
import static elements.TaskElements.confirmButton;
import static ui.steps.LoginPage.loginAsAdmin;

public class ProjectPage {
    public static void removeProject(){
        loginAsAdmin();
        myProjects().click();
        dropdownProjectField().click();
        configureProject().click();
        removeProjectField().click();
        confirmButton().click();
    }
}
