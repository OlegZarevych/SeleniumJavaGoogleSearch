package ozar.SeleniumJavaGoogleSearch.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import ozar.SeleniumJavaGoogleSearch.BaseTest.BaseTest;
import ozar.SeleniumJavaGoogleSearch.Browser.Browser;
import ozar.SeleniumJavaGoogleSearch.Browser.BrowserFactory;
import ozar.SeleniumJavaGoogleSearch.dataProvider.ConfigReader;

/**
 * @author Oleg Zarevych
 * test search at Google
 */
@Test
public class SearchTest extends BaseTest{
	
	@Test
	public void GoogleCheckTitle()
	{
		String title = "Google";
		Assert.assertEquals(getBrowserTitle(),title);
	}
}
