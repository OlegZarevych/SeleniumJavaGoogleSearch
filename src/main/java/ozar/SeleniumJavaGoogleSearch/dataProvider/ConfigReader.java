package ozar.SeleniumJavaGoogleSearch.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import ozar.SeleniumJavaGoogleSearch.Browser.Browser;
import ozar.SeleniumJavaGoogleSearch.Browser.Browsers;

public class ConfigReader {

	private final String propertyFilePath = "config//Configurations.properties";
	private static Properties properties;

	public ConfigReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}

	public static Browsers getBrowserType()
	{
		return Browsers.valueOf(getDriverName());
	}
	
	private static String getDriverName() {
		String driver = properties.getProperty("driver");
		if (driver != null)
			return driver;
		else
			throw new RuntimeException("driver not specified in the Configuration.properties file.");
	}

}
