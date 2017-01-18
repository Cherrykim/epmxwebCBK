package AssetManagerPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.AddUserPage;
import page.AssetManagerPage;
import page.LoginPage;
import page.MasterFilesPage;

public class AssetManager_07_AddEditAssetEntry extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		assetManagerPage = PageFactory.getAssetManagerPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		newAssetEntry = getUniqueText(8);
		
		newAssetCategory1 = "category1";
		newCategory1= newAssetCategory1 + " : " + newAssetCategory1;
		newAssetDepartment1 = "department1";
		newDepartment1= newAssetDepartment1 + " : " + newAssetDepartment1;
		newAssetStatus1 = "status1";
		newStatus1= newAssetStatus1 + " : " + newAssetStatus1;
		newAssetType1 = getUniqueText(5);
		newType1= newAssetType1 + " : " + newAssetType1;
		newAssetUnit1 = "unit1";
		newUnit1= newAssetUnit1 + " : " + newAssetUnit1;
		newAssetLocation1 = "location1";
		newLocation1= newAssetLocation1 + " : " + newAssetLocation1;
		
		
		newAssetCategory2 = "category2";
		newCategory2= newAssetCategory2 + " : " + newAssetCategory2;
		newAssetDepartment2 = "department2";
		newDepartment2= newAssetDepartment2 + " : " + newAssetDepartment2;
		newAssetStatus2 = "status2";
		newStatus2= newAssetStatus2 + " : " + newAssetStatus2;
		newAssetType2 = getUniqueText(5);
		newType2= newAssetType2 + " : " + newAssetType2;
		newAssetUnit2 = "unit2";
		newUnit2= newAssetUnit2 + " : " + newAssetUnit2;
		newAssetLocation2 = "location2";
		newLocation2= newAssetLocation2 + " : " + newAssetLocation2;
		
		itemCode1 = "item1";
		itemCode2 = "item2";
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
		
		glAccountCode1 = "glNo1";
		glAccountCode2 = "glNo2";
		
		vendorID1 = "110320161";
		vendorName1 = "Vendor 1";
		vendorID2 = "110320162";
		vendorName2 = "Vendor 2";
		
		log.info("Step Pre-condition - 00: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 00: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 00: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 01: Create Asset Category");
		assetManagerPage.createNewAssetCategory(newAssetCategory1);
		assetManagerPage.createNewAssetCategory(newAssetCategory2);
		
		log.info("Step Pre-condition - 02: Create Asset Department");
		assetManagerPage.createNewAssetDepartment(newAssetDepartment1);
		assetManagerPage.createNewAssetDepartment(newAssetDepartment2);
		
		log.info("Step Pre-condition - 03: Create Asset Status");
		assetManagerPage.createNewAssetStatus(newAssetStatus1);
		assetManagerPage.createNewAssetStatus(newAssetStatus2);
		
		log.info("Step Pre-condition - 05: Create Asset Type");
		assetManagerPage.createNewAssetType(newAssetType1);
		assetManagerPage.createNewAssetType(newAssetType2);
		
		log.info("Step Pre-condition - 06: Create Asset Unit");
		assetManagerPage.createNewAssetUnit(newAssetUnit1);
		assetManagerPage.createNewAssetUnit(newAssetUnit2);
		
		log.info("Step Pre-condition - 07: Create Asset Location");
		assetManagerPage.createNewAssetLocation(newAssetLocation1);
		assetManagerPage.createNewAssetLocation(newAssetLocation2);
		
		log.info("Step Pre-condition - 08: Create Item code");
		masterFilesPage.createNewItemCode(itemCode1);
		masterFilesPage.createNewItemCode(itemCode2);
		
		log.info("Step Pre-condition - 09: Create new Buyer");
		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole);
		addUserPage.createNewUserWithRole(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", primaryUserRole2);
	
		log.info("Step Pre-condition - 10: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.createNewGLAccount(glAccountCode2);
		
		log.info("Step Pre-condition - 04: Create new Vendor");
		masterFilesPage.createNewVendor(vendorID1, vendorName1);
		masterFilesPage.createNewVendor(vendorID2, vendorName2);
	}

	@Test(groups = { "regression" }, description = "Check Add Asset entry works")
	public void AddEditAssetEntry_001_CheckAddAssetEntryWorks() {	
		
		log.info("Step AddEditAssetEntry_001 - 01: Open Add Asset entry page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/add_asset.php");

		log.info("Step AddEditAssetEntry_001 - 02: Input new Asset entry");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNum", newAssetEntry);
		
		log.info("Step AddEditAssetEntry_001 - 03: Click on Add button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditAssetEntry_001 - 04: Input all selecter textfield");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ItemCode", itemCode1);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newType1);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetCategory", newCategory1);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetStatus", newStatus1);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AsgndDept", newDepartment1);
