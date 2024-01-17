package CursovaApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Base64;

import static Base.BasePage.*;
import static io.restassured.RestAssured.given;

public class TaskApiTests {
    private int taskResult;
    private String authHeaderTask;
    private String taskTitle;


    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        authHeaderTask = "Basic " + Base64.getEncoder().encodeToString((USER + ":" + PASSWORD).getBytes());
    }

    @Test
    public void createTaskTest() {
        String createTaskRequest = buildCreateTaskRequest();

        Response createTaskResponse = given()
                .header("Authorization", authHeaderTask)
                .contentType(ContentType.JSON)
                .body(createTaskRequest)
                .post(API_ENDPOINT);

        createTaskResponse.prettyPrint();

        int createTaskStatusCode = createTaskResponse.getStatusCode();
        System.out.println("Create Task Status Code: " + createTaskStatusCode);

        Assert.assertEquals(createTaskStatusCode, 200, "Failed to create a new task");

        taskResult = createTaskResponse.jsonPath().get("result");
        System.out.println("Task created with ID: " + taskResult);
    }

    @Test
    public void removeTaskTest() {
        String removeTaskRequest = buildRemoveTaskRequest(taskResult);

        Response removeTaskResponse = given()
                .header("Authorization", authHeaderTask)
                .contentType(ContentType.JSON)
                .body(removeTaskRequest)
                .delete(API_ENDPOINT);

        removeTaskResponse.prettyPrint();

        int removeTaskStatusCode = removeTaskResponse.getStatusCode();
        System.out.println("Remove Task Status Code: " + removeTaskStatusCode);
        Assert.assertEquals(removeTaskStatusCode, 200, "Failed to remove the task");

        boolean removeTaskResult = removeTaskResponse.jsonPath().get("result");
        System.out.println("Task removed with Result: " + removeTaskResult);
    }

    private String buildCreateTaskRequest() {
        this.taskTitle = taskTitle;
        return "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"createTask\",\n" +
                "    \"id\": 11765090,\n" +
                "    \"params\": {\n" +
                "        \"title\": \"" + taskTitle +"\",\n" +
                "        \"project_id\": 15,\n" +
                "        \"color_id\": \"green\",\n" +
                "    }\n" +
                "}";
    }

    private String buildRemoveTaskRequest(int taskId) {
        return "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"removeTask\",\n" +
                "    \"id\": 1515,\n" +
                "    \"params\": {\n" +
                "        \"task_id\": " + taskId + "\n" +
                "    }\n" +
                "}";
    }
}

