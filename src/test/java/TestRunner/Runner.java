package TestRunner;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "features",
        glue = "stepDefinitions",
        monochrome = true
)

public class Runner 

{


}
