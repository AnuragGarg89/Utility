package screenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author anurag.garg
 *
 */

public class BaseClass {

	protected Properties config;
	protected Properties locators;
	protected static String projectPath = System.getProperty("user.dir");;

	public void captureScreenshot(WebDriver driver) {
		try {
			String fileName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(projectPath + "\\Screenshots\\Chrome\\" + fileName + ".jpeg");
			FileUtils.copyFile(scrFile, destFile);

		} catch (Exception e) {
			System.out.println("Error capturing screenshot" + e.getMessage());
		}

	}

}
