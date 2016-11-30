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
		itemCode1 = "item1";
		itemCode2 = "item2";
		unitOfMeasure1 = "um1";
		unitOfMeasure2 = "um2";
		vendorName1 = "vendor"+ getUniqueNumber(7);
		vendorName2= vendorName1+"second";
		job1 = "JobCode1";
		jobCode1= job1 + " : "+ job1;
		job2 = "JobCode2";
		jobCode2= job2 + " : "+ job2;
		projectCode1 = "Project1";
		projectCode2 = "Project2";
		glAccountCode1 = "glNo1";
		glAccountCode2 = "glNo2";
		ship1 = "ShipCd1";
		shipToCode1= ship1 + " : "+ ship1;
		ship2 = "ShipCd2";
		shipToCode2= ship2 + " : "+ ship2;
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create Unit of measure");
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure1);
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure2);
		
		log.info("Step Pre-condition - 05: Create Item code");
		masterFilesPage.createNewItemCode(itemCode1);
		masterFilesPage.createNewItemCode(itemCode2);
		
		log.info("Step Pre-condition - 05: Create new Job code");
		masterFilesPage.createNewJobCode(job1);
		masterFilesPage.createNewJobCode(job2);
		
		log.info("Step Pre-condition - 04: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.createNewGLAccount(glAccountCode2);
		
		log.info("Step Pre-condition - 05: Create new Project code");
		masterFilesPage.createNewProjectCode(projectCode1);
		masterFilesPage.createNewProjectCode(projectCode2);	
		
		log.info("Step Pre-condition - 05: Create new Ship-to Code");
		masterFilesPage.createNewShipToCode(ship1);
		masterFilesPage.createNewShipToCode(ship2);
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
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqDate", "11-11-2020");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DelDate", "11-11-2020");
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_JobNum", jobCode1);
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ProjectNum", "projectCode1");
//		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode1);
		
		log.info("Step AddEditRequisition_001 - 05: Add Line Item to Requisition");
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Items0", itemCode1);
		requisitionPage.inputTextareaByID(DriverManager.getDriver(), "txt_Desc0", "Item 1");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_quantity0", "11.0000");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Um0", unitOfMeasure1);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Price0", "11.0000");
		
		log.info("Step AddEditRequisition_001 - 06: Click on Save button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "chk_UpType1");
		requisitionPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_Save");
		
		log.info("Step AddEditRequisition_001 - 07: Input new Requisition");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_001 - 08: Click on Modify button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditRequisition_001 - 04: Input All other textfields");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Vendor", vendorName1));
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_ReqDate"), "11-11-2020");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_DelDate"), "11-11-2020");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_JobNum", jobCode1));
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_ProjectNum", "projectCode1"));
//		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode1));
		
		log.info("Step AddEditRequisition_001 - 05: Add Line Item to Requisition");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_LineItem0", itemCode1));
		verifyEquals(requisitionPage.getTextareaByID(DriverManager.getDriver(), "txt_Desc0"), "Item 1");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_quantity0"), "11.0000");
		verifyEquals(requisitionPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Um0"), unitOfMeasure1);
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
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PackgNum", "12");
		
		log.info("Step AddEditRequisition_002 - 12: Add Item to Requisition");
		requisitionPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_LineItem_0", itemCode2);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Desc_0", "Item 2");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_QtyRcvd_0", "12.0000");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Um_0", unitOfMeasure2);
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendItem_0", "Vendor Item 2");
		
		log.info("Step AddEditRequisition_002 - 13: Click on Save button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditRequisition_002 - 14: Input new Requisition");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNum", newRequisition);
		
		log.info("Step AddEditRequisition_002 - 15: Click on Modify button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All textfield is saved correctly");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_Vendor"), vendorName2);
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_PackgNum"), "12");
		
		log.info("VP: Item is added correctly");
		verifyTrue(requisitionPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_LineItem0", itemCode2));
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_Desc_0"), "Item 2");
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_QtyRcvd_0"), "12.0000");
		verifyEquals(requisitionPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Um_0"), unitOfMeasure2);
		verifyEquals(requisitionPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendItem_0"), "Vendor Item 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Vendor name works")
	public void AddEditRequisition_003_SearchRequisitionByVendorName() {	
		
		log.info("Step AddEditRequisition_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_003 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_003 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_003 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_003 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_003 - 06: Click on Add button");
		log.info("Step AddEditRequisition_003 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_003 - 08: Click on Save button");
		log.info("Step AddEditRequisition_003 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisition/manage_unplanned_receipt.php");
		
		log.info("Step AddEditRequisition_003 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditRequisition_003 - 11: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, vendorName2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Receiver works")
	public void AddEditRequisition_004_SearchRequisitionByReceiver() {	
		
		log.info("Step AddEditRequisition_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_004 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_004 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_004 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_004 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_004 - 06: Click on Add button");
		log.info("Step AddEditRequisition_004 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_004 - 08: Click on Save button");
		log.info("Step AddEditRequisition_004 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisition/manage_unplanned_receipt.php");
		
		log.info("Step AddEditRequisition_004 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditRequisition_004 - 11: Select Receiver");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Rcvr", "Tammi Stock");
		
		log.info("Step AddEditRequisition_004 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, vendorName2));
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
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisition/manage_unplanned_receipt.php");
		
		log.info("Step AddEditRequisition_005 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditRequisition_005 - 11: Input Keyword");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Keyword", "Item 2");
		
		log.info("Step AddEditRequisition_005 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("Step AddEditRequisition_005 - 13: Click on OK button");
		requisitionPage.clickOnElementByItsValue(DriverManager.getDriver(), "OK");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, vendorName2));
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
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisition/manage_unplanned_receipt.php");
		
		log.info("Step AddEditRequisition_006 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditRequisition_006 - 11: Select Corporation");
		requisitionPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", "Wadsworth Center");
		
		log.info("Step AddEditRequisition_006 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, "Wadsworth Center"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Requisition code by Requisition date works")
	public void AddEditRequisition_007_SearchRequisitionByRequisitionDate() {	
		
		log.info("Step AddEditRequisition_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditRequisition_007 - 02: Input correct username and password");
		log.info("Step AddEditRequisition_007 - 03: Accept Alert message");
		log.info("Step AddEditRequisition_007 - 04: Open Add labels page");
		log.info("Step AddEditRequisition_007 - 05: Input new Requisition code");
		log.info("Step AddEditRequisition_007 - 06: Click on Add button");
		log.info("Step AddEditRequisition_007 - 07: Input all other textfields");
		log.info("Step AddEditRequisition_007 - 08: Click on Save button");
		log.info("Step AddEditRequisition_007 - 09: Open Manager page");
		requisitionPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/requisition/manage_unplanned_receipt.php");
		
		log.info("Step AddEditRequisition_007 - 10: Input Requisition Code");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		
		log.info("Step AddEditRequisition_007 - 11: Input Requisition date");
		requisitionPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DateF", "11-11-2020");
		
		log.info("Step AddEditRequisition_007 - 12: Click on Search button");
		requisitionPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Requisition code displayed correctly");
		verifyTrue(requisitionPage.isResultTableContainsRecord(DriverManager.getDriver(), newRequisition, "11-11-2020"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private RequisitionPage requisitionPage;
	private String newRequisition;
	private String unitOfMeasure1, unitOfMeasure2;
	private String itemCode1, itemCode2;
	private String vendorName1, vendorName2;
	private String glAccountCode1, glAccountCode2;
	private String projectCode1, projectCode2;
	private String job1, job2, jobCode1, jobCode2;
	private String ship1, ship2, shipToCode1, shipToCode2;

}
