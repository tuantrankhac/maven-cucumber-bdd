package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\features",
		glue = "stepDefinitions",
		monochrome = true,
		plugin = { "pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber.json" },
		snippets = SnippetType.CAMELCASE,
		tags =  "@parameter"
		
		)

public class TestRunner {

}
