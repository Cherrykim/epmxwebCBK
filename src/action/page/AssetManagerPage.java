package page;

import org.openqa.selenium.WebDriver;

import common.DriverManager;

public class AssetManagerPage extends AbstractPage {

	public AssetManagerPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public boolean isWelcomeMessageDisplayed(){
		return getText(driver, epmxweb.MainPage.welcomeMessage).contains("Welcome");
	}
	
	public void createNewAssetCategory(String value){
		openLink(driver, "https://cherry.epmxweb.com/asset_manager/add_asset_category.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_CategoryCode", value);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", value);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewAssetDepartment(String value){
		openLink(driver, "https://cherry.epmxweb.com/asset_manager/add_asset_department.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_DepartmentCode", value);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", value);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewAssetStatus(String value){
		openLink(driver, "https://cherry.epmxweb.com/asset_manager/add_asset_status.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_StatusCode", value);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", value);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewAssetType(String value){
		openLink(driver, "https://cherry.epmxweb.com/asset_manager/add_asset_type.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_TypeCode", value);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", value);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewAssetUnit(String value){
		openLink(driver, "https://cherry.epmxweb.com/asset_manager/add_asset_unit.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_UnitCode", value);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_Description", value);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewAssetLocation(String value){
		openLink(driver, "https://cherry.epmxweb.com/asset_manager/add_asset_location.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_LocationCode", value);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDescription", value);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void addAttachment(String fileName){
		openTab(driver, "Attachments");
		if(isControlDisplayed(driver, epmxweb.RfqPage.dynamicAttachment, "datatest")){
			click(driver, epmxweb.RfqPage.deleteFirstAttachment);
			acceptAlert(driver);
		}
		switchToFrame(driver, epmxweb.RfqPage.iframeAttachment);
		uploadFile(driver, "fl_Attachment", fileName);
		clickOnElementByItsValue(driver, "Add Attachment");
		switchToTopWindowFrame(driver);
		sleep();
	}
	
	public void createNewAssetEntry(String value){
		openLink(driver, "https://cherry.epmxweb.com/asset_manager/add_asset.php");
		sleep(2);
		inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNum", value);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextareaByID(DriverManager.getDriver(), "txt_AssetDesc", value);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public boolean isAttachmentDisplayed(String fileName){
		openTab(driver, "Attachments");
		return isControlDisplayed(driver, epmxweb.RfqPage.dynamicAttachment, fileName);
	}
	private WebDriver driver;
	private String ipClient;
}
