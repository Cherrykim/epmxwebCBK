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
import page.AddUserPage;
import page.ConfigPage;
import page.LoginPage;

public class MasterFiles_07_AddEditContact extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		configPage = PageFactory.getConfigPage(DriverManager.getDriver(), ipClient);
		
		newContact = getUniqueText(10);
		primaryBuyerID = "110320161";
		primaryBuyerFirstName = "Primary";
		primaryBuyerLastName = "Buyer";
//		primaryUserName = "Primary Buyer";
		primaryUserName = "Alexander Adam";
		primaryUserRole = "Requisitioner";
		primaryBuyerID2 = "110320162";
		primaryBuyerFirstName2 = "Primary2";
		primaryBuyerLastName2 = "Buyer2";
//		primaryUserName2 = "Primary2 Buyer2";
		primaryUserName2 = "Ballweg Cindy";
		primaryUserRole2 = "Requisitioner";
		vendorID1 = "110320161";
		vendorName1 = "Vendor 1";
		vendorID2 = "110320162";
		vendorName2 = "Vendor 2";
		validNumber1 = "111";
		validNumber2 = "222";
		validDecimal1 = "11.11";
		validDecimal2 = "22.22";
		validText1 = "!@#$text";
		validText2 = "%^&*text";
		validStartDate1 = "11-10-2020";
		validStartDate2 = "12-11-2020";
		validEndDate1 = "11-11-2020";
		validEndDate2 = "12-12-2020";
		
		log.info("Pre-condition - 01: Open the site http://tool.cherry.epmxweb.com/");
		log.info("Pre-condition - 02: Select Brand: 'master'");
		log.info("Pre-condition - 03: Choose available MySQL database and get an Username");
		log.info("Pre-condition - 04: Click on Config button and get default Password");
		log.info("Pre-condition - 05: Open the site https://cherry.epmxweb.com");
		configPage.selectBranchAndDatabase(Constant.DefaultValue.CURRENT_BRANCH, Constant.DefaultValue.AAC_DATABASE);
		
		log.info("Pre-condition - 06: Open the site https://cherry.epmxweb.com");
		log.info("Pre-condition - 07: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_AAC, Constant.LoginData.PASSWORD);
		
		log.info("Pre-condition - 08: Accept Alert message");
		loginPage.acceptAlert();
		
//		log.info("Pre-condition - 09: Open Add user page");
//		log.info("Pre-condition - 10: Create new Buyer");
//		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole, "Attic Angel Place");
//		addUserPage.createNewUserWithRole(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", primaryUserRole2, "Attic Angel Place");
		
//		log.info("Pre-condition - 11: Create new Vendor");
//		masterFilesPage.createNewVendor(vendorID1, vendorName1);
//		masterFilesPage.createNewVendor(vendorID2, vendorName2);
	}

	@Test(groups = { "regression" }, description = "Check Add Contact works")
	public void AddContact_001_CheckAddContactWorks() {	
		
		log.info("Step AddContact_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddContact_001 - 02: Input correct username and password");
		log.info("Step AddContact_001 - 03: Accept Alert message");
		log.info("Step AddContact_001 - 04: Open Add Contact page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_contracts.php");

		log.info("Step AddContact_001 - 05: Input new Contact");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_contract_code", newContact);
		
		log.info("Step AddContact_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddContact_001 - 07: Select Vendor");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_vendor_id", vendorName1);
		
		log.info("Step AddContact_001 - 08: Select Owner");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_owner_id", primaryUserName);
		
		log.info("Step AddContact_001 - 09: Select Contact Buyer");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_buyer_id", primaryUserName);
		
		log.info("Step AddContact_001 - 10: Select Contact status");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "str_status", "Active");
		
		log.info("Step AddContact_001 - 11: Add Legal agreement");
		masterFilesPage.addLegalAgreement("datatest1.pdf");
		
		log.info("Step AddContact_001 - 11: Input all other fields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_contract_name", validText1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_contract_number", validNumber1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_start_date", validStartDate1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_end_date", validEndDate1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_user_defined", validText1);
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "str_contract_notes", validText1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "flt_discount_threshold", validNumber1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "flt_disc_contracted_percent", validDecimal1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_expiration_days", validNumber1);
		
		log.info("Step AddContact_001 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddContact_001 - 13: Input new Contact");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_contract_code", newContact);
		
		log.info("Step AddContact_001 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		////
		
		log.info("Step AddContact_001 - VP: Check Legal agreement is added correctly");
		verifyTrue(masterFilesPage.isLegalAgreementAttachmentDisplayed("datatest1.pdf"));
		
		log.info("Step AddContact_001 - VP: Check all dropdown are getSelecteded correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_vendor_id"), vendorName1);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_owner_id"), primaryUserName);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_buyer_id"), primaryUserName);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "str_status"), "Active");
		
		log.info("Step AddContact_001 - VP: Input all other fields");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_contract_name"), validText1);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_contract_number"), validNumber1);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_start_date"), validStartDate1);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_end_date"), validEndDate1);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_user_defined"), validText1);
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "str_contract_notes"), validText1);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "flt_discount_threshold"), validNumber1);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "flt_disc_contracted_percent"), validDecimal1);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "int_expiration_days"), validNumber1);
		
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Contact works")
	public void AddContact_002_CheckEditContactWorks() {	
		
		log.info("Step AddContact_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddContact_002 - 02: Input correct username and password");
		log.info("Step AddContact_002 - 03: Accept Alert message");
		log.info("Step AddContact_002 - 04: Open Add labels page");
		log.info("Step AddContact_002 - 05: Input new Contact");
		log.info("Step AddContact_002 - 06: Click on Add button");
		log.info("Step AddContact_002 - 07: Select all dropdown");
		log.info("Step AddContact_002 - 08: Input all other fields");
		log.info("Step AddContact_002 - 09: Upload Legal agreement");
		log.info("Step AddContact_002 - 10: Click on Save button");
		log.info("Step AddContact_002 - 11: Input new Contact");
		log.info("Step AddContact_002 - 12: Click on Modify button");
		log.info("Step AddContact_002 - 13: Select Vendor");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_vendor_id", vendorName2);
		
		log.info("Step AddContact_002 - 14: Select Owner");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_owner_id", primaryUserName2);
		
		log.info("Step AddContact_002 - 15: Select Contact Buyer");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_buyer_id", primaryUserName2);
		
		log.info("Step AddContact_002 - 16: Select Contact status");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "str_status", "Expired");
		
		log.info("Step AddContact_002 - 17: Add Legal agreement");
		masterFilesPage.addLegalAgreement("datatest2.pdf");
		
		log.info("Step AddContact_002 - 18: Input all other fields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_contract_name", validText2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_contract_number", validNumber2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_start_date", validStartDate2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_end_date", validEndDate2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_user_defined", validText2);
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "str_contract_notes", validText2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "flt_discount_threshold", validNumber2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "flt_disc_contracted_percent", validDecimal2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_expiration_days", validNumber2);
		
		log.info("Step AddContact_002 - 19: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddContact_002 - 20: Input new Contact");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_contract_code", newContact);
		
		log.info("Step AddContact_002 - 21: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		////
		
		log.info("Step AddContact_002 - VP: Check Legal agreement is added correctly");
		verifyTrue(masterFilesPage.isLegalAgreementAttachmentDisplayed("datatest2.pdf"));
		
		log.info("Step AddContact_002 - VP: Check all dropdown are getSelecteded correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_vendor_id"), vendorName2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_owner_id"), primaryUserName2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_buyer_id"), primaryUserName2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "str_status"), "Expired");
		
		log.info("Step AddContact_002 - VP: Input all other fields");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_contract_name"), validText2);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_contract_number"), validNumber2);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_start_date"), validStartDate2);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_end_date"), validEndDate2);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "str_user_defined"), validText2);
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "str_contract_notes"), validText2);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "flt_discount_threshold"), validNumber2);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "flt_disc_contracted_percent"), validDecimal2);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "int_expiration_days"), validNumber2);
	}
	
