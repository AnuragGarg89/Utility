package screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IntializeWebDriver extends BaseClass{
	
	private WebDriver driver = null;	

	public WebDriver getBrowser(String browser){
		
		if(browser.equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver", projectPath + "\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
			
		}else if(browser.equalsIgnoreCase("FIREFOX")){
			System.setProperty("webdriver.gecko.driver", projectPath + "\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
			
		}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", projectPath + "\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;}
		else{
			return null;
		}
	}

}
