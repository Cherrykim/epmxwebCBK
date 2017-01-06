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

public class AssetManager_04_AddEditAssetStatus extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		assetManagerPage = PageFactory.getAssetManagerPage(DriverManager.getDriver(), ipClient);
		newAssetStatus = getUniqueText(8);
	}

	@Test(groups = { "regression" }, description = "Check Add Asset status works")
	public void AddEditAssetStatus_001_CheckAddAssetStatusWorks() {	
		
		log.info("Step AddEditAssetStatus_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetStatus_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditAssetStatus_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditAssetStatus_001 - 04: Open Add Asset status page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/add_asset_status.php");

		log.info("Step AddEditAssetStatus_001 - 05: Input new Asset status");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_StatusCode", newAssetStatus);
		
		log.info("Step AddEditAssetStatus_001 - 06: Click on Add button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditAssetStatus_001 - 07: Input Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditAssetStatus_001 - 08: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetStatus_001 - 09: Input new Asset status");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_StatusCode", newAssetStatus);
		
		log.info("Step AddEditAssetStatus_001 - 10: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Asset status works")
	public void AddEditAssetStatus_002_CheckEditAssetStatusWorks() {	
		
		log.info("Step AddEditAssetStatus_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetStatus_002 - 02: Input correct username and password");
		log.info("Step AddEditAssetStatus_002 - 03: Accept Alert message");
		log.info("Step AddEditAssetStatus_002 - 04: Open Add Asset Status page");
		log.info("Step AddEditAssetStatus_002 - 05: Input new Asset status");
		log.info("Step AddEditAssetStatus_002 - 06: Click on Add button");
		log.info("Step AddEditAssetStatus_002 - 07: Input Description");
		log.info("Step AddEditAssetStatus_002 - 08: Click on Save button");
		log.info("Step AddEditAssetStatus_002 - 09: Input new Asset status");
		log.info("Step AddEditAssetStatus_002 - 10: Click on Modify button");
		log.info("Step AddEditAssetStatus_002 - 11: Input new Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditAssetStatus_002 - 12: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetStatus_002 - 13: Input new Asset status");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_StatusCode", newAssetStatus);
		
		log.info("Step AddEditAssetStatus_002 - 14: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Asset status works")
	public void AddEditAssetStatus_003_CheckDeactivateAssetStatusWorks() {	
		
		log.info("Step AddEditAssetStatus_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetStatus_003 - 02: Input correct username and password");
		log.info("Step AddEditAssetStatus_003 - 03: Accept Alert message");
		log.info("Step AddEditAssetStatus_003 - 04: Open Add Asset Status page");
		log.info("Step AddEditAssetStatus_003 - 05: Input new Asset status");
		log.info("Step AddEditAssetStatus_003 - 06: Click on Add button");
		log.info("Step AddEditAssetStatus_003 - 07: Input Description");
		log.info("Step AddEditAssetStatus_003 - 08: Click on Save button");
		log.info("Step AddEditAssetStatus_003 - 09: Input new Asset status");
		log.info("Step AddEditAssetStatus_003 - 10: Click on Deactivate button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditAssetStatus_003 - 11: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditAssetStatus_003 - 12: Input new Asset status");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_StatusCode", newAssetStatus);
		
		log.info("Step AddEditAssetStatus_003 - 13: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Asset status is deactivated");
		verifyEquals(assetManagerPage.getAlertText(DriverManager.getDriver()), "Asset Status is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Asset status works")
	public void AddEditAssetStatus_004_CheckReactivateAssetStatusWorks() {	
		
		log.info("Step AddEditAssetStatus_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetStatus_004 - 02: Input correct username and password");
		log.info("Step AddEditAssetStatus_004 - 03: Accept Alert message");
		log.info("Step AddEditAssetStatus_004 - 04: Open Add Asset Status page");
		log.info("Step AddEditAssetStatus_004 - 05: Input new Asset status");
		log.info("Step AddEditAssetStatus_004 - 06: Click on Add button");
		log.info("Step AddEditAssetStatus_004 - 07: Input Description");
		log.info("Step AddEditAssetStatus_004 - 08: Click on Save button");
		log.info("Step AddEditAssetStatus_004 - 09: Input new Asset status");
		log.info("Step AddEditAssetStatus_004 - 10: Click on Deactivate button");
		log.info("Step AddEditAssetStatus_004 - 11: Accept alert");
		log.info("Step AddEditAssetStatus_004 - 12: Input new Asset status");
		log.info("Step AddEditAssetStatus_004 - 13: Click on Modify button");
		log.info("Step AddEditAssetStatus_004 - 14: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(assetManagerPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset status by Code works")
	public void AddEditAssetStatus_005_SearchAssetStatusByCode() {	
		
		log.info("Step AddEditAssetStatus_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetStatus_005 - 02: Input correct username and password");
		log.info("Step AddEditAssetStatus_005 - 03: Accept Alert message");
		log.info("Step AddEditAssetStatus_005 - 04: Open Add Asset Status page");
		log.info("Step AddEditAssetStatus_005 - 05: Input new Asset status");
		log.info("Step AddEditAssetStatus_005 - 06: Click on Add button");
		log.info("Step AddEditAssetStatus_005 - 07: Input Description");
		log.info("Step AddEditAssetStatus_005 - 08: Click on Save button");
		log.info("Step AddEditAssetStatus_005 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_status.php");
		
		log.info("Step AddEditAssetStatus_005 - 10: Input Asset Status");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetStatus", newAssetStatus);
		
		log.info("Step AddEditAssetStatus_005 - 11: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset status displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetStatus, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset status by Corporation works")
	public void AddEditAssetStatus_006_SearchAssetStatusByCorporation() {	
		
		log.info("Step AddEditAssetStatus_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetStatus_006 - 02: Input correct username and password");
		log.info("Step AddEditAssetStatus_006 - 03: Accept Alert message");
		log.info("Step AddEditAssetStatus_006 - 04: Open Add Asset Status page");
		log.info("Step AddEditAssetStatus_006 - 05: Input new Asset status");
		log.info("Step AddEditAssetStatus_006 - 06: Click on Add button");
		log.info("Step AddEditAssetStatus_006 - 07: Input Description");
		log.info("Step AddEditAssetStatus_006 - 08: Click on Save button");
		log.info("Step AddEditAssetStatus_006 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_status.php");
		
		log.info("Step AddEditAssetStatus_006 - 10: Input Asset Status");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetStatus", newAssetStatus);
		
		log.info("Step AddEditAssetStatus_006 - 11: Select Corporation");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditAssetStatus_006 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset status displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetStatus, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset status by Description works")
	public void AddEditAssetStatus_007_SearchAssetStatusByDescription() {	
		
		log.info("Step AddEditAssetStatus_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetStatus_007 - 02: Input correct username and password");
		log.info("Step AddEditAssetStatus_007 - 03: Accept Alert message");
		log.info("Step AddEditAssetStatus_007 - 04: Open Add Asset Status page");
		log.info("Step AddEditAssetStatus_007 - 05: Input new Asset status");
		log.info("Step AddEditAssetStatus_007 - 06: Click on Add button");
		log.info("Step AddEditAssetStatus_007 - 07: Input Description");
		log.info("Step AddEditAssetStatus_007 - 08: Click on Save button");
		log.info("Step AddEditAssetStatus_007 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_status.php");
		
		log.info("Step AddEditAssetStatus_007 - 10: Input Asset Status");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetStatus", newAssetStatus);
		
		log.info("Step AddEditAssetStatus_007 - 11: Input Asset Status description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_StatusDesc", "new description 2");
		
		log.info("Step AddEditAssetStatus_007 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset status displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetStatus, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AssetManagerPage assetManagerPage;
	private String newAssetStatus;
}
