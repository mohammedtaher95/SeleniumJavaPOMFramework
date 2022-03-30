package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerPage;
	LoginPage loginPage;
	MyAccountPage myaccountPage;
	
	Faker faker = new Faker();
	
	String oldPassword = faker.number().digits(8).toString(); 
	String newPassword = faker.number().digits(9).toString(); 
	String firstName = faker.name().firstName(); 
	String lastName = faker.name().lastName();
	String email = faker.internet().emailAddress(); 
	
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
	public void RegisteredUserCanChangePassword() throws InterruptedException
	{
		myaccountPage = new MyAccountPage(driver);
		//wait = new WebDriverWait(driver, 20);
		registerPage.openMyAccountPage();
		myaccountPage.openChangePasswordpage();
		myaccountPage.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myaccountPage.ChangeResult.getText().contains("Password was changed"));
		myaccountPage.CloseMessage();
	}
	
	@Test(priority = 3, dependsOnMethods = {"RegisteredUserCanChangePassword"})
	public void RegisteredUserCanLogout()
	{
		registerPage.userlogout();
	}
	
	@Test(priority = 4, dependsOnMethods = {"RegisteredUserCanLogout"})
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
