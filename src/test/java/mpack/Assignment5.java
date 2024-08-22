package mpack;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://snapdeal.com/");
		Actions a = new Actions(driver);
		WebElement movetosignup = driver.findElement(By.cssSelector(".accountUserName.col-xs-12.reset-padding"));
		a.moveToElement(movetosignup).perform();
		Thread.sleep(3000);
		WebElement iframe = driver.findElement(By.id("loginIframe"));
		driver.switchTo().frame(iframe);
		WebElement cli = driver.findElement(By.xpath("//a[contains(text(),'login')]"));
		a.moveToElement(cli).click().build().perform();
		driver.findElement(By.id("userName")).sendKeys("trupti.waje@joshsoftware.com");

		String orgWindow = driver.getWindowHandle();
		System.out.println(orgWindow);

		driver.findElement(By.cssSelector("#checkUser")).click();
		
		driver.findElement(By.xpath("//input[@id='j_number']")).sendKeys("9763444557");
       
		//driver.findElement(By.cssSelector("#j_name")).sendKeys("Trupti Waje");
		//driver.findElement(By.cssSelector("#j_dob")).click();
		//driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")).click();

	}
}



