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
	
	public void openUrlFromUrlList(WebDriver driver, String baseUrl, String[] urlList){
		System.out.println(urlList.length);
		for(String url : urlList){
			if(!url.isEmpty())
			System.out.println("Link: " + baseUrl+url);
			openLink(driver, baseUrl+url);
//			else;
		}
	}
	
	/**
	 * Check alert message is displayed correctly
	 * @param driver
	 * @param text
	 * @return
	 */
	public boolean isTextDisplayed(WebDriver driver, String text){
		return isControlDisplayedWithLowerTimeOut(driver, epmxweb.AbstractPage.dynamicText, text);
	}
	
	/**
	 * click Button by text
	 * @param driver
	 */
	public void clickButtonByItsText(WebDriver driver, String text){
		click(driver, epmxweb.AbstractPage.dynamicRegularButtonByName, text);
		sleep(3);
	}
	
	/**
	 * click Link button by text
	 * @param driver
	 */
	public void clickLinkButtonByItsText(WebDriver driver, String text){
		click(driver, epmxweb.AbstractPage.dynamicLinkButtonByName, text);
	}
	
	/**
	 * click Link by text
	 * @param driver
	 */
	public void clickLinkByItsText(WebDriver driver, String text){
		click(driver, epmxweb.AbstractPage.dynamicLinkByLinkName, text);
		sleep(2);
	}
	
	/**
	 * click Link by text
	 * @param driver
	 */
	public boolean isLinkByItsTextDisplayed(WebDriver driver, String text){
		return isControlDisplayed(driver, epmxweb.AbstractPage.dynamicLinkByLinkName, text);
	}
	
	/**
	 * click Link by text
	 * @param driver
	 */
	public void clickLinkByItsText(WebDriver driver, String text, String index){
		click(driver, epmxweb.AbstractPage.dynamicLinkByLinkNameWithIndex, text, index);
		sleep(2);
	}
	
	/**
	 * Input textfield by textfield label
	 * @param driver
	 * @param label
	 * @param text
	 */
	public void inputTextfieldByTextfieldLabel(WebDriver driver, String label, String text){
		type(driver, epmxweb.AbstractPage.dynamicTextFieldByTextfieldLabel, text, label);
		sleep(2);
	}
	
	/**
	 * Input textfield by textfield id
	 * @param driver
	 * @param label
	 * @param text
	 */
	public void inputTextfieldByIDWithEnter(WebDriver driver, String id, String text){
		type(driver, epmxweb.AbstractPage.dynamicTextFieldByID, text, id);
		keyPressing("enter");
		keyPressing("enter");
	}
	
	/**
	 * Input textfield by textfield id
	 * @param driver
	 * @param label
	 * @param text
	 */
	public void inputTextfieldByID(WebDriver driver, String id, String text){
		type(driver, epmxweb.AbstractPage.dynamicTextFieldByID, text, id);
	}
	
	/**
	 * Input textfield by textfield id
	 * @param driver
	 * @param label
	 * @param text
	 */
	public String getTextfieldByID(WebDriver driver, String id){
		return getAttributeValue(driver, epmxweb.AbstractPage.dynamicTextFieldByID, "value", id);
	}
	
	/**
	 * Input textfield by textfield id
	 * @param driver
	 * @param label
	 * @param text
	 */
	public void inputTextfieldByName(WebDriver driver, String name, String text){
		type(driver, epmxweb.AbstractPage.dynamicTextFieldByName, text, name);
	}
	
	/**
	 * Input textfield by textfield id
	 * @param driver
	 * @param label
	 * @param text
	 */
	public String getTextfieldByName(WebDriver driver, String name){
		return getAttributeValue(driver, epmxweb.AbstractPage.dynamicTextFieldByName, "value", name);
	}
	
	public void clickOnClearButton(WebDriver driver){
		click(driver, epmxweb.AbstractPage.clearButton);
		sleep(3);
	}
	
	public void clickOnSearchButton(WebDriver driver){
		click(driver, epmxweb.AbstractPage.searchButton);
		sleep(3);
	}
	
	public void selectItemFromDropdownByID(WebDriver driver, String id, String item){
		sleep();
		selectComboxboxItem(driver, epmxweb.AbstractPage.dynamicSelectFieldByID, item, id);
		sleep();
	}
	
	
	public String getSelectedItemByID(WebDriver driver, String id){
		return getSelectedComboboxItem(driver, epmxweb.AbstractPage.dynamicSelectFieldByID, id);
	}
	
	public void selectItemFromDropdownByClass(WebDriver driver, String className, String item){
		selectComboxboxItem(driver, epmxweb.AbstractPage.dynamicSelectFieldByClass, item, className);
		sleep();
	}
	
	public String getSelectedItemByClass(WebDriver driver, String className){
		return getSelectedComboboxItem(driver, epmxweb.AbstractPage.dynamicSelectFieldByClass, className);
	}
	
	public void selectItemFromDropdownByName(WebDriver driver, String name, String item){
		selectComboxboxItem(driver, epmxweb.AbstractPage.dynamicSelectFieldByName, item, name);
		sleep();
	}
	
	public String getSelectedItemByName(WebDriver driver, String name){
		return getSelectedComboboxItem(driver, epmxweb.AbstractPage.dynamicSelectFieldByName, name);
	}
	
	public boolean isTableByIdContainsText(WebDriver driver, String id, String item){
		return isControlDisplayed(driver, epmxweb.AbstractPage.dynamicTableByIDContainsText, id, item);
	}
	
    public String getPageTitle(WebDriver driver) {
    	sleep(2);
        return driver.getTitle();
    }
    
    public void clickOnElementByItsID(WebDriver driver, String id){
    	click(driver, epmxweb.AbstractPage.dynamicElementByID, id);
    	sleep(2);
    }
    
    public void clickOnElementByItsTitle(WebDriver driver, String title){
    	click(driver, epmxweb.AbstractPage.dynamicElementByTitle, title);
    	sleep(2);
    }
    
    public void clickOnDivByItsText(WebDriver driver, String divName){
    	click(driver, epmxweb.AbstractPage.dynamicDiv, divName);
    	sleep(2);
    }
    
    public void clickOnCheckboxByName(WebDriver driver, String checkboxName){
    	click(driver, epmxweb.AbstractPage.dynamicCheckboxByItsName, checkboxName);
    	sleep(2);
    }
    
    public String getAlertText(WebDriver driver){
		return getTextJavascriptAlert(driver);
	}
	
	public void acceptAlert(WebDriver driver){
		if(isAlertPresent(driver)) acceptJavascriptAlert(driver);
	}
	
	public void clickOnImageButtonByItsSrc(WebDriver driver, String src){
		click(driver, epmxweb.AbstractPage.dynamicImgByItsSrc, src);
    	sleep(3);
	}
	
	public void clickOnLinkByPreciselyText(WebDriver driver, String linkName){
		click(driver, epmxweb.AbstractPage.dynamicLinkByLinkNamePrecisely, linkName);
		sleep(2);
	}
	
	public boolean isLinkNameDisplayed(WebDriver driver, String linkName){
		return isControlDisplayed(driver, epmxweb.AbstractPage.dynamicLinkByLinkNamePrecisely, linkName);
	}
	
	public String getElementAttributeByID(WebDriver driver, String id, String value){
		return getAttributeValue(driver, epmxweb.AbstractPage.dynamicElementByID, value, id);
	}
	
	protected final Log log;
	private String ipClient;
}
