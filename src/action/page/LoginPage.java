package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	/**
	 * Login with emailAddress & password
	 * 
	 * @param emailAddress
	 * @param password
	 */
	public void login(String emailAddress, String password) {		
		type(driver, Mailosaur.LoginPage.usernameTextbox, emailAddress);
		type(driver, Mailosaur.LoginPage.passwordTextbox, password);
		click(driver, Mailosaur.LoginPage.loginButton);
		sleep(2);//sleep 2s to wait for page load
	}
	
	/**
	 * check Error Message Display With Content
	 * @param contentText
	 * @return true/false
	 */
	public boolean isErrorMessageDisplayWithContent(String contentText){
		String text = getText(driver, Mailosaur.LoginPage.errorMessage);
		return text.contains(contentText);
	}
	
	/**
	 * check Error Message Display On Tooltip With Content
	 * @param content
	 * @return true/false
	 */
	public boolean isErrorMessageDisplayOnTooltipWithContent(String content){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement field = driver.findElement(Mailosaur.LoginPage.usernameTextbox);
		String message = (String)js.executeScript("return arguments[0].validationMessage;", field);
		return message.contains(content);
	}
	
	/**
	 * check email address textbox display
	 * @return true/false
	 */
	public boolean isEmailAddressTextboxDisplay(){
		return isControlDisplayed(driver, Mailosaur.LoginPage.usernameTextbox);
	}
	
	public String getAlertText(){
		return getTextJavascriptAlert(driver);
	}
	
	public void acceptAlert(){
		if(isAlertPresent(driver)) acceptJavascriptAlert(driver);
	}
	
	private WebDriver driver;
	private String ipClient;
}
