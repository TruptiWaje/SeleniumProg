package mpack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableHandling extends Base
{
	public  void getEmailDetails(List<WebElement> email, int i) throws InterruptedException
	{
		
			if(i>0 && i<=email.size())
			{
				email.get(i-1).click();
				Thread.sleep(2000);
				WebElement subject = driver.findElement(By.xpath("//div[@class='fz-20 ff-futura-demi gray-color ng-binding']"));
				System.out.println("Subject of "+i+"th email: "+subject.getText());
				WebElement sender = driver.findElement(By.xpath("(//div[@class='from fz-20 ff-futura-book p-l-20 ng-binding'])[2]"));
				System.out.println("Sender of "+i+ "th email: "+sender.getText());
			}
		
	}
	public static void main(String[] args) throws InterruptedException
	{
		TableHandling table = new TableHandling();
		table.initializeDriver("chrome");
		driver.get("https://www.mailinator.com/v4/public/inboxes.jsp");
		//Go to respective email id
		driver.findElement(By.id("inbox_field")).sendKeys("test@mailinator.com");
		driver.findElement(By.xpath("//button[@class='primary-btn']")).click();
		Thread.sleep(2000);
		//get all email list and count total emails in the inbox
		List<WebElement> email = driver.findElements(By.xpath("//div[@class='os-content']/table[@class='table-striped jambo_table']//tr"));
		Thread.sleep(1000);
		int totalRows = email.size();
		System.out.println("Total emails in inbox: "+totalRows);
		//get nth number email details
		table.getEmailDetails(email,4);
		
	}

}
