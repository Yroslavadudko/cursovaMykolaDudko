package steps.api;

import models.args.result.Result;
import config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import static steps.api.StatusCodeSteps.checkStatusCode;

public class BaseApiSteps {
    public static Result<?> performAuthorizedRequest(Object requestObject) {
        Response response = RestAssured.given()
                .auth().preemptive().basic(Config.getApiLogin(), Config.getApiToken())
                .contentType(ContentType.JSON)
                .body(requestObject)
                .when()
                .post(Config.getApiEndpoint());
        response.prettyPrint();
        checkStatusCode(response, 200, "Request Status Code");
        return response.as(Result.class);
    }
}




