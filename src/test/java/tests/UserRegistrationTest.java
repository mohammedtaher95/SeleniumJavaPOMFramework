package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends ParallelTestBase {
	
	
	HomePage homeObject;
	UserRegistrationPage registerPage;
	LoginPage loginPage;

	UserFormData newUser = new UserFormData();
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(getDriver());
		homeObject.openRegistrationPage();
		registerPage = new UserRegistrationPage(getDriver());
		registerPage.userRegistration(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getPassword());
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
		loginPage = new LoginPage(getDriver());
		loginPage.userLogin(newUser.getEmail(), newUser.getPassword());
		Assert.assertTrue(registerPage.logoutLink.getText().contains("Log out"));
	}
	
	@Test(dependsOnMethods = {"RegisteredUserCanLogin"})
	public void UserCanLogout()
	{
		registerPage.userlogout();
	}
}
