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

public class UserApiTests {
    private int userResult;
    private String authHeader;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
        authHeader = "Basic " + Base64.getEncoder().encodeToString((USER + ":" + PASSWORD).getBytes());
    }

    @Test
    public void createUserAsAdminTest() {
        String createUserRequest = buildCreateUserRequest();

        Response createUserResponse = given()
                .header("Authorization", authHeader)
                .contentType(ContentType.JSON)
                .body(createUserRequest)
                .post(API_ENDPOINT);

        createUserResponse.prettyPrint();

        int createUserStatusCode = createUserResponse.getStatusCode();
        System.out.println("Create User Status Code: " + createUserStatusCode);

        Assert.assertEquals(createUserStatusCode, 200, "Failed to create a new user");

        userResult = createUserResponse.jsonPath().get("result");
        System.out.println("User created with Result: " + userResult);
    }

    @Test
    public void removeUserAsAdminTest() {
        String removeUserRequest = buildRemoveUserRequest();

        Response removeUserResponse = given()
                .header("Authorization", authHeader)
                .contentType(ContentType.JSON)
                .body(removeUserRequest)
                .delete(API_ENDPOINT);

        removeUserResponse.prettyPrint();

        int removeUserStatusCode = removeUserResponse.getStatusCode();
        System.out.println("Remove User Status Code: " + removeUserStatusCode);
        Assert.assertEquals(removeUserStatusCode, 200, "Failed to remove the user");

        boolean removeUserResult = removeUserResponse.jsonPath().get("result");
        System.out.println("User removed with Result: " + removeUserResult);
    }

    private String buildCreateUserRequest() {
        return "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"createUser\",\n" +
                "    \"id\": " + USER_ID + ",\n" +
                "    \"params\": {\n" +
                "        \"username\": \"" + USER_API + "\",\n" +
                "        \"password\": \"" + PASSWORD_API + "\"\n" +
                "    }\n" +
                "}";
    }

    private String buildRemoveUserRequest() {
        return "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"removeUser\",\n" +
                "    \"id\": " + USER_ID + ",\n" +
                "    \"params\": {\n" +
                "        \"user_id\": " + userResult + "\n" +
                "    }\n" +
                "}";
    }
}

