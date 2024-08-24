package mpack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AcessEmail extends Base {
	public static void main(String[] args) throws InterruptedException
	{
		AcessEmail access = new AcessEmail();
		access.initializeDriver("firefox");
		driver.get("https://yopmail.com/en/");
		driver.findElement(By.id("login")).sendKeys("trupti@yopmail.com");		
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		WebElement edit = driver.findElement(By.xpath("//button[@id='newmail']//i[@class='material-icons-outlined']"));
		a.moveToElement(edit).click().perform();
		WebElement iframe = driver.findElement(By.id("ifmail"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("msgto")).sendKeys("shweta@yopmail.com");
		driver.findElement(By.id("msgsubject")).sendKeys("Test Subject");
		driver.findElement(By.id("msgbody")).sendKeys("test body of the email");
		driver.findElement(By.id("msgsend")).click();
		access.closeBrowser();
		
	}

}
