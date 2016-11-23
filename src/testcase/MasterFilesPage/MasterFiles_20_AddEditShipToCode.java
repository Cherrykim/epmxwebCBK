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

public class MasterFiles_20_AddEditShipToCode extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newShipToCode = getUniqueText(7);
		taxCode1 = "tax1";
		taxCode2 = "tax2";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create Tax Code");
		masterFilesPage.createNewTaxCode(taxCode1);
		masterFilesPage.createNewTaxCode(taxCode2);
	}

	@Test(groups = { "regression" }, description = "Check Add Ship-to code works")
	public void AddEditShipToCode_001_CheckAddShipToCodeWorks() {	
		
		log.info("Step AddEditShipToCode_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditShipToCode_001 - 02: Input correct username and password");
		log.info("Step AddEditShipToCode_001 - 03: Accept Alert message");
		log.info("Step AddEditShipToCode_001 - 04: Open Add Ship-to code page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_ship_to_code.php");

		log.info("Step AddEditShipToCode_001 - 05: Input new Ship-to code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipToCode", newShipToCode);
		
		log.info("Step AddEditShipToCode_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditShipToCode_001 - 07: Input all fields");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TaxCode", taxCode1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Company", "Wadworth");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_Address", "141 Baker street");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "London");
		masterFilesPage.selectRadioButtonByName(DriverManager.getDriver(), "Non US");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_State", "No State");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Country", "UK");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12345");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Phone", "123456789");
		
		log.info("Step AddEditShipToCode_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditShipToCode_001 - 09: Input new Ship-to code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipToCode", newShipToCode);
		
		log.info("Step AddEditShipToCode_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TaxCode"), taxCode1);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Company"), "Wadworth");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_Address").trim(), "141 Baker street");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "London");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_State"), "No State");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12345");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Phone"), "123456789");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Country"), "UK");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Ship-to code works")
	public void AddEditShipToCode_002_CheckEdiShipToCodeWorks() {	
		
		log.info("Step AddEditShipToCode_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditShipToCode_002 - 02: Input correct username and password");
		log.info("Step AddEditShipToCode_002 - 03: Accept Alert message");
		log.info("Step AddEditShipToCode_002 - 04: Open Add labels page");
		log.info("Step AddEditShipToCode_002 - 05: Input new Ship-to code");
		log.info("Step AddEditShipToCode_002 - 06: Click on Add button");
		log.info("Step AddEditShipToCode_002 - 07: Input Description");
		log.info("Step AddEditShipToCode_002 - 08: Click on Save button");
		log.info("Step AddEditShipToCode_002 - 09: Input new Ship-to code");
		log.info("Step AddEditShipToCode_002 - 10: Click on Modify button");
		log.info("Step AddEditShipToCode_002 - 11: Input new Description");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TaxCode", taxCode2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Company", "Wadworth2");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_Address", "123 Nameless Street");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "Washington");
		masterFilesPage.selectRadioButtonByName(DriverManager.getDriver(), "US");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_State", "Alabama");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12346");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Phone", "123456781");
		
		log.info("Step AddEditShipToCode_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditShipToCode_002 - 13: Input new Ship-to code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipToCode", newShipToCode);
		
		log.info("Step AddEditShipToCode_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TaxCode"), taxCode2);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Company"), "Wadworth2");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_Address").trim(), "123 Nameless Street");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "Washington");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12346");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Phone"), "123456781");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_State"), "Alabama");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Ship-to code works")
	public void AddEditShipToCode_003_CheckDeactivateShipToCodeWorks() {	
		
		log.info("Step AddEditShipToCode_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditShipToCode_003 - 02: Input correct username and password");
		log.info("Step AddEditShipToCode_003 - 03: Accept Alert message");
		log.info("Step AddEditShipToCode_003 - 04: Open Add labels page");
		log.info("Step AddEditShipToCode_003 - 05: Input new Ship-to code");
		log.info("Step AddEditShipToCode_003 - 06: Click on Add button");
		log.info("Step AddEditShipToCode_003 - 07: Input Description");
		log.info("Step AddEditShipToCode_003 - 08: Click on Save button");
		log.info("Step AddEditShipToCode_003 - 09: Input new Ship-to code");
		log.info("Step AddEditShipToCode_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditShipToCode_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditShipToCode_003 - 12: Input new Ship-to code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipToCode", newShipToCode);
		
		log.info("Step AddEditShipToCode_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Ship-To Code is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Ship-To Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Ship-to code works")
	public void AddEditShipToCode_004_CheckReactivateShipToCodeWorks() {	
		
		log.info("Step AddEditShipToCode_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditShipToCode_004 - 02: Input correct username and password");
		log.info("Step AddEditShipToCode_004 - 03: Accept Alert message");
		log.info("Step AddEditShipToCode_004 - 04: Open Add labels page");
		log.info("Step AddEditShipToCode_004 - 05: Input new Ship-to code");
		log.info("Step AddEditShipToCode_004 - 06: Click on Add button");
		log.info("Step AddEditShipToCode_004 - 07: Input Description");
		log.info("Step AddEditShipToCode_004 - 08: Click on Save button");
		log.info("Step AddEditShipToCode_004 - 09: Input new Ship-to code");
		log.info("Step AddEditShipToCode_004 - 10: Click on Deactivate button");
		log.info("Step AddEditShipToCode_004 - 11: Accept alert");
		log.info("Step AddEditShipToCode_004 - 12: Input new Ship-to code");
		log.info("Step AddEditShipToCode_004 - 13: Click on Modify button");
		log.info("Step AddEditShipToCode_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Ship-to Code code by Code works")
	public void AddEditShipToCode_005_SearchShipToCodeByCode() {	
		
		log.info("Step AddEditShipToCode_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditShipToCode_005 - 02: Input correct username and password");
		log.info("Step AddEditShipToCode_005 - 03: Accept Alert message");
		log.info("Step AddEditShipToCode_005 - 04: Open Add labels page");
		log.info("Step AddEditShipToCode_005 - 05: Input new Ship-to Code code");
		log.info("Step AddEditShipToCode_005 - 06: Click on Add button");
		log.info("Step AddEditShipToCode_005 - 07: Input Description");
		log.info("Step AddEditShipToCode_005 - 08: Click on Save button");
		log.info("Step AddEditShipToCode_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_ship_to_code.php");
		
		log.info("Step AddEditShipToCode_005 - 10: Input Ship-to Code Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipToCode", newShipToCode);
		
		log.info("Step AddEditShipToCode_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Ship-to Code code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newShipToCode, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Ship-to Code code by Corporation works")
	public void AddEditShipToCode_006_SearchShipToCodeByCorporation() {	
		
		log.info("Step AddEditShipToCode_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditShipToCode_006 - 02: Input correct username and password");
		log.info("Step AddEditShipToCode_006 - 03: Accept Alert message");
		log.info("Step AddEditShipToCode_006 - 04: Open Add labels page");
		log.info("Step AddEditShipToCode_006 - 05: Input new Ship-to Code code");
		log.info("Step AddEditShipToCode_006 - 06: Click on Add button");
		log.info("Step AddEditShipToCode_006 - 07: Input Description");
		log.info("Step AddEditShipToCode_006 - 08: Click on Save button");
		log.info("Step AddEditShipToCode_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_ship_to_code.php");
		
		log.info("Step AddEditShipToCode_006 - 10: Input Ship-to Code Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipToCode", newShipToCode);
		
		log.info("Step AddEditShipToCode_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditShipToCode_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Ship-to Code code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newShipToCode, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Ship-to Code code by City works")
	public void AddEditShipToCode_007_SearchShipToCodeByCity() {	
		
		log.info("Step AddEditShipToCode_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditShipToCode_007 - 02: Input correct username and password");
		log.info("Step AddEditShipToCode_007 - 03: Accept Alert message");
		log.info("Step AddEditShipToCode_007 - 04: Open Add labels page");
		log.info("Step AddEditShipToCode_007 - 05: Input new Ship-to Code code");
		log.info("Step AddEditShipToCode_007 - 06: Click on Add button");
		log.info("Step AddEditShipToCode_007 - 07: Input Description");
		log.info("Step AddEditShipToCode_007 - 08: Click on Save button");
		log.info("Step AddEditShipToCode_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_ship_to_code.php");
		
		log.info("Step AddEditShipToCode_007 - 10: Input Ship-to Code Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipToCode", newShipToCode);
		
		log.info("Step AddEditShipToCode_007 - 11: Input Ship-to Code City");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "Washington");
		
		log.info("Step AddEditShipToCode_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Ship-to Code code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newShipToCode, "Washington"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newShipToCode;
	private String taxCode1, taxCode2;
}
