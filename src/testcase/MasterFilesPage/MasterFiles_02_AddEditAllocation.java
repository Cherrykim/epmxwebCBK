package MasterFilesPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.UltilitiesPage;
import page.MasterFilesPage;
import page.LoginPage;

public class MasterFiles_02_AddEditAllocation extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		ultilitiesPage = PageFactory.getUltilitiesPage(DriverManager.getDriver(), ipClient);
		newAllocation = getUniqueText(8);
		glAccountCode1 = "glNo1";
		glAccountCode2 = "glNo2";
		job1 = "JobCode1";
		jobCode1= job1 + " : "+ job1;
		job2 = "JobCode2";
		jobCode2= job2 + " : "+ job2;
		projectCode1 = "Project1";
		projectCode2 = "Project2";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Enable Ultilities for Allocation");
		ultilitiesPage.enableAllocation();
		
		log.info("Step Pre-condition - 05: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.createNewGLAccount(glAccountCode2);
		
		log.info("Step Pre-condition - 06: Create new Job code");
		masterFilesPage.createNewJobCode(job1);
		masterFilesPage.createNewJobCode(job2);
		
		log.info("Step Pre-condition - 05: Create new Project code");
		masterFilesPage.createNewProjectCode(projectCode1);
		masterFilesPage.createNewProjectCode(projectCode2);

	}

	@Test(groups = { "regression" }, description = "Check Add Allocation works")
	public void AddEditAllocation_001_CheckAddAllocationWorks() {	
		
		log.info("Step AddEditAllocation_001 - 01: Open Add 1009 code page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_allocations.php");

		log.info("Step AddEditAllocation_001 - 02: Input new Allocation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationCode", newAllocation);
		
		log.info("Step AddEditAllocation_001 - 03: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditAllocation_001 - 04: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditAllocation_001 - 05: Input GL Account and percent");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccountCode0", glAccountCode1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct0", "20.000000");

		log.info("Step AddEditAllocation_001 - 06: Input Project and percent");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Project1", projectCode1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct1", "30.000000");

		log.info("Step AddEditAllocation_001 - 07: Input Job code and percent");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Job2", jobCode1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct2", "50.000000");

		log.info("Step AddEditAllocation_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAllocation_001 - 09: Input new Allocation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationCode", newAllocation);
		
		log.info("Step AddEditAllocation_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditAllocation_001 - VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
		
		log.info("Step AddEditAllocation_001 - VP: GL Account and percent saved correctly");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount0", glAccountCode1));
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct0"), "20.000000");

		log.info("Step AddEditAllocation_001 - VP: Input Project and percent saved correctly");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Project1", projectCode1));
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct1"), "30.000000");

		log.info("Step AddEditAllocation_001 - VP: Input Job code and percent saved correctly");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Job2", jobCode1));
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct2"), "50.000000");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Allocation works")
	public void AddEditAllocation_002_CheckEditAllocationWorks() {	
		
		log.info("Step AddEditAllocation_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAllocation_002 - 02: Input correct username and password");
		log.info("Step AddEditAllocation_002 - 03: Accept Alert message");
		log.info("Step AddEditAllocation_002 - 04: Open Add labels page");
		log.info("Step AddEditAllocation_002 - 05: Input new Allocation");
		log.info("Step AddEditAllocation_002 - 06: Click on Add button");
		log.info("Step AddEditAllocation_002 - 07: Input Description");
		log.info("Step AddEditAllocation_002 - 08: Click on Save button");
		log.info("Step AddEditAllocation_002 - 09: Input new Allocation");
		log.info("Step AddEditAllocation_002 - 10: Click on Modify button");
		log.info("Step AddEditAllocation_002 - 11: Input new Description");
		log.info("Step AddEditAllocation_002 - 12: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditAllocation_002 - 13: Input GL Account and percent");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccountCode0", glAccountCode2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct0", "50.000000");

		log.info("Step AddEditAllocation_002 - 14: Input Project and percent");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Project1", projectCode2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct1", "20.000000");

		log.info("Step AddEditAllocation_002 - 15: Input Job code and percent");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Job2", jobCode2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct2", "30.000000");

		log.info("Step AddEditAllocation_002 - 16: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAllocation_002 - 17: Input new Allocation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationCode", newAllocation);
		
		log.info("Step AddEditAllocation_002 - 18: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditAllocation_002 - VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
		
		log.info("Step AddEditAllocation_002 - VP: GL Account and percent saved correctly");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount0", glAccountCode2));
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct0"), "50.000000");

		log.info("Step AddEditAllocation_002 - VP: Input Project and percent saved correctly");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Project1", projectCode2));
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct1"), "20.000000");

		log.info("Step AddEditAllocation_002 - VP: Input Job code and percent saved correctly");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Job2", jobCode2));
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AllocationPct2"), "30.000000");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Allocation works")
	public void AddEditAllocation_003_CheckDeactivateAllocationWorks() {	
		
		log.info("Step AddEditAllocation_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAllocation_003 - 02: Input correct username and password");
		log.info("Step AddEditAllocation_003 - 03: Accept Alert message");
		log.info("Step AddEditAllocation_003 - 04: Open Add labels page");
		log.info("Step AddEditAllocation_003 - 05: Input new Allocation");
		log.info("Step AddEditAllocation_003 - 06: Click on Add button");
		log.info("Step AddEditAllocation_003 - 07: Input Description");
		log.info("Step AddEditAllocation_003 - 08: Click on Save button");
		log.info("Step AddEditAllocation_003 - 09: Input new Allocation");
		log.info("Step AddEditAllocation_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditAllocation_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditAllocation_003 - 12: Input new Allocation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationCode", newAllocation);
		
		log.info("Step AddEditAllocation_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Allocation is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Allocation is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Allocation works")
	public void AddEditAllocation_004_CheckReactivateAllocationWorks() {	
		
		log.info("Step AddEditAllocation_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAllocation_004 - 02: Input correct username and password");
		log.info("Step AddEditAllocation_004 - 03: Accept Alert message");
		log.info("Step AddEditAllocation_004 - 04: Open Add labels page");
		log.info("Step AddEditAllocation_004 - 05: Input new Allocation");
		log.info("Step AddEditAllocation_004 - 06: Click on Add button");
		log.info("Step AddEditAllocation_004 - 07: Input Description");
		log.info("Step AddEditAllocation_004 - 08: Click on Save button");
		log.info("Step AddEditAllocation_004 - 09: Input new Allocation");
		log.info("Step AddEditAllocation_004 - 10: Click on Deactivate button");
		log.info("Step AddEditAllocation_004 - 11: Accept alert");
		log.info("Step AddEditAllocation_004 - 12: Input new Allocation");
		log.info("Step AddEditAllocation_004 - 13: Click on Modify button");
		log.info("Step AddEditAllocation_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Allocation by Code works")
	public void AddEditAllocation_005_SearchAllocationByCode() {	
		
		log.info("Step AddEditAllocation_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAllocation_005 - 02: Input correct username and password");
		log.info("Step AddEditAllocation_005 - 03: Accept Alert message");
		log.info("Step AddEditAllocation_005 - 04: Open Add labels page");
		log.info("Step AddEditAllocation_005 - 05: Input new Allocation");
		log.info("Step AddEditAllocation_005 - 06: Click on Add button");
		log.info("Step AddEditAllocation_005 - 07: Input Description");
		log.info("Step AddEditAllocation_005 - 08: Click on Save button");
		log.info("Step AddEditAllocation_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_allocations.php");
		
		log.info("Step AddEditAllocation_005 - 10: Input Allocation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationCode", newAllocation);
		
		log.info("Step AddEditAllocation_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Allocation displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newAllocation, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Allocation by Corporation works")
	public void AddEditAllocation_006_SearchAllocationByCorporation() {	
		
		log.info("Step AddEditAllocation_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAllocation_006 - 02: Input correct username and password");
		log.info("Step AddEditAllocation_006 - 03: Accept Alert message");
		log.info("Step AddEditAllocation_006 - 04: Open Add labels page");
		log.info("Step AddEditAllocation_006 - 05: Input new Allocation");
		log.info("Step AddEditAllocation_006 - 06: Click on Add button");
		log.info("Step AddEditAllocation_006 - 07: Input Description");
		log.info("Step AddEditAllocation_006 - 08: Click on Save button");
		log.info("Step AddEditAllocation_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_allocations.php");
		
		log.info("Step AddEditAllocation_006 - 10: Input Allocation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationCode", newAllocation);
		
		log.info("Step AddEditAllocation_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditAllocation_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Allocation displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newAllocation, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Allocation by Description works")
	public void AddEditAllocation_007_SearchAllocationByDescription() {	
		
		log.info("Step AddEditAllocation_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAllocation_007 - 02: Input correct username and password");
		log.info("Step AddEditAllocation_007 - 03: Accept Alert message");
		log.info("Step AddEditAllocation_007 - 04: Open Add labels page");
		log.info("Step AddEditAllocation_007 - 05: Input new Allocation");
		log.info("Step AddEditAllocation_007 - 06: Click on Add button");
		log.info("Step AddEditAllocation_007 - 07: Input Description");
		log.info("Step AddEditAllocation_007 - 08: Click on Save button");
		log.info("Step AddEditAllocation_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_allocations.php");
		
		log.info("Step AddEditAllocation_007 - 10: Input Allocation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationCode", newAllocation);
		
		log.info("Step AddEditAllocation_007 - 11: Input Allocation description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AllocationDesc", "new description 2");
		
		log.info("Step AddEditAllocation_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Allocation displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newAllocation, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private UltilitiesPage ultilitiesPage;
	private String newAllocation;
	private String glAccountCode1, glAccountCode2;
	private String job1, job2, jobCode1, jobCode2;
	private String projectCode1, projectCode2;
}
