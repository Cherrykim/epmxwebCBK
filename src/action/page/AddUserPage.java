package page;

import org.openqa.selenium.WebDriver;

public class AddUserPage extends AbstractPage {

	public AddUserPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public boolean isWelcomeMessageDisplayed(){
		return getText(driver, epmxweb.MainPage.welcomeMessage).contains("Welcome");
	}
	
	public void createNewUser(String userID, String firstName, String lastName, String emailAddress, String corporation){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_user.php");
		sleep(2);
		inputTextfieldByIDWithEnter(driver, "txt_UserName", userID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByIDWithEnter(driver, "txt_Password", "12345678");
		inputTextfieldByIDWithEnter(driver, "txt_Confirm", "12345678");
		inputTextfieldByIDWithEnter(driver, "txt_FName", firstName);
		inputTextfieldByIDWithEnter(driver, "txt_LName", lastName);
		inputTextfieldByIDWithEnter(driver, "txt_Email1", emailAddress);
		clickOnDivByItsText(driver, "Corporate Security");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			clickOnElementByItsID(driver, "img_Save");
			return;
		}
		clickOnCheckboxByName(driver, corporation);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewUserWithRole(String userID, String firstName, String lastName, String emailAddress, String userRole){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_user.php");
		sleep(2);
		inputTextfieldByID(driver, "txt_UserName", userID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(driver, "txt_Password", "12345678");
		inputTextfieldByID(driver, "txt_Confirm", "12345678");
		inputTextfieldByID(driver, "txt_FName", firstName);
		inputTextfieldByID(driver, "txt_LName", lastName);
		inputTextfieldByID(driver, "txt_Email1", emailAddress);
		selectItemFromDropdownByID(driver, "sel_UserClass", userRole);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	public void createNewUserWithRole(String userID, String firstName, String lastName, String emailAddress, String userRole, String corporation){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_user.php");
		sleep(2);
		inputTextfieldByID(driver, "txt_UserName", userID);
		clickOnElementByItsID(driver, "img_Add");
		if(isAlertPresent(driver)) {
			acceptAlert(driver);
			return;
		}
		inputTextfieldByID(driver, "txt_Password", "12345678");
		inputTextfieldByID(driver, "txt_Confirm", "12345678");
		inputTextfieldByID(driver, "txt_FName", firstName);
		inputTextfieldByID(driver, "txt_LName", lastName);
		inputTextfieldByID(driver, "txt_Email1", emailAddress);
		selectItemFromDropdownByID(driver, "sel_UserClass", userRole);
		selectItemFromDropdownByID(driver, "sel_Corporation", corporation);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	//temp
	
	public void selectRadioButtonByValue(String value){
		click(driver, epmxweb.LicenseAgreementPage.dynamicRadioButton, value);
		sleep();
	}
	
	public void clickOnButtonByValue(String value){
		click(driver, epmxweb.LicenseAgreementPage.dynamicButtonByValue, value);
		sleep();
	}
	
	public boolean isButtonByValueEnabled(String value){
		return isControlEnabled(driver, epmxweb.LicenseAgreementPage.dynamicButtonByValue, value);
	}
	
	public void changeDefaultCorporation(String userID, String corporation){
		openLink(driver, "https://cherry.epmxweb.com/master_files/add_user.php");
		sleep(2);
		inputTextfieldByIDWithEnter(driver, "txt_UserName", userID);
		clickOnElementByItsID(driver, "img_Modify");
		selectItemFromDropdownByID(driver, "sel_Corporation", corporation);
		clickOnElementByItsID(driver, "img_Save");
	}
	private WebDriver driver;
	private String ipClient;
}
