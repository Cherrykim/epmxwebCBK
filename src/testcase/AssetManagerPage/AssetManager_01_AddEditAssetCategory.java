package AssetManagerPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.AssetManagerPage;
import page.LoginPage;

public class AssetManager_01_AddEditAssetCategory extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		assetManagerPage = PageFactory.getAssetManagerPage(DriverManager.getDriver(), ipClient);
		newAssetCategory = getUniqueText(8);
	}

	@Test(groups = { "regression" }, description = "Check Add Asset category works")
	public void AddEditAssetCategory_001_CheckAddAssetCategoryWorks() {	
		
		log.info("Step AddEditAssetCategory_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetCategory_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditAssetCategory_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditAssetCategory_001 - 04: Open Add Asset category page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/add_asset_category.php");

		log.info("Step AddEditAssetCategory_001 - 05: Input new Asset category");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CategoryCode", newAssetCategory);
		
		log.info("Step AddEditAssetCategory_001 - 06: Click on Add button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditAssetCategory_001 - 07: Input Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditAssetCategory_001 - 08: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetCategory_001 - 09: Input new Asset category");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CategoryCode", newAssetCategory);
		
		log.info("Step AddEditAssetCategory_001 - 10: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Asset category works")
	public void AddEditAssetCategory_002_CheckEditAssetCategoryWorks() {	
		
		log.info("Step AddEditAssetCategory_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetCategory_002 - 02: Input correct username and password");
		log.info("Step AddEditAssetCategory_002 - 03: Accept Alert message");
		log.info("Step AddEditAssetCategory_002 - 04: Open Add Asset Category page");
		log.info("Step AddEditAssetCategory_002 - 05: Input new Asset category");
		log.info("Step AddEditAssetCategory_002 - 06: Click on Add button");
		log.info("Step AddEditAssetCategory_002 - 07: Input Description");
		log.info("Step AddEditAssetCategory_002 - 08: Click on Save button");
		log.info("Step AddEditAssetCategory_002 - 09: Input new Asset category");
		log.info("Step AddEditAssetCategory_002 - 10: Click on Modify button");
		log.info("Step AddEditAssetCategory_002 - 11: Input new Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditAssetCategory_002 - 12: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetCategory_002 - 13: Input new Asset category");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CategoryCode", newAssetCategory);
		
		log.info("Step AddEditAssetCategory_002 - 14: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Asset category works")
	public void AddEditAssetCategory_003_CheckDeactivateAssetCategoryWorks() {	
		
		log.info("Step AddEditAssetCategory_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetCategory_003 - 02: Input correct username and password");
		log.info("Step AddEditAssetCategory_003 - 03: Accept Alert message");
		log.info("Step AddEditAssetCategory_003 - 04: Open Add Asset Category page");
		log.info("Step AddEditAssetCategory_003 - 05: Input new Asset category");
		log.info("Step AddEditAssetCategory_003 - 06: Click on Add button");
		log.info("Step AddEditAssetCategory_003 - 07: Input Description");
		log.info("Step AddEditAssetCategory_003 - 08: Click on Save button");
		log.info("Step AddEditAssetCategory_003 - 09: Input new Asset category");
		log.info("Step AddEditAssetCategory_003 - 10: Click on Deactivate button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditAssetCategory_003 - 11: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditAssetCategory_003 - 12: Input new Asset category");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CategoryCode", newAssetCategory);
		
		log.info("Step AddEditAssetCategory_003 - 13: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Asset category is deactivated");
		verifyEquals(assetManagerPage.getAlertText(DriverManager.getDriver()), "Asset Category is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Asset category works")
	public void AddEditAssetCategory_004_CheckReactivateAssetCategoryWorks() {	
		
		log.info("Step AddEditAssetCategory_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetCategory_004 - 02: Input correct username and password");
		log.info("Step AddEditAssetCategory_004 - 03: Accept Alert message");
		log.info("Step AddEditAssetCategory_004 - 04: Open Add Asset Category page");
		log.info("Step AddEditAssetCategory_004 - 05: Input new Asset category");
		log.info("Step AddEditAssetCategory_004 - 06: Click on Add button");
		log.info("Step AddEditAssetCategory_004 - 07: Input Description");
		log.info("Step AddEditAssetCategory_004 - 08: Click on Save button");
		log.info("Step AddEditAssetCategory_004 - 09: Input new Asset category");
		log.info("Step AddEditAssetCategory_004 - 10: Click on Deactivate button");
		log.info("Step AddEditAssetCategory_004 - 11: Accept alert");
		log.info("Step AddEditAssetCategory_004 - 12: Input new Asset category");
		log.info("Step AddEditAssetCategory_004 - 13: Click on Modify button");
		log.info("Step AddEditAssetCategory_004 - 14: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(assetManagerPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset category by Code works")
	public void AddEditAssetCategory_005_SearchAssetCategoryByCode() {	
		
		log.info("Step AddEditAssetCategory_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetCategory_005 - 02: Input correct username and password");
		log.info("Step AddEditAssetCategory_005 - 03: Accept Alert message");
		log.info("Step AddEditAssetCategory_005 - 04: Open Add Asset Category page");
		log.info("Step AddEditAssetCategory_005 - 05: Input new Asset category");
		log.info("Step AddEditAssetCategory_005 - 06: Click on Add button");
		log.info("Step AddEditAssetCategory_005 - 07: Input Description");
		log.info("Step AddEditAssetCategory_005 - 08: Click on Save button");
		log.info("Step AddEditAssetCategory_005 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_category.php");
		
		log.info("Step AddEditAssetCategory_005 - 10: Input Asset Category");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetCategory", newAssetCategory);
		
		log.info("Step AddEditAssetCategory_005 - 11: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset category displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetCategory, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset category by Corporation works")
	public void AddEditAssetCategory_006_SearchAssetCategoryByCorporation() {	
		
		log.info("Step AddEditAssetCategory_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetCategory_006 - 02: Input correct username and password");
		log.info("Step AddEditAssetCategory_006 - 03: Accept Alert message");
		log.info("Step AddEditAssetCategory_006 - 04: Open Add Asset Category page");
		log.info("Step AddEditAssetCategory_006 - 05: Input new Asset category");
		log.info("Step AddEditAssetCategory_006 - 06: Click on Add button");
		log.info("Step AddEditAssetCategory_006 - 07: Input Description");
		log.info("Step AddEditAssetCategory_006 - 08: Click on Save button");
		log.info("Step AddEditAssetCategory_006 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_category.php");
		
		log.info("Step AddEditAssetCategory_006 - 10: Input Asset Category");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetCategory", newAssetCategory);
		
		log.info("Step AddEditAssetCategory_006 - 11: Select Corporation");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditAssetCategory_006 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset category displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetCategory, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset category by Description works")
	public void AddEditAssetCategory_007_SearchAssetCategoryByDescription() {	
		
		log.info("Step AddEditAssetCategory_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetCategory_007 - 02: Input correct username and password");
		log.info("Step AddEditAssetCategory_007 - 03: Accept Alert message");
		log.info("Step AddEditAssetCategory_007 - 04: Open Add Asset Category page");
		log.info("Step AddEditAssetCategory_007 - 05: Input new Asset category");
		log.info("Step AddEditAssetCategory_007 - 06: Click on Add button");
		log.info("Step AddEditAssetCategory_007 - 07: Input Description");
		log.info("Step AddEditAssetCategory_007 - 08: Click on Save button");
		log.info("Step AddEditAssetCategory_007 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_category.php");
		
		log.info("Step AddEditAssetCategory_007 - 10: Input Asset Category");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetCategory", newAssetCategory);
		
		log.info("Step AddEditAssetCategory_007 - 11: Input Asset Category description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDesc", "new description 2");
		
		log.info("Step AddEditAssetCategory_007 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset category displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetCategory, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AssetManagerPage assetManagerPage;
	private String newAssetCategory;
}
