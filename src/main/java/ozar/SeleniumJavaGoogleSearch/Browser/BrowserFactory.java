package ozar.SeleniumJavaGoogleSearch.Browser;

import ozar.SeleniumJavaGoogleSearch.dataProvider.ConfigReader;

public class BrowserFactory {

	private Browser browser;

	public Browser getBrowser() {

		switch (getBrowserType()) {
		case CHROME:
			browser = new ChromeBrowser();
		default:
			browser = new ChromeBrowser();
		}

		return browser;
	}

	private Browsers getBrowserType() {
		ConfigReader configReader = new ConfigReader();
		return configReader.getBrowserType();
	}

}
