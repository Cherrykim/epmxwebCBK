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

public class AssetManager_05_AddEditAssetType extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		assetManagerPage = PageFactory.getAssetManagerPage(DriverManager.getDriver(), ipClient);
		newAssetType = getUniqueText(8);
	}

	@Test(groups = { "regression" }, description = "Check Add Asset type works")
	public void AddEditAssetType_001_CheckAddAssetTypeWorks() {	
		
		log.info("Step AddEditAssetType_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetType_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditAssetType_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditAssetType_001 - 04: Open Add Asset type page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/add_asset_type.php");

		log.info("Step AddEditAssetType_001 - 05: Input new Asset type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TypeCode", newAssetType);
		
		log.info("Step AddEditAssetType_001 - 06: Click on Add button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditAssetType_001 - 07: Input Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditAssetType_001 - 08: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetType_001 - 09: Input new Asset type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TypeCode", newAssetType);
		
		log.info("Step AddEditAssetType_001 - 10: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Asset type works")
	public void AddEditAssetType_002_CheckEditAssetTypeWorks() {	
		
		log.info("Step AddEditAssetType_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetType_002 - 02: Input correct username and password");
		log.info("Step AddEditAssetType_002 - 03: Accept Alert message");
		log.info("Step AddEditAssetType_002 - 04: Open Add Asset Type page");
		log.info("Step AddEditAssetType_002 - 05: Input new Asset type");
		log.info("Step AddEditAssetType_002 - 06: Click on Add button");
		log.info("Step AddEditAssetType_002 - 07: Input Description");
		log.info("Step AddEditAssetType_002 - 08: Click on Save button");
		log.info("Step AddEditAssetType_002 - 09: Input new Asset type");
		log.info("Step AddEditAssetType_002 - 10: Click on Modify button");
		log.info("Step AddEditAssetType_002 - 11: Input new Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditAssetType_002 - 12: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetType_002 - 13: Input new Asset type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TypeCode", newAssetType);
		
		log.info("Step AddEditAssetType_002 - 14: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Asset type works")
	public void AddEditAssetType_003_CheckDeactivateAssetTypeWorks() {	
		
		log.info("Step AddEditAssetType_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetType_003 - 02: Input correct username and password");
		log.info("Step AddEditAssetType_003 - 03: Accept Alert message");
		log.info("Step AddEditAssetType_003 - 04: Open Add Asset Type page");
		log.info("Step AddEditAssetType_003 - 05: Input new Asset type");
		log.info("Step AddEditAssetType_003 - 06: Click on Add button");
		log.info("Step AddEditAssetType_003 - 07: Input Description");
		log.info("Step AddEditAssetType_003 - 08: Click on Save button");
		log.info("Step AddEditAssetType_003 - 09: Input new Asset type");
		log.info("Step AddEditAssetType_003 - 10: Click on Deactivate button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditAssetType_003 - 11: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditAssetType_003 - 12: Input new Asset type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TypeCode", newAssetType);
		
		log.info("Step AddEditAssetType_003 - 13: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Asset type is deactivated");
		verifyEquals(assetManagerPage.getAlertText(DriverManager.getDriver()), "Asset Type is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Asset type works")
	public void AddEditAssetType_004_CheckReactivateAssetTypeWorks() {	
		
		log.info("Step AddEditAssetType_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetType_004 - 02: Input correct username and password");
		log.info("Step AddEditAssetType_004 - 03: Accept Alert message");
		log.info("Step AddEditAssetType_004 - 04: Open Add Asset Type page");
		log.info("Step AddEditAssetType_004 - 05: Input new Asset type");
		log.info("Step AddEditAssetType_004 - 06: Click on Add button");
		log.info("Step AddEditAssetType_004 - 07: Input Description");
		log.info("Step AddEditAssetType_004 - 08: Click on Save button");
		log.info("Step AddEditAssetType_004 - 09: Input new Asset type");
		log.info("Step AddEditAssetType_004 - 10: Click on Deactivate button");
		log.info("Step AddEditAssetType_004 - 11: Accept alert");
		log.info("Step AddEditAssetType_004 - 12: Input new Asset type");
		log.info("Step AddEditAssetType_004 - 13: Click on Modify button");
		log.info("Step AddEditAssetType_004 - 14: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(assetManagerPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset type by Code works")
	public void AddEditAssetType_005_SearchAssetTypeByCode() {	
		
		log.info("Step AddEditAssetType_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetType_005 - 02: Input correct username and password");
		log.info("Step AddEditAssetType_005 - 03: Accept Alert message");
		log.info("Step AddEditAssetType_005 - 04: Open Add Asset Type page");
		log.info("Step AddEditAssetType_005 - 05: Input new Asset type");
		log.info("Step AddEditAssetType_005 - 06: Click on Add button");
		log.info("Step AddEditAssetType_005 - 07: Input Description");
		log.info("Step AddEditAssetType_005 - 08: Click on Save button");
		log.info("Step AddEditAssetType_005 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_type.php");
		
		log.info("Step AddEditAssetType_005 - 10: Input Asset Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newAssetType);
		
		log.info("Step AddEditAssetType_005 - 11: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset type displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetType, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset type by Corporation works")
	public void AddEditAssetType_006_SearchAssetTypeByCorporation() {	
		
		log.info("Step AddEditAssetType_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetType_006 - 02: Input correct username and password");
		log.info("Step AddEditAssetType_006 - 03: Accept Alert message");
		log.info("Step AddEditAssetType_006 - 04: Open Add Asset Type page");
		log.info("Step AddEditAssetType_006 - 05: Input new Asset type");
		log.info("Step AddEditAssetType_006 - 06: Click on Add button");
		log.info("Step AddEditAssetType_006 - 07: Input Description");
		log.info("Step AddEditAssetType_006 - 08: Click on Save button");
		log.info("Step AddEditAssetType_006 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_type.php");
		
		log.info("Step AddEditAssetType_006 - 10: Input Asset Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newAssetType);
		
		log.info("Step AddEditAssetType_006 - 11: Select Corporation");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditAssetType_006 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset type displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetType, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset type by Description works")
	public void AddEditAssetType_007_SearchAssetTypeByDescription() {	
		
		log.info("Step AddEditAssetType_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetType_007 - 02: Input correct username and password");
		log.info("Step AddEditAssetType_007 - 03: Accept Alert message");
		log.info("Step AddEditAssetType_007 - 04: Open Add Asset Type page");
		log.info("Step AddEditAssetType_007 - 05: Input new Asset type");
		log.info("Step AddEditAssetType_007 - 06: Click on Add button");
		log.info("Step AddEditAssetType_007 - 07: Input Description");
		log.info("Step AddEditAssetType_007 - 08: Click on Save button");
		log.info("Step AddEditAssetType_007 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_type.php");
		
		log.info("Step AddEditAssetType_007 - 10: Input Asset Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newAssetType);
		
		log.info("Step AddEditAssetType_007 - 11: Input Asset Type description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TypeDesc", "new description 2");
		
		log.info("Step AddEditAssetType_007 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset type displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetType, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AssetManagerPage assetManagerPage;
	private String newAssetType;
}
