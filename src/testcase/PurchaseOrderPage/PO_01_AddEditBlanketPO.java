package PurchaseOrderPage;

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

public class PO_01_AddEditBlanketPO extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		poPage = PageFactory.getPOPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		
		newBlanketPO = getUniqueText(7);
		
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
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create new Vendor");
		masterFilesPage.createNewVendor(vendorID1, vendorName1);
		masterFilesPage.createNewVendor(vendorID2, vendorName2);
		
		log.info("Pre-condition - 05: Create new Buyer");
		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole);
		addUserPage.createNewUserWithRole(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", primaryUserRole2);
		
		log.info("Step Pre-condition - 05: Create new Bill-to Code");
		masterFilesPage.createNewBillToCode(bill1);
		masterFilesPage.createNewBillToCode(bill2);
		
		log.info("Step Pre-condition - 05: Create new Ship-to Code");
		masterFilesPage.createNewShipToCode(ship1);
		masterFilesPage.createNewShipToCode(ship2);
		
		log.info("Step Pre-condition - 05: Create new PO Type");
		masterFilesPage.createNewPOType(po1);
		masterFilesPage.createNewPOType(po2);
		
		log.info("Step Pre-condition - 04: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.assignGLAccount(glAccountCode1, Constant.LoginData.USERNAME_NYDOH);
		masterFilesPage.createNewGLAccount(glAccountCode2);
		masterFilesPage.assignGLAccount(glAccountCode2, Constant.LoginData.USERNAME_NYDOH);
		
		log.info("Step Pre-condition - 05: Create new Job Code");
		masterFilesPage.createNewJobCode(job1);
		masterFilesPage.createNewJobCode(job2);
		
		log.info("Step Pre-condition - 05: Create new Project code");
		masterFilesPage.createNewProjectCode(projectCode1);
		masterFilesPage.createNewProjectCode(projectCode2);	
		
		log.info("Step Pre-condition - 04: Create new Terms code");
		masterFilesPage.createNewTermsCode(termsCode1);
		masterFilesPage.createNewTermsCode(termsCode2);
		
		log.info("Step Pre-condition - 04: Create Tax Code");
		masterFilesPage.createNewTaxCode(taxCode1);
		masterFilesPage.createNewTaxCode(taxCode2);
		
		log.info("Step Pre-condition - 04: Create Special text");
		masterFilesPage.createNewSpecialText(text1);
		masterFilesPage.createNewSpecialText(text2);
		
		log.info("Step Pre-condition - 05: Create Item code");
		masterFilesPage.createNewItemCode(itemCode1);
		masterFilesPage.createNewItemCode(itemCode2);
		
		log.info("Pre-condition - 06: Create new Vendor");
		masterFilesPage.createNewVendor(vendorID1, vendorName1);
		masterFilesPage.createNewVendor(vendorID2, vendorName2);
		
		log.info("Pre-condition - 09: Create Unit of measure");
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure1);
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure2);
		
		log.info("Pre-condition - 07: Create new Commodity code");
		masterFilesPage.createNewCommodityCode(commodCode1);
		masterFilesPage.createNewCommodityCode(commodCode2);
	}

	@Test(groups = { "regression" }, description = "Check Add Blanket PO works")
	public void AddEditBlanketPO_001_CheckAddBlanketPOWorks() {	
		
		log.info("Step AddEditBlanketPO_001 - 01: Open Add Blanket PO page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/add_blanket_po.php");

		log.info("Step AddEditBlanketPO_001 - 02: Input new Blanket PO");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newBlanketPO);
		
		log.info("Step AddEditBlanketPO_001 - 03: Input Vendor");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		
		log.info("Step AddEditBlanketPO_001 - 04: Click on Add button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add.gif");
		
		log.info("Step AddEditBlanketPO_001 - 05: Select all dropdowns");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipCode", shipToCode1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BillCode", billToCode1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_PPFreight", "Included in Price");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TermsCode", terms1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_PoType", poType1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TaxCode1", taxCode1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TaxCode2", taxCode2);
		
		log.info("Step AddEditBlanketPO_001 - 06: Input all selecter textfield");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipVia", "FEDEX");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNum", jobCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Project", projectCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode1);
		
		log.info("Step AddEditBlanketPO_001 - 07: Input all textfields");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ExpDate", "11-11-2016");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FOBpt", "Point 1");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorCont", "Vendor 1");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PoChange", "11");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent1", "11.0000");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent2", "11.0000");
		
		log.info("Step AddEditBlanketPO_001 - 08: Open Addl Head info");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btnAddlHeadInfo");
		
		log.info("Step AddEditBlanketPO_001 - 09: Input all Addl head info");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Req", primaryUserName);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Exped", primaryUserName);
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscAmt", "11.00");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_EstFreight", "11.00");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SepHand", "1");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_POCopy", "1");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_NumReleaseCopy", "0");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_MasterAggrNum", "11");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText1", specialText1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText2", specialText1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText3", specialText1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText4", specialText1);
		
		log.info("Step AddEditBlanketPO_001 - 10: Click on Save button");
		poPage.clickOnElementByItsValue(DriverManager.getDriver(), "Save");
		
		//Input for Catalogue tab
		log.info("Step AddEditBlanketPO_001 - 11: Open Catalog item tab");
		poPage.openTab(DriverManager.getDriver(), "Catalog Items");
		
		log.info("Step AddEditBlanketPO_001 - 12: Input all textfields");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Items", itemCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccountLineItem", glAccountCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ProjectLineItem", projectCode1);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNumLineItem", jobCode1);
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Quantity", "10.0000");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Price", "10.0000");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_EAmt", "100.00");
		poPage.inputTextareaByID(DriverManager.getDriver(), "txt_Desc", "validtext");
		
		log.info("Step AddEditBlanketPO_001 - 13: Select all dropdown");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_CommCode", commodity1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Um", um1);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipCodeLineItem", shipToCode1);
		
		log.info("Step AddEditBlanketPO_001 - 14: Click on Add button");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_AddItem");

		//Input for P.O. Instructions tab
		log.info("Step AddEditBlanketPO_001 - 15: Open P.O. Instructions tab");
		poPage.openTab(DriverManager.getDriver(), "P.O. Instructions");
		
		log.info("Step AddEditBlanketPO_001 - 16: Input all textfields");
		poPage.inputTextareaByID(DriverManager.getDriver(), "txt_PoInstructions", "validtext");
		poPage.inputTextareaByID(DriverManager.getDriver(), "txt_PoIntrNotes", "validtext");
		
		//Input for Attachments tab
		log.info("Step AddEditBlanketPO_001 - 17: Add Attachment");
		poPage.addAttachment("datatest1.pdf");
		
		log.info("Step AddEditBlanketPO_002 - 18: Click on Save button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "chk_UpType1");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		poPage.sleep(3);
		
		log.info("Step AddEditBlanketPO_001 - 19: Input new Blanket PO");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newBlanketPO);
		
		log.info("Step AddEditBlanketPO_001 - 20: Input Vendor");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		
		log.info("Step AddEditBlanketPO_001 - 21: Click on Modify button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		//Check saved correctly
		
		log.info("Step AddEditBlanketPO_001 - VP: All dropdown displayed correctly");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ShipCode"), shipToCode1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BillCode"), billToCode1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_PPFreight"), "Included in Price");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TermsCode"), terms1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_PoType"), poType1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TaxCode1"), taxCode1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TaxCode2"), taxCode2);
		
		log.info("Step AddEditBlanketPO_001 - VP: All textfield is displayed correctly");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_ShipVia"), "FEDEX");
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum", jobCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_ProjNum", projectCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode1));
		
		log.info("Step AddEditBlanketPO_001 - 22: Input all textfields");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_ExpDate"), "11-11-2016");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_FOBpt"), "Point 1");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorCont"), "Vendor 1");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_PoChange"), "11");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent1"), "11.0000");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent2"), "11.0000");
		
		log.info("Step AddEditBlanketPO_001 - 23: Open Addl Head info");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_AddlHeadInfo");
		
		log.info("Step AddEditBlanketPO_001 - 24: Input all Addl head info");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Req"), primaryUserName);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Exped"), primaryUserName);
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_DiscAmt"), "11.00");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_EstFreight"), "11.00");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_SepHand"), "1");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_POCopy"), "1");
//		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_NumReleaseCopy"), "0");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_MasterAggrNum"), "11");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText1"), specialText1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText2"), specialText1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText3"), specialText1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText4"), specialText1);
		
		log.info("Step AddEditBlanketPO_001 - 25: Click on Save button");
		poPage.clickOnElementByItsValue(DriverManager.getDriver(), "Save");
		
		//Check for Catalogue tab
		log.info("Step AddEditBlanketPO_001 - 26: Open Catalog item tab");
		poPage.openTab(DriverManager.getDriver(), "Catalog Items");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "img_Edit0");
		
		log.info("Step AddEditBlanketPO_001 - 27: Input all textfields");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineItems0"), itemCode1);
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectlyByScript(DriverManager.getDriver(), "div_LineGlAccountLineItem0", glAccountCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectlyByScript(DriverManager.getDriver(), "div_LineProjectLineItem0", projectCode1));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectlyByScript(DriverManager.getDriver(), "div_LineJobNumLineItem0", jobCode1));
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineQuantity0"), "10.0000");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_LinePrice0"), "10.0000");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineEAmt0"), "100.00");
		verifyEquals(poPage.getTextareaByID(DriverManager.getDriver(), "txt_LineDesc0"), "validtext");
		
		log.info("Step AddEditBlanketPO_001 - 28: Select all dropdown");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineCommCode0"), commodity1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineUm0"), um1);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineShipCodeLineItem0"), shipToCode1);

		//Check for P.O. Instructions tab
		log.info("Step AddEditBlanketPO_001 - 29: Open P.O. Instructions tab");
		poPage.openTab(DriverManager.getDriver(), "P.O. Instructions");
		
		log.info("Step AddEditBlanketPO_001 - 30: Input all textfields");
		verifyEquals(poPage.getTextareaByID(DriverManager.getDriver(), "txt_PoInstructions"), "validtext");
		verifyEquals(poPage.getTextareaByID(DriverManager.getDriver(), "txt_PoIntrNotes"), "validtext");
		
		//Check for Attachments tab
		log.info("Step AddEditBlanketPO_001 - 31: Open Attachments tab");
		verifyTrue(poPage.isAttachmentDisplayed("datatest1.pdf"));
	}
	
	@Test(groups = { "regression" }, description = "Check Add Blanket PO works")
	public void AddEditBlanketPO_002_CheckEditBlanketPOWorks() {	
		
		log.info("Step AddEditBlanketPO_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_002 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_002 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_002 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_002 - 05: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_002 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_002 - 07: Input Description");
		log.info("Step AddEditBlanketPO_002 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_002 - 09: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_002 - 10: Click on Modify button");
		log.info("Step AddEditBlanketPO_002 - 11: Select all dropdowns");
		log.info("Step AddEditBlanketPO_001 - 18: Open CBlk Header Info tab");
		poPage.openTab(DriverManager.getDriver(), "Blk Header Info");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipCode", shipToCode2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BillCode", billToCode2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_PPFreight", "Pre Paid by Vendor");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TermsCode", terms2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_PoType", poType2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TaxCode1", taxCode2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TaxCode2", taxCode1);
		
		log.info("Step AddEditBlanketPO_002 - 08: Input all selecter textfield");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ShipVia", "DELIVERED VT");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNum", jobCode2);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Project", projectCode2);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode2);
		
		log.info("Step AddEditBlanketPO_002 - 09: Input all textfields");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ExpDate", "12-12-2016");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FOBpt", "Point 2");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorCont", "Vendor 2");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PoChange", "12");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent1", "12.0000");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent2", "12.0000");
		
		log.info("Step AddEditBlanketPO_002 - 10: Open Addl Head info");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_AddlHeadInfo");
		
		log.info("Step AddEditBlanketPO_002 - 11: Input all Addl head info");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Req", primaryUserName2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Exped", primaryUserName2);
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscAmt", "12.00");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_EstFreight", "12.00");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SepHand", "2");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_POCopy", "2");
//		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_NumReleaseCopy", "2");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_MasterAggrNum", "12");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText1", specialText2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText2", specialText2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText3", specialText2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText4", specialText2);
		
		log.info("Step AddEditBlanketPO_002 - 12: Click on Save button");
		poPage.clickOnElementByItsValue(DriverManager.getDriver(), "Save");
		
		//Input for Catalogue tab
		log.info("Step AddEditBlanketPO_001 - 13: Open Catalog item tab");
		poPage.openTab(DriverManager.getDriver(), "Catalog Items");
		
		log.info("Step AddEditBlanketPO_001 - 14: Input all textfields");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Items", itemCode2);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccountLineItem", glAccountCode2);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ProjectLineItem", projectCode2);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNumLineItem", jobCode2);
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Quantity", "20.0000");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Price", "20.0000");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_EAmt", "400.00");
		poPage.inputTextareaByID(DriverManager.getDriver(), "txt_Desc", "validtext2");
		
		log.info("Step AddEditBlanketPO_001 - 15: Select all dropdown");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_CommCode", commodity2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Um", um2);
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipCodeLineItem", shipToCode2);
		
		log.info("Step AddEditBlanketPO_001 - 16: Click on Add button");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_AddItem");

		//Input for P.O. Instructions tab
		log.info("Step AddEditBlanketPO_001 - 17: Open P.O. Instructions tab");
		poPage.openTab(DriverManager.getDriver(), "P.O. Instructions");
		
		log.info("Step AddEditBlanketPO_001 - 18: Input all textfields");
		poPage.inputTextareaByID(DriverManager.getDriver(), "txt_PoInstructions", "validtext2");
		poPage.inputTextareaByID(DriverManager.getDriver(), "txt_PoIntrNotes", "validtext2");
		
		//Input for Attachments tab
		log.info("Step AddEditBlanketPO_001 - 19: Open Attachments tab");
		poPage.addAttachment("datatest2.pdf");

		log.info("Step AddEditBlanketPO_002 - 20: Click on Save button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "chk_UpType1");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		poPage.sleep(3);
		
		log.info("Step AddEditBlanketPO_002 - 21: Input new Blanket PO");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newBlanketPO);
		
		log.info("Step AddEditBlanketPO_002 - 22: Input Vendor");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		
		log.info("Step AddEditBlanketPO_002 - 23: Click on Modify button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		//Check saved correctly
		
		log.info("Step AddEditBlanketPO_002 - 24: All dropdowns are displayed correctly");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ShipCode"), shipToCode2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BillCode"), billToCode2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_PPFreight"), "Pre Paid by Vendor");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TermsCode"), terms2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_PoType"), poType2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TaxCode1"), taxCode2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TaxCode2"), taxCode1);
		
		log.info("Step AddEditBlanketPO_002 - 25: All selecter textfields are displayed correctly");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_ShipVia"), "DELIVERED VT");
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum", jobCode2));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_ProjNum", projectCode2));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode2));
		
		log.info("Step AddEditBlanketPO_002 - 26: All textfields are displayed correctly");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_ExpDate"), "12-12-2016");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_FOBpt"), "Point 2");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorCont"), "Vendor 2");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_PoChange"), "12");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent1"), "12.0000");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_TaxPercent2"), "12.0000");
		
		log.info("Step AddEditBlanketPO_002 - 27: Open Addl Head info");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_AddlHeadInfo");
		
		log.info("Step AddEditBlanketPO_002 - 28: All Addl head info displayed correctly");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Req"), primaryUserName2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Exped"), primaryUserName2);
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_DiscAmt"), "12.00");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_EstFreight"), "12.00");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_SepHand"), "2");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_POCopy"), "2");
//		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_NumReleaseCopy"), "2");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_MasterAggrNum"), "12");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText1"), specialText2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText2"), specialText2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText3"), specialText2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText4"), specialText2);
		
		log.info("Step AddEditBlanketPO_001 - 29: Click on Save button");
		poPage.clickOnElementByItsValue(DriverManager.getDriver(), "Save");
		
		//Check for Catalogue tab
		log.info("Step AddEditBlanketPO_001 - 30: Open Catalog item tab");
		poPage.openTab(DriverManager.getDriver(), "Catalog Items");
		poPage.clickOnElementByItsID(DriverManager.getDriver(), "img_Edit1");
		
		log.info("Step AddEditBlanketPO_001 - 31: All catalog textfields displayed correctly");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineItems1"), itemCode2);
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectlyByScript(DriverManager.getDriver(), "div_LineGlAccountLineItem1", glAccountCode2));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectlyByScript(DriverManager.getDriver(), "div_LineProjectLineItem1", projectCode2));
		verifyTrue(poPage.isSuggestionDropdownDisplayedCorrectlyByScript(DriverManager.getDriver(), "div_LineJobNumLineItem1", jobCode2));
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineQuantity1"), "20.0000");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_LinePrice1"), "20.0000");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineEAmt1"), "400.00");
		verifyEquals(poPage.getTextareaByID(DriverManager.getDriver(), "txt_LineDesc1"), "validtext2");
		
		log.info("Step AddEditBlanketPO_001 - 32: Select all dropdown");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineCommCode1"), commodity2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineUm1"), um2);
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineShipCodeLineItem1"), shipToCode2);

		//Check for P.O. Instructions tab
		log.info("Step AddEditBlanketPO_001 - 33: Open P.O. Instructions tab");
		poPage.openTab(DriverManager.getDriver(), "P.O. Instructions");
		
		log.info("Step AddEditBlanketPO_001 - 34: Input all textfields");
		verifyEquals(poPage.getTextareaByID(DriverManager.getDriver(), "txt_PoInstructions"), "validtext2");
		verifyEquals(poPage.getTextareaByID(DriverManager.getDriver(), "txt_PoIntrNotes"), "validtext2");
		
		//Check for Attachments tab
		log.info("Step AddEditBlanketPO_001 - 35: Open Attachments tab");
		verifyTrue(poPage.isAttachmentDisplayed("datatest2.pdf"));
	}
	
	@Test(groups = { "regression" }, description = "Check Void Blanket PO works")
	public void AddEditBlanketPO_003_CheckVoidBlanketPOWorks() {	
		
		log.info("Step AddEditBlanketPO_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_003 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_003 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_003 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_003 - 05: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_003 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_003 - 07: Input Description");
		log.info("Step AddEditBlanketPO_003 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_003 - 09: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_003 - 10: Click on Void button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "void.gif");
		
		log.info("Step AddEditBlanketPO_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBlanketPO_001 - 01: Open Add Blanket PO page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/add_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_003 - 12: Input new Blanket PO");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newBlanketPO);
		
		log.info("Step AddEditBlanketPO_003 - 13: Input Vendor");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		
		log.info("Step AddEditBlanketPO_003 - 14: Click on Modify button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Blanket PO is voidd");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "This Blanket P.O. has been voided. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Blanket PO works")
	public void AddEditBlanketPO_004_CheckReactivateBlanketPOWorks() {	
		
		log.info("Step AddEditBlanketPO_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_004 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_004 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_004 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_004 - 05: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_004 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_004 - 07: Input Description");
		log.info("Step AddEditBlanketPO_004 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_004 - 09: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_004 - 10: Click on Void button");
		log.info("Step AddEditBlanketPO_004 - 11: Accept alert");
		log.info("Step AddEditBlanketPO_004 - 12: Input new Blanket PO");
		log.info("Step AddEditBlanketPO_004 - 13: Click on Modify button");
		log.info("Step AddEditBlanketPO_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Blanket PO date works")
	public void AddEditBlanketPO_005_SearchBlanketPOByBlanketPODate() {	
		
		log.info("Step AddEditBlanketPO_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_005 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_005 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_005 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_005 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_005 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_005 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_005 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_005 - 09: Open Manager page");
		orderDate = poPage.getOrderDate();
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_005 - 10: Input Blanket PO date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_005 - 11: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, orderDate));
	}
