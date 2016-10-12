package page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.jetty.html.Page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import common.AutomationAction;

public class AbstractPage extends AutomationAction {

	protected AbstractPage() {
		log = LogFactory.getLog(getClass());
		control.setPage(this.getClass().getSimpleName());
		log.debug("Created page abstraction for " + getClass().getName());
	}

	//=====================================Action Methods===========================//
	/**
	 * Logout
	 * @param driver
	 */
	public void logout(WebDriver driver) {
		scrollPage(driver, 0, 0);
		click(driver, Mailosaur.AbstractPage.userDropdown);
		click(driver, Mailosaur.AbstractPage.logoutLink);
		sleep();//wait for log out
	}
	
	/**
	 * select New Mailbox In Mail Dropdown
	 * @param driver
	 */
	public void selectNewMailboxInMailDropdown(WebDriver driver){
		scrollPage(driver, 0, 0);
		click(driver, Mailosaur.AbstractPage.mailboxesDropdown);
		click(driver, Mailosaur.AbstractPage.newMailboxLink);
	}
	
	/**
	 * Check Site logo displayed
	 * @param driver
	 * @return
	 */
	public boolean isSiteLogoDisplayed(WebDriver driver){
		return isControlDisplayed(driver,  Mailosaur.AbstractPage.siteLogo);
	}
	
	/**
	 * Check Site top menu displayed
	 * @param driver
	 * @return
	 */
	public boolean isSiteTopMenuDisplayed(WebDriver driver){
//		sleep(10);
//		scrollPageToControl(driver, Mailosaur.AbstractPage.siteTopMenu);
		return isControlDisplayed(driver,  Mailosaur.AbstractPage.siteTopMenu);
	}
	
	
	/**
	 * Check Site bottom menu displayed
	 * @param driver
	 * @return
	 */
	public boolean isSiteBottomMenuDisplayed(WebDriver driver){
//		scrollPageToControl(driver, Mailosaur.AbstractPage.siteBottomMenu);
		return isControlDisplayed(driver,  Mailosaur.AbstractPage.siteBottomMenu);
	}
	
	/**
	 * click Button by text
	 * @param driver
	 */
	public void clickButtonByItsText(WebDriver driver, String text){
		click(driver, Mailosaur.AbstractPage.dynamicRegularButtonByName, text);
		sleep(3);
	}
	
	/**
	 * click Link button by text
	 * @param driver
	 */
	public void clickLinkButtonByItsText(WebDriver driver, String text){
		click(driver, Mailosaur.AbstractPage.dynamicLinkButtonByName, text);
	}
	
	/**
	 * click Link by text
	 * @param driver
	 */
	public void clickLinkByItsText(WebDriver driver, String text){
		click(driver, Mailosaur.AbstractPage.dynamicLinkByLinkName, text);
		sleep(2);
	}
	
	/**
	 * click Link button by text
	 * @param driver
	 */
	public HomePage clickOnSiteLogo(WebDriver driver){
		click(driver, Mailosaur.AbstractPage.siteLogo);
		sleep(4);
		return PageFactory.getHomePage(driver, ipClient);
	}
	
	/**
	 * Input textfield by textfield label
	 * @param driver
	 * @param label
	 * @param text
	 */
	public void inputTextfieldByTextfieldLabel(WebDriver driver, String label, String text){
		type(driver, Mailosaur.AbstractPage.dynamicTextFieldByTextfieldLabel, text, label);
		sleep(2);
	}
	
	/**
	 * Get Validate Message by label name
	 * @param driver
	 * @param label
	 * @return
	 */
	public String getValidateMessageByLabel(WebDriver driver, String label){
		return getText(driver, Mailosaur.AbstractPage.dynamicValidateMessagebyTextfieldLabel, label);
	}
	
	/**
	 * Check page header displayed correctly
	 * @param driver
	 * @param pageName
	 * @return
	 */
	public boolean isPageHeaderDisplayed(WebDriver driver, String pageName){
		return isControlDisplayed(driver, Mailosaur.AbstractPage.dynamicPageHeader, pageName);
	}
	
	/**
	 * Check page legend displayed correctly
	 * @param driver
	 * @param pageName
	 * @return
	 */
	public boolean isPageLegendDisplayed(WebDriver driver, String pageName){
		return isControlDisplayed(driver, Mailosaur.AbstractPage.dynamicPageLegend, pageName);
	}
	
	/**
	 * Check alert message is displayed correctly
	 * @param driver
	 * @param message
	 * @return
	 */
	public boolean isAlertMessageDisplayedCorrectly(WebDriver driver, String message){
		return isControlDisplayed(driver, Mailosaur.AbstractPage.dynamicAlertMessage, message);
	}
	
	/**
	 * Logout
	 * @param driver
	 */
	public void openUserDropdown(WebDriver driver) {
		scrollPage(driver, 0, 0);
		if(!isControlDisplayed(driver, Mailosaur.AbstractPage.logoutLink)) click(driver, Mailosaur.AbstractPage.userDropdown);
		sleep();
	}
	
	protected final Log log;
	private String ipClient;
}
