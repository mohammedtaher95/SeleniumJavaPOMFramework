package tests;

import java.util.concurrent.TimeUnit;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utilities.Helper;

public class OldTestBase{

	public static WebDriver driver;
	public WebDriverWait wait;

	@BeforeSuite
	@Parameters("browser")
	public void startDriver(@Optional("chrome") String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			String ChromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ChromePath);
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			String FireFoxPath = System.getProperty("user.dir") + "/drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", FireFoxPath);
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			String FireFoxPath = System.getProperty("user.dir") + "/drivers/msedgedriver.exe";
			System.setProperty("webdriver.gecko.driver", FireFoxPath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
		wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
	}

	@AfterTest
	public void clearCookies()
	{
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void HomePageNavigation()
	{
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void closeDriver()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void screenShotOnFailure(ITestResult testResult)
	{
		if(testResult.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.CaptureScreenshot(driver, testResult.getName());
		}
		
	}

}
