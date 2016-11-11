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

public class MasterFiles_25_AddEditUnitOfMeasure extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newUnitOfMeasure = getUniqueText(3);
	}

	@Test(groups = { "regression" }, description = "Check Add Unit of measure works")
	public void AddEditUnitOfMeasure_001_CheckAddUnitOfMeasureWorks() {	
		
		log.info("Step AddEditUnitOfMeasure_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnitOfMeasure_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step AddEditUnitOfMeasure_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddEditUnitOfMeasure_001 - 04: Open Add Unit of measure page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_units_of_measure.php");

		log.info("Step AddEditUnitOfMeasure_001 - 05: Input new Unit of measure");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UMCode", newUnitOfMeasure);
		
		log.info("Step AddEditUnitOfMeasure_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditUnitOfMeasure_001 - 07: Input Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Description", "new description");
		
		log.info("Step AddEditUnitOfMeasure_001 - 08: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditUnitOfMeasure_001 - 09: Input new Unit of measure");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UMCode", newUnitOfMeasure);
		
		log.info("Step AddEditUnitOfMeasure_001 - 10: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Desc"), "new description");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit Unit of measure works")
	public void AddEditUnitOfMeasure_002_CheckEditUnitOfMeasureWorks() {	
		
		log.info("Step AddEditUnitOfMeasure_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnitOfMeasure_002 - 02: Input correct username and password");
		log.info("Step AddEditUnitOfMeasure_002 - 03: Accept Alert message");
		log.info("Step AddEditUnitOfMeasure_002 - 04: Open Add labels page");
		log.info("Step AddEditUnitOfMeasure_002 - 05: Input new Unit of measure");
		log.info("Step AddEditUnitOfMeasure_002 - 06: Click on Add button");
		log.info("Step AddEditUnitOfMeasure_002 - 07: Input Description");
		log.info("Step AddEditUnitOfMeasure_002 - 08: Click on Save button");
		log.info("Step AddEditUnitOfMeasure_002 - 09: Input new Unit of measure");
		log.info("Step AddEditUnitOfMeasure_002 - 10: Click on Modify button");
		log.info("Step AddEditUnitOfMeasure_002 - 11: Input new Description");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Desc", "new description 2");
		
		log.info("Step AddEditUnitOfMeasure_002 - 12: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditUnitOfMeasure_002 - 13: Input new Unit of measure");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UMCode", newUnitOfMeasure);
		
		log.info("Step AddEditUnitOfMeasure_002 - 14: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Description field is saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Desc"), "new description 2");
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate Unit of measure works")
	public void AddEditUnitOfMeasure_003_CheckDeactivateUnitOfMeasureWorks() {	
		
		log.info("Step AddEditUnitOfMeasure_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnitOfMeasure_003 - 02: Input correct username and password");
		log.info("Step AddEditUnitOfMeasure_003 - 03: Accept Alert message");
		log.info("Step AddEditUnitOfMeasure_003 - 04: Open Add labels page");
		log.info("Step AddEditUnitOfMeasure_003 - 05: Input new Unit of measure");
		log.info("Step AddEditUnitOfMeasure_003 - 06: Click on Add button");
		log.info("Step AddEditUnitOfMeasure_003 - 07: Input Description");
		log.info("Step AddEditUnitOfMeasure_003 - 08: Click on Save button");
		log.info("Step AddEditUnitOfMeasure_003 - 09: Input new Unit of measure");
		log.info("Step AddEditUnitOfMeasure_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditUnitOfMeasure_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditUnitOfMeasure_003 - 12: Input new Unit of measure");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UMCode", newUnitOfMeasure);
		
		log.info("Step AddEditUnitOfMeasure_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Unit of Measure is deactivated correctly");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Unit of Measure is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate Unit of measure works")
	public void AddEditUnitOfMeasure_004_CheckReactivateUnitOfMeasureWorks() {	
		
		log.info("Step AddEditUnitOfMeasure_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUnitOfMeasure_004 - 02: Input correct username and password");
		log.info("Step AddEditUnitOfMeasure_004 - 03: Accept Alert message");
		log.info("Step AddEditUnitOfMeasure_004 - 04: Open Add labels page");
		log.info("Step AddEditUnitOfMeasure_004 - 05: Input new Unit of measure");
		log.info("Step AddEditUnitOfMeasure_004 - 06: Click on Add button");
		log.info("Step AddEditUnitOfMeasure_004 - 07: Input Description");
		log.info("Step AddEditUnitOfMeasure_004 - 08: Click on Save button");
		log.info("Step AddEditUnitOfMeasure_004 - 09: Input new Unit of measure");
		log.info("Step AddEditUnitOfMeasure_004 - 10: Click on Deactivate button");
		log.info("Step AddEditUnitOfMeasure_004 - 11: Accept alert");
		log.info("Step AddEditUnitOfMeasure_004 - 12: Input new Unit of measure");
		log.info("Step AddEditUnitOfMeasure_004 - 13: Click on Modify button");
		log.info("Step AddEditUnitOfMeasure_004 - 14: Accept alert");
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
	private String newUnitOfMeasure;
}
