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

public class MasterFiles_19_AddEditReceivingDept extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newReceivingDept = getUniqueText(7);
		glAccountCode1 = "glNo1";
		glAccountCode2 = "glNo2";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.createNewGLAccount(glAccountCode2);
	}

	@Test(groups = { "regression" }, description = "Check Add Receiving Dept works")
	public void AddEditReceivingDept_001_CheckAddReceivingDeptWorks() {	
		
		log.info("Step AddEditReceivingDept_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditReceivingDept_001 - 02: Input correct username and password");
		log.info("Step AddEditReceivingDept_001 - 03: Accept Alert message");
		log.info("Step AddEditReceivingDept_001 - 04: Open Add Receiving Dept page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_receiving_department.php");

		log.info("Step AddEditReceivingDept_001 - 05: Input new Receiving Dept");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RecvCode", newReceivingDept);
		
		log.info("Step AddEditReceivingDept_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditReceivingDept_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RecvDesc", "new description");
		
		log.info("Step AddEditReceivingDept_001 - 08: Input GL Account code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode1);
		
		log.info("Step AddEditReceivingDept_001 - 09: Input Miscellaneous");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Misc", "misc 1");
		
		log.info("Step AddEditReceivingDept_001 - 10: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditReceivingDept_001 - 11: Input new Receiving Dept");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RecvCode", newReceivingDept);
		
		log.info("Step AddEditReceivingDept_001 - 12: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description is displayed correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_RecvDesc"), "new description");
		
		log.info("VP: GL Account is displayed correctly");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode1));
		
		log.info("VP: Miscellaneous is displayed correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Misc"), "misc 1");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Receiving Dept works")
	public void AddEditReceivingDept_002_CheckEdiReceivingDeptWorks() {	
		
		log.info("Step AddEditReceivingDept_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditReceivingDept_002 - 02: Input correct username and password");
		log.info("Step AddEditReceivingDept_002 - 03: Accept Alert message");
		log.info("Step AddEditReceivingDept_002 - 04: Open Add labels page");
		log.info("Step AddEditReceivingDept_002 - 05: Input new Receiving Dept");
		log.info("Step AddEditReceivingDept_002 - 06: Click on Add button");
		log.info("Step AddEditReceivingDept_002 - 07: Input Description");
		log.info("Step AddEditReceivingDept_002 - 08: Click on Save button");
		log.info("Step AddEditReceivingDept_002 - 09: Input new Receiving Dept");
		log.info("Step AddEditReceivingDept_002 - 10: Click on Modify button");
		log.info("Step AddEditReceivingDept_002 - 11: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RecvDesc", "new description 2");
		
		log.info("Step AddEditReceivingDept_001 - 12: Input GL Account code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode2);
		
		log.info("Step AddEditReceivingDept_001 - 13: Input Miscellaneous");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Misc", "misc 2");
		
		log.info("Step AddEditReceivingDept_002 - 14: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditReceivingDept_002 - 15: Input new Receiving Dept");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RecvCode", newReceivingDept);
		
		log.info("Step AddEditReceivingDept_002 - 16: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description is displayed correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_RecvDesc"), "new description 2");
		
		log.info("VP: GL Account is displayed correctly");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode2));
		
		log.info("VP: Miscellaneous is displayed correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Misc"), "misc 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Receiving Dept works")
	public void AddEditReceivingDept_003_CheckDeactivateReceivingDeptWorks() {	
		
		log.info("Step AddEditReceivingDept_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditReceivingDept_003 - 02: Input correct username and password");
		log.info("Step AddEditReceivingDept_003 - 03: Accept Alert message");
		log.info("Step AddEditReceivingDept_003 - 04: Open Add labels page");
		log.info("Step AddEditReceivingDept_003 - 05: Input new Receiving Dept");
		log.info("Step AddEditReceivingDept_003 - 06: Click on Add button");
		log.info("Step AddEditReceivingDept_003 - 07: Input Description");
		log.info("Step AddEditReceivingDept_003 - 08: Click on Save button");
		log.info("Step AddEditReceivingDept_003 - 09: Input new Receiving Dept");
		log.info("Step AddEditReceivingDept_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditReceivingDept_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditReceivingDept_003 - 12: Input new Receiving Dept");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RecvCode", newReceivingDept);
		
		log.info("Step AddEditReceivingDept_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Object Code is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Receiving Dept. is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Receiving Dept works")
	public void AddEditReceivingDept_004_CheckReactivateReceivingDeptWorks() {	
		
		log.info("Step AddEditReceivingDept_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditReceivingDept_004 - 02: Input correct username and password");
		log.info("Step AddEditReceivingDept_004 - 03: Accept Alert message");
		log.info("Step AddEditReceivingDept_004 - 04: Open Add labels page");
		log.info("Step AddEditReceivingDept_004 - 05: Input new Receiving Dept");
		log.info("Step AddEditReceivingDept_004 - 06: Click on Add button");
		log.info("Step AddEditReceivingDept_004 - 07: Input Description");
		log.info("Step AddEditReceivingDept_004 - 08: Click on Save button");
		log.info("Step AddEditReceivingDept_004 - 09: Input new Receiving Dept");
		log.info("Step AddEditReceivingDept_004 - 10: Click on Deactivate button");
		log.info("Step AddEditReceivingDept_004 - 11: Accept alert");
		log.info("Step AddEditReceivingDept_004 - 12: Input new Receiving Dept");
		log.info("Step AddEditReceivingDept_004 - 13: Click on Modify button");
		log.info("Step AddEditReceivingDept_004 - 14: Accept alert");
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
	private String newReceivingDept;
	private String glAccountCode1, glAccountCode2;
}
