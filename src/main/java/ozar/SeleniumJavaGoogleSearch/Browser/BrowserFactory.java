package ozar.SeleniumJavaGoogleSearch.Browser;

import ozar.SeleniumJavaGoogleSearch.dataProvider.ConfigReader;

public class BrowserFactory {

	private static Browser browser;

	public static Browser getBrowser() {

		switch (ConfigReader.getBrowserType()) {
		case CHROME:
			browser = new ChromeBrowser();
		case FF:
			browser = new GeckoBrowser();
		case PHANTOM:
			browser = new PhantomBrowser();
		default:
			browser = new GeckoBrowser();
		}

		return browser;
	}

}
