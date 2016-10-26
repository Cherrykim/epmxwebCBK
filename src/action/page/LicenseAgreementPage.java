package page;

import org.openqa.selenium.WebDriver;

public class LicenseAgreementPage extends AbstractPage {

	public LicenseAgreementPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public void selectRadioButtonByValue(String value){
		click(driver, epmxweb.LicenseAgreementPage.dynamicRadioButton, value);
		sleep();
	}
	
	public void clickOnButtonByValue(String value){
		click(driver, epmxweb.LicenseAgreementPage.dynamicButtonByValue, value);
		sleep();
	}
	
	public boolean isButtonByValueEnabled(String value){
		return isControlEnabled(driver, epmxweb.LicenseAgreementPage.dynamicButtonByValue, value);
	}
	
	private WebDriver driver;
	private String ipClient;
}
