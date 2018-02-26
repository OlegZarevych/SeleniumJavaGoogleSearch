package ozar.SeleniumJavaGoogleSearch.BaseTest;

import ozar.SeleniumJavaGoogleSearch.Browser.Browser;
import ozar.SeleniumJavaGoogleSearch.Browser.BrowserFactory;
import ozar.SeleniumJavaGoogleSearch.dataProvider.ConfigReader;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseTest {
	
	private Browser browser;
	private BrowserFactory factory = new BrowserFactory();

	public String getBrowserTitle() {
		return browser.title();
	}
	
	
	@BeforeTest
	void launchBrowser() {
		browser = factory.getBrowser();
		browser.startDriver();
	}
	
	@BeforeTest
	void goToUrl() {
		browser.goTo(ConfigReader.getUrl());
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
	}

	@AfterTest
	void closeBrowser() {
		browser.stopDriver();
	}
}
