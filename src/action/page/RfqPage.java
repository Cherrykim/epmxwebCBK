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
		clickOnDivByItsText(driver, "Attachments");
		if(isControlDisplayed(driver, epmxweb.RfqPage.dynamicAttachment, "datatest")){
			clickOnImageButtonByItsSrc(driver, "delete.gif");
			acceptAlert(driver);
		}
		switchToFrame(driver, epmxweb.RfqPage.iframeAttachment);
		uploadFile(driver, "fl_Attachment", fileName);
		clickOnElementByItsValue(driver, "Add Attachment");
		switchToTopWindowFrame(driver);
		sleep();
	}
	
	public boolean isAttachmentDisplayed(String fileName){
		clickOnDivByItsText(driver, "Attachments");
		return isControlDisplayed(driver, epmxweb.RfqPage.dynamicAttachment, fileName);
	}
	private WebDriver driver;
	private String ipClient;
}
