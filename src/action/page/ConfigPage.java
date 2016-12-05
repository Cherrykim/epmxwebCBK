package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.Constant;

public class ConfigPage extends AbstractPage {

	public ConfigPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public void selectBranchAndDatabase(String branch, String dataBase){
		openLink(driver, Constant.PageUrl.TOOL_PAGE_URL);
		selectComboxboxItem(driver, epmxweb.ConfigPage.selectBranch, branch);
		sleep(2);
		if(!isControlDisplayed(driver, epmxweb.ConfigPage.dynamicUsingDatabese, dataBase))
		click(driver, epmxweb.ConfigPage.dynamicDatabaseUseButton, dataBase);
		sleep(2);
		openLink(driver, Constant.PageUrl.TEST_PAGE_URL);
	}
	
	//temp
	
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
