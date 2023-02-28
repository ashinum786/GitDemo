package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Landingpage;
import utils.TextContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingpageproductName;
	public String offerpageproductName;
	TextContextSetup test;
	Landingpage landingpage;
	public LandingPageStepDefinition(TextContextSetup test)
	{
		this.test=test;
		this.landingpage=test.pageObjectManager.getLandingPage();
	}
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingpage.getTitleLandingpage().contains("GreenKart"));
	}
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
	
		landingpage.searchItem(shortname);
	    Thread.sleep(2000);
	    test.landingpageproductName=landingpage.getProductName().split("-")[0].trim();
	    System.out.println(landingpageproductName+" is extracted from Home page ");
	}
	
	}
