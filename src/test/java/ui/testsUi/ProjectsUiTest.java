package ui.testsUi;

import api.models.dynamic.DynamicProjectTests;
import org.testng.annotations.Test;
import static ui.elements.ProjectElements.*;
import static ui.steps.LoginPage.loginAsAdmin;
import static ui.steps.ProjectPage.removeProject;
import static ui.steps.TaskPage.createAndEditTasks;

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
