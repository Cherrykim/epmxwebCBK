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

public class AssetManager_03_AddEditAssetLocation extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		assetManagerPage = PageFactory.getAssetManagerPage(DriverManager.getDriver(), ipClient);
		newAssetLocation = getUniqueText(8);
	}

	@Test(groups = { "regression" }, description = "Check Add Asset location works")
	public void AddEditAssetLocation_001_CheckAddAssetLocationWorks() {	
		
		log.info("Step AddEditAssetLocation_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetLocation_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditAssetLocation_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditAssetLocation_001 - 04: Open Add Asset location page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/add_asset_location.php");

		log.info("Step AddEditAssetLocation_001 - 05: Input new Asset location");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LocationCode", newAssetLocation);
		
		log.info("Step AddEditAssetLocation_001 - 06: Click on Add button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditAssetLocation_001 - 07: Input Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDescription", "new description");
		
		log.info("Step AddEditAssetLocation_001 - 08: Input all fields");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_Address", "141 Baker street");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "London");
		assetManagerPage.selectRadioButtonByName(DriverManager.getDriver(), "Non US");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_State", "No State");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Country", "UK");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12345");
		
		log.info("Step AddEditAssetLocation_001 - 09: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetLocation_001 - 10: Input new Asset location");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LocationCode", newAssetLocation);
		
		log.info("Step AddEditAssetLocation_001 - 11: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_AssetDescription"), "new description");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_Address").trim(), "141 Baker street");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "London");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_State"), "No State");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12345");
		verifyEquals(assetManagerPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Country"), "UK");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Asset location works")
	public void AddEditAssetLocation_002_CheckEditAssetLocationWorks() {	
		
		log.info("Step AddEditAssetLocation_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetLocation_002 - 02: Input correct username and password");
		log.info("Step AddEditAssetLocation_002 - 03: Accept Alert message");
		log.info("Step AddEditAssetLocation_002 - 04: Open Add Asset Location page");
		log.info("Step AddEditAssetLocation_002 - 05: Input new Asset location");
		log.info("Step AddEditAssetLocation_002 - 06: Click on Add button");
		log.info("Step AddEditAssetLocation_002 - 07: Input Description");
		log.info("Step AddEditAssetLocation_002 - 08: Click on Save button");
		log.info("Step AddEditAssetLocation_002 - 09: Input new Asset location");
		log.info("Step AddEditAssetLocation_002 - 10: Click on Modify button");
		log.info("Step AddEditAssetLocation_002 - 11: Input new Description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDescription", "new description 2");
		
		log.info("Step AddEditAssetLocation_002 - 12: Input all other fields");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_Address", "123 Nameless Street");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "Washington");
		assetManagerPage.selectRadioButtonByName(DriverManager.getDriver(), "US");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_State", "Alabama");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12346");
		
		log.info("Step AddEditAssetLocation_002 - 13: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetLocation_002 - 14: Input new Asset location");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LocationCode", newAssetLocation);
		
		log.info("Step AddEditAssetLocation_002 - 15: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_AssetDescription"), "new description 2");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_Address").trim(), "123 Nameless Street");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "Washington");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12346");
		verifyEquals(assetManagerPage.getSelectedItemByID(DriverManager.getDriver(), "sel_State"), "Alabama");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Asset location works")
	public void AddEditAssetLocation_003_CheckDeactivateAssetLocationWorks() {	
		
		log.info("Step AddEditAssetLocation_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetLocation_003 - 02: Input correct username and password");
		log.info("Step AddEditAssetLocation_003 - 03: Accept Alert message");
		log.info("Step AddEditAssetLocation_003 - 04: Open Add Asset Location page");
		log.info("Step AddEditAssetLocation_003 - 05: Input new Asset location");
		log.info("Step AddEditAssetLocation_003 - 06: Click on Add button");
		log.info("Step AddEditAssetLocation_003 - 07: Input Description");
		log.info("Step AddEditAssetLocation_003 - 08: Click on Save button");
		log.info("Step AddEditAssetLocation_003 - 09: Input new Asset location");
		log.info("Step AddEditAssetLocation_003 - 10: Click on Deactivate button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditAssetLocation_003 - 11: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditAssetLocation_003 - 12: Input new Asset location");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LocationCode", newAssetLocation);
		
		log.info("Step AddEditAssetLocation_003 - 13: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Asset location is deactivated");
		verifyEquals(assetManagerPage.getAlertText(DriverManager.getDriver()), "Asset Location is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Asset location works")
	public void AddEditAssetLocation_004_CheckReactivateAssetLocationWorks() {	
		
		log.info("Step AddEditAssetLocation_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetLocation_004 - 02: Input correct username and password");
		log.info("Step AddEditAssetLocation_004 - 03: Accept Alert message");
		log.info("Step AddEditAssetLocation_004 - 04: Open Add Asset Location page");
		log.info("Step AddEditAssetLocation_004 - 05: Input new Asset location");
		log.info("Step AddEditAssetLocation_004 - 06: Click on Add button");
		log.info("Step AddEditAssetLocation_004 - 07: Input Description");
		log.info("Step AddEditAssetLocation_004 - 08: Click on Save button");
		log.info("Step AddEditAssetLocation_004 - 09: Input new Asset location");
		log.info("Step AddEditAssetLocation_004 - 10: Click on Deactivate button");
		log.info("Step AddEditAssetLocation_004 - 11: Accept alert");
		log.info("Step AddEditAssetLocation_004 - 12: Input new Asset location");
		log.info("Step AddEditAssetLocation_004 - 13: Click on Modify button");
		log.info("Step AddEditAssetLocation_004 - 14: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(assetManagerPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset location by Code works")
	public void AddEditAssetLocation_005_SearchAssetLocationByCode() {	
		
		log.info("Step AddEditAssetLocation_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetLocation_005 - 02: Input correct username and password");
		log.info("Step AddEditAssetLocation_005 - 03: Accept Alert message");
		log.info("Step AddEditAssetLocation_005 - 04: Open Add Asset Location page");
		log.info("Step AddEditAssetLocation_005 - 05: Input new Asset location");
		log.info("Step AddEditAssetLocation_005 - 06: Click on Add button");
		log.info("Step AddEditAssetLocation_005 - 07: Input Description");
		log.info("Step AddEditAssetLocation_005 - 08: Click on Save button");
		log.info("Step AddEditAssetLocation_005 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_location.php");
		
		log.info("Step AddEditAssetLocation_005 - 10: Input Asset Location");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetLocation", newAssetLocation);
		
		log.info("Step AddEditAssetLocation_005 - 11: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset location displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetLocation, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset location by Corporation works")
	public void AddEditAssetLocation_006_SearchAssetLocationByCorporation() {	
		
		log.info("Step AddEditAssetLocation_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetLocation_006 - 02: Input correct username and password");
		log.info("Step AddEditAssetLocation_006 - 03: Accept Alert message");
		log.info("Step AddEditAssetLocation_006 - 04: Open Add Asset Location page");
		log.info("Step AddEditAssetLocation_006 - 05: Input new Asset location");
		log.info("Step AddEditAssetLocation_006 - 06: Click on Add button");
		log.info("Step AddEditAssetLocation_006 - 07: Input Description");
		log.info("Step AddEditAssetLocation_006 - 08: Click on Save button");
		log.info("Step AddEditAssetLocation_006 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_location.php");
		
		log.info("Step AddEditAssetLocation_006 - 10: Input Asset Location");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetLocation", newAssetLocation);
		
		log.info("Step AddEditAssetLocation_006 - 11: Select Corporation");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditAssetLocation_006 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset location displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetLocation, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset location by City works")
	public void AddEditAssetLocation_007_SearchAssetLocationByCity() {	
		
		log.info("Step AddEditAssetLocation_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetLocation_007 - 02: Input correct username and password");
		log.info("Step AddEditAssetLocation_007 - 03: Accept Alert message");
		log.info("Step AddEditAssetLocation_007 - 04: Open Add Asset Location page");
		log.info("Step AddEditAssetLocation_007 - 05: Input new Asset location");
		log.info("Step AddEditAssetLocation_007 - 06: Click on Add button");
		log.info("Step AddEditAssetLocation_007 - 07: Input Description");
		log.info("Step AddEditAssetLocation_007 - 08: Click on Save button");
		log.info("Step AddEditAssetLocation_007 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset_location.php");
		
		log.info("Step AddEditAssetLocation_007 - 10: Input Asset Location");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetLocation", newAssetLocation);
		
		log.info("Step AddEditAssetLocation_007 - 11: Input Asset Location City");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LocationCity", "Washington");
		
		log.info("Step AddEditAssetLocation_007 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset location displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetLocation, "Washington"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AssetManagerPage assetManagerPage;
	private String newAssetLocation;
}
