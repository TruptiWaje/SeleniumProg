package mpack;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop extends Base {
	public static void main(String[] args)
	{
		DragAndDrop dragDrop = new DragAndDrop();
		dragDrop.initializeDriver("chrome");
		driver.get("https://jqueryui.com/droppable/");
		//Find frame and switch
		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);
		//Save source and target element and also printing its CssVaue and Text
		WebElement drag  = driver.findElement(By.cssSelector("#draggable"));
		WebElement drop = driver.findElement(By.cssSelector("#droppable"));
		String colourBeforeDragging = drop.getCssValue("color");
		String textBeforeDragging = drop.getText();
		System.out.println("Colour before dragging: " +drop.getCssValue("color"));
		System.out.println("Text before dragging: " +drop.getText());
		Actions a = new Actions(driver);
		a.dragAndDrop(drag, drop).perform();
		String colourAfterDragging = drop.getCssValue("color");
		String textAfterDragging = drop.getText();
		System.out.println("Colour After dragging: " +drop.getCssValue("color"));
		System.out.println("Text After dragging: " +drop.getText());
		//Assert if colour and text does not change
		Assert.assertNotEquals("Colours are same",colourBeforeDragging , colourAfterDragging);
		Assert.assertNotEquals("Text are same", textBeforeDragging, textAfterDragging);
		dragDrop.closeBrowser();
	}

}
