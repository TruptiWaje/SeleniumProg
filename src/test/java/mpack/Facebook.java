package mpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Facebook extends Base {
	public static void main(String[] args)
	{
		Facebook ass2 = new Facebook();
		ass2.initializeDriver("chrome");
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
		WebElement createAccount = driver.findElement(By.xpath("//a[starts-with(@id, 'u_0_0_')]"));
		System.out.println("Create Account button visibility status:" +createAccount.isDisplayed());
		createAccount.click();
		driver.findElement(By.name("firstname")).sendKeys("Anvi");
		driver.findElement(By.name("lastname")).sendKeys("Waje");
		driver.findElement(By.name("reg_email__")).sendKeys("pratiktutor6@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Anvi@123456");
		driver.findElement(By.xpath("//select[@id='day']//option[@value='13']")).click();
		driver.findElement(By.xpath("//select[@id='month']//option[@value='12']")).click();
		driver.findElement(By.xpath("//select[@id='year']//option[@value='1999']")).click();
		driver.findElement(By.xpath("//label[contains(text(), 'Female')]")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	}

}
