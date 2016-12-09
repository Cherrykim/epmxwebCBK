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
import page.ConfigPage;
import page.LoginPage;

public class MasterFiles_14_AddEditKits extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		configPage = PageFactory.getConfigPage(DriverManager.getDriver(), ipClient);
		
		newKits = getUniqueText(10);
		itemCode1 = "item1";
		itemCode2 = "item2";
		unitOfMeasure1 = "um1";
		unitOfMeasure2 = "um2";
		validDecimal1 = "11.1111";
		validDecimal2 = "22.2222";
		validText1 = "!@#$text";
		validText2 = "%^&*text";
		
		log.info("Pre-condition - 01: Open the site http://tool.cherry.epmxweb.com/");
		log.info("Pre-condition - 02: Select Brand: 'master'");
		log.info("Pre-condition - 03: Choose available MySQL database and get an Username");
		log.info("Pre-condition - 04: Click on Config button and get default Password");
		log.info("Pre-condition - 05: Open the site https://cherry.epmxweb.com");
		configPage.selectBranchAndDatabase(Constant.DefaultValue.CURRENT_BRANCH, Constant.DefaultValue.HSW_DATABASE);
		
		log.info("Pre-condition - 06: Open the site https://cherry.epmxweb.com");
		log.info("Pre-condition - 07: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_HSW, Constant.LoginData.PASSWORD);
		
		log.info("Pre-condition - 08: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Pre-condition - 09: Create Unit of measure");
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure1);
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure2);
		
		log.info("Pre-condition - 10: Create Item code");
		masterFilesPage.createNewItemCodeHSW(itemCode1);
		masterFilesPage.createNewItemCodeHSW(itemCode2);
	}

	@Test(groups = { "regression" }, description = "Check Add Kits works")
	public void AddEditKits_001_CheckAddKitsWorks() {	
		
		log.info("Step AddEditKits_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditKits_001 - 02: Input correct username and password");
		log.info("Step AddEditKits_001 - 03: Accept Alert message");
		log.info("Step AddEditKits_001 - 04: Open Add Kits page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_kits.php");

		log.info("Step AddEditKits_001 - 05: Input new Kits");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_KitNumber", newKits);
		
		log.info("Step AddEditKits_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditKits_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", validText1);
		
		log.info("Step AddEditKits_001 - 08: Input Item code");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Items0", itemCode1);
		
		log.info("Step AddEditKits_001 - 09: Input Quantity");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Quantity0", validDecimal1);
		
		log.info("Step AddEditKits_001 - 07: Select Unit measure");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Measure0", unitOfMeasure1);
		
		log.info("Step AddEditKits_001 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditKits_001 - 13: Input new Kits");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_KitNumber", newKits);
		
		log.info("Step AddEditKits_001 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		////
		
		log.info("Step AddEditKits_001 - VP: Description is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), validText1);
		
		log.info("Step AddEditKits_001 - VP: Item code displayed correctly");
		masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Item0", itemCode1);
		
		log.info("Step AddEditKits_001 - VP: Quantity is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Quantity0"), validDecimal1);
		
		log.info("Step AddEditKits_001 - VP: Unit measure is saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Measure0"), unitOfMeasure1);
		
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Kits works")
	public void AddEditKits_002_CheckEditKitsWorks() {	
		
		log.info("Step AddEditKits_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditKits_002 - 02: Input correct username and password");
		log.info("Step AddEditKits_002 - 03: Accept Alert message");
		log.info("Step AddEditKits_002 - 04: Open Add Kits page");
		log.info("Step AddEditKits_002 - 05: Input new Kits");
		log.info("Step AddEditKits_002 - 06: Click on Add button");
		log.info("Step AddEditKits_002 - 07: Input Description");
		log.info("Step AddEditKits_002 - 08: Input Item code");
		log.info("Step AddEditKits_002 - 09: Input Quantity");
		log.info("Step AddEditKits_002 - 10: Select Unit measure");
		log.info("Step AddEditKits_002 - 11: Click on Save button");
		log.info("Step AddEditKits_002 - 12: Input new Kits");
		log.info("Step AddEditKits_002 - 13: Click on Modify button");
		log.info("Step AddEditKits_002 - 14: Edit Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", validText2);
		
		log.info("Step AddEditKits_002 - 15: Delete first Item code");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete.gif");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditKits_002 - 16: Edit Item code");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Items1", itemCode2);
		
		log.info("Step AddEditKits_002 - 17: Edit Quantity");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Quantity1", validDecimal2);
		
		log.info("Step AddEditKits_002 - 18: Edit Unit measure");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Measure1", unitOfMeasure2);
		
		log.info("Step AddEditKits_002 - 19: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditKits_002 - 20: Input new Kits");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_KitNumber", newKits);
		
		log.info("Step AddEditKits_002 - 21: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		////
		
		log.info("Step AddEditKits_002 - VP: Description is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), validText2);
		
		log.info("Step AddEditKits_002 - VP: Item code displayed correctly");
		masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Item0", itemCode2);
		
		log.info("Step AddEditKits_002 - VP: Quantity is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Quantity0"), validDecimal2);
		
		log.info("Step AddEditKits_002 - VP: Unit measure is saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Measure0"), unitOfMeasure2);
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Kits works")
	public void AddEditKits_003_CheckDeactivateKitsWorks() {	
		
		log.info("Step AddEditKits_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditKits_003 - 02: Input correct username and password");
		log.info("Step AddEditKits_003 - 03: Accept Alert message");
		log.info("Step AddEditKits_003 - 04: Open Add labels page");
		log.info("Step AddEditKits_003 - 05: Input new Kits");
		log.info("Step AddEditKits_003 - 06: Click on Add button");
		log.info("Step AddEditKits_003 - 07: Input VendorShortName");
		log.info("Step AddEditKits_003 - 08: Click on Save button");
		log.info("Step AddEditKits_003 - 09: Input new Kits");
		log.info("Step AddEditKits_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditKits_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditKits_003 - 12: Input new Kits");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_KitNumber", newKits);
		
		log.info("Step AddEditKits_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Kits is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Kit Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Kits works")
	public void AddEditKits_004_CheckReactivateKitsWorks() {	
		
		log.info("Step AddEditKits_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditKits_004 - 02: Input correct username and password");
		log.info("Step AddEditKits_004 - 03: Accept Alert message");
		log.info("Step AddEditKits_004 - 04: Open Add labels page");
		log.info("Step AddEditKits_004 - 05: Input new Kits");
		log.info("Step AddEditKits_004 - 06: Click on Add button");
		log.info("Step AddEditKits_004 - 07: Input VendorShortName");
		log.info("Step AddEditKits_004 - 08: Click on Save button");
		log.info("Step AddEditKits_004 - 09: Input new Kits");
		log.info("Step AddEditKits_004 - 10: Click on Deactivate button");
		log.info("Step AddEditKits_004 - 11: Accept alert");
		log.info("Step AddEditKits_004 - 12: Input new Kits");
		log.info("Step AddEditKits_004 - 13: Click on Modify button");
		log.info("Step AddEditKits_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Commodity code by Code works")
	public void AddEditKits_005_SearchKitsByCode() {	
		
		log.info("Step AddEditKits_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditKits_005 - 02: Input correct username and password");
		log.info("Step AddEditKits_005 - 03: Accept Alert message");
		log.info("Step AddEditKits_005 - 04: Open Add labels page");
		log.info("Step AddEditKits_005 - 05: Input new Commodity code");
		log.info("Step AddEditKits_005 - 06: Click on Add button");
		log.info("Step AddEditKits_005 - 07: Input Description");
		log.info("Step AddEditKits_005 - 08: Click on Save button");
		log.info("Step AddEditKits_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_kits.php");
		
		log.info("Step AddEditKits_005 - 10: Input Kits");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Item", newKits);
		
		log.info("Step AddEditKits_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Commodity code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newKits, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Commodity code by Corporation works")
	public void AddEditKits_006_SearchKitsByCorporation() {	
		
		log.info("Step AddEditKits_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditKits_006 - 02: Input correct username and password");
		log.info("Step AddEditKits_006 - 03: Accept Alert message");
		log.info("Step AddEditKits_006 - 04: Open Add labels page");
		log.info("Step AddEditKits_006 - 05: Input new Commodity code");
		log.info("Step AddEditKits_006 - 06: Click on Add button");
		log.info("Step AddEditKits_006 - 07: Input Description");
		log.info("Step AddEditKits_006 - 08: Click on Save button");
		log.info("Step AddEditKits_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_kits.php");
		
		log.info("Step AddEditKits_006 - 10: Input Kits");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Item", newKits);
		
		log.info("Step AddEditKits_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", "HIGHBRIDGE SPRINGS");
		
		log.info("Step AddEditKits_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Commodity code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newKits, "HIGHBRIDGE SPRINGS"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Commodity code by Description works")
	public void AddEditKits_007_SearchKitsByDescription() {	
		
		log.info("Step AddEditKits_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditKits_007 - 02: Input correct username and password");
		log.info("Step AddEditKits_007 - 03: Accept Alert message");
		log.info("Step AddEditKits_007 - 04: Open Add labels page");
		log.info("Step AddEditKits_007 - 05: Input new Commodity code");
		log.info("Step AddEditKits_007 - 06: Click on Add button");
		log.info("Step AddEditKits_007 - 07: Input Description");
		log.info("Step AddEditKits_007 - 08: Click on Save button");
		log.info("Step AddEditKits_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_kits.php");
		
		log.info("Step AddEditKits_007 - 10: Input Kits");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Item", newKits);
		
		log.info("Step AddEditKits_007 - 11: Input Kits description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_KitDesc", validText2);
		
		log.info("Step AddEditKits_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Commodity code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newKits, validText2));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		log.info("Post-condition - 01: Return database to default");
		configPage.selectBranchAndDatabase(Constant.DefaultValue.CURRENT_BRANCH, Constant.DefaultValue.CURRENT_DATABASE);
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private ConfigPage configPage;
	private String newKits;
	private String unitOfMeasure1, unitOfMeasure2;
	private String itemCode1, itemCode2;
	private String validDecimal1, validDecimal2, validText1, validText2;
}
