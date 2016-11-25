package page;

import org.openqa.selenium.WebDriver;

import common.DriverManager;

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
	
	public void selectRequiredRadioButton(){
		 click(driver, epmxweb.MasterFilesPage.requiredRadioButton);
	}
	
	public void selectOptionalRadioButton(){
		 click(driver, epmxweb.MasterFilesPage.optionalRadioButton);
	}
	
	public boolean isRequiredRadioButtonChecked(){
		return isControlSelected(driver, epmxweb.MasterFilesPage.requiredRadioButton);
	}
	
	public boolean isOptionalRadioButtonChecked(){
		return isControlSelected(driver, epmxweb.MasterFilesPage.optionalRadioButton);
	}
	
	public boolean isFirstCatalogItemDisplayedCorrectly(String itemName){
//		System.out.println(getAttributeValue(driver, epmxweb.MasterFilesPage.firstCatalogItem, "innerHTML"));
		return getAttributeValue(driver, epmxweb.MasterFilesPage.firstCatalogItem, "innerHTML").contains(itemName);
	}
	
	public boolean isFirstTranslationCurrencyCodeDisplayedCorrectly(String itemName){
//		System.out.println(getAttributeValue(driver, epmxweb.MasterFilesPage.firstTranslationCurrencyCode, "innerHTML"));
		return getAttributeValue(driver, epmxweb.MasterFilesPage.firstTranslationCurrencyCode, "innerHTML").contains(itemName);
	}
	
	public void createNewVendor(String vendorID, String vendorName){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_vendors.php");
		sleep(2);
		inputTextfieldByID(driver, "txt_VendorCode", vendorID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(driver, "txt_VendorName", vendorName);
		clickOnDivByItsText(driver, "Addl Vendor Info");
		inputTextfieldByID(driver, "txt_TaxId", vendorName);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public boolean isPrimaryVendorDisplayedCorrectly(String vendorName){
//		return isControlDisplayed(driver, epmxweb.MasterFilesPage.dynamicFirstCatalogItem, itemName);
//		System.out.println(getAttributeValue(driver, epmxweb.MasterFilesPage.primaryVendor, "innerHTML"));
		return getAttributeValue(driver, epmxweb.MasterFilesPage.primaryVendor, "innerHTML").contains(vendorName);
	}
	
	public void deactiveTranslationCode(String codeName){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_currency_translation.php");
		inputTextfieldByID(driver, "txt_BaseCurCode", codeName);
		clickOnImageButtonByItsSrc(driver, "manage");
		sleep(3);
		if(isImageButtonDisplayed(driver, "deactivate")) clickOnImageButtonByItsSrc(driver, "deactivate");
		acceptAlert(driver);
		sleep();
	}
	
	public void createNewGLAccount(String accountID){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_gl_account_code.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_GLCode", accountID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Desc", "new description");
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewGLAccount(String corpName, String accountID){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_gl_account_code.php");
		sleep(2);
		selectItemFromDropdownByID(driver, "sel_Corporation", corpName);
		inputTextfieldByID(DriverManager.getDriver(), "txt_GLCode", accountID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Desc", "new description");
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewCommodityCode(String codeID){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_commodity_code.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_CommodityCode", codeID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", codeID);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewCommodityCode(String codeID, String vendorName){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_commodity_code.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_CommodityCode", codeID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", codeID);
		inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_PVendor", vendorName);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewTaxCode(String taxID){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_tax_code.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_TaxCode", taxID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewUnitOfMeasure(String unitName){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_units_of_measure.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_UMCode", unitName);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new unit");
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewItemCode(String itemName){
		createNewUnitOfMeasure("um1");
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_material.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_ItemCode", itemName);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UnitMeasure", "um1");
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewItemCode(String itemName, String vendorName){
		createNewUnitOfMeasure("um1");
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_material.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_ItemCode", itemName);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UnitMeasure", "um1");
		inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_PVendor", vendorName);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewCorporation(String corpName){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_corporation.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_CompName", corpName);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewVendorType(String vendorType){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_vendor_type.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_VenType", vendorType);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", vendorType);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewTermsCode(String termsCode){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_terms_code.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", termsCode);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", termsCode);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewCataloge(String itemCode, String description){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_catalog.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_CatalogCode", itemCode);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", itemCode);
		inputSelecterTextfieldByID(driver, "txt_Items0", itemCode+ " : "+description);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public boolean isAlternateVendorRecordDisplayedCorrectly(String vendorName, String itemCode, String itemPrice){
		return isControlDisplayed(driver, epmxweb.MasterFilesPage.dynamicAlternateVendorRecord, vendorName, itemCode, itemPrice);
	}
	
	public void inputNameTextfield(String name, String value){
		type(driver, epmxweb.MasterFilesPage.dynamicTextfieldByName, value, name);
	}
	
	public String getNameTextfieldValue(String name){
		return getAttributeValue(driver, epmxweb.MasterFilesPage.dynamicTextfieldByName, "value", name);
	}
	
	public void switchAddAndModifyCurrency(){
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			clickOnImageButtonByItsSrc(driver, "manage");
		}
	}
	
	public void createNewBillToCode(String billToCode){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_bill_to_code.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_BillToCode", billToCode);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Company", billToCode);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewShipToCode(String shipToCode){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_ship_to_code.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_ShipToCode", shipToCode);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Company", shipToCode);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewPOType(String poType){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_po_type.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_PotypeCode", poType);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", poType);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewJobCode(String jobCode){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_job_numbers.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_JobCode", jobCode);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", jobCode);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewProjectCode(String projectCode){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_project_number.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_ProjCode", projectCode);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", projectCode);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewSpecialText(String text){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_project_number.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_TextCode", text);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextareaByID(DriverManager.getDriver(), "txt_Text", text);
		clickOnElementByItsID(driver, "img_Save");
	}
	private WebDriver driver;
	private String ipClient;
}
