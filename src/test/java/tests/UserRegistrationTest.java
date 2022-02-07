package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	
	HomePage homeObject;
	UserRegistrationPage registerPage;
	LoginPage loginPage;
	
	Faker faker = new Faker();
	
	String FirstName = faker.name().firstName();
	String LastName = faker.name().lastName();
	String Email = faker.internet().emailAddress();
	String Password = faker.number().digits(9).toString();
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerPage = new UserRegistrationPage(driver);
		registerPage.userRegistration(FirstName, LastName, Email, Password);
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
		loginPage.userLogin(Email, Password);
		Assert.assertTrue(registerPage.logoutLink.getText().contains("Log out"));
	}
}
