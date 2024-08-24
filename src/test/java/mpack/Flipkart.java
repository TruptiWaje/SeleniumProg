// Links and attributes
package mpack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Flipkart extends Base {
	public static void main(String[] args)
	{
		Flipkart ass3 = new Flipkart();
		ass3.initializeDriver("chrome");
		driver.get("https://www.flipkart.com/");
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		System.out.println("Total Links on homepage of flipkart: "+elements.size());
		System.out.println("Links on the home page are as followed:");
		for (WebElement element : elements) {
			if(element.getText().length()>0)
			{
			System.out.println(element.getText());
			}
		}
		driver.quit();

	}

}
