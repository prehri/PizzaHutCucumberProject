package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features/pizzahut.feature",
                  glue= {"stepDefinations"},   
                 dryRun=false,
                 monochrome=true,
                 plugin= {"pretty","html:test-output"},
                 tags= "@Smoke"
                 )
public class TestRunner {

}

