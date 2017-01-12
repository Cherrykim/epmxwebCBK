package AssetManagerPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.AddUserPage;
import page.AssetManagerPage;
import page.LoginPage;
import page.MasterFilesPage;

public class AssetManager_08_AddEditAssetWarranty extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		assetManagerPage = PageFactory.getAssetManagerPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newAssetEntry = getUniqueText(8);
		
		glAccountCode1 = "glNo1";
		glAccountCode2 = "glNo2";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create Asset Entry");
		assetManagerPage.createNewAssetEntry(newAssetEntry);
	
		log.info("Step Pre-condition - 05: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.createNewGLAccount(glAccountCode2);
	}

	@Test(groups = { "regression" }, description = "Check Add Asset warranty works")
	public void AddEditAssetWarranty_001_CheckAddAssetWarrantyWorks() {	
		
		log.info("Step AddEditAssetWarranty_001 - 01: Open Add Asset warranty page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/add_warranty.php");

		log.info("Step AddEditAssetWarranty_001 - 02: Input new Asset warranty");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNbr", newAssetEntry);
		
		log.info("Step AddEditAssetWarranty_001 - 03: Click on Add button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditAssetWarranty_001 - 04: Select Warranty period");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_WarrantyPeriod", "Days");
		
		log.info("Step AddEditAssetWarranty_001 - 05: Input all textfields");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyStartDate", "11-11-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyExpDate", "11-11-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyPaidThruDate", "11-11-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyType", "Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyLength", "11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyRenewalFee", "11.11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyAgreementNbr", "11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyPO", "P.O. Number 1");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CurrentWarrantyCost", "11.11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TotalWarrantyCost", "11.11");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_WarrantyNotes", "Notes 1");
		
		log.info("Step AddEditAssetWarranty_001 - 06: Input G/L Account");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_WarrantyGLAcct", glAccountCode1);
		
		log.info("Step AddEditAssetWarranty_001 - 07: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetWarranty_001 - 08: Input new Asset warranty");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNbr", newAssetEntry);
		
		log.info("Step AddEditAssetWarranty_001 - 09: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditAssetWarranty_001 - VP: Check data saved correctly: Warranty period");
		verifyEquals(assetManagerPage.getSelectedItemByID(DriverManager.getDriver(), "sel_WarrantyPeriod"), "Days");
		
		log.info("Step AddEditAssetWarranty_001 - VP: Check data saved correctly: All textfields");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyStartDate"), "11-11-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyExpDate"), "11-11-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyPaidThruDate"), "11-11-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyType"), "Type");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyLength"), "11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyRenewalFee"), "11.11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyAgreementNbr"), "11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyPO"), "P.O. Number 1");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_CurrentWarrantyCost"), "11.11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_TotalWarrantyCost"), "11.11");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_WarrantyNotes"), "Notes 1");
		
		log.info("Step AddEditAssetWarranty_001 - VP: Check data saved correctly: G/L Account");
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode1));
	}
	
	@Test(groups = { "regression" }, description = "Check Add Asset warranty works")
	public void AddEditAssetWarranty_002_CheckEditAssetWarrantyWorks() {	
		
		log.info("Step AddEditAssetWarranty_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetWarranty_002 - 02: Input correct username and password");
		log.info("Step AddEditAssetWarranty_002 - 03: Accept Alert message");
		log.info("Step AddEditAssetWarranty_002 - 04: Open Add Asset Warranty page");
		log.info("Step AddEditAssetWarranty_002 - 05: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_002 - 06: Click on Add button");
		log.info("Step AddEditAssetWarranty_002 - 07: Input Description");
		log.info("Step AddEditAssetWarranty_002 - 08: Click on Save button");
		log.info("Step AddEditAssetWarranty_002 - 09: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_002 - 10: Click on Modify button");
		log.info("Step AddEditAssetWarranty_002 - 11: Select Warranty period");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_WarrantyPeriod", "Months");
		
		log.info("Step AddEditAssetWarranty_002 - 12: Input all textfields");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyStartDate", "12-12-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyExpDate", "12-12-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyPaidThruDate", "12-12-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyType", "Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyLength", "12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyRenewalFee", "12.12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyAgreementNbr", "12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_WarrantyPO", "P.O. Number 2");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CurrentWarrantyCost", "12.12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TotalWarrantyCost", "12.12");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_WarrantyNotes", "Notes 2");
		
		log.info("Step AddEditAssetWarranty_002 - 13: Input G/L Account");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_WarrantyGLAcct", glAccountCode2);
		
		log.info("Step AddEditAssetWarranty_002 - 14: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetWarranty_002 - 15: Input new Asset warranty");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNbr", newAssetEntry);
		
		log.info("Step AddEditAssetWarranty_002 - 16: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditAssetWarranty_002 - VP: Check data saved correctly: Warranty period");
		verifyEquals(assetManagerPage.getSelectedItemByID(DriverManager.getDriver(), "sel_WarrantyPeriod"), "Months");
		
		log.info("Step AddEditAssetWarranty_002 - VP: Check data saved correctly: All textfields");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyStartDate"), "12-12-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyExpDate"), "12-12-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyPaidThruDate"), "12-12-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyType"), "Type");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyLength"), "12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyRenewalFee"), "12.12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyAgreementNbr"), "12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_WarrantyPO"), "P.O. Number 2");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_CurrentWarrantyCost"), "12.12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_TotalWarrantyCost"), "12.12");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_WarrantyNotes"), "Notes 2");
		
		log.info("Step AddEditAssetWarranty_002 - VP: Check data saved correctly: G/L Account");
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode2));
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Asset warranty works")
	public void AddEditAssetWarranty_003_CheckDeactivateAssetWarrantyWorks() {	
		
		log.info("Step AddEditAssetWarranty_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetWarranty_003 - 02: Input correct username and password");
		log.info("Step AddEditAssetWarranty_003 - 03: Accept Alert message");
		log.info("Step AddEditAssetWarranty_003 - 04: Open Add Asset Warranty page");
		log.info("Step AddEditAssetWarranty_003 - 05: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_003 - 06: Click on Add button");
		log.info("Step AddEditAssetWarranty_003 - 07: Input Description");
		log.info("Step AddEditAssetWarranty_003 - 08: Click on Save button");
		log.info("Step AddEditAssetWarranty_003 - 09: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_003 - 10: Click on Deactivate button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditAssetWarranty_003 - 11: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditAssetWarranty_003 - 12: Input new Asset warranty");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNbr", newAssetEntry);
		
		log.info("Step AddEditAssetWarranty_003 - 13: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Asset warranty is deactivated");
		verifyEquals(assetManagerPage.getAlertText(DriverManager.getDriver()), "Asset Number is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Asset warranty works")
	public void AddEditAssetWarranty_004_CheckReactivateAssetWarrantyWorks() {	
		
		log.info("Step AddEditAssetWarranty_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetWarranty_004 - 02: Input correct username and password");
		log.info("Step AddEditAssetWarranty_004 - 03: Accept Alert message");
		log.info("Step AddEditAssetWarranty_004 - 04: Open Add Asset Warranty page");
		log.info("Step AddEditAssetWarranty_004 - 05: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_004 - 06: Click on Add button");
		log.info("Step AddEditAssetWarranty_004 - 07: Input Description");
		log.info("Step AddEditAssetWarranty_004 - 08: Click on Save button");
		log.info("Step AddEditAssetWarranty_004 - 09: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_004 - 10: Click on Deactivate button");
		log.info("Step AddEditAssetWarranty_004 - 11: Accept alert");
		log.info("Step AddEditAssetWarranty_004 - 12: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_004 - 13: Click on Modify button");
		log.info("Step AddEditAssetWarranty_004 - 14: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(assetManagerPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset warranty by Asset Number works")
	public void AddEditAssetWarranty_005_SearchAssetWarrantyByAssetNumber() {	
		
		log.info("Step AddEditAssetWarranty_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetWarranty_005 - 02: Input correct username and password");
		log.info("Step AddEditAssetWarranty_005 - 03: Accept Alert message");
		log.info("Step AddEditAssetWarranty_005 - 04: Open Add Asset Warranty page");
		log.info("Step AddEditAssetWarranty_005 - 05: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_005 - 06: Click on Add button");
		log.info("Step AddEditAssetWarranty_005 - 07: Input Description");
		log.info("Step AddEditAssetWarranty_005 - 08: Click on Save button");
		log.info("Step AddEditAssetWarranty_005 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_warranty.php");
		
		log.info("Step AddEditAssetWarranty_005 - 10: Input Asset Number");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetNumber", newAssetEntry);
		
		log.info("Step AddEditAssetWarranty_005 - 11: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset warranty displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetEntry, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset warranty by Corporation works")
	public void AddEditAssetWarranty_006_SearchAssetWarrantyByCorporation() {	
		
		log.info("Step AddEditAssetWarranty_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetWarranty_006 - 02: Input correct username and password");
		log.info("Step AddEditAssetWarranty_006 - 03: Accept Alert message");
		log.info("Step AddEditAssetWarranty_006 - 04: Open Add Asset Warranty page");
		log.info("Step AddEditAssetWarranty_006 - 05: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_006 - 06: Click on Add button");
		log.info("Step AddEditAssetWarranty_006 - 07: Input Description");
		log.info("Step AddEditAssetWarranty_006 - 08: Click on Save button");
		log.info("Step AddEditAssetWarranty_006 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_warranty.php");
		
		log.info("Step AddEditAssetWarranty_006 - 10: Input Asset Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "newAssetEntry", newAssetEntry);
		
		log.info("Step AddEditAssetWarranty_006 - 11: Select Corporation");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditAssetWarranty_006 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset warranty displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetEntry, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset warranty by Description works")
	public void AddEditAssetWarranty_007_SearchAssetWarrantyByDescription() {	
		
		log.info("Step AddEditAssetWarranty_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetWarranty_007 - 02: Input correct username and password");
		log.info("Step AddEditAssetWarranty_007 - 03: Accept Alert message");
		log.info("Step AddEditAssetWarranty_007 - 04: Open Add Asset Warranty page");
		log.info("Step AddEditAssetWarranty_007 - 05: Input new Asset warranty");
		log.info("Step AddEditAssetWarranty_007 - 06: Click on Add button");
		log.info("Step AddEditAssetWarranty_007 - 07: Input Description");
		log.info("Step AddEditAssetWarranty_007 - 08: Click on Save button");
		log.info("Step AddEditAssetWarranty_007 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_warranty.php");
		
		log.info("Step AddEditAssetWarranty_007 - 10: Input Asset Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "newAssetEntry", newAssetEntry);
		
		log.info("Step AddEditAssetWarranty_007 - 11: Input Asset Warranty description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDesc", newAssetEntry);
		
		log.info("Step AddEditAssetWarranty_007 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset warranty displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetEntry, newAssetEntry));
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AssetManagerPage assetManagerPage;
	private MasterFilesPage masterFilesPage;
	private String newAssetEntry;
	private String glAccountCode1, glAccountCode2;
}
