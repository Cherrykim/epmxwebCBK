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

public class AssetManager_06_AddEditAssetUnit extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		assetManagerPage = PageFactory.getAssetManagerPage(DriverManager.getDriver(), ipClient);
		newAssetUnit = getUniqueText(8);
	}

	@Test(groups = { "regression" }, description = "Check Add Asset unit works")
	public void AddEditAssetUnit_001_CheckAddAssetUnitWorks() {	
		
		log.info("Step AddEditAssetUnit_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetUnit_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditAssetUnit_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditAssetUnit_001 - 04: Open Add Asset unit page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/add_asset_unit.php");

		log.info("Step AddEditAssetUnit_001 - 05: Input new Asset unit");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UnitCode", newAssetUnit);
		
		log.info("Step AddEditAssetUnit_001 - 06: Click on Add button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditAssetUnit_001 - 07: Input Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditAssetUnit_001 - 08: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetUnit_001 - 09: Input new Asset unit");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UnitCode", newAssetUnit);
		
		log.info("Step AddEditAssetUnit_001 - 10: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Asset unit works")
	public void AddEditAssetUnit_002_CheckEditAssetUnitWorks() {	
		
		log.info("Step AddEditAssetUnit_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetUnit_002 - 02: Input correct username and password");
		log.info("Step AddEditAssetUnit_002 - 03: Accept Alert message");
		log.info("Step AddEditAssetUnit_002 - 04: Open Add Asset Unit page");
		log.info("Step AddEditAssetUnit_002 - 05: Input new Asset unit");
		log.info("Step AddEditAssetUnit_002 - 06: Click on Add button");
		log.info("Step AddEditAssetUnit_002 - 07: Input Description");
		log.info("Step AddEditAssetUnit_002 - 08: Click on Save button");
		log.info("Step AddEditAssetUnit_002 - 09: Input new Asset unit");
		log.info("Step AddEditAssetUnit_002 - 10: Click on Modify button");
		log.info("Step AddEditAssetUnit_002 - 11: Input new Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditAssetUnit_002 - 12: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetUnit_002 - 13: Input new Asset unit");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UnitCode", newAssetUnit);
		
		log.info("Step AddEditAssetUnit_002 - 14: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Asset unit works")
	public void AddEditAssetUnit_003_CheckDeactivateAssetUnitWorks() {	
		
		log.info("Step AddEditAssetUnit_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetUnit_003 - 02: Input correct username and password");
		log.info("Step AddEditAssetUnit_003 - 03: Accept Alert message");
		log.info("Step AddEditAssetUnit_003 - 04: Open Add Asset Unit page");
		log.info("Step AddEditAssetUnit_003 - 05: Input new Asset unit");
		log.info("Step AddEditAssetUnit_003 - 06: Click on Add button");
		log.info("Step AddEditAssetUnit_003 - 07: Input Description");
		log.info("Step AddEditAssetUnit_003 - 08: Click on Save button");
		log.info("Step AddEditAssetUnit_003 - 09: Input new Asset unit");
		log.info("Step AddEditAssetUnit_003 - 10: Click on Deactivate button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditAssetUnit_003 - 11: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditAssetUnit_003 - 12: Input new Asset unit");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UnitCode", newAssetUnit);
		
		log.info("Step AddEditAssetUnit_003 - 13: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Asset unit is deactivated");
		verifyEquals(assetManagerPage.getAlertText(DriverManager.getDriver()), "Asset Unit is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Asset unit works")
	public void AddEditAssetUnit_004_CheckReactivateAssetUnitWorks() {	
		
		log.info("Step AddEditAssetUnit_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetUnit_004 - 02: Input correct username and password");
		log.info("Step AddEditAssetUnit_004 - 03: Accept Alert message");
		log.info("Step AddEditAssetUnit_004 - 04: Open Add Asset Unit page");
		log.info("Step AddEditAssetUnit_004 - 05: Input new Asset unit");
		log.info("Step AddEditAssetUnit_004 - 06: Click on Add button");
		log.info("Step AddEditAssetUnit_004 - 07: Input Description");
		log.info("Step AddEditAssetUnit_004 - 08: Click on Save button");
		log.info("Step AddEditAssetUnit_004 - 09: Input new Asset unit");
		log.info("Step AddEditAssetUnit_004 - 10: Click on Deactivate button");
		log.info("Step AddEditAssetUnit_004 - 11: Accept alert");
		log.info("Step AddEditAssetUnit_004 - 12: Input new Asset unit");
		log.info("Step AddEditAssetUnit_004 - 13: Click on Modify button");
		log.info("Step AddEditAssetUnit_004 - 14: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(assetManagerPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset unit by Code works")
	public void AddEditAssetUnit_005_SearchAssetUnitByCode() {	
		
		log.info("Step AddEditAssetUnit_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetUnit_005 - 02: Input correct username and password");
		log.info("Step AddEditAssetUnit_005 - 03: Accept Alert message");
		log.info("Step AddEditAssetUnit_005 - 04: Open Add Asset Unit page");
		log.info("Step AddEditAssetUnit_005 - 05: Input new Asset unit");
		log.info("Step AddEditAssetUnit_005 - 06: Click on Add button");
		log.info("Step AddEditAssetUnit_005 - 07: Input Description");
		log.info("Step AddEditAssetUnit_005 - 08: Click on Save button");
		log.info("Step AddEditAssetUnit_005 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_unit.php");
		
		log.info("Step AddEditAssetUnit_005 - 10: Input Asset Unit");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetUnit", newAssetUnit);
		
		log.info("Step AddEditAssetUnit_005 - 11: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset unit displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetUnit, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset unit by Corporation works")
	public void AddEditAssetUnit_006_SearchAssetUnitByCorporation() {	
		
		log.info("Step AddEditAssetUnit_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetUnit_006 - 02: Input correct username and password");
		log.info("Step AddEditAssetUnit_006 - 03: Accept Alert message");
		log.info("Step AddEditAssetUnit_006 - 04: Open Add Asset Unit page");
		log.info("Step AddEditAssetUnit_006 - 05: Input new Asset unit");
		log.info("Step AddEditAssetUnit_006 - 06: Click on Add button");
		log.info("Step AddEditAssetUnit_006 - 07: Input Description");
		log.info("Step AddEditAssetUnit_006 - 08: Click on Save button");
		log.info("Step AddEditAssetUnit_006 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_unit.php");
		
		log.info("Step AddEditAssetUnit_006 - 10: Input Asset Unit");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetUnit", newAssetUnit);
		
		log.info("Step AddEditAssetUnit_006 - 11: Select Corporation");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditAssetUnit_006 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset unit displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetUnit, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset unit by Description works")
	public void AddEditAssetUnit_007_SearchAssetUnitByDescription() {	
		
		log.info("Step AddEditAssetUnit_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetUnit_007 - 02: Input correct username and password");
		log.info("Step AddEditAssetUnit_007 - 03: Accept Alert message");
		log.info("Step AddEditAssetUnit_007 - 04: Open Add Asset Unit page");
		log.info("Step AddEditAssetUnit_007 - 05: Input new Asset unit");
		log.info("Step AddEditAssetUnit_007 - 06: Click on Add button");
		log.info("Step AddEditAssetUnit_007 - 07: Input Description");
		log.info("Step AddEditAssetUnit_007 - 08: Click on Save button");
		log.info("Step AddEditAssetUnit_007 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_unit.php");
		
		log.info("Step AddEditAssetUnit_007 - 10: Input Asset Unit");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetUnit", newAssetUnit);
		
		log.info("Step AddEditAssetUnit_007 - 11: Input Asset Unit description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UnitDesc", "new description 2");
		
		log.info("Step AddEditAssetUnit_007 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset unit displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetUnit, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AssetManagerPage assetManagerPage;
	private String newAssetUnit;
}
