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

public class MasterFiles_28_AddEditVendorType extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newVendorType = getUniqueText(3);
	}

	@Test(groups = { "regression" }, description = "Check Add Vendor Type works")
	public void AddEditVendorType_001_CheckAddVendorTypeWorks() {	
		
		log.info("Step AddEditVendorType_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorType_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditVendorType_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditVendorType_001 - 04: Open Add Vendor Type page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_vendor_type.php");

		log.info("Step AddEditVendorType_001 - 05: Input new Vendor Type");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VenType", newVendorType);
		
		log.info("Step AddEditVendorType_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditVendorType_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditVendorType_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditVendorType_001 - 09: Input new Vendor Type");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VenType", newVendorType);
		
		log.info("Step AddEditVendorType_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Vendor Type works")
	public void AddEditVendorType_002_CheckEditVendorTypeWorks() {	
		
		log.info("Step AddEditVendorType_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorType_002 - 02: Input correct username and password");
		log.info("Step AddEditVendorType_002 - 03: Accept Alert message");
		log.info("Step AddEditVendorType_002 - 04: Open Add labels page");
		log.info("Step AddEditVendorType_002 - 05: Input new Vendor Type");
		log.info("Step AddEditVendorType_002 - 06: Click on Add button");
		log.info("Step AddEditVendorType_002 - 07: Input Description");
		log.info("Step AddEditVendorType_002 - 08: Click on Save button");
		log.info("Step AddEditVendorType_002 - 09: Input new Vendor Type");
		log.info("Step AddEditVendorType_002 - 10: Click on Modify button");
		log.info("Step AddEditVendorType_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditVendorType_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditVendorType_002 - 13: Input new Vendor Type");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VenType", newVendorType);
		
		log.info("Step AddEditVendorType_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Vendor Type works")
	public void AddEditVendorType_003_CheckDeactivateVendorTypeWorks() {	
		
		log.info("Step AddEditVendorType_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorType_003 - 02: Input correct username and password");
		log.info("Step AddEditVendorType_003 - 03: Accept Alert message");
		log.info("Step AddEditVendorType_003 - 04: Open Add labels page");
		log.info("Step AddEditVendorType_003 - 05: Input new Vendor Type");
		log.info("Step AddEditVendorType_003 - 06: Click on Add button");
		log.info("Step AddEditVendorType_003 - 07: Input Description");
		log.info("Step AddEditVendorType_003 - 08: Click on Save button");
		log.info("Step AddEditVendorType_003 - 09: Input new Vendor Type");
		log.info("Step AddEditVendorType_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditVendorType_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditVendorType_003 - 12: Input new Vendor Type");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VenType", newVendorType);
		
		log.info("Step AddEditVendorType_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Vendor Type is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Vendor Type is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Vendor Type works")
	public void AddEditVendorType_004_CheckReactivateVendorTypeWorks() {	
		
		log.info("Step AddEditVendorType_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorType_004 - 02: Input correct username and password");
		log.info("Step AddEditVendorType_004 - 03: Accept Alert message");
		log.info("Step AddEditVendorType_004 - 04: Open Add labels page");
		log.info("Step AddEditVendorType_004 - 05: Input new Vendor Type");
		log.info("Step AddEditVendorType_004 - 06: Click on Add button");
		log.info("Step AddEditVendorType_004 - 07: Input Description");
		log.info("Step AddEditVendorType_004 - 08: Click on Save button");
		log.info("Step AddEditVendorType_004 - 09: Input new Vendor Type");
		log.info("Step AddEditVendorType_004 - 10: Click on Deactivate button");
		log.info("Step AddEditVendorType_004 - 11: Accept alert");
		log.info("Step AddEditVendorType_004 - 12: Input new Vendor Type");
		log.info("Step AddEditVendorType_004 - 13: Click on Modify button");
		log.info("Step AddEditVendorType_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Vendor Type code by Code works")
	public void AddEditVendorType_005_SearchVendorTypeByCode() {	
		
		log.info("Step AddEditVendorType_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorType_005 - 02: Input correct username and password");
		log.info("Step AddEditVendorType_005 - 03: Accept Alert message");
		log.info("Step AddEditVendorType_005 - 04: Open Add labels page");
		log.info("Step AddEditVendorType_005 - 05: Input new Vendor Type code");
		log.info("Step AddEditVendorType_005 - 06: Click on Add button");
		log.info("Step AddEditVendorType_005 - 07: Input Description");
		log.info("Step AddEditVendorType_005 - 08: Click on Save button");
		log.info("Step AddEditVendorType_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_vendor_type.php");
		
		log.info("Step AddEditVendorType_005 - 10: Input Vendor Type Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SearchType", newVendorType);
		
		log.info("Step AddEditVendorType_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Vendor Type code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newVendorType, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Vendor Type code by Corporation works")
	public void AddEditVendorType_006_SearchVendorTypeByCorporation() {	
		
		log.info("Step AddEditVendorType_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorType_006 - 02: Input correct username and password");
		log.info("Step AddEditVendorType_006 - 03: Accept Alert message");
		log.info("Step AddEditVendorType_006 - 04: Open Add labels page");
		log.info("Step AddEditVendorType_006 - 05: Input new Vendor Type code");
		log.info("Step AddEditVendorType_006 - 06: Click on Add button");
		log.info("Step AddEditVendorType_006 - 07: Input Description");
		log.info("Step AddEditVendorType_006 - 08: Click on Save button");
		log.info("Step AddEditVendorType_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_vendor_type.php");
		
		log.info("Step AddEditVendorType_006 - 10: Input Vendor Type Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SearchType", newVendorType);
		
		log.info("Step AddEditVendorType_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditVendorType_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Vendor Type code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newVendorType, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Vendor Type code by Description works")
	public void AddEditVendorType_007_SearchVendorTypeByDescription() {	
		
		log.info("Step AddEditVendorType_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendorType_007 - 02: Input correct username and password");
		log.info("Step AddEditVendorType_007 - 03: Accept Alert message");
		log.info("Step AddEditVendorType_007 - 04: Open Add labels page");
		log.info("Step AddEditVendorType_007 - 05: Input new Vendor Type code");
		log.info("Step AddEditVendorType_007 - 06: Click on Add button");
		log.info("Step AddEditVendorType_007 - 07: Input Description");
		log.info("Step AddEditVendorType_007 - 08: Click on Save button");
		log.info("Step AddEditVendorType_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_vendor_type.php");
		
		log.info("Step AddEditVendorType_007 - 10: Input Vendor Type Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SearchType", newVendorType);
		
		log.info("Step AddEditVendorType_007 - 11: Input Vendor Type Code description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorTypeDesc", "new description 2");
		
		log.info("Step AddEditVendorType_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Vendor Type code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newVendorType, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newVendorType;
}
