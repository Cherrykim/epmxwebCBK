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

public class MasterFiles_13_AddEditJobNumber extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newJobNumber = getUniqueText(7);
		glAccountCode1 = "glNo1";
		glAccountCode2 = "glNo2";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.createNewGLAccount(glAccountCode2);
	}

	@Test(groups = { "regression" }, description = "Check Add Job Number works")
	public void AddEditJobNumber_001_CheckAddJobNumberWorks() {	
		
		log.info("Step AddEditJobNumber_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditJobNumber_001 - 02: Input correct username and password");
		log.info("Step AddEditJobNumber_001 - 03: Accept Alert message");
		log.info("Step AddEditJobNumber_001 - 04: Open Add Job Number page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_job_numbers.php");

		log.info("Step AddEditJobNumber_001 - 05: Input new Job Number");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_JobCode", newJobNumber);
		
		log.info("Step AddEditJobNumber_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditJobNumber_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditJobNumber_001 - 08: Assign GL Account code");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode1);
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add_field", "2");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "ok", "2");
		
		log.info("Step AddEditJobNumber_001 - 09: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditJobNumber_001 - 10: Input new Job Number");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_JobCode", newJobNumber);
		
		log.info("Step AddEditJobNumber_001 - 11: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description is displayed correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
		
		log.info("VP: GL Account is selected");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		verifyTrue(masterFilesPage.isItemInSelectedList(DriverManager.getDriver(), "sel_Gl", glAccountCode1));
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Job Number works")
	public void AddEditJobNumber_002_CheckEdiJobNumberWorks() {	
		
		log.info("Step AddEditJobNumber_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditJobNumber_002 - 02: Input correct username and password");
		log.info("Step AddEditJobNumber_002 - 03: Accept Alert message");
		log.info("Step AddEditJobNumber_002 - 04: Open Add Job Number page");
		log.info("Step AddEditJobNumber_002 - 05: Input new Job Number");
		log.info("Step AddEditJobNumber_002 - 06: Click on Add button");
		log.info("Step AddEditJobNumber_002 - 07: Input Description");
		log.info("Step AddEditJobNumber_002 - 08: Click on Save button");
		log.info("Step AddEditJobNumber_002 - 09: Input new Job Number");
		log.info("Step AddEditJobNumber_002 - 10: Click on Modify button");
		log.info("Step AddEditJobNumber_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditJobNumber_002 - 12: Input new data for GL Account code");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "removeall_field");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode2);
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add_field", "2");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "ok", "2");
		
		log.info("Step AddEditJobNumber_002 - 13: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditJobNumber_002 - 14: Input new Job Number");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_JobCode", newJobNumber);
		
		log.info("Step AddEditJobNumber_002 - 15: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description is displayed correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
		
		log.info("VP: GL Account is selected");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		verifyTrue(masterFilesPage.isItemInSelectedList(DriverManager.getDriver(), "sel_Gl", glAccountCode2));
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "ok", "2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Job Number works")
	public void AddEditJobNumber_003_CheckDeactivateJobNumberWorks() {	
		
		log.info("Step AddEditJobNumber_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditJobNumber_003 - 02: Input correct username and password");
		log.info("Step AddEditJobNumber_003 - 03: Accept Alert message");
		log.info("Step AddEditJobNumber_003 - 04: Open Add Job Number page");
		log.info("Step AddEditJobNumber_003 - 05: Input new Job Number");
		log.info("Step AddEditJobNumber_003 - 06: Click on Add button");
		log.info("Step AddEditJobNumber_003 - 07: Input Description");
		log.info("Step AddEditJobNumber_003 - 08: Click on Save button");
		log.info("Step AddEditJobNumber_003 - 09: Input new Job Number");
		log.info("Step AddEditJobNumber_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditJobNumber_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditJobNumber_003 - 12: Input new Job Number");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_JobCode", newJobNumber);
		
		log.info("Step AddEditJobNumber_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Object Code is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Job Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Job Number works")
	public void AddEditJobNumber_004_CheckReactivateJobNumberWorks() {	
		
		log.info("Step AddEditJobNumber_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditJobNumber_004 - 02: Input correct username and password");
		log.info("Step AddEditJobNumber_004 - 03: Accept Alert message");
		log.info("Step AddEditJobNumber_004 - 04: Open Add Job Number page");
		log.info("Step AddEditJobNumber_004 - 05: Input new Job Number");
		log.info("Step AddEditJobNumber_004 - 06: Click on Add button");
		log.info("Step AddEditJobNumber_004 - 07: Input Description");
		log.info("Step AddEditJobNumber_004 - 08: Click on Save button");
		log.info("Step AddEditJobNumber_004 - 09: Input new Job Number");
		log.info("Step AddEditJobNumber_004 - 10: Click on Deactivate button");
		log.info("Step AddEditJobNumber_004 - 11: Accept alert");
		log.info("Step AddEditJobNumber_004 - 12: Input new Job Number");
		log.info("Step AddEditJobNumber_004 - 13: Click on Modify button");
		log.info("Step AddEditJobNumber_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Job Number code by Code works")
	public void AddEditJobNumber_005_SearchJobNumberByCode() {	
		
		log.info("Step AddEditJobNumber_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditJobNumber_005 - 02: Input correct username and password");
		log.info("Step AddEditJobNumber_005 - 03: Accept Alert message");
		log.info("Step AddEditJobNumber_005 - 04: Open Add Job Number page");
		log.info("Step AddEditJobNumber_005 - 05: Input new Job Number code");
		log.info("Step AddEditJobNumber_005 - 06: Click on Add button");
		log.info("Step AddEditJobNumber_005 - 07: Input Description");
		log.info("Step AddEditJobNumber_005 - 08: Click on Save button");
		log.info("Step AddEditJobNumber_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_job_numbers.php");
		
		log.info("Step AddEditJobNumber_005 - 10: Input Job Number Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_JobCode", newJobNumber);
		
		log.info("Step AddEditJobNumber_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Job Number code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newJobNumber, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Job Number code by Corporation works")
	public void AddEditJobNumber_006_SearchJobNumberByCorporation() {	
		
		log.info("Step AddEditJobNumber_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditJobNumber_006 - 02: Input correct username and password");
		log.info("Step AddEditJobNumber_006 - 03: Accept Alert message");
		log.info("Step AddEditJobNumber_006 - 04: Open Add Job Number page");
		log.info("Step AddEditJobNumber_006 - 05: Input new Job Number code");
		log.info("Step AddEditJobNumber_006 - 06: Click on Add button");
		log.info("Step AddEditJobNumber_006 - 07: Input Description");
		log.info("Step AddEditJobNumber_006 - 08: Click on Save button");
		log.info("Step AddEditJobNumber_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_job_numbers.php");
		
		log.info("Step AddEditJobNumber_006 - 10: Input Job Number Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_JobCode", newJobNumber);
		
		log.info("Step AddEditJobNumber_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditJobNumber_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Job Number code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newJobNumber, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Job Number code by Description works")
	public void AddEditJobNumber_007_SearchJobNumberByDescription() {	
		
		log.info("Step AddEditJobNumber_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditJobNumber_007 - 02: Input correct username and password");
		log.info("Step AddEditJobNumber_007 - 03: Accept Alert message");
		log.info("Step AddEditJobNumber_007 - 04: Open Add Job Number page");
		log.info("Step AddEditJobNumber_007 - 05: Input new Job Number code");
		log.info("Step AddEditJobNumber_007 - 06: Click on Add button");
		log.info("Step AddEditJobNumber_007 - 07: Input Description");
		log.info("Step AddEditJobNumber_007 - 08: Click on Save button");
		log.info("Step AddEditJobNumber_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_job_numbers.php");
		
		log.info("Step AddEditJobNumber_007 - 10: Input Job Number Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_JobCode", newJobNumber);
		
		log.info("Step AddEditJobNumber_007 - 11: Input Job Number Code description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_JobDesc", "new description 2");
		
		log.info("Step AddEditJobNumber_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Job Number code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newJobNumber, "new description 2"));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newJobNumber;
	private String glAccountCode1, glAccountCode2;
}