//		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AsgndUnit", newUnit1);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AsgndEmp", primaryUserName);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAcc", glAccountCode1);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName1);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetLocation", newLocation1);
		
		log.info("Step AddEditAssetEntry_001 - 05: Input all textfields");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_AssetDesc", "new desciption");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AcquisitionDate", "11-11-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AcquisitionCost", "11.11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AccumulatedDepreciation", "11.11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_NetValue", "11.11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_NbrLicenses", "11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DateAssigned", "11-11-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Misc", "Miscellaneous");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorContact", vendorName1);
		
		log.info("Step AddEditAssetEntry_001 - 06: Open Addl Asset Info tab");
		assetManagerPage.openTab(DriverManager.getDriver(), "Addl Asset Info");
		
		log.info("Step AddEditAssetEntry_001 - 07: Input all textfields");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONumber", "11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNumber", "11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RfqNumber", "11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisposalMethod", "11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisposalExpense", "11.11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SalvageValue", "11.11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Manufacturer", "11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ModelNumber", "11");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisposalDate", "11-11-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisposalValue", "11.11");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UsefulLifeTerm", "Days");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UsefulLifeLength", "11");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_AssetNotes", "11");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_DisposalNotes", "11");
		
		log.info("Step AddEditAssetEntry_001 - 08: Input all selecter textfield");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AsgndByEmp", primaryUserName);
		
		log.info("Step AddEditAssetEntry_001 - 09: Add Attachment");
		assetManagerPage.addAttachment("datatest1.pdf");
		
		log.info("Step AddEditAssetEntry_001 - 10: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetEntry_001 - 11: Input new Asset entry");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNum", newAssetEntry);
		
		log.info("Step AddEditAssetEntry_001 - 12: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditAssetEntry_001 - VP: Check fields saved correctly: all selecter textfield");
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Item", itemCode1));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetType", newType1));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetCat", newCategory1));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetStat", newStatus1));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssgnDept", newDepartment1));
//		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetUnit", newUnit1));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetEmp", primaryUserName));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode1));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Vendor", vendorName1));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetLoco", newLocation1));
		
		log.info("Step AddEditAssetEntry_001 - VP:  Check fields saved correctly: all textfields");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_AssetDesc"), "new desciption");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_AcquisitionDate"), "11-11-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_AcquisitionCost"), "11.11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_AccumulatedDepreciation"), "11.11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_NetValue"), "11.11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_NbrLicenses"), "11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DateAssigned"), "11-11-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Misc"), "Miscellaneous");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorContact"), vendorName1);
		
		log.info("Step AddEditAssetEntry_001 - VP: Open Addl Asset Info tab");
		assetManagerPage.openTab(DriverManager.getDriver(), "Addl Asset Info");
		
		log.info("Step AddEditAssetEntry_001 - VP:  Check fields saved correctly: all textfields");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_PONumber"), "11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_ReqNumber"), "11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_RfqNumber"), "11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DisposalMethod"), "11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DisposalExpense"), "11.11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_SalvageValue"), "11.11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Manufacturer"), "11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_ModelNumber"), "11");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DisposalDate"), "11-11-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DisposalValue"), "11.11");
		verifyEquals(assetManagerPage.getSelectedItemByID(DriverManager.getDriver(), "sel_UsefulLifeTerm"), "Days");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_UsefulLifeLength"), "11");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_AssetNotes"), "11");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_DisposalNotes"), "11");
		
		log.info("Step AddEditAssetEntry_001 - VP:  Check fields saved correctly:  all selecter textfield");
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssgnEmpBy", primaryUserName));
		
		log.info("Step AddEditAssetEntry_001 - VP:  Check fields saved correctly:  Attachment");
		verifyTrue(assetManagerPage.isAttachmentDisplayed("datatest1.pdf"));
	}
	
	@Test(groups = { "regression" }, description = "Check Add Asset entry works")
	public void AddEditAssetEntry_002_CheckEditAssetEntryWorks() {	
		
		log.info("Step AddEditAssetEntry_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetEntry_002 - 02: Input correct username and password");
		log.info("Step AddEditAssetEntry_002 - 03: Accept Alert message");
		log.info("Step AddEditAssetEntry_002 - 04: Open Add Asset Entry page");
		log.info("Step AddEditAssetEntry_002 - 05: Input new Asset entry");
		log.info("Step AddEditAssetEntry_002 - 06: Click on Add button");
		log.info("Step AddEditAssetEntry_002 - 07: Input Description");
		log.info("Step AddEditAssetEntry_002 - 08: Click on Save button");
		log.info("Step AddEditAssetEntry_002 - 09: Input new Asset entry");
		log.info("Step AddEditAssetEntry_002 - 10: Click on Modify button");
		log.info("Step AddEditAssetEntry_002 - 11: Input all selecter textfield");
		assetManagerPage.openTab(DriverManager.getDriver(), "Asset Info");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ItemCode", itemCode2);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newType2);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetCategory", newCategory2);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetStatus", newStatus2);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AsgndDept", newDepartment2);
