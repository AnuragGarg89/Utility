package screenshot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LocatorReader {
	private static  LocatorReader _instance = null;
	public Properties locator;
	public InputStream inputStream = null;

	public LocatorReader() {
		try {
			this.locator = new Properties();
			this.inputStream = getClass().getClassLoader()
					.getResourceAsStream("Locators.properties");
			if (this.inputStream != null) {
				this.locator.load(this.inputStream);
				this.inputStream.close();
			} else {
				System.out.println("Error on reading config file");
			}
		} catch (IOException e) {
			System.out.println("Error" + e);
		} finally {
			if (this.inputStream != null) {
				try {
					this.inputStream.close();
				} catch (IOException e) {
					System.out.println("Func:  Error occured while closing config file" + e);
				}
			}

		}

	}

	public String getValueOfLocator(String key) {
		return this.locator.getProperty(key);
	}
	

	public static LocatorReader getInstance() {

        if (_instance == null) {
            _instance = new LocatorReader();
        }
        return _instance;
    }

}
