package ozar.SeleniumJavaGoogleSearch.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomBrowser extends Browser {

	private WebDriver driver;
	
	@Override
	public void startDriver() {
		driver = new PhantomJSDriver();

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
