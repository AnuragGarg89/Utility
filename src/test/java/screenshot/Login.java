package screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * 
 * @author anurag.garg
 *
 */

public class Login {

	WebDriver driver;

	@Test
	public void loginToOEM() {

		BaseClass baseclass = new BaseClass();
		IntializeWebDriver iwd = new IntializeWebDriver();

		try {
			this.driver = iwd.getBrowser("CHROME");
			this.driver.get(ConfigPropertyReader.getInstance().getValueForKey("url"));
			driver.findElement(By.xpath(LocatorReader.getInstance().getValueOfLocator("usernameXpath")))
					.sendKeys(ConfigPropertyReader.getInstance().getValueForKey("usernameValue"));
			driver.findElement(By.xpath(LocatorReader.getInstance().getValueOfLocator("Next"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(LocatorReader.getInstance().getValueOfLocator("passwordXpath")))
					.sendKeys(ConfigPropertyReader.getInstance().getValueForKey("passwordValue"));
			Thread.sleep(3000);
			driver.findElement(By.xpath(LocatorReader.getInstance().getValueOfLocator("Next"))).click();
			Thread.sleep(5000);

			baseclass.captureScreenshot(this.driver);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.driver.quit();
		}

	}

}
