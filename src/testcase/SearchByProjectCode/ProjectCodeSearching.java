package SearchByProjectCode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.ConfigPage;
import page.MainPage;
import page.LoginPage;

public class ProjectCodeSearching extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		configPage = PageFactory.getConfigPage(DriverManager.getDriver(), ipClient);
		homePage = PageFactory.getMainPage(DriverManager.getDriver(), ipClient);
		log.info("Pre-condition - 01: Open the site http://tool.cherry.epmxweb.com/");
		log.info("Pre-condition - 02: Select Brand: " + Constant.DefaultValue.CURRENT_BRANCH);
		log.info("Pre-condition - 03: Choose database and get an Username");
		log.info("Pre-condition - 04: Click on Config button and get default Password");
		configPage.selectBranchAndDatabase(Constant.DefaultValue.CURRENT_BRANCH, Constant.DefaultValue.CURRENT_DATABASE);
	}
	
	@Test(groups = { "regression" }, description = "Search with Project Code")
	public void ProjectCodeSearching_01_SearchWithProjectCode() {	
		
		log.info("Step ProjectCodeSearching_01 - 01: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step ProjectCodeSearching_01 - 02: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step ProjectCodeSearching_01 - 03: Expand Purchasing menu");
		homePage.clickLinkByItsText(DriverManager.getDriver(), "Purchasing");
		
		log.info("Step ProjectCodeSearching_01 - 04: Select PO History page");
		homePage.clickLinkByItsText(DriverManager.getDriver(), "Automated History Card", "2");
		
		log.info("Step ProjectCodeSearching_01 - 05: Select Select Corporation: 'All'");
		homePage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", "All");
		
		log.info("Step ProjectCodeSearching_01 - 06: Clear all Search option");
		homePage.clickOnClearButton(DriverManager.getDriver());
		
		log.info("Step ProjectCodeSearching_01 - 07: Input Project code");
		homePage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Project", "Bacti");
		
		log.info("Step ProjectCodeSearching_01 - 08: Click on Search button");
		homePage.clickOnSearchButton(DriverManager.getDriver());
		
		log.info("VP ProjectCodeSearching_01 - 09: Result table displayed correctly");
		verifyTrue(homePage.isTableByIdContainsText(DriverManager.getDriver(), "liveGrid_HistoryCard_tab", "Bacti"));
		
		log.info("Step ProjectCodeSearching_01 - 10: Clear all Search option");
		homePage.clickOnClearButton(DriverManager.getDriver());
		
		log.info("Step ProjectCodeSearching_01 - 11: Input Project code");
		homePage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_Project", "ARBO");
		
		log.info("Step ProjectCodeSearching_01 - 12: Click on Search button");
		homePage.clickOnSearchButton(DriverManager.getDriver());
		
		log.info("VP ProjectCodeSearching_01 - 13: Result table displayed correctly");
		verifyTrue(homePage.isTableByIdContainsText(DriverManager.getDriver(), "liveGrid_HistoryCard_tab", "ARBO"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private ConfigPage configPage;
	private MainPage homePage;
}
