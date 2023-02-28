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
import pageObjects.Checkoutpage;
import pageObjects.Landingpage;
import utils.TextContextSetup;

public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String landingpageproductName;
	public String offerpageproductName;
	TextContextSetup test;
	public Checkoutpage checkoutpage;
	Landingpage landingpage;
	public CheckoutPageStepDefinition(TextContextSetup test)
	{
		this.test=test;
		this.landingpage=test.pageObjectManager.getLandingPage();
		this.checkoutpage=test.pageObjectManager.getCheckoutPage();
	}
	@Then("verify user has ability to enter promo code and place the order")
	
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
	
		Assert.assertTrue(checkoutpage.verifyPromoBtn());
		Assert.assertTrue(checkoutpage.verifyPlaceOrderBtn());
	}
	@Then("^User proceeds to Checkout And Validate the (.+) items in checkout page$")
	public void user_proceeds_to_Checkout(String name) throws InterruptedException {
		checkoutpage.CheckOutItems();
	}
	
	@When("^Added (.+) items of the selected product to cart$")
	public void Added_items_product(String quantity) {
		landingpage.incrementQuantity(3);
		landingpage.addToCart();
	}
	}
