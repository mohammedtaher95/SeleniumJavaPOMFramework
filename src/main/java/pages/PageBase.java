package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase 
{
	protected WebDriver driver;
	public static JavascriptExecutor jse;
	
	// creating Constructor
	public PageBase(WebDriver driver)
	{
		this.driver = driver;
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

	protected static void ScrollToBottom()
	{
		jse.executeScript("scrollBy(0,2500)");
	}

}
