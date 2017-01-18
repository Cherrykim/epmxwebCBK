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
import page.LoginPage;

public class MasterFiles_23_AddEditTermsCode extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newTermsCode = getUniqueText(3);
	}

	@Test(groups = { "regression" }, description = "Check Add Terms Code works")
	public void AddEditTermsCode_001_CheckAddTermsCodeWorks() {	
		
		log.info("Step AddEditTermsCode_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTermsCode_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditTermsCode_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditTermsCode_001 - 04: Open Add Terms Code page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_terms_code.php");

		log.info("Step AddEditTermsCode_001 - 05: Input new Terms Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", newTermsCode);
		
		log.info("Step AddEditTermsCode_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditTermsCode_001 - 07: Select Terms type");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TermsId", "Normal");
		
		log.info("Step AddEditTermsCode_001 - 08: Input all other textfields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscountPercent", "11.11");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscountDays", "11");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DueDays", "11");
		
		log.info("Step AddEditTermsCode_001 - 09: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditTermsCode_001 - 10: Input new Terms Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", newTermsCode);
		
		log.info("Step AddEditTermsCode_001 - 11: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Term type is selected");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TermsId"), "Normal");
		
		log.info("VP: All other textfields are saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_DiscountPercent"), "11.11");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_DiscountDays"), "11");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_DueDays"), "11");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Terms Code works")
	public void AddEditTermsCode_002_CheckEditTermsCodeWorks() {	
		
		log.info("Step AddEditTermsCode_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTermsCode_002 - 02: Input correct username and password");
		log.info("Step AddEditTermsCode_002 - 03: Accept Alert message");
		log.info("Step AddEditTermsCode_002 - 04: Open Add Terms Code page");
		log.info("Step AddEditTermsCode_002 - 05: Input new Terms Code");
		log.info("Step AddEditTermsCode_002 - 06: Click on Add button");
		log.info("Step AddEditTermsCode_002 - 07: Input Description");
		log.info("Step AddEditTermsCode_002 - 08: Click on Save button");
		log.info("Step AddEditTermsCode_002 - 09: Input new Terms Code");
		log.info("Step AddEditTermsCode_002 - 10: Click on Modify button");
		log.info("Step AddEditTermsCode_002 - 11: Change Terms type");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TermsId", "Late Charge");
		
		log.info("Step AddEditTermsCode_001 - 12: Input all other textfields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscountPercent", "22.22");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscountDays", "22");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DueDays", "22");
		
		log.info("Step AddEditTermsCode_002 - 13: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditTermsCode_002 - 14: Input new Terms Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", newTermsCode);
		
		log.info("Step AddEditTermsCode_002 - 15: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Term type is selected");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TermsId"), "Late Charge");
		
		log.info("VP: All other textfields are saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description 2");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_DiscountPercent"), "22.22");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_DiscountDays"), "22");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_DueDays"), "22");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Terms Code works")
	public void AddEditTermsCode_003_CheckDeactivateTermsCodeWorks() {	
		
		log.info("Step AddEditTermsCode_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTermsCode_003 - 02: Input correct username and password");
		log.info("Step AddEditTermsCode_003 - 03: Accept Alert message");
		log.info("Step AddEditTermsCode_003 - 04: Open Add Terms Code page");
		log.info("Step AddEditTermsCode_003 - 05: Input new Terms Code");
		log.info("Step AddEditTermsCode_003 - 06: Click on Add button");
		log.info("Step AddEditTermsCode_003 - 07: Input Description");
		log.info("Step AddEditTermsCode_003 - 08: Click on Save button");
		log.info("Step AddEditTermsCode_003 - 09: Input new Terms Code");
		log.info("Step AddEditTermsCode_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditTermsCode_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditTermsCode_003 - 12: Input new Terms Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", newTermsCode);
		
		log.info("Step AddEditTermsCode_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Terms Code is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Terms Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Terms Code works")
	public void AddEditTermsCode_004_CheckReactivateTermsCodeWorks() {	
		
		log.info("Step AddEditTermsCode_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTermsCode_004 - 02: Input correct username and password");
		log.info("Step AddEditTermsCode_004 - 03: Accept Alert message");
		log.info("Step AddEditTermsCode_004 - 04: Open Add Terms Code page");
		log.info("Step AddEditTermsCode_004 - 05: Input new Terms Code");
		log.info("Step AddEditTermsCode_004 - 06: Click on Add button");
		log.info("Step AddEditTermsCode_004 - 07: Input Description");
		log.info("Step AddEditTermsCode_004 - 08: Click on Save button");
		log.info("Step AddEditTermsCode_004 - 09: Input new Terms Code");
		log.info("Step AddEditTermsCode_004 - 10: Click on Deactivate button");
		log.info("Step AddEditTermsCode_004 - 11: Accept alert");
		log.info("Step AddEditTermsCode_004 - 12: Input new Terms Code");
		log.info("Step AddEditTermsCode_004 - 13: Click on Modify button");
		log.info("Step AddEditTermsCode_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Terms Code code by Code works")
	public void AddEditTermsCode_005_SearchTermsCodeByCode() {	
		
		log.info("Step AddEditTermsCode_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTermsCode_005 - 02: Input correct username and password");
		log.info("Step AddEditTermsCode_005 - 03: Accept Alert message");
		log.info("Step AddEditTermsCode_005 - 04: Open Add Terms Code page");
		log.info("Step AddEditTermsCode_005 - 05: Input new Terms Code code");
		log.info("Step AddEditTermsCode_005 - 06: Click on Add button");
		log.info("Step AddEditTermsCode_005 - 07: Input Description");
		log.info("Step AddEditTermsCode_005 - 08: Click on Save button");
		log.info("Step AddEditTermsCode_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_terms_code.php");
		
		log.info("Step AddEditTermsCode_005 - 10: Input Terms Code Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", newTermsCode);
		
		log.info("Step AddEditTermsCode_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Terms Code code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newTermsCode, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Terms Code code by Corporation works")
	public void AddEditTermsCode_006_SearchTermsCodeByCorporation() {	
		
		log.info("Step AddEditTermsCode_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTermsCode_006 - 02: Input correct username and password");
		log.info("Step AddEditTermsCode_006 - 03: Accept Alert message");
		log.info("Step AddEditTermsCode_006 - 04: Open Add Terms Code page");
		log.info("Step AddEditTermsCode_006 - 05: Input new Terms Code code");
		log.info("Step AddEditTermsCode_006 - 06: Click on Add button");
		log.info("Step AddEditTermsCode_006 - 07: Input Description");
		log.info("Step AddEditTermsCode_006 - 08: Click on Save button");
		log.info("Step AddEditTermsCode_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_terms_code.php");
		
		log.info("Step AddEditTermsCode_006 - 10: Input Terms Code Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", newTermsCode);
		
		log.info("Step AddEditTermsCode_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditTermsCode_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Terms Code code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newTermsCode, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Terms Code code by Description works")
	public void AddEditTermsCode_007_SearchTermsCodeByDescription() {	
		
		log.info("Step AddEditTermsCode_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTermsCode_007 - 02: Input correct username and password");
		log.info("Step AddEditTermsCode_007 - 03: Accept Alert message");
		log.info("Step AddEditTermsCode_007 - 04: Open Add Terms Code page");
		log.info("Step AddEditTermsCode_007 - 05: Input new Terms Code code");
		log.info("Step AddEditTermsCode_007 - 06: Click on Add button");
		log.info("Step AddEditTermsCode_007 - 07: Input Description");
		log.info("Step AddEditTermsCode_007 - 08: Click on Save button");
		log.info("Step AddEditTermsCode_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_terms_code.php");
		
		log.info("Step AddEditTermsCode_007 - 10: Input Terms Code Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", newTermsCode);
		
		log.info("Step AddEditTermsCode_007 - 11: Input Terms Code Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsDesc", "new description 2");
		
		log.info("Step AddEditTermsCode_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Terms Code code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newTermsCode, "new description 2"));
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newTermsCode;
}
