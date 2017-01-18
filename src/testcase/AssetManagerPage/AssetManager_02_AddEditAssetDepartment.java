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

public class AssetManager_02_AddEditAssetDepartment extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		assetManagerPage = PageFactory.getAssetManagerPage(DriverManager.getDriver(), ipClient);
		newAssetDepartment = getUniqueText(8);
	}

	@Test(groups = { "regression" }, description = "Check Add Asset department works")
	public void AddEditAssetDepartment_001_CheckAddAssetDepartmentWorks() {	
		
		log.info("Step AddEditAssetDepartment_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetDepartment_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditAssetDepartment_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditAssetDepartment_001 - 04: Open Add Asset department page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/add_asset_department.php");

		log.info("Step AddEditAssetDepartment_001 - 05: Input new Asset department");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DepartmentCode", newAssetDepartment);
		
		log.info("Step AddEditAssetDepartment_001 - 06: Click on Add button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditAssetDepartment_001 - 07: Input Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditAssetDepartment_001 - 08: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetDepartment_001 - 09: Input new Asset department");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DepartmentCode", newAssetDepartment);
		
		log.info("Step AddEditAssetDepartment_001 - 10: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Asset department works")
	public void AddEditAssetDepartment_002_CheckEditAssetDepartmentWorks() {	
		
		log.info("Step AddEditAssetDepartment_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetDepartment_002 - 02: Input correct username and password");
		log.info("Step AddEditAssetDepartment_002 - 03: Accept Alert message");
		log.info("Step AddEditAssetDepartment_002 - 04: Open Add Asset Department page");
		log.info("Step AddEditAssetDepartment_002 - 05: Input new Asset department");
		log.info("Step AddEditAssetDepartment_002 - 06: Click on Add button");
		log.info("Step AddEditAssetDepartment_002 - 07: Input Description");
		log.info("Step AddEditAssetDepartment_002 - 08: Click on Save button");
		log.info("Step AddEditAssetDepartment_002 - 09: Input new Asset department");
		log.info("Step AddEditAssetDepartment_002 - 10: Click on Modify button");
		log.info("Step AddEditAssetDepartment_002 - 11: Input new Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditAssetDepartment_002 - 12: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetDepartment_002 - 13: Input new Asset department");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DepartmentCode", newAssetDepartment);
		
		log.info("Step AddEditAssetDepartment_002 - 14: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Asset department works")
	public void AddEditAssetDepartment_003_CheckDeactivateAssetDepartmentWorks() {	
		
		log.info("Step AddEditAssetDepartment_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetDepartment_003 - 02: Input correct username and password");
		log.info("Step AddEditAssetDepartment_003 - 03: Accept Alert message");
		log.info("Step AddEditAssetDepartment_003 - 04: Open Add Asset Department page");
		log.info("Step AddEditAssetDepartment_003 - 05: Input new Asset department");
		log.info("Step AddEditAssetDepartment_003 - 06: Click on Add button");
		log.info("Step AddEditAssetDepartment_003 - 07: Input Description");
		log.info("Step AddEditAssetDepartment_003 - 08: Click on Save button");
		log.info("Step AddEditAssetDepartment_003 - 09: Input new Asset department");
		log.info("Step AddEditAssetDepartment_003 - 10: Click on Deactivate button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditAssetDepartment_003 - 11: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditAssetDepartment_003 - 12: Input new Asset department");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DepartmentCode", newAssetDepartment);
		
		log.info("Step AddEditAssetDepartment_003 - 13: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Asset department is deactivated");
		verifyEquals(assetManagerPage.getAlertText(DriverManager.getDriver()), "Asset Department is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Asset department works")
	public void AddEditAssetDepartment_004_CheckReactivateAssetDepartmentWorks() {	
		
		log.info("Step AddEditAssetDepartment_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetDepartment_004 - 02: Input correct username and password");
		log.info("Step AddEditAssetDepartment_004 - 03: Accept Alert message");
		log.info("Step AddEditAssetDepartment_004 - 04: Open Add Asset Department page");
		log.info("Step AddEditAssetDepartment_004 - 05: Input new Asset department");
		log.info("Step AddEditAssetDepartment_004 - 06: Click on Add button");
		log.info("Step AddEditAssetDepartment_004 - 07: Input Description");
		log.info("Step AddEditAssetDepartment_004 - 08: Click on Save button");
		log.info("Step AddEditAssetDepartment_004 - 09: Input new Asset department");
		log.info("Step AddEditAssetDepartment_004 - 10: Click on Deactivate button");
		log.info("Step AddEditAssetDepartment_004 - 11: Accept alert");
		log.info("Step AddEditAssetDepartment_004 - 12: Input new Asset department");
		log.info("Step AddEditAssetDepartment_004 - 13: Click on Modify button");
		log.info("Step AddEditAssetDepartment_004 - 14: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(assetManagerPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset department by Code works")
	public void AddEditAssetDepartment_005_SearchAssetDepartmentByCode() {	
		
		log.info("Step AddEditAssetDepartment_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetDepartment_005 - 02: Input correct username and password");
		log.info("Step AddEditAssetDepartment_005 - 03: Accept Alert message");
		log.info("Step AddEditAssetDepartment_005 - 04: Open Add Asset Department page");
		log.info("Step AddEditAssetDepartment_005 - 05: Input new Asset department");
		log.info("Step AddEditAssetDepartment_005 - 06: Click on Add button");
		log.info("Step AddEditAssetDepartment_005 - 07: Input Description");
		log.info("Step AddEditAssetDepartment_005 - 08: Click on Save button");
		log.info("Step AddEditAssetDepartment_005 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_department.php");
		
		log.info("Step AddEditAssetDepartment_005 - 10: Input Asset Department");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDept", newAssetDepartment);
		
		log.info("Step AddEditAssetDepartment_005 - 11: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset department displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetDepartment, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset department by Corporation works")
	public void AddEditAssetDepartment_006_SearchAssetDepartmentByCorporation() {	
		
		log.info("Step AddEditAssetDepartment_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetDepartment_006 - 02: Input correct username and password");
		log.info("Step AddEditAssetDepartment_006 - 03: Accept Alert message");
		log.info("Step AddEditAssetDepartment_006 - 04: Open Add Asset Department page");
		log.info("Step AddEditAssetDepartment_006 - 05: Input new Asset department");
		log.info("Step AddEditAssetDepartment_006 - 06: Click on Add button");
		log.info("Step AddEditAssetDepartment_006 - 07: Input Description");
		log.info("Step AddEditAssetDepartment_006 - 08: Click on Save button");
		log.info("Step AddEditAssetDepartment_006 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_department.php");
		
		log.info("Step AddEditAssetDepartment_006 - 10: Input Asset Department");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDept", newAssetDepartment);
		
		log.info("Step AddEditAssetDepartment_006 - 11: Select Corporation");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditAssetDepartment_006 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset department displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetDepartment, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset department by Description works")
	public void AddEditAssetDepartment_007_SearchAssetDepartmentByDescription() {	
		
		log.info("Step AddEditAssetDepartment_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetDepartment_007 - 02: Input correct username and password");
		log.info("Step AddEditAssetDepartment_007 - 03: Accept Alert message");
		log.info("Step AddEditAssetDepartment_007 - 04: Open Add Asset Department page");
		log.info("Step AddEditAssetDepartment_007 - 05: Input new Asset department");
		log.info("Step AddEditAssetDepartment_007 - 06: Click on Add button");
		log.info("Step AddEditAssetDepartment_007 - 07: Input Description");
		log.info("Step AddEditAssetDepartment_007 - 08: Click on Save button");
		log.info("Step AddEditAssetDepartment_007 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_department.php");
		
		log.info("Step AddEditAssetDepartment_007 - 10: Input Asset Department");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDept", newAssetDepartment);
		
		log.info("Step AddEditAssetDepartment_007 - 11: Input Asset Department description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDesc", "new description 2");
		
		log.info("Step AddEditAssetDepartment_007 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset department displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetDepartment, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AssetManagerPage assetManagerPage;
	private String newAssetDepartment;
}
