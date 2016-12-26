package InvoicesPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.MasterFilesPage;
import page.POPage;
import page.AddUserPage;
import page.LoginPage;

public class Invoices_02_AddEditInvoiceEntry extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		poPage = PageFactory.getPOPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		
		newVoucherNumber = getUniqueText(6);
		
		vendorID1 = "110320161";
		vendorName1 = "Vendor 1";
		vendorID2 = "110320162";
		vendorName2 = "Vendor 2";
		
		bill1 = "BillCd1";
		billToCode1= bill1 + " : "+ bill1;
		bill2 = "BillCd2";
		billToCode2= bill2 + " : "+ bill2;
		
		ship1 = "ShipCd1";
		shipToCode1= ship1 + " : "+ ship1;
		ship2 = "ShipCd2";
		shipToCode2= ship2 + " : "+ ship2;
		
		po1 = "POType1";
		poType1= po1 + " : "+ po1;
		po2 = "POType2";
		poType2= po2 + " : "+ po2;
		
		job1 = "JobCode1";
		jobCode1= job1 + " : "+ job1;
		job2 = "JobCode2";
		jobCode2= job2 + " : "+ job2;
		
		termsCode1 = "te1";
		terms1 = termsCode1+ " : "+termsCode1;
		termsCode2 = "te2";
		terms2 = termsCode2+ " : "+termsCode2;
		
		text1 = "tx1";
		specialText1= text1 + " : "+ text1;
		text2 = "tx2";
		specialText2= text2 + " : "+ text2;
		
		projectCode1 = "Project1";
		projectCode2 = "Project2";
		
		glAccountCode1 = "glN01";
		glAccountCode2 = "glN02";
		
		taxCode1 = "tax1";
		taxCode2 = "tax2";
		
		primaryBuyerID = "110320161";
		primaryBuyerFirstName = "Primary";
		primaryBuyerLastName = "Buyer";
		primaryUserName = "Primary Buyer";
		primaryUserRole = "Requesters";
		primaryBuyerID2 = "110320162";
		primaryBuyerFirstName2 = "Primary2";
		primaryBuyerLastName2 = "Buyer2";
		primaryUserName2 = "Primary2 Buyer2";
		primaryUserRole2 = "Requesters";
		
		itemCode1 = "item1";
		itemCode2 = "item2";
		
		commodCode1= "comcode1";
		commodity1 = commodCode1+ " : "+commodCode1;
		commodCode2= "comcode2";
		commodity2 = commodCode2+ " : "+commodCode2;
		
		unitOfMeasure1 = "um1";
		um1 = unitOfMeasure1 + " : " +unitOfMeasure1;
		unitOfMeasure2 = "um2";
		um2 = unitOfMeasure2 + " : " +unitOfMeasure2;
		
		batchNumber1 = "batN1";
		batchNumber2 = "batN2";
		
		_1099Code1 = "1099Cod1";
		_1099Code2 = "1099Cod1";
		
		bankCode1 = "te1";
		bank1 = bankCode1+ " : "+bankCode1;
		bankCode2 = "te2";
		bank2 = bankCode2+ " : "+bankCode2;
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
//		log.info("Step Pre-condition - 04: Create new Vendor");
//		masterFilesPage.createNewVendor(vendorID1, vendorName1);
//		masterFilesPage.createNewVendor(vendorID2, vendorName2);
//		
//		log.info("Pre-condition - 05: Create new Buyer");
//		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole);
//		addUserPage.createNewUserWithRole(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", primaryUserRole2);
//		
//		log.info("Step Pre-condition - 05: Create new Bill-to Code");
//		masterFilesPage.createNewBillToCode(bill1);
//		masterFilesPage.createNewBillToCode(bill2);
//		
//		log.info("Step Pre-condition - 05: Create new Ship-to Code");
//		masterFilesPage.createNewShipToCode(ship1);
//		masterFilesPage.createNewShipToCode(ship2);
//		
//		log.info("Step Pre-condition - 05: Create new PO Type");
//		masterFilesPage.createNewPOType(po1);
//		masterFilesPage.createNewPOType(po2);
//		
//		log.info("Step Pre-condition - 04: Create GL Account");
//		masterFilesPage.createNewGLAccount(glAccountCode1);
//		masterFilesPage.assignGLAccount(glAccountCode1, Constant.LoginData.USERNAME_NYDOH);
//		masterFilesPage.createNewGLAccount(glAccountCode2);
//		masterFilesPage.assignGLAccount(glAccountCode2, Constant.LoginData.USERNAME_NYDOH);
//		
//		log.info("Step Pre-condition - 05: Create new Job Code");
//		masterFilesPage.createNewJobCode(job1);
//		masterFilesPage.createNewJobCode(job2);
//		
//		log.info("Step Pre-condition - 05: Create new Project code");
//		masterFilesPage.createNewProjectCode(projectCode1);
//		masterFilesPage.createNewProjectCode(projectCode2);	
//		
//		log.info("Step Pre-condition - 04: Create new Terms code");
//		masterFilesPage.createNewTermsCode(termsCode1);
//		masterFilesPage.createNewTermsCode(termsCode2);
//		
//		log.info("Step Pre-condition - 04: Create Tax Code");
//		masterFilesPage.createNewTaxCode(taxCode1);
//		masterFilesPage.createNewTaxCode(taxCode2);
//		
//		log.info("Step Pre-condition - 04: Create Special text");
//		masterFilesPage.createNewSpecialText(text1);
//		masterFilesPage.createNewSpecialText(text2);
//		
//		log.info("Step Pre-condition - 05: Create Item code");
//		masterFilesPage.createNewItemCode(itemCode1);
//		masterFilesPage.createNewItemCode(itemCode2);
//		
//		log.info("Pre-condition - 06: Create new Vendor");
//		masterFilesPage.createNewVendor(vendorID1, vendorName1);
//		masterFilesPage.createNewVendor(vendorID2, vendorName2);
//		
//		log.info("Pre-condition - 09: Create Unit of measure");
//		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure1);
//		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure2);
//		
//		log.info("Pre-condition - 07: Create new Commodity code");
//		masterFilesPage.createNewCommodityCode(commodCode1);
//		masterFilesPage.createNewCommodityCode(commodCode2);
//		
//		log.info("Pre-condition - 07: Create new Batch number");
//		masterFilesPage.createNewBatchNumber(batchNumber1);
//		masterFilesPage.createNewBatchNumber(batchNumber2);
//		
//		log.info("Pre-condition - 07: Create new 1099 code");
//		masterFilesPage.createNew1099Code(_1099Code1);
//		masterFilesPage.createNew1099Code(_1099Code2);
//		
//		log.info("Step Pre-condition - 04: Create new Terms code");
//		masterFilesPage.createNewBankCode(bankCode1);
//		masterFilesPage.createNewBankCode(bankCode2);
	}

	@Test(groups = { "regression" }, description = "Check Add Invoice Entry works")
	public void AddEditInvoiceEntry_001_CheckAddInvoiceEntryWorks() {	
		
		log.info("Step AddEditInvoiceEntry_001 - 01: Open Add Invoice Entry page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/invoice/invoice_entry.php");

		log.info("Step AddEditInvoiceEntry_001 - 02: Input new Invoice Entry");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VoucherNum", newVoucherNumber);
		
		log.info("Step AddEditInvoiceEntry_001 - 04: Click on Add button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add.gif");
		
		log.info("Step AddEditInvoiceEntry_001 - 05: Select all dropdowns");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BatchNumber", batchNumber1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipCode", shipToCode1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TermsCode", terms1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TaxCode", taxCode1);
		
		log.info("Step AddEditInvoiceEntry_001 - 06: Input all selecter textfield");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_PoNum", projectCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		
		log.info("Step AddEditInvoiceEntry_001 - 07: Input all textfields");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent", "11.00");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscAmt", "11.00");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscDate", "11-11-2020");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_InvoiceNum", "11");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_InvoiceDate", "11-11-2020");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_NetDate", "11-11-2020");
		
		log.info("Step AddEditInvoiceEntry_001 - 18: Input line item");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineItem0", itemCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineGlAccountItem0", glAccountCode1);
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VItem0", vendorName1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNumLineItem0", jobCode1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Um0", unitOfMeasure1);
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Qty0", "11.0000");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_NetAmt0", "11.00");
		poPage.inputTextareaByID(DriverManager.getDriver(), "txt_Desc10", "validtext");
		
		log.info("Step AddEditInvoiceEntry_001 - 08: Open Addl Head info");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btnAddlHeadInfo");
		
		//Input for Addl Header Info tab
		log.info("Step AddEditInvoiceEntry_001 - 18: Open Addl Header Info tab");
		poPage.openTab(DriverManager.getDriver(), "Addl Header Info");
		
		log.info("Step AddEditInvoiceEntry_001 - 05: Select all dropdowns");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_1099Code", _1099Code1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_PaymentType", "Bank Draft");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BankCode", bank1);
		
		log.info("Step AddEditInvoiceEntry_001 - 06: Input all selecter textfield");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AltPayee", vendorName1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_InvAccount", glAccountCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_DiscAccount", glAccountCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_TaxAccount", glAccountCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_FreightAccount", glAccountCode1);
		
		log.info("Step AddEditInvoiceEntry_001 - 07: Input all textfields");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Amt", "11.00");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PrepaidChkNum", "11");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PrepaidChkDate", "11-11-2020");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PaymentDesc", "validtext");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod", "01/2020");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_HoldCode", "11");
		
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PaymentRef", "validtext");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PaymentDate", "11-11-2020");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PaymentAmount", "11");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ChkDesc", "11");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RptPmntStartDate", "11-11-2020");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RptPmntTotalNoOfPmnts", "11");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RptPmntPerYr", "11");
		
		//Input for Attachments tab
		log.info("Step AddEditInvoiceEntry_001 - 18: Add Attachment");
		poPage.addAttachment("datatest1.pdf");
		
		log.info("Step AddEditInvoiceEntry_002 - 11: Click on Save button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "chk_UpType1");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		poPage.sleep(3);
		
		log.info("Step AddEditInvoiceEntry_001 - 02: Input new Invoice Entry");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VoucherNum", newVoucherNumber);
		
		log.info("Step AddEditInvoiceEntry_001 - 14: Click on Modify button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		//Check saved correctly
		
		log.info("Step AddEditInvoiceEntry_001 - VP: All dropdown displayed correctly");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ShipCode"), shipToCode1);
		
		log.info("Step AddEditInvoiceEntry_001 - VP: All textfield is displayed correctly");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_ShipVia"), "FEDEX");
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum", jobCode1));
		
		log.info("Step AddEditInvoiceEntry_001 - 17: Input all textfields");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_ExpDate"), "11-11-2016");
		
		log.info("Step AddEditInvoiceEntry_001 - 18: Open Addl Head info");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_AddlHeadInfo");
		
		
		//Check for Catalogue tab
		log.info("Step AddEditInvoiceEntry_001 - 18: Open Catalog item tab");
		poPage.openTab(DriverManager.getDriver(), "Catalog Items");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "img_Edit0");
		
		log.info("Step AddEditInvoiceEntry_001 - 18: Input all textfields");
		verifyEquals(poPage.getTextareaByID(DriverManager.getDriver(), "txt_LineDesc0"), "validtext");
		
		
		
		log.info("Step AddEditInvoiceEntry_001 - 05: Select all dropdowns");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BatchNumber"), batchNumber1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ShipCode"), shipToCode1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TermsCode"), terms1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TaxCode"), taxCode1);
		
		log.info("Step AddEditInvoiceEntry_001 - 06: Input all selecter textfield");
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_PoNum", projectCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Vendor", vendorName1));
		
		log.info("Step AddEditInvoiceEntry_001 - 07: Input all textfields");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent"), "11.00");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_DiscAmt"), "11.00");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_DiscDate"), "11-11-2020");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_InvoiceNum"), "11");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_InvoiceDate"), "11-11-2020");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_NetDate"), "11-11-2020");
		
		log.info("Step AddEditInvoiceEntry_001 - 18: Input line item");
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "obj_LineItem0", itemCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_LineGlAccountLineItem0", glAccountCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNumLineItem0", jobCode1));
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Um0"), unitOfMeasure1);
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_VItem0"), vendorName1);
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_Qty0"), "11.0000");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_NetAmt0"), "11.00");
		verifyEquals(poPage.getTextareaByID(DriverManager.getDriver(), "txt_Desc10"), "validtext");
		
		log.info("Step AddEditInvoiceEntry_001 - 08: Open Addl Head info");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btnAddlHeadInfo");
		
		//Input for Addl Header Info tab
		log.info("Step AddEditInvoiceEntry_001 - 18: Open Addl Header Info tab");
		poPage.openTab(DriverManager.getDriver(), "Addl Header Info");
		
		log.info("Step AddEditInvoiceEntry_001 - 05: Select all dropdowns");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_1099Code"), _1099Code1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_PaymentType"), "Bank Draft");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BankCode"), bank1);
		
		log.info("Step AddEditInvoiceEntry_001 - 06: Input all selecter textfield");
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AltPayee", vendorName1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_InvAccount", glAccountCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_DiscAccount", glAccountCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_TaxAccount", glAccountCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_FreightAccount", glAccountCode1));
		
		log.info("Step AddEditInvoiceEntry_001 - 07: Input all textfields");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_1099Amt"), "11.00");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_PrepaidChkNum"), "11");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_PrepaidChkDate"), "11-11-2020");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_PaymentDesc"), "validtext");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod"), "01/2020");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_HoldCode"), "11");
		
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_PaymentRef"), "validtext");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_PaymentDate"), "11-11-2020");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_PaymentAmount"), "11");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_ChkDesc"), "11");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_RptPmntStartDate"), "11-11-2020");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_RptPmntTotalNoOfPmnts"), "11");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_RptPmntPerYr"), "11");
		
		//Check for Attachments tab
		log.info("Step AddEditInvoiceEntry_001 - 18: Open Attachments tab");
		verifyTrue(poPage.isAttachmentDisplayed("datatest1.pdf"));
	}
	
