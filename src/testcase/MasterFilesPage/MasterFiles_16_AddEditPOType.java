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
	
	@Test(groups = { "regression" }, description = "Check Search PO Type code by Code works")
	public void AddEditPOType_005_SearchPOTypeByCode() {	
		
		log.info("Step AddEditPOType_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditPOType_005 - 02: Input correct username and password");
		log.info("Step AddEditPOType_005 - 03: Accept Alert message");
		log.info("Step AddEditPOType_005 - 04: Open Add labels page");
		log.info("Step AddEditPOType_005 - 05: Input new PO Type code");
		log.info("Step AddEditPOType_005 - 06: Click on Add button");
		log.info("Step AddEditPOType_005 - 07: Input Description");
		log.info("Step AddEditPOType_005 - 08: Click on Save button");
		log.info("Step AddEditPOType_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_po_type.php");
		
		log.info("Step AddEditPOType_005 - 10: Input PO Type Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PoTypeCode", newPOType);
		
		log.info("Step AddEditPOType_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: PO Type code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newPOType, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search PO Type code by Corporation works")
	public void AddEditPOType_006_SearchPOTypeByCorporation() {	
		
		log.info("Step AddEditPOType_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditPOType_006 - 02: Input correct username and password");
		log.info("Step AddEditPOType_006 - 03: Accept Alert message");
		log.info("Step AddEditPOType_006 - 04: Open Add labels page");
		log.info("Step AddEditPOType_006 - 05: Input new PO Type code");
		log.info("Step AddEditPOType_006 - 06: Click on Add button");
		log.info("Step AddEditPOType_006 - 07: Input Description");
		log.info("Step AddEditPOType_006 - 08: Click on Save button");
		log.info("Step AddEditPOType_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_po_type.php");
		
		log.info("Step AddEditPOType_006 - 10: Input PO Type Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PoTypeCode", newPOType);
		
		log.info("Step AddEditPOType_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditPOType_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: PO Type code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newPOType, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search PO Type code by Description works")
	public void AddEditPOType_007_SearchPOTypeByDescription() {	
		
		log.info("Step AddEditPOType_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditPOType_007 - 02: Input correct username and password");
		log.info("Step AddEditPOType_007 - 03: Accept Alert message");
		log.info("Step AddEditPOType_007 - 04: Open Add labels page");
		log.info("Step AddEditPOType_007 - 05: Input new PO Type code");
		log.info("Step AddEditPOType_007 - 06: Click on Add button");
		log.info("Step AddEditPOType_007 - 07: Input Description");
		log.info("Step AddEditPOType_007 - 08: Click on Save button");
		log.info("Step AddEditPOType_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_po_type.php");
		
		log.info("Step AddEditPOType_007 - 10: Input PO Type Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PoTypeCode", newPOType);
		
		log.info("Step AddEditPOType_007 - 11: Input PO Type Code description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PoTypeDesc", "new description 2");
		
		log.info("Step AddEditPOType_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: PO Type code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newPOType, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newPOType;
}