//	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Buyer works")
	public void AddEditBlanketPO_006_SearchBlanketPOByBuyer() {	
		
		log.info("Step AddEditBlanketPO_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_006 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_006 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_006 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_006 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_006 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_006 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_006 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_006 - 09: Open Manager page");
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_006 - 10: Input Blanket PO Order date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_006 - 11: Select Receiver");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Buyer", "Tammi Stock");
		
		log.info("Step AddEditBlanketPO_006 - 12: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Keywords works")
	public void AddEditBlanketPO_007_SearchBlanketPOByKeywords() {	
		
		log.info("Step AddEditBlanketPO_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_007 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_007 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_007 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_007 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_007 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_007 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_007 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_007 - 09: Open Manager page");
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_007 - 10: Input Blanket PO Order date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_007 - 11: Input Keyword");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Keyword", "validtext");
		
		log.info("Step AddEditBlanketPO_007 - 12: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("Step AddEditBlanketPO_007 - 13: Click on OK button");
		poPage.clickOnElementByItsValue(DriverManager.getDriver(), "OK");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Corporation works")
	public void AddEditBlanketPO_008_SearchBlanketPOByCorporation() {	
		
		log.info("Step AddEditBlanketPO_008 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_008 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_008 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_008 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_008 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_008 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_008 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_008 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_008 - 09: Open Manager page");
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_008 - 10: Input Blanket PO Order date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_008 - 11: Select Corporation");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", "Wadsworth Center");
		
		log.info("Step AddEditBlanketPO_008 - 12: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, "Wadsworth Center"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Job number works")
	public void AddEditBlanketPO_009_SearchBlanketPOByJobNumber() {	
		
		log.info("Step AddEditBlanketPO_009 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_009 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_009 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_009 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_009 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_009 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_009 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_009 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_009 - 09: Open Manager page");
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_009 - 10: Input Blanket PO Order date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_009 - 11: Input Job number");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Job", jobCode2);
		
		log.info("Step AddEditBlanketPO_009 - 12: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Vendor works")
	public void AddEditBlanketPO_010_SearchBlanketPOByVendor() {	
		
		log.info("Step AddEditBlanketPO_010 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_010 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_010 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_010 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_010 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_010 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_010 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_010 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_010 - 09: Open Manager page");
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_010 - 10: Input Blanket PO Order date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_010 - 11: Input Vendor name");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Vendor", vendorName1);
		
		log.info("Step AddEditBlanketPO_010 - 12: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Project Code works")
	public void AddEditBlanketPO_011_SearchBlanketPOByProjectCode() {	
		
		log.info("Step AddEditBlanketPO_011 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_011 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_011 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_011 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_011 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_011 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_011 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_011 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_011 - 09: Open Manager page");
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_011 - 10: Input Blanket PO Order date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_011 - 11: Input Project code");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Proj", projectCode2);
		
		log.info("Step AddEditBlanketPO_011 - 12: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Request date works")
	public void AddEditBlanketPO_012_SearchBlanketPOByBlanketPOStatus() {	
		
		log.info("Step AddEditBlanketPO_012 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_012 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_012 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_012 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_012 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_012 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_012 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_012 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_012 - 09: Open Manager page");
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_012 - 10: Input Blanket PO Order date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_012 - 11: Input Blanket PO status");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_POStatus", "Open");
		
		log.info("Step AddEditBlanketPO_012 - 12: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Item code works")
	public void AddEditBlanketPO_013_SearchBlanketPOByItemCode() {	
		
		log.info("Step AddEditBlanketPO_013 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_013 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_013 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_013 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_013 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_013 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_013 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_013 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_013 - 09: Open Manager page");
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_013 - 10: Input Blanket PO Order date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_013 - 11: Input Item code");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Item", itemCode2);
		
		log.info("Step AddEditBlanketPO_013 - 12: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Blanket PO code by Ship-to code works")
	public void AddEditBlanketPO_014_SearchBlanketPOByShipToCode() {	
		
		log.info("Step AddEditBlanketPO_014 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_014 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_014 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_014 - 04: Open Add Blanket PO page");
		log.info("Step AddEditBlanketPO_014 - 05: Input Blanket PO date code");
		log.info("Step AddEditBlanketPO_014 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_014 - 07: Input all other textfields");
		log.info("Step AddEditBlanketPO_014 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_014 - 09: Open Manager page");
		poPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/manage_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_014 - 10: Input Blanket PO Order date");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_OrderDateFrom", orderDate);
		
		log.info("Step AddEditBlanketPO_014 - 11: Input Ship-to code");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Ship", shipToCode2);
		
		log.info("Step AddEditBlanketPO_014 - 12: Click on Search button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Blanket PO code displayed correctly");
		verifyTrue(poPage.isResultTableContainsRecord(DriverManager.getDriver(), newBlanketPO, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Delete Blanket PO works")
	public void AddEditBlanketPO_015_CheckDeleteBlanketPOWorks() {	
		
		log.info("Step AddEditBlanketPO_015 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBlanketPO_015 - 02: Input correct username and password");
		log.info("Step AddEditBlanketPO_015 - 03: Accept Alert message");
		log.info("Step AddEditBlanketPO_015 - 04: Open Add Blanket PO page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/po/add_blanket_po.php");
		
		log.info("Step AddEditBlanketPO_015 - 05: Input new Blanket PO");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newBlanketPO);
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		
		log.info("Step AddEditBlanketPO_015 - 06: Click on Add button");
		log.info("Step AddEditBlanketPO_015 - 07: Input Description");
		log.info("Step AddEditBlanketPO_015 - 08: Click on Save button");
		log.info("Step AddEditBlanketPO_015 - 09: Input new Blanket PO");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditBlanketPO_015 - 10: Click on Delete button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBlanketPO_015 - 11: Input new Blanket PO");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONum", newBlanketPO);
		
		log.info("Step AddEditBlanketPO_015 - 12: Input Vendor");
		poPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		
		log.info("Step AddEditBlanketPO_015 - 13: Click on Modify button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Blanket PO is not displayed");
		verifyFalse(masterFilesPage.isTextDisplayed(DriverManager.getDriver(), newBlanketPO));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private POPage poPage;
	private AddUserPage addUserPage;
	private String newBlanketPO;
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
}
