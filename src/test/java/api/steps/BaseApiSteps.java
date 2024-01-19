package api.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Base.BasePage.*;
import static io.restassured.RestAssured.given;

public class BaseApiSteps {
    public static Response performAuthorizedRequest(Object requestObject) {
        return given()
                .auth().preemptive().basic(API_LOGIN, API_TOKEN)
                .contentType(ContentType.JSON)
                .body(requestObject)
                .post(API_ENDPOINT);
    }
}
