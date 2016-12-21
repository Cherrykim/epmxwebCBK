package page;

import org.openqa.selenium.WebDriver;

import common.DriverManager;

public class POPage extends AbstractPage {

	public POPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public String createPONumber(String poNumber, String vendorID, String vendorName){
		openLink(driver, "https://cherry.epmxweb.com/po/add_blanket_po.php");
		String currentDate = getTextfieldByID(driver, "txt_PoDate");
		inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", poNumber);
		inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorID + " : " +vendorName);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			clickOnElementByItsID(driver, "img_Modify");
			return poNumber + " : " + currentDate + " : " +vendorName;
		}
		clickOnElementByItsID(driver, "img_Save");
		clickOnElementByItsID(DriverManager.getDriver(), "chk_UpType1");
		clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		sleep(3);
		return poNumber + " : " + currentDate + " : " +vendorName;
	}
	
	public String getOrderDate(){
		openTab(driver, "P.O. Review");
		return getText(driver, epmxweb.POPage.orderDate);
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
	
	public boolean isAttachmentDisplayed(String fileName){
		openTab(driver, "Attachments");
		return isControlDisplayed(driver, epmxweb.RfqPage.dynamicAttachment, fileName);
	}
	
	private WebDriver driver;
	private String ipClient;
}
