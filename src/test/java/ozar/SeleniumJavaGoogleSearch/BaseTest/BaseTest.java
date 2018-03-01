package ozar.SeleniumJavaGoogleSearch.BaseTest;

import ozar.SeleniumJavaGoogleSearch.Browser.Browser;
import ozar.SeleniumJavaGoogleSearch.Browser.BrowserFactory;
import ozar.SeleniumJavaGoogleSearch.dataProvider.ConfigReader;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	private static Browser browser;
	
	@BeforeSuite
	public void init()
	{
		ConfigReader.getInstance();
	}

	@BeforeTest
	public static void start()
	{
		launchBrowser();
		goToUrl();
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
	}

	@AfterMethod
	public void closeBrowser() {
		browser.stopDriver();
	}
	
	public String getBrowserTitle() {
		return browser.title();
	}
	
	private static void launchBrowser()
	{
		browser = BrowserFactory.getBrowser();
		browser.startDriver();
	}
	
	private static void goToUrl() {
		browser.goTo(ConfigReader.getUrl());
	}
}
