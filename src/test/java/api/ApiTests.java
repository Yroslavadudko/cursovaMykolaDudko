package api;

import models.args.result.Result;
import models.args.projects.ProjectInfo;
import models.args.tasks.TaskInfo;
import models.args.users.UserInfo;
import config.Config;
import io.restassured.RestAssured;
import models.dynamic.DynamicProjectTests;
import models.dynamic.DynamicTaskTests;
import models.dynamic.DynamicUserTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Base64;
import static enums.UserRoles.MANAGER;
import static methods.Projects.CREATE_PROJECT;
import static methods.Projects.REMOVE_PROJECT;
import static methods.Tasks.CREATE_TASK;
import static methods.Tasks.REMOVE_TASK;
import static methods.Users.CREATE_USER;
import static methods.Users.DELETE_USER;
import static models.args.result.CreateResult.*;
import static steps.api.BaseApiSteps.performAuthorizedRequest;

public class ApiTests {
    public static String authHeaderUser;
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = Config.getBaseUrl();
        authHeaderUser = "Basic " + Base64.getEncoder()
                .encodeToString((Config.getUser() + ":" + Config.getPassword()).getBytes());
    }

    @Test(groups = "ApiProjectsTests", priority = 1, dataProvider = "userData", dataProviderClass = DynamicUserTests.class)
    public void createUserAsAdminTest(String userName) {
        UserInfo.CreateUserRequest createUser = UserInfo.CreateUserRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_USER)
                .id(Config.getUserId())
                .params(UserInfo.CreateUserRequest.ParamsCreate.builder()
                        .username(Config.getUserApi()).password(Config.getPasswordApi())
                        .name(userName).role(MANAGER.getRole()).email("dudkomykola@icloud.com").build())
                .build();
        Result result = performAuthorizedRequest(createUser);
        userResult = result.User_id();
        System.out.println("Creating new User: " + userName);
        System.out.println("User created with Result: " + userResult);
    }

    @Test(groups = "ApiProjectsTests", priority = 2, dataProvider = "projectData", dataProviderClass = DynamicProjectTests.class)
    public void createProjectTest(String projectName) {
        ProjectInfo.CreateProjectRequest createProject = ProjectInfo.CreateProjectRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_PROJECT)
                .id(Config.getUserId())
                .params(ProjectInfo.CreateProjectRequest.ParamsCreate.builder().name(projectName).description("Coursework")
                        .start_date("2024-01-01").end_date("2024-02-05").build())
                .build();
        Result result = performAuthorizedRequest(createProject);
        projectResult = result.Project_id();
        System.out.println("Creating new Project: " + projectName);
        System.out.println("Project created with Result: " + projectResult);
    }
    @Test(groups = "ApiProjectsTests", priority = 3, dataProvider = "taskData", dataProviderClass = DynamicTaskTests.class)
    public void createTaskTest(String taskName) {
        int resultProject_id = 0;
        TaskInfo.CreateTaskRequest createTask = TaskInfo.CreateTaskRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_TASK)
                .id(Config.getTaskId())
                .params(TaskInfo.CreateTaskRequest.ParamsCreate.builder().project_id(projectResult).title(taskName)
                        .description("Testing API").color_id("green").date_started("2024-01-18").build())
                .build();
        Result result = performAuthorizedRequest(createTask);
        taskResult = result.Task_id();
        System.out.println("Creating new Task: " + taskName);
        System.out.println("Task created with Result: " + taskResult);
    }
    @Test(groups = "ApiProjectsTests", priority = 4)
    public void removeTaskTest(){
        TaskInfo.RemoveTaskRequest removeTask = TaskInfo.RemoveTaskRequest.builder()
                .jsonrpc("2.0")
                .method(REMOVE_TASK)
                .id(Config.getTaskId())
                .params(TaskInfo.RemoveTaskRequest.ParamsRemote.builder().task_id(taskResult).build())
                .build();
        Result result = performAuthorizedRequest(removeTask);
        int resultWithId = result.Task_id();
        boolean taskRemovedResult = (boolean) result.getResult();
        System.out.println("Task removed with Result: " + resultWithId);
        System.out.println("Task removed result: " + taskRemovedResult);
    }
    @Test(groups = "ApiProjectsTests", priority = 5)
    public void removeProjectTest(){
        ProjectInfo.RemoveProjectRequest removeProject = ProjectInfo.RemoveProjectRequest.builder()
                .jsonrpc("2.0")
                .method(REMOVE_PROJECT)
                .id(Config.getProjectId())
                .params(ProjectInfo.RemoveProjectRequest.ParamsRemote.builder().project_id(projectResult).build())
                .build();
        Result result = performAuthorizedRequest(removeProject);
        int resultWithId = result.Project_id();
        boolean projectRemovedResult = (boolean) result.getResult();
        System.out.println("Project removed with Result: " + resultWithId);
        System.out.println("Project removed result: " + projectRemovedResult);
    }
    @Test(groups = "ApiProjectsTests", priority = 6)
    public void removeUserAsAdminTest() {
        UserInfo.RemoveUserRequest removeUser = UserInfo.RemoveUserRequest.builder()
                .jsonrpc("2.0")
                .method(DELETE_USER)
                .id(Config.getUserId())
                .params(UserInfo.RemoveUserRequest.ParamsRemote.builder().user_id(userResult).build())
                .build();
        Result result = performAuthorizedRequest(removeUser);
        int resultWithId = result.User_id();
        boolean userRemovedResult = (boolean) result.getResult();
        System.out.println("User removed with Result: " + resultWithId);
        System.out.println("User removed result: " + userRemovedResult);
    }
}

