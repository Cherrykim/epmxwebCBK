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

public class MasterFiles_09_AddEditTranslationCurrency extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		baseCurrencyCode = "ARS : Argentine Peso";
		newBaseCurrencyCode = "AED : UAE Dirham";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
	}

	@Test(groups = { "regression" }, description = "Check Add Translation Currency works")
	public void AddTranslationCurrency_001_CheckAddTranslationCurrencyWorks() {	
		
		log.info("Step AddTranslationCurrency_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddTranslationCurrency_001 - 02: Input correct username and password");
		log.info("Step AddTranslationCurrency_001 - 03: Accept Alert message");
		log.info("Step AddTranslationCurrency_001 - 04: Open Add Translation Currency page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_currency_translation.php");

		log.info("Step AddTranslationCurrency_001 - 05: Input new Translation Currency");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BaseCurCode", baseCurrencyCode);
		
		log.info("Step AddTranslationCurrency_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		masterFilesPage.switchAddAndModifyCurrency();
		
//		log.info("Step AddTranslationCurrency_001 - 07: Input Description");
//		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddTranslationCurrency_001 - 08: Click on Translation Currency item textfield button");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "txt_TransCurCode0");
		
		log.info("Step AddTranslationCurrency_001 - 09: Select  Translation Currency item");
		masterFilesPage.clickOnDivByItsText(DriverManager.getDriver(), baseCurrencyCode);
		
		log.info("Step AddTranslationCurrency_001 - 10: Input new Translation Currency");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TransRate0", "15.000000");
		
		log.info("Step AddTranslationCurrency_001 - 10: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddTranslationCurrency_001 - 11: Input new Translation Currency");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BaseCurCode", baseCurrencyCode);
		
		log.info("Step AddTranslationCurrency_001 - 12: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
//		log.info("VP: Description field is saved correctly");
//		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Description"), "new description");
		
		log.info("VP: First record is displayed correctly");
		verifyTrue(masterFilesPage.isFirstTranslationCurrencyCodeDisplayedCorrectly(baseCurrencyCode));
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Translation Currency works")
	public void AddTranslationCurrency_002_CheckEditTranslationCurrencyWorks() {	
		
		log.info("Step AddTranslationCurrency_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddTranslationCurrency_002 - 02: Input correct username and password");
		log.info("Step AddTranslationCurrency_002 - 03: Accept Alert message");
		log.info("Step AddTranslationCurrency_002 - 04: Open Add labels page");
		log.info("Step AddTranslationCurrency_002 - 05: Input new Translation Currency");
		log.info("Step AddTranslationCurrency_002 - 06: Click on Add button");
		log.info("Step AddTranslationCurrency_002 - 07: Input Description");
		log.info("Step AddTranslationCurrency_002 - 08: Click on Translation Currency item textfield button");
		log.info("Step AddTranslationCurrency_002 - 09: Select  Translation Currency item");
		log.info("Step AddTranslationCurrency_002 - 10: Click on Save button");
		log.info("Step AddTranslationCurrency_002 - 11: Input new Translation Currency");
		log.info("Step AddTranslationCurrency_002 - 12: Click on Modify button");
		
		log.info("Step AddTranslationCurrency_002 - 14: Remove first record");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "delete");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddTranslationCurrency_001 - 15: Click on Translation Currency item textfield button");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "txt_TransCurCode1");
		
		log.info("Step AddTranslationCurrency_001 - 16: Select  Translation Currency item");
		masterFilesPage.clickOnDivByItsText(DriverManager.getDriver(), newBaseCurrencyCode);
		
		log.info("Step AddTranslationCurrency_001 - 10: Input new Translation Currency");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TransRate1", "12.000000");
		
		log.info("Step AddTranslationCurrency_001 - 17: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddTranslationCurrency_001 - 18: Input new Translation Currency");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BaseCurCode", baseCurrencyCode);
		
		log.info("Step AddTranslationCurrency_001 - 19: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: First record is displayed correctly");
		verifyTrue(masterFilesPage.isFirstTranslationCurrencyCodeDisplayedCorrectly(newBaseCurrencyCode));
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Translation Currency works")
	public void AddTranslationCurrency_003_CheckDeactivateTranslationCurrencyWorks() {	
		
		log.info("Step AddTranslationCurrency_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddTranslationCurrency_003 - 02: Input correct username and password");
		log.info("Step AddTranslationCurrency_003 - 03: Accept Alert message");
		log.info("Step AddTranslationCurrency_003 - 04: Open Add labels page");
		log.info("Step AddTranslationCurrency_003 - 05: Input new Translation Currency");
		log.info("Step AddTranslationCurrency_003 - 06: Click on Add button");
		log.info("Step AddTranslationCurrency_003 - 07: Input Description");
		log.info("Step AddTranslationCurrency_003 - 08: Click on Save button");
		log.info("Step AddTranslationCurrency_003 - 09: Input new Translation Currency");
		log.info("Step AddTranslationCurrency_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddTranslationCurrency_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddTranslationCurrency_003 - 12: Input new Translation Currency");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BaseCurCode", baseCurrencyCode);
		
		log.info("Step AddTranslationCurrency_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Bank Code is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Currency Translation Rates is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Translation Currency works")
	public void AddTranslationCurrency_004_CheckReactivateTranslationCurrencyWorks() {	
		
		log.info("Step AddTranslationCurrency_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddTranslationCurrency_004 - 02: Input correct username and password");
		log.info("Step AddTranslationCurrency_004 - 03: Accept Alert message");
		log.info("Step AddTranslationCurrency_004 - 04: Open Add labels page");
		log.info("Step AddTranslationCurrency_004 - 05: Input new Translation Currency");
		log.info("Step AddTranslationCurrency_004 - 06: Click on Add button");
		log.info("Step AddTranslationCurrency_004 - 07: Input Description");
		log.info("Step AddTranslationCurrency_004 - 08: Click on Save button");
		log.info("Step AddTranslationCurrency_004 - 09: Input new Translation Currency");
		log.info("Step AddTranslationCurrency_004 - 10: Click on Deactivate button");
		log.info("Step AddTranslationCurrency_004 - 11: Accept alert");
		log.info("Step AddTranslationCurrency_004 - 12: Input new Translation Currency");
		log.info("Step AddTranslationCurrency_004 - 13: Click on Modify button");
		log.info("Step AddTranslationCurrency_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Base Currency code by Code works")
	public void AddTranslationCurrency_005_SearchBaseCurrencyCodeByCode() {	
		
		log.info("Step AddTranslationCurrency_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddTranslationCurrency_005 - 02: Input correct username and password");
		log.info("Step AddTranslationCurrency_005 - 03: Accept Alert message");
		log.info("Step AddTranslationCurrency_005 - 04: Open Add labels page");
		log.info("Step AddTranslationCurrency_005 - 05: Input new Base Currency code");
		log.info("Step AddTranslationCurrency_005 - 06: Click on Add button");
		log.info("Step AddTranslationCurrency_005 - 07: Input Description");
		log.info("Step AddTranslationCurrency_005 - 08: Click on Save button");
		log.info("Step AddTranslationCurrency_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_currency_translation.php");
		
		log.info("Step AddTranslationCurrency_005 - 10: Input Base Currency Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BaseCurrencyCode", baseCurrencyCode);
		
		log.info("Step AddTranslationCurrency_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Base Currency code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), "ARS", "Argentine Peso"));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Base Currency code by Description works")
	public void AddTranslationCurrency_006_SearchBaseCurrencyCodeByDescription() {	
		
		log.info("Step AddTranslationCurrency_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddTranslationCurrency_006 - 02: Input correct username and password");
		log.info("Step AddTranslationCurrency_006 - 03: Accept Alert message");
		log.info("Step AddTranslationCurrency_006 - 04: Open Add labels page");
		log.info("Step AddTranslationCurrency_006 - 05: Input new Base Currency code");
		log.info("Step AddTranslationCurrency_006 - 06: Click on Add button");
		log.info("Step AddTranslationCurrency_006 - 07: Input Description");
		log.info("Step AddTranslationCurrency_006 - 08: Click on Save button");
		log.info("Step AddTranslationCurrency_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_currency_translation.php");
		
		log.info("Step AddTranslationCurrency_006 - 10: Input Base Currency Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BaseCurrencyCode", baseCurrencyCode);
		
		log.info("Step AddTranslationCurrency_006 - 11: Input Base Currency name");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_BaseCurrencyName", "Argentine Peso");
		
		log.info("Step AddTranslationCurrency_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Base Currency code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), "ARS", "Argentine Peso"));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String baseCurrencyCode;
	private String newBaseCurrencyCode;
}
