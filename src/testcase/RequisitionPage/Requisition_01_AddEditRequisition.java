package RequisitionPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.RequisitionPage;
import page.MasterFilesPage;
import page.LoginPage;

public class Requisition_01_AddEditRequisition extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		requisitionPage = PageFactory.getRequisitionPage(DriverManager.getDriver(), ipClient);
		newRequisition = getUniqueNumber(7);
		copyRequisition = getUniqueNumber(7);
		itemCode1 = "item1";
		unitOfMeasure1 = "um1";
		unitOfMeasure2 = "um2";
		unitOfMeasureName1= unitOfMeasure1+ " : "+unitOfMeasure1;
		unitOfMeasureName2= unitOfMeasure2+ " : "+unitOfMeasure2;
		vendorID1 = "110320161";
		vendorName1 = "Vendor 1";
		vendorID2 = "110320162";
		vendorName2 = "Vendor 2";
		job1 = "JobCode1";
		jobCode1= job1 + " : "+ job1;
		job2 = "JobCode2";
		jobCode2= job2 + " : "+ job2;
		projectCode1 = "Project1";
		projectCode2 = "Project2";
		glAccountCode1 = "glN01";
		glAccountCode2 = "glN02";
		ship1 = "ShipCd1";
		shipToCode1= ship1 + " : "+ ship1;
		ship2 = "ShipCd2";
		shipToCode2= ship2 + " : "+ ship2;
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
//		log.info("Step Pre-condition - 04: Create Unit of measure");
//		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure1);
//		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure2);
//		
//		log.info("Step Pre-condition - 05: Create Item code");
//		masterFilesPage.createNewItemCode(itemCode1);
//		
//		log.info("Step Pre-condition - 06: Create new Job code");
//		masterFilesPage.createNewJobCode(job1);
//		masterFilesPage.createNewJobCode(job2);
////		
//		log.info("Step Pre-condition - 07: Create GL Account");
//		masterFilesPage.createNewGLAccount(glAccountCode1);
//		masterFilesPage.createNewGLAccount(glAccountCode2);
////		
//		log.info("Step Pre-condition - 08: Create new Project code");
//		masterFilesPage.createNewProjectCode(projectCode1);
//		masterFilesPage.createNewProjectCode(projectCode2);	
//		
//		log.info("Step Pre-condition - 09: Create new Ship-to Code");
//		masterFilesPage.createNewShipToCode(ship1);
//		masterFilesPage.createNewShipToCode(ship2);
//		
//		log.info("Step Pre-condition - 10: Create new Vendor");
//		masterFilesPage.createNewVendor(vendorID1, vendorName1);
//		masterFilesPage.createNewVendor(vendorID2, vendorName2);
	}

	@Test(groups = { "regression" }, description = "Check Add Requisition works")
	public void AddEditRequisition_001_CheckAddRequisitionWorks() {	
		
		log.info("Step AddEditRequisition_001 - 01: Open Add Requisition page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/add_requisition.php");

		log.info("Step AddEditRequisition_001 - 02: Input new Requisition");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_001 - 03: Click on Add button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditRequisition_001 - 04: Input All other textfields");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipCode", shipToCode1);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqDate", "11-11-2020");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DelDate", "11-11-2020");
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNum", jobCode1);
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ProjectNum", projectCode1);
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode1);
		
		log.info("Step AddEditRequisition_001 - 05: Add Line Item to Requisition");
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Items0", itemCode1);
		requisitionPage.inputTextareaByID(DriverManager.getDriver(), "txt_Desc0", "Item 1");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_quantity0", "11.0000");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Um0", unitOfMeasureName1);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Price0", "11.0000");
		
		log.info("Step AddEditRequisition_001 - 06: Click on Save button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "chk_UpType1");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		
		log.info("Step AddEditRequisition_001 - 07: Input new Requisition");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_001 - 08: Click on Modify button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditRequisition_001 - VP: All other textfields are saved correctly");
		verifyEquals(requisitionPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ShipCode"), shipToCode1);
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Vendor", vendorName1));
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_ReqDate"), "11-11-2020");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_DelDate"), "11-11-2020");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum", jobCode1));
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_ProjectNum", projectCode1));
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode1));
		
		log.info("Step AddEditRequisition_001 - VP: Line Item is added to Requisition");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_LineItem0", itemCode1));
		verifyEquals(requisitionPage.getTextareaByID(DriverManager.getDriver(), "txt_Desc0"), "Item 1");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_quantity0"), "11.0000");
		verifyEquals(requisitionPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Um0"), unitOfMeasureName1);
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_Price0"), "11.0000");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_EAmt0"), "121.00");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Requisition works")
	public void AddEditRequisition_002_CheckEditRequisitionWorks() {	
		
		log.info("Step AddEditRequisition_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_002 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_002 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_002 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_002 - 05: Input new Requisition");
		log.info("Step AddEditRequisition_002 - 06: Click on Add button");
		log.info("Step AddEditRequisition_002 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_002 - 08: Click on Save button");
		log.info("Step AddEditRequisition_002 - 09: Input new Requisition");
		log.info("Step AddEditRequisition_002 - 10: Click on Modify button");
		log.info("Step AddEditRequisition_002 - 11: Input All other textfields");
		log.info("Step AddEditRequisition_002 - 12: Input All other textfields");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipCode", shipToCode2);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqDate", "12-12-2020");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DelDate", "12-12-2020");
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNum", jobCode2);
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ProjectNum", projectCode2);
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode2);
		
		log.info("Step AddEditRequisition_002 - 13: Add Line Item to Requisition");
		requisitionPage.inputTextareaByID(DriverManager.getDriver(), "txt_Desc0", "Item 2");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_quantity0", "12.0000");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Um0", unitOfMeasureName2);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Price0", "12.0000");
		
		log.info("Step AddEditRequisition_002 - 14: Click on Save button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "chk_UpType1");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		
		log.info("Step AddEditRequisition_002 - 15: Input new Requisition");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_002 - 16: Click on Modify button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditRequisition_002 - VP: All other textfields are saved correctly");
		verifyEquals(requisitionPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ShipCode"), shipToCode2);
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Vendor", vendorName2));
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_ReqDate"), "12-12-2020");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_DelDate"), "12-12-2020");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum", jobCode2));
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_ProjectNum", projectCode2));
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode2));
		
		log.info("Step AddEditRequisition_002 - VP: Line Item is added to Requisition");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_LineItem0", itemCode1));
		verifyEquals(requisitionPage.getTextareaByID(DriverManager.getDriver(), "txt_Desc0"), "Item 2");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_quantity0"), "12.0000");
		verifyEquals(requisitionPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Um0"), unitOfMeasureName2);
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_Price0"), "12.0000");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_EAmt0"), "144.00");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Requisition name works")
	public void AddEditRequisition_003_SearchRequisitionByRequisitionNumber() {	
		
		log.info("Step AddEditRequisition_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_003 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_003 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_003 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_003 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_003 - 06: Click on Add button");
		log.info("Step AddEditRequisition_003 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_003 - 08: Click on Save button");
		log.info("Step AddEditRequisition_003 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/manage_requisition.php");
		
		log.info("Step AddEditRequisition_003 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_003 - 11: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Keywords works")
	public void AddEditRequisition_005_SearchRequisitionByKeywords() {	
		
		log.info("Step AddEditRequisition_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_005 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_005 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_005 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_005 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_005 - 06: Click on Add button");
		log.info("Step AddEditRequisition_005 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_005 - 08: Click on Save button");
		log.info("Step AddEditRequisition_005 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/manage_requisition.php");
		
		log.info("Step AddEditRequisition_005 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_005 - 11: Input Keyword");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Keyword", "Item 2");
		
		log.info("Step AddEditRequisition_005 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("Step AddEditRequisition_005 - 13: Click on OK button");
		requisitionPage.clickOnElementByItsValue(DriverManager.getDriver(), "OK");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Corporation works")
	public void AddEditRequisition_006_SearchRequisitionByCorporation() {	
		
		log.info("Step AddEditRequisition_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_006 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_006 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_006 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_006 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_006 - 06: Click on Add button");
		log.info("Step AddEditRequisition_006 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_006 - 08: Click on Save button");
		log.info("Step AddEditRequisition_006 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/manage_requisition.php");
		
		log.info("Step AddEditRequisition_006 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_006 - 11: Select Corporation");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", "Wadsworth Center");
		
		log.info("Step AddEditRequisition_006 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, "Wadsworth Center"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Job number works")
	public void AddEditRequisition_007_SearchRequisitionByJobNumber() {	
		
		log.info("Step AddEditRequisition_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_007 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_007 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_007 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_007 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_007 - 06: Click on Add button");
		log.info("Step AddEditRequisition_007 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_007 - 08: Click on Save button");
		log.info("Step AddEditRequisition_007 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/manage_requisition.php");
		
		log.info("Step AddEditRequisition_007 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_007 - 11: Input Job number");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "sel_JobNumber", jobCode2);
		
		log.info("Step AddEditRequisition_007 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Suggesstion Vendor works")
	public void AddEditRequisition_008_SearchRequisitionBySuggestionVendor() {	
		
		log.info("Step AddEditRequisition_008 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_008 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_008 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_008 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_008 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_008 - 06: Click on Add button");
		log.info("Step AddEditRequisition_008 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_008 - 08: Click on Save button");
		log.info("Step AddEditRequisition_008 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/manage_requisition.php");
		
		log.info("Step AddEditRequisition_008 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_008 - 11: Input Vendor name");
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "sel_Vendor", vendorName2);
		
		log.info("Step AddEditRequisition_008 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, vendorName2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Project Code works")
	public void AddEditRequisition_009_SearchRequisitionByProjectCode() {	
		
		log.info("Step AddEditRequisition_009 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_009 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_009 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_009 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_009 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_009 - 06: Click on Add button");
		log.info("Step AddEditRequisition_009 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_009 - 08: Click on Save button");
		log.info("Step AddEditRequisition_009 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/manage_requisition.php");
		
		log.info("Step AddEditRequisition_009 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_009 - 11: Input Project code");
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ProjectNum", projectCode2);
		
		log.info("Step AddEditRequisition_009 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Request date works")
	public void AddEditRequisition_010_SearchRequisitionByRequestDate() {	
		
		log.info("Step AddEditRequisition_010 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_010 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_010 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_010 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_010 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_010 - 06: Click on Add button");
		log.info("Step AddEditRequisition_010 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_010 - 08: Click on Save button");
		log.info("Step AddEditRequisition_010 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/manage_requisition.php");
		
		log.info("Step AddEditRequisition_010 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_010 - 11: Input Request date");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqDateFrom", "12-12-2020");
		
		log.info("Step AddEditRequisition_010 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, "12-12-2020"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Item code works")
	public void AddEditRequisition_011_SearchRequisitionByItemCode() {	
		
		log.info("Step AddEditRequisition_011 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_011 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_011 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_011 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_011 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_011 - 06: Click on Add button");
		log.info("Step AddEditRequisition_011 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_011 - 08: Click on Save button");
		log.info("Step AddEditRequisition_011 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/manage_requisition.php");
		
		log.info("Step AddEditRequisition_011 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_011 - 11: Input Item code");
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Item", itemCode1);
		
		log.info("Step AddEditRequisition_011 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Ship-to code works")
	public void AddEditRequisition_012_SearchRequisitionByShipToCode() {	
		
		log.info("Step AddEditRequisition_012 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_012 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_012 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_012 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_012 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_012 - 06: Click on Add button");
		log.info("Step AddEditRequisition_012 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_012 - 08: Click on Save button");
		log.info("Step AddEditRequisition_012 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/manage_requisition.php");
		
		log.info("Step AddEditRequisition_012 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_012 - 11: Input Ship-to code");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ShipToCode", shipToCode2);
		
		log.info("Step AddEditRequisition_012 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Requisition works")
	public void AddEditRequisition_013_CheckCopyRequisitionWorks() {	
		
		log.info("Step AddEditRequisition_013 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_013 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_013 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_013 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_013 - 05: Input new Requisition");
		log.info("Step AddEditRequisition_013 - 06: Click on Add button");
		log.info("Step AddEditRequisition_013 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_013 - 08: Click on Save button");
		log.info("Step AddEditRequisition_013 - 09: Open Copy requisition page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/reqs_from_previous_reqs.php");
		
		log.info("Step AddEditRequisition_013 - 10: Search for Requisition");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("Step AddEditRequisition_013 - 11: Select Requisition");
		requisitionPage.clickOnElementByItsText(DriverManager.getDriver(), newRequisition);
		
		log.info("Step AddEditRequisition_013 - 12: Click on Copy Req button");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_CreatReq");
		
		log.info("Step AddEditRequisition_013 - 13: Input Requisition number and Delivery date");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DivReqNumber", copyRequisition);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DivDlvDate", "12-12-2020");
		
		log.info("Step AddEditRequisition_013 - 14: Click on Ok button");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_OkReq");
		requisitionPage.sleep(2);
		
		log.info("Step AddEditRequisition_013 - 15: Input Requisition date");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqDate", "12-12-2020");
		
		log.info("Step AddEditRequisition_013 - 16: Click on Save button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "chk_UpType1");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		
		log.info("Step AddEditRequisition_001 - 17: Open Add Requisition page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/add_requisition.php");
		
		log.info("Step AddEditRequisition_013 - 18: Input new Requisition");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", copyRequisition);
		
		log.info("Step AddEditRequisition_013 - 19: Click on Modify button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditRequisition_013 - VP: All other textfields are saved correctly");
		verifyEquals(requisitionPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ShipCode"), shipToCode2);
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Vendor", vendorName2));
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_ReqDate"), "12-12-2020");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_DelDate"), "12-12-2020");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum", jobCode2));
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_ProjectNum", projectCode2));
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode2));
		
		log.info("Step AddEditRequisition_013 - VP: Line Item is added to Requisition");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_LineItem0", itemCode1));
		verifyEquals(requisitionPage.getTextareaByID(DriverManager.getDriver(), "txt_Desc0"), "Item 2");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_quantity0"), "12.0000");
		verifyEquals(requisitionPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Um0"), unitOfMeasureName2);
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_Price0"), "12.0000");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_EAmt0"), "144.00");
	}
	
	@Test(groups = { "regression" }, description = "Check Delete Requisition works")
	public void AddEditRequisition_014_DeleteRequisitionWorks() {	
		log.info("Step AddEditRequisition_014 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_014 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_014 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_014 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_014 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_014 - 06: Click on Add button");
		log.info("Step AddEditRequisition_014 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_014 - 08: Click on Save button");
		log.info("Step AddEditRequisition_014 - 09: Open Add Requisition page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisitions/add_requisition.php");

		log.info("Step AddEditRequisition_014 - 10: Input new Requisition");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_014 - 11: Click on Manage button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditRequisition_014 - 12: Click on Delete button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
		requisitionPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Requisition is not displayed");
		verifyFalse(requisitionPage.isTextDisplayed(DriverManager.getDriver(), newRequisition));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private RequisitionPage requisitionPage;
	private String newRequisition, copyRequisition;
	private String unitOfMeasure1, unitOfMeasure2, unitOfMeasureName1, unitOfMeasureName2;
	private String itemCode1;
	private String glAccountCode1, glAccountCode2;
	private String projectCode1, projectCode2;
	private String job1, job2, jobCode1, jobCode2;
	private String ship1, ship2, shipToCode1, shipToCode2;
	private String vendorID1, vendorName1;
	private String vendorID2, vendorName2;
}
