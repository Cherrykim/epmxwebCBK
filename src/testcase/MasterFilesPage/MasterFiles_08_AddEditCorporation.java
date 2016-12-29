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

public class MasterFiles_08_AddEditCorporation extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		
		newCorporation = getUniqueText(10);
		primaryBuyerID = "110320161";
		primaryBuyerFirstName = "Primary";
		primaryBuyerLastName = "Buyer";
		primaryUserName = "Primary Buyer";
		primaryUserRole = "Requesters";
		log.info("Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		log.info("Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		log.info("Pre-condition - 04: Open Add user page");
		log.info("Pre-condition - 05: Create new Buyer");
		addUserPage.createNewUserWithRole(primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, "qa1@mailinator.com", primaryUserRole);
	}

	@Test(groups = { "regression" }, description = "Check Add Corporation works")
	public void AddCorporation_001_CheckAddCorporationWorks() {	
		
		log.info("Step AddCorporation_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCorporation_001 - 02: Input correct username and password");
		log.info("Step AddCorporation_001 - 03: Accept Alert message");
		log.info("Step AddCorporation_001 - 04: Open Add Corporation page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_corporation.php");

		log.info("Step AddCorporation_001 - 05: Input new Corporation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CompName", newCorporation);
		
		log.info("Step AddCorporation_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddCorporation_001 - 07: Get Date Entered");
		dateEntered = masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_DateEntered");
		
		log.info("Step AddCorporation_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddCorporation_001 - 09: Input new Corporation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CompName", newCorporation);
		
		log.info("Step AddCorporation_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Date entered field is displayed correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_DateEntered"), masterFilesPage.convertDate("dd-MM-yyyy", "MM-dd-yyyy", dateEntered));
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Corporation works")
	public void AddCorporation_002_CheckEditCorporationWorks() {	
		
		log.info("Step AddCorporation_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCorporation_002 - 02: Input correct username and password");
		log.info("Step AddCorporation_002 - 03: Accept Alert message");
		log.info("Step AddCorporation_002 - 04: Open Add Corporation page");
		log.info("Step AddCorporation_002 - 05: Input new Corporation");
		log.info("Step AddCorporation_002 - 06: Click on Add button");
		log.info("Step AddCorporation_002 - 07: Click on Save button");
		log.info("Step AddCorporation_002 - 08: Input new Corporation");
		log.info("Step AddCorporation_002 - 09: Click on Modify button");
		log.info("Step AddCorporation_002 - 10: Select Buyer");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BuyerID", primaryUserName);
		
		log.info("Step AddCorporation_002 - 11: Select Expeditor ");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ExpeditorID", primaryUserName);
		
		log.info("Step AddCorporation_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddCorporation_002 - 13: Input new Corporation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CompName", newCorporation);
		
		log.info("Step AddCorporation_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Buyer is saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BuyerID"), primaryUserName);
		
		log.info("VP: Expeditor is saved correctly");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ExpeditorID"), primaryUserName);
		
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Corporation works")
	public void AddCorporation_003_CheckDeactivateCorporationWorks() {	
		
		log.info("Step AddCorporation_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCorporation_003 - 02: Input correct username and password");
		log.info("Step AddCorporation_003 - 03: Accept Alert message");
		log.info("Step AddCorporation_003 - 04: Open Add Corporation page");
		log.info("Step AddCorporation_003 - 05: Input new Corporation");
		log.info("Step AddCorporation_003 - 06: Click on Add button");
		log.info("Step AddCorporation_003 - 07: Input Description");
		log.info("Step AddCorporation_003 - 08: Click on Save button");
		log.info("Step AddCorporation_003 - 09: Input new Corporation");
		log.info("Step AddCorporation_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddCorporation_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddCorporation_003 - 12: Input new Corporation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_CompName", newCorporation);
		
		log.info("Step AddCorporation_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Corporation is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Corporation is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Corporation works")
	public void AddCorporation_004_CheckReactivateCorporationWorks() {	
		
		log.info("Step AddCorporation_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddCorporation_004 - 02: Input correct username and password");
		log.info("Step AddCorporation_004 - 03: Accept Alert message");
		log.info("Step AddCorporation_004 - 04: Open Add Corporation page");
		log.info("Step AddCorporation_004 - 05: Input new Corporation");
		log.info("Step AddCorporation_004 - 06: Click on Add button");
		log.info("Step AddCorporation_004 - 07: Input Description");
		log.info("Step AddCorporation_004 - 08: Click on Save button");
		log.info("Step AddCorporation_004 - 09: Input new Corporation");
		log.info("Step AddCorporation_004 - 10: Click on Deactivate button");
		log.info("Step AddCorporation_004 - 11: Accept alert");
		log.info("Step AddCorporation_004 - 12: Input new Corporation");
		log.info("Step AddCorporation_004 - 13: Click on Modify button");
		log.info("Step AddCorporation_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Corporation code by Corporation works")
	public void AddEditCorporationCode_005_SearchCorporationCodeByCorporation() {	
		
		log.info("Step AddEditCorporationCode_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditCorporationCode_005 - 02: Input correct username and password");
		log.info("Step AddEditCorporationCode_005 - 03: Accept Alert message");
		log.info("Step AddEditCorporationCode_005 - 04: Open Add Corporation page");
		log.info("Step AddEditCorporationCode_005 - 05: Input new Corporation code");
		log.info("Step AddEditCorporationCode_005 - 06: Click on Add button");
		log.info("Step AddEditCorporationCode_005 - 07: Input Description");
		log.info("Step AddEditCorporationCode_005 - 08: Click on Save button");
		log.info("Step AddEditCorporationCode_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_corporation.php");
		
		log.info("Step AddEditCorporationCode_005 - 10: Input Corporation");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditCorporationCode_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Corporation code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), Constant.DefaultValue.CORPORATION, ""));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private AddUserPage addUserPage;
	private String newCorporation;
	private String primaryBuyerID, primaryBuyerFirstName, primaryBuyerLastName, primaryUserRole, primaryUserName;
	private String dateEntered;
}
