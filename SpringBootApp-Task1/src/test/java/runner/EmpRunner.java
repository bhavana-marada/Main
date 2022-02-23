package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "emp.feature" , 
	glue = {"definition"}, 
	plugin = {"pretty"})
public class EmpRunner {
	
}
