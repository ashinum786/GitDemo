package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	public WebDriver driver;
	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}
	By search=By.id("search-field");
	//By productName=By.cssSelector("h4.product-name");
	By productName=By.xpath("//*[@id='root']/div/div/div/div/div/div/table/tbody/tr/td[1]");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	public void getsearchText() {
		driver.findElement(search).getText();
	}
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
}
