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
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
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
		
		log.info("Step AddEditTermsCode_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditTermsCode_001 - 09: Input new Terms Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", newTermsCode);
		
		log.info("Step AddEditTermsCode_001 - 10: Click on Modify button");
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
		log.info("Step AddEditTermsCode_002 - 04: Open Add labels page");
		log.info("Step AddEditTermsCode_002 - 05: Input new Terms Code");
		log.info("Step AddEditTermsCode_002 - 06: Click on Add button");
		log.info("Step AddEditTermsCode_002 - 07: Input Description");
		log.info("Step AddEditTermsCode_002 - 08: Click on Save button");
		log.info("Step AddEditTermsCode_002 - 09: Input new Terms Code");
		log.info("Step AddEditTermsCode_002 - 10: Click on Modify button");
		log.info("Step AddEditTermsCode_002 - 11: Change Terms type");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_TermsId", "Proximo");
		
		log.info("Step AddEditTermsCode_001 - 08: Input all other textfields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description 2");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscountPercent", "22.22");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DiscountDays", "22");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DueDays", "22");
		
		log.info("Step AddEditTermsCode_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditTermsCode_002 - 13: Input new Terms Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TermsCode", newTermsCode);
		
		log.info("Step AddEditTermsCode_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Term type is selected");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_TermsId"), "Proximo");
		
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
		log.info("Step AddEditTermsCode_003 - 04: Open Add labels page");
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
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Terms code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Terms Code works")
	public void AddEditTermsCode_004_CheckReactivateTermsCodeWorks() {	
		
		log.info("Step AddEditTermsCode_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTermsCode_004 - 02: Input correct username and password");
		log.info("Step AddEditTermsCode_004 - 03: Accept Alert message");
		log.info("Step AddEditTermsCode_004 - 04: Open Add labels page");
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
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newTermsCode;
}
