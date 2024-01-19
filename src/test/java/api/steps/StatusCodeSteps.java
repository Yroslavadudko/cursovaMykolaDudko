package api.steps;

import io.restassured.response.Response;
import org.testng.Assert;

public class StatusCodeSteps {
    public static void checkStatusCode(Response response, int expectedStatusCode, String message) {
        int actualStatusCode = response.getStatusCode();
        System.out.println(message + ": " + actualStatusCode);
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Failed: " + message);
    }
}

