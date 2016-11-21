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

public class MasterFiles_10_AddEditGLAccount extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newGLAccount = getUniqueText(7);
	}

	@Test(groups = { "regression" }, description = "Check Add GL Account works")
	public void AddEditGLAccount_001_CheckAddGLAccountWorks() {	
		
		log.info("Step AddEditGLAccount_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditGLAccount_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditGLAccount_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditGLAccount_001 - 04: Open Add GL Account page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_gl_account_code.php");

		log.info("Step AddEditGLAccount_001 - 05: Input new GL Account");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GLCode", newGLAccount);
		
		log.info("Step AddEditGLAccount_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditGLAccount_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Desc", "new description");
		
		log.info("Step AddEditGLAccount_001 - 08: Input all data for Budget Period 1");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ContAmt1", "11.00");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PeriodFrom1", "11-17-2020");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PeriodThru1", "11-18-2020");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AccumAmt1", "11.00");
		
		log.info("Step AddEditGLAccount_001 - 09: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditGLAccount_001 - 10: Input new GL Account");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GLCode", newGLAccount);
		
		log.info("Step AddEditGLAccount_001 - 11: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Desc"), "new description");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ContAmt1").trim(), "11.00");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_PeriodFrom1"), "11-17-2020");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_PeriodThru1"), "11-18-2020");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AccumAmt1"), "11.00");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit GL Account works")
	public void AddEditGLAccount_002_CheckEdiGLAccountWorks() {	
		
		log.info("Step AddEditGLAccount_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditGLAccount_002 - 02: Input correct username and password");
		log.info("Step AddEditGLAccount_002 - 03: Accept Alert message");
		log.info("Step AddEditGLAccount_002 - 04: Open Add labels page");
		log.info("Step AddEditGLAccount_002 - 05: Input new GL Account");
		log.info("Step AddEditGLAccount_002 - 06: Click on Add button");
		log.info("Step AddEditGLAccount_002 - 07: Input Description");
		log.info("Step AddEditGLAccount_002 - 08: Click on Save button");
		log.info("Step AddEditGLAccount_002 - 09: Input new GL Account");
		log.info("Step AddEditGLAccount_002 - 10: Click on Modify button");
		log.info("Step AddEditGLAccount_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Desc", "new description 2");
		
		log.info("Step AddEditGLAccount_002 - 12: Input new data for Budget Period 1");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ContAmt1", "12.00");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PeriodFrom1", "12-17-2020");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PeriodThru1", "12-18-2020");
//		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AccumAmt1", "12.00");
		
		log.info("Step AddEditGLAccount_002 - 13: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditGLAccount_002 - 14: Input new GL Account");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GLCode", newGLAccount);
		
		log.info("Step AddEditGLAccount_002 - 15: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Desc"), "new description 2");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ContAmt1").trim(), "12.00");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_PeriodFrom1"), "12-17-2020");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_PeriodThru1"), "12-18-2020");
