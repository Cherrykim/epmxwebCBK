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

public class MasterFiles_29_AddEditVendor extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newVendor = getUniqueText(12);
		termsCode1 = "te1";
		terms1 = termsCode1+ " : "+termsCode1;
		termsCode2 = "te2";
		terms2 = termsCode2+ " : "+termsCode2;
		vendorType1 = "ve1";
		vType1 = vendorType1+ " : "+vendorType1;
		vendorType2 = "ve2";
		vType2 = vendorType2+ " : "+vendorType2;

		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create new Terms code");
		masterFilesPage.createNewTermsCode(termsCode1);
		masterFilesPage.createNewTermsCode(termsCode2);
		
		log.info("Step Pre-condition - 05: Create new Vendor Type");
		masterFilesPage.createNewVendorType(vendorType1);
		masterFilesPage.createNewVendorType(vendorType2);
	}

	@Test(groups = { "regression" }, description = "Check Add Vendor works")
	public void AddEditVendor_001_CheckAddVendorWorks() {	
		
		log.info("Step AddEditVendor_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendor_001 - 02: Input correct username and password");
		log.info("Step AddEditVendor_001 - 03: Accept Alert message");
		log.info("Step AddEditVendor_001 - 04: Open Add Vendor page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_vendors.php");

		log.info("Step AddEditVendor_001 - 05: Input new Vendor");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorCode", newVendor);
		
		log.info("Step AddEditVendor_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditVendor_001 - 07: Input All field");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorName", newVendor);
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_VendorAddress", "Address 1");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "London");
		masterFilesPage.selectRadioButtonByName(DriverManager.getDriver(), "Non US");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_State", "No State");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Country", "UK");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12345");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ZipPlusFour", "1234");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorShortName", newVendor);
		
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FOBPoint", "11");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipVia", "DELIVERED VT");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_VendorType", vType1);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_PrePaidFreight", "Included in Price");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TermCode", terms1);

		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ContactFax", "12345");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PhoneNumber1", "123456789");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Extension1", "123");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PhoneNumber2", "123456780");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Extension2", "321");

		
		log.info("Step AddEditVendor_001 - 08: Add Vendor contact");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "new_vendor_contact_name", "New Vendor 1");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "new_vendor_contact_email", "vendor1@gmail.com");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "new_vendor_contact_phone_number", "123456789");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "new_vendor_contact_phone_ext", "123");
		masterFilesPage.clickButtonByItsText(DriverManager.getDriver(), "Add Contact");
		
		log.info("Step AddEditVendor_001 - 09: Add Vendor contact");
		masterFilesPage.clickOnDivByItsText(DriverManager.getDriver(), "Addl Vendor Info");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxId", newVendor);
		
		log.info("Step AddEditVendor_001 - 10: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditVendor_001 - 11: Input new Vendor");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorCode", newVendor);
		
		log.info("Step AddEditVendor_001 - 12: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All field saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorName"), newVendor);
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_VendorAddress"), "Address 1");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "London");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_State"), "No State");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Country"), "UK");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12345");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ZipPlusFour"), "1234");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorShortName"), newVendor);
		
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_FOBPoint"), "11");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ShipVia"), "DELIVERED VT");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_VendorType"), vType1);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_PrePaidFreight"), "Included in Price");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TermCode"), terms1);

		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ContactFax"), "12345");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_PhoneNumber1"), "123456789");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Extension1"), "123");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_PhoneNumber2"), "123456780");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Extension2"), "321");
		
		log.info("VP: Vendor contact is added");
		verifyEquals(masterFilesPage.getElementTextByClass(DriverManager.getDriver(), "contact_display_name"), "New Vendor 1");
		verifyEquals(masterFilesPage.getElementTextByClass(DriverManager.getDriver(), "contact_display_email"), "vendor1@gmail.com");
		verifyEquals(masterFilesPage.getElementTextByClass(DriverManager.getDriver(), "contact_display_phone"), "123456789 Ext: 123");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Vendor works")
	public void AddEditVendor_002_CheckEdiVendorWorks() {	
		
		log.info("Step AddEditVendor_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendor_002 - 02: Input correct username and password");
		log.info("Step AddEditVendor_002 - 03: Accept Alert message");
		log.info("Step AddEditVendor_002 - 04: Open Add labels page");
		log.info("Step AddEditVendor_002 - 05: Input new Vendor");
		log.info("Step AddEditVendor_002 - 06: Click on Add button");
		log.info("Step AddEditVendor_002 - 07: Input all fields");
		log.info("Step AddEditVendor_002 - 08: Click on Save button");
		log.info("Step AddEditVendor_002 - 09: Input new Vendor");
		log.info("Step AddEditVendor_002 - 10: Click on Modify button");
		log.info("Step AddEditVendor_002 - 11: Input all fields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorName", newVendor+"second");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_VendorAddress", "Address 2");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "Washington");
		masterFilesPage.selectRadioButtonByName(DriverManager.getDriver(), "US");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_State", "Alabama");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12346");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ZipPlusFour", "1235");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorShortName", newVendor+"second");
		
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FOBPoint", "12");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipVia", "FEDEX");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_VendorType", vType2);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_PrePaidFreight", "Pre Paid by Vendor");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TermCode", terms2);

		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ContactFax", "12346");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PhoneNumber1", "123456780");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Extension1", "321");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PhoneNumber2", "123456789");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Extension2", "123");

		
		log.info("Step AddEditVendor_002 - 12: Remove old contact and Add Vendor contact");
		masterFilesPage.clickButtonByItsText(DriverManager.getDriver(), "remove");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "new_vendor_contact_name", "New Vendor 2");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "new_vendor_contact_email", "vendor2@gmail.com");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "new_vendor_contact_phone_number", "123456780");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "new_vendor_contact_phone_ext", "321");
		masterFilesPage.clickButtonByItsText(DriverManager.getDriver(), "Add Contact");
		
		log.info("Step AddEditVendor_002 - 13: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditVendor_002 - 14: Input new Vendor");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorCode", newVendor);
		
		log.info("Step AddEditVendor_002 - 15: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All field saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorName"), newVendor+"second");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_VendorAddress"), "Address 2");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "Washington");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_State"), "Alabama");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12346");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ZipPlusFour"), "1235");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorShortName"), newVendor+"second");
		
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_FOBPoint"), "12");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ShipVia"), "FEDEX");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_VendorType"), vType2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_PrePaidFreight"), "Pre Paid by Vendor");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TermCode"), terms2);

		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ContactFax"), "12346");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_PhoneNumber1"), "123456780");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Extension1"), "321");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_PhoneNumber2"), "123456789");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Extension2"), "123");
		
		log.info("VP: Vendor contact is added");
		verifyEquals(masterFilesPage.getElementTextByClass(DriverManager.getDriver(), "contact_display_name"), "New Vendor 2");
		verifyEquals(masterFilesPage.getElementTextByClass(DriverManager.getDriver(), "contact_display_email"), "vendor2@gmail.com");
		verifyEquals(masterFilesPage.getElementTextByClass(DriverManager.getDriver(), "contact_display_phone"), "123456780 Ext: 321");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Vendor works")
	public void AddEditVendor_003_CheckDeactivateVendorWorks() {	
		
		log.info("Step AddEditVendor_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendor_003 - 02: Input correct username and password");
		log.info("Step AddEditVendor_003 - 03: Accept Alert message");
		log.info("Step AddEditVendor_003 - 04: Open Add labels page");
		log.info("Step AddEditVendor_003 - 05: Input new Vendor");
		log.info("Step AddEditVendor_003 - 06: Click on Add button");
		log.info("Step AddEditVendor_003 - 07: Input all information");
		log.info("Step AddEditVendor_003 - 08: Click on Save button");
		log.info("Step AddEditVendor_003 - 09: Input new Vendor");
		log.info("Step AddEditVendor_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditVendor_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditVendor_003 - 12: Input new Vendor");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorCode", newVendor);
		
		log.info("Step AddEditVendor_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Object Code is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Vendor is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Vendor works")
	public void AddEditVendor_004_CheckReactivateVendorWorks() {	
		
		log.info("Step AddEditVendor_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditVendor_004 - 02: Input correct username and password");
		log.info("Step AddEditVendor_004 - 03: Accept Alert message");
		log.info("Step AddEditVendor_004 - 04: Open Add labels page");
		log.info("Step AddEditVendor_004 - 05: Input new Vendor");
		log.info("Step AddEditVendor_004 - 06: Click on Add button");
		log.info("Step AddEditVendor_004 - 07: Input all information");
		log.info("Step AddEditVendor_004 - 08: Click on Save button");
		log.info("Step AddEditVendor_004 - 09: Input new Vendor");
		log.info("Step AddEditVendor_004 - 10: Click on Deactivate button");
		log.info("Step AddEditVendor_004 - 11: Accept alert");
		log.info("Step AddEditVendor_004 - 12: Input new Vendor");
		log.info("Step AddEditVendor_004 - 13: Click on Modify button");
		log.info("Step AddEditVendor_004 - 14: Accept alert");
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
	private String newVendor;
	private String termsCode1, termsCode2;
	private String vendorType1, vendorType2;
	private String terms1, terms2, vType1, vType2;
}
