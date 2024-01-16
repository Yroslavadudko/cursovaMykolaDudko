package CursovaApi;

import Models.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.BasePage.*;


public class LoginApiTests {
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }
    @Test
    public void authorizationTest() {
            LoginRequest loginRequest = LoginRequest.builder()
                    .user("your_username")
                    .password("your_password")
                    .build();

            Response authResponse = RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .body("{ \"username\": \"" + USER + "\", \"password\": \"" + PASSWORD + "\" }")
                    .post(LOGIN_ENDPOINT);

            int statusCode = authResponse.getStatusCode();
            System.out.println("Status Code: " + statusCode);
            Assert.assertEquals(authResponse.getStatusCode(), 200, "Failed to obtain authentication token");
            Cookie authToken = new Cookie.Builder("token", authResponse.getCookies().get("token")).build();
        }
    }

