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

public class MasterFiles_21_AddEditSpecialText extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newSpecialText = getUniqueText(3);
	}

	@Test(groups = { "regression" }, description = "Check Add Special Text works")
	public void AddEditSpecialText_001_CheckAddSpecialTextWorks() {	
		
		log.info("Step AddEditSpecialText_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditSpecialText_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditSpecialText_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditSpecialText_001 - 04: Open Add Special Text page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_special_text.php");

		log.info("Step AddEditSpecialText_001 - 05: Input new Special Text");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TextCode", newSpecialText);
		
		log.info("Step AddEditSpecialText_001 - 06: Click on Add button");
		masterFilesPage.sleep();
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditSpecialText_001 - 07: Input all textfields");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_Text", "new description");
		
		log.info("Step AddEditSpecialText_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditSpecialText_001 - 09: Input new Special Text");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TextCode", newSpecialText);
		
		log.info("Step AddEditSpecialText_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_Text"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Special Text works")
	public void AddEditSpecialText_002_CheckEditSpecialTextWorks() {	
		
		log.info("Step AddEditSpecialText_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditSpecialText_002 - 02: Input correct username and password");
		log.info("Step AddEditSpecialText_002 - 03: Accept Alert message");
		log.info("Step AddEditSpecialText_002 - 04: Open Add labels page");
		log.info("Step AddEditSpecialText_002 - 05: Input new Special Text");
		log.info("Step AddEditSpecialText_002 - 06: Click on Add button");
		log.info("Step AddEditSpecialText_002 - 07: Input Description");
		log.info("Step AddEditSpecialText_002 - 08: Click on Save button");
		log.info("Step AddEditSpecialText_002 - 09: Input new Special Text");
		log.info("Step AddEditSpecialText_002 - 10: Click on Modify button");
		log.info("Step AddEditSpecialText_002 - 11: Input new Description");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_Text", "new description 2");
		
		log.info("Step AddEditSpecialText_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditSpecialText_002 - 13: Input new Special Text");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TextCode", newSpecialText);
		
		log.info("Step AddEditSpecialText_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_Text"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Special Text works")
	public void AddEditSpecialText_003_CheckDeactivateSpecialTextWorks() {	
		
		log.info("Step AddEditSpecialText_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditSpecialText_003 - 02: Input correct username and password");
		log.info("Step AddEditSpecialText_003 - 03: Accept Alert message");
		log.info("Step AddEditSpecialText_003 - 04: Open Add labels page");
		log.info("Step AddEditSpecialText_003 - 05: Input new Special Text");
		log.info("Step AddEditSpecialText_003 - 06: Click on Add button");
		log.info("Step AddEditSpecialText_003 - 07: Input Description");
		log.info("Step AddEditSpecialText_003 - 08: Click on Save button");
		log.info("Step AddEditSpecialText_003 - 09: Input new Special Text");
		log.info("Step AddEditSpecialText_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditSpecialText_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditSpecialText_003 - 12: Input new Special Text");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_TextCode", newSpecialText);
		
		log.info("Step AddEditSpecialText_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Special Text is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Special Text Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Special Text works")
	public void AddEditSpecialText_004_CheckReactivateSpecialTextWorks() {	
		
		log.info("Step AddEditSpecialText_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditSpecialText_004 - 02: Input correct username and password");
		log.info("Step AddEditSpecialText_004 - 03: Accept Alert message");
		log.info("Step AddEditSpecialText_004 - 04: Open Add labels page");
		log.info("Step AddEditSpecialText_004 - 05: Input new Special Text");
		log.info("Step AddEditSpecialText_004 - 06: Click on Add button");
		log.info("Step AddEditSpecialText_004 - 07: Input Description");
		log.info("Step AddEditSpecialText_004 - 08: Click on Save button");
		log.info("Step AddEditSpecialText_004 - 09: Input new Special Text");
		log.info("Step AddEditSpecialText_004 - 10: Click on Deactivate button");
		log.info("Step AddEditSpecialText_004 - 11: Accept alert");
		log.info("Step AddEditSpecialText_004 - 12: Input new Special Text");
		log.info("Step AddEditSpecialText_004 - 13: Click on Modify button");
		log.info("Step AddEditSpecialText_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search Special Text Code code by Code works")
	public void AddEditSpecialText_005_SearchSpecialTextCodeByCode() {	
		
		log.info("Step AddEditSpecialText_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditSpecialText_005 - 02: Input correct username and password");
		log.info("Step AddEditSpecialText_005 - 03: Accept Alert message");
		log.info("Step AddEditSpecialText_005 - 04: Open Add labels page");
		log.info("Step AddEditSpecialText_005 - 05: Input new Special Text Code code");
		log.info("Step AddEditSpecialText_005 - 06: Click on Add button");
		log.info("Step AddEditSpecialText_005 - 07: Input Description");
		log.info("Step AddEditSpecialText_005 - 08: Click on Save button");
		log.info("Step AddEditSpecialText_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_special_text.php");
		
		log.info("Step AddEditSpecialText_005 - 10: Input Special Text Code Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SplTxtCode", newSpecialText);
		
		log.info("Step AddEditSpecialText_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Special Text Code code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newSpecialText, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Special Text Code code by Corporation works")
	public void AddEditSpecialText_006_SearchSpecialTextCodeByCorporation() {	
		
		log.info("Step AddEditSpecialText_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditSpecialText_006 - 02: Input correct username and password");
		log.info("Step AddEditSpecialText_006 - 03: Accept Alert message");
		log.info("Step AddEditSpecialText_006 - 04: Open Add labels page");
		log.info("Step AddEditSpecialText_006 - 05: Input new Special Text Code code");
		log.info("Step AddEditSpecialText_006 - 06: Click on Add button");
		log.info("Step AddEditSpecialText_006 - 07: Input Description");
		log.info("Step AddEditSpecialText_006 - 08: Click on Save button");
		log.info("Step AddEditSpecialText_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_special_text.php");
		
		log.info("Step AddEditSpecialText_006 - 10: Input Special Text Code Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SplTxtCode", newSpecialText);
		
		log.info("Step AddEditSpecialText_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEditSpecialText_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Special Text Code code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newSpecialText, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search Special Text Code code by Text works")
	public void AddEditSpecialText_007_SearchSpecialTextCodeByText() {	
		
		log.info("Step AddEditSpecialText_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditSpecialText_007 - 02: Input correct username and password");
		log.info("Step AddEditSpecialText_007 - 03: Accept Alert message");
		log.info("Step AddEditSpecialText_007 - 04: Open Add labels page");
		log.info("Step AddEditSpecialText_007 - 05: Input new Special Text Code code");
		log.info("Step AddEditSpecialText_007 - 06: Click on Add button");
		log.info("Step AddEditSpecialText_007 - 07: Input Description");
		log.info("Step AddEditSpecialText_007 - 08: Click on Save button");
		log.info("Step AddEditSpecialText_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_special_text.php");
		
		log.info("Step AddEditSpecialText_007 - 10: Input Special Text Code Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SplTxtCode", newSpecialText);
		
		log.info("Step AddEditSpecialText_007 - 11: Input Special Text Code content");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_SplTxtDesc", "new description 2");
		
		log.info("Step AddEditSpecialText_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: Special Text Code code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newSpecialText, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newSpecialText;
}
