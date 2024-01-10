package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/apifeature",//feature files
        glue = "", //step definitions
        dryRun = false,//getting snips without executing and updating test. 
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class CucumberTestRunner {


}
