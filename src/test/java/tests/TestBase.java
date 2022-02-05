package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase {

	public static WebDriver driver;

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
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			String FireFoxPath = System.getProperty("user.dir") + "/drivers/msedgedriver.exe";
			System.setProperty("webdriver.gecko.driver", FireFoxPath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@AfterTest
	public void clearCookies()
	{
		driver.manage().deleteAllCookies();
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
