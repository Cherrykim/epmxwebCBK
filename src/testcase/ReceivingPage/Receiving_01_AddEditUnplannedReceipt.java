package ReceivingPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.ReceivingPage;
import page.MasterFilesPage;
import page.LoginPage;

public class Receiving_01_AddEditUnplannedReceipt extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		receivingPage = PageFactory.getReceivingPage(DriverManager.getDriver(), ipClient);
		newUnplannedReceipt = getUniqueNumber(7);
		itemCode1 = "item1";
		itemCode2 = "item2";
		unitOfMeasure1 = "um1";
		unitOfMeasure2 = "um2";
		vendorName1 = "vendor"+ getUniqueNumber(7);
		vendorName2= vendorName1+"second";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create Unit of measure");
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure1);
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure2);
		
		log.info("Step Pre-condition - 05: Create Item code");
		masterFilesPage.createNewItemCode(itemCode1);
		masterFilesPage.createNewItemCode(itemCode2);
	}

	@Test(groups = { "regression" }, description = "Check Add Unplanned Receipt works")
	public void AddEditUnplannedReceipt_001_CheckAddUnplannedReceiptWorks() {	
		
		log.info("Step AddEditUnplannedReceipt_001 - 01: Open Add Unplanned Receipt page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/receiving/add_unplanned_receipt.php");

		log.info("Step AddEditUnplannedReceipt_001 - 02: Input new Unplanned Receipt");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RcptNum", newUnplannedReceipt);
		
		log.info("Step AddEditUnplannedReceipt_001 - 03: Click on Add button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditUnplannedReceipt_001 - 04: Input All other textfields");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RcptDate", "11-11-2020");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PackgNum", "11");
		
		log.info("Step AddEditUnplannedReceipt_001 - 05: Add Item to Receipt");
		receivingPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineItem_0", itemCode1);
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Desc_0", "Item 1");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_QtyRcvd_0", "11.0000");
		receivingPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Um_0", unitOfMeasure1);
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendItem_0", "Vendor Item 1");
		
		log.info("Step AddEditUnplannedReceipt_001 - 06: Click on Save button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditUnplannedReceipt_001 - 07: Input new Unplanned Receipt");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RcptNum", newUnplannedReceipt);
		
		log.info("Step AddEditUnplannedReceipt_001 - 08: Click on Modify button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All textfield is saved correctly");
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_Vendor"), vendorName1);
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_RcptDate"), "11-11-2020");
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_PackgNum"), "11");
		
		log.info("VP: Item is added correctly");
		verifyTrue(receivingPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_LineItem0", itemCode1));
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_Desc_0"), "Item 1");
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_QtyRcvd_0"), "11.0000");
		verifyEquals(receivingPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Um_0"), unitOfMeasure1);
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendItem_0"), "Vendor Item 1");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Unplanned Receipt works")
	public void AddEditUnplannedReceipt_002_CheckEditUnplannedReceiptWorks() {	
		
		log.info("Step AddEditUnplannedReceipt_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnplannedReceipt_002 - 02: Input correct username and password");
		log.info("Step AddEditUnplannedReceipt_002 - 03: Accept Alert message");
		log.info("Step AddEditUnplannedReceipt_002 - 04: Open Add labels page");
		log.info("Step AddEditUnplannedReceipt_002 - 05: Input new Unplanned Receipt");
		log.info("Step AddEditUnplannedReceipt_002 - 06: Click on Add button");
		log.info("Step AddEditUnplannedReceipt_002 - 07: Input all other textfields");
		log.info("Step AddEditUnplannedReceipt_002 - 08: Click on Save button");
		log.info("Step AddEditUnplannedReceipt_002 - 09: Input new Unplanned Receipt");
		log.info("Step AddEditUnplannedReceipt_002 - 10: Click on Modify button");
		log.info("Step AddEditUnplannedReceipt_002 - 11: Input All other textfields");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PackgNum", "12");
		
		log.info("Step AddEditUnplannedReceipt_002 - 12: Add Item to Receipt");
		receivingPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineItem_0", itemCode2);
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Desc_0", "Item 2");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_QtyRcvd_0", "12.0000");
		receivingPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Um_0", unitOfMeasure2);
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendItem_0", "Vendor Item 2");
		
		log.info("Step AddEditUnplannedReceipt_002 - 13: Click on Save button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditUnplannedReceipt_002 - 14: Input new Unplanned Receipt");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RcptNum", newUnplannedReceipt);
		
		log.info("Step AddEditUnplannedReceipt_002 - 15: Click on Modify button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All textfield is saved correctly");
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_Vendor"), vendorName2);
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_PackgNum"), "12");
		
		log.info("VP: Item is added correctly");
		verifyTrue(receivingPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_LineItem0", itemCode2));
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_Desc_0"), "Item 2");
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_QtyRcvd_0"), "12.0000");
		verifyEquals(receivingPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Um_0"), unitOfMeasure2);
		verifyEquals(receivingPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendItem_0"), "Vendor Item 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Unplanned Receipt code by Vendor name works")
	public void AddEditUnplannedReceipt_003_SearchUnplannedReceiptByVendorName() {	
		
		log.info("Step AddEditUnplannedReceipt_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnplannedReceipt_003 - 02: Input correct username and password");
		log.info("Step AddEditUnplannedReceipt_003 - 03: Accept Alert message");
		log.info("Step AddEditUnplannedReceipt_003 - 04: Open Add labels page");
		log.info("Step AddEditUnplannedReceipt_003 - 05: Input new Unplanned Receipt code");
		log.info("Step AddEditUnplannedReceipt_003 - 06: Click on Add button");
		log.info("Step AddEditUnplannedReceipt_003 - 07: Input all other textfields");
		log.info("Step AddEditUnplannedReceipt_003 - 08: Click on Save button");
		log.info("Step AddEditUnplannedReceipt_003 - 09: Open Manager page");
		receivingPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/receiving/manage_unplanned_receipt.php");
		
		log.info("Step AddEditUnplannedReceipt_003 - 10: Input Unplanned Receipt Code");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditUnplannedReceipt_003 - 11: Click on Search button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Unplanned Receipt code displayed correctly");
		verifyTrue(receivingPage.isResultTableContainsRecord(DriverManager.getDriver(), newUnplannedReceipt, vendorName2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Unplanned Receipt code by Receiver works")
	public void AddEditUnplannedReceipt_004_SearchUnplannedReceiptByReceiver() {	
		
		log.info("Step AddEditUnplannedReceipt_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnplannedReceipt_004 - 02: Input correct username and password");
		log.info("Step AddEditUnplannedReceipt_004 - 03: Accept Alert message");
		log.info("Step AddEditUnplannedReceipt_004 - 04: Open Add labels page");
		log.info("Step AddEditUnplannedReceipt_004 - 05: Input new Unplanned Receipt code");
		log.info("Step AddEditUnplannedReceipt_004 - 06: Click on Add button");
		log.info("Step AddEditUnplannedReceipt_004 - 07: Input all other textfields");
		log.info("Step AddEditUnplannedReceipt_004 - 08: Click on Save button");
		log.info("Step AddEditUnplannedReceipt_004 - 09: Open Manager page");
		receivingPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/receiving/manage_unplanned_receipt.php");
		
		log.info("Step AddEditUnplannedReceipt_004 - 10: Input Unplanned Receipt Code");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditUnplannedReceipt_004 - 11: Select Receiver");
		receivingPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Rcvr", "Tammi Stock");
		
		log.info("Step AddEditUnplannedReceipt_004 - 12: Click on Search button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Unplanned Receipt code displayed correctly");
		verifyTrue(receivingPage.isResultTableContainsRecord(DriverManager.getDriver(), newUnplannedReceipt, vendorName2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Unplanned Receipt code by Keywords works")
	public void AddEditUnplannedReceipt_005_SearchUnplannedReceiptByKeywords() {	
		
		log.info("Step AddEditUnplannedReceipt_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnplannedReceipt_005 - 02: Input correct username and password");
		log.info("Step AddEditUnplannedReceipt_005 - 03: Accept Alert message");
		log.info("Step AddEditUnplannedReceipt_005 - 04: Open Add labels page");
		log.info("Step AddEditUnplannedReceipt_005 - 05: Input new Unplanned Receipt code");
		log.info("Step AddEditUnplannedReceipt_005 - 06: Click on Add button");
		log.info("Step AddEditUnplannedReceipt_005 - 07: Input all other textfields");
		log.info("Step AddEditUnplannedReceipt_005 - 08: Click on Save button");
		log.info("Step AddEditUnplannedReceipt_005 - 09: Open Manager page");
		receivingPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/receiving/manage_unplanned_receipt.php");
		
		log.info("Step AddEditUnplannedReceipt_005 - 10: Input Unplanned Receipt Code");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditUnplannedReceipt_005 - 11: Input Keyword");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Keyword", "Item 2");
		
		log.info("Step AddEditUnplannedReceipt_005 - 12: Click on Search button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("Step AddEditUnplannedReceipt_005 - 13: Click on OK button");
		receivingPage.clickOnElementByItsValue(DriverManager.getDriver(), "OK");
		
		log.info("VP: Unplanned Receipt code displayed correctly");
		verifyTrue(receivingPage.isResultTableContainsRecord(DriverManager.getDriver(), newUnplannedReceipt, vendorName2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Unplanned Receipt code by Corporation works")
	public void AddEditUnplannedReceipt_006_SearchUnplannedReceiptByCorporation() {	
		
		log.info("Step AddEditUnplannedReceipt_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnplannedReceipt_006 - 02: Input correct username and password");
		log.info("Step AddEditUnplannedReceipt_006 - 03: Accept Alert message");
		log.info("Step AddEditUnplannedReceipt_006 - 04: Open Add labels page");
		log.info("Step AddEditUnplannedReceipt_006 - 05: Input new Unplanned Receipt code");
		log.info("Step AddEditUnplannedReceipt_006 - 06: Click on Add button");
		log.info("Step AddEditUnplannedReceipt_006 - 07: Input all other textfields");
		log.info("Step AddEditUnplannedReceipt_006 - 08: Click on Save button");
		log.info("Step AddEditUnplannedReceipt_006 - 09: Open Manager page");
		receivingPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/receiving/manage_unplanned_receipt.php");
		
		log.info("Step AddEditUnplannedReceipt_006 - 10: Input Unplanned Receipt Code");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditUnplannedReceipt_006 - 11: Select Corporation");
		receivingPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", "Wadsworth Center");
		
		log.info("Step AddEditUnplannedReceipt_006 - 12: Click on Search button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Unplanned Receipt code displayed correctly");
		verifyTrue(receivingPage.isResultTableContainsRecord(DriverManager.getDriver(), newUnplannedReceipt, "Wadsworth Center"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Unplanned Receipt code by Receipt date works")
	public void AddEditUnplannedReceipt_007_SearchUnplannedReceiptByReceiptDate() {	
		
		log.info("Step AddEditUnplannedReceipt_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnplannedReceipt_007 - 02: Input correct username and password");
		log.info("Step AddEditUnplannedReceipt_007 - 03: Accept Alert message");
		log.info("Step AddEditUnplannedReceipt_007 - 04: Open Add labels page");
		log.info("Step AddEditUnplannedReceipt_007 - 05: Input new Unplanned Receipt code");
		log.info("Step AddEditUnplannedReceipt_007 - 06: Click on Add button");
		log.info("Step AddEditUnplannedReceipt_007 - 07: Input all other textfields");
		log.info("Step AddEditUnplannedReceipt_007 - 08: Click on Save button");
		log.info("Step AddEditUnplannedReceipt_007 - 09: Open Manager page");
		receivingPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/receiving/manage_unplanned_receipt.php");
		
		log.info("Step AddEditUnplannedReceipt_007 - 10: Input Unplanned Receipt Code");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditUnplannedReceipt_007 - 11: Input Receipt date");
		receivingPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DateF", "11-11-2020");
		
		log.info("Step AddEditUnplannedReceipt_007 - 12: Click on Search button");
		receivingPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Unplanned Receipt code displayed correctly");
		verifyTrue(receivingPage.isResultTableContainsRecord(DriverManager.getDriver(), newUnplannedReceipt, "11-11-2020"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private ReceivingPage receivingPage;
	private String newUnplannedReceipt;
	private String unitOfMeasure1, unitOfMeasure2;
	private String itemCode1, itemCode2;
	private String vendorName1, vendorName2;
}
