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

public class MasterFiles_07_AddEditContract extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		configPage = PageFactory.getConfigPage(DriverManager.getDriver(), ipClient);
		
		newContract = getUniqueText(10);
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
		
		log.info("Pre-condition - 09: Open Add user page");
		log.info("Pre-condition - 10: Create new Buyer");
		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole, "Attic Angel Place");
		addUserPage.createNewUserWithRole(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", primaryUserRole2, "Attic Angel Place");
		
		log.info("Pre-condition - 11: Create new Vendor");
		masterFilesPage.createNewVendor(vendorID1, vendorName1);
		masterFilesPage.createNewVendor(vendorID2, vendorName2);
	}

	@Test(groups = { "regression" }, description = "Check Add Contract works")
	public void AddContract_001_CheckAddContractWorks() {	
		
		log.info("Step AddContract_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddContract_001 - 02: Input correct username and password");
		log.info("Step AddContract_001 - 03: Accept Alert message");
		log.info("Step AddContract_001 - 04: Open Add Contract page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_contracts.php");

		log.info("Step AddContract_001 - 05: Input new Contract");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_contract_code", newContract);
		
		log.info("Step AddContract_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddContract_001 - 07: Select Vendor");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_vendor_id", vendorName1);
		
		log.info("Step AddContract_001 - 08: Select Owner");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_owner_id", primaryUserName);
		
		log.info("Step AddContract_001 - 09: Select Contract Buyer");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_buyer_id", primaryUserName);
		
		log.info("Step AddContract_001 - 10: Select Contract status");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "str_status", "Active");
		
		log.info("Step AddContract_001 - 11: Add Legal agreement");
		masterFilesPage.addLegalAgreement("datatest1.pdf");
		
		log.info("Step AddContract_001 - 12: Input all other fields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_contract_name", validText1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_contract_number", validNumber1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_start_date", validStartDate1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_end_date", validEndDate1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_user_defined", validText1);
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "str_contract_notes", validText1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "flt_discount_threshold", validNumber1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "flt_disc_contracted_percent", validDecimal1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_expiration_days", validNumber1);
		
		log.info("Step AddContract_001 - 13: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddContract_001 - 14: Input new Contract");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_contract_code", newContract);
		
		log.info("Step AddContract_001 - 15: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		////
		
		log.info("Step AddContract_001 - VP: Check Legal agreement is added correctly");
		verifyTrue(masterFilesPage.isLegalAgreementAttachmentDisplayed("datatest1.pdf"));
		
		log.info("Step AddContract_001 - VP: Check all dropdown are getSelecteded correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_vendor_id"), vendorName1);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_owner_id"), primaryUserName);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_buyer_id"), primaryUserName);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "str_status"), "Active");
		
		log.info("Step AddContract_001 - VP: Input all other fields");
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
	
	@Test(groups = { "regression" }, description = "Check Edit Contract works")
	public void AddContract_002_CheckEditContractWorks() {	
		
		log.info("Step AddContract_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddContract_002 - 02: Input correct username and password");
		log.info("Step AddContract_002 - 03: Accept Alert message");
		log.info("Step AddContract_002 - 04: Open Add Contract page");
		log.info("Step AddContract_002 - 05: Input new Contract");
		log.info("Step AddContract_002 - 06: Click on Add button");
		log.info("Step AddContract_002 - 07: Select all dropdown");
		log.info("Step AddContract_002 - 08: Input all other fields");
		log.info("Step AddContract_002 - 09: Upload Legal agreement");
		log.info("Step AddContract_002 - 10: Click on Save button");
		log.info("Step AddContract_002 - 11: Input new Contract");
		log.info("Step AddContract_002 - 12: Click on Modify button");
		log.info("Step AddContract_002 - 13: Select Vendor");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_vendor_id", vendorName2);
		
		log.info("Step AddContract_002 - 14: Select Owner");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_owner_id", primaryUserName2);
		
		log.info("Step AddContract_002 - 15: Select Contract Buyer");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_buyer_id", primaryUserName2);
		
		log.info("Step AddContract_002 - 16: Select Contract status");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "str_status", "Expired");
		
		log.info("Step AddContract_002 - 17: Add Legal agreement");
		masterFilesPage.addLegalAgreement("datatest2.pdf");
		
		log.info("Step AddContract_002 - 18: Input all other fields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_contract_name", validText2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_contract_number", validNumber2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_start_date", validStartDate2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_end_date", validEndDate2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "str_user_defined", validText2);
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "str_contract_notes", validText2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "flt_discount_threshold", validNumber2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "flt_disc_contracted_percent", validDecimal2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_expiration_days", validNumber2);
		
		log.info("Step AddContract_002 - 19: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddContract_002 - 20: Input new Contract");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_contract_code", newContract);
		
		log.info("Step AddContract_002 - 21: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		////
		
		log.info("Step AddContract_002 - VP: Check Legal agreement is added correctly");
		verifyTrue(masterFilesPage.isLegalAgreementAttachmentDisplayed("datatest2.pdf"));
		
		log.info("Step AddContract_002 - VP: Check all dropdown are getSelecteded correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_vendor_id"), vendorName2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_owner_id"), primaryUserName2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "int_buyer_id"), primaryUserName2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "str_status"), "Expired");
		
		log.info("Step AddContract_002 - VP: Input all other fields");
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
	
	@Test(groups = { "regression" }, description = "Check Deactivate Contract works")
	public void AddContract_003_CheckDeactivateContractWorks() {	
		
		log.info("Step AddContract_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddContract_003 - 02: Input correct username and password");
		log.info("Step AddContract_003 - 03: Accept Alert message");
		log.info("Step AddContract_003 - 04: Open Add Contract page");
		log.info("Step AddContract_003 - 05: Input new Contract");
		log.info("Step AddContract_003 - 06: Click on Add button");
		log.info("Step AddContract_003 - 07: Input VendorShortName");
		log.info("Step AddContract_003 - 08: Click on Save button");
		log.info("Step AddContract_003 - 09: Input new Contract");
		log.info("Step AddContract_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddContract_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddContract_003 - 12: Input new Contract");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "int_contract_code", newContract);
		
		log.info("Step AddContract_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Contract is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Contract Code is deactivated. Press OK to reactivate or cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Contract works")
	public void AddContract_004_CheckReactivateContractWorks() {	
		
		log.info("Step AddContract_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddContract_004 - 02: Input correct username and password");
		log.info("Step AddContract_004 - 03: Accept Alert message");
		log.info("Step AddContract_004 - 04: Open Add Contract page");
		log.info("Step AddContract_004 - 05: Input new Contract");
		log.info("Step AddContract_004 - 06: Click on Add button");
		log.info("Step AddContract_004 - 07: Input VendorShortName");
		log.info("Step AddContract_004 - 08: Click on Save button");
		log.info("Step AddContract_004 - 09: Input new Contract");
		log.info("Step AddContract_004 - 10: Click on Deactivate button");
		log.info("Step AddContract_004 - 11: Accept alert");
		log.info("Step AddContract_004 - 12: Input new Contract");
		log.info("Step AddContract_004 - 13: Click on Modify button");
		log.info("Step AddContract_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_save", "class"), "Button nav_menu");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Contract by Code works")
	public void AddEditContract_005_SearchContractByCode() {	
		
		log.info("Step AddEditContract_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditContract_005 - 02: Input correct username and password");
		log.info("Step AddEditContract_005 - 03: Accept Alert message");
		log.info("Step AddEditContract_005 - 04: Open Add Contract page");
		log.info("Step AddEditContract_005 - 05: Input new Contract");
		log.info("Step AddEditContract_005 - 06: Click on Add button");
		log.info("Step AddEditContract_005 - 07: Input VendorShortName");
		log.info("Step AddEditContract_005 - 08: Click on Save button");
		log.info("Step AddEditContract_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/contracts/manage_contracts.php");
		
		log.info("Step AddEditContract_005 - 10: Input Contract");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "clear.gif");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_contract_code", newContract);
		
		log.info("Step AddEditContract_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif", "2");
		
		log.info("VP: Contract displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newContract, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Contract by Corporation works")
	public void AddEditContract_006_SearchContractByCorporation() {	
		
		log.info("Step AddEditContract_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditContract_006 - 02: Input correct username and password");
		log.info("Step AddEditContract_006 - 03: Accept Alert message");
		log.info("Step AddEditContract_006 - 04: Open Add Contract page");
		log.info("Step AddEditContract_006 - 05: Input new Contract");
		log.info("Step AddEditContract_006 - 06: Click on Add button");
		log.info("Step AddEditContract_006 - 07: Input VendorShortName");
		log.info("Step AddEditContract_006 - 08: Click on Save button");
		log.info("Step AddEditContract_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/contracts/manage_contracts.php");
		
		log.info("Step AddEditContract_006 - 10: Input Contract");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "clear.gif");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_contract_code", newContract);
		
		log.info("Step AddEditContract_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "int_corp_id", "Attic Angel Place");
		
		log.info("Step AddEditContract_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif", "2");
		
		log.info("VP: Contract displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newContract, "Attic Angel Place"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Contract by Vendor Short Name works")
	public void AddEditContract_007_SearchContractByVendorShortName() {	
		
		log.info("Step AddEditContract_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditContract_007 - 02: Input correct username and password");
		log.info("Step AddEditContract_007 - 03: Accept Alert message");
		log.info("Step AddEditContract_007 - 04: Open Add Contract page");
		log.info("Step AddEditContract_007 - 05: Input new Contract");
		log.info("Step AddEditContract_007 - 06: Click on Add button");
		log.info("Step AddEditContract_007 - 07: Input Vendor Short Name");
		log.info("Step AddEditContract_007 - 08: Click on Save button");
		log.info("Step AddEditContract_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/contracts/manage_contracts.php");
		
		log.info("Step AddEditContract_007 - 10: Input Contract");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "clear.gif");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_contract_code", newContract);
		
		log.info("Step AddEditContract_007 - 11: Input Vendor short name");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_short_name", vendorName2);
		
		log.info("Step AddEditContract_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif", "2");
		
		log.info("VP: Contract displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newContract, vendorName2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Contract by Contract name works")
	public void AddEditContract_008_SearchContractByContractName() {	
		
		log.info("Step AddEditContract_008 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditContract_008 - 02: Input correct username and password");
		log.info("Step AddEditContract_008 - 03: Accept Alert message");
		log.info("Step AddEditContract_008 - 04: Open Add Contract page");
		log.info("Step AddEditContract_008 - 05: Input new Contract");
		log.info("Step AddEditContract_008 - 06: Click on Add button");
		log.info("Step AddEditContract_008 - 07: Input Vendor Short Name");
		log.info("Step AddEditContract_008 - 08: Click on Save button");
		log.info("Step AddEditContract_008 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/contracts/manage_contracts.php");
		
		log.info("Step AddEditContract_008 - 10: Input Contract");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "clear.gif");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_contract_code", newContract);
		
		log.info("Step AddEditContract_008 - 11: Input Contract name");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_contract_name", validText2);
		
		log.info("Step AddEditContract_008 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif", "2");
		
		log.info("VP: Contract displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newContract, validText2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Contract by Contract number works")
	public void AddEditContract_009_SearchContractByContractNumber() {	
		
		log.info("Step AddEditContract_009 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditContract_009 - 02: Input correct usernumber and password");
		log.info("Step AddEditContract_009 - 03: Accept Alert message");
		log.info("Step AddEditContract_009 - 04: Open Add Contract page");
		log.info("Step AddEditContract_009 - 05: Input new Contract");
		log.info("Step AddEditContract_009 - 06: Click on Add button");
		log.info("Step AddEditContract_009 - 07: Input Vendor Short Number");
		log.info("Step AddEditContract_009 - 08: Click on Save button");
		log.info("Step AddEditContract_009 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/contracts/manage_contracts.php");
		
		log.info("Step AddEditContract_009 - 10: Input Contract");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "clear.gif");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_contract_code", newContract);
		
		log.info("Step AddEditContract_009 - 11: Input Contract number");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_contract_number", validNumber2);
		
		log.info("Step AddEditContract_009 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif", "2");
		
		log.info("VP: Contract displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newContract, validNumber2));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		log.info("Post-condition - 01: Return database to default");
		configPage.selectBranchAndDatabase(Constant.DefaultValue.CURRENT_BRANCH, Constant.DefaultValue.CURRENT_DATABASE);
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private AddUserPage addUserPage;
	private ConfigPage configPage;
	private String newContract;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, primaryUserRole2, primaryUserName2;
	private String vendorID1, vendorName1;
	private String vendorID2, vendorName2;
	private String validNumber1, validNumber2, validDecimal1, validDecimal2, validText1, validText2, validStartDate1, validStartDate2, validEndDate1, validEndDate2;
}
