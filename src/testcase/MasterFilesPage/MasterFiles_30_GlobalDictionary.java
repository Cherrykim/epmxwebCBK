package MasterFilesPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.AddLabelsPage;
import page.MasterFilesPage;
import page.LoginPage;

public class MasterFiles_30_GlobalDictionary extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		addLabelsPage = PageFactory.getAddLabelsPage(DriverManager.getDriver(), ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		globalDictionaryPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		uniqueNumber = getUniqueNumber();
		newLabelName = "label"+ uniqueNumber;
		labelShortName = "lb"+ uniqueNumber;
		labelDisplayName = "label" + uniqueNumber;
		labelModules = "Requisitions";
		labelFieldType = "Text Box";
		labelRequiredFlag =  "Required";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Open Add labels page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/admin/labels.php");
	
		log.info("Step Pre-condition - 05: Input all fields");
		addLabelsPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FldName", newLabelName);
		addLabelsPage.inputTextfieldByName(DriverManager.getDriver(), "txt_DisplayName", labelDisplayName);
		addLabelsPage.inputTextfieldByName(DriverManager.getDriver(), "sel_DisplayShortName", labelShortName);
		addLabelsPage.selectItemFromDropdownByClass(DriverManager.getDriver(), "SelectFieldValue", labelModules);
		addLabelsPage.selectItemFromDropdownByName(DriverManager.getDriver(), "sel_FldType", labelFieldType);
		addLabelsPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ReqFlg", labelRequiredFlag);
		
		log.info("Step Pre-condition - 06: Click on Save button");
		addLabelsPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
	}

	
	@Test(groups = { "regression" }, description = "Can search for new label in Global Dictionary page")
	public void GlobalDictionary_001_SearchForNewLabelInGlobalDictionaryPage() {	
		log.info("Step GlobalDictionary_001 - 01: Open Global Dictionary page");
		addLabelsPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/global_dictionary.php");
		
		log.info("Step GlobalDictionary_001 - 02: Select 'Requisitions' module");
		globalDictionaryPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Modules", "Requisitions");

		log.info("Step GlobalDictionary_001 - 03: Input new label display name for searching");
		globalDictionaryPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisName", labelDisplayName);
		
		log.info("Step GlobalDictionary_001 - 04: Click on Search button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search");
		
		log.info("VP: Check label type is correct");
		verifyTrue(globalDictionaryPage.isTextDisplayed(DriverManager.getDriver(), "Entry Fields"));
		
		log.info("VP: Check default display name is correct");
		verifyEquals(globalDictionaryPage.getDefaultDisplayName(), labelDisplayName);
		
		log.info("VP: Check default short name is correct");
		verifyEquals(globalDictionaryPage.getDefaultShortName(), labelShortName);
		
		log.info("Step GlobalDictionary_001 - 05: Click on Clear button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "clear");
		
		log.info("Step GlobalDictionary_001 - 06: Select 'Entry Fields' Categories");
		globalDictionaryPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Sections", "Entry Fields");
		
		log.info("Step GlobalDictionary_001 - 07: Input new label display name for searching");
		globalDictionaryPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisName", labelDisplayName);
		
		log.info("Step GlobalDictionary_001 - 08: Click on Search button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search");
		
		log.info("Step GlobalDictionary_001 - VP: Check default display name is correct");
		verifyEquals(globalDictionaryPage.getDefaultDisplayName(), labelDisplayName);
		
		log.info("Step GlobalDictionary_001 - VP: Check default short name is correct");
		verifyEquals(globalDictionaryPage.getDefaultShortName(), labelShortName);
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Dictionary function works")
	public void GlobalDictionary_002_CheckEditDictionaryFunctionWorks() {	
		
		log.info("Step GlobalDictionary_002 - 01: Open Global Dictionary page");
		log.info("Step GlobalDictionary_002 - 02: Select 'Requisitions' module");
		log.info("Step GlobalDictionary_002 - 03: Input new label display name for searching");
		log.info("Step GlobalDictionary_002 - 04: Click on Search button");
		log.info("Step GlobalDictionary_002 - 05: Input New display name");
		globalDictionaryPage.inputNameTextfield("txt_DisplayName", "new"+ newLabelName);

		log.info("Step GlobalDictionary_002 - 06: Click on Save button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save_page");
		
		log.info("Step GlobalDictionary_002 - 05: Input New display short name");
		globalDictionaryPage.inputNameTextfield("txt_ShortName", "new"+ labelShortName);
		
		log.info("Step GlobalDictionary_002 - 05: Select required radio button");
		globalDictionaryPage.selectOptionalRadioButton();
		
		log.info("Step GlobalDictionary_002 - 06: Click on Save button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save_page");
		
		log.info("Step GlobalDictionary_002 - VP: Check new display name is correct");
		verifyEquals(globalDictionaryPage.getNameTextfieldValue("txt_DisplayName"), "new"+ newLabelName);
		
		log.info("Step GlobalDictionary_002 - VP: Check new short name is correct");
		verifyEquals(globalDictionaryPage.getNameTextfieldValue("txt_ShortName"), "new"+ labelShortName);
		
		log.info("Step GlobalDictionary_002 - VP: Required radio button is selected");
		verifyTrue(globalDictionaryPage.isOptionalRadioButtonChecked());
	}
	
	@Test(groups = { "regression" }, description = "Check Global Dictionary Reset all display name function works")
	public void GlobalDictionary_003_CheckGlobalDictionaryResetAllDisplayNameFunctionWorks() {	
		
		log.info("Step GlobalDictionary_003 - 01: Open Global Dictionary page");
		log.info("Step GlobalDictionary_003 - 02: Select 'Requisitions' module");
		log.info("Step GlobalDictionary_003 - 03: Input new label display name for searching");
		log.info("Step GlobalDictionary_003 - 04: Click on Search button");
		log.info("Step GlobalDictionary_003 - 05: Input New display name");
		log.info("Step GlobalDictionary_003 - 06: Click on Save button");
		log.info("Step GlobalDictionary_003 - 07: Input New display short name");
		log.info("Step GlobalDictionary_003 - 08: Select required radio button");
		log.info("Step GlobalDictionary_003 - 09: Click on Save button");
		log.info("Step GlobalDictionary_003 - 10: Click on RESET DISP NAMES TO ALL CORP DEFAULTS button");
		globalDictionaryPage.clickOnElementByItsValue(DriverManager.getDriver(), "RESET DISP NAMES TO ALL CORP DEFAULTS");
		globalDictionaryPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step GlobalDictionary_003 - VP: Reset successful messageg is displayed");
		verifyTrue(globalDictionaryPage.isTextDisplayed(DriverManager.getDriver(), "Display Names reset successfully."));
		
		log.info("Step GlobalDictionary_003 - 11: Click on Search button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search");
		
		log.info("Step GlobalDictionary_003 - VP: Check new display name is restored to default");
		verifyEquals(globalDictionaryPage.getNameTextfieldValue("txt_DisplayName"), newLabelName);
		
		log.info("Step GlobalDictionary_003 - VP: Check new short name is restored to default");
		verifyEquals(globalDictionaryPage.getNameTextfieldValue("txt_ShortName"), labelShortName);
		
		log.info("Step GlobalDictionary_003 - VP: Required radio button is selected");
		verifyTrue(globalDictionaryPage.isOptionalRadioButtonChecked());
	}
	
	@Test(groups = { "regression" }, description = "Check Global Dictionary Reset all options  function works")
	public void GlobalDictionary_004_CheckGlobalDictionaryResetAllOptionsFunctionWorks() {	
		
		log.info("Step GlobalDictionary_004 - 01: Open Global Dictionary page");
		log.info("Step GlobalDictionary_004 - 02: Select 'Requisitions' module");
		log.info("Step GlobalDictionary_004 - 03: Input new label display name for searching");
		log.info("Step GlobalDictionary_004 - 04: Click on Search button");
		log.info("Step GlobalDictionary_004 - 05: Input New display name");
		log.info("Step GlobalDictionary_004 - 06: Click on Save button");
		log.info("Step GlobalDictionary_004 - 07: Input New display short name");
		log.info("Step GlobalDictionary_004 - 08: Select required radio button");
		log.info("Step GlobalDictionary_004 - 09: Click on Save button");
		log.info("Step GlobalDictionary_004 - 10: Click on RESET EDIT OPTS TO ALL CORP DEFAULTS button");
		globalDictionaryPage.clickOnElementByItsValue(DriverManager.getDriver(), "RESET EDIT OPTS TO ALL CORP DEFAULTS");
		globalDictionaryPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step GlobalDictionary_004 - VP: Reset successful messageg is displayed");
		verifyTrue(globalDictionaryPage.isTextDisplayed(DriverManager.getDriver(), "Edit Options reset successfully."));
		
		log.info("Step GlobalDictionary_004 - 11: Click on Search button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search");
		
		log.info("Step GlobalDictionary_004 - VP: Check new display name is restored to default");
		verifyEquals(globalDictionaryPage.getNameTextfieldValue("txt_DisplayName"), newLabelName);
		
		log.info("Step GlobalDictionary_004 - VP: Check new short name is restored to default");
		verifyEquals(globalDictionaryPage.getNameTextfieldValue("txt_ShortName"), labelShortName);
		
		log.info("Step GlobalDictionary_004 - VP: Required radio button is selected");
		verifyFalse(globalDictionaryPage.isOptionalRadioButtonChecked());
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AddLabelsPage addLabelsPage;
	private MasterFilesPage globalDictionaryPage;
	private String uniqueNumber, newLabelName, labelShortName, labelDisplayName, labelModules, labelFieldType, labelRequiredFlag;
}
