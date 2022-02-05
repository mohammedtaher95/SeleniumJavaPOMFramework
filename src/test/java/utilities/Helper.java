package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void CaptureScreenshot(WebDriver driver, String screenshotName)
	{
		Path destination = Paths.get("./screenshots", screenshotName + ".png");
		try {

			Files.createDirectories(destination.getParent());
			FileOutputStream out = new FileOutputStream(destination.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
