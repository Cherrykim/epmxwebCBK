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

public class MasterFiles_27_AddEditVendorGroup extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newVendorGroup = getUniqueText(6);
	}

	@Test(groups = { "regression" }, description = "Check Add Vendor Group works")
	public void AddEditVendorGroup_001_CheckAddVendorGroupWorks() {	
		
		log.info("Step AddEditVendorGroup_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorGroup_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditVendorGroup_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditVendorGroup_001 - 04: Open Add Vendor Group page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_vendor_group.php");

		log.info("Step AddEditVendorGroup_001 - 05: Input new Vendor Group");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VenGroup", newVendorGroup);
		
		log.info("Step AddEditVendorGroup_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditVendorGroup_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditVendorGroup_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditVendorGroup_001 - 09: Input new Vendor Group");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VenGroup", newVendorGroup);
		
		log.info("Step AddEditVendorGroup_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Vendor Group works")
	public void AddEditVendorGroup_002_CheckEditVendorGroupWorks() {	
		
		log.info("Step AddEditVendorGroup_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorGroup_002 - 02: Input correct username and password");
		log.info("Step AddEditVendorGroup_002 - 03: Accept Alert message");
		log.info("Step AddEditVendorGroup_002 - 04: Open Add labels page");
		log.info("Step AddEditVendorGroup_002 - 05: Input new Vendor Group");
		log.info("Step AddEditVendorGroup_002 - 06: Click on Add button");
		log.info("Step AddEditVendorGroup_002 - 07: Input Description");
		log.info("Step AddEditVendorGroup_002 - 08: Click on Save button");
		log.info("Step AddEditVendorGroup_002 - 09: Input new Vendor Group");
		log.info("Step AddEditVendorGroup_002 - 10: Click on Modify button");
		log.info("Step AddEditVendorGroup_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditVendorGroup_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditVendorGroup_002 - 13: Input new Vendor Group");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VenGroup", newVendorGroup);
		
		log.info("Step AddEditVendorGroup_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Vendor Group works")
	public void AddEditVendorGroup_003_CheckDeactivateVendorGroupWorks() {	
		
		log.info("Step AddEditVendorGroup_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorGroup_003 - 02: Input correct username and password");
		log.info("Step AddEditVendorGroup_003 - 03: Accept Alert message");
		log.info("Step AddEditVendorGroup_003 - 04: Open Add labels page");
		log.info("Step AddEditVendorGroup_003 - 05: Input new Vendor Group");
		log.info("Step AddEditVendorGroup_003 - 06: Click on Add button");
		log.info("Step AddEditVendorGroup_003 - 07: Input Description");
		log.info("Step AddEditVendorGroup_003 - 08: Click on Save button");
		log.info("Step AddEditVendorGroup_003 - 09: Input new Vendor Group");
		log.info("Step AddEditVendorGroup_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditVendorGroup_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditVendorGroup_003 - 12: Input new Vendor Group");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VenGroup", newVendorGroup);
		
		log.info("Step AddEditVendorGroup_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Vendor Group is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Vendor Group is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Vendor Group works")
	public void AddEditVendorGroup_004_CheckReactivateVendorGroupWorks() {	
		
		log.info("Step AddEditVendorGroup_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorGroup_004 - 02: Input correct username and password");
		log.info("Step AddEditVendorGroup_004 - 03: Accept Alert message");
		log.info("Step AddEditVendorGroup_004 - 04: Open Add labels page");
		log.info("Step AddEditVendorGroup_004 - 05: Input new Vendor Group");
		log.info("Step AddEditVendorGroup_004 - 06: Click on Add button");
		log.info("Step AddEditVendorGroup_004 - 07: Input Description");
		log.info("Step AddEditVendorGroup_004 - 08: Click on Save button");
		log.info("Step AddEditVendorGroup_004 - 09: Input new Vendor Group");
		log.info("Step AddEditVendorGroup_004 - 10: Click on Deactivate button");
		log.info("Step AddEditVendorGroup_004 - 11: Accept alert");
		log.info("Step AddEditVendorGroup_004 - 12: Input new Vendor Group");
		log.info("Step AddEditVendorGroup_004 - 13: Click on Modify button");
		log.info("Step AddEditVendorGroup_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Vendor Group code by Code works")
	public void AddEditVendorGroup_005_SearchVendorGroupByCode() {	
		
		log.info("Step AddEditVendorGroup_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorGroup_005 - 02: Input correct username and password");
		log.info("Step AddEditVendorGroup_005 - 03: Accept Alert message");
		log.info("Step AddEditVendorGroup_005 - 04: Open Add labels page");
		log.info("Step AddEditVendorGroup_005 - 05: Input new Vendor Group code");
		log.info("Step AddEditVendorGroup_005 - 06: Click on Add button");
		log.info("Step AddEditVendorGroup_005 - 07: Input Description");
		log.info("Step AddEditVendorGroup_005 - 08: Click on Save button");
		log.info("Step AddEditVendorGroup_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_vendor_group.php");
		
		log.info("Step AddEditVendorGroup_005 - 10: Input Vendor Group Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorGroupCode", newVendorGroup);
		
		log.info("Step AddEditVendorGroup_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Vendor Group code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newVendorGroup, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Vendor Group code by Corporation works")
	public void AddEditVendorGroup_006_SearchVendorGroupByCorporation() {	
		
		log.info("Step AddEditVendorGroup_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorGroup_006 - 02: Input correct username and password");
		log.info("Step AddEditVendorGroup_006 - 03: Accept Alert message");
		log.info("Step AddEditVendorGroup_006 - 04: Open Add labels page");
		log.info("Step AddEditVendorGroup_006 - 05: Input new Vendor Group code");
		log.info("Step AddEditVendorGroup_006 - 06: Click on Add button");
		log.info("Step AddEditVendorGroup_006 - 07: Input Description");
		log.info("Step AddEditVendorGroup_006 - 08: Click on Save button");
		log.info("Step AddEditVendorGroup_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_vendor_group.php");
		
		log.info("Step AddEditVendorGroup_006 - 10: Input Vendor Group Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorGroupCode", newVendorGroup);
		
		log.info("Step AddEditVendorGroup_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditVendorGroup_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Vendor Group code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newVendorGroup, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Vendor Group code by Description works")
	public void AddEditVendorGroup_007_SearchVendorGroupByDescription() {	
		
		log.info("Step AddEditVendorGroup_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorGroup_007 - 02: Input correct username and password");
		log.info("Step AddEditVendorGroup_007 - 03: Accept Alert message");
		log.info("Step AddEditVendorGroup_007 - 04: Open Add labels page");
		log.info("Step AddEditVendorGroup_007 - 05: Input new Vendor Group code");
		log.info("Step AddEditVendorGroup_007 - 06: Click on Add button");
		log.info("Step AddEditVendorGroup_007 - 07: Input Description");
		log.info("Step AddEditVendorGroup_007 - 08: Click on Save button");
		log.info("Step AddEditVendorGroup_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_vendor_group.php");
		
		log.info("Step AddEditVendorGroup_007 - 10: Input Vendor Group Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorGroupCode", newVendorGroup);
		
		log.info("Step AddEditVendorGroup_007 - 11: Input Vendor Group Code description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorGroupDesc", "new description 2");
		
		log.info("Step AddEditVendorGroup_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Vendor Group code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newVendorGroup, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newVendorGroup;
}
