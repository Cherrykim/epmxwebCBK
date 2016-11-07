package AdminPage;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import common.DriverManager;
import page.PageFactory;
import page.AddUserPage;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.MailinatorPage;

public class Admin_02_ForgotPassword extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {
		userID = "newuserid";
		userEmail = "qa1@mailinator.com";
		corporation = "Wadsworth Center";
		openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		addUserPage = PageFactory.getAddUserPage(DriverManager.getDriver(), ipClient);
		forgotPasswordPage = PageFactory.getForgotPasswordPage(DriverManager.getDriver(), ipClient);
		mailinatorPage = PageFactory.getMailinatorPage(DriverManager.getDriver(), ipClient);
		log.info("Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME, Constant.LoginData.PASSWORD);
		log.info("Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		log.info("Pre-condition - 04: Open Add user page");
		log.info("Pre-condition - 05: Create new user");
		addUserPage.createNewUser(userID, getUniqueNumber(), getUniqueNumber(), userEmail, corporation);
	}

	@Test(groups = { "regression" }, description = "Check cancel button works")
	public void ForgotPassword_001_CheckCancelButtonWorks() {	
		
		log.info("Step ForgotPassword_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_001 - 02: Input correct username and password");
		log.info("Step ForgotPassword_001 - 03: Accept Alert message");
		log.info("Step ForgotPassword_001 - 04: Open Forgot password page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/admin/forgot_password.php");

		log.info("Step ForgotPassword_001 - 05: Click on Cancel button");
		forgotPasswordPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Cancel");
		
		log.info("VP: Login page is displayed correctly");
		verifyEquals(loginPage.getPageTitle(DriverManager.getDriver()), "ePMX login page");
	}
	
	@Test(groups = { "regression" }, description = "Leave ID field blank")
	public void ForgotPassword_002_LeaveIDFieldBlank() {	
		
		log.info("Step ForgotPassword_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_002 - 02: Input correct username and password");
		log.info("Step ForgotPassword_002 - 03: Accept Alert message");
		log.info("Step ForgotPassword_002 - 04: Open Forgot password page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/admin/forgot_password.php");

		log.info("Step ForgotPassword_002 - 05: Click on Save button");
		forgotPasswordPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save");
		
		log.info("VP: 'Please enter User ID' error message is displayed correctly");
		verifyEquals(forgotPasswordPage.getAlertText(DriverManager.getDriver()), "Please enter User ID");
	}
	
	@Test(groups = { "regression" }, description = "Input wrong Username")
	public void ForgotPassword_003_InputWrongUsername() {	
		
		log.info("Step ForgotPassword_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_003 - 02: Input correct username and password");
		log.info("Step ForgotPassword_003 - 03: Accept Alert message");
		log.info("Step ForgotPassword_003 - 04: Open Forgot password page");
		
		log.info("Step ForgotPassword_003 - 05: Input incorrect User ID");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UserID", "UIOPPOIU123");

		log.info("Step ForgotPassword_003 - 05: Click on Save button");
		forgotPasswordPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save");
		
		log.info("VP: 'Invalid User ID' message is displayed correctly");
		verifyTrue(forgotPasswordPage.isTextDisplayed(DriverManager.getDriver(), "Invalid User ID"));
	}
	
	@Test(groups = { "regression" }, description = "Input correct Username")
	public void ForgotPassword_004_InputCorrectUsername() {	
		
		log.info("Step ForgotPassword_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_004 - 02: Input correct username and password");
		log.info("Step ForgotPassword_004 - 03: Accept Alert message");
		log.info("Step ForgotPassword_004 - 04: Open Forgot password page");
		
		log.info("Step ForgotPassword_004 - 05: Input correct User ID");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UserID", userID);

		log.info("Step ForgotPassword_004 - 06: Click on Save button");
		forgotPasswordPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save");
		forgotPasswordPage.sleep(20);
		
		log.info("VP: 'Email has been sent to ...' message is displayed correctly");
		verifyEquals(forgotPasswordPage.getAlertText(DriverManager.getDriver()).trim(), "Email has been sent to "+userID);
	}
	
	@Test(groups = { "regression" }, description = "Input incorrect Verify password")
	public void ForgotPassword_005_InputIncorrectVerifyPassword() {	
		
		log.info("Step ForgotPassword_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_005 - 02: Input correct username and password");
		log.info("Step ForgotPassword_005 - 03: Accept Alert message");
		log.info("Step ForgotPassword_005 - 04: Open Forgot password page");
		log.info("Step ForgotPassword_005 - 05: Input correct User ID");
		log.info("Step ForgotPassword_005 - 06: Click on Save button");
		
		log.info("Step ForgotPassword_005 - 07: Open Mailbox to check Reset password email");
		loginPage.openLink(DriverManager.getDriver(), "https://www.mailinator.com");
		
		log.info("Step ForgotPassword_005 - 08: Input Email address");
		mailinatorPage.openMailbox(userEmail);
		
		log.info("Step ForgotPassword_005 - 09: Open Forgotten Password email");
		mailinatorPage.openMailByTitle("Forgotten Password");
		
		log.info("Step ForgotPassword_005 - 10: Click on New password link");
		mailinatorPage.openNewPasswordPage();
		
		log.info("Step ForgotPassword_005 - 11: Switch to new tab");
		mailinatorPage.switchTab(DriverManager.getDriver());
		
		log.info("Step ForgotPassword_005 - 12: Input incorrect Verfication code");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VerifyCode", "aaaaaa");
		
		log.info("Step ForgotPassword_005 - 13: Click on Save button");
		forgotPasswordPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save");
		
		log.info("VP: 'Verfication code does not match.' message is displayed correctly");
		verifyEquals(forgotPasswordPage.getAlertText(DriverManager.getDriver()), "Verfication code does not match.");
	}
	
	@Test(groups = { "regression" }, description = "Leave new password field blank")
	public void ForgotPassword_006_LeaveNewPasswordFieldBlank() {	
		
		log.info("Step ForgotPassword_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_006 - 02: Input correct username and password");
		log.info("Step ForgotPassword_006 - 03: Accept Alert message");
		log.info("Step ForgotPassword_006 - 04: Open Forgot password page");
		log.info("Step ForgotPassword_006 - 05: Input correct User ID");
		log.info("Step ForgotPassword_006 - 06: Click on Save button");
		log.info("Step ForgotPassword_006 - 07: Open Mailbox to check Reset password email");
		log.info("Step ForgotPassword_006 - 08: Input Email address");
		log.info("Step ForgotPassword_006 - 09: Open Forgotten Password email");
		log.info("Step ForgotPassword_006 - 10: Click on New password link");
		log.info("Step ForgotPassword_006 - 11: Switch to new tab");
		log.info("Step ForgotPassword_006 - 12: Input Correct Verfication code");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_VerifyCode", forgotPasswordPage.getVerficationCode());
		
		log.info("Step ForgotPassword_006 - 13: Click on Save button");
		forgotPasswordPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save");
		
		log.info("VP: 'Verfication code does not match.' message is displayed correctly");
		verifyEquals(forgotPasswordPage.getAlertText(DriverManager.getDriver()), "Password fields are empty.");
	}
	
	@Test(groups = { "regression" }, description = "Input  password without upcase")
	public void ForgotPassword_007_InputPasswordWithoutUpcase() {	
		
		log.info("Step ForgotPassword_007 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_007 - 02: Input correct username and password");
		log.info("Step ForgotPassword_007 - 03: Accept Alert message");
		log.info("Step ForgotPassword_007 - 04: Open Forgot password page");
		log.info("Step ForgotPassword_007 - 05: Input correct User ID");
		log.info("Step ForgotPassword_007 - 06: Click on Save button");
		log.info("Step ForgotPassword_007 - 07: Open Mailbox to check Reset password email");
		log.info("Step ForgotPassword_007 - 08: Input Email address");
		log.info("Step ForgotPassword_007 - 09: Open Forgotten Password email");
		log.info("Step ForgotPassword_007 - 10: Click on New password link");
		log.info("Step ForgotPassword_007 - 11: Switch to new tab");
		log.info("Step ForgotPassword_007 - 12: Input Correct Verfication code");
		log.info("Step ForgotPassword_007 - 13: Input new password without upcase characters");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Password", "12345678");
		
		log.info("Step ForgotPassword_007 - 14: Click on Save button");
		forgotPasswordPage.clickOnElementByItsID(DriverManager.getDriver(), "txt_Confirm");
		
		log.info("VP: 'Password must contain one upper case letter (A-Z).' message is displayed correctly");
		verifyEquals(forgotPasswordPage.getAlertText(DriverManager.getDriver()), "Password must contain one upper case letter (A-Z).");
	}
	
	@Test(groups = { "regression" }, description = "Input  password without special character")
	public void ForgotPassword_008_InputPasswordWithoutSpecialCharacter() {	
		
		log.info("Step ForgotPassword_008 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_008 - 02: Input correct username and password");
		log.info("Step ForgotPassword_008 - 03: Accept Alert message");
		log.info("Step ForgotPassword_008 - 04: Open Forgot password page");
		log.info("Step ForgotPassword_008 - 05: Input correct User ID");
		log.info("Step ForgotPassword_008 - 06: Click on Save button");
		log.info("Step ForgotPassword_008 - 07: Open Mailbox to check Reset password email");
		log.info("Step ForgotPassword_008 - 08: Input Email address");
		log.info("Step ForgotPassword_008 - 09: Open Forgotten Password email");
		log.info("Step ForgotPassword_008 - 10: Click on New password link");
		log.info("Step ForgotPassword_008 - 11: Switch to new tab");
		log.info("Step ForgotPassword_008 - 12: Input Correct Verfication code");
		log.info("Step ForgotPassword_008 - 13: Input new password without upcase characters");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Password", "A12345678");
		
		log.info("Step ForgotPassword_008 - 14: Click on Save button");
		forgotPasswordPage.clickOnElementByItsID(DriverManager.getDriver(), "txt_Confirm");
		
		log.info("VP: 'Password must contain one special character.' message is displayed correctly");
		verifyEquals(forgotPasswordPage.getAlertText(DriverManager.getDriver()), "Password must contain one special character.");
	}
	
	@Test(groups = { "regression" }, description = "Input  password less than 8 character")
	public void ForgotPassword_009_InputPasswordLessThan8Character() {	
		
		log.info("Step ForgotPassword_009 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_009 - 02: Input correct username and password");
		log.info("Step ForgotPassword_009 - 03: Accept Alert message");
		log.info("Step ForgotPassword_009 - 04: Open Forgot password page");
		log.info("Step ForgotPassword_009 - 05: Input correct User ID");
		log.info("Step ForgotPassword_009 - 06: Click on Save button");
		log.info("Step ForgotPassword_009 - 07: Open Mailbox to check Reset password email");
		log.info("Step ForgotPassword_009 - 08: Input Email address");
		log.info("Step ForgotPassword_009 - 09: Open Forgotten Password email");
		log.info("Step ForgotPassword_009 - 10: Click on New password link");
		log.info("Step ForgotPassword_009 - 11: Switch to new tab");
		log.info("Step ForgotPassword_009 - 12: Input Correct Verfication code");
		log.info("Step ForgotPassword_009 - 13: Input new password without upcase characters");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Password", "A123!");
		
		log.info("Step ForgotPassword_009 - 14: Click on Save button");
		forgotPasswordPage.clickOnElementByItsID(DriverManager.getDriver(), "txt_Confirm");
		
		log.info("VP: 'Minimum length of the password is 8 character(s).' message is displayed correctly");
		verifyEquals(forgotPasswordPage.getAlertText(DriverManager.getDriver()), "Minimum length of the password is 8 character(s).");
	}
	
	@Test(groups = { "regression" }, description = "Input password not match")
	public void ForgotPassword_010_InputPasswordNotMatch() {	
		
		log.info("Step ForgotPassword_010 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_010 - 02: Input correct username and password");
		log.info("Step ForgotPassword_010 - 03: Accept Alert message");
		log.info("Step ForgotPassword_010 - 04: Open Forgot password page");
		log.info("Step ForgotPassword_010 - 05: Input correct User ID");
		log.info("Step ForgotPassword_010 - 06: Click on Save button");
		log.info("Step ForgotPassword_010 - 07: Open Mailbox to check Reset password email");
		log.info("Step ForgotPassword_010 - 08: Input Email address");
		log.info("Step ForgotPassword_010 - 09: Open Forgotten Password email");
		log.info("Step ForgotPassword_010 - 10: Click on New password link");
		log.info("Step ForgotPassword_010 - 11: Switch to new tab");
		log.info("Step ForgotPassword_010 - 12: Input Correct Verfication code");
		log.info("Step ForgotPassword_010 - 13: Input new password without upcase characters");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Password", "A123456!");
		
		log.info("Step ForgotPassword_010 - 14: Input confirm password not match with new password");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Confirm", "A1234567!");
		
		log.info("Step ForgotPassword_010 - 15: Click on Save button");
		forgotPasswordPage.clickOnElementByItsID(DriverManager.getDriver(), "txt_Password");
		
		log.info("VP: 'Passwords do not Match. Please re-enter.' message is displayed correctly");
		verifyEquals(forgotPasswordPage.getAlertText(DriverManager.getDriver()), "Passwords do not Match. Please re-enter.");
	}
	
	@Test(groups = { "regression" }, description = "Input correct password")
	public void ForgotPassword_011_InputPasswordCorrectly() {	
		
		log.info("Step ForgotPassword_011 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step ForgotPassword_011 - 02: Input correct username and password");
		log.info("Step ForgotPassword_011 - 03: Accept Alert message");
		log.info("Step ForgotPassword_011 - 04: Open Forgot password page");
		log.info("Step ForgotPassword_011 - 05: Input correct User ID");
		log.info("Step ForgotPassword_011 - 06: Click on Save button");
		log.info("Step ForgotPassword_011 - 07: Open Mailbox to check Reset password email");
		log.info("Step ForgotPassword_011 - 08: Input Email address");
		log.info("Step ForgotPassword_011 - 09: Open Forgotten Password email");
		log.info("Step ForgotPassword_011 - 10: Click on New password link");
		log.info("Step ForgotPassword_011 - 11: Switch to new tab");
		log.info("Step ForgotPassword_011 - 12: Input Correct Verfication code");
		log.info("Step ForgotPassword_011 - 13: Input new password without upcase characters");
		log.info("Step ForgotPassword_011 - 14: Input confirm password match with new password");
		forgotPasswordPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Confirm", "A123456!");
		
		log.info("Step ForgotPassword_011 - 15: Click on Save button");
		forgotPasswordPage.clickOnElementByItsTitle(DriverManager.getDriver(), "Save");
		
		log.info("Step ForgotPassword_011 - 16: Input correct username and password");
		loginPage.login(userID, "A123456!");
		
		
		log.info("Step ForgotPassword_011 - 17: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("VP: 'End User License Agreement' message is displayed correctly");
		verifyEquals(loginPage.getPageTitle(DriverManager.getDriver()), "End User License Agreement");
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private AddUserPage addUserPage;
	private ForgotPasswordPage forgotPasswordPage;
	private MailinatorPage mailinatorPage;
	private String userID, userEmail, corporation;
}
