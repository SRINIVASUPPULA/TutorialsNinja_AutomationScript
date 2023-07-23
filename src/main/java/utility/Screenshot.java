package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	// This method takes a screenshot of the browser and saves as a file
	public static void snap(WebDriver driver, String filename) {
		File ScrnshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String filetext = date.toString().replace(" ", "_").replace(":", "_");
		// Create file from the screenshot of driver
		try {
			FileUtils.copyFile(ScrnshotFile, new File(("user.dir") + "\\screenshots\\" + filename + filetext + ".jpg"));
		} catch (IOException e) {
			System.out.println("Could not save the file");
			e.printStackTrace();
		}
	}

}
