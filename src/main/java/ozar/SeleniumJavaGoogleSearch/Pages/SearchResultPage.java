package ozar.SeleniumJavaGoogleSearch.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Oleg Zarevych
 * Google search result page
 */

public class SearchResultPage {
	
	 @FindBy(xpath = "//div/h3/a[text()='QA — Вікіпедія']")
	 private WebElement wikiUkrQa;
	 
	 public boolean IsUkrWikiPresent()
	 {
		 return wikiUkrQa.isDisplayed();
	 }
}
