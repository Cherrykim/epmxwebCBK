package AssetManagerPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.AddUserPage;
import page.AssetManagerPage;
import page.LoginPage;
import page.MasterFilesPage;

public class AssetManager_09_AddServiceInformation extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		assetManagerPage = PageFactory.getAssetManagerPage(DriverManager.getDriver(), ipClient);
		newAssetEntry = getUniqueNumber(8);
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create Asset Entry");
		assetManagerPage.createNewAssetEntry(newAssetEntry);
	}

	@Test(groups = { "regression" }, description = "Check Add Service Information works")
	public void AddEditServiceInformation_001_CheckAddServiceInformationWorks() {	
		
		log.info("Step AddEditServiceInformation_001 - 01: Open Add Service Information page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/add_service.php");

		log.info("Step AddEditServiceInformation_001 - 02: Input new Service Information");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNum", newAssetEntry);
		
		log.info("Step AddEditServiceInformation_001 - 03: Click on Add button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditServiceInformation_001 - 04: Input all textfields");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LastServicetDate", "11-11-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_NextServiceDate", "11-11-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ServiceSchedule", "validtext");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ServiceType", "validtext");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ServiceProvider", "validtext");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ServiceContact", "validtext");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ServiceGLAcct", "validtext");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ServicePO", "validtext");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CurrentServiceCost", "11.11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_totalServiceCost", "11.11");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_ServiceNotes", "Notes 1");
		
		log.info("Step AddEditServiceInformation_001 - 07: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		
		log.info("Step AddEditServiceInformation_001 - VP: Check data saved correctly: Warranty period");
		verifyEquals(assetManagerPage.getAlertText(DriverManager.getDriver()), "A new service has been recorded.");
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AssetManagerPage assetManagerPage;
	private String newAssetEntry;
}
