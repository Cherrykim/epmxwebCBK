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

public class MasterFiles_01_AddEdit1099Code extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		new1099Code = getUniqueText(8);
	}

	@Test(groups = { "regression" }, description = "Check Add 1099 code works")
	public void AddEdit1099Code_001_CheckAdd1099CodeWorks() {	
		
		log.info("Step AddEdit1099Code_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEdit1099Code_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEdit1099Code_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEdit1099Code_001 - 04: Open Add 1009 code page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_1099_code.php");

		log.info("Step AddEdit1099Code_001 - 05: Input new 1099 code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Code", new1099Code);
		
		log.info("Step AddEdit1099Code_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEdit1099Code_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEdit1099Code_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEdit1099Code_001 - 09: Input new 1099 code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Code", new1099Code);
		
		log.info("Step AddEdit1099Code_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_1099Desc"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Add 1099 code works")
	public void AddEdit1099Code_002_CheckEdit1099CodeWorks() {	
		
		log.info("Step AddEdit1099Code_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEdit1099Code_002 - 02: Input correct username and password");
		log.info("Step AddEdit1099Code_002 - 03: Accept Alert message");
		log.info("Step AddEdit1099Code_002 - 04: Open Add labels page");
		log.info("Step AddEdit1099Code_002 - 05: Input new 1099 code");
		log.info("Step AddEdit1099Code_002 - 06: Click on Add button");
		log.info("Step AddEdit1099Code_002 - 07: Input Description");
		log.info("Step AddEdit1099Code_002 - 08: Click on Save button");
		log.info("Step AddEdit1099Code_002 - 09: Input new 1099 code");
		log.info("Step AddEdit1099Code_002 - 10: Click on Modify button");
		log.info("Step AddEdit1099Code_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Desc", "new description 2");
		
		log.info("Step AddEdit1099Code_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEdit1099Code_002 - 13: Input new 1099 code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Code", new1099Code);
		
		log.info("Step AddEdit1099Code_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_1099Desc"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate 1099 code works")
	public void AddEdit1099Code_003_CheckDeactivate1099CodeWorks() {	
		
		log.info("Step AddEdit1099Code_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEdit1099Code_003 - 02: Input correct username and password");
		log.info("Step AddEdit1099Code_003 - 03: Accept Alert message");
		log.info("Step AddEdit1099Code_003 - 04: Open Add labels page");
		log.info("Step AddEdit1099Code_003 - 05: Input new 1099 code");
		log.info("Step AddEdit1099Code_003 - 06: Click on Add button");
		log.info("Step AddEdit1099Code_003 - 07: Input Description");
		log.info("Step AddEdit1099Code_003 - 08: Click on Save button");
		log.info("Step AddEdit1099Code_003 - 09: Input new 1099 code");
		log.info("Step AddEdit1099Code_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEdit1099Code_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEdit1099Code_003 - 12: Input new 1099 code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Code", new1099Code);
		
		log.info("Step AddEdit1099Code_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: 1099 code is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "1099 Code is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate 1099 code works")
	public void AddEdit1099Code_004_CheckReactivate1099CodeWorks() {	
		
		log.info("Step AddEdit1099Code_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEdit1099Code_004 - 02: Input correct username and password");
		log.info("Step AddEdit1099Code_004 - 03: Accept Alert message");
		log.info("Step AddEdit1099Code_004 - 04: Open Add labels page");
		log.info("Step AddEdit1099Code_004 - 05: Input new 1099 code");
		log.info("Step AddEdit1099Code_004 - 06: Click on Add button");
		log.info("Step AddEdit1099Code_004 - 07: Input Description");
		log.info("Step AddEdit1099Code_004 - 08: Click on Save button");
		log.info("Step AddEdit1099Code_004 - 09: Input new 1099 code");
		log.info("Step AddEdit1099Code_004 - 10: Click on Deactivate button");
		log.info("Step AddEdit1099Code_004 - 11: Accept alert");
		log.info("Step AddEdit1099Code_004 - 12: Input new 1099 code");
		log.info("Step AddEdit1099Code_004 - 13: Click on Modify button");
		log.info("Step AddEdit1099Code_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search 1099 code by Code works")
	public void AddEdit1099Code_005_Search1099CodeByCode() {	
		
		log.info("Step AddEdit1099Code_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEdit1099Code_005 - 02: Input correct username and password");
		log.info("Step AddEdit1099Code_005 - 03: Accept Alert message");
		log.info("Step AddEdit1099Code_005 - 04: Open Add labels page");
		log.info("Step AddEdit1099Code_005 - 05: Input new 1099 code");
		log.info("Step AddEdit1099Code_005 - 06: Click on Add button");
		log.info("Step AddEdit1099Code_005 - 07: Input Description");
		log.info("Step AddEdit1099Code_005 - 08: Click on Save button");
		log.info("Step AddEdit1099Code_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_1099_code.php");
		
		log.info("Step AddEdit1099Code_005 - 10: Input 1099 Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Code", new1099Code);
		
		log.info("Step AddEdit1099Code_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: 1099 code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), new1099Code, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search 1099 code by Corporation works")
	public void AddEdit1099Code_006_Search1099CodeByCorporation() {	
		
		log.info("Step AddEdit1099Code_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEdit1099Code_006 - 02: Input correct username and password");
		log.info("Step AddEdit1099Code_006 - 03: Accept Alert message");
		log.info("Step AddEdit1099Code_006 - 04: Open Add labels page");
		log.info("Step AddEdit1099Code_006 - 05: Input new 1099 code");
		log.info("Step AddEdit1099Code_006 - 06: Click on Add button");
		log.info("Step AddEdit1099Code_006 - 07: Input Description");
		log.info("Step AddEdit1099Code_006 - 08: Click on Save button");
		log.info("Step AddEdit1099Code_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_1099_code.php");
		
		log.info("Step AddEdit1099Code_006 - 10: Input 1099 Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Code", new1099Code);
		
		log.info("Step AddEdit1099Code_006 - 11: Select Corporation");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", Constant.DefaultValue.CORPORATION);
		
		log.info("Step AddEdit1099Code_006 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: 1099 code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), new1099Code, Constant.DefaultValue.CORPORATION));
	}
	
	@Test(groups = { "regression" }, description = "Check Search 1099 code by Description works")
	public void AddEdit1099Code_007_Search1099CodeByDescription() {	
		
		log.info("Step AddEdit1099Code_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEdit1099Code_007 - 02: Input correct username and password");
		log.info("Step AddEdit1099Code_007 - 03: Accept Alert message");
		log.info("Step AddEdit1099Code_007 - 04: Open Add labels page");
		log.info("Step AddEdit1099Code_007 - 05: Input new 1099 code");
		log.info("Step AddEdit1099Code_007 - 06: Click on Add button");
		log.info("Step AddEdit1099Code_007 - 07: Input Description");
		log.info("Step AddEdit1099Code_007 - 08: Click on Save button");
		log.info("Step AddEdit1099Code_007 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_1099_code.php");
		
		log.info("Step AddEdit1099Code_007 - 10: Input 1099 Code");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Code", new1099Code);
		
		log.info("Step AddEdit1099Code_007 - 11: Input 1099 Code description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_1099Desc", "new description 2");
		
		log.info("Step AddEdit1099Code_007 - 12: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: 1099 code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), new1099Code, "new description 2"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String new1099Code;
}
