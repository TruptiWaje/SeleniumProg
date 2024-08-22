//Dynamic Xpath
package mpack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ebay extends Base
{ 
	public String getResult()
	{
		String element = driver.findElement(By.cssSelector(".srp-controls__count-heading")).getText();
		return element;
	}
	public List<WebElement> getAllProduct()
	{
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']//li"));
		System.out.println("The list of product on first page: ");
		for (WebElement element : elements) {
			System.out.println("**********************************\n"+element.getText());
	}
		return elements;
}
	public WebElement getNthProduct(String productPath, int n)
	{
		List<WebElement> list = driver.findElements(By.cssSelector(productPath));
		if(list.size()>=n)
		{
			return list.get(n+1);
		}
		else
		{
			return null;
		}

	}
	public static void main(String[] args)
	{
		Ebay ass4 = new Ebay();
		ass4.initializeDriver("firefox");
		driver.get("https://www.ebay.com/");
		driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Smart Watches");
		driver.findElement(By.xpath("//select[@id='gh-cat']//option[contains(text(),'Baby')]")).click();
		driver.findElement(By.cssSelector("#gh-btn")).click();
		// to get all product on first page
		System.out.println(ass4.getResult());
		// to get nth product on the page
		System.out.println("The product at Nth position: \n*******************************\n"+ass4.getNthProduct(".s-item.s-item__pl-on-bottom", 60).getText()+"\n");
		ass4.getAllProduct();
		ass4.closeBrowser();
	}

}
