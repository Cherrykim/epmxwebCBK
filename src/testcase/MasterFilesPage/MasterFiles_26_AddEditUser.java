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

public class MasterFiles_26_AddEditUser extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		openBrowser(browser, port, ipClient);
		
		loginPage = PageFactory.getLoginPage(DriverManager.getDriver(), ipClient);
		masterFilesPage = PageFactory.getMasterFilesPage(DriverManager.getDriver(), ipClient);
		newUser = getUniqueText(12);
		glAccountCode1 = "glNo3";
		glAccountCode2 = "glNo4";
		corp1 = "corpNo1";
		corp2 = "corpNo2";
		
		log.info("Step Pre-condition - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step Pre-condition - 02: Input correct username and password");
		loginPage.login(Constant.LoginData.USERNAME_CBK, Constant.LoginData.PASSWORD);
		
		log.info("Step Pre-condition - 03: Accept Alert message");
		loginPage.acceptAlert();
		
		log.info("Step Pre-condition - 04: Create new Corp");
		masterFilesPage.createNewCorporation(corp1);
		masterFilesPage.createNewCorporation(corp2);
		
		log.info("Step Pre-condition - 05: Create GL Account");
		masterFilesPage.createNewGLAccount(corp1, glAccountCode1);
		masterFilesPage.assignGLAccount(glAccountCode1, Constant.LoginData.USERNAME_CBK);
		masterFilesPage.createNewGLAccount(corp2, glAccountCode2);
		masterFilesPage.assignGLAccount(glAccountCode2, Constant.LoginData.USERNAME_CBK);

	}

	@Test(groups = { "regression" }, description = "Check Add User works")
	public void AddEditUser_001_CheckAddUserWorks() {	
		
		log.info("Step AddEditUser_001 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUser_001 - 02: Input correct username and password");
		log.info("Step AddEditUser_001 - 03: Accept Alert message");
		log.info("Step AddEditUser_001 - 04: Open Add User page");
		loginPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/add_user.php");

		log.info("Step AddEditUser_001 - 05: Input new User");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UserName", newUser);
		
		log.info("Step AddEditUser_001 - 06: Click on Add button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add");
		
		log.info("Step AddEditUser_001 - 07: Input All field");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Password", "12345678");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Confirm", "12345678");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FName", newUser);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LName", newUser);
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Email1", "email1@gmail.com");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Email2", "email2@gmail.com");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_MailStation", "gmail");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ChatID", "email@gmail.com");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Phone", "123456789");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Fax", "12345");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", corp1);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UserClass", "Admin");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Language", "English");

		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_Address", "141 Baker street");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "London");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_County", "County 1");
		masterFilesPage.selectRadioButtonByName(DriverManager.getDriver(), "Non US");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_State", "No State");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Country", "UK");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12345");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ZipFour", "1234");

		
		log.info("Step AddEditUser_001 - 08: Assign GL Account code");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode1);
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add_field", "3");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "ok", "3");
		
		log.info("Step AddEditUser_001 - 09: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditUser_001 - 10: Input new User");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UserName", newUser);
		
		log.info("Step AddEditUser_001 - 11: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All field saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_FName"), newUser);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_LName"), newUser);
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Email1"), "email1@gmail.com");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Email2"), "email2@gmail.com");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_MailStation"), "gmail");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ChatID"), "email@gmail.com");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Phone"), "123456789");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Fax"), "12345");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Corporation"), corp1);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_UserClass"), "Admin");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Language"), "English");

		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_Address"), "141 Baker street");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "London");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_County"), "County 1");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_State"), "No State");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Country"), "UK");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12345");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ZipFour"), "1234");
		
		log.info("VP: GL Account is selected");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		verifyTrue(masterFilesPage.isItemInSelectedList(DriverManager.getDriver(), "sel_Gl", glAccountCode1));
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "ok", "3");
	}
	
	@Test(groups = { "regression" }, description = "Check Edit User works")
	public void AddEditUser_002_CheckEdiUserWorks() {	
		
		log.info("Step AddEditUser_002 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUser_002 - 02: Input correct username and password");
		log.info("Step AddEditUser_002 - 03: Accept Alert message");
		log.info("Step AddEditUser_002 - 04: Open Add User page");
		log.info("Step AddEditUser_002 - 05: Input new User");
		log.info("Step AddEditUser_002 - 06: Click on Add button");
		log.info("Step AddEditUser_002 - 07: Input all fields");
		log.info("Step AddEditUser_002 - 08: Click on Save button");
		log.info("Step AddEditUser_002 - 09: Input new User");
		log.info("Step AddEditUser_002 - 10: Click on Modify button");
		log.info("Step AddEditUser_002 - 11: Input all fields");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FName", newUser+"second");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LName", newUser+"second");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Email1", "email1@yahoo.com");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Email2", "email2@yahoo.com");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_MailStation", "yahoo");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ChatID", "email@yahoo.com");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Phone", "123456780");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Fax", "12346");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Corporation", corp2);
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_UserClass", "Receiving");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_Language", "---SELECT---");
		
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_County", "County 2");
		masterFilesPage.inputTextareaByID(DriverManager.getDriver(), "txt_Address", "123 Nameless Street");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_City", "Washington");
		masterFilesPage.selectRadioButtonByName(DriverManager.getDriver(), "US");
		masterFilesPage.selectItemFromDropdownByID(DriverManager.getDriver(), "sel_State", "Alabama");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_Zip", "12346");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_ZipFour", "1235");
		
		log.info("Step AddEditUser_002 - 12: Input new data for GL Account code");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "removeall_field");
		masterFilesPage.inputSelecterTextfieldByID(DriverManager.getDriver(), "txt_GlAccount", glAccountCode2);
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "add_field", "3");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "ok", "3");
		
		log.info("Step AddEditUser_002 - 13: Click on Save button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "save");
		
		log.info("Step AddEditUser_002 - 14: Input new User");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UserName", newUser);
		
		log.info("Step AddEditUser_002 - 15: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: All field saved correctly");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_FName"), newUser+"second");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_LName"), newUser+"second");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Email1"), "email1@yahoo.com");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Email2"), "email2@yahoo.com");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_MailStation"), "yahoo");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ChatID"), "email@yahoo.com");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Phone"), "123456780");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Fax"), "12346");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Corporation"), corp2);
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_UserClass"), "Receiving");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_Language"), "---SELECT---");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_County"), "County 2");
		verifyEquals(masterFilesPage.getTextareaByID(DriverManager.getDriver(), "txt_Address").trim(), "123 Nameless Street");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_City"), "Washington");
		verifyEquals(masterFilesPage.getSelectedItemByID(DriverManager.getDriver(), "sel_State"), "Alabama");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_Zip"), "12346");
		verifyEquals(masterFilesPage.getTextfieldByID(DriverManager.getDriver(), "txt_ZipFour"), "1235");
		
		log.info("VP: GL Account is selected");
		masterFilesPage.clickOnElementByItsID(DriverManager.getDriver(), "btn_GL");
		verifyTrue(masterFilesPage.isItemInSelectedList(DriverManager.getDriver(), "sel_Gl", glAccountCode2));
	}
	
	@Test(groups = { "regression" }, description = "Check Deactivate User works")
	public void AddEditUser_003_CheckDeactivateUserWorks() {	
		
		log.info("Step AddEditUser_003 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUser_003 - 02: Input correct username and password");
		log.info("Step AddEditUser_003 - 03: Accept Alert message");
		log.info("Step AddEditUser_003 - 04: Open Add User page");
		log.info("Step AddEditUser_003 - 05: Input new User");
		log.info("Step AddEditUser_003 - 06: Click on Add button");
		log.info("Step AddEditUser_003 - 07: Input all information");
		log.info("Step AddEditUser_003 - 08: Click on Save button");
		log.info("Step AddEditUser_003 - 09: Input new User");
		log.info("Step AddEditUser_003 - 10: Click on Deactivate button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "deactivate");
		
		log.info("Step AddEditUser_003 - 11: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("Step AddEditUser_003 - 12: Input new User");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_UserName", newUser);
		
		log.info("Step AddEditUser_003 - 13: Click on Modify button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "manage");
		
		log.info("VP: Object Code is deactivated");
		verifyEquals(masterFilesPage.getAlertText(DriverManager.getDriver()), "Employee is deactivated. Press OK to reactivate or Cancel to view record only.");
	}
	
	@Test(groups = { "regression" }, description = "Check REactivate User works")
	public void AddEditUser_004_CheckReactivateUserWorks() {	
		
		log.info("Step AddEditUser_004 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUser_004 - 02: Input correct username and password");
		log.info("Step AddEditUser_004 - 03: Accept Alert message");
		log.info("Step AddEditUser_004 - 04: Open Add User page");
		log.info("Step AddEditUser_004 - 05: Input new User");
		log.info("Step AddEditUser_004 - 06: Click on Add button");
		log.info("Step AddEditUser_004 - 07: Input all information");
		log.info("Step AddEditUser_004 - 08: Click on Save button");
		log.info("Step AddEditUser_004 - 09: Input new User");
		log.info("Step AddEditUser_004 - 10: Click on Deactivate button");
		log.info("Step AddEditUser_004 - 11: Accept alert");
		log.info("Step AddEditUser_004 - 12: Input new User");
		log.info("Step AddEditUser_004 - 13: Click on Modify button");
		log.info("Step AddEditUser_004 - 14: Accept alert");
		masterFilesPage.acceptAlert(DriverManager.getDriver());
		
		log.info("VP: Save button is clickable");
		verifyEquals(masterFilesPage.getElementAttributeByID(DriverManager.getDriver(), "img_Save", "class"), "Button");
	}
	
	@Test(groups = { "regression" }, description = "Check Search User code by First name works")
	public void AddEditUser_005_SearchUserByFirstName() {	
		
		log.info("Step AddEditUser_005 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUser_005 - 02: Input correct username and password");
		log.info("Step AddEditUser_005 - 03: Accept Alert message");
		log.info("Step AddEditUser_005 - 04: Open Add User page");
		log.info("Step AddEditUser_005 - 05: Input new User code");
		log.info("Step AddEditUser_005 - 06: Click on Add button");
		log.info("Step AddEditUser_005 - 07: Input Description");
		log.info("Step AddEditUser_005 - 08: Click on Save button");
		log.info("Step AddEditUser_005 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_user.php");
		
		log.info("Step AddEditUser_005 - 10: Input User First name");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_FirstName", newUser);
		
		log.info("Step AddEditUser_005 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: User code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newUser, ""));
	}
	
	@Test(groups = { "regression" }, description = "Check Search User code by Last name works")
	public void AddEditUser_006_SearchUserByLastName() {	
		
		log.info("Step AddEditUser_006 - 01: Open the site https://cherry.epmxweb.com");
		log.info("Step AddEditUser_006 - 02: Input correct username and password");
		log.info("Step AddEditUser_006 - 03: Accept Alert message");
		log.info("Step AddEditUser_006 - 04: Open Add User page");
		log.info("Step AddEditUser_006 - 05: Input new User code");
		log.info("Step AddEditUser_006 - 06: Click on Add button");
		log.info("Step AddEditUser_006 - 07: Input Description");
		log.info("Step AddEditUser_006 - 08: Click on Save button");
		log.info("Step AddEditUser_006 - 09: Open Manager page");
		masterFilesPage.openLink(DriverManager.getDriver(), "https://cherry.epmxweb.com/master_files/manage_user.php");
		
		log.info("Step AddEditUser_006 - 10: Input User Last name");
		masterFilesPage.inputTextfieldByID(DriverManager.getDriver(), "txt_LastName", newUser);
		
		log.info("Step AddEditUser_006 - 11: Click on Search button");
		masterFilesPage.clickOnImageButtonByItsSrc(DriverManager.getDriver(), "search.gif");
		
		log.info("VP: User code displayed correctly");
		verifyTrue(masterFilesPage.isResultTableContainsRecord(DriverManager.getDriver(), newUser, newUser));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	private LoginPage loginPage;
	private MasterFilesPage masterFilesPage;
	private String newUser;
	private String glAccountCode1, glAccountCode2;
	private String corp1, corp2;
}
