//Invoke firefox browser
package mpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ToolsQA extends Base{

	public static void main(String[] args) throws InterruptedException
	{
		ToolsQA tools = new ToolsQA();
		tools.initializeDriver("firefox");
		driver.get("https://www.toolsqa.com/");
		String title = driver.getTitle(); //get title of the page and compare and print PASS or FAIL
		if(title.equals("Tools QA"))
		{
			 System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		Thread.sleep(2000); //close the cookie alert box
		driver.findElement(By.id("accept-cookie-policy")).click();
		//scroll the page till end and click on Facebook
		Actions a = new Actions(driver);
		WebElement scroll = driver.findElement(By.xpath("//span[contains(text(),'Facebook')]"));
		a.scrollToElement(scroll);
		scroll.click();
		//go back on original Webpage
		driver.navigate().back();
		//print current URL
		System.out.println("Current URL:" +driver.getCurrentUrl());
		// navigate forward and refresh the page
		driver.navigate().forward();
		driver.navigate().refresh();
		tools.closeBrowser();

	}

}
