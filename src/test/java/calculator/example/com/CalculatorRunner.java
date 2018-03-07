package calculator.example.com;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/html/" }, 
		features = {"src/test/java/calculator/features/calculator.feature" },
		glue = {"stepDefinion.example.com"})

public class CalculatorRunner {

	
	

	}


