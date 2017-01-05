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
import page.AddUserPage;
import page.LoginPage;

public class MasterFiles_18_AddEditDivision extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);

		newDivision = getUniqueText(7);
		glAccountCode1 = "glNo1";
		glAccountCode2 = "glNo2";
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
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.createNewGLAccount(glAccountCode2);
		
		log.info("Pre-condition - 05: Create new Buyer");
		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole);
		addUserPage.createNewUserWithRole(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", primaryUserRole2);
	}

	@Test(groups = { "regression" }, description = "Check Add Division works")
	public void AddEditDivision_001_CheckAddDivisionWorks() {	
		
		log.info("Step AddEditDivision_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditDivision_001 - 02: Input correct username and password");
		log.info("Step AddEditDivision_001 - 03: Accept Alert message");
		log.info("Step AddEditDivision_001 - 04: Open Add Division page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_project_number.php");

		log.info("Step AddEditDivision_001 - 05: Input new Division");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ProjCode", newDivision);
		
		log.info("Step AddEditDivision_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditDivision_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditDivision_001 - 08: Assign GL Account code");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode1);
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add_field", "2");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "ok", "2");
		
		log.info("Step AddEditDivision_001 - 09: Select Approver");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Approver1", primaryUserName);
		
		log.info("Step AddEditDivision_001 - 10: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditDivision_001 - 11: Input new Division");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ProjCode", newDivision);
		
		log.info("Step AddEditDivision_001 - 12: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description is displayed correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
		
		log.info("VP: Approver is displayed correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Approver1"), primaryUserName);
		
		log.info("VP: GL Account is selected");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		verifyTrue(masterFilesPage.isItemInSelectedList(DriverManager.getDriver(), "sel_Gl", glAccountCode1));
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Division works")
	public void AddEditDivision_002_CheckEdiDivisionWorks() {	
		
		log.info("Step AddEditDivision_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditDivision_002 - 02: Input correct username and password");
		log.info("Step AddEditDivision_002 - 03: Accept Alert message");
		log.info("Step AddEditDivision_002 - 04: Open Add Division page");
		log.info("Step AddEditDivision_002 - 05: Input new Division");
		log.info("Step AddEditDivision_002 - 06: Click on Add button");
		log.info("Step AddEditDivision_002 - 07: Input Description");
		log.info("Step AddEditDivision_002 - 08: Click on Save button");
		log.info("Step AddEditDivision_002 - 09: Input new Division");
		log.info("Step AddEditDivision_002 - 10: Click on Modify button");
		log.info("Step AddEditDivision_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditDivision_002 - 12: Input new data for GL Account code");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "removeall_field");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode2);
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add_field", "2");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "ok", "2");
		
		log.info("Step AddEditDivision_002 - 13: Select Approver");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Approver1", primaryUserName2);
		
		log.info("Step AddEditDivision_002 - 14: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditDivision_002 - 15: Input new Division");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ProjCode", newDivision);
		
		log.info("Step AddEditDivision_002 - 16: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description is displayed correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
		
		log.info("VP: Approver is displayed correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Approver1"), primaryUserName2);
		
		log.info("VP: GL Account is selected");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		verifyTrue(masterFilesPage.isItemInSelectedList(DriverManager.getDriver(), "sel_Gl", glAccountCode2));
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "ok", "2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Division works")
	public void AddEditDivision_003_CheckDeactivateDivisionWorks() {	
		
		log.info("Step AddEditDivision_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditDivision_003 - 02: Input correct username and password");
		log.info("Step AddEditDivision_003 - 03: Accept Alert message");
		log.info("Step AddEditDivision_003 - 04: Open Add Division page");
		log.info("Step AddEditDivision_003 - 05: Input new Division");
		log.info("Step AddEditDivision_003 - 06: Click on Add button");
		log.info("Step AddEditDivision_003 - 07: Input Description");
		log.info("Step AddEditDivision_003 - 08: Click on Save button");
		log.info("Step AddEditDivision_003 - 09: Input new Division");
		log.info("Step AddEditDivision_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditDivision_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditDivision_003 - 12: Input new Division");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ProjCode", newDivision);
		
		log.info("Step AddEditDivision_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Division is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Project is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Division works")
	public void AddEditDivision_004_CheckReactivateDivisionWorks() {	
		
		log.info("Step AddEditDivision_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditDivision_004 - 02: Input correct username and password");
		log.info("Step AddEditDivision_004 - 03: Accept Alert message");
		log.info("Step AddEditDivision_004 - 04: Open Add Division page");
		log.info("Step AddEditDivision_004 - 05: Input new Division");
		log.info("Step AddEditDivision_004 - 06: Click on Add button");
		log.info("Step AddEditDivision_004 - 07: Input Description");
		log.info("Step AddEditDivision_004 - 08: Click on Save button");
		log.info("Step AddEditDivision_004 - 09: Input new Division");
		log.info("Step AddEditDivision_004 - 10: Click on Deactivate button");
		log.info("Step AddEditDivision_004 - 11: Accept alert");
		log.info("Step AddEditDivision_004 - 12: Input new Division");
		log.info("Step AddEditDivision_004 - 13: Click on Modify button");
		log.info("Step AddEditDivision_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Division code by Code works")
	public void AddEditDivision_005_SearchDivisionByCode() {	
		
		log.info("Step AddEditDivision_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditDivision_005 - 02: Input correct username and password");
		log.info("Step AddEditDivision_005 - 03: Accept Alert message");
		log.info("Step AddEditDivision_005 - 04: Open Add Division page");
		log.info("Step AddEditDivision_005 - 05: Input new Division code");
		log.info("Step AddEditDivision_005 - 06: Click on Add button");
		log.info("Step AddEditDivision_005 - 07: Input Description");
		log.info("Step AddEditDivision_005 - 08: Click on Save button");
		log.info("Step AddEditDivision_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_project_number.php");
		
		log.info("Step AddEditDivision_005 - 10: Input Division Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PrjCode", newDivision);
		
		log.info("Step AddEditDivision_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Division code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newDivision, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Division code by Corporation works")
	public void AddEditDivision_006_SearchDivisionByCorporation() {	
		
		log.info("Step AddEditDivision_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditDivision_006 - 02: Input correct username and password");
		log.info("Step AddEditDivision_006 - 03: Accept Alert message");
		log.info("Step AddEditDivision_006 - 04: Open Add Division page");
		log.info("Step AddEditDivision_006 - 05: Input new Division code");
		log.info("Step AddEditDivision_006 - 06: Click on Add button");
		log.info("Step AddEditDivision_006 - 07: Input Description");
		log.info("Step AddEditDivision_006 - 08: Click on Save button");
		log.info("Step AddEditDivision_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_project_number.php");
		
		log.info("Step AddEditDivision_006 - 10: Input Division Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PrjCode", newDivision);
		
		log.info("Step AddEditDivision_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditDivision_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Division code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newDivision, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Division code by Description works")
	public void AddEditDivision_007_SearchDivisionByDescription() {	
		
		log.info("Step AddEditDivision_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditDivision_007 - 02: Input correct username and password");
		log.info("Step AddEditDivision_007 - 03: Accept Alert message");
		log.info("Step AddEditDivision_007 - 04: Open Add Division page");
		log.info("Step AddEditDivision_007 - 05: Input new Division code");
		log.info("Step AddEditDivision_007 - 06: Click on Add button");
		log.info("Step AddEditDivision_007 - 07: Input Description");
		log.info("Step AddEditDivision_007 - 08: Click on Save button");
		log.info("Step AddEditDivision_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_project_number.php");
		
		log.info("Step AddEditDivision_007 - 10: Input Division Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PrjCode", newDivision);
		
		log.info("Step AddEditDivision_007 - 11: Input Division Code description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PrjDesc", "new description 2");
		
		log.info("Step AddEditDivision_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Division code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newDivision, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private AddUserPage addUserPage;
	private String newDivision;
	private String glAccountCode1, glAccountCode2;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, primaryUserRole2, primaryUserName2;
}
