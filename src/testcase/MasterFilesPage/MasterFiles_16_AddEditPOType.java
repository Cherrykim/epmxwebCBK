package MasterFilesPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.MasterFilesPage;
import page.LoginPage;

public class MasterFiles_16_AddEditPOType extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newPOType = getUniqueText(10);
	}

	@Test(groups = { "regression" }, description = "Check Add PO Type works")
	public void AddEditPOType_001_CheckAddPOTypeWorks() {	
		
		log.info("Step AddEditPOType_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditPOType_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditPOType_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditPOType_001 - 04: Open Add PO Type page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_po_type.php");

		log.info("Step AddEditPOType_001 - 05: Input new PO Type");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PotypeCode", newPOType);
		
		log.info("Step AddEditPOType_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditPOType_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditPOType_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditPOType_001 - 09: Input new PO Type");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PotypeCode", newPOType);
		
		log.info("Step AddEditPOType_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit PO Type works")
	public void AddEditPOType_002_CheckEditPOTypeWorks() {	
		
		log.info("Step AddEditPOType_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditPOType_002 - 02: Input correct username and password");
		log.info("Step AddEditPOType_002 - 03: Accept Alert message");
		log.info("Step AddEditPOType_002 - 04: Open Add labels page");
		log.info("Step AddEditPOType_002 - 05: Input new PO Type");
		log.info("Step AddEditPOType_002 - 06: Click on Add button");
		log.info("Step AddEditPOType_002 - 07: Input Description");
		log.info("Step AddEditPOType_002 - 08: Click on Save button");
		log.info("Step AddEditPOType_002 - 09: Input new PO Type");
		log.info("Step AddEditPOType_002 - 10: Click on Modify button");
		log.info("Step AddEditPOType_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditPOType_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditPOType_002 - 13: Input new PO Type");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PotypeCode", newPOType);
		
		log.info("Step AddEditPOType_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate PO Type works")
	public void AddEditPOType_003_CheckDeactivatePOTypeWorks() {	
		
		log.info("Step AddEditPOType_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditPOType_003 - 02: Input correct username and password");
		log.info("Step AddEditPOType_003 - 03: Accept Alert message");
		log.info("Step AddEditPOType_003 - 04: Open Add labels page");
		log.info("Step AddEditPOType_003 - 05: Input new PO Type");
		log.info("Step AddEditPOType_003 - 06: Click on Add button");
		log.info("Step AddEditPOType_003 - 07: Input Description");
		log.info("Step AddEditPOType_003 - 08: Click on Save button");
		log.info("Step AddEditPOType_003 - 09: Input new PO Type");
		log.info("Step AddEditPOType_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditPOType_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditPOType_003 - 12: Input new PO Type");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PotypeCode", newPOType);
		
		log.info("Step AddEditPOType_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: PO Type is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "P.O. Type is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate PO Type works")
	public void AddEditPOType_004_CheckReactivatePOTypeWorks() {	
		
		log.info("Step AddEditPOType_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditPOType_004 - 02: Input correct username and password");
		log.info("Step AddEditPOType_004 - 03: Accept Alert message");
		log.info("Step AddEditPOType_004 - 04: Open Add labels page");
		log.info("Step AddEditPOType_004 - 05: Input new PO Type");
		log.info("Step AddEditPOType_004 - 06: Click on Add button");
		log.info("Step AddEditPOType_004 - 07: Input Description");
		log.info("Step AddEditPOType_004 - 08: Click on Save button");
		log.info("Step AddEditPOType_004 - 09: Input new PO Type");
		log.info("Step AddEditPOType_004 - 10: Click on Deactivate button");
		log.info("Step AddEditPOType_004 - 11: Accept alert");
		log.info("Step AddEditPOType_004 - 12: Input new PO Type");
		log.info("Step AddEditPOType_004 - 13: Click on Modify button");
		log.info("Step AddEditPOType_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newPOType;
}
