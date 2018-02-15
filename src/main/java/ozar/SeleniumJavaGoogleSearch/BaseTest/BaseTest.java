package ozar.SeleniumJavaGoogleSearch.BaseTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ozar.SeleniumJavaGoogleSearch.Browser.Browser;
import ozar.SeleniumJavaGoogleSearch.Browser.BrowserFactory;

public class BaseTest {

	private Browser browser;
	private BrowserFactory factory = new BrowserFactory();

	@BeforeTest
	void launchBrowser() {
		browser = factory.getBrowser();
		browser.startDriver();
	}
	
	@AfterTest
	void closeBrowser()
	{
		browser.stopDriver();
	}
}
