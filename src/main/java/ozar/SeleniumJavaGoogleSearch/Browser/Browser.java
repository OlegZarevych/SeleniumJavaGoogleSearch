package ozar.SeleniumJavaGoogleSearch.Browser;

import org.openqa.selenium.WebDriver;

public abstract class Browser {

	protected WebDriver driver;

	public abstract void startDriver();

	public abstract void stopDriver();

	public abstract void goTo(String url);
	
	public abstract String title();

}
