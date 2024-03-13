package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;

public class Hooks {


    @Before()
    public void setUp() {
        baseURI = ConfigurationReader.get("base_url");
    }

    @After()
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Test failed!");
        } else {
            System.out.println("Cleanup!");
        }
    }


}


