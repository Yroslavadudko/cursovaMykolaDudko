package api.steps;

import api.models.args.result.Result;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static Base.BasePage.*;
import static api.steps.StatusCodeSteps.checkStatusCode;
import static io.restassured.RestAssured.given;

public class BaseApiSteps {
    public static Result<?> performAuthorizedRequest(Object requestObject) {
        Response response = RestAssured.given()
                .auth().preemptive().basic(API_LOGIN, API_TOKEN)
                .contentType(ContentType.JSON)
                .body(requestObject)
                .when()
                .post(API_ENDPOINT);
        response.prettyPrint();
        checkStatusCode(response, 200, "Request Status Code");
        return response.as(Result.class);
    }
}