//	@Test(groups = { "regression" }, description = "Check Add Invoice Entry works")
//	public void AddEditInvoiceEntry_002_CheckEditInvoiceEntryWorks() {	
//		
//		log.info("Step AddEditInvoiceEntry_002 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_002 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_002 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_002 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_002 - 05: Input new Invoice Entry");
//		log.info("Step AddEditInvoiceEntry_002 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_002 - 07: Input Description");
//		log.info("Step AddEditInvoiceEntry_002 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_002 - 09: Input new Invoice Entry");
//		log.info("Step AddEditInvoiceEntry_002 - 10: Click on Modify button");
//		log.info("Step AddEditInvoiceEntry_002 - 11: Select all dropdowns");
//		log.info("Step AddEditInvoiceEntry_001 - 18: Open CBlk Header Info tab");
//		poPage.openTab(DriverManager.getDriver(), "Blk Header Info");
//		
//		//Check for Attachments tab
//		log.info("Step AddEditInvoiceEntry_001 - 18: Open Attachments tab");
//		verifyTrue(poPage.isAttachmentDisplayed("datatest2.pdf"));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Void Invoice Entry works")
//	public void AddEditInvoiceEntry_003_CheckVoidInvoiceEntryWorks() {	
//		
//		log.info("Step AddEditInvoiceEntry_003 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_003 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_003 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_003 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_003 - 05: Input new Invoice Entry");
//		log.info("Step AddEditInvoiceEntry_003 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_003 - 07: Input Description");
//		log.info("Step AddEditInvoiceEntry_003 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_003 - 09: Input new Invoice Entry");
//		log.info("Step AddEditInvoiceEntry_003 - 10: Click on Void button");
//		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "void.gif");
//		
//		log.info("Step AddEditInvoiceEntry_003 - 11: Accept alert");
//		masterFilesPage.acceptAlert(DriverManager.getDriver());
//		
//		log.info("Step AddEditInvoiceEntry_001 - 01: Open Add Invoice Entry page");
//		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/invoice/invoice_entry.php");
//		
//		log.info("Step AddEditInvoiceEntry_003 - 12: Input new Invoice Entry");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newVoucherNumber);
//		
//		log.info("Step AddEditInvoiceEntry_003 - 13: Input Vendor");
//		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
//		
//		log.info("Step AddEditInvoiceEntry_003 - 14: Click on Modify button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
//		
//		log.info("VP: Invoice Entry is voidd");
//		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "This Blanket P.O. has been voided. Press OK to reactivate or Cancel to view record only.");
//	}
//	
//	@Test(groups = { "regression" }, description = "Check REactivate Invoice Entry works")
//	public void AddEditInvoiceEntry_004_CheckReactivateInvoiceEntryWorks() {	
//		
//		log.info("Step AddEditInvoiceEntry_004 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_004 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_004 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_004 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_004 - 05: Input new Invoice Entry");
//		log.info("Step AddEditInvoiceEntry_004 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_004 - 07: Input Description");
//		log.info("Step AddEditInvoiceEntry_004 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_004 - 09: Input new Invoice Entry");
//		log.info("Step AddEditInvoiceEntry_004 - 10: Click on Void button");
//		log.info("Step AddEditInvoiceEntry_004 - 11: Accept alert");
//		log.info("Step AddEditInvoiceEntry_004 - 12: Input new Invoice Entry");
//		log.info("Step AddEditInvoiceEntry_004 - 13: Click on Modify button");
//		log.info("Step AddEditInvoiceEntry_004 - 14: Accept alert");
//		masterFilesPage.acceptAlert(DriverManager.getDriver());
//		
//		log.info("VP: Save button is clickable");
//		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Invoice Entry date works")
//	public void AddEditInvoiceEntry_005_SearchInvoiceEntryByInvoiceEntryDate() {	
//		
//		log.info("Step AddEditInvoiceEntry_005 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_005 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_005 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_005 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_005 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_005 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_005 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_005 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_005 - 09: Open Manager page");
//		orderDate = poPage.getOrderDate();
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_005 - 10: Input Invoice Entry date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_005 - 11: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, orderDate));
//	}
////	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Buyer works")
//	public void AddEditInvoiceEntry_006_SearchInvoiceEntryByBuyer() {	
//		
//		log.info("Step AddEditInvoiceEntry_006 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_006 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_006 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_006 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_006 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_006 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_006 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_006 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_006 - 09: Open Manager page");
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_006 - 10: Input Invoice Entry Order date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_006 - 11: Select Receiver");
//		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Buyer", "Tammi Stock");
//		
//		log.info("Step AddEditInvoiceEntry_006 - 12: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, ""));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Keywords works")
//	public void AddEditInvoiceEntry_007_SearchInvoiceEntryByKeywords() {	
//		
//		log.info("Step AddEditInvoiceEntry_007 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_007 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_007 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_007 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_007 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_007 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_007 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_007 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_007 - 09: Open Manager page");
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_007 - 10: Input Invoice Entry Order date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_007 - 11: Input Keyword");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Keyword", "validtext");
//		
//		log.info("Step AddEditInvoiceEntry_007 - 12: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("Step AddEditInvoiceEntry_007 - 13: Click on OK button");
//		poPage.clickOnElementByItsValue(DriverManager.getDriver(), "OK");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, ""));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Corporation works")
//	public void AddEditInvoiceEntry_008_SearchInvoiceEntryByCorporation() {	
//		
//		log.info("Step AddEditInvoiceEntry_008 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_008 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_008 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_008 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_008 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_008 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_008 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_008 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_008 - 09: Open Manager page");
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_008 - 10: Input Invoice Entry Order date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_008 - 11: Select Corporation");
//		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", "Wadsworth Center");
//		
//		log.info("Step AddEditInvoiceEntry_008 - 12: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, "Wadsworth Center"));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Job number works")
//	public void AddEditInvoiceEntry_009_SearchInvoiceEntryByJobNumber() {	
//		
//		log.info("Step AddEditInvoiceEntry_009 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_009 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_009 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_009 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_009 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_009 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_009 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_009 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_009 - 09: Open Manager page");
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_009 - 10: Input Invoice Entry Order date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_009 - 11: Input Job number");
//		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Job", jobCode2);
//		
//		log.info("Step AddEditInvoiceEntry_009 - 12: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, ""));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Vendor works")
//	public void AddEditInvoiceEntry_010_SearchInvoiceEntryByVendor() {	
//		
//		log.info("Step AddEditInvoiceEntry_010 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_010 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_010 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_010 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_010 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_010 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_010 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_010 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_010 - 09: Open Manager page");
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_010 - 10: Input Invoice Entry Order date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_010 - 11: Input Vendor name");
//		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Vendor", vendorName1);
//		
//		log.info("Step AddEditInvoiceEntry_010 - 12: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, ""));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Project Code works")
//	public void AddEditInvoiceEntry_011_SearchInvoiceEntryByProjectCode() {	
//		
//		log.info("Step AddEditInvoiceEntry_011 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_011 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_011 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_011 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_011 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_011 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_011 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_011 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_011 - 09: Open Manager page");
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_011 - 10: Input Invoice Entry Order date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_011 - 11: Input Project code");
//		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Proj", projectCode2);
//		
//		log.info("Step AddEditInvoiceEntry_011 - 12: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, ""));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Request date works")
//	public void AddEditInvoiceEntry_012_SearchInvoiceEntryByInvoiceEntryStatus() {	
//		
//		log.info("Step AddEditInvoiceEntry_012 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_012 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_012 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_012 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_012 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_012 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_012 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_012 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_012 - 09: Open Manager page");
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_012 - 10: Input Invoice Entry Order date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_012 - 11: Input Invoice Entry status");
//		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_POStatus", "Open");
//		
//		log.info("Step AddEditInvoiceEntry_012 - 12: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, ""));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Item code works")
//	public void AddEditInvoiceEntry_013_SearchInvoiceEntryByItemCode() {	
//		
//		log.info("Step AddEditInvoiceEntry_013 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_013 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_013 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_013 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_013 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_013 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_013 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_013 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_013 - 09: Open Manager page");
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_013 - 10: Input Invoice Entry Order date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_013 - 11: Input Item code");
//		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Item", itemCode2);
//		
//		log.info("Step AddEditInvoiceEntry_013 - 12: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, ""));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Search Invoice Entry code by Ship-to code works")
//	public void AddEditInvoiceEntry_014_SearchInvoiceEntryByShipToCode() {	
//		
//		log.info("Step AddEditInvoiceEntry_014 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_014 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_014 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_014 - 04: Open Add Invoice Entry page");
//		log.info("Step AddEditInvoiceEntry_014 - 05: Input Invoice Entry date code");
//		log.info("Step AddEditInvoiceEntry_014 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_014 - 07: Input all other textfields");
//		log.info("Step AddEditInvoiceEntry_014 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_014 - 09: Open Manager page");
//		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
//		
//		log.info("Step AddEditInvoiceEntry_014 - 10: Input Invoice Entry Order date");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
//		
//		log.info("Step AddEditInvoiceEntry_014 - 11: Input Ship-to code");
//		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Ship", shipToCode2);
//		
//		log.info("Step AddEditInvoiceEntry_014 - 12: Click on Search button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
//		
//		log.info("VP: Invoice Entry code displayed correctly");
//		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newVoucherNumber, ""));
//	}
//	
//	@Test(groups = { "regression" }, description = "Check Delete Invoice Entry works")
//	public void AddEditInvoiceEntry_015_CheckDeleteInvoiceEntryWorks() {	
//		
//		log.info("Step AddEditInvoiceEntry_015 - 01: Open the site https://cherry.epmxweb.com");
//		log.info("Step AddEditInvoiceEntry_015 - 02: Input correct username and password");
//		log.info("Step AddEditInvoiceEntry_015 - 03: Accept Alert message");
//		log.info("Step AddEditInvoiceEntry_015 - 04: Open Add Invoice Entry page");
//		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/invoice/invoice_entry.php");
//		
//		log.info("Step AddEditInvoiceEntry_015 - 05: Input new Invoice Entry");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newVoucherNumber);
//		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
//		
//		log.info("Step AddEditInvoiceEntry_015 - 06: Click on Add button");
//		log.info("Step AddEditInvoiceEntry_015 - 07: Input Description");
//		log.info("Step AddEditInvoiceEntry_015 - 08: Click on Save button");
//		log.info("Step AddEditInvoiceEntry_015 - 09: Input new Invoice Entry");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
//		
//		log.info("Step AddEditInvoiceEntry_015 - 10: Click on Delete button");
//		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
//		masterFilesPage.acceptAlert(DriverManager.getDriver());
//		
//		log.info("Step AddEditInvoiceEntry_015 - 11: Input new Invoice Entry");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newVoucherNumber);
//		
//		log.info("Step AddEditInvoiceEntry_015 - 12: Input Vendor");
//		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
//		
//		log.info("Step AddEditInvoiceEntry_015 - 13: Click on Modify button");
//		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
//		
//		log.info("VP: Invoice Entry is not displayed");
//		verifyFalse(masterFilesPage.isTextDisplayed(DriverManager.getDriver(), newVoucherNumber));
//	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private POPage poPage;
	private AddUserPage addUserPage;
	private String newVoucherNumber;
	private String bill1, bill2, billToCode1, billToCode2, ship1, ship2, shipToCode1, shipToCode2, vendorID1, vendorName1, vendorID2, vendorName2;
	private String po1, po2, poType1, poType2;
	private String job1, job2, jobCode1, jobCode2;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, primaryUserRole2, primaryUserName2;
	private String glAccountCode1, glAccountCode2;
	private String projectCode1, projectCode2;
	private String terms1, terms2, termsCode1, termsCode2;
	private String taxCode1, taxCode2;
	private String text1, text2, specialText1, specialText2;
	private String itemCode1, itemCode2;
	private String orderDate;
	private String commodCode1, commodCode2, commodity1, commodity2;
	private String unitOfMeasure1, unitOfMeasure2, um1, um2;
	private String batchNumber1, batchNumber2, _1099Code1, _1099Code2;
	private String bank1, bank2, bankCode1, bankCode2;
}
