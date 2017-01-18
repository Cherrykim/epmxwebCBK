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
import page.InvoicesPage;
import page.LoginPage;

public class Invoices_01_AddEditBatchInfo extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		invoicesPage = PageFactory.getInvoicesPage(DriverManager.getDriver(), ipClient);
		
		newBatchInfo = getUniqueText(5);
		
		bankCode1 = "te1";
		bank1 = bankCode1+ " : "+bankCode1;
		bankCode2 = "te2";
		bank2 = bankCode2+ " : "+bankCode2;
		
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
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
		invoicesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchNum", newBatchInfo);
		
		log.info("Step AddEditBatchInfo_001 - 04: Click on Add button");
		invoicesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add.gif");
		
		log.info("Step AddEditBatchInfo_001 - 05: Select Bank code");
		invoicesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BankCode", bank1);
		
		log.info("Step AddEditBatchInfo_001 - 06: Input all textfield");
		invoicesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod", "01/2020");
		invoicesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchDate", "11-11-2020");
		
		log.info("Step AddEditBatchInfo_002 - 11: Click on Save button");
		invoicesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBatchInfo_001 - 12: Input new Batch Info");
		invoicesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchNum", newBatchInfo);
		
		log.info("Step AddEditBatchInfo_001 - 13: Click on Modify button");
		invoicesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		invoicesPage.acceptAlert(DriverManager.getDriver());
		//Check saved correctly
		
		log.info("Step AddEditBatchInfo_001 - VP: Bank code is saved correctly");
		verifyEquals(invoicesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BankCode"), bank1);
		
		log.info("Step AddEditBatchInfo_001 - VP: Account period and Batch description displayed correctly");
		verifyEquals(invoicesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod"), "01/2020");
		verifyEquals(invoicesPage.getTextfieldByID(DriverManager.getDriver(), "txt_BatchDate"), "11-11-2020");
		
		log.info("Step AddEditBatchInfo_001 - 14: Get Batch date");
		batchDate = invoicesPage.getTextfieldByID(DriverManager.getDriver(), "txt_BatchDate");

	}
	
	@Test(groups = { "regression" }, description = "Check Add Batch Info works")
	public void AddEditBatchInfo_002_CheckEditBatchInfoWorks() {	
		
		log.info("Step AddEditBatchInfo_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBatchInfo_002 - 02: Input correct username and password");
		log.info("Step AddEditBatchInfo_002 - 03: Accept Alert message");
		log.info("Step AddEditBatchInfo_002 - 04: Open Add Batch info page page");
		log.info("Step AddEditBatchInfo_002 - 05: Input new Batch Info");
		log.info("Step AddEditBatchInfo_002 - 06: Click on Add button");
		log.info("Step AddEditBatchInfo_002 - 07: Input BatchDate");
		log.info("Step AddEditBatchInfo_002 - 08: Click on Save button");
		log.info("Step AddEditBatchInfo_002 - 09: Input new Batch Info");
		log.info("Step AddEditBatchInfo_002 - 10: Click on Modify button");
		log.info("Step AddEditBatchInfo_002 - 11: Select Bank code");
		invoicesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BankCode", bank2);
		
		log.info("Step AddEditBatchInfo_002 - 12: Input all textfield");
		invoicesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod", "02/2020");
		invoicesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchDate", "12-12-2020");
		
		log.info("Step AddEditBatchInfo_002 - 13: Click on Save button");
		invoicesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditBatchInfo_002 - 14: Input new Batch Info");
		invoicesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchNum", newBatchInfo);
		
		log.info("Step AddEditBatchInfo_002 - 15: Click on Modify button");
		invoicesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		invoicesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBatchInfo_002 - VP: Bank code is saved correctly");
		verifyEquals(invoicesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_BankCode"), bank2);
		
		log.info("Step AddEditBatchInfo_002 - VP: Account period and Batch description displayed correctly");
		verifyEquals(invoicesPage.getTextfieldByID(DriverManager.getDriver(), "txt_AccPeriod"), "02/2020");
		verifyEquals(invoicesPage.getTextfieldByID(DriverManager.getDriver(), "txt_BatchDate"), "12-12-2020");
		}
	
	@Test(groups = { "regression" }, description = "Check Search Batch info by Batch Date works")
	public void AddEditBatchInfo_003_SearchBatchInfoByBatchDate() {	
		
		log.info("Step AddEditBatchInfo_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBatchInfo_003 - 02: Input correct username and password");
		log.info("Step AddEditBatchInfo_003 - 03: Accept Alert message");
		log.info("Step AddEditBatchInfo_003 - 04: Open Add Batch info page page");
		log.info("Step AddEditBatchInfo_003 - 05: Input new Batch info");
		log.info("Step AddEditBatchInfo_003 - 06: Click on Add button");
		log.info("Step AddEditBatchInfo_003 - 07: Input BatchDate");
		log.info("Step AddEditBatchInfo_003 - 08: Click on Save button");
		log.info("Step AddEditBatchInfo_003 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/invoice/manage_batch_info.php");
		
		log.info("Step AddEditBatchInfo_003 - 10: Click on Clear button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "clear.gif");
		
		log.info("Step AddEditBatchInfo_003 - 11: Input Batch date");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchDate", batchDate);
		
		log.info("Step AddEditBatchInfo_003 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Batch info displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newBatchInfo, batchDate));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Batch info by Users works")
	public void AddEditBatchInfo_004_SearchBatchInfoByUser() {	
		
		log.info("Step AddEditBatchInfo_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBatchInfo_004 - 02: Input correct username and password");
		log.info("Step AddEditBatchInfo_004 - 03: Accept Alert message");
		log.info("Step AddEditBatchInfo_004 - 04: Open Add Batch info page page");
		log.info("Step AddEditBatchInfo_004 - 05: Input new Batch info");
		log.info("Step AddEditBatchInfo_004 - 06: Click on Add button");
		log.info("Step AddEditBatchInfo_004 - 07: Input BatchDate");
		log.info("Step AddEditBatchInfo_004 - 08: Click on Save button");
		log.info("Step AddEditBatchInfo_004 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/invoice/manage_batch_info.php");
		
		log.info("Step AddEditBatchInfo_004 - 10: Click on Clear button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "clear.gif");
		
		log.info("Step AddEditBatchInfo_004 - 11: Input Batch date");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchDate", batchDate);
		
		log.info("Step AddEditBatchInfo_004 - 12: Select User");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_BuyerId", "Tammi Stock");
		
		log.info("Step AddEditBatchInfo_004 - 13: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Batch info displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newBatchInfo, "Tammi Stock"));
	}
	
	@Test(groups = { "regression" }, description = "Check Delete Batch Info works")
	public void AddEditBatchInfo_005_CheckDeleteBatchInfoWorks() {	
		
		log.info("Step AddEditBatchInfo_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditBatchInfo_005 - 02: Input correct username and password");
		log.info("Step AddEditBatchInfo_005 - 03: Accept Alert message");
		
		log.info("Step AddEditBatchInfo_005 - 04: Open Add Batch info page page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/invoice/add_batch_info.php");
		
		log.info("Step AddEditBatchInfo_005 - 05: Input new Batch Info");
		log.info("Step AddEditBatchInfo_005 - 06: Click on Add button");
		log.info("Step AddEditBatchInfo_005 - 07: Input All fields");
		log.info("Step AddEditBatchInfo_005 - 08: Click on Save button");
		log.info("Step AddEditBatchInfo_005 - 09: Input new Batch Info");
		invoicesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchNum", newBatchInfo);
		
		log.info("Step AddEditBatchInfo_002 - 10: Click on Modify button");
		invoicesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		invoicesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBatchInfo_005 - 11: Click on Delete button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditBatchInfo_005 - 12: Input new Batch Info");
		invoicesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BatchNum", newBatchInfo);
		
		log.info("Step AddEditBatchInfo_005 - 13: Click on Modify button");
		invoicesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Batch Info is not displayed");
		verifyFalse(masterFilesPage.isTextDisplayed(DriverManager.getDriver(), newBatchInfo));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private InvoicesPage invoicesPage;
	private String newBatchInfo;
	private String bank1, bank2, bankCode1, bankCode2;
	private String batchDate;
}
