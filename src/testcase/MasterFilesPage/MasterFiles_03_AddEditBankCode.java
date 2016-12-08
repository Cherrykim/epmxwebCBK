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

public class MasterFiles_03_AddEditBankCode extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newBankCode = getUniqueText(3);
	}

	@Test(groups = { "regression" }, description = "Check Add Bank code works")
	public void AddEditBankCode_001_CheckAddBankCodeWorks() {	
		
		log.info("Step AddEditBankCode_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBankCode_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditBankCode_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditBankCode_001 - 04: Open Add Bank code page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_bank_code.php");

		log.info("Step AddEditBankCode_001 - 05: Input new Bank code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BankCode", newBankCode);
		
		log.info("Step AddEditBankCode_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditBankCode_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditBankCode_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBankCode_001 - 09: Input new Bank code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BankCode", newBankCode);
		
		log.info("Step AddEditBankCode_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_BankDesc"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Bank code works")
	public void AddEditBankCode_002_CheckEditBankCodeWorks() {	
		
		log.info("Step AddEditBankCode_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBankCode_002 - 02: Input correct username and password");
		log.info("Step AddEditBankCode_002 - 03: Accept Alert message");
		log.info("Step AddEditBankCode_002 - 04: Open Add labels page");
		log.info("Step AddEditBankCode_002 - 05: Input new Bank code");
		log.info("Step AddEditBankCode_002 - 06: Click on Add button");
		log.info("Step AddEditBankCode_002 - 07: Input Description");
		log.info("Step AddEditBankCode_002 - 08: Click on Save button");
		log.info("Step AddEditBankCode_002 - 09: Input new Bank code");
		log.info("Step AddEditBankCode_002 - 10: Click on Modify button");
		log.info("Step AddEditBankCode_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BankDesc", "new description 2");
		
		log.info("Step AddEditBankCode_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBankCode_002 - 13: Input new Bank code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BankCode", newBankCode);
		
		log.info("Step AddEditBankCode_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_BankDesc"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Bank code works")
	public void AddEditBankCode_003_CheckDeactivateBankCodeWorks() {	
		
		log.info("Step AddEditBankCode_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBankCode_003 - 02: Input correct username and password");
		log.info("Step AddEditBankCode_003 - 03: Accept Alert message");
		log.info("Step AddEditBankCode_003 - 04: Open Add labels page");
		log.info("Step AddEditBankCode_003 - 05: Input new Bank code");
		log.info("Step AddEditBankCode_003 - 06: Click on Add button");
		log.info("Step AddEditBankCode_003 - 07: Input Description");
		log.info("Step AddEditBankCode_003 - 08: Click on Save button");
		log.info("Step AddEditBankCode_003 - 09: Input new Bank code");
		log.info("Step AddEditBankCode_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditBankCode_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBankCode_003 - 12: Input new Bank code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BankCode", newBankCode);
		
		log.info("Step AddEditBankCode_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Bank Code is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Bank Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Bank code works")
	public void AddEditBankCode_004_CheckReactivateBankCodeWorks() {	
		
		log.info("Step AddEditBankCode_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBankCode_004 - 02: Input correct username and password");
		log.info("Step AddEditBankCode_004 - 03: Accept Alert message");
		log.info("Step AddEditBankCode_004 - 04: Open Add labels page");
		log.info("Step AddEditBankCode_004 - 05: Input new Bank code");
		log.info("Step AddEditBankCode_004 - 06: Click on Add button");
		log.info("Step AddEditBankCode_004 - 07: Input Description");
		log.info("Step AddEditBankCode_004 - 08: Click on Save button");
		log.info("Step AddEditBankCode_004 - 09: Input new Bank code");
		log.info("Step AddEditBankCode_004 - 10: Click on Deactivate button");
		log.info("Step AddEditBankCode_004 - 11: Accept alert");
		log.info("Step AddEditBankCode_004 - 12: Input new Bank code");
		log.info("Step AddEditBankCode_004 - 13: Click on Modify button");
		log.info("Step AddEditBankCode_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Bank code by Code works")
	public void AddEditBankCode_005_SearchBankCodeByCode() {	
		
		log.info("Step AddEditBankCode_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBankCode_005 - 02: Input correct username and password");
		log.info("Step AddEditBankCode_005 - 03: Accept Alert message");
		log.info("Step AddEditBankCode_005 - 04: Open Add labels page");
		log.info("Step AddEditBankCode_005 - 05: Input new Bank code");
		log.info("Step AddEditBankCode_005 - 06: Click on Add button");
		log.info("Step AddEditBankCode_005 - 07: Input Description");
		log.info("Step AddEditBankCode_005 - 08: Click on Save button");
		log.info("Step AddEditBankCode_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_bank_code.php");
		
		log.info("Step AddEditBankCode_005 - 10: Input Bank Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BankCode", newBankCode);
		
		log.info("Step AddEditBankCode_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Bank code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newBankCode, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Bank code by Corporation works")
	public void AddEditBankCode_006_SearchBankCodeByCorporation() {	
		
		log.info("Step AddEditBankCode_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBankCode_006 - 02: Input correct username and password");
		log.info("Step AddEditBankCode_006 - 03: Accept Alert message");
		log.info("Step AddEditBankCode_006 - 04: Open Add labels page");
		log.info("Step AddEditBankCode_006 - 05: Input new Bank code");
		log.info("Step AddEditBankCode_006 - 06: Click on Add button");
		log.info("Step AddEditBankCode_006 - 07: Input Description");
		log.info("Step AddEditBankCode_006 - 08: Click on Save button");
		log.info("Step AddEditBankCode_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_bank_code.php");
		
		log.info("Step AddEditBankCode_006 - 10: Input Bank Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BankCode", newBankCode);
		
		log.info("Step AddEditBankCode_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditBankCode_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Bank code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newBankCode, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Bank code by Name works")
	public void AddEditBankCode_007_SearchBankCodeByName() {	
		
		log.info("Step AddEditBankCode_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBankCode_007 - 02: Input correct username and password");
		log.info("Step AddEditBankCode_007 - 03: Accept Alert message");
		log.info("Step AddEditBankCode_007 - 04: Open Add labels page");
		log.info("Step AddEditBankCode_007 - 05: Input new Bank code");
		log.info("Step AddEditBankCode_007 - 06: Click on Add button");
		log.info("Step AddEditBankCode_007 - 07: Input Description");
		log.info("Step AddEditBankCode_007 - 08: Click on Save button");
		log.info("Step AddEditBankCode_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_bank_code.php");
		
		log.info("Step AddEditBankCode_007 - 10: Input Bank Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BankCode", newBankCode);
		
		log.info("Step AddEditBankCode_007 - 11: Input Bank Code Name");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BankDesc", "new description 2");
		
		log.info("Step AddEditBankCode_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Bank code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newBankCode, "new description 2"));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newBankCode;
}
