package screenshot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPropertyReader extends BaseClass {
	private static  ConfigPropertyReader _instance = null;
	public Properties config;
	public InputStream inputStream = null;
	public ConfigPropertyReader() {

		try {
			this.config = new Properties();
			this.inputStream = getClass().getClassLoader()
					.getResourceAsStream("Config.properties");
			if (this.inputStream != null) {
				this.config.load(this.inputStream);
				this.inputStream.close();
			} else {
				System.out.println("Error on reading config file");
			}
		} catch (IOException e) {
			System.out.println("Exception in reading config fie" + e);
		} finally {
			if (this.inputStream != null) {
				try {
					this.inputStream.close();
				} catch (IOException e) {
					System.out.println("Error occured while closing config file" + e);
				}
			}

		}

	}

	public String getValueForKey(String key) {
		return this.config.getProperty(key);

	}
	
	public static ConfigPropertyReader getInstance() {

        if (_instance == null) {
            _instance = new ConfigPropertyReader();
        }
        return _instance;
    }
}
