package ozar.SeleniumJavaGoogleSearch.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import ozar.SeleniumJavaGoogleSearch.BaseTest.BaseTest;

/**
 * @author Oleg Zarevych
 * test search at Google
 */

public class SearchTest extends BaseTest{
	
	@Test
	public void GoogleCheckTitle()
	{
		String title = "Google";
		Assert.assertEquals(getBrowserTitle(),title);
	}
}
