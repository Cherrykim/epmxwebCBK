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
		inputTextfieldByIDWithEnter(driver, "txt_Password", "12345678");
		inputTextfieldByIDWithEnter(driver, "txt_Confirm", "12345678");
		inputTextfieldByIDWithEnter(driver, "txt_FName", firstName);
		inputTextfieldByIDWithEnter(driver, "txt_LName", lastName);
		inputTextfieldByIDWithEnter(driver, "txt_Email1", emailAddress);
		clickOnDivByItsText(driver, "Corporate Security");
		clickOnCheckboxByName(driver, corporation);
		clickOnElementByItsID(driver, "img_Save");
	}
	
	private WebDriver driver;
	private String ipClient;
}
