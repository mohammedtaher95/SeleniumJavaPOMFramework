package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase
{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="gender-male")
	WebElement genderMaleradiobtn;
	
	@FindBy(id="FirstName")
	WebElement FirstName;
	
	@FindBy(id="LastName")
	WebElement LastName;
	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(id="ConfirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	WebElement MyAccountLink;
	
	public void userRegistration(String Firstname, String Lastname, String email, String password)
	{
		ClickButton(genderMaleradiobtn);
		Fill_in_Text(FirstName, Firstname);
		Fill_in_Text(LastName, Lastname);
		Fill_in_Text(Email, email);
		Fill_in_Text(Password, password);
		Fill_in_Text(ConfirmPassword, password);
		ClickButton(registerBtn);
	}
	
	public void userlogout()
	{
		ClickButton(logoutLink);
	}
	
	public void openMyAccountPage()
	{
		ClickButton(MyAccountLink);
	}
}
