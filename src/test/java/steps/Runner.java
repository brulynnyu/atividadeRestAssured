package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "/src/test/resources/features/",
                plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
                glue = {"steps"}
        )

public class Runner extends AbstractTestNGCucumberTests {

}
