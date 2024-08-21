package mpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignement2 {
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.fb.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals("https://www.facebook.com/"))
		{
			System.out.println("Redirected to correct URL:" +currentUrl);
		}
		else
		{
			System.out.println("Redirected to wrong URL:" +currentUrl);
		}
		WebElement CreateAccount = driver.findElement(By.xpath("//a[starts-with(@id, 'u_0_0_')]"));
		System.out.println("Create Account button visibility status:" +CreateAccount.isDisplayed());
		CreateAccount.click();
		driver.findElement(By.name("firstname")).sendKeys("Anvi");
		driver.findElement(By.name("lastname")).sendKeys("Waje");
		driver.findElement(By.name("reg_email__")).sendKeys("anvi.waje@gmail.com");
		//driver.findElement(By.name("reg_email_confirmation__")).sendKeys("anvi.waje@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Anvi@123456");
		driver.findElement(By.xpath("//select[@id='day']//option[@value='13']")).click();
		driver.findElement(By.xpath("//select[@id='month']//option[@value='12']")).click();
		driver.findElement(By.xpath("//select[@id='year']//option[@value='1999']")).click();
		driver.findElement(By.xpath("//label[contains(text(), 'Female')]")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
		//Not able to verify by user. Currently facebook need verification which can be done 
		//through mail but not able to access gmail through automation script due to security issues, so commented the code
		
		/*  WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		  newTab.get("https://www.gmail.com");
		  driver.findElement(By.id("identifierId")).sendKeys("pratiktutor6@gmail.com");
		  driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		  driver.findElement(By.name("Passwd")).sendKeys("Josh@123");
		  driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		  System.out.print(driver.findElement(By.xpath("(//tr[starts-with(@class, ZA)])[8])")).getText());
     	  driver.findElement(By.id("code_in_cliff")).sendKeys(args);
 */
		// Verify that
	}

}
