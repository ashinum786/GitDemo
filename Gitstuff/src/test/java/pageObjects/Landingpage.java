package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Landingpage {
	public WebDriver driver;
	public Landingpage(WebDriver driver) {
		this.driver=driver;
	}
	By search=By.className("search-keyword");
	By productName=By.cssSelector("h4.product-name");
	By topDeals=By.linkText("Top Deals");
	By increment=By.cssSelector("a.increment");
	By addToCart=By.cssSelector(".product-action button");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	public void getsearchText() {
		driver.findElement(search).getText();
	}
	public void incrementQuantity(int quantity) {
		
		int i=quantity-1;
		while(i>0) {
			driver.findElement(increment).click();
			i--;
		}
	}
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	public String getTitleLandingpage() {
		return driver.getTitle();
	}
}
