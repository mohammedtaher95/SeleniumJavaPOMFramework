package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerPage;
	LoginPage loginPage;
	MyAccountPage myaccountPage;
	
	String oldPassword = "12345678" ; 
	String newPassword = "123456" ; 
	String firstName = "Mohammed" ; 
	String lastName = "Taher" ; 
	String email = "test422@gmail.com" ; 
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerPage = new UserRegistrationPage(driver);
		registerPage.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void RegisteredUserCanChangePassword()
	{
		myaccountPage = new MyAccountPage(driver);
		registerPage.openMyAccountPage();
		myaccountPage.openChangePasswordpage();
		myaccountPage.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myaccountPage.ChangeResult.getText().contains("Password was changed"));
		myaccountPage.CloseMessage();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority = 3, dependsOnMethods = {"RegisteredUserCanChangePassword"})
	public void RegisteredUserCanLogout()
	{
		registerPage.userlogout();
	}
	
	@Test(priority = 4)
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginPage = new LoginPage(driver);
		loginPage.userLogin(email, newPassword);
		Assert.assertTrue(registerPage.logoutLink.getText().contains("Log out"));
	}
	
	@Test(priority = 5, dependsOnMethods = {"RegisteredUserCanLogin"})
	public void UserLogout()
	{
		registerPage.userlogout();
	}

}
