package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "Password")
	WebElement Password;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;
	
	public void userLogin(String email, String password)
	{
		Fill_in_Text(Email, email);
		Fill_in_Text(Password, password);
		ClickButton(loginBtn);
	}

}
