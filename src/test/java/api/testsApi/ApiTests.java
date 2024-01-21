package api.testsApi;

import api.models.args.result.Result;
import api.models.args.projects.ProjectInfo;
import api.models.args.tasks.TaskInfo;
import api.models.args.users.UserInfo;
import api.models.dynamic.*;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Base64;
import static Base.BasePage.*;
import static api.enums.UserRoles.MANAGER;
import static api.methods.Projects.CREATE_PROJECT;
import static api.methods.Projects.REMOVE_PROJECT;
import static api.methods.Tasks.CREATE_TASK;
import static api.methods.Tasks.REMOVE_TASK;
import static api.methods.Users.CREATE_USER;
import static api.methods.Users.DELETE_USER;
import static api.models.args.result.CreateResult.*;
import static api.steps.BaseApiSteps.performAuthorizedRequest;

public class ApiTests {
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        authHeaderUser = "Basic " + Base64.getEncoder().encodeToString((USER + ":" + PASSWORD).getBytes());
    }

    @Test(priority = 1, dataProvider = "userData", dataProviderClass = DynamicUserTests.class)
    public void createUserAsAdminTest(String userName) {
        UserInfo.CreateUserRequest createUser = UserInfo.CreateUserRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_USER)
                .id(USER_ID)
                .params(UserInfo.CreateUserRequest.ParamsCreate.builder().username(USER_API).password(PASSWORD_API)
                        .name(userName).role(MANAGER.getRole()).email("dudkomykola@icloud.com").build())
                .build();
        Result result = performAuthorizedRequest(createUser);
        userResult = result.User_id();
        System.out.println("Creating new User: " + userName);
        System.out.println("User created with Result: " + userResult);
    }

    @Test(priority = 2, dataProvider = "projectData", dataProviderClass = DynamicProjectTests.class)
    public void createProjectTest(String projectName) {
        ProjectInfo.CreateProjectRequest createProject = ProjectInfo.CreateProjectRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_PROJECT)
                .id(USER_ID)
                .params(ProjectInfo.CreateProjectRequest.ParamsCreate.builder().name(projectName).description("Coursework")
                        .start_date("2024-01-01").end_date("2024-02-05").build())
                .build();
        Result result = performAuthorizedRequest(createProject);
        projectResult = result.Project_id();
        System.out.println("Creating new Project: " + projectName);
        System.out.println("Project created with Result: " + projectResult);
    }
    @Test(priority = 3, dataProvider = "taskData", dataProviderClass = DynamicTaskTests.class)
    public void createTaskTest(String taskName) {
        int resultProject_id = 0;
        TaskInfo.CreateTaskRequest createTask = TaskInfo.CreateTaskRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_TASK)
                .id(TASK_ID)
                .params(TaskInfo.CreateTaskRequest.ParamsCreate.builder().project_id(projectResult).title(taskName)
                        .description("Testing API").color_id("green").date_started("2024-01-18").build())
                .build();
        Result result = performAuthorizedRequest(createTask);
        taskResult = result.Task_id();
        System.out.println("Creating new Task: " + taskName);
        System.out.println("Task created with Result: " + taskResult);
    }
    @Test(priority = 4)
    public void removeTaskTest(){
        TaskInfo.RemoveTaskRequest removeTask = TaskInfo.RemoveTaskRequest.builder()
                .jsonrpc("2.0")
                .method(REMOVE_TASK)
                .id(TASK_ID)
                .params(TaskInfo.RemoveTaskRequest.ParamsRemote.builder().task_id(taskResult).build())
                .build();
        Result result = performAuthorizedRequest(removeTask);
        int resultWithId = result.Task_id();
        boolean taskRemovedResult = (boolean) result.getResult();
        System.out.println("Task removed with Result: " + resultWithId);
        System.out.println("Task removed result: " + taskRemovedResult);
    }
    @Test(priority = 5)
    public void removeProjectTest(){
        ProjectInfo.RemoveProjectRequest removeProject = ProjectInfo.RemoveProjectRequest.builder()
                .jsonrpc("2.0")
                .method(REMOVE_PROJECT)
                .id(PROJECT_ID)
                .params(ProjectInfo.RemoveProjectRequest.ParamsRemote.builder().project_id(projectResult).build())
                .build();
        Result result = performAuthorizedRequest(removeProject);
        int resultWithId = result.Project_id();
        boolean projectRemovedResult = (boolean) result.getResult();
        System.out.println("Project removed with Result: " + resultWithId);
        System.out.println("Project removed result: " + projectRemovedResult);
    }
    @Test(priority = 6)
    public void removeUserAsAdminTest() {
        UserInfo.RemoveUserRequest removeUser = UserInfo.RemoveUserRequest.builder()
                .jsonrpc("2.0")
                .method(DELETE_USER)
                .id(USER_ID)
                .params(UserInfo.RemoveUserRequest.ParamsRemote.builder().user_id(userResult).build())
                .build();
        Result result = performAuthorizedRequest(removeUser);
        int resultWithId = result.User_id();
        boolean userRemovedResult = (boolean) result.getResult();
        System.out.println("User removed with Result: " + resultWithId);
        System.out.println("User removed result: " + userRemovedResult);
    }
}

