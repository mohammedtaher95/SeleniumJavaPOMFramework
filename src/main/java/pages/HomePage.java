package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(linkText = "Contact us")
	WebElement ContactUsLink;

	@FindBy(id = "customerCurrency")
	WebElement CurrencyDropDownList;
	
	public void openRegistrationPage()
	{
		ClickButton(registerLink);
	}
	
	public void openLoginPage()
	{
		ClickButton(loginLink);
	}

	public void openContactUsPage()
	{
		ScrollToBottom();
		ClickButton(ContactUsLink);
	}

	public void changeCurrency(int index)
	{
		select = new Select(CurrencyDropDownList);
		select.selectByIndex(index);
	}


}
