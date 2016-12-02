package InvoicesPage;

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
import page.LoginPage;

public class Invoices_01_AddEditBatchInfo extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		poPage = PageFactory.getPOPage(DriverManager.getDriver(), ipClient);
		
		newBatchInfo = getUniqueText(5);
		
		bankCode1 = "te1";
		bank1 = bankCode1+ " : "+bankCode1;
		bankCode2 = "te2";
		bank2 = bankCode2+ " : "+bankCode2;
		
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create new Terms code");
		masterFilesPage.createNewBankCode(bankCode1);
		masterFilesPage.createNewBankCode(bankCode2);
		
	}

	@Test(groups = { "regression" }, description = "Check Add Batch Info works")
	public void AddEditBatchInfo_001_CheckAddBatchInfoWorks() {	
		
		log.info("Step AddEditBatchInfo_001 - 01: Open Add Batch Info page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/invoice/add_batch_info.php");

		log.info("Step AddEditBatchInfo_001 - 02: Input new Batch Info");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchNum", newBatchInfo);
		
		log.info("Step AddEditBatchInfo_001 - 04: Click on Add button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add.gif");
		
		log.info("Step AddEditBatchInfo_001 - 05: Select Bank code");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BankCode", bank1);
		
		log.info("Step AddEditBatchInfo_001 - 06: Input all textfield");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod", "01/2020");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchDate", "11-11-2020");
		
		log.info("Step AddEditBatchInfo_002 - 11: Click on Save button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBatchInfo_001 - 12: Input new Batch Info");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchNum", newBatchInfo);
		
		log.info("Step AddEditBatchInfo_001 - 13: Click on Modify button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		poPage.acceptAlert(DriverManager.getDriver());
		//Check saved correctly
		
		log.info("Step AddEditBatchInfo_001 - VP: Bank code is saved correctly");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BankCode"), bank1);
		
		log.info("Step AddEditBatchInfo_001 - VP: Account period and Batch description displayed correctly");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod"), "01/2020");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_BatchDate"), "11-11-2020");
	}
	
	@Test(groups = { "regression" }, description = "Check Add Batch Info works")
	public void AddEditBatchInfo_002_CheckEditBatchInfoWorks() {	
		
		log.info("Step AddEditBatchInfo_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBatchInfo_002 - 02: Input correct username and password");
		log.info("Step AddEditBatchInfo_002 - 03: Accept Alert message");
		log.info("Step AddEditBatchInfo_002 - 04: Open Add labels page");
		log.info("Step AddEditBatchInfo_002 - 05: Input new Batch Info");
		log.info("Step AddEditBatchInfo_002 - 06: Click on Add button");
		log.info("Step AddEditBatchInfo_002 - 07: Input Description");
		log.info("Step AddEditBatchInfo_002 - 08: Click on Save button");
		log.info("Step AddEditBatchInfo_002 - 09: Input new Batch Info");
		log.info("Step AddEditBatchInfo_002 - 10: Click on Modify button");
		log.info("Step AddEditBatchInfo_001 - 05: Select Bank code");
		poPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BankCode", bank2);
		
		log.info("Step AddEditBatchInfo_001 - 06: Input all textfield");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod", "02/2020");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchDate", "12-12-2020");
		
		log.info("Step AddEditBatchInfo_002 - 11: Click on Save button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBatchInfo_001 - 12: Input new Batch Info");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchNum", newBatchInfo);
		
		log.info("Step AddEditBatchInfo_001 - 13: Click on Modify button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		poPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBatchInfo_001 - VP: Bank code is saved correctly");
		verifyEquals(poPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BankCode"), bank2);
		
		log.info("Step AddEditBatchInfo_001 - VP: Account period and Batch description displayed correctly");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod"), "02/2020");
		verifyEquals(poPage.getTextfieldByID(DriverManager.getDriver(), "txt_BatchDate"), "12-12-2020");
	}
	
	@Test(groups = { "regression" }, description = "Check Delete Batch Info works")
	public void AddEditBatchInfo_003_CheckDeleteBatchInfoWorks() {	
		
		log.info("Step AddEditBatchInfo_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBatchInfo_003 - 02: Input correct username and password");
		log.info("Step AddEditBatchInfo_003 - 03: Accept Alert message");
		log.info("Step AddEditBatchInfo_003 - 04: Open Add labels page");
		log.info("Step AddEditBatchInfo_003 - 05: Input new Batch Info");
		log.info("Step AddEditBatchInfo_003 - 06: Click on Add button");
		log.info("Step AddEditBatchInfo_003 - 07: Input Description");
		log.info("Step AddEditBatchInfo_003 - 08: Click on Save button");
		log.info("Step AddEditBatchInfo_003 - 09: Input new Batch Info");
		log.info("Step AddEditBatchInfo_003 - 10: Click on Delete button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBatchInfo_003 - 11: Input new Batch Info");
		poPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchNum", newBatchInfo);
		
		log.info("Step AddEditBatchInfo_003 - 12: Click on Modify button");
		poPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Batch Info is not displayed");
		verifyFalse(masterFilesPage.isTextDisplayed(DriverManager.getDriver(), newBatchInfo));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private POPage poPage;
	private String newBatchInfo;
	private String bank1, bank2, bankCode1, bankCode2;
}
