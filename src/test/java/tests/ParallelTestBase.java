package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelTestBase {

    public static String BaseURL = "https://demo.nopcommerce.com/";
    protected ThreadLocal<RemoteWebDriver> driver = null;

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver = new ThreadLocal<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
        getDriver().navigate().to(BaseURL);
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }

    @AfterClass
    public void stopDriver()
    {
        getDriver().quit();
        driver.remove();
    }

    @AfterClass
    public void clearCookies()
    {
        getDriver().manage().deleteAllCookies();
    }

    @AfterMethod
    public void screenShotOnFailure(ITestResult testResult)
    {
        if(testResult.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.CaptureScreenshot(getDriver(), testResult.getName());
        }

    }
}
