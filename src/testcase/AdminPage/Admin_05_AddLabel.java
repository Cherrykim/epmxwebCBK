package AdminPage;

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

public class Admin_05_AddLabel extends AbstractTest {

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
	}

	@Test(groups = { "regression" }, description = "Leave Enter display label blank")
	public void AddLabel_001_LeaveEnterDisplayLabelBlank() {	
		
		log.info("Step AddLabel_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddLabel_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step AddLabel_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddLabel_001 - 04: Open Add labels page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/admin/labels.php");

		log.info("Step AddLabel_001 - 05: Click on Save button");
		addLabelsPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("VP: Please enter Display Label message is displayed");
		verifyEquals(addLabelsPage.getAlertText(DriverManager.getDriver()), "Please enter Display Label");
	}
	
	@Test(groups = { "regression" }, description = "Check Cancel button works")
	public void AddLabel_002_CheckCancelButtonWorks() {	
		
		log.info("Step AddLabel_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddLabel_002 - 02: Input correct username and password");
		log.info("Step AddLabel_002 - 03: Accept Alert message");
		log.info("Step AddLabel_002 - 04: Open Add labels page");
		log.info("Step AddLabel_002 - 05: Input all fields");
		addLabelsPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FldName", newLabelName);
		addLabelsPage.inputTextfieldByName(DriverManager.getDriver(), "txt_DisplayName", labelDisplayName);
		addLabelsPage.inputTextfieldByName(DriverManager.getDriver(), "sel_DisplayShortName", labelShortName);
		addLabelsPage.selectItemFromDropdownByClass(DriverManager.getDriver(), "SelectFieldValue", labelModules);
		addLabelsPage.selectItemFromDropdownByName(DriverManager.getDriver(), "sel_FldType", labelFieldType);
		addLabelsPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ReqFlg", labelRequiredFlag);
		
		log.info("Step AddLabel_002 - 06: Click on Save button");
		addLabelsPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "cancel");
		
		log.info("VP: All fields returned to default");
		verifyEquals(addLabelsPage.getTextfieldByID(DriverManager.getDriver(), "txt_FldName"), "");
		verifyEquals(addLabelsPage.getTextfieldByName(DriverManager.getDriver(), "txt_DisplayName"), "");
		verifyEquals(addLabelsPage.getTextfieldByName(DriverManager.getDriver(), "sel_DisplayShortName"), "");
		verifyEquals(addLabelsPage.getSelectedItemByClass(DriverManager.getDriver(), "SelectFieldValue"), "Master Files");
		verifyEquals(addLabelsPage.getSelectedItemByName(DriverManager.getDriver(), "sel_FldType"), "Label");
		verifyEquals(addLabelsPage.getSelectedItemByID(DriverManager.getDriver(), "sel_ReqFlg"), "");
	}
	
	@Test(groups = { "regression" }, description = "Check create labels works correctly")
	public void AddLabel_003_CheckCreateLabelsWorksCorrectly() {	
		log.info("Step AddLabel_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddLabel_003 - 02: Input correct username and password");
		log.info("Step AddLabel_003 - 03: Accept Alert message");
		log.info("Step AddLabel_003 - 04: Open Add labels page");
		log.info("Step AddLabel_003 - 05: Input all fields");
		addLabelsPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FldName", newLabelName);
		addLabelsPage.inputTextfieldByName(DriverManager.getDriver(), "txt_DisplayName", labelDisplayName);
		addLabelsPage.inputTextfieldByName(DriverManager.getDriver(), "sel_DisplayShortName", labelShortName);
		addLabelsPage.selectItemFromDropdownByClass(DriverManager.getDriver(), "SelectFieldValue", labelModules);
		addLabelsPage.selectItemFromDropdownByName(DriverManager.getDriver(), "sel_FldType", labelFieldType);
		addLabelsPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_ReqFlg", labelRequiredFlag);
		
		log.info("Step AddLabel_003 - 06: Click on Save button");
		addLabelsPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("VP: Label added successfully message is displayed");
		verifyTrue(addLabelsPage.isTextDisplayed(DriverManager.getDriver(), "Label added successfully"));
	}
	
	@Test(groups = { "regression" }, description = "Can search for new label in Global Dictionary page")
	public void AddLabel_004_SearchForNewLabelInGlobalDictionaryPage() {	
		log.info("Step AddLabel_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddLabel_004 - 02: Input correct username and password");
		log.info("Step AddLabel_004 - 03: Accept Alert message");
		log.info("Step AddLabel_004 - 04: Open Add labels page");
		log.info("Step AddLabel_004 - 05: Input all fields");
		log.info("Step AddLabel_004 - 06: Click on Save button");
		log.info("Step AddLabel_004 - 07: Open Global Dictionary page");
		addLabelsPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/global_dictionary.php");
		
		log.info("Step AddLabel_004 - 08: Select 'Requisitions' module");
		globalDictionaryPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Modules", "Requisitions");

		log.info("Step AddLabel_004 - 09: Input new label display name for searching");
		globalDictionaryPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisName", labelDisplayName);
		
		log.info("Step AddLabel_004 - 10: Click on Search button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search");
		
		log.info("VP: Check label type is correct");
		verifyTrue(globalDictionaryPage.isTextDisplayed(DriverManager.getDriver(), "Entry Fields"));
		
		log.info("VP: Check default display name is correct");
		verifyEquals(globalDictionaryPage.getDefaultDisplayName(), labelDisplayName);
		
		log.info("VP: Check default short name is correct");
		verifyEquals(globalDictionaryPage.getDefaultShortName(), labelShortName);
		
		log.info("Step AddLabel_004 - 11: Click on Clear button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "clear");
		
		log.info("Step AddLabel_004 - 12: Select 'Entry Fields' Categories");
		globalDictionaryPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Sections", "Entry Fields");
		
		log.info("Step AddLabel_004 - 13: Input new label display name for searching");
		globalDictionaryPage.inputTextfieldByID(DriverManager.getDriver(), "txt_DisName", labelDisplayName);
		
		log.info("Step AddLabel_004 - 14: Click on Search button");
		globalDictionaryPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search");
		
		log.info("VP: Check default display name is correct");
		verifyEquals(globalDictionaryPage.getDefaultDisplayName(), labelDisplayName);
		
		log.info("VP: Check default short name is correct");
		verifyEquals(globalDictionaryPage.getDefaultShortName(), labelShortName);
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
