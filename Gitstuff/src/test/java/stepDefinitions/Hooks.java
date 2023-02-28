package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TextContextSetup;

public class Hooks {
	TextContextSetup test; 
	public Hooks(TextContextSetup test) {
		this.test=test;
		
	}
	@After
	public void AfterScenario() throws IOException {
		test.testBase.WebDriverManager().quit();
	}
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver=test.testBase.WebDriverManager();
		if(scenario.isFailed()) {
			File srcpath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		}
	
	}
}
