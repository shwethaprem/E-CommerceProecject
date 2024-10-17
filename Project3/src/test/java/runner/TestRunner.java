package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features ="src/test/resources1/features",
		glue = {"stepdefinitions","hooks"},
		tags="@checkout1",
		plugin = {"pretty",
				"html:target/CucumberReport.html",
				"json:target/CucumberReport.json",
				"junit:target/CucumberReport.xml"
				}
		
		
		 
		)


public class TestRunner {

}
