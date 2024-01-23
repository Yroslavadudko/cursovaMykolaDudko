package ui.steps;

import static ui.elements.ProjectElements.*;
import static ui.elements.ProjectElements.removeProjectField;
import static ui.elements.TaskElements.confirmButton;
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
