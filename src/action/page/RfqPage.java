package page;

import org.openqa.selenium.WebDriver;

import common.DriverManager;

public class RfqPage extends AbstractPage {

	public RfqPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
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
	
	public boolean isVendorRecordDisplayed(String vendorID, String vendorName){
		return isControlDisplayed(driver, epmxweb.RfqPage.dynamicVendorRecord, vendorID, vendorName);
	}
	
	private WebDriver driver;
	private String ipClient;
}
