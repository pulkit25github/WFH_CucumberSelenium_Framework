package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (
   
      //  	  features= {".//Features/Login.feature", ".//Features/AddCustomer.feature"},     //Multiple Files
     //       features= ".//Features/AddCustomer.feature",                                    //Single File
        	  features= ".//Features/", 
        	  glue = {"stepDefinitions"},
              monochrome = true,
              dryRun = false,
              tags= "@All",
   //           tags = {"@smoke", "@sanity", "@regression"},     // execution failed if error found in tags= AND operator
   //           tags = {"@smoke, @sanity, @regression"},     // execution not failed if error found in tag= OR operator
   
          plugin = {"pretty" , "html:test-output/Cucumber-Reports/report.html"}
  //           plugin = {"json:target/cucumber.json"}	// For HTML Report: through cmd  (mvn clean verify)
        	  
   //     	 publish = true      // if you want to publish report on cucumber portal
        		)


public class TestRun {

}
