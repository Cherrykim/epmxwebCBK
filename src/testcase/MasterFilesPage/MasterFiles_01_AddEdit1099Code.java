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
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
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
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String new1099Code;
}
