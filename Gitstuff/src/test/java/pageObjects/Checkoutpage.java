package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkoutpage {
	public WebDriver driver;
	
	
	public Checkoutpage(WebDriver driver) {
		this.driver=driver;
	}
	By cartBag=By.xpath("//img[@alt='Cart']");
	By checkOutBtn=By.xpath("//button[contains(text(),\"PROCEED TO CHECKOUT\")]");
	By promoBtn=By.cssSelector(".promoBtn");
	By placeOrder=By.xpath("//button[contains(text(),\"Place Order\")]");
	
	
	public void CheckOutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutBtn).click();
	}
	
	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	public boolean verifyPlaceOrderBtn() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
}
