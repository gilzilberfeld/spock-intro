package spock.intro;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		"pretty" }, 
		features = "src/test/resources", 
		glue = "spock.intro.cucumber", 
		monochrome = true)
public class D03_CucumberAvengers {

}
