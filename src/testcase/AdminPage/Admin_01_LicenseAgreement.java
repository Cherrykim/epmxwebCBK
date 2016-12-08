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
import page.LicenseAgreementPage;
import page.LoginPage;

public class Admin_01_LicenseAgreement extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		licenseAgreementPage = PageFactory.getLicenseAgreementPage(DriverManager.getDriver(), ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		homePage = PageFactory.getMainPage(DriverManager.getDriver(), ipClient);
	}

	@Test(groups = { "regression" }, description = "Choose 'I do not accept the Terms' radio button")
	public void LicenseAgreement_001_DoNotAcceptTheTerms() {	
		
		log.info("Step LicenseAgreement_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step LicenseAgreement_001 - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step LicenseAgreement_001 - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step LicenseAgreement_001 - 04: Open License Agreement page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/admin/end_user_agreement.php");

		log.info("Step LicenseAgreement_001 - 05: Choose 'I do not accept the Terms' radio button");
		licenseAgreementPage.selectRadioButtonByValue("N");
		
		log.info("VP: Next button is disabled");
		verifyFalse(licenseAgreementPage.isButtonByValueEnabled("Next"));
		
		log.info("VP: Print button is disabled");
		verifyFalse(licenseAgreementPage.isButtonByValueEnabled("Print"));
	}
	
	@Test(groups = { "regression" }, description = "Choose 'I accept the Terms' radio button")
	public void LicenseAgreement_002_AcceptTheTerms() {	
		
		log.info("Step LicenseAgreement_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step LicenseAgreement_002 - 02: Input correct username and password");
		log.info("Step LicenseAgreement_002 - 03: Accept Alert message");
		log.info("Step LicenseAgreement_002 - 04: Open License Agreement page");
		log.info("Step LicenseAgreement_002 - 05: Choose 'I accept the Terms' radio button");
		licenseAgreementPage.selectRadioButtonByValue("Y");
		
		log.info("VP: Next button is enabled");
		verifyTrue(licenseAgreementPage.isButtonByValueEnabled("Next"));
		
		log.info("VP: Print button is enabled");
		verifyTrue(licenseAgreementPage.isButtonByValueEnabled("Print"));
	}
	
	@Test(groups = { "regression" }, description = "Check Print button works")
	public void LicenseAgreement_003_CheckPrintButtonWorks() {	
		
		log.info("Step LicenseAgreement_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step LicenseAgreement_003 - 02: Input correct username and password");
		log.info("Step LicenseAgreement_003 - 03: Accept Alert message");
		log.info("Step LicenseAgreement_003 - 04: Open License Agreement page");
		log.info("Step LicenseAgreement_003 - 05: Choose 'I accept the Terms' radio button");
		log.info("Step LicenseAgreement_003 - 06: Click on Print button");
		licenseAgreementPage.clickOnButtonByValue("Print");
		currentTab = licenseAgreementPage.switchTab(DriverManager.getDriver());
		
		log.info("VP: User agreement pdf page is displayed");
		verifyEquals(licenseAgreementPage.getPageTitle(DriverManager.getDriver()), "pdf_user_agreement.php");
		licenseAgreementPage.switchWindowBackAndCloseCurrentWindow(DriverManager.getDriver(), currentTab);
	}
	
	@Test(groups = { "regression" }, description = "Check Next button works")
	public void LicenseAgreement_004_CheckNextButtonWorks() {	
		
		log.info("Step LicenseAgreement_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step LicenseAgreement_003 - 02: Input correct username and password");
		log.info("Step LicenseAgreement_003 - 03: Accept Alert message");
		log.info("Step LicenseAgreement_003 - 04: Open License Agreement page");
		log.info("Step LicenseAgreement_003 - 05: Choose 'I accept the Terms' radio button");
		log.info("Step LicenseAgreement_003 - 06: Click on Next button");
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
	private MainPage homePage;
	private String currentTab;
}
