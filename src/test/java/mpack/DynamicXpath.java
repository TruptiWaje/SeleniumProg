package mpack;

import org.openqa.selenium.By;

public class DynamicXpath extends Base{
	public static void main(String[] args) throws InterruptedException
	{
		DynamicXpath dynamic = new DynamicXpath();
		dynamic.initializeDriver("firefox");
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ap_email_login")).sendKeys("9763444557");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ap_password")).sendKeys("Josh@123");
		driver.findElement(By.id("auth-signin-button")).click();
		String userName = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		if(userName.contentEquals("Hello, Josh"));
		{
			System.out.println("User has logged in successfully");
		}
		dynamic.closeBrowser();	
	}

}
