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

public class MasterFiles_22_AddEditTaxCode extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newTaxCode = getUniqueText(4);
	}

	@Test(groups = { "regression" }, description = "Check Add Tax Code works")
	public void AddEditTaxCode_001_CheckAddTaxCodeWorks() {	
		
		log.info("Step AddEditTaxCode_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTaxCode_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditTaxCode_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditTaxCode_001 - 04: Open Add Tax Code page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_tax_code.php");

		log.info("Step AddEditTaxCode_001 - 05: Input new Tax Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxCode", newTaxCode);
		
		log.info("Step AddEditTaxCode_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditTaxCode_001 - 07: Input Tax percent and Tax Authority");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Percent", "11.1111");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Authority", "Government");
		
		log.info("Step AddEditTaxCode_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditTaxCode_001 - 09: Input new Tax Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxCode", newTaxCode);
		
		log.info("Step AddEditTaxCode_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Tax percent and Tax Authority are saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Percent"), "11.1111");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Authority"), "Government");

	}
	
	@Test(groups = { "regression" }, description = "Check Edit Tax Code works")
	public void AddEditTaxCode_002_CheckEditTaxCodeWorks() {	
		
		log.info("Step AddEditTaxCode_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTaxCode_002 - 02: Input correct username and password");
		log.info("Step AddEditTaxCode_002 - 03: Accept Alert message");
		log.info("Step AddEditTaxCode_002 - 04: Open Add labels page");
		log.info("Step AddEditTaxCode_002 - 05: Input new Tax Code");
		log.info("Step AddEditTaxCode_002 - 06: Click on Add button");
		log.info("Step AddEditTaxCode_002 - 07: Input Description");
		log.info("Step AddEditTaxCode_002 - 08: Click on Save button");
		log.info("Step AddEditTaxCode_002 - 09: Input new Tax Code");
		log.info("Step AddEditTaxCode_002 - 10: Click on Modify button");
		log.info("Step AddEditTaxCode_002 - 11: Change Tax percent and Tax Authority");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Percent", "22.2222");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Authority", "Seller");
		
		log.info("Step AddEditTaxCode_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditTaxCode_002 - 13: Input new Tax Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxCode", newTaxCode);
		
		log.info("Step AddEditTaxCode_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Tax percent and Tax Authority are saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Percent"), "22.2222");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Authority"), "Seller");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Tax Code works")
	public void AddEditTaxCode_003_CheckDeactivateTaxCodeWorks() {	
		
		log.info("Step AddEditTaxCode_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTaxCode_003 - 02: Input correct username and password");
		log.info("Step AddEditTaxCode_003 - 03: Accept Alert message");
		log.info("Step AddEditTaxCode_003 - 04: Open Add labels page");
		log.info("Step AddEditTaxCode_003 - 05: Input new Tax Code");
		log.info("Step AddEditTaxCode_003 - 06: Click on Add button");
		log.info("Step AddEditTaxCode_003 - 07: Input Description");
		log.info("Step AddEditTaxCode_003 - 08: Click on Save button");
		log.info("Step AddEditTaxCode_003 - 09: Input new Tax Code");
		log.info("Step AddEditTaxCode_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditTaxCode_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditTaxCode_003 - 12: Input new Tax Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TaxCode", newTaxCode);
		
		log.info("Step AddEditTaxCode_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Tax Code is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Tax Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Tax Code works")
	public void AddEditTaxCode_004_CheckReactivateTaxCodeWorks() {	
		
		log.info("Step AddEditTaxCode_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditTaxCode_004 - 02: Input correct username and password");
		log.info("Step AddEditTaxCode_004 - 03: Accept Alert message");
		log.info("Step AddEditTaxCode_004 - 04: Open Add labels page");
		log.info("Step AddEditTaxCode_004 - 05: Input new Tax Code");
		log.info("Step AddEditTaxCode_004 - 06: Click on Add button");
		log.info("Step AddEditTaxCode_004 - 07: Input Description");
		log.info("Step AddEditTaxCode_004 - 08: Click on Save button");
		log.info("Step AddEditTaxCode_004 - 09: Input new Tax Code");
		log.info("Step AddEditTaxCode_004 - 10: Click on Deactivate button");
		log.info("Step AddEditTaxCode_004 - 11: Accept alert");
		log.info("Step AddEditTaxCode_004 - 12: Input new Tax Code");
		log.info("Step AddEditTaxCode_004 - 13: Click on Modify button");
		log.info("Step AddEditTaxCode_004 - 14: Accept alert");
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
	private String newTaxCode;
}
