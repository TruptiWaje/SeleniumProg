//Dynamic Xpath
package mpack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignement4 {
	static WebDriver driver =null;

	public static WebDriver startbrowser(String browser_name)
	{

		if(browser_name.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("Safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}

		return driver;

	}
	public String getresult()
	{

		String element = driver.findElement(By.cssSelector(".srp-controls__count-heading")).getText();
		return element;

	}
	public List<WebElement> getallproduct()
	{
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']//li"));
		System.out.println("The list of product on first page: ");
		for (WebElement element : elements) {
			System.out.println("**********************************\n"+element.getText());
		}
		return elements;
	}

	public WebElement getNthproduct(String productpath, int n)
	{
		List<WebElement> list = driver.findElements(By.cssSelector(productpath));
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
		WebDriver driver = startbrowser("firefox");
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Smart Watches");
		driver.findElement(By.xpath("//select[@id='gh-cat']//option[contains(text(),'Baby')]")).click();
		driver.findElement(By.cssSelector("#gh-btn")).click();

		// to get all product on first page
		Assignement4 a = new Assignement4();
		System.out.println(a.getresult());

		// to get nth product on the page
		System.out.println("The product at Nth position: \n*******************************\n"+a.getNthproduct(".s-item.s-item__pl-on-bottom", 60).getText()+"\n");
		a.getallproduct();

		driver.quit();



	}

}
