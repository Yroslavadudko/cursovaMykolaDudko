package CursovaApi;

import CursovaApi.Models.CreateTaskRequest;
import CursovaApi.Models.CreateUserRequest;
import CursovaApi.Models.RemoveUserRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Base64;

import static Base.BasePage.*;
import static io.restassured.RestAssured.given;

public class UserApiTests<NewUserRequest> {

    private String authHeaderUser;
    private int userResult;
    private int taskResult;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        authHeaderUser = "Basic " + Base64.getEncoder().encodeToString((USER + ":" + PASSWORD).getBytes());
    }

    @Test(priority = 1)
    public void createUserAsAdminTest() {

        CreateUserRequest createUser = CreateUserRequest.builder()
                .jsonrpc("2.0")
                .method("createUser")
                .id(USER_ID)
                .params(CreateUserRequest.ParamsCreate.builder().username(USER_API).password(PASSWORD_API).build())
                .build();
        Response createUserResponse = given()
                .header("Authorization", authHeaderUser)
                .contentType(ContentType.JSON)
                .body(createUser)
                .post(API_ENDPOINT);

        createUserResponse.prettyPrint();

        int createUserStatusCode = createUserResponse.getStatusCode();
        System.out.println("Create User Status Code: " + createUserStatusCode);

        Assert.assertEquals(createUserStatusCode, 200, "Failed to create a new user");

        userResult = createUserResponse.jsonPath().get("result");
        System.out.println("User created with Result: " + userResult);
    }
    @Test(priority = 2)
    public void createTaskTest() {
        CreateTaskRequest createTask = CreateTaskRequest.builder()
                .jsonrpc("2.0")
                .method("createTask")
                .id(USER_ID)
                .params(CreateTaskRequest.ParamsCreate.builder().project_id(15).title("ApiRest").color_id("green").build())
                .build();
        Response createTaskResponse = given()
                .auth().preemptive().basic(USER_API, PASSWORD_API)
                .contentType(ContentType.JSON)
                .body(createTask)
                .post(API_ENDPOINT);

        createTaskResponse.prettyPrint();

        int createTaskStatusCode = createTaskResponse.getStatusCode();
        System.out.println("Create Task Status Code: " + createTaskStatusCode);

        Assert.assertEquals(createTaskStatusCode, 200, "Failed to create a new task");

        taskResult = createTaskResponse.jsonPath().get("result");
        System.out.println("Task created with ID: " + taskResult);
    }

    @Test(priority = 3)
    public void removeUserAsAdminTest() {
        RemoveUserRequest removeUser = RemoveUserRequest.builder()
                .jsonrpc("2.0")
                .method("removeUser")
                .id(USER_ID)
                .params(RemoveUserRequest.ParamsRemote.builder().user_id(userResult).build())
                .build();

        Response removeUserResponse = given()
                .contentType(ContentType.JSON)
                .body(removeUser)
                .delete(API_ENDPOINT);

        removeUserResponse.prettyPrint();

        int removeUserStatusCode = removeUserResponse.getStatusCode();
        System.out.println("Remove User Status Code: " + removeUserStatusCode);
        Assert.assertEquals(removeUserStatusCode, 200, "Failed to remove the user");

        boolean userResult = removeUserResponse.jsonPath().get("result");
        System.out.println("User removed with Result: " + userResult);
    }

}

