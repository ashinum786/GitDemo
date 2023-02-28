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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TextContextSetup;

public class OffersPageStepDefinition {
	public WebDriver driver;
	public String landingpageproductName;
	public String offerpageproductName;
	PageObjectManager pageObjectManager;
	TextContextSetup test;
	public OffersPageStepDefinition(TextContextSetup test) {
		
		this.test=test;
	}
	
	
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortname) throws InterruptedException {
		switchToOffersPage();
		OffersPage offerspage=test.pageObjectManager.getOffersPage();
		Thread.sleep(2000);
		offerspage.searchItem(shortname);
		
		offerpageproductName=offerspage.getProductName();
		/*
		test.driver.findElement(By.id("search-field")).sendKeys(shortname);
		offerpageproductName=test.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();*/
	}
	
	public void switchToOffersPage() {
		//pageObjectManager = new PageObjectManager(test.driver);
		Landingpage landingpage=test.pageObjectManager.getLandingPage();
		landingpage.selectTopDealsPage();
		test.genericUtils.SwitchWindowToChild(); 
	}
	@Then("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(test.landingpageproductName, offerpageproductName);
	}
	}
