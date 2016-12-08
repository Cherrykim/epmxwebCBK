package CheckCSVUrls;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.ConfigPage;
import page.LoginPage;

public class UrlsCheckingMysqlpdo extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		configPage = PageFactory.getConfigPage(DriverManager.getDriver(), ipClient);
		baseUrl = "https://cherry.epmxweb.com";
		log.info("Pre-condition - 01: Open the site http://tool.cherry.epmxweb.com/");
		log.info("Pre-condition - 02: Select Brand: 'mysqlpdo'");
		log.info("Pre-condition - 03: Choose available MySQL database and get an Username");
		log.info("Pre-condition - 04: Click on Config button and get default Password");
		log.info("Pre-condition - 05: Open the site https://cherry.epmxweb.com");
		configPage.selectBranchAndDatabase("mysqlpdo", Constant.DefaultValue.CURRENT_DATABASE);
	}
	
	@Test(groups = { "regression" }, description = "Check page is displayed correctly")
	public void UrlsChecking_01_CheckPageIsDisplayedCorrectly() {	
		
		log.info("Step UrlsChecking_01 - 01: Open the site http://tool.cherry.epmxweb.com/");
		log.info("Step UrlsChecking_01 - 02: Select Brand: 'master'");
		log.info("Step UrlsChecking_01 - 03: Choose available MySQL database and get an Username");
		log.info("Step UrlsChecking_01 - 04: Click on Config button and get default Password");
		log.info("Step UrlsChecking_01 - 05: Open the site https://cherry.epmxweb.com");
		log.info("Step UrlsChecking_01 - 06: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
		
		log.info("Step UrlsChecking_01 - 07: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step UrlsChecking_01 - 08: Accept Alert message");
		urlList = loginPage.getUrlList(DriverManager.getDriver(), Constant.DefaultValue.URL_CSV_FILENAME);
		numberOfUrl = loginPage.getNumberOfUrl(DriverManager.getDriver(), Constant.DefaultValue.URL_CSV_FILENAME);
		loop = 0;
		log.info("Step UrlsChecking_01 - 09: Start checking for "+ numberOfUrl + " page screen");
		for(int i = 0; i<numberOfUrl; i++){
			
			if(loop==20) {
				log.info("Step UrlsChecking_01 - 05: Open the site https://cherry.epmxweb.com");
				log.info("Step UrlsChecking_01 - 06: Input correct username and password");
				loginPage.openLink(DriverManager.getDriver(), baseUrl);
				loginPage.login(Constant.LoginData.USERNAME_NYDOH, Constant.LoginData.PASSWORD);
				
				log.info("Step UrlsChecking_01: Accept alert if it's displayed ");
				loginPage.acceptAlert();
				
				loop = 0;
			} 
			
			loop++;
			
			log.info("Step UrlsChecking_01: Navigate to url: "+ baseUrl + urlList[i]);
			loginPage.openLink(DriverManager.getDriver(), baseUrl +  urlList[i]);
			
			log.info("Step UrlsChecking_01: Accept alert if it's displayed ");
			loginPage.acceptAlert();
			
			log.info("VP : The text 'Powered by' is showed in the page with Url: "+ baseUrl + urlList[i]);
			verifyTrue(loginPage.isTextDisplayed(DriverManager.getDriver(), "Powered by"));
			
			log.info("VP : The text 'version' is showed in the page with Url: "+ baseUrl + urlList[i]);
			verifyTrue(loginPage.isTextDisplayed(DriverManager.getDriver(), "version"));
			
			log.info("VP : The text 'There is an error on the page' is not showed in the page with Url: "+ baseUrl + urlList[i]);
			verifyFalse(loginPage.isTextDisplayed(DriverManager.getDriver(), "There is an error on the page"));
			verifyFalse(loginPage.isTextDisplayed(DriverManager.getDriver(), "There is an error in the Page"));
			
			log.info("VP : The text 'Could not connect' is not showed in the page with Url: "+ baseUrl + urlList[i]);
			verifyFalse(loginPage.isTextDisplayed(DriverManager.getDriver(), "Could not connect"));
		}
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private ConfigPage configPage;
	private String[] urlList;
	private String baseUrl;
	private int numberOfUrl, loop;
}
