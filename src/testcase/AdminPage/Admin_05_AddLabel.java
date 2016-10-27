package AdminPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.HomePage;
import page.LicenseAgreementPage;
import page.LoginPage;

public class Admin_05_AddLabel extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		licenseAgreementPage = PageFactory.getLicenseAgreementPage(DriverManager.getDriver(), ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		homePage = PageFactory.getHomePage(DriverManager.getDriver(), ipClient);
	}

	@Test(groups = { "regression" }, description = "Leave Enter display label blank")
	public void AddLabel_001_LeaveEnterDisplayLabelBlank() {	
		
		log.info("Step AddLabel_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddLabel_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step AddLabel_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step AddLabel_001 - 04: Open License Agreement page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/admin/end_user_agreement.php");

		log.info("Step AddLabel_001 - 05: Choose 'I do not accept the Terms' radio button");
		licenseAgreementPage.selectRadioButtonByValue("N");
		
		log.info("VP: Next button is disabled");
		verifyFalse(licenseAgreementPage.isButtonByValueEnabled("Next"));
		
		log.info("VP: Print button is disabled");
		verifyFalse(licenseAgreementPage.isButtonByValueEnabled("Print"));
	}
	
	@Test(groups = { "regression" }, description = "Check Cancel button works")
	public void AddLabel_002_CheckCancelButtonWorks() {	
		
		log.info("Step AddLabel_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddLabel_002 - 02: Input correct username and password");
		log.info("Step AddLabel_002 - 03: Accept Alert message");
		log.info("Step AddLabel_002 - 04: Open License Agreement page");
		log.info("Step AddLabel_002 - 05: Choose 'I accept the Terms' radio button");
		licenseAgreementPage.selectRadioButtonByValue("Y");
		
		log.info("VP: Next button is enabled");
		verifyTrue(licenseAgreementPage.isButtonByValueEnabled("Next"));
		
		log.info("VP: Print button is enabled");
		verifyTrue(licenseAgreementPage.isButtonByValueEnabled("Print"));
	}
	
	@Test(groups = { "regression" }, description = "Check create labels works correctly")
	public void AddLabel_003_CheckCreateLabelsWorksCorrectly() {	
		
		log.info("Step AddLabel_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddLabel_003 - 02: Input correct username and password");
		log.info("Step AddLabel_003 - 03: Accept Alert message");
		log.info("Step AddLabel_003 - 04: Open License Agreement page");
		log.info("Step AddLabel_003 - 05: Choose 'I accept the Terms' radio button");
		log.info("Step AddLabel_003 - 06: Click on Print button");
		licenseAgreementPage.clickOnButtonByValue("Print");
		currentTab = licenseAgreementPage.switchTab(DriverManager.getDriver());
		
		log.info("VP: User agreement pdf page is displayed");
		verifyEquals(licenseAgreementPage.getPageTitle(DriverManager.getDriver()), "pdf_user_agreement.php");
		licenseAgreementPage.switchWindowBackAndCloseCurrentWindow(DriverManager.getDriver(), currentTab);
	}
	
	@Test(groups = { "regression" }, description = "Can search for new label in Global Dictionary page")
	public void AddLabel_004_SearchForNewLabelInGlobalDictionaryPage() {	
		
		log.info("Step AddLabel_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddLabel_003 - 02: Input correct username and password");
		log.info("Step AddLabel_003 - 03: Accept Alert message");
		log.info("Step AddLabel_003 - 04: Open License Agreement page");
		log.info("Step AddLabel_003 - 05: Choose 'I accept the Terms' radio button");
		log.info("Step AddLabel_003 - 06: Click on Next button");
		licenseAgreementPage.clickOnButtonByValue("Next");
		
		log.info("VP - 01: Wellcome message is displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private LicenseAgreementPage licenseAgreementPage;
	private HomePage homePage;
	private String currentTab;
}
