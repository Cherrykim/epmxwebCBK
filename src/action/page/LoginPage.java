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
		type(driver, epmxweb.LoginPage.usernameTextbox, emailAddress);
		type(driver, epmxweb.LoginPage.passwordTextbox, password);
		click(driver, epmxweb.LoginPage.loginButton);
		sleep(2);//sleep 2s to wait for page load
	}
	
	/**
	 * check Error Message Display With Content
	 * @param contentText
	 * @return true/false
	 */
	public boolean isErrorMessageDisplayWithContent(String contentText){
		String text = getText(driver, epmxweb.LoginPage.errorMessage);
		return text.contains(contentText);
	}
	
	/**
	 * check Error Message Display On Tooltip With Content
	 * @param content
	 * @return true/false
	 */
	public boolean isErrorMessageDisplayOnTooltipWithContent(String content){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement field = driver.findElement(epmxweb.LoginPage.usernameTextbox);
		String message = (String)js.executeScript("return arguments[0].validationMessage;", field);
		return message.contains(content);
	}
	
	/**
	 * check email address textbox display
	 * @return true/false
	 */
	public boolean isEmailAddressTextboxDisplay(){
		return isControlDisplayed(driver, epmxweb.LoginPage.usernameTextbox);
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
