package ozar.SeleniumJavaGoogleSearch.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser extends Browser {

	private WebDriver driver;

	@Override
	public void startDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Override
	public void stopDriver() {

		if (driver != null)
			driver.quit();
	}

	@Override
	public void goTo(String url) {
		if (driver != null)
			driver.navigate().to(url);
	}
	
	@Override
	public String title() {
		return driver.getTitle();
	}
}
