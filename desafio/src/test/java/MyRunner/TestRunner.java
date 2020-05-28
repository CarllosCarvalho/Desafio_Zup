package MyRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/Users/Carll/OneDrive/Documentos/ZupProjetoDesafio/desafio/src/test/java/Features/", 
				glue = {"StepDefinitions"}, monochrome = true, format={"pretty","html:test-outout"} )
public class TestRunner {
	
	
}