//	@Test(groups = { "regression" }, description = "Check Deactivate Contact works")
//	public void AddContact_003_CheckDeactivateContactWorks() {	
//		
//		log.info("Step AddContact_003 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddContact_003 - 02: Input correct username and password");
//		log.info("Step AddContact_003 - 03: Accept Alert message");
//		log.info("Step AddContact_003 - 04: Open Add labels page");
//		log.info("Step AddContact_003 - 05: Input new Contact");
//		log.info("Step AddContact_003 - 06: Click on Add button");
//		log.info("Step AddContact_003 - 07: Input Description");
//		log.info("Step AddContact_003 - 08: Click on Save button");
//		log.info("Step AddContact_003 - 09: Input new Contact");
//		log.info("Step AddContact_003 - 10: Click on Deactivate button");
//		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
//		
//		log.info("Step AddContact_003 - 11: Accept alert");
//		masterFilesPage.acceptAlert(DriverManager.getDriver());
//		
//		log.info("Step AddContact_003 - 12: Input new Contact");
//		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_contract_code", newContact);
//		
//		log.info("Step AddContact_003 - 13: Click on Modify button");
//		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
//		
//		log.info("VP: Contact is deactivated correctly");
//		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Contact is deactivated. Press OK to reactivate or Cancel to view record only.");
//	}
//	
//	@Test(groups = { "regression" }, description = "Check REactivate Contact works")
//	public void AddContact_004_CheckReactivateContactWorks() {	
//		
//		log.info("Step AddContact_004 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddContact_004 - 02: Input correct username and password");
//		log.info("Step AddContact_004 - 03: Accept Alert message");
//		log.info("Step AddContact_004 - 04: Open Add labels page");
//		log.info("Step AddContact_004 - 05: Input new Contact");
//		log.info("Step AddContact_004 - 06: Click on Add button");
//		log.info("Step AddContact_004 - 07: Input Description");
//		log.info("Step AddContact_004 - 08: Click on Save button");
//		log.info("Step AddContact_004 - 09: Input new Contact");
//		log.info("Step AddContact_004 - 10: Click on Deactivate button");
//		log.info("Step AddContact_004 - 11: Accept alert");
//		log.info("Step AddContact_004 - 12: Input new Contact");
//		log.info("Step AddContact_004 - 13: Click on Modify button");
//		log.info("Step AddContact_004 - 14: Accept alert");
//		masterFilesPage.acceptAlert(DriverManager.getDriver());
//		
//		log.info("VP: Save button is clickable");
//		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Contact by Code works")
//	public void AddEditContact_005_SearchContactByCode() {	
//		
//		log.info("Step AddEditContact_005 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditContact_005 - 02: Input correct username and password");
//		log.info("Step AddEditContact_005 - 03: Accept Alert message");
//		log.info("Step AddEditContact_005 - 04: Open Add labels page");
//		log.info("Step AddEditContact_005 - 05: Input new Contact");
//		log.info("Step AddEditContact_005 - 06: Click on Add button");
//		log.info("Step AddEditContact_005 - 07: Input Description");
//		log.info("Step AddEditContact_005 - 08: Click on Save button");
//		log.info("Step AddEditContact_005 - 09: Open Manager page");
//		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_commodity_code.php");
//		
//		log.info("Step AddEditContact_005 - 10: Input Contact");
//		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommCode", newContact);
//		
//		log.info("Step AddEditContact_005 - 11: Click on Search button");
//		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Contact displayed correctly");
//		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newContact, ""));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Contact by Corporation works")
//	public void AddEditContact_006_SearchContactByCorporation() {	
//		
//		log.info("Step AddEditContact_006 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditContact_006 - 02: Input correct username and password");
//		log.info("Step AddEditContact_006 - 03: Accept Alert message");
//		log.info("Step AddEditContact_006 - 04: Open Add labels page");
//		log.info("Step AddEditContact_006 - 05: Input new Contact");
//		log.info("Step AddEditContact_006 - 06: Click on Add button");
//		log.info("Step AddEditContact_006 - 07: Input Description");
//		log.info("Step AddEditContact_006 - 08: Click on Save button");
//		log.info("Step AddEditContact_006 - 09: Open Manager page");
//		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_commodity_code.php");
//		
//		log.info("Step AddEditContact_006 - 10: Input Contact");
//		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommCode", newContact);
//		
//		log.info("Step AddEditContact_006 - 11: Select Corporation");
//		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
//		
//		log.info("Step AddEditContact_006 - 12: Click on Search button");
//		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Contact displayed correctly");
//		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newContact, Constant.DefaultValue.CORPORATION));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Contact by Description works")
//	public void AddEditContact_007_SearchContactByDescription() {	
//		
//		log.info("Step AddEditContact_007 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditContact_007 - 02: Input correct username and password");
//		log.info("Step AddEditContact_007 - 03: Accept Alert message");
//		log.info("Step AddEditContact_007 - 04: Open Add labels page");
//		log.info("Step AddEditContact_007 - 05: Input new Contact");
//		log.info("Step AddEditContact_007 - 06: Click on Add button");
//		log.info("Step AddEditContact_007 - 07: Input Description");
//		log.info("Step AddEditContact_007 - 08: Click on Save button");
//		log.info("Step AddEditContact_007 - 09: Open Manager page");
//		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_commodity_code.php");
//		
//		log.info("Step AddEditContact_007 - 10: Input Contact");
//		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommCode", newContact);
//		
//		log.info("Step AddEditContact_007 - 11: Input Contact description");
//		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CommDesc", "new description 2");
//		
//		log.info("Step AddEditContact_007 - 12: Click on Search button");
//		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Contact displayed correctly");
//		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newContact, "new description 2"));
//	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		log.info("Post-condition - 01: Return database to default");
//		configPage.selectBranchAndDatabase(Constant.DefaultValue.CURRENT_BRANCH, Constant.DefaultValue.CURRENT_DATABASE);
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private AddUserPage addUserPage;
	private ConfigPage configPage;
	private String newContact;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, primaryUserRole2, primaryUserName2;
	private String vendorID1, vendorName1;
	private String vendorID2, vendorName2;
	private String validNumber1, validNumber2, validDecimal1, validDecimal2, validText1, validText2, validStartDate1, validStartDate2, validEndDate1, validEndDate2;
}
