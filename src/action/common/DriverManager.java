package common;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> _webDriver = new ThreadLocal<WebDriver>();

	/**
	 * get driver from thread driver
	 * 
	 * @return driver for current thread
	 */
	public static WebDriver getDriver() {
		return _webDriver.get();
	}

	/**
	 * set current driver to thread driver
	 * 
	 * @param driver
	 */
	public static void setWebDriver(WebDriver driver) {
		_webDriver.set(driver);
	}

	/**
	 * remove current driver from thread driver
	 */
	public static void removeDriver() {
		_webDriver.remove();
	}

}