//		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AccumAmt1"), "12.00");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate GL Account works")
	public void AddEditGLAccount_003_CheckDeactivateGLAccountWorks() {	
		
		log.info("Step AddEditGLAccount_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditGLAccount_003 - 02: Input correct username and password");
		log.info("Step AddEditGLAccount_003 - 03: Accept Alert message");
		log.info("Step AddEditGLAccount_003 - 04: Open Add labels page");
		log.info("Step AddEditGLAccount_003 - 05: Input new GL Account");
		log.info("Step AddEditGLAccount_003 - 06: Click on Add button");
		log.info("Step AddEditGLAccount_003 - 07: Input Description");
		log.info("Step AddEditGLAccount_003 - 08: Click on Save button");
		log.info("Step AddEditGLAccount_003 - 09: Input new GL Account");
		log.info("Step AddEditGLAccount_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditGLAccount_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditGLAccount_003 - 12: Input new GL Account");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GLCode", newGLAccount);
		
		log.info("Step AddEditGLAccount_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: G/L Account Code is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "G/L Account Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate GL Account works")
	public void AddEditGLAccount_004_CheckReactivateGLAccountWorks() {	
		
		log.info("Step AddEditGLAccount_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditGLAccount_004 - 02: Input correct username and password");
		log.info("Step AddEditGLAccount_004 - 03: Accept Alert message");
		log.info("Step AddEditGLAccount_004 - 04: Open Add labels page");
		log.info("Step AddEditGLAccount_004 - 05: Input new GL Account");
		log.info("Step AddEditGLAccount_004 - 06: Click on Add button");
		log.info("Step AddEditGLAccount_004 - 07: Input Description");
		log.info("Step AddEditGLAccount_004 - 08: Click on Save button");
		log.info("Step AddEditGLAccount_004 - 09: Input new GL Account");
		log.info("Step AddEditGLAccount_004 - 10: Click on Deactivate button");
		log.info("Step AddEditGLAccount_004 - 11: Accept alert");
		log.info("Step AddEditGLAccount_004 - 12: Input new GL Account");
		log.info("Step AddEditGLAccount_004 - 13: Click on Modify button");
		log.info("Step AddEditGLAccount_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search GL Account code by Code works")
	public void AddEditGLAccount_005_SearchGLAccountByCode() {	
		
		log.info("Step AddEditGLAccount_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditGLAccount_005 - 02: Input correct username and password");
		log.info("Step AddEditGLAccount_005 - 03: Accept Alert message");
		log.info("Step AddEditGLAccount_005 - 04: Open Add labels page");
		log.info("Step AddEditGLAccount_005 - 05: Input new GL Account code");
		log.info("Step AddEditGLAccount_005 - 06: Click on Add button");
		log.info("Step AddEditGLAccount_005 - 07: Input Description");
		log.info("Step AddEditGLAccount_005 - 08: Click on Save button");
		log.info("Step AddEditGLAccount_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_gl_account_code.php");
		
		log.info("Step AddEditGLAccount_005 - 10: Input GL Account Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GlAcc", newGLAccount);
		
		log.info("Step AddEditGLAccount_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: GL Account code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newGLAccount, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search GL Account code by Corporation works")
	public void AddEditGLAccount_006_SearchGLAccountByCorporation() {	
		
		log.info("Step AddEditGLAccount_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditGLAccount_006 - 02: Input correct username and password");
		log.info("Step AddEditGLAccount_006 - 03: Accept Alert message");
		log.info("Step AddEditGLAccount_006 - 04: Open Add labels page");
		log.info("Step AddEditGLAccount_006 - 05: Input new GL Account code");
		log.info("Step AddEditGLAccount_006 - 06: Click on Add button");
		log.info("Step AddEditGLAccount_006 - 07: Input Description");
		log.info("Step AddEditGLAccount_006 - 08: Click on Save button");
		log.info("Step AddEditGLAccount_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_gl_account_code.php");
		
		log.info("Step AddEditGLAccount_006 - 10: Input GL Account Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GlAcc", newGLAccount);
		
		log.info("Step AddEditGLAccount_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditGLAccount_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: GL Account code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newGLAccount, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search GL Account code by Description works")
	public void AddEditGLAccount_007_SearchGLAccountByDescription() {	
		
		log.info("Step AddEditGLAccount_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditGLAccount_007 - 02: Input correct username and password");
		log.info("Step AddEditGLAccount_007 - 03: Accept Alert message");
		log.info("Step AddEditGLAccount_007 - 04: Open Add labels page");
		log.info("Step AddEditGLAccount_007 - 05: Input new GL Account code");
		log.info("Step AddEditGLAccount_007 - 06: Click on Add button");
		log.info("Step AddEditGLAccount_007 - 07: Input Description");
		log.info("Step AddEditGLAccount_007 - 08: Click on Save button");
		log.info("Step AddEditGLAccount_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_gl_account_code.php");
		
		log.info("Step AddEditGLAccount_007 - 10: Input GL Account Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GlAcc", newGLAccount);
		
		log.info("Step AddEditGLAccount_007 - 11: Input GL Account Code description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GlAccDesc", "new description 2");
		
		log.info("Step AddEditGLAccount_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: GL Account code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newGLAccount, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newGLAccount;
}