//		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AsgndUnit", newUnit2);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AsgndEmp", primaryUserName2);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAcc", glAccountCode2);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Vendor", vendorName2);
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetLocation", newLocation2);
		
		log.info("Step AddEditAssetEntry_002 - 11: Input all textfields");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_AssetDesc", "new desciption 2");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AcquisitionDate", "12-12-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AcquisitionCost", "12.12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AccumulatedDepreciation", "12.12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_NetValue", "12.12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_NbrLicenses", "12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DateAssigned", "12-12-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Misc", "Miscellaneous 2");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorContact", vendorName2);
		
		log.info("Step AddEditAssetEntry_002 - 12: Open Addl Asset Info tab");
		assetManagerPage.openTab(DriverManager.getDriver(), "Addl Asset Info");
		
		log.info("Step AddEditAssetEntry_002 - 13: Input all textfields");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PONumber", "12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ReqNumber", "12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RfqNumber", "12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisposalMethod", "12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisposalExpense", "12.12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SalvageValue", "12.12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Manufacturer", "12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ModelNumber", "12");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisposalDate", "12-12-2016");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisposalValue", "12.12");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UsefulLifeTerm", "Months");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UsefulLifeLength", "12");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_AssetNotes", "12");
		assetManagerPage.inputTextareaByID(DriverManager.getDriver(), "txt_DisposalNotes", "12");
		
		log.info("Step AddEditAssetEntry_002 - 14: Input all selecter textfield");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AsgndByEmp", primaryUserName2);
		
		log.info("Step AddEditAssetEntry_002 - 15: Add Attachment");
		assetManagerPage.addAttachment("datatest2.pdf");
		
		log.info("Step AddEditAssetEntry_002 - 16: Click on Save button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditAssetEntry_002 - 17: Input new Asset entry");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNum", newAssetEntry);
		
		log.info("Step AddEditAssetEntry_002 - 18: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("Step AddEditAssetEntry_002 - VP: Check fields saved correctly: all selecter textfield");
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Item", itemCode2));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetType", newType2));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetCat", newCategory2));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetStat", newStatus2));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssgnDept", newDepartment2));
//		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetUnit", newUnit2));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetEmp", primaryUserName2));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode2));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_Vendor", vendorName2));
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssetLoco", newLocation2));
		
		log.info("Step AddEditAssetEntry_002 - VP:  Check fields saved correctly: all textfields");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_AssetDesc"), "new desciption 2");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_AcquisitionDate"), "12-12-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_AcquisitionCost"), "12.12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_AccumulatedDepreciation"), "12.12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_NetValue"), "12.12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_NbrLicenses"), "12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DateAssigned"), "12-12-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Misc"), "Miscellaneous 2");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorContact"), vendorName2);
		
		log.info("Step AddEditAssetEntry_002 - VP: Open Addl Asset Info tab");
		assetManagerPage.openTab(DriverManager.getDriver(), "Addl Asset Info");
		
		log.info("Step AddEditAssetEntry_002 - VP:  Check fields saved correctly: all textfields");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_PONumber"), "12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_ReqNumber"), "12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_RfqNumber"), "12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DisposalMethod"), "12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DisposalExpense"), "12.12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_SalvageValue"), "12.12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_Manufacturer"), "12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_ModelNumber"), "12");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DisposalDate"), "12-12-2016");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_DisposalValue"), "12.12");
		verifyEquals(assetManagerPage.getSelectedItemByID(DriverManager.getDriver(), "sel_UsefulLifeTerm"), "Months");
		verifyEquals(assetManagerPage.getTextfieldByID(DriverManager.getDriver(), "txt_UsefulLifeLength"), "12");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_AssetNotes"), "12");
		verifyEquals(assetManagerPage.getTextareaByID(DriverManager.getDriver(), "txt_DisposalNotes"), "12");
		
		log.info("Step AddEditAssetEntry_002 - VP:  Check fields saved correctly:  all selecter textfield");
		verifyTrue(assetManagerPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_AssgnEmpBy", primaryUserName2));
		
		log.info("Step AddEditAssetEntry_002 - VP:  Check fields saved correctly:  Attachment");
		verifyTrue(assetManagerPage.isAttachmentDisplayed("datatest2.pdf"));
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Asset entry works")
	public void AddEditAssetEntry_003_CheckDeactivateAssetEntryWorks() {	
		
		log.info("Step AddEditAssetEntry_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetEntry_003 - 02: Input correct username and password");
		log.info("Step AddEditAssetEntry_003 - 03: Accept Alert message");
		log.info("Step AddEditAssetEntry_003 - 04: Open Add Asset Entry page");
		log.info("Step AddEditAssetEntry_003 - 05: Input new Asset entry");
		log.info("Step AddEditAssetEntry_003 - 06: Click on Add button");
		log.info("Step AddEditAssetEntry_003 - 07: Input Description");
		log.info("Step AddEditAssetEntry_003 - 08: Click on Save button");
		log.info("Step AddEditAssetEntry_003 - 09: Input new Asset entry");
		log.info("Step AddEditAssetEntry_003 - 10: Click on Deactivate button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditAssetEntry_003 - 11: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditAssetEntry_003 - 12: Input new Asset entry");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetNum", newAssetEntry);
		
		log.info("Step AddEditAssetEntry_003 - 13: Click on Modify button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Asset entry is deactivated");
		verifyEquals(assetManagerPage.getAlertText(DriverManager.getDriver()), "Asset Number is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Asset entry works")
	public void AddEditAssetEntry_004_CheckReactivateAssetEntryWorks() {	
		
		log.info("Step AddEditAssetEntry_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetEntry_004 - 02: Input correct username and password");
		log.info("Step AddEditAssetEntry_004 - 03: Accept Alert message");
		log.info("Step AddEditAssetEntry_004 - 04: Open Add Asset Entry page");
		log.info("Step AddEditAssetEntry_004 - 05: Input new Asset entry");
		log.info("Step AddEditAssetEntry_004 - 06: Click on Add button");
		log.info("Step AddEditAssetEntry_004 - 07: Input Description");
		log.info("Step AddEditAssetEntry_004 - 08: Click on Save button");
		log.info("Step AddEditAssetEntry_004 - 09: Input new Asset entry");
		log.info("Step AddEditAssetEntry_004 - 10: Click on Deactivate button");
		log.info("Step AddEditAssetEntry_004 - 11: Accept alert");
		log.info("Step AddEditAssetEntry_004 - 12: Input new Asset entry");
		log.info("Step AddEditAssetEntry_004 - 13: Click on Modify button");
		log.info("Step AddEditAssetEntry_004 - 14: Accept alert");
		assetManagerPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(assetManagerPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset entry by Type works")
	public void AddEditAssetEntry_005_SearchAssetEntryByType() {	
		
		log.info("Step AddEditAssetEntry_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetEntry_005 - 02: Input correct username and password");
		log.info("Step AddEditAssetEntry_005 - 03: Accept Alert message");
		log.info("Step AddEditAssetEntry_005 - 04: Open Add Asset Entry page");
		log.info("Step AddEditAssetEntry_005 - 05: Input new Asset entry");
		log.info("Step AddEditAssetEntry_005 - 06: Click on Add button");
		log.info("Step AddEditAssetEntry_005 - 07: Input Description");
		log.info("Step AddEditAssetEntry_005 - 08: Click on Save button");
		log.info("Step AddEditAssetEntry_005 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset.php");
		
		log.info("Step AddEditAssetEntry_005 - 10: Input Asset Type");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newType2);
		
		log.info("Step AddEditAssetEntry_005 - 11: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset entry displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetEntry, newType2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset entry by Corporation works")
	public void AddEditAssetEntry_006_SearchAssetEntryByCorporation() {	
		
		log.info("Step AddEditAssetEntry_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetEntry_006 - 02: Input correct username and password");
		log.info("Step AddEditAssetEntry_006 - 03: Accept Alert message");
		log.info("Step AddEditAssetEntry_006 - 04: Open Add Asset Entry page");
		log.info("Step AddEditAssetEntry_006 - 05: Input new Asset entry");
		log.info("Step AddEditAssetEntry_006 - 06: Click on Add button");
		log.info("Step AddEditAssetEntry_006 - 07: Input Description");
		log.info("Step AddEditAssetEntry_006 - 08: Click on Save button");
		log.info("Step AddEditAssetEntry_006 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset.php");
		
		log.info("Step AddEditAssetEntry_006 - 10: Input Asset Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newType2);
		
		log.info("Step AddEditAssetEntry_006 - 11: Select Corporation");
		assetManagerPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditAssetEntry_006 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset entry displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetEntry, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset entry by Description works")
	public void AddEditAssetEntry_007_SearchAssetEntryByDescription() {	
		
		log.info("Step AddEditAssetEntry_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetEntry_007 - 02: Input correct username and password");
		log.info("Step AddEditAssetEntry_007 - 03: Accept Alert message");
		log.info("Step AddEditAssetEntry_007 - 04: Open Add Asset Entry page");
		log.info("Step AddEditAssetEntry_007 - 05: Input new Asset entry");
		log.info("Step AddEditAssetEntry_007 - 06: Click on Add button");
		log.info("Step AddEditAssetEntry_007 - 07: Input Description");
		log.info("Step AddEditAssetEntry_007 - 08: Click on Save button");
		log.info("Step AddEditAssetEntry_007 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset.php");
		
		log.info("Step AddEditAssetEntry_007 - 10: Input Asset Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newType2);
		
		log.info("Step AddEditAssetEntry_007 - 11: Input Asset Entry description");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetDesc", "new description 2");
		
		log.info("Step AddEditAssetEntry_007 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset entry displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetEntry, "new description 2"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset entry by Item Code works")
	public void AddEditAssetEntry_008_SearchAssetEntryByItemCode() {	
		
		log.info("Step AddEditAssetEntry_008 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetEntry_008 - 02: Input correct username and password");
		log.info("Step AddEditAssetEntry_008 - 03: Accept Alert message");
		log.info("Step AddEditAssetEntry_008 - 04: Open Add Asset Entry page");
		log.info("Step AddEditAssetEntry_008 - 05: Input new Asset entry");
		log.info("Step AddEditAssetEntry_008 - 06: Click on Add button");
		log.info("Step AddEditAssetEntry_008 - 07: Input Description");
		log.info("Step AddEditAssetEntry_008 - 08: Click on Save button");
		log.info("Step AddEditAssetEntry_008 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset.php");
		
		log.info("Step AddEditAssetEntry_008 - 10: Input Asset Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newType2);
		
		log.info("Step AddEditAssetEntry_008 - 11: Input Item Code");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_ItemCode", itemCode2);
		
		log.info("Step AddEditAssetEntry_008 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset entry displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetEntry, itemCode2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Asset entry by Asset Status works")
	public void AddEditAssetEntry_009_SearchAssetEntryByAssetStatus() {	
		
		log.info("Step AddEditAssetEntry_009 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditAssetEntry_009 - 02: Input correct username and password");
		log.info("Step AddEditAssetEntry_009 - 03: Accept Alert message");
		log.info("Step AddEditAssetEntry_009 - 04: Open Add Asset Entry page");
		log.info("Step AddEditAssetEntry_009 - 05: Input new Asset entry");
		log.info("Step AddEditAssetEntry_009 - 06: Click on Add button");
		log.info("Step AddEditAssetEntry_009 - 07: Input Description");
		log.info("Step AddEditAssetEntry_009 - 08: Click on Save button");
		log.info("Step AddEditAssetEntry_009 - 09: Open Manager page");
		assetManagerPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/asset_manager/manage_asset.php");
		
		log.info("Step AddEditAssetEntry_009 - 10: Input Asset Type");
		assetManagerPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AssetType", newType2);
		
		log.info("Step AddEditAssetEntry_009 - 11: Input Item Code");
		assetManagerPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_AssetStatus", newStatus2);
		
		log.info("Step AddEditAssetEntry_009 - 12: Click on Search button");
		assetManagerPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Asset entry displayed correctly");
		verifyTrue(assetManagerPage.isResultTableContainsRecord(DriverManager.getDriver(), newAssetEntry, newStatus2));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AssetManagerPage assetManagerPage;
	private MasterFilesPage masterFilesPage;
	private AddUserPage addUserPage;
	private String newAssetEntry;
	private String newAssetCategory1, newAssetDepartment1, newAssetStatus1, newAssetType1, newAssetUnit1;
	private String newAssetCategory2, newAssetDepartment2, newAssetStatus2, newAssetType2, newAssetUnit2;
	private String newCategory1, newDepartment1, newStatus1, newType1, newUnit1;
	private String newCategory2, newDepartment2, newStatus2, newType2, newUnit2;
	private String newAssetLocation1, newAssetLocation2, newLocation1, newLocation2;
	private String itemCode1, itemCode2;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, primaryUserRole2, primaryUserName2;
	private String glAccountCode1, glAccountCode2, vendorID1, vendorName1, vendorID2, vendorName2;
}
