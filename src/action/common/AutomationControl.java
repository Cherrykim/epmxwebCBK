package common;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Element;
import config.XmlHelper;

public class AutomationControl {
	/**
	 * Load control information from xml file
	 * 
	 * @param controlName
	 */
	public void loadControlInfo(String controlName) {
		try {
			XmlHelper xml = new XmlHelper();
			xml.parseResource("src/interface/" + getPage() + ".xml");
			for (Element pageElement : xml.getElements("/page")) {
				for (Element control : xml.getElements(pageElement, "control")) {
					if (control.getElementsByTagName("name").item(0).getTextContent().equals(controlName)) {
						String value = control.getElementsByTagName("value").item(0).getTextContent();
						String type = control.getElementsByTagName("type").item(0).getTextContent();
						setControlType(type);
						setControlValue(value);
						break;
					}
				}
			}

		} catch (Exception e) {
			log.warn(e);
		}
	}

	/**
	 * find element
	 * 
	 * @param driver
	 * @param controlName
	 * @return web element
	 */
	public WebElement findElement(WebDriver driver, By controlName) {
		return driver.findElement(controlName);
	}

	/**
	 * find dynamic element
	 * 
	 * @param driver
	 * @param specialControl
	 * @param inputValue
	 * @return web element
	 */
	public WebElement findElement(WebDriver driver, String controlName, String... inputValue) {
		String value = String.format(controlName, inputValue);
		return driver.findElement(By.xpath(value));
	}

	/**
	 * get By for dynamic element
	 * 
	 * @param driver
	 * @param controlName
	 * @return by object for element
	 */
	public By getBy(WebDriver driver, String specialControl, String... inputValue) {
		String value = String.format(specialControl, inputValue);
		return By.xpath(value);
	}

	/**
	 * find list of element
	 * 
	 * @param driver
	 * @param controlName
	 * @return list Elements
	 */
	public List<WebElement> findElements(WebDriver driver, By controlName) {
		return driver.findElements(controlName);
	}

	/**
	 * find list of dynamic element
	 * 
	 * @param driver
	 * @param controlName
	 * @param inputValue
	 * @return list of dynamic element
	 */
	public List<WebElement> findElements(WebDriver driver, String controlName, String... inputValue) {
		String value = String.format(controlName, inputValue);
		return driver.findElements(By.xpath(value));
	}

	/**
	 * Set control value
	 * 
	 * @param controlValue
	 */
	public void setControlValue(String controlValue) {
		this.controlValue = controlValue;
	}

	/**
	 * get control value
	 * 
	 * @return
	 */
	public String getControlValue() {
		return controlValue;
	}

	/**
	 * set type of control
	 * 
	 * @param controlType
	 */
	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	/**
	 * get type of control
	 * 
	 * @param controlType
	 */
	public String getControlType() {
		return controlType;
	}

	/**
	 * get page
	 * 
	 */
	public String getPage() {
		return page;
	}

	/**
	 * set page
	 * 
	 * @param page
	 */
	public void setPage(String page) {
		this.page = page;
	}

	private String page;
	private String controlValue;
	private String controlType;
	protected final Log log = LogFactory.getLog(AutomationControl.class);	
}
