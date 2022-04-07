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

public class MyAccountTest extends ParallelTestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerPage;
	LoginPage loginPage;
	MyAccountPage myaccountPage;
	
	UserFormData user = new UserFormData();
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(getDriver());
		homeObject.openRegistrationPage();
		registerPage = new UserRegistrationPage(getDriver());
		registerPage.userRegistration(user.getFirstName(), user.getLastName(), user.getEmail(), user.getOldPassword());
		Assert.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void RegisteredUserCanChangePassword() throws InterruptedException
	{
		myaccountPage = new MyAccountPage(getDriver());
		//wait = new WebDriverWait(driver, 20);
		registerPage.openMyAccountPage();
		myaccountPage.openChangePasswordpage();
		myaccountPage.ChangePassword(user.getOldPassword(), user.getNewPassword());
		Assert.assertTrue(myaccountPage.ChangeResult.getText().contains("Password was changed"));
		myaccountPage.CloseMessage();
		Thread.sleep(1000);
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
		loginPage = new LoginPage(getDriver());
		loginPage.userLogin(user.getEmail(), user.getNewPassword());
		Assert.assertTrue(registerPage.logoutLink.getText().contains("Log out"));
	}
	
	@Test(priority = 5, dependsOnMethods = {"RegisteredUserCanLogin"})
	public void UserLogout()
	{
		registerPage.userlogout();
	}

}
