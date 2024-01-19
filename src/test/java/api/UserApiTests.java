package api;

import api.models.args.projects.ProjectInfo;
import api.models.args.tasks.TaskInfo;
import api.models.args.users.UserInfo;
import api.models.dynamic.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
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
import static api.steps.BaseApiSteps.performAuthorizedRequest;
import static api.steps.StatusCodeSteps.checkStatusCode;
import static io.restassured.RestAssured.given;

public class UserApiTests {
    private int userResult;
    private int taskResult;
    private int projectResult;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        String authHeaderUser = "Basic " + Base64.getEncoder().encodeToString((USER + ":" + PASSWORD).getBytes());
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
        Response createUserResponse = performAuthorizedRequest(createUser);
        System.out.println("Creating new User: " + userName );
        createUserResponse.prettyPrint();
        checkStatusCode(createUserResponse, 200, "Create User Status Code: ");
        userResult = createUserResponse.jsonPath().get("result");
        System.out.println("User created with Result: " + userResult);
    }
    @Test (priority = 2, dataProvider = "projectData", dataProviderClass = DynamicProjectTests.class)
    public void createProjectTest(String projectName){
        ProjectInfo.CreateProjectRequest createProject = ProjectInfo.CreateProjectRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_PROJECT)
                .id(USER_ID)
                .params(ProjectInfo.CreateProjectRequest.ParamsCreate.builder().name(projectName)
                        .description("Coursework").start_date("2024-01-01").end_date("2024-02-05").build())
                .build();
        Response createProjectResponse = performAuthorizedRequest(createProject);
        System.out.println("Creating project: " + projectName);
        createProjectResponse.prettyPrint();
        checkStatusCode(createProjectResponse, 200,"Create Project Status Code: ");
        projectResult = createProjectResponse.jsonPath().get("result");
        System.out.println("Project created with ID: " + projectResult);
    }
    @Test(priority = 3, dataProvider = "taskData", dataProviderClass = DynamicTaskTests.class)
    public void createTaskTest(String taskName) {
        TaskInfo.CreateTaskRequest createTask = TaskInfo.CreateTaskRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_TASK)
                .id(TASK_ID)
                .params(TaskInfo.CreateTaskRequest.ParamsCreate.builder().project_id(projectResult).title(taskName)
                        .description("Testing API").color_id("green").date_started("2024-01-18").build())
                .build();
        Response createTaskResponse = performAuthorizedRequest(createTask);
        System.out.println("Creating task: " + taskName);
        createTaskResponse.prettyPrint();
        checkStatusCode(createTaskResponse,200, "Create Task Status Code: ");
        taskResult = createTaskResponse.jsonPath().get("result");
        System.out.println("Task created with ID: " + taskResult);
    }
    @Test(priority = 4)
    public void removeTaskTest(){
        TaskInfo.RemoveTaskRequest removeTask = TaskInfo.RemoveTaskRequest.builder()
                .jsonrpc("2.0")
                .method(REMOVE_TASK)
                .id(TASK_ID)
                .params(TaskInfo.RemoveTaskRequest.ParamsRemote.builder().task_id(taskResult).build())
                .build();
        Response removeTaskResponse = performAuthorizedRequest(removeTask);
        removeTaskResponse.prettyPrint();
        checkStatusCode(removeTaskResponse, 200, "Remove Task Status Code: ");
        boolean taskResult = removeTaskResponse.jsonPath().get("result");
        System.out.println("Task removed with Result: " + taskResult);
    }
    @Test(priority = 5)
    public void removeProjectTest(){
        ProjectInfo.RemoveProjectRequest removeProject = ProjectInfo.RemoveProjectRequest.builder()
                .jsonrpc("2.0")
                .method(REMOVE_PROJECT)
                .id(PROJECT_ID)
                .params(ProjectInfo.RemoveProjectRequest.ParamsRemote.builder().project_id(projectResult).build())
                .build();
        Response removeProjectResponse = performAuthorizedRequest(removeProject);
        removeProjectResponse.prettyPrint();
        checkStatusCode(removeProjectResponse, 200, "Remove Project Status Code: ");
        boolean projectResult = removeProjectResponse.jsonPath().get("result");
        System.out.println("Project removed with Result: " + projectResult);
    }
    @Test(priority = 6)
    public void removeUserAsAdminTest() {
        UserInfo.RemoveUserRequest removeUser = UserInfo.RemoveUserRequest.builder()
                .jsonrpc("2.0")
                .method(DELETE_USER)
                .id(USER_ID)
                .params(UserInfo.RemoveUserRequest.ParamsRemote.builder().user_id(userResult).build())
                .build();
        Response removeUserResponse = performAuthorizedRequest(removeUser);
        removeUserResponse.prettyPrint();
        checkStatusCode(removeUserResponse, 200, "Remove User Status Code: ");
        boolean userResult = removeUserResponse.jsonPath().get("result");
        System.out.println("User removed with Result: " + userResult);
    }
}

