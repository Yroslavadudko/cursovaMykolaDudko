package ui;

import data.dynamic.DynamicProjectTests;
import org.testng.annotations.Test;
import static elements.ProjectElements.*;
import static steps.ui.LoginPage.loginAsAdmin;
import static steps.ui.ProjectPage.removeProject;
import static steps.ui.TaskPage.createAndEditTasks;

public class ProjectsUiTest extends BaseTest {

    @Test(groups = "UiProjectsTests", priority = 1,
            dataProvider = "projectData", dataProviderClass = DynamicProjectTests.class)
    public void createProjectTest(String projectName) {
        // Project creation
        loginAsAdmin();
        newProjectField().click();
        formNameProjectField().setValue(projectName);
        identifierProjectField().setValue("MYPROJECTS");
        columnTaskProjectField().click();
        formTaskLimitField().setValue("4");
        saveField().click();
        System.out.println("Project Name: " + projectName);
    }
    @Test(groups = "UiProjectsTests", priority = 2)
    public void createTaskTest(){
        // Create/edit/remove the Task
        createAndEditTasks();
    }
    @Test(groups = "UiProjectsTests", priority = 3)
    public void removeProjectsTest(){
        // Project remove
        removeProject();
    }
}
