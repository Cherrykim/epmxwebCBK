package ForgotPassword;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.HomePage;
import page.LoginPage;

public class ForgotPassword_01 extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		homePage = PageFactory.getHomePage(DriverManager.getDriver(), ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
	}

	@Test(groups = { "regression" }, description = "Login _Leave the User ID field blank")
	public void Login_001_LeaveUserIDBlank() {	
		
		log.info("Step Login_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Login_001 - 02: Leave User ID empty and click on Login button");
		loginPage.login("", "");
		
		log.info("VP - 01: The system will show error message: Please enter a  User ID");
		verifyTrue(loginPage.getAlertText().contains("Please enter a  User ID"));
	}
	
	@Test(groups = { "regression" }, description = "Login _Leave Password blank")
	public void Login_002_LeavePasswordBlank() {	
		
		log.info("Step Login_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Login_002 - 02: Input an User ID");
		log.info("Step Login_002 - 03: Leave Password field empty and click on Login button");
		loginPage.login("qa1", "");
		
		log.info("VP - 01: The system will show error message: Please enter a  Password");
		verifyTrue(loginPage.getAlertText().contains("Please enter a  Password"));
	}
	
	@Test(groups = { "regression" }, description = "Login _Input incorrect Username and Password ")
	public void Login_003_InputIncorrectUsernameAndPassword() {	
		
		log.info("Step Login_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Login_003 - 02: Input incorrect Username and Password then click on Login button");
		loginPage.login("qa1", "123456");
		
		log.info("VP - 01: The system will show error message: Invalid User ID");
		verifyTrue(loginPage.isErrorMessageDisplayWithContent("Invalid User ID"));
	}
	
	@Test(groups = { "regression" }, description = "Input correct Username and incorrect Password ")
	public void Login_004_InputCorrectUsernameAndIncorrectPassword() {	
		
		log.info("Step Login_004 - 01: Open the site http://tool.cherry.epmxweb.com/");
		log.info("Step Login_004 - 02: Select Brand: 'master'");
		log.info("Step Login_004 - 03: Choose available MySQL database and get an Username");
		log.info("Step Login_004 - 04: Open the site https://cherry.epmxweb.com");
		log.info("Step Login_004 - 05: Input correct username and incorrect password");
		loginPage.login(Constant.LoginData.USERNAME, "123456");
		
		log.info("VP - 01: The system will show error message: Invalid Password");
		verifyTrue(loginPage.isErrorMessageDisplayWithContent("Invalid Password"));
	}
	
	@Test(groups = { "regression" }, description = "Input correct Username and Password ")
	public void Login_005_InputCorrectUsernameAndPassword() {	
		
		log.info("Step Login_005 - 01: Open the site http://tool.cherry.epmxweb.com/");
		log.info("Step Login_005 - 02: Select Brand: 'master'");
		log.info("Step Login_005 - 03: Choose available MySQL database and get an Username");
		log.info("Step Login_005 - 04: Click on Config button and get default Password");
		log.info("Step Login_005 - 05: Open the site https://cherry.epmxweb.com");
		log.info("Step Login_005 - 06: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		
		log.info("Step Login_005 - 07: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("VP - 01: The system will show error message: Invalid Password");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private HomePage homePage;
}
