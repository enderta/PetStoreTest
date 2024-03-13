package step_definitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.payloadGenerator;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class CRUDSteps {
    private Response response;
    private Map<String, Object> userPayload;
    private String userID;
    private String username;

    @Given("I have a valid user payload")
    public void iHaveAValidUserPayload() {
        userPayload = payloadGenerator.getPayload();
        username = (String) userPayload.get("username");
    }

    @When("I send a {string} request to {string} endpoint")
    public void iSendARequestToEndpoint(String method, String endpoint) {
        if(method.equalsIgnoreCase("POST")){
            endpoint= "/user";
        }
        else {
            endpoint = "/user/"+username;

        }
        sendRequest(method, endpoint, userPayload);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain the {string} for {string}")
    public void theResponseShouldContainTheFor(String data, String requestType) {
        if(requestType.equalsIgnoreCase("POST")) {
            Assert.assertEquals(userID, response.jsonPath().getString(data));
        } else {
            Assert.assertEquals(userID, response.jsonPath().getString(data));
        }
    }

    private void sendRequest(String method, String endpoint, Map<String, Object> payload) {
        if (method.equalsIgnoreCase("POST")) {
            response = given().contentType(ContentType.JSON)
                    .and().body(payload)
                    .when().post(endpoint);
            userID = response.jsonPath().getString("message");
        } else if (method.equalsIgnoreCase("GET")) {
            response = given().contentType(ContentType.JSON)
                    .when().get(endpoint);
            userID = response.jsonPath().getString("userID");
        } else if (method.equalsIgnoreCase("PUT")) {
            response = given().contentType(ContentType.JSON)
                    .and().body(payload)
                    .when().put(endpoint);
        } else if (method.equalsIgnoreCase("DELETE")) {
            response = given().contentType(ContentType.JSON)
                    .when().delete(endpoint);
        }
    }

}