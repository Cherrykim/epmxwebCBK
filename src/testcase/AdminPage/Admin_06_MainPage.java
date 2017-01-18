package AdminPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.MainPage;
import page.LoginPage;

public class Admin_06_MainPage extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		mainPage = PageFactory.getMainPage(DriverManager.getDriver(), ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
	}

	@Test(groups = { "regression" }, description = "Check Master Files menu button")
	public void MainPage_001_CheckMasterFilesMenuButton() {	
		
		log.info("Step MainPage_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step MainPage_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step MainPage_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step MainPage_001 - 04: Click on Master Files menu button");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Master Files");

		log.info("Step MainPage_001 - VP: Catalog File sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Catalog File"));
		
		log.info("Step MainPage_001 - VP: Commodity Code sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Commodity Code"));
		
		log.info("Step MainPage_001 - VP: Control File... sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Control File..."));
		
		log.info("Step MainPage_001 - VP: Control File Reports sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Control File Reports"));
		
		log.info("Step MainPage_001 - VP: Corporation sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Corporation"));
		
		log.info("Step MainPage_001 - VP: Employee sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Employee"));
		
		log.info("Step MainPage_001 - VP: Global Dictionary sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Global Dictionary"));
		
		log.info("Step MainPage_001 - VP: Master File Reports sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Master File Reports"));
		
		log.info("Step MainPage_001 - VP: Material File sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Material File"));
		
		log.info("Step MainPage_001 - VP: System Information sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "System Information"));
		
		log.info("Step MainPage_001 - VP: Vendor File sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu1", "Vendor File"));
	}
	
	@Test(groups = { "regression" }, description = "Check Utilities menu button")
	public void MainPage_002_CheckUtilitiesMenuButton() {	
		
		log.info("Step MainPage_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step MainPage_002 - 02: Input correct username and password");
		log.info("Step MainPage_002 - 03: Accept Alert message");
		log.info("Step MainPage_002 - 04: Click on Ultilites menu button");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Utilities");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Utilities");

		log.info("Step MainPage_002 - VP: Accumulated Budget Report sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu8", "Accumulated Budget Report"));
		
		log.info("Step MainPage_002 - VP: Clear Ownership sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu8", "Clear Ownership"));
		
		log.info("Step MainPage_002 - VP: Catalog Security sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu8", "Catalog Security"));
		
		log.info("Step MainPage_002 - VP: Maintain System Files sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu8", "Maintain System Files"));
		
		log.info("Step MainPage_002 - VP: Reset Users button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu8", "Reset Users"));
		
		log.info("Step MainPage_002 - VP: User Class Sub Module Access sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu8", "User Class Sub Module Access"));
		
		log.info("Step MainPage_002 - VP: Users Logged on ePMX sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu8", "Users Logged on ePMX"));
		
		log.info("Step MainPage_002 - VP: Imports sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu8", "Imports"));
	}
	
	@Test(groups = { "regression" }, description = "Check Requisitions menu button")
	public void MainPage_003_CheckRequisitionsMenuButton() {	
		
		log.info("Step MainPage_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step MainPage_003 - 02: Input correct username and password");
		log.info("Step MainPage_003 - 03: Accept Alert message");
		log.info("Step MainPage_003 - 04: Click on Requisitions menu button");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Requisitions");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Requisitions");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Requisitions");

		
		log.info("Step MainPage_003 - VP: Requisitions sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu2", "Requisitions"));
		
		log.info("Step MainPage_003 - VP: Requisitions from Previous Reqs sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu2", "Requisitions from Previous Reqs"));
		
		log.info("Step MainPage_003 - VP: Requisition Approvals sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu2", "Requisition Approvals"));
		
		log.info("Step MainPage_003 - VP: Requisition Status Inquiry sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu2", "Requisition Status Inquiry"));
		
		log.info("Step MainPage_003 - VP: Reports button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu2", "Reports"));
		
		log.info("Step MainPage_003 - VP: Print Requisition Document sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu2", "Print Requisition Document"));
		
		log.info("Step MainPage_003 - VP: Suspend Requisition Approval sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu2", "Suspend Requisition Approval"));
		
		log.info("Step MainPage_003 - VP: Logs sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu2", "Logs"));
	}
	
	@Test(groups = { "regression" }, description = "Check Purchasing menu button")
	public void MainPage_004_CheckPurchasingsMenuButton() {	
		
		log.info("Step MainPage_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step MainPage_004 - 02: Input correct username and password");
		log.info("Step MainPage_004 - 03: Accept Alert message");
		log.info("Step MainPage_004 - 04: Click on Purchasing menu button");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Purchasing");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Purchasing");

		log.info("Step MainPage_004 - VP: Standard P.O. sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Standard P.O."));
		
		log.info("Step MainPage_004 - VP: Blanket P.O. sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Blanket P.O."));
		
		log.info("Step MainPage_004 - VP: P.O.'s From Requisitions sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "P.O.'s From Requisitions"));
		
		log.info("Step MainPage_004 - VP: Modify P.O. sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Modify P.O."));
		
		log.info("Step MainPage_004 - VP: P.O. Approvals is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "P.O. Approvals"));
		
		log.info("Step MainPage_004 - VP: Automated History Card sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Automated History Card"));
		
		log.info("Step MainPage_004 - VP: Material on Order sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Material on Order"));
		
		log.info("Step MainPage_004 - VP: Material on Contract sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Material on Contract"));
		
		log.info("Step MainPage_004 - VP: Review P.O. Document is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Review P.O. Document"));
		
		log.info("Step MainPage_004 - VP: Print P.O Document sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Print P.O Document"));
		
		log.info("Step MainPage_004 - VP: Reports sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Reports"));
		
		log.info("Step MainPage_004 - VP: Logs sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu5", "Logs"));
	}
	
	@Test(groups = { "regression" }, description = "Check Receiving menu button")
	public void MainPage_005_CheckReceivingsMenuButton() {	
		
		log.info("Step MainPage_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step MainPage_005 - 02: Input correct username and password");
		log.info("Step MainPage_005 - 03: Accept Alert message");
		log.info("Step MainPage_005 - 04: Click on Receiving menu button");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Receiving");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Receiving");

		log.info("Step MainPage_005 - VP: Material Receipt sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu3", "Material Receipt"));
		
		log.info("Step MainPage_005 - VP: Material Receipts Summary sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu3", "Material Receipts Summary"));
		
		log.info("Step MainPage_005 - VP: Unplanned Receipts sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu3", "Unplanned Receipts"));
		
		log.info("Step MainPage_005 - VP: Material on Order sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu3", "Material on Order"));
		
		log.info("Step MainPage_005 - VP: Reports sub-menu button  is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu3", "Reports"));
	}
	
	@Test(groups = { "regression" }, description = "Check Invoice menu button")
	public void MainPage_006_CheckInvoiceMenuButton() {	
		
		log.info("Step MainPage_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step MainPage_006 - 02: Input correct username and password");
		log.info("Step MainPage_006 - 03: Accept Alert message");
		log.info("Step MainPage_006 - 04: Click on Invoice menu button");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Invoice");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Invoice");

		log.info("Step MainPage_006 - VP: Invoice Entry sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu9", "Invoice Entry"));
		
		log.info("Step MainPage_006 - VP: Invoice Approvals sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu9", "Invoice Approvals"));
		
		log.info("Step MainPage_006 - VP: Material on Order sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu9", "Material on Order"));
		
		log.info("Step MainPage_006 - VP: Material Receipts Summary sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu9", "Material Receipts Summary"));
		
		log.info("Step MainPage_006 - VP: Purchase Order History sub-menu button  is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu9", "Purchase Order History"));
		
		log.info("Step MainPage_006 - VP: Voucher Inquiry sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu9", "Voucher Inquiry"));
		
		log.info("Step MainPage_006 - VP: Review P.O. Document sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu9", "Review P.O. Document"));
		
		log.info("Step MainPage_006 - VP: Reports sub-menu button  is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu9", "Reports"));
	}
	
	@Test(groups = { "regression" }, description = "Check Asset Manager menu button")
	public void MainPage_007_CheckAssetManagerMenuButton() {	
		
		log.info("Step MainPage_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step MainPage_007 - 02: Input correct username and password");
		log.info("Step MainPage_007 - 03: Accept Alert message");
		log.info("Step MainPage_007 - 04: Click on Asset Manager menu button");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Asset Manager");
		mainPage.clickOnLinkByPreciselyText(DriverManager.getDriver(), "Asset Manager");

		log.info("Step MainPage_007 - VP: Asset Entry sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu12", "Asset Entry"));
		
		log.info("Step MainPage_007 - VP: Asset Inquiry sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu12", "Asset Inquiry"));
		
		log.info("Step MainPage_007 - VP: Warranty sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu12", "Warranty"));
		
		log.info("Step MainPage_007 - VP: Control Files sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu12", "Control Files"));
		
		log.info("Step MainPage_007 - VP: Reports sub-menu button  is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu12", "Reports"));
		
		log.info("Step MainPage_007 - VP: Service History sub-menu button is displayed");
		verifyTrue(mainPage.isSubMenuButtonDisplayed("msmenu12", "Service History"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MainPage mainPage;
}
