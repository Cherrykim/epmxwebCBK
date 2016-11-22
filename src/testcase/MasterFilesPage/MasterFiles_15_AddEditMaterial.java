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
import page.LoginPage;

public class MasterFiles_15_AddEditMaterial extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		
		newMaterial = getUniqueText(10);
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
		vendorID1 = "110320161";
		vendorName1 = "Vendor 1";
		vendorID2 = "110320162";
		vendorName2 = "Vendor 2";
		commodCode1= "comcode1";
		commodity1 = commodCode1+ " : "+commodCode1;
		commodCode2= "comcode2";
		commodity2 = commodCode2+ " : "+commodCode2;
		glAccountCode1 = "glNo1";
		glAccountCode2 = "glNo2";
		unitOfMeasure1 = "um1";
		unitOfMeasure2 = "um2";
		
		log.info("Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		log.info("Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		log.info("Pre-condition - 04: Open Add user page");
		
		log.info("Pre-condition - 05: Create new Buyer");
		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole);
		addUserPage.createNewUserWithRole(primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, "qa1@mailinator.com", primaryUserRole2);
		
		log.info("Pre-condition - 06: Create new Vendor");
		masterFilesPage.createNewVendor(vendorID1, vendorName1);
		masterFilesPage.createNewVendor(vendorID2, vendorName2);
		
		log.info("Pre-condition - 07: Create new Commodity code");
		masterFilesPage.createNewCommodityCode(commodCode1);
		masterFilesPage.createNewCommodityCode(commodCode2);
		
		log.info("Pre-condition - 08: Create GL Account");
		masterFilesPage.createNewGLAccount(glAccountCode1);
		masterFilesPage.createNewGLAccount(glAccountCode2);
		
		log.info("Pre-condition - 09: Create Unit of Measure");
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure1);
		masterFilesPage.createNewUnitOfMeasure(unitOfMeasure2);
	}

	@Test(groups = { "regression" }, description = "Check Add Material works")
	public void AddEditMaterial_001_CheckAddEditMaterialWorks() {	
		
		log.info("Step AddEditMaterial_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_001 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_001 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_001 - 04: Open Add Material page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_material.php");

		log.info("Step AddEditMaterial_001 - 05: Input new Material");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ItemCode", newMaterial);
		
		log.info("Step AddEditMaterial_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditMaterial_001 - 07: Input Description");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_MaterialDescription", "new description");
		
		log.info("Step AddEditMaterial_001 - 08: Select all dropdowns");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_CommodityCode", commodity1);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UnitMeasure", unitOfMeasure1);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ExpeditorID", primaryUserName);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BuyerID", primaryUserName);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Rank", "Level 1");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GlAcc", glAccountCode1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PVendor", vendorName1);
		
		log.info("Step AddEditMaterial_001 - 09: Input all textfield");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_EconomicOrderQty", "11.0000");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_StandardUnitCost", "11.0000");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RoutingCode", "rocode1");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_InspectionCode", "inscode1");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_QuoteLeadDays", "11");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Maxdays", "11");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_material_manufacturer", "11");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_material_part_number", "11");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorItemNum", "11");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorItemPrice", "11.0000");
		
		log.info("Step AddEditMaterial_001 - 10: Click on Add Alternate vendor button");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "add_alt_vendor");
		
		log.info("Step AddEditMaterial_001 - 10: Input Alternate vendor");
		masterFilesPage.inputTextfieldByIDWithEnter(DriverManager.getDriver(), "txt_AVendor", vendorName2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AVendorItemNum", "11");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AVendorItemPrice", "11.0000");
		masterFilesPage.sleep();
		
		log.info("Step AddEditMaterial_001 - 11: Click on Save Alternate Vendor button");
		masterFilesPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save Alternate Vendor");
		
		log.info("Step AddEditMaterial_001 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditMaterial_001 - 13: Input new Material");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ItemCode", newMaterial);
		
		log.info("Step AddEditMaterial_001 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_MaterialDescription"), "new description");
		
		log.info("VP: All dropdowns are saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_CommodityCode"), commodity1);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_UnitMeasure"), unitOfMeasure1);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ExpeditorID"), primaryUserName);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BuyerID"), primaryUserName);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Rank"), "Level 1");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode1));
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_PVendor", vendorName1));
		
		log.info("VP: All textfield saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_EconomicOrderQty"), "11.0000");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_StandardUnitCost"), "11.0000");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_RoutingCode"), "rocode1");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_InspectionCode"), "inscode1");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_QuoteLeadDays"), "11");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Maxdays"), "11");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_material_manufacturer"), "11");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_material_part_number"), "11");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorItemNum"), "11");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorItemPrice"), "11.0000");
		
		log.info("VP: Alternate vendor is displayed correctly");
		verifyTrue(masterFilesPage.isAlternateVendorRecordDisplayedCorrectly(vendorName2, "11", "11.0000"));
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Material works")
	public void AddEditMaterial_002_CheckEditMaterialWorks() {	
		
		log.info("Step AddEditMaterial_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_002 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_002 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_002 - 04: Open Add labels page");
		log.info("Step AddEditMaterial_002 - 05: Input new Material");
		log.info("Step AddEditMaterial_002 - 06: Click on Add button");
		log.info("Step AddEditMaterial_002 - 07: Input Description");
		log.info("Step AddEditMaterial_002 - 08: Select Primary user");
		log.info("Step AddEditMaterial_002 - 09: Input Primary vendor");
		log.info("Step AddEditMaterial_002 - 10: Click on Add Alternate vendor button");
		log.info("Step AddEditMaterial_002 - 10: Input Alternate vendor");
		log.info("Step AddEditMaterial_002 - 12: Click on Save Alternate Vendor button");
		log.info("Step AddEditMaterial_002 - 12: Click on Save button");
		log.info("Step AddEditMaterial_002 - 13: Input new Material");
		log.info("Step AddEditMaterial_002 - 14: Click on Modify button");
		log.info("Step AddEditMaterial_002 - 15: Change description");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_MaterialDescription", "new description 2");
		
		log.info("Step AddEditMaterial_002 - 16: Remove Alternate");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditMaterial_002 - 08: Select all dropdowns");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_CommodityCode", commodity2);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UnitMeasure", unitOfMeasure2);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ExpeditorID", primaryUserName2);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BuyerID", primaryUserName2);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Rank", "Level 2");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode2);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_PVendor", vendorName2);
		
		log.info("Step AddEditMaterial_002 - 09: Input all textfield");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_EconomicOrderQty", "12.0000");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_StandardUnitCost", "12.0000");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_RoutingCode", "rocode2");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_InspectionCode", "inscode2");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_QuoteLeadDays", "12");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Maxdays", "12");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_material_manufacturer", "12");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_material_part_number", "12");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorItemNum", "12");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorItemPrice", "12.0000");
		
		log.info("Step AddEditMaterial_002 - 10: Click on Add Alternate vendor button");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "add_alt_vendor");
		
		log.info("Step AddEditMaterial_002 - 10: Input Alternate vendor");
		masterFilesPage.inputTextfieldByIDWithEnter(DriverManager.getDriver(), "txt_AVendor", vendorName1);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AVendorItemNum", "12");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AVendorItemPrice", "12.0000");
		masterFilesPage.sleep();
		
		log.info("Step AddEditMaterial_002 - 12: Click on Save Alternate Vendor button");
		masterFilesPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save Alternate Vendor");
		
		log.info("Step AddEditMaterial_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditMaterial_002 - 13: Input new Material");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ItemCode", newMaterial);
		
		log.info("Step AddEditMaterial_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_MaterialDescription"), "new description 2");
		
		log.info("VP: All dropdowns are saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_CommodityCode"), commodity2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_UnitMeasure"), unitOfMeasure2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ExpeditorID"), primaryUserName2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BuyerID"), primaryUserName2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Rank"), "Level 2");
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_GlAccount", glAccountCode2));
		verifyTrue(masterFilesPage.isSuggestionDropdownDisplayedCorrectly(DriverManager.getDriver(), "div_PVendor", vendorName2));
		
		log.info("VP: All textfield saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_EconomicOrderQty"), "12.0000");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_StandardUnitCost"), "12.0000");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_RoutingCode"), "rocode2");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_InspectionCode"), "inscode2");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_QuoteLeadDays"), "12");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Maxdays"), "12");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_material_manufacturer"), "12");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_material_part_number"), "12");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorItemNum"), "12");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_VendorItemPrice"), "12.0000");
		
		log.info("VP: Alternate vendor is displayed correctly");
		verifyTrue(masterFilesPage.isAlternateVendorRecordDisplayedCorrectly(vendorName1, "12", "12.0000"));
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Material works")
	public void AddEditMaterial_003_CheckDeactivateMaterialWorks() {	
		
		log.info("Step AddEditMaterial_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_003 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_003 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_003 - 04: Open Add labels page");
		log.info("Step AddEditMaterial_003 - 05: Input new Material");
		log.info("Step AddEditMaterial_003 - 06: Click on Add button");
		log.info("Step AddEditMaterial_003 - 07: Input Description");
		log.info("Step AddEditMaterial_003 - 08: Click on Save button");
		log.info("Step AddEditMaterial_003 - 09: Input new Material");
		log.info("Step AddEditMaterial_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditMaterial_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditMaterial_003 - 12: Input new Material");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ItemCode", newMaterial);
		
		log.info("Step AddEditMaterial_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Item Code is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Item Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Material works")
	public void AddEditMaterial_004_CheckReactivateMaterialWorks() {	
		
		log.info("Step AddEditMaterial_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_004 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_004 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_004 - 04: Open Add labels page");
		log.info("Step AddEditMaterial_004 - 05: Input new Material");
		log.info("Step AddEditMaterial_004 - 06: Click on Add button");
		log.info("Step AddEditMaterial_004 - 07: Input Description");
		log.info("Step AddEditMaterial_004 - 08: Click on Save button");
		log.info("Step AddEditMaterial_004 - 09: Input new Material");
		log.info("Step AddEditMaterial_004 - 10: Click on Deactivate button");
		log.info("Step AddEditMaterial_004 - 11: Accept alert");
		log.info("Step AddEditMaterial_004 - 12: Input new Material");
		log.info("Step AddEditMaterial_004 - 13: Click on Modify button");
		log.info("Step AddEditMaterial_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Material code by Catalog Code works")
	public void AddEditMaterial_005_SearchMaterialByCatalogCode() {	
		
		log.info("Step AddEditMaterial_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_005 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_005 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_005 - 04: Open Add labels page");
		log.info("Step AddEditMaterial_005 - 05: Input new Material code");
		log.info("Step AddEditMaterial_005 - 06: Click on Add button");
		log.info("Step AddEditMaterial_005 - 07: Input Description");
		log.info("Step AddEditMaterial_005 - 08: Click on Save button");
		log.info("Step AddEditMaterial_005 - 09: Create new catalog for item code");
		masterFilesPage.createNewCataloge(newMaterial, "new description 2");
		
		log.info("Step AddEditMaterial_005 - 10: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_material.php");
		
		log.info("Step AddEditMaterial_005 - 11: Select Catalog");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Catalog", newMaterial+" : "+newMaterial);
		
		log.info("Step AddEditMaterial_005 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Material code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newMaterial, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Material code by Corporation works")
	public void AddEditMaterial_006_SearchMaterialByCorporation() {	
		
		log.info("Step AddEditMaterial_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_006 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_006 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_006 - 04: Open Add labels page");
		log.info("Step AddEditMaterial_006 - 05: Input new Material code");
		log.info("Step AddEditMaterial_006 - 06: Click on Add button");
		log.info("Step AddEditMaterial_006 - 07: Input Description");
		log.info("Step AddEditMaterial_006 - 08: Click on Save button");
		log.info("Step AddEditMaterial_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_material.php");
		
		log.info("Step AddEditMaterial_006 - 10: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditMaterial_006 - 11: Select Catalog");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Catalog", newMaterial+" : "+newMaterial);
		
		log.info("Step AddEditMaterial_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Material code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newMaterial, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Material code by Description works")
	public void AddEditMaterial_007_SearchMaterialByDescription() {	
		
		log.info("Step AddEditMaterial_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_007 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_007 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_007 - 04: Open Add labels page");
		log.info("Step AddEditMaterial_007 - 05: Input new Material code");
		log.info("Step AddEditMaterial_007 - 06: Click on Add button");
		log.info("Step AddEditMaterial_007 - 07: Input Description");
		log.info("Step AddEditMaterial_007 - 08: Click on Save button");
		log.info("Step AddEditMaterial_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_material.php");
		
		log.info("Step AddEditMaterial_005 - 10: Select Catalog");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Catalog", newMaterial+" : "+newMaterial);
		
		log.info("Step AddEditMaterial_007 - 11: Input Material Code description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		
		log.info("Step AddEditMaterial_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Material code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newMaterial, "new description 2"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Material code by Commodity Code works")
	public void AddEditMaterial_008_SearchMaterialByCommodityCode() {	
		
		log.info("Step AddEditMaterial_008 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_008 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_008 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_008 - 04: Open Add labels page");
		log.info("Step AddEditMaterial_008 - 05: Input new Material code");
		log.info("Step AddEditMaterial_008 - 06: Click on Add button");
		log.info("Step AddEditMaterial_008 - 07: Input Description");
		log.info("Step AddEditMaterial_008 - 08: Click on Save button");
		log.info("Step AddEditMaterial_008 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_material.php");
		
		log.info("Step AddEditMaterial_005 - 10: Select Catalog");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Catalog", newMaterial+" : "+newMaterial);
		
		log.info("Step AddEditMaterial_005 - 11: Select Commodity code");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_CommCode", commodity2);
		
		log.info("Step AddEditMaterial_008 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Material code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newMaterial, commodCode2));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Material code by Vendor Item code works")
	public void AddEditMaterial_009_SearchMaterialByVendorItemCode() {	
		
		log.info("Step AddEditMaterial_009 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_009 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_009 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_009 - 04: Open Add labels page");
		log.info("Step AddEditMaterial_009 - 05: Input new Material code");
		log.info("Step AddEditMaterial_009 - 06: Click on Add button");
		log.info("Step AddEditMaterial_009 - 07: Input Description");
		log.info("Step AddEditMaterial_009 - 08: Click on Save button");
		log.info("Step AddEditMaterial_009 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_material.php");
		
		log.info("Step AddEditMaterial_005 - 10: Select Catalog");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Catalog", newMaterial+" : "+newMaterial);
		
		log.info("Step AddEditMaterial_009 - 11: Input Vendor Item Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VendorItemNumber", "12");
		
		log.info("Step AddEditMaterial_009 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Material code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newMaterial, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Material code by Key word works")
	public void AddEditMaterial_010_SearchMaterialByKeyWord() {	
		
		log.info("Step AddEditMaterial_010 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditMaterial_010 - 02: Input correct username and password");
		log.info("Step AddEditMaterial_010 - 03: Accept Alert message");
		log.info("Step AddEditMaterial_010 - 04: Open Add labels page");
		log.info("Step AddEditMaterial_010 - 05: Input new Material code");
		log.info("Step AddEditMaterial_010 - 06: Click on Add button");
		log.info("Step AddEditMaterial_010 - 07: Input Description");
		log.info("Step AddEditMaterial_010 - 08: Click on Save button");
		log.info("Step AddEditMaterial_010 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_material.php");
		
		log.info("Step AddEditMaterial_005 - 10: Select Catalog");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Catalog", newMaterial+" : "+newMaterial);
		
		log.info("Step AddEditMaterial_010 - 11: Input Key word");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Keyword", "new");
		
		log.info("Step AddEditMaterial_010 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Material code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newMaterial, "new"));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private AddUserPage addUserPage;
	private String newMaterial;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String primaryBuyerID2, primaryBuyerFirstName2, primaryBuyerLastName2, primaryUserRole2, primaryUserName2;
	private String vendorID1, vendorName1;
	private String vendorID2, vendorName2;
	private String commodCode1, commodCode2, commodity1, commodity2;
	private String glAccountCode1, glAccountCode2;
	private String unitOfMeasure1, unitOfMeasure2;
}
