package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/AddNewClient.feature",//feature files
        glue = "", //step definitions
        dryRun = false,//getting snips without executing and updating test. 
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt","json:target/cucumber-report.json"}
)
public class CucumberTestRunner {

    // We must have maven installed in our computer.
    // we need to use mvn clean test
    // We need update our pom.xml file. We should add maven-surefire-plugin

}
