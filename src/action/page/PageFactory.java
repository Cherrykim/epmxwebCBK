package page;

import org.openqa.selenium.WebDriver;

public class PageFactory {

	/**
	 * get LoginPage
	 * @param driver
	 * @param ipClient
	 * @return LoginPage object
	 */
	public static LoginPage getLoginPage(WebDriver driver, String ipClient) {
		return new LoginPage(driver, ipClient);
	}

	/**
	 * get HomePage
	 * @param driver
	 * @param ipClient
	 * @return HomePage object
	 */
	public static HomePage getHomePage(WebDriver driver, String ipClient) {
		return new HomePage(driver, ipClient);
	}
	
	/**
	 * get ConfigPage
	 * @param driver
	 * @param ipClient
	 * @return ConfigPage object
	 */
	public static ConfigPage getConfigPage(WebDriver driver, String ipClient) {
		return new ConfigPage(driver, ipClient);
	}
}
