package page;

import org.openqa.selenium.WebDriver;

public class GlobalDictionaryPage extends AbstractPage {

	public GlobalDictionaryPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	
	public String getDefaultDisplayName(){
		return getText(driver, epmxweb.GlobalDictionaryPage.defaultDisplayName);
	}
	
	public String getDefaultShortName(){
		return getText(driver, epmxweb.GlobalDictionaryPage.defaultShortName);
	}
	
	public boolean isRequiredRadioButtonChecked(){
		return isControlSelected(driver, epmxweb.GlobalDictionaryPage.requiredRadioButton);
	}
	
	public boolean isOptionalRadioButtonChecked(){
		return isControlSelected(driver, epmxweb.GlobalDictionaryPage.optionalRadioButton);
	}
	private WebDriver driver;
	private String ipClient;
}
