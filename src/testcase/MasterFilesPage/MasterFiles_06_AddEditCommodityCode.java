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

public class MasterFiles_06_AddEditCommodityCode extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		
		newCommodity = getUniqueText(10);
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
		vendorID1 = "110320161";
		vendorName1 = "Vendor 1";
		vendorID2 = "110320162";
		vendorName2 = "Vendor 2";
		log.info("Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		log.info("Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		log.info("Pre-condition - 04: Open Add user page");
		log.info("Pre-condition - 05: Create new Buyer");
		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole);
		addUserPage.createNewUserWithRole(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", primaryUserRole2);
		log.info("Pre-condition - 06: Create new Vendor");
		masterFilesPage.createNewVendor(vendorID1, vendorName1);
		masterFilesPage.createNewVendor(vendorID2, vendorName2);
	}

	@Test(groups = { "regression" }, description = "Check Add Commodity works")
	public void AddCommodityCode_001_CheckAddCommodityWorks() {	
		
		log.info("Step AddCommodityCode_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCommodityCode_001 - 02: Input correct username and password");
		log.info("Step AddCommodityCode_001 - 03: Accept Alert message");
		log.info("Step AddCommodityCode_001 - 04: Open Add Commodity page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_commodity_code.php");

		log.info("Step AddCommodityCode_001 - 05: Input new Commodity");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommodityCode", newCommodity);
		
		log.info("Step AddCommodityCode_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddCommodityCode_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddCommodityCode_001 - 08: Select Primary user");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BuyerID", primaryUserName);
		
		log.info("Step AddCommodityCode_001 - 09: Input Primary vendor");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_PVendor", vendorName1);
		
		log.info("Step AddCommodityCode_001 - 10: Click on Add Alternate vendor button");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "add_alt_vendor");
		
		log.info("Step AddCommodityCode_001 - 10: Input Alternate vendor");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_PVendorA", vendorName2);
		
		log.info("Step AddCommodityCode_001 - 11: Click on Save Alternate Vendor button");
		masterFilesPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save Alternate Vendor");
		
		log.info("Step AddCommodityCode_001 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddCommodityCode_001 - 13: Input new Commodity");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommodityCode", newCommodity);
		
		log.info("Step AddCommodityCode_001 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_CommodityCodeDescription"), "new description");
		
		log.info("VP: Primary user is saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BuyerID"), primaryUserName);
		
		log.info("VP: Primary vendor is displayed correctly");
		verifyTrue(masterFilesPage.isPrimaryVendorDisplayedCorrectly(vendorName1));
		
		log.info("VP: Alternate vendor is displayed correctly");
		verifyTrue(masterFilesPage.isTextDisplayed(DriverManager.getDriver(), vendorName2));
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Commodity works")
	public void AddCommodityCode_002_CheckEditCommodityWorks() {	
		
		log.info("Step AddCommodityCode_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCommodityCode_002 - 02: Input correct username and password");
		log.info("Step AddCommodityCode_002 - 03: Accept Alert message");
		log.info("Step AddCommodityCode_002 - 04: Open Add Commodity page");
		log.info("Step AddCommodityCode_002 - 05: Input new Commodity");
		log.info("Step AddCommodityCode_002 - 06: Click on Add button");
		log.info("Step AddCommodityCode_002 - 07: Input Description");
		log.info("Step AddCommodityCode_002 - 08: Select Primary user");
		log.info("Step AddCommodityCode_002 - 09: Input Primary vendor");
		log.info("Step AddCommodityCode_002 - 10: Click on Add Alternate vendor button");
		log.info("Step AddCommodityCode_002 - 10: Input Alternate vendor");
		log.info("Step AddCommodityCode_002 - 11: Click on Save Alternate Vendor button");
		log.info("Step AddCommodityCode_002 - 12: Click on Save button");
		log.info("Step AddCommodityCode_002 - 13: Input new Commodity");
		log.info("Step AddCommodityCode_002 - 14: Click on Modify button");
		log.info("Step AddCommodityCode_002 - 15: Change description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommodityCodeDescription", "new description 2");
		
		log.info("Step AddCommodityCode_002 - 16: Remove Alternate");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddCommodityCode_002 - 17: Select Primary user");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BuyerID", primaryUserName2);
		
		log.info("Step AddCommodityCode_002 - 18: Input Primary vendor");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PVendor", vendorName2);
		
		log.info("Step AddCommodityCode_002 - 19: Click on Add Alternate vendor button");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "add_alt_vendor");
		
		log.info("Step AddCommodityCode_002 - 20: Input Alternate vendor");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_PVendorA", vendorName1);
		
		log.info("Step AddCommodityCode_002 - 21: Click on Save Alternate Vendor button");
		masterFilesPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save Alternate Vendor");
		
		log.info("Step AddCommodityCode_002 - 22: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddCommodityCode_002 - 24: Input new Commodity");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommodityCode", newCommodity);
		
		log.info("Step AddCommodityCode_002 - 25: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_CommodityCodeDescription"), "new description 2");
		
		log.info("VP: Primary user is saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BuyerID"), primaryUserName2);
		
		log.info("VP: Primary vendor is displayed correctly");
		verifyTrue(masterFilesPage.isPrimaryVendorDisplayedCorrectly(vendorName2));
		
		log.info("VP: Alternate vendor is displayed correctly");
		verifyTrue(masterFilesPage.isTextDisplayed(DriverManager.getDriver(), vendorName1));
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Commodity works")
	public void AddCommodityCode_003_CheckDeactivateCommodityWorks() {	
		
		log.info("Step AddCommodityCode_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCommodityCode_003 - 02: Input correct username and password");
		log.info("Step AddCommodityCode_003 - 03: Accept Alert message");
		log.info("Step AddCommodityCode_003 - 04: Open Add Commodity page");
		log.info("Step AddCommodityCode_003 - 05: Input new Commodity");
		log.info("Step AddCommodityCode_003 - 06: Click on Add button");
		log.info("Step AddCommodityCode_003 - 07: Input Description");
		log.info("Step AddCommodityCode_003 - 08: Click on Save button");
		log.info("Step AddCommodityCode_003 - 09: Input new Commodity");
		log.info("Step AddCommodityCode_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddCommodityCode_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddCommodityCode_003 - 12: Input new Commodity");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommodityCode", newCommodity);
		
		log.info("Step AddCommodityCode_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Commodity Code is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Commodity Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Commodity works")
	public void AddCommodityCode_004_CheckReactivateCommodityWorks() {	
		
		log.info("Step AddCommodityCode_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCommodityCode_004 - 02: Input correct username and password");
		log.info("Step AddCommodityCode_004 - 03: Accept Alert message");
		log.info("Step AddCommodityCode_004 - 04: Open Add Commodity page");
		log.info("Step AddCommodityCode_004 - 05: Input new Commodity");
		log.info("Step AddCommodityCode_004 - 06: Click on Add button");
		log.info("Step AddCommodityCode_004 - 07: Input Description");
		log.info("Step AddCommodityCode_004 - 08: Click on Save button");
		log.info("Step AddCommodityCode_004 - 09: Input new Commodity");
		log.info("Step AddCommodityCode_004 - 10: Click on Deactivate button");
		log.info("Step AddCommodityCode_004 - 11: Accept alert");
		log.info("Step AddCommodityCode_004 - 12: Input new Commodity");
		log.info("Step AddCommodityCode_004 - 13: Click on Modify button");
		log.info("Step AddCommodityCode_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Commodity code by Code works")
	public void AddEditCommodityCode_005_SearchCommodityCodeByCode() {	
		
		log.info("Step AddEditCommodityCode_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditCommodityCode_005 - 02: Input correct username and password");
		log.info("Step AddEditCommodityCode_005 - 03: Accept Alert message");
		log.info("Step AddEditCommodityCode_005 - 04: Open Add Commodity page");
		log.info("Step AddEditCommodityCode_005 - 05: Input new Commodity code");
		log.info("Step AddEditCommodityCode_005 - 06: Click on Add button");
		log.info("Step AddEditCommodityCode_005 - 07: Input Description");
		log.info("Step AddEditCommodityCode_005 - 08: Click on Save button");
		log.info("Step AddEditCommodityCode_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_commodity_code.php");
		
		log.info("Step AddEditCommodityCode_005 - 10: Input Commodity Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommCode", newCommodity);
		
		log.info("Step AddEditCommodityCode_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Commodity code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newCommodity, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Commodity code by Corporation works")
	public void AddEditCommodityCode_006_SearchCommodityCodeByCorporation() {	
		
		log.info("Step AddEditCommodityCode_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditCommodityCode_006 - 02: Input correct username and password");
		log.info("Step AddEditCommodityCode_006 - 03: Accept Alert message");
		log.info("Step AddEditCommodityCode_006 - 04: Open Add Commodity page");
		log.info("Step AddEditCommodityCode_006 - 05: Input new Commodity code");
		log.info("Step AddEditCommodityCode_006 - 06: Click on Add button");
		log.info("Step AddEditCommodityCode_006 - 07: Input Description");
		log.info("Step AddEditCommodityCode_006 - 08: Click on Save button");
		log.info("Step AddEditCommodityCode_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_commodity_code.php");
		
		log.info("Step AddEditCommodityCode_006 - 10: Input Commodity Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommCode", newCommodity);
		
		log.info("Step AddEditCommodityCode_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditCommodityCode_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Commodity code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newCommodity, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Commodity code by Description works")
	public void AddEditCommodityCode_007_SearchCommodityCodeByDescription() {	
		
		log.info("Step AddEditCommodityCode_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditCommodityCode_007 - 02: Input correct username and password");
		log.info("Step AddEditCommodityCode_007 - 03: Accept Alert message");
		log.info("Step AddEditCommodityCode_007 - 04: Open Add Commodity page");
		log.info("Step AddEditCommodityCode_007 - 05: Input new Commodity code");
		log.info("Step AddEditCommodityCode_007 - 06: Click on Add button");
		log.info("Step AddEditCommodityCode_007 - 07: Input Description");
		log.info("Step AddEditCommodityCode_007 - 08: Click on Save button");
		log.info("Step AddEditCommodityCode_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_commodity_code.php");
		
		log.info("Step AddEditCommodityCode_007 - 10: Input Commodity Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommCode", newCommodity);
		
		log.info("Step AddEditCommodityCode_007 - 11: Input Commodity Code description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommDesc", "new description 2");
		
		log.info("Step AddEditCommodityCode_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Commodity code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newCommodity, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private AddUserPage addUserPage;
	private String newCommodity;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, primaryUserRole2, primaryUserName2;
	private String vendorID1, vendorName1;
	private String vendorID2, vendorName2;
}
