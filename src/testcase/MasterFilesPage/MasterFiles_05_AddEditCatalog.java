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

public class MasterFiles_05_AddEditCatalog extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newCatalog = getUniqueText(15);
		item1 = "100 : CLRS - Other Research 100% - W";
		item2 = "105 : CLRS - Other Research 5% - Wad";
	}

	@Test(groups = { "regression" }, description = "Check Add Catalog works")
	public void AddCatalogCode_001_CheckAddCatalogWorks() {	
		
		log.info("Step AddCatalogCode_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCatalogCode_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step AddCatalogCode_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddCatalogCode_001 - 04: Open Add Catalog page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_catalog.php");

		log.info("Step AddCatalogCode_001 - 05: Input new Catalog");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CatalogCode", newCatalog);
		
		log.info("Step AddCatalogCode_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddCatalogCode_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddCatalogCode_001 - 08: Click on Catalog item textfield button");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "txt_Items0");
		
		log.info("Step AddCatalogCode_001 - 09: Select catalog item");
		masterFilesPage.clickOnDivByItsText(DriverManager.getDriver(), item1);
		
		log.info("Step AddCatalogCode_001 - 10: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddCatalogCode_001 - 11: Input new Catalog");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CatalogCode", newCatalog);
		
		log.info("Step AddCatalogCode_001 - 12: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
		
		log.info("VP: First record is displayed correctly");
		verifyTrue(masterFilesPage.isFirstCatalogItemDisplayedCorrectly(item1));
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Catalog works")
	public void AddCatalogCode_002_CheckEditCatalogWorks() {	
		
		log.info("Step AddCatalogCode_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCatalogCode_002 - 02: Input correct username and password");
		log.info("Step AddCatalogCode_002 - 03: Accept Alert message");
		log.info("Step AddCatalogCode_002 - 04: Open Add labels page");
		log.info("Step AddCatalogCode_002 - 05: Input new Catalog");
		log.info("Step AddCatalogCode_002 - 06: Click on Add button");
		log.info("Step AddCatalogCode_002 - 07: Input Description");
		log.info("Step AddCatalogCode_002 - 08: Click on Catalog item textfield button");
		log.info("Step AddCatalogCode_002 - 09: Select catalog item");
		log.info("Step AddCatalogCode_002 - 10: Click on Save button");
		log.info("Step AddCatalogCode_002 - 11: Input new Catalog");
		log.info("Step AddCatalogCode_002 - 12: Click on Modify button");
		log.info("Step AddCatalogCode_001 - 13: Change description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddCatalogCode_002 - 14: Remove first record");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddCatalogCode_001 - 15: Click on Catalog item textfield button");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "txt_Items1");
		
		log.info("Step AddCatalogCode_001 - 16: Select catalog item");
		masterFilesPage.clickOnDivByItsText(DriverManager.getDriver(), item2);
		
		log.info("Step AddCatalogCode_001 - 17: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddCatalogCode_001 - 18: Input new Catalog");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CatalogCode", newCatalog);
		
		log.info("Step AddCatalogCode_001 - 19: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
		
		log.info("VP: First record is displayed correctly");
		verifyTrue(masterFilesPage.isFirstCatalogItemDisplayedCorrectly(item2));
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Catalog works")
	public void AddCatalogCode_003_CheckDeactivateCatalogWorks() {	
		
		log.info("Step AddCatalogCode_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCatalogCode_003 - 02: Input correct username and password");
		log.info("Step AddCatalogCode_003 - 03: Accept Alert message");
		log.info("Step AddCatalogCode_003 - 04: Open Add labels page");
		log.info("Step AddCatalogCode_003 - 05: Input new Catalog");
		log.info("Step AddCatalogCode_003 - 06: Click on Add button");
		log.info("Step AddCatalogCode_003 - 07: Input Description");
		log.info("Step AddCatalogCode_003 - 08: Click on Save button");
		log.info("Step AddCatalogCode_003 - 09: Input new Catalog");
		log.info("Step AddCatalogCode_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddCatalogCode_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddCatalogCode_003 - 12: Input new Catalog");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CatalogCode", newCatalog);
		
		log.info("Step AddCatalogCode_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Catalog Code is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Catalog Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Catalog works")
	public void AddCatalogCode_004_CheckReactivateCatalogWorks() {	
		
		log.info("Step AddCatalogCode_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCatalogCode_004 - 02: Input correct username and password");
		log.info("Step AddCatalogCode_004 - 03: Accept Alert message");
		log.info("Step AddCatalogCode_004 - 04: Open Add labels page");
		log.info("Step AddCatalogCode_004 - 05: Input new Catalog");
		log.info("Step AddCatalogCode_004 - 06: Click on Add button");
		log.info("Step AddCatalogCode_004 - 07: Input Description");
		log.info("Step AddCatalogCode_004 - 08: Click on Save button");
		log.info("Step AddCatalogCode_004 - 09: Input new Catalog");
		log.info("Step AddCatalogCode_004 - 10: Click on Deactivate button");
		log.info("Step AddCatalogCode_004 - 11: Accept alert");
		log.info("Step AddCatalogCode_004 - 12: Input new Catalog");
		log.info("Step AddCatalogCode_004 - 13: Click on Modify button");
		log.info("Step AddCatalogCode_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newCatalog;
	private String item1, item2;
}
