package ozar.SeleniumJavaGoogleSearch.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Oleg Zarevych
 * google.com page
 */

public class GoogleMainPage {

	 @FindBy(id = "lst-ib")
	 private WebElement searchField;
	 
	 @FindBy(name = "btnK")
	 private WebElement searchButton;
	
	 public void searchTest(String text)
	 {
		 searchField.sendKeys(text);
		 searchButton.submit();
		 // return new SearchResultPage();
	 }
	 
	 public boolean IsSearchVisible()
	 {
		 return searchField.isDisplayed();
	 }
	 
}
