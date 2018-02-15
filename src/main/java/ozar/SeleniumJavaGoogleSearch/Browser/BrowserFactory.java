package ozar.SeleniumJavaGoogleSearch.Browser;

import ozar.SeleniumJavaGoogleSearch.dataProvider.ConfigReader;

public class BrowserFactory {

	private Browser browser;

	public Browser getBrowser() {

		switch (ConfigReader.getBrowserType()) {
		case CHROME:
			browser = new ChromeBrowser();
		default:
			browser = new ChromeBrowser();
		}

		return browser;
	}

}
