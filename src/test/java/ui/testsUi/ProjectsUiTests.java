package ui.testsUi;

import api.models.dynamic.DynamicProjectTests;
import org.testng.annotations.Test;
import static ui.elements.ProjectElements.*;
import static ui.elements.TaskElements.confirmButton;
import static ui.steps.LoginPage.loginAsAdmin;

public class ProjectsUiTests extends BaseTest {


    @Test(priority = 3, groups = "UiProjectsTests",
            dataProvider = "projectData", dataProviderClass = DynamicProjectTests.class)
    public void createProjectTest(String projectName) {
        // Project creation
        loginAsAdmin();
        newProjectField().click();
        formNameProjectField().setValue(projectName);
        identifierProjectField().setValue("MYPROJECT");
        columnTaskProjectField().click();
        formTaskLimitField().setValue("4");
        saveField().click();
        System.out.println("Project Name: " + projectName);
    }
    @Test(priority = 5, groups = "UiProjectsTests")
    public void removeProjectsTest(){
        // Project remove
        loginAsAdmin();
        myProjects().click();
        dropdownProjectField().click();
        configureProject().click();
        removeProjectField().click();
        confirmButton().click();
    }
}
