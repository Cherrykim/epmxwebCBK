package page;

import org.openqa.selenium.WebDriver;

import common.Constant;

public class UltilitiesPage extends AbstractPage {

	public UltilitiesPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public void confirmMasterPassword(){
		inputTextfieldByID(driver, "txt_Mp", Constant.LoginData.MASTER_PASSWORD);
		clickOnElementByItsID(driver, "btn_MasterPassOk");
		sleep(2);
	}
	
	public void enableAllocation(){
		openLink(driver, "https://cherry.epmxweb.com/utilities/userclass_submodule_access.php");
		confirmMasterPassword();
		inputSelecterTextfieldByID(driver, "txt_UserClass", "Admin/Asset");
		sleep(4);
		clickLinkByItsText(driver, "Master Files", "2");
		sleep(3);
		click(driver, epmxweb.UltilitiesPage.controlFileExpand);
		click(driver, epmxweb.UltilitiesPage.allocationMaintain);
		clickOnImageButtonByItsSrc(driver, "save.gif");
	}
	
	private WebDriver driver;
	private String ipClient;
}
