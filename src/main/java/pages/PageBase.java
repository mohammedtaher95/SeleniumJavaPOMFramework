package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase 
{
	protected WebDriver driver;
	
	// creating Constructor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void ClickButton(WebElement button)
	{
		button.click();
	}
	
	protected static void Fill_in_Text(WebElement textElement , String value)
	{
		textElement.sendKeys(value);
	}

}
