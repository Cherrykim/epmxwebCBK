package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationAction {

	/**
	 * Print comment on console to NGreport
	 */
	protected AutomationAction() {
		log = LogFactory.getLog(getClass());
	}

	/**
	 * Check control display
	 * 
	 * @param driver
	 * @param controlName
	 * @return true/false
	 */
	public boolean isControlDisplayed(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		try {
			return control.findElement(driver, controlName).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check dynamic control display
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @return true/false
	 */
	public boolean isControlDisplayed(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		try {
			return control.findElement(driver, dynamicControlName, value).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * check control is selected
	 * 
	 * @param driver
	 * @param controlName
	 * @return true/ false
	 */
	public boolean isControlSelected(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		try {
			return control.findElement(driver, controlName).isSelected();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * check dynamic control is selected
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @return true/false
	 */
	public boolean isControlSelected(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		try {
			return control.findElement(driver, dynamicControlName, value).isSelected();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check control enabled
	 * 
	 * @param driver
	 * @param controlName
	 * @return true/false
	 */
	public boolean isControlEnabled(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		try {
			return control.findElement(driver, controlName).isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check dynamic control enabled
	 * 
	 * @param dynamicControlName
	 * @param value
	 * @return true/false
	 */
	public boolean isControlEnabled(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		try {
			return control.findElement(driver, dynamicControlName, value).isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * wait for page load
	 * 
	 * @param driver
	 */
	public void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, timeWait);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			log.debug(error.toString());
		}
		sleep(1);
	}

	/**
	 * wait for control displays
	 * 
	 * @param driver
	 * @param controlName
	 * @param timeout
	 */
	public void waitForControl(WebDriver driver, By controlName, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(controlName));
		} catch (Exception e) {
			log.debug("Element doesn't exist");
		}
	}

	/**
	 * Wait for dynamic control displays
	 * 
	 * @param driver
	 * @param controlName
	 * @param timeout
	 * @param value
	 * 
	 */
	public void waitForControl(WebDriver driver, String dynamicControlName, long timeout, String... inputValue) {
		try {
			By by = control.getBy(driver, dynamicControlName, inputValue);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Element doesn't exist");
		}
	}

	/**
	 * Wait for control does not display
	 * 
	 * @param driver
	 * @param controlName
	 * @param timeout
	 */
	public void waitForControlNotDisplayed(WebDriver driver, By controlName, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(controlName));
		} catch (Exception e) {
			log.debug("Control does not close");
		}
	}

	/**
	 * Wait for dynamic control does not display
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @param timeout
	 */
	public void waitForControlNotDisplayed(WebDriver driver, String dynamicControlName, long timeout, String... inputValue) {
		try {
			By by = control.getBy(driver, dynamicControlName, inputValue);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Control does not close");
		}
	}

	/**
	 * get control attribute
	 * 
	 * @param driver
	 * @param controlName
	 * @param attribute
	 * @return attribute value
	 */
	public String getAttributeValue(WebDriver driver, By controlName, String attribute) {
		waitForControl(driver, controlName, timeout);
		return control.findElement(driver, controlName).getAttribute(attribute);
	}

	/**
	 * get dynamic control attribute
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @param attribute
	 * @return attribute value
	 */
	public String getAttributeValue(WebDriver driver, String dynamicControlName, String attribute, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		return control.findElement(driver, dynamicControlName, value).getAttribute(attribute);
	}

	/**
	 * Click on control
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void click(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		control.findElement(driver, controlName).click();

	}

	/**
	 * Force Click on control
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void forceClick(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		element = control.findElement(driver, controlName);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * Click on dynamic control
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 */
	public void click(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		control.findElement(driver, dynamicControlName, value).click();
	}

	/**
	 * clear text in control
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void clear(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		control.findElement(driver, controlName).clear();
	}

	/**
	 * clear text in dynamic control
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 */
	public void clear(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		control.findElement(driver, dynamicControlName, value).clear();
	}

	/**
	 * enter value into control
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 */
	public void type(WebDriver driver, By controlName, String value) {
		waitForControl(driver, controlName, timeout);
		element = control.findElement(driver, controlName);
		element.clear();
		element.sendKeys(value);
	}
	
	/**
	 * enter value into dynamic control
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @param valueinput
	 */
	public void type(WebDriver driver, String dynamicControlName, String valueinput, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		element = control.findElement(driver, dynamicControlName, value);
		element.clear();
		element.sendKeys(valueinput);
	}
	
	

	/**
	 * get element
	 * 
	 * @param driver
	 * @param controlName
	 * @return web element
	 */
	public WebElement getElement(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		return control.findElement(driver, controlName);
	}

	/**
	 * get list of element
	 * 
	 * @param driver
	 * @param controlName
	 * @return list of element
	 */
	public List<WebElement> getElements(WebDriver driver, By controlName) {
		return control.findElements(driver, controlName);
	}

	/**
	 * get list of dynamic element
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @return list of dynamic element
	 */
	public List<WebElement> getElements(WebDriver driver, String dynamicControlName, String... value) {
		return control.findElements(driver, dynamicControlName, value);
	}

	/**
	 * press enter for a control
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void pressEnter(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		control.findElement(driver, controlName).sendKeys(Keys.ENTER);
	}

	/**
	 * get text for a control
	 * 
	 * @param driver
	 * @param controlName
	 * @return text of a control
	 */
	public String getText(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		return control.findElement(driver, controlName).getText();
	}

	/**
	 * get text for a dynamic control
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @return text of dynamic control
	 */
	public String getText(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		return control.findElement(driver, dynamicControlName, value).getText();
	}

	/**
	 * count element
	 * 
	 * @param driver
	 * @param controlName
	 * @return number of elements
	 */
	public int countElement(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		return control.findElements(driver, controlName).size();
	}

	/**
	 * count dynamic element
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @return number of dynamic elements
	 */
	public int countElement(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		return control.findElements(driver, dynamicControlName, value).size();
	}

	/**
	 * sleep in timeout (s)
	 * 
	 * @param timeout
	 */
	public void sleep(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * sleep with default time (timeSleep) (2s)
	 */
	public void sleep() {
		sleep(timeSleep);
	}

	/**
	 * execute javascript
	 * 
	 * @param driver
	 * @param javaSript
	 */
	public Object executeJavaScript(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			log.debug(e.getMessage());
			return null;
		}
	}

	/**
	 * get current url of page
	 * 
	 * @param driver
	 * @return url
	 */
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	/**
	 * scroll page down
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollPage(WebDriver driver, int x, int y) {
		executeJavaScript(driver, "window.scrollTo(" + x + "," + y + ");");
		sleep();
	}

	/**
	 * select item in dynamic Combobox
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @param item
	 */
	public void selectComboxboxItem(WebDriver driver, String dynamicControlName, String item, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		element = control.findElement(driver, dynamicControlName, value);
		Select select = new Select(element);
		select.selectByVisibleText(item);
	}

	/**
	 * select item in Combobox
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @param item
	 */
	public void selectComboxboxItem(WebDriver driver, By controlName, String item) {
		waitForControl(driver, controlName, timeout);
		element = control.findElement(driver, controlName);
		Select select = new Select(element);
		select.selectByVisibleText(item);
	}

	/**
	 * get selected item in combobox
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @return selectedItem
	 */
	public String getSelectedComboboxItem(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		element = control.findElement(driver, controlName);
		Select select = new Select(element);
		String itemSelected = select.getFirstSelectedOption().getText();
		return itemSelected;
	}
	
	/**
	 * get selected item in dynamic combobox
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @return
	 */
	public String getSelectedComboboxItem(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		element = control.findElement(driver, dynamicControlName, value);
		Select select = new Select(element);
		String itemSelected = select.getFirstSelectedOption().getText();
		return itemSelected;
	}

	/**
	 * check a checkbox
	 */
	public void checkACheckbox(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		element = control.findElement(driver, controlName);
		if (!element.isSelected()) {
			click(driver, controlName);
		}
	}
	
	/**
	 * get checkbox status
	 * @param driver
	 * @param controlName
	 * @return checked/unchecked
	 */
	public String getCheckboxStatus(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		element = control.findElement(driver, controlName);
		if (!element.isSelected()) {
			return "unchecked";
		}else return "checked";
	}

	/**
	 * uncheck a checkbox
	 */
	public void uncheckACheckbox(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		element = control.findElement(driver, controlName);
		if (element.isSelected()) {
			click(driver, controlName);
		}
	}

	/**
	 * check a dynamic checkbox
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 */
	public void checkACheckbox(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		element = control.findElement(driver, dynamicControlName, value);
		if (!element.isSelected()) {
			click(driver, dynamicControlName, value);
		}
	}

	/**
	 * get dynamic checkbox status
	 * @param driver
	 * @param dynamicControlName
	 * @return checked/unchecked
	 */
	public String getCheckboxStatus(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		element = control.findElement(driver, dynamicControlName, value);
		if (!element.isSelected()) {
			return "unchecked";
		}else return "checked";
	}
	
	/**
	 * uncheck a dynamic check box
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 */
	public void uncheckACheckbox(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		element = control.findElement(driver, dynamicControlName, value);
		if (element.isSelected()) {
			click(driver, dynamicControlName, value);
		}
	}
	
	/**
	 * switch to frame
	 * 
	 * @param driver
	 * @param controlName
	 * @return driver for frame
	 */
	public WebDriver switchToFrame(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		sleep();
		driver = driver.switchTo().frame(driver.findElement(controlName));
		sleep();
		return driver;
	}
	
	/**
	 * hover mouse on Element
	 * @param driver
	 * @param controlName
	 */
	public void hoverMouseOnElement(WebDriver driver, By controlName){
		Actions action = new Actions(driver);
		element = control.findElement(driver, controlName);
		action.moveToElement(element).perform();
	}
	
	/**
	 * hover mouse on dynamic Element
	 * @param driver
	 * @param controlName
	 */
	public void hoverMouseOnElement(WebDriver driver, String dynamicControlName, String... value){
		Actions action = new Actions(driver);
		element = control.findElement(driver, dynamicControlName, value);
		action.moveToElement(element).perform();
	}
	
	/**
	 * scroll page to dynamic Control
	 * @param driver
	 * @param dynamicControlName
	 * @param inputValue
	 */
	public void scrollPageToControl(WebDriver driver, String dynamicControlName, String... inputValue) {
		waitForControl(driver, dynamicControlName, timeout, inputValue);
		element = control.findElement(driver, dynamicControlName, inputValue);
		int x = element.getLocation().x;
		int y = element.getLocation().y;
		executeJavaScript(driver, "window.scrollTo(" + x + "," + y + ");");
		sleep(1);//wait for page scroll to the element
	}
	
	/**
	 * scroll page to static Control
	 * @param driver
	 * @param controlName
	 */
	public void scrollPageToControl(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, timeout);
		element = control.findElement(driver, controlName);
		int x = element.getLocation().x;
		int y = element.getLocation().y;
		executeJavaScript(driver, "window.scrollTo(" + x + "," + y + ");");
		sleep(1);//wait for page scroll to the element
	}

	/**
	 * open link
	 * 
	 * @param driver
	 * @param url
	 */
	public void openLink(WebDriver driver, String url) {
		try{
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(url);
		}
		catch(Exception e)
		{
			System.out.println("Time out. Can't open this URL: "+url);
		}
		sleep(3); //wait for link load successfully
	}
	
	
	public String switchWindow(WebDriver driver){
		String winHandleBefore;
        try {

        	 winHandleBefore = driver.getWindowHandle();

        	for(String winHandle : driver.getWindowHandles()){
        		driver.switchTo().window(winHandle);
        	}
        	}catch(Exception e){
        		return "Unable to Switch to main window" + e.getMessage();
        }
        return winHandleBefore;
       }
	
	public String switchWindowBackWithoutClose(WebDriver driver, String winHandleBefore){
        try {
            //Switch back to original browser (first window)
            driver.switchTo().window(winHandleBefore);
            //continue with original browser (first window)
        }catch(Exception e){
        return "Unable to Switch to main window" + e.getMessage();
        }
        return "Passed";
        }
	
	
	public String switchWindowBackAndCloseCurrentWindow(WebDriver driver, String winHandleBefore){
		try {
          driver.close(); 
          //Switch back to original browser (first window)
          driver.switchTo().window(winHandleBefore);
          //continue with original browser (first window)
      }catch(Exception e){
      return "Unable to Switch to main window" + e.getMessage();
      }
        return "Passed";
        }
	
	public String switchTab(WebDriver driver){
		sleep(3);
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
//		driver.close();
//		driver.switchTo().window(currentHandle);
		return currentHandle;
	}
	
//	public String switch
	
	/**
	 * switch To Top Window Frame
	 */
	public WebDriver switchToTopWindowFrame(WebDriver driver) {
		driver = driver.switchTo().defaultContent();
		return driver;
	}
	
	public boolean isAlertPresent(WebDriver driver) 
	{ 
		sleep(3);
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (Exception Ex) 
	    { 
	        return false; 
	    }   // catch 
	}  

	/**
	 * Accept Javascript alert
	 * 
	 * @param driver
	 */
	public void acceptJavascriptAlert(WebDriver driver) {
		sleep(3);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		sleep(2);
	}

	/**
	 * Dismiss Javascript alert
	 * 
	 * @param driver
	 */
	public void dismissJavascriptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * Get text of Javascript alert
	 * 
	 * @param driver
	 */
	public String getTextJavascriptAlert(WebDriver driver) {
		sleep(2);
		String message;
		try {
			Alert alert = driver.switchTo().alert();
			message = alert.getText();
			alert.accept();
		} catch (final WebDriverException e) {
			message = null;
		}
		return message;
	}

	/**
	 * Input text into Javascript prompt
	 * 
	 * @param driver
	 */
	public void acceptJavascriptPrompt(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert().sendKeys(value);
		alert.accept();
	}

	public String[] getUrlList(WebDriver driver, String fileName){
			return Common.getCommon().getUrlListByReadCSVFile(fileName);
	}
	
	public int getNumberOfUrl(WebDriver driver, String fileName){
		return Common.getCommon().getNumberOfUrl(fileName);
}
	
	/**
	 * Check dynamic control display
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @return true/false
	 */
	public boolean isControlDisplayedWithLowerTimeOut(WebDriver driver, String dynamicControlName, String... value) {
		waitForControl(driver, dynamicControlName, 2, value);
		try {
			return control.findElement(driver, dynamicControlName, value).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Close dialog download because web driver does not capture or use hot key
	 * 
	 * @param keyEvent
	 */
	public void keyPressing(String keyEvent) {
		try {
			Robot robot = new Robot();
			if (keyEvent == "esc") {
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				sleep();
			}
			if (keyEvent == "enter") {
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				sleep(5);
			}
			if (keyEvent == "tab") {
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}
			if (keyEvent == "space") {
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_SPACE);
			}
			if (keyEvent == "alt_s") {
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_S);
			}
			if (keyEvent == "window_q") {
				robot.keyPress(KeyEvent.VK_WINDOWS);
				robot.keyPress(KeyEvent.VK_Q);
				robot.keyRelease(KeyEvent.VK_WINDOWS);
				robot.keyRelease(KeyEvent.VK_Q);
			}
		} catch (AWTException e) {
			log.debug("Can not use Key");
		}
	}
	
	public String convertDate(String oldDateType, String newDateType, String date)
	{
		String newDateString;

		SimpleDateFormat sdf = new SimpleDateFormat(oldDateType);
		Date d = new Date();
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sdf.applyPattern(newDateType);
		newDateString = sdf.format(d);
		return newDateString.toString();
	}
	
	/**
	 * enter value into control
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 */
	public void upload(WebDriver driver, By controlName, String value) {
		waitForControl(driver, controlName, timeout);
		element = control.findElement(driver, controlName);
		element.sendKeys(value);
	}

	/**
	 * enter value into dynamic control
	 * 
	 * @param driver
	 * @param dynamicControlName
	 * @param value
	 * @param valueinput
	 */
	public void upload(WebDriver driver, String dynamicControlName, String valueinput, String... value) {
		waitForControl(driver, dynamicControlName, timeout, value);
		element = control.findElement(driver, dynamicControlName, value);
		element.sendKeys(valueinput);
	}
	
	/**
	 * get full path of file
	 */
	public String getPathFile(String fileName) {
		File file = new File(fileName);
		return file.getAbsolutePath();
	}
	
	protected int timeout = 15;
	protected int timeWait = 30;
	protected int timeSleep = 2;
	protected WebElement element;
	protected AutomationControl control = new AutomationControl();
	protected final Log log;
	private final Stack<String> openWindowHandles = new Stack<String>();
}
