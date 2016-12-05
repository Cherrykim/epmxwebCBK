package page;

import org.openqa.selenium.WebDriver;

public class AddLabelsPage extends AbstractPage {

	public AddLabelsPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public boolean isWelcomeMessageDisplayed(){
		return getText(driver, epmxweb.MainPage.welcomeMessage).contains("Welcome");
	}
	
	public void selectRadioButtonByName(String radioButtonName){
		click(driver, epmxweb.AbstractPage.dynamicRadioButtonByName, radioButtonName);
		sleep(2);
	}
	
	public boolean isImageButtonDisplayed(String src){
		return isControlDisplayed(driver, epmxweb.AbstractPage.dynamicImgByItsSrc, src);
	}
	
	public boolean isItemInSelectedList(String id, String itemName){
		return isControlDisplayed(driver, epmxweb.AbstractPage.dynamicSelectedListByID, id, itemName);
	}
	
	public boolean isSuggestionDropdownDisplayedCorrectly(String id, String value){
		return getAttributeValue(driver, epmxweb.AbstractPage.dynamicSuggestionDropdownByID, "innerHTML", id).contains(value);
	}
	
	public String getElementTextByClass(String className){
		return getText(driver, epmxweb.AbstractPage.dynamicElementByClass, className);
	}
	
	public boolean isResultTableContainsRecord(String value1, String value2){
		return isControlDisplayed(driver, epmxweb.AbstractPage.dynamicResultTableContainsText, value1, value2);
	}
	private WebDriver driver;
	private String ipClient;
}
