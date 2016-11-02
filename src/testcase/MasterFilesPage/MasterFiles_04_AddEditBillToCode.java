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

public class MasterFiles_04_AddEditBillToCode extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newBillToCode = getUniqueText(7);
	}

	@Test(groups = { "regression" }, description = "Check Add Bill-to code works")
	public void AddEditBillToCode_001_CheckAddBillToCodeWorks() {	
		
		log.info("Step AddEditBillToCode_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBillToCode_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditBillToCode_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditBillToCode_001 - 04: Open Add Bill-to code page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_bill_to_code.php");

		log.info("Step AddEditBillToCode_001 - 05: Input new Bill-to code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BillToCode", newBillToCode);
		
		log.info("Step AddEditBillToCode_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditBillToCode_001 - 07: Input all fields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Company", "Wadworth");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_Address", "141 Baker street");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "London");
		masterFilesPage.selectRadioButtonByName(DriverManager.getDriver(), "Non US");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_State", "No State");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Country", "UK");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12345");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Phone", "123456789");
		
		log.info("Step AddEditBillToCode_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBillToCode_001 - 09: Input new Bill-to code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BillToCode", newBillToCode);
		
		log.info("Step AddEditBillToCode_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Company"), "Wadworth");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_Address").trim(), "141 Baker street");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "London");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_State"), "No State");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12345");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Phone"), "123456789");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Country"), "UK");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Bill-to code works")
	public void AddEditBillToCode_002_CheckAddBillToCodeWorks() {	
		
		log.info("Step AddEditBillToCode_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBillToCode_002 - 02: Input correct username and password");
		log.info("Step AddEditBillToCode_002 - 03: Accept Alert message");
		log.info("Step AddEditBillToCode_002 - 04: Open Add labels page");
		log.info("Step AddEditBillToCode_002 - 05: Input new Bill-to code");
		log.info("Step AddEditBillToCode_002 - 06: Click on Add button");
		log.info("Step AddEditBillToCode_002 - 07: Input Description");
		log.info("Step AddEditBillToCode_002 - 08: Click on Save button");
		log.info("Step AddEditBillToCode_002 - 09: Input new Bill-to code");
		log.info("Step AddEditBillToCode_002 - 10: Click on Modify button");
		log.info("Step AddEditBillToCode_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Company", "Wadworth2");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_Address", "123 Nameless Street");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "Washington");
		masterFilesPage.selectRadioButtonByName(DriverManager.getDriver(), "US");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_State", "Alabama");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12346");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Phone", "123456781");
		
		log.info("Step AddEditBillToCode_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBillToCode_002 - 13: Input new Bill-to code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BillToCode", newBillToCode);
		
		log.info("Step AddEditBillToCode_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All fields are saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Company"), "Wadworth2");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_Address").trim(), "123 Nameless Street");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "Washington");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12346");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Phone"), "123456781");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_State"), "Alabama");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Bill-to code works")
	public void AddEditBillToCode_003_CheckDeactivateBillToCodeWorks() {	
		
		log.info("Step AddEditBillToCode_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBillToCode_003 - 02: Input correct username and password");
		log.info("Step AddEditBillToCode_003 - 03: Accept Alert message");
		log.info("Step AddEditBillToCode_003 - 04: Open Add labels page");
		log.info("Step AddEditBillToCode_003 - 05: Input new Bill-to code");
		log.info("Step AddEditBillToCode_003 - 06: Click on Add button");
		log.info("Step AddEditBillToCode_003 - 07: Input Description");
		log.info("Step AddEditBillToCode_003 - 08: Click on Save button");
		log.info("Step AddEditBillToCode_003 - 09: Input new Bill-to code");
		log.info("Step AddEditBillToCode_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditBillToCode_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBillToCode_003 - 12: Input new Bill-to code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BillToCode", newBillToCode);
		
		log.info("Step AddEditBillToCode_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All fields returned to default");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Bill-To Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Bill-to code works")
	public void AddEditBillToCode_004_CheckReactivateBillToCodeWorks() {	
		
		log.info("Step AddEditBillToCode_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBillToCode_004 - 02: Input correct username and password");
		log.info("Step AddEditBillToCode_004 - 03: Accept Alert message");
		log.info("Step AddEditBillToCode_004 - 04: Open Add labels page");
		log.info("Step AddEditBillToCode_004 - 05: Input new Bill-to code");
		log.info("Step AddEditBillToCode_004 - 06: Click on Add button");
		log.info("Step AddEditBillToCode_004 - 07: Input Description");
		log.info("Step AddEditBillToCode_004 - 08: Click on Save button");
		log.info("Step AddEditBillToCode_004 - 09: Input new Bill-to code");
		log.info("Step AddEditBillToCode_004 - 10: Click on Deactivate button");
		log.info("Step AddEditBillToCode_004 - 11: Accept alert");
		log.info("Step AddEditBillToCode_004 - 12: Input new Bill-to code");
		log.info("Step AddEditBillToCode_004 - 13: Click on Modify button");
		log.info("Step AddEditBillToCode_004 - 14: Accept alert");
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
	private String newBillToCode;
}
