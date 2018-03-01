package ozar.SeleniumJavaGoogleSearch.dataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import ozar.SeleniumJavaGoogleSearch.Browser.Browsers;

public final class ConfigReader {

	private static final String propertyFilePath = "Configurations.properties";
	private static Properties properties;
	
	private static final ConfigReader instance = new ConfigReader();
	   	   
	   private ConfigReader()
	   {
			//BufferedReader reader;
			//reader = new BufferedReader(new FileReader(inputStream));
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(inputStream);
				//reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
	   }  

		public static ConfigReader getInstance() 
		{
		     return instance;
		}   
	   
	public static Browsers getBrowserType()
	{
		return Browsers.valueOf(getDriverName());
	}
	
	public static String getUrl()
	{
		return getUrlProperties();
	}
	
	private static String getUrlProperties()
	{
		getInstance();
		String driver = properties.getProperty("url");
		if (driver != null)
			return driver;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	private static String getDriverName() 
	{
		getInstance();
		String driver = properties.getProperty("driver");
		if (driver != null)
			return driver;
		else
			throw new RuntimeException("driver not specified in the Configuration.properties file.");
	}

}
