package desafio.mobile.inmetricsRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-report", 
				"json:target/cucumber-report/cucumber.json", 
				"io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"},
		features = "src/test/resources/features/",
		glue = "desafio.mobile.inmetricsSteps",
		dryRun = false,
		tags = {"@CE009_Realizar_compra"},
		snippets = SnippetType.CAMELCASE,
		strict = false,
		monochrome = true
		)

public class AllTesteRunner {

}
