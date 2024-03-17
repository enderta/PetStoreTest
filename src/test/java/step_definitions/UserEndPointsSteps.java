package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.payloadGenerator;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class UserEndPointsSteps {
    private Response response;
    private Map<String, Object> userPayload;
    private String username;
    Faker faker = new Faker();

    @Given("I have a valid user payload")
    public void iHaveAValidUserPayload() {
        userPayload = payloadGenerator.getPayload();
        username = (String) userPayload.get("username");
    }

    @When("I send a {string} request to {string} endpoint")
    public void iSendARequestToEndpoint(String method, String endpoint) {
        if (method.equalsIgnoreCase("POST")) {
            endpoint = "/user";
        } else {
            username = userPayload.get("username").toString();
            endpoint = "/user/" + username;
        }
        sendRequest(method, endpoint, userPayload);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }


    private void sendRequest(String method, String endpoint, Map<String, Object> payload) {

        if (method.equalsIgnoreCase("POST")) {
            response = given().contentType(ContentType.JSON)
                    .and().body(payload)
                    .when().post(endpoint);

        } else if (method.equalsIgnoreCase("GET")) {
            response = given().contentType(ContentType.JSON)
                    .when().get(endpoint);

        } else if (method.equalsIgnoreCase("PUT")) {
            payload.put("firstName", faker.name().firstName());
            payload.put("lastName", faker.name().lastName());
            payload.put("username", payload.get("firstName") + "." + payload.get("lastName"));
            response = given().contentType(ContentType.JSON)
                    .and().body(payload)
                    .when().put(endpoint);

        } else if (method.equalsIgnoreCase("DELETE")) {
            response = given().contentType(ContentType.JSON)
                    .when().delete(endpoint);
        }

    }

}