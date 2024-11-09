package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {  "pretty",
                //json report
                "json:target/cucumber.json",
                //html report
                "html:target/default-html-reports.html",
                //junit report
                "junit:target/cucumber.xml",
        },
        features = "src/resources/features",
        glue = "step_definitions",
        dryRun = false,
        tags = "@wip"

)
public class CukesRunner {
}