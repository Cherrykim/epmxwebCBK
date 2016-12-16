package RequestForQuotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.RfqPage;
import page.MasterFilesPage;
import page.AddUserPage;
import page.ConfigPage;
import page.LoginPage;

public class RFQ_01_AddEditRfq extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		rfqPage = PageFactory.getRfqPage(DriverManager.getDriver(), ipClient);
		configPage = PageFactory.getConfigPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		newRfq = getUniqueNumber(7);
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
		itemCode1 = "item1";
		itemCode2 = "item2";
		unitOfMeasure1 = "um1";
		unitOfMeasure2 = "um2";
		unitOfMeasureName1= unitOfMeasure1+ " : "+unitOfMeasure1;
		unitOfMeasureName2= unitOfMeasure2+ " : "+unitOfMeasure2;
		vendorID1 = "110320161";
		vendorName1 = "Vendor 1";
		vendorID2 = "110320162";
		vendorName2 = "Vendor 2";
		vendor1 = vendorID1 + " : "+ vendorName1;
		vendor2 = vendorID2 + " : "+ vendorName2;
		
		job1 = "JobCode1";
		jobCode1= job1 + " : "+ job1;
		job2 = "JobCode2";
		jobCode2= job2 + " : "+ job2;
		projectCode1 = "Project1";
		project1 = projectCode1+ " : "+ projectCode1;
		projectCode2 = "Project2";
		project2 = projectCode2+ " : "+ projectCode2;
		glAccountCode1 = "glN01";
		glAccountCode2 = "glN02";
		ship1 = "ShipCd1";
		shipToCode1= ship1 + " : "+ ship1;
		ship2 = "ShipCd2";
		shipToCode2= ship2 + " : "+ ship2;
		text1 = "tx1";
		specialText1= text1 + " : "+ text1;
		text2 = "tx2";
		specialText2= text2 + " : "+ text2;
		primaryBuyerID = "110320163";
		primaryBuyerFirstName = "Primary";
		primaryBuyerLastName = "Buyer";
		primaryUserName = "Primary Buyer";
		primaryUserRole = "Requesters";
		primaryBuyerID2 = "110320162";
		primaryBuyerFirstName2 = "Primary2";
		primaryBuyerLastName2 = "Buyer2";
		primaryUserName2 = "Primary2 Buyer2";
		primaryUserRole2 = "Requesters";
		corporation = "DN Tanks";
		
		log.info("Pre-condition - 01: Open the site http://tool.cherry.epmxweb.com/");
		log.info("Pre-condition - 02: Select Brand: 'master'");
		log.info("Pre-condition - 03: Choose available MySQL database and get an Username");
		log.info("Pre-condition - 04: Click on Config button and get default Password");
		log.info("Pre-condition - 05: Open the site https://cherry.epmxweb.com");
		configPage.selectBranchAndDatabase(Constant.DefaultValue.CURRENT_BRANCH, Constant.DefaultValue.NG_DATABASE);
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NG, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
//		log.info("Step Pre-condition - 04: Create Unit of measure");
//		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure1);
//		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure2);
//		
//		log.info("Step Pre-condition - 05: Create Item code");
//		masterFilesPage.createNewItemCodeWithCorp(itemCode1, corporation);
//		masterFilesPage.createNewItemCodeWithCorp(itemCode2, corporation);
//		
//		log.info("Step Pre-condition - 06: Create new Job code");
//		masterFilesPage.createNewJobCode(job1, corporation);
//		masterFilesPage.createNewJobCode(job2, corporation);
//		
//		log.info("Step Pre-condition - 07: Create GL Account");
//		masterFilesPage.createNewGLAccountWithCorp(glAccountCode1, corporation);
//		masterFilesPage.createNewGLAccountWithCorp(glAccountCode2, corporation);
//		
//		log.info("Step Pre-condition - 08: Create new Project code");
//		masterFilesPage.createNewProjectCode(projectCode1, corporation);
//		masterFilesPage.createNewProjectCode(projectCode2, corporation);	
//		
//		log.info("Step Pre-condition - 09: Create new Ship-to Code");
//		masterFilesPage.createNewShipToCode(ship1, corporation);
//		masterFilesPage.createNewShipToCode(ship2, corporation);
//		
//		log.info("Step Pre-condition - 10: Create new Vendor");
//		masterFilesPage.createNewVendor(vendorID1, vendorName1, corporation);
//		masterFilesPage.createNewVendor(vendorID2, vendorName2, corporation);
//		
//		log.info("Step Pre-condition - 04: Create Special text");
//		masterFilesPage.createNewSpecialText(text1, corporation);
//		masterFilesPage.createNewSpecialText(text2, corporation);
//		
//		log.info("Pre-condition - 05: Create new Buyer");
//		addUserPage.createNewUser(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", corporation);
//		addUserPage.createNewUser(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", corporation);
	}

	@Test(groups = { "regression" }, description = "Check Add Rfq works")
	public void AddEditRfq_001_CheckAddRfqWorks() {	
		
		log.info("Step AddEditRfq_001 - 01: Open Add Rfq page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfq/add_request_for_quotation.php");

		log.info("Step AddEditRfq_001 - 02: Select corporation");
		rfqPage.sleep(3);
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RFQNum", newRfq);
		
		log.info("Step AddEditRfq_001 - 03: Click on Add button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditRfq_001 - 04: Input All other textfields");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Replydate", validStartDate1);
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DelDate", validEndDate1);
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FOBpt", validNumber1);
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ShipVia", "BEST  METHOD");
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNum", jobCode1);
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAcc", glAccountCode1);
		
		log.info("Step AddEditRfq_001 - 05: Select all other textfield");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipCode", shipToCode1);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_PPFreight", "Included in Price");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Buyer", primaryUserName);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Req", primaryUserName);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Project", project1);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText1", specialText1);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText2", specialText1);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText3", specialText1);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText4", specialText1);
		
		log.info("Step AddEditRfq_001 - 06: Add Line Item to Rfq");
		rfqPage.openTab(DriverManager.getDriver(), "Line Item Info");
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineItem0", itemCode1);
		rfqPage.inputTextareaByID(DriverManager.getDriver(), "txt_LineDesc10", "Item 1");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LineQty0", "11.0000");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_LineUm0", unitOfMeasureName1);
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LineRequiredDelivery0", validStartDate1);
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineJobNum0", jobCode1);
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineGlAccount0", glAccountCode1);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_LineSpecialText0", specialText1);

		log.info("Step AddEditRfq_001 - 07: Add Attachment");
		rfqPage.addAttachment("datatest1.pdf");
		
		log.info("Step AddEditRfq_001 - 08: Add Vendor");
		rfqPage.openTab(DriverManager.getDriver(), "RFQ Vendors");
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Vendor", vendor1);
		rfqPage.clickOnElementByItsValue(DriverManager.getDriver(), "Add To Vendors List");
		
		log.info("Step AddEditRfq_001 - 09: Input Instructions");
		rfqPage.openTab(DriverManager.getDriver(), "RFQ Instructions");
		rfqPage.inputTextareaByID(DriverManager.getDriver(), "txt_rfqInstructions", validText1);
		rfqPage.inputTextareaByID(DriverManager.getDriver(), "txt_rfqNotes", validText1);
		
		log.info("Step AddEditRfq_001 - 10: Click on Save button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		rfqPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		
		log.info("Step AddEditRfq_001 - 11: Select corporation");
		rfqPage.sleep(3);
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RFQNum", newRfq);
		
		log.info("Step AddEditRfq_001 - 12: Click on Modify button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditRfq_001 - VP: Check All other textfields saved correctly");
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_Replydate"), validStartDate1);
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_DelDate"), validEndDate1);
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_FOBpt"), validNumber1);
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_ShipVia"), "BEST  METHOD");
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum", jobCode1));
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode1));
		
		log.info("Step AddEditRfq_001 - 05: Check All other dropdown saved correctly");
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ShipCode"), shipToCode1);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_PPFreight"), "Included in Price");
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Buyer"), primaryUserName);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Req"), primaryUserName);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Project"), project1);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText1"), specialText1);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText2"), specialText1);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText3"), specialText1);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText4"), specialText1);
		
		log.info("Step AddEditRfq_001 - 05: Check Line Item displayed correctly");
		rfqPage.openTab(DriverManager.getDriver(), "Line Item Info");
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "obj_LineItem0", itemCode1));
		verifyEquals(rfqPage.getTextareaByID(DriverManager.getDriver(), "txt_LineDesc10"), "Item 1");
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineQuantity0"), "11.0000");
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineUm0"), unitOfMeasureName1);
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineDelDateLineItem0"), validStartDate1);
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum0", jobCode1));
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAcc0", glAccountCode1));
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineSpecialTextLineItem0"), specialText1);

		log.info("Step AddEditRfq_001 - 05: Check Attachment displayed correctly");
		verifyTrue(rfqPage.isAttachmentDisplayed("datatest1.pdf"));
		
		log.info("Step AddEditRfq_001 - 05: Check Vendor displayed correctly");
		rfqPage.openTab(DriverManager.getDriver(), "RFQ Vendors");
		verifyTrue(rfqPage.isVendorRecordDisplayed(vendorID1, vendorName1));
		
		log.info("Step AddEditRfq_001 - 05: Check Instructions saved correctly");
		rfqPage.openTab(DriverManager.getDriver(), "RFQ Instructions");
		verifyEquals(rfqPage.getTextareaByID(DriverManager.getDriver(), "txt_rfqInstructions"), validText1);
		verifyEquals(rfqPage.getTextareaByID(DriverManager.getDriver(), "txt_rfqNotes"), validText1);
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Rfq works")
	public void AddEditRfq_002_CheckEditRfqWorks() {	
		
		log.info("Step AddEditRfq_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_002 - 02: Input correct username and password");
		log.info("Step AddEditRfq_002 - 03: Accept Alert message");
		log.info("Step AddEditRfq_002 - 04: Open Add labels page");
		log.info("Step AddEditRfq_002 - 05: Input new Rfq");
		log.info("Step AddEditRfq_002 - 06: Click on Add button");
		log.info("Step AddEditRfq_002 - 07: Input all other textfields");
		log.info("Step AddEditRfq_002 - 08: Click on Save button");
		log.info("Step AddEditRfq_002 - 09: Input new Rfq");
		log.info("Step AddEditRfq_002 - 10: Click on Modify button");
		log.info("Step AddEditRfq_002 - 11: Edit All other textfields");
		rfqPage.openTab(DriverManager.getDriver(), "Header Info");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Replydate", validStartDate2);
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DelDate", validEndDate2);
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FOBpt", validNumber2);
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ShipVia", "BEST FASTEST WAY");
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNum", jobCode2);
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAcc", glAccountCode2);
		
		log.info("Step AddEditRfq_001 - 05: Select all other textfield");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipCode", shipToCode2);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_PPFreight", "Pre Paid by Vendor");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Buyer", primaryUserName2);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Req", primaryUserName2);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Project", project2);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText1", specialText2);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText2", specialText2);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText3", specialText2);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_SpecialText4", specialText2);
		
		log.info("Step AddEditRfq_001 - 06: Add Line Item to Rfq");
		rfqPage.openTab(DriverManager.getDriver(), "Line Item Info");
		rfqPage.clickOnElementByItsID(DriverManager.getDriver(), "img_DelLine0");
		rfqPage.acceptAlert(DriverManager.getDriver());
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineItem1", itemCode2);
		rfqPage.inputTextareaByID(DriverManager.getDriver(), "txt_LineDesc11", "Item 2");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LineQuantity1", "22.2222");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_LineUm1", unitOfMeasureName2);
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LineDelDateLineItem1", validStartDate2);
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineJobNumLineItem1", jobCode2);
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineGlAccount1", glAccountCode2);
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_LineSpecialTextLineItem1", specialText2);

		log.info("Step AddEditRfq_001 - 07: Add Attachment");
		rfqPage.addAttachment("datatest2.pdf");
		
		log.info("Step AddEditRfq_001 - 08: Add Vendor");
		rfqPage.openTab(DriverManager.getDriver(), "RFQ Vendors");
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Vendor", vendor2);
		rfqPage.clickOnElementByItsValue(DriverManager.getDriver(), "Add To Vendors List");
		
		log.info("Step AddEditRfq_001 - 09: Input Instructions");
		rfqPage.openTab(DriverManager.getDriver(), "RFQ Instructions");
		rfqPage.inputTextareaByID(DriverManager.getDriver(), "txt_rfqInstructions", validText2);
		rfqPage.inputTextareaByID(DriverManager.getDriver(), "txt_rfqNotes", validText2);
		
		log.info("Step AddEditRfq_001 - 10: Click on Save button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		rfqPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		
		log.info("Step AddEditRfq_001 - 11: Select corporation");
		rfqPage.sleep(3);
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RFQNum", newRfq);
		
		log.info("Step AddEditRfq_001 - 12: Click on Modify button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditRfq_001 - VP: Check All other textfields saved correctly");
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_Replydate"), validStartDate2);
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_DelDate"), validEndDate2);
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_FOBpt"), validNumber2);
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_ShipVia"), "BEST FASTEST WAY");
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum", jobCode2));
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode2));
		
		log.info("Step AddEditRfq_001 - 05: Check All other dropdown saved correctly");
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ShipCode"), shipToCode2);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_PPFreight"), "Pre Paid by Vendor");
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Buyer"), primaryUserName2);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Req"), primaryUserName2);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Project"), project2);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText1"), specialText2);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText2"), specialText2);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText3"), specialText2);
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_SpecialText4"), specialText2);
		
		log.info("Step AddEditRfq_001 - 05: Check Line Item displayed correctly");
		rfqPage.openTab(DriverManager.getDriver(), "Line Item Info");
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "obj_LineItem0", itemCode2));
		verifyEquals(rfqPage.getTextareaByID(DriverManager.getDriver(), "txt_LineDesc10"), "Item 2");
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineQuantity0"), "22.2222");
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineUm0"), unitOfMeasureName2);
		verifyEquals(rfqPage.getTextfieldByID(DriverManager.getDriver(), "txt_LineDelDateLineItem0"), validStartDate2);
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum0", jobCode2));
		verifyTrue(rfqPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAcc0", glAccountCode2));
		verifyEquals(rfqPage.getSelectedItemByID(DriverManager.getDriver(), "sel_LineSpecialTextLineItem0"), specialText2);

		log.info("Step AddEditRfq_001 - 05: Check Attachment displayed correctly");
		verifyTrue(rfqPage.isAttachmentDisplayed("datatest2.pdf"));
		
		log.info("Step AddEditRfq_001 - 05: Check Vendor displayed correctly");
		rfqPage.openTab(DriverManager.getDriver(), "RFQ Vendors");
		verifyTrue(rfqPage.isVendorRecordDisplayed(vendorID2, vendorName2));
		
		log.info("Step AddEditRfq_001 - 05: Check Instructions saved correctly");
		rfqPage.openTab(DriverManager.getDriver(), "RFQ Instructions");
		verifyEquals(rfqPage.getTextareaByID(DriverManager.getDriver(), "txt_rfqInstructions"), validText2);
		verifyEquals(rfqPage.getTextareaByID(DriverManager.getDriver(), "txt_rfqNotes"), validText2);
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Rfq name works")
	public void AddEditRfq_003_SearchRfqByRfqNumber() {	
		
		log.info("Step AddEditRfq_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_003 - 02: Input correct username and password");
		log.info("Step AddEditRfq_003 - 03: Accept Alert message");
		log.info("Step AddEditRfq_003 - 04: Open Add labels page");
		log.info("Step AddEditRfq_003 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_003 - 06: Click on Add button");
		log.info("Step AddEditRfq_003 - 07: Input all other textfields");
		log.info("Step AddEditRfq_003 - 08: Click on Save button");
		log.info("Step AddEditRfq_003 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_003 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_003 - 11: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Buyer works")
	public void AddEditRfq_004_SearchRfqByBuyer() {	
		
		log.info("Step AddEditRfq_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_004 - 02: Input correct username and password");
		log.info("Step AddEditRfq_004 - 03: Accept Alert message");
		log.info("Step AddEditRfq_004 - 04: Open Add labels page");
		log.info("Step AddEditRfq_004 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_004 - 06: Click on Add button");
		log.info("Step AddEditRfq_004 - 07: Input all other textfields");
		log.info("Step AddEditRfq_004 - 08: Click on Save button");
		log.info("Step AddEditRfq_004 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_004 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_004 - 11: Select Receiver");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Buyer", "Tammi Stock");
		
		log.info("Step AddEditRfq_004 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Keywords works")
	public void AddEditRfq_005_SearchRfqByKeywords() {	
		
		log.info("Step AddEditRfq_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_005 - 02: Input correct username and password");
		log.info("Step AddEditRfq_005 - 03: Accept Alert message");
		log.info("Step AddEditRfq_005 - 04: Open Add labels page");
		log.info("Step AddEditRfq_005 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_005 - 06: Click on Add button");
		log.info("Step AddEditRfq_005 - 07: Input all other textfields");
		log.info("Step AddEditRfq_005 - 08: Click on Save button");
		log.info("Step AddEditRfq_005 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_005 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_005 - 11: Input Keyword");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Keyword", "Item 2");
		
		log.info("Step AddEditRfq_005 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("Step AddEditRfq_005 - 13: Click on OK button");
		rfqPage.clickOnElementByItsValue(DriverManager.getDriver(), "OK");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Corporation works")
	public void AddEditRfq_006_SearchRfqByCorporation() {	
		
		log.info("Step AddEditRfq_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_006 - 02: Input correct username and password");
		log.info("Step AddEditRfq_006 - 03: Accept Alert message");
		log.info("Step AddEditRfq_006 - 04: Open Add labels page");
		log.info("Step AddEditRfq_006 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_006 - 06: Click on Add button");
		log.info("Step AddEditRfq_006 - 07: Input all other textfields");
		log.info("Step AddEditRfq_006 - 08: Click on Save button");
		log.info("Step AddEditRfq_006 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_006 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_006 - 11: Select Corporation");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", "Wadsworth Center");
		
		log.info("Step AddEditRfq_006 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, "Wadsworth Center"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Job number works")
	public void AddEditRfq_007_SearchRfqByJobNumber() {	
		
		log.info("Step AddEditRfq_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_007 - 02: Input correct username and password");
		log.info("Step AddEditRfq_007 - 03: Accept Alert message");
		log.info("Step AddEditRfq_007 - 04: Open Add labels page");
		log.info("Step AddEditRfq_007 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_007 - 06: Click on Add button");
		log.info("Step AddEditRfq_007 - 07: Input all other textfields");
		log.info("Step AddEditRfq_007 - 08: Click on Save button");
		log.info("Step AddEditRfq_007 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_007 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_007 - 11: Input Job number");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "sel_JobNumber", jobCode2);
		
		log.info("Step AddEditRfq_007 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Suggesstion Vendor works")
	public void AddEditRfq_008_SearchRfqBySuggestionVendor() {	
		
		log.info("Step AddEditRfq_008 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_008 - 02: Input correct username and password");
		log.info("Step AddEditRfq_008 - 03: Accept Alert message");
		log.info("Step AddEditRfq_008 - 04: Open Add labels page");
		log.info("Step AddEditRfq_008 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_008 - 06: Click on Add button");
		log.info("Step AddEditRfq_008 - 07: Input all other textfields");
		log.info("Step AddEditRfq_008 - 08: Click on Save button");
		log.info("Step AddEditRfq_008 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_008 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_008 - 11: Input Vendor name");
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Vendor", vendorName2);
		
		log.info("Step AddEditRfq_008 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, vendorName2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Project Code works")
	public void AddEditRfq_009_SearchRfqByProjectCode() {	
		
		log.info("Step AddEditRfq_009 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_009 - 02: Input correct username and password");
		log.info("Step AddEditRfq_009 - 03: Accept Alert message");
		log.info("Step AddEditRfq_009 - 04: Open Add labels page");
		log.info("Step AddEditRfq_009 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_009 - 06: Click on Add button");
		log.info("Step AddEditRfq_009 - 07: Input all other textfields");
		log.info("Step AddEditRfq_009 - 08: Click on Save button");
		log.info("Step AddEditRfq_009 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_009 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_009 - 11: Input Project code");
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ProjectNum", projectCode2);
		
		log.info("Step AddEditRfq_009 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Request date works")
	public void AddEditRfq_010_SearchRfqByRequestDate() {	
		
		log.info("Step AddEditRfq_010 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_010 - 02: Input correct username and password");
		log.info("Step AddEditRfq_010 - 03: Accept Alert message");
		log.info("Step AddEditRfq_010 - 04: Open Add labels page");
		log.info("Step AddEditRfq_010 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_010 - 06: Click on Add button");
		log.info("Step AddEditRfq_010 - 07: Input all other textfields");
		log.info("Step AddEditRfq_010 - 08: Click on Save button");
		log.info("Step AddEditRfq_010 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_010 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_010 - 11: Input Request date");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqDateFrom", "12-12-2020");
		
		log.info("Step AddEditRfq_010 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, "12-12-2020"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Item code works")
	public void AddEditRfq_011_SearchRfqByItemCode() {	
		
		log.info("Step AddEditRfq_011 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_011 - 02: Input correct username and password");
		log.info("Step AddEditRfq_011 - 03: Accept Alert message");
		log.info("Step AddEditRfq_011 - 04: Open Add labels page");
		log.info("Step AddEditRfq_011 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_011 - 06: Click on Add button");
		log.info("Step AddEditRfq_011 - 07: Input all other textfields");
		log.info("Step AddEditRfq_011 - 08: Click on Save button");
		log.info("Step AddEditRfq_011 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_011 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_011 - 11: Input Item code");
		rfqPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Item", itemCode1);
		
		log.info("Step AddEditRfq_011 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Ship-to code works")
	public void AddEditRfq_012_SearchRfqByShipToCode() {	
		
		log.info("Step AddEditRfq_012 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_012 - 02: Input correct username and password");
		log.info("Step AddEditRfq_012 - 03: Accept Alert message");
		log.info("Step AddEditRfq_012 - 04: Open Add labels page");
		log.info("Step AddEditRfq_012 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_012 - 06: Click on Add button");
		log.info("Step AddEditRfq_012 - 07: Input all other textfields");
		log.info("Step AddEditRfq_012 - 08: Click on Save button");
		log.info("Step AddEditRfq_012 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_012 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_012 - 11: Input Ship-to code");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipToCode", shipToCode2);
		
		log.info("Step AddEditRfq_012 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Rfq code by Ship-to code works")
	public void AddEditRfq_013_SearchRfqByVendorName() {	
		
		log.info("Step AddEditRfq_012 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_012 - 02: Input correct username and password");
		log.info("Step AddEditRfq_012 - 03: Accept Alert message");
		log.info("Step AddEditRfq_012 - 04: Open Add labels page");
		log.info("Step AddEditRfq_012 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_012 - 06: Click on Add button");
		log.info("Step AddEditRfq_012 - 07: Input all other textfields");
		log.info("Step AddEditRfq_012 - 08: Click on Save button");
		log.info("Step AddEditRfq_012 - 09: Open Manager page");
		rfqPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfqs/manage_rfq.php");
		
		log.info("Step AddEditRfq_012 - 10: Input Rfq Code");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_012 - 11: Input Ship-to code");
		rfqPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipToCode", shipToCode2);
		
		log.info("Step AddEditRfq_012 - 12: Click on Search button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Rfq code displayed correctly");
		verifyTrue(rfqPage.isResultTableContainsRecord(DriverManager.getDriver(), newRfq, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Delete Rfq works")
	public void AddEditRfq_014_DeleteRfqWorks() {	
		log.info("Step AddEditRfq_013 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRfq_013 - 02: Input correct username and password");
		log.info("Step AddEditRfq_013 - 03: Accept Alert message");
		log.info("Step AddEditRfq_013 - 04: Open Add labels page");
		log.info("Step AddEditRfq_013 - 05: Input new Rfq code");
		log.info("Step AddEditRfq_013 - 06: Click on Add button");
		log.info("Step AddEditRfq_013 - 07: Input all other textfields");
		log.info("Step AddEditRfq_013 - 08: Click on Save button");
		log.info("Step AddEditRfq_013 - 09: Open Add Rfq page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/rfq/add_request_for_quotation.php");

		log.info("Step AddEditRfq_013 - 10: Input new Rfq");
		rfqPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRfq);
		
		log.info("Step AddEditRfq_013 - 11: Click on Manage button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditRfq_013 - 12: Click on Delete button");
		rfqPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
		rfqPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Rfq is not displayed");
		verifyFalse(rfqPage.isTextDisplayed(DriverManager.getDriver(), newRfq));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private RfqPage rfqPage;
	private ConfigPage configPage;
	private AddUserPage addUserPage;
	private String newRfq;
	private String unitOfMeasure1, unitOfMeasure2, unitOfMeasureName1, unitOfMeasureName2;
	private String itemCode1, itemCode2;
	private String glAccountCode1, glAccountCode2;
	private String projectCode1, projectCode2, project1, project2;
	private String job1, job2, jobCode1, jobCode2;
	private String ship1, ship2, shipToCode1, shipToCode2;
	private String vendorID1, vendorName1, vendor1;
	private String vendorID2, vendorName2, vendor2;
	private String validNumber1, validNumber2, validDecimal1, validDecimal2, validText1, validText2, validStartDate1, validStartDate2, validEndDate1, validEndDate2;
	private String text1, text2, specialText1, specialText2;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, primaryUserRole2, primaryUserName2;
	private String corporation;
}
