package mpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal extends Base {
	public static void main(String[] args) throws InterruptedException {
		SnapDeal snap = new SnapDeal();
		snap.initializeDriver("Chrome");
		driver.get("https://snapdeal.com/");
		//code to use mouse actions
		Actions a = new Actions(driver);
		WebElement moveToSignup = driver.findElement(By.cssSelector(".accountUserName.col-xs-12.reset-padding"));
		a.moveToElement(moveToSignup).perform();
		Thread.sleep(2000);
		//Code to access iframe
		driver.get("https://demoqa.com/frames");
		WebElement iframe=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframe);
		WebElement text = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("Frame1 text: " + text.getText());
		snap.closeBrowser();
	}
}



