package PurchaseOrderPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.MasterFilesPage;
import page.POPage;
import page.AddUserPage;
import page.LoginPage;

public class PO_01_AddEditBlanketPO extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		poPage = PageFactory.getPOPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		newBlanketPO = getUniqueText(7);
		
		vendorID1 = "110320161";
		vendorName1 = "Vendor 1";
		vendorID2 = "110320162";
		vendorName2 = "Vendor 2";
		
		bill1 = "BillCd1";
		billToCode1= bill1 + " : "+ bill1;
		bill2 = "BillCd2";
		billToCode2= bill2 + " : "+ bill2;
		
		ship1 = "ShipCd1";
		shipToCode1= ship1 + " : "+ ship1;
		ship2 = "ShipCd2";
		shipToCode2= ship2 + " : "+ ship2;
		
		po1 = "POType1";
		poType1= po1 + " : "+ po1;
		po2 = "POType2";
		poType2= po2 + " : "+ po2;
		
		job1 = "JobCode1";
		jobCode1= job1 + " : "+ job1;
		job2 = "JobCode2";
		jobCode2= job2 + " : "+ job2;
		
		termsCode1 = "te1";
		terms1 = termsCode1+ " : "+termsCode1;
		termsCode2 = "te2";
		terms2 = termsCode2+ " : "+termsCode2;
		
		text1 = "tx1";
		specialText1= text1 + " : "+ text1;
		text2 = "tx2";
		specialText2= text2 + " : "+ text2;
		
		projectCode1 = "Project1";
		projectCode2 = "Project2";
		
		glAccountCode1 = "glNo1";
		glAccountCode2 = "glNo2";
		
		taxCode1 = "tax1";
		taxCode2 = "tax2";
		
		primaryBuyerID = "110320161";
		primaryBuyerFirstName = "Primary";
		primaryBuyerLastName = "Buyer";
		primaryUserName = "Primary Buyer";
		primaryUserRole = "Requesters";
		primaryBuyerID2 = "110320162";
		primaryBuyerFirstName2 = "Primary2";
		primaryBuyerLastName2 = "Buyer2";
		primaryUserName2 = "Primary2 Buyer2";
		primaryUserRole2 = "Requesters";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create new Vendor");
		masterFilesPage.createNewVendor(vendorID1, vendorName1);
		masterFilesPage.createNewVendor(vendorID2, vendorName2);
		
		log.info("Pre-condition - 05: Create new Buyer");
		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole);
		addUserPage.createNewUserWithRole(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", primaryUserRole2);
		
		log.info("Step Pre-condition - 05: Create new Bill-to Code");
		masterFilesPage.createNewBillToCode(bill1);
		masterFilesPage.createNewBillToCode(bill2);
		
		log.info("Step Pre-condition - 05: Create new Ship-to Code");
		masterFilesPage.createNewShipToCode(ship1);
		masterFilesPage.createNewShipToCode(ship2);
		
		log.info("Step Pre-condition - 05: Create new PO Type");
		masterFilesPage.createNewPOType(po1);
		masterFilesPage.createNewPOType(po2);
		
		log.info("Step Pre-condition - 04: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.createNewGLAccount(glAccountCode2);
		
		log.info("Step Pre-condition - 05: Create new PO Type");
		masterFilesPage.createNewJobCode(job1);
		masterFilesPage.createNewJobCode(job2);
		
		log.info("Step Pre-condition - 05: Create new PO Type");
		masterFilesPage.createNewProjectCode(projectCode1);
		masterFilesPage.createNewProjectCode(projectCode2);	
		
		log.info("Step Pre-condition - 04: Create new Terms code");
		masterFilesPage.createNewTermsCode(termsCode1);
		masterFilesPage.createNewTermsCode(termsCode2);
		
		log.info("Step Pre-condition - 04: Create Tax Code");
		masterFilesPage.createNewTaxCode(taxCode1);
		masterFilesPage.createNewTaxCode(taxCode2);
		
		log.info("Step Pre-condition - 04: Create Special text");
		masterFilesPage.createNewSpecialText(text1);
		masterFilesPage.createNewSpecialText(text2);
		
	}

	@Test(groups = { "regression" }, description = "Check Add Blanket PO works")
	public void AddEditBlanketPO_001_CheckAddBlanketPOWorks() {	
		
		log.info("Step AddEditBlanketPO_001 - 04: Open Add Blanket PO page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/add_blanket_po.php");

		log.info("Step AddEditBlanketPO_001 - 05: Input new Blanket PO");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newBlanketPO);
		
		log.info("Step AddEditBlanketPO_001 - 05: Input Vendor");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		
		log.info("Step AddEditBlanketPO_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditBlanketPO_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditBlanketPO_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBlanketPO_001 - 09: Input new Blanket PO");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BlanketPO", newBlanketPO);
		
		log.info("Step AddEditBlanketPO_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_1099Desc"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Blanket PO works")
	public void AddEditBlanketPO_002_CheckEditBlanketPOWorks() {	
		
		log.info("Step AddEditBlanketPO_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_002 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_002 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_002 - 04: Open Add labels page");
		log.info("Step AddEditBlanketPO_002 - 05: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_002 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_002 - 07: Input Description");
		log.info("Step AddEditBlanketPO_002 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_002 - 09: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_002 - 10: Click on Modify button");
		log.info("Step AddEditBlanketPO_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Desc", "new description 2");
		
		log.info("Step AddEditBlanketPO_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBlanketPO_002 - 13: Input new Blanket PO");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BlanketPO", newBlanketPO);
		
		log.info("Step AddEditBlanketPO_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_1099Desc"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Blanket PO works")
	public void AddEditBlanketPO_003_CheckDeactivateBlanketPOWorks() {	
		
		log.info("Step AddEditBlanketPO_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_003 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_003 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_003 - 04: Open Add labels page");
		log.info("Step AddEditBlanketPO_003 - 05: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_003 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_003 - 07: Input Description");
		log.info("Step AddEditBlanketPO_003 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_003 - 09: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditBlanketPO_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBlanketPO_003 - 12: Input new Blanket PO");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BlanketPO", newBlanketPO);
		
		log.info("Step AddEditBlanketPO_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Blanket PO is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Blanket PO is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Blanket PO works")
	public void AddEditBlanketPO_004_CheckReactivateBlanketPOWorks() {	
		
		log.info("Step AddEditBlanketPO_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_004 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_004 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_004 - 04: Open Add labels page");
		log.info("Step AddEditBlanketPO_004 - 05: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_004 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_004 - 07: Input Description");
		log.info("Step AddEditBlanketPO_004 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_004 - 09: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_004 - 10: Click on Deactivate button");
		log.info("Step AddEditBlanketPO_004 - 11: Accept alert");
		log.info("Step AddEditBlanketPO_004 - 12: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_004 - 13: Click on Modify button");
		log.info("Step AddEditBlanketPO_004 - 14: Accept alert");
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
	private POPage poPage;
	private AddUserPage addUserPage;
	private String newBlanketPO;
	private String bill1, bill2, billToCode1, billToCode2, ship1, ship2, shipToCode1, shipToCode2, vendorID1, vendorName1, vendorID2, vendorName2;
	private String po1, po2, poType1, poType2;
	private String job1, job2, jobCode1, jobCode2;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, primaryUserRole2, primaryUserName2;
	private String glAccountCode1, glAccountCode2;
	private String projectCode1, projectCode2;
	private String terms1, terms2, termsCode1, termsCode2;
	private String taxCode1, taxCode2;
	private String text1, text2, specialText1, specialText2;
}
