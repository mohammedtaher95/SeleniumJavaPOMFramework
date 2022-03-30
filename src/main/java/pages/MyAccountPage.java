package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText="Change password")
	WebElement changePasswordLink ; 
	
	@FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;
	
    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;
    
    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxt;
    
    @FindBy(css = "button.button-1.change-password-button")
    WebElement ChangePasswordBtn;
    
    @FindBy(css = "p.content")
    public WebElement ChangeResult;
    
    @FindBy(css = "span.close")
    WebElement MessageCloseBtn;
    
    public void openChangePasswordpage()
    {
    	ClickButton(changePasswordLink);
    }
    
    public void ChangePassword(String OldPass, String NewPass)
    {
    	Fill_in_Text(oldPasswordTxt, OldPass);
    	Fill_in_Text(newPasswordTxt, NewPass);
    	Fill_in_Text(confirmPasswordTxt, NewPass);
    	ClickButton(ChangePasswordBtn);
    }
    
    public void CloseMessage()
    {
    	ClickButton(MessageCloseBtn);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("p.content")));
    }
    

}
