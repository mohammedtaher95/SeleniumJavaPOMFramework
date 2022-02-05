package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	
	HomePage homeObject;
	UserRegistrationPage registerPage;
	LoginPage loginPage;
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerPage = new UserRegistrationPage(driver);
		registerPage.userRegistration("Mohammed", "Taher", "test1256@gmail.com", "123456789");
		Assert.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout()
	{
		registerPage.userlogout();
	}
	
	@Test(dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginPage = new LoginPage(driver);
		loginPage.userLogin("test1256@gmail.com", "123456789");
		Assert.assertTrue(registerPage.logoutLink.getText().contains("Log out"));
	}
}
