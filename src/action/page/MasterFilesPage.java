package page;

import org.openqa.selenium.WebDriver;

public class MasterFilesPage extends AbstractPage {

	public MasterFilesPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	
	public String getDefaultDisplayName(){
		return getText(driver, epmxweb.MasterFilesPage.defaultDisplayName);
	}
	
	public String getDefaultShortName(){
		return getText(driver, epmxweb.MasterFilesPage.defaultShortName);
	}
	
	public boolean isRequiredRadioButtonChecked(){
		return isControlSelected(driver, epmxweb.MasterFilesPage.requiredRadioButton);
	}
	
	public boolean isOptionalRadioButtonChecked(){
		return isControlSelected(driver, epmxweb.MasterFilesPage.optionalRadioButton);
	}
	
	public boolean isFirstRecordDisplayedCorrectly(String itemName){
//		return isControlDisplayed(driver, epmxweb.MasterFilesPage.dynamicFirstCatalogItem, itemName);
		System.out.println(getAttributeValue(driver, epmxweb.MasterFilesPage.firstCatalogItem, "innerHTML"));
		return getAttributeValue(driver, epmxweb.MasterFilesPage.firstCatalogItem, "innerHTML").contains(itemName);
	}
	
	public void createNewVendor(String vendorID, String vendorName){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_user.php");
		sleep(2);
		inputTextfieldByIDWithEnter(driver, "txt_UserName", vendorID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByIDWithEnter(driver, "txt_VendorName", vendorName);
		clickOnDivByItsText(driver, "Addl Vendor Info");
		inputTextfieldByIDWithEnter(driver, "txt_TaxId", vendorName);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	private WebDriver driver;
	private String ipClient;
}
