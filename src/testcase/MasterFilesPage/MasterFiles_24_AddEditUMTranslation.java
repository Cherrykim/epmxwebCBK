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

public class MasterFiles_24_AddEditUMTranslation extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		itemCode = getUniqueText(7);
		unitOfMeasure1 = "um1";
		unitOfMeasure2 = "um2";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create Unit of measure");
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure1);
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure2);
		
		log.info("Step Pre-condition - 05: Create Item code");
		masterFilesPage.createNewItemCode(itemCode);
	}

	@Test(groups = { "regression" }, description = "Check Add UM Translation works")
	public void AddEditUMTranslation_001_CheckAddUMTranslationWorks() {	
		
		log.info("Step AddEditUMTranslation_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUMTranslation_001 - 02: Input correct username and password");
		log.info("Step AddEditUMTranslation_001 - 03: Accept Alert message");
		log.info("Step AddEditUMTranslation_001 - 04: Open Add UM Translation page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_um_translation.php");

		log.info("Step AddEditUMTranslation_001 - 05: Input Item code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Item", itemCode);
		
		log.info("Step AddEditUMTranslation_001 - 06: Select UM from and to");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UmFrom", unitOfMeasure1);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UmTo", unitOfMeasure2);

		
		log.info("Step AddEditUMTranslation_001 - 07: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditUMTranslation_001 - 08: Select Operand and input factor");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Operand", "Add");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Factor", "11.1111");
		
		log.info("Step AddEditUMTranslation_001 - 09: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditUMTranslation_001 - 10: Input Item code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Item", itemCode);
		
		log.info("Step AddEditUMTranslation_001 - 11: Select UM from and to");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UmFrom", unitOfMeasure1);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UmTo", unitOfMeasure2);
		
		log.info("Step AddEditUMTranslation_001 - 12: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Operand"), "Add");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Factor"), "11.1111");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit UM Translation works")
	public void AddEditUMTranslation_002_CheckEdiUMTranslationWorks() {	
		
		log.info("Step AddEditUMTranslation_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUMTranslation_002 - 02: Input correct username and password");
		log.info("Step AddEditUMTranslation_002 - 03: Accept Alert message");
		log.info("Step AddEditUMTranslation_002 - 04: Open Add UM Translation page");
		log.info("Step AddEditUMTranslation_002 - 05: Input Item code");
		log.info("Step AddEditUMTranslation_002 - 06: Select UM from and to");
		log.info("Step AddEditUMTranslation_002 - 07: Click on Add button");
		log.info("Step AddEditUMTranslation_002 - 08: Select Operand and input factor");
		log.info("Step AddEditUMTranslation_002 - 09: Click on Save button");
		log.info("Step AddEditUMTranslation_002 - 10: Input Item code");
		log.info("Step AddEditUMTranslation_002 - 11: Select UM from and to");
		log.info("Step AddEditUMTranslation_002 - 12: Click on Modify button");
		
		log.info("Step AddEditUMTranslation_002 - 13: Select Operand and input factor");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Operand", "Subtract");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Factor", "22.2222");
		
		log.info("Step AddEditUMTranslation_002 - 14: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditUMTranslation_002 - 15: Input Item code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Item", itemCode);
		
		log.info("Step AddEditUMTranslation_002 - 16: Select UM from and to");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UmFrom", unitOfMeasure1);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UmTo", unitOfMeasure2);
		
		log.info("Step AddEditUMTranslation_002 - 17: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Operand"), "Subtract");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Factor"), "22.2222");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate UM Translation works")
	public void AddEditUMTranslation_003_CheckDeactivateUMTranslationWorks() {	
		
		log.info("Step AddEditUMTranslation_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUMTranslation_003 - 02: Input correct username and password");
		log.info("Step AddEditUMTranslation_003 - 03: Accept Alert message");
		log.info("Step AddEditUMTranslation_003 - 04: Open Add UM Translation page");
		log.info("Step AddEditUMTranslation_003 - 05: Input Item code");
		log.info("Step AddEditUMTranslation_003 - 06: Select UM from and to");
		log.info("Step AddEditUMTranslation_003 - 07: Click on Add button");
		log.info("Step AddEditUMTranslation_003 - 08: Select Operand and input factor");
		log.info("Step AddEditUMTranslation_003 - 09: Click on Save button");
		log.info("Step AddEditUMTranslation_003 - 10: Input Item code");
		log.info("Step AddEditUMTranslation_003 - 11: Select UM from and to");
		log.info("Step AddEditUMTranslation_003 - 12: Click on Modify button");
		log.info("Step AddEditUMTranslation_003 - 13: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditUMTranslation_003 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditUMTranslation_003 - 15: Input Item code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Item", itemCode);
		
		log.info("Step AddEditUMTranslation_003 - 16: Select UM from and to");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UmFrom", unitOfMeasure1);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UmTo", unitOfMeasure2);
		
		log.info("Step AddEditUMTranslation_003 - 17: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Ship-To Code is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "U/M Translation is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate UM Translation works")
	public void AddEditUMTranslation_004_CheckReactivateUMTranslationWorks() {	
		
		log.info("Step AddEditUMTranslation_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUMTranslation_004 - 02: Input correct username and password");
		log.info("Step AddEditUMTranslation_004 - 03: Accept Alert message");
		log.info("Step AddEditUMTranslation_004 - 04: Open Add UM Translation page");
		log.info("Step AddEditUMTranslation_004 - 05: Input Item code");
		log.info("Step AddEditUMTranslation_004 - 06: Select UM from and to");
		log.info("Step AddEditUMTranslation_004 - 07: Click on Add button");
		log.info("Step AddEditUMTranslation_004 - 08: Select Operand and input factor");
		log.info("Step AddEditUMTranslation_004 - 09: Click on Save button");
		log.info("Step AddEditUMTranslation_004 - 10: Input Item code");
		log.info("Step AddEditUMTranslation_004 - 11: Select UM from and to");
		log.info("Step AddEditUMTranslation_004 - 12: Click on Modify button");
		log.info("Step AddEditUMTranslation_004 - 13: Click on Deactivate button");
		log.info("Step AddEditUMTranslation_004 - 14: Accept alert");
		log.info("Step AddEditUMTranslation_004 - 15: Input Item code");
		log.info("Step AddEditUMTranslation_004 - 16: Select UM from and to");
		log.info("Step AddEditUMTranslation_004 - 17: Click on Modify button");
		log.info("Step AddEditUMTranslation_004 - 18: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search UM Translation code by Code works")
	public void AddEditUMTranslation_005_SearchUMTranslationByCode() {	
		
		log.info("Step AddEditUMTranslation_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUMTranslation_005 - 02: Input correct username and password");
		log.info("Step AddEditUMTranslation_005 - 03: Accept Alert message");
		log.info("Step AddEditUMTranslation_005 - 04: Open Add UM Translation page");
		log.info("Step AddEditUMTranslation_005 - 05: Input new UM Translation code");
		log.info("Step AddEditUMTranslation_005 - 06: Click on Add button");
		log.info("Step AddEditUMTranslation_005 - 07: Input Description");
		log.info("Step AddEditUMTranslation_005 - 08: Click on Save button");
		log.info("Step AddEditUMTranslation_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_um_translation.php");
		
		log.info("Step AddEditUMTranslation_005 - 10: Input UM Translation Code");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Item", itemCode);
		
		log.info("Step AddEditUMTranslation_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: UM Translation code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), itemCode, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search UM Translation code by Corporation works")
	public void AddEditUMTranslation_006_SearchUMTranslationByCorporation() {	
		
		log.info("Step AddEditUMTranslation_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUMTranslation_006 - 02: Input correct username and password");
		log.info("Step AddEditUMTranslation_006 - 03: Accept Alert message");
		log.info("Step AddEditUMTranslation_006 - 04: Open Add UM Translation page");
		log.info("Step AddEditUMTranslation_006 - 05: Input new UM Translation code");
		log.info("Step AddEditUMTranslation_006 - 06: Click on Add button");
		log.info("Step AddEditUMTranslation_006 - 07: Input Description");
		log.info("Step AddEditUMTranslation_006 - 08: Click on Save button");
		log.info("Step AddEditUMTranslation_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_um_translation.php");
		
		log.info("Step AddEditUMTranslation_006 - 10: Input UM Translation Code");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Item", itemCode);
		
		log.info("Step AddEditUMTranslation_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditUMTranslation_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: UM Translation code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), itemCode, Constant.DefaultValue.CORPORATION));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String itemCode;
	private String unitOfMeasure1, unitOfMeasure2;
}
