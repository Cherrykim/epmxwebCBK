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
	public static MainPage getMainPage(WebDriver driver, String ipClient) {
		return new MainPage(driver, ipClient);
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
	
	/**
	 * get LicenseAgreementPage
	 * @param driver
	 * @param ipClient
	 * @return LicenseAgreementPage object
	 */
	public static LicenseAgreementPage getLicenseAgreementPage(WebDriver driver, String ipClient) {
		return new LicenseAgreementPage(driver, ipClient);
	}
	
	/**
	 * get ForgotPasswordPage
	 * @param driver
	 * @param ipClient
	 * @return ForgotPasswordPage object
	 */
	public static ForgotPasswordPage getForgotPasswordPage(WebDriver driver, String ipClient) {
		return new ForgotPasswordPage(driver, ipClient);
	}
	
	/**
	 * get AddUserPage
	 * @param driver
	 * @param ipClient
	 * @return AddUserPage object
	 */
	public static AddUserPage getAddUserPage(WebDriver driver, String ipClient) {
		return new AddUserPage(driver, ipClient);
	}
	
	/**
	 * get MailinatorPage
	 * @param driver
	 * @param ipClient
	 * @return MailinatorPage object
	 */
	public static MailinatorPage getMailinatorPage(WebDriver driver, String ipClient) {
		return new MailinatorPage(driver, ipClient);
	}
	
	/**
	 * get AddLabelsPage
	 * @param driver
	 * @param ipClient
	 * @return AddLabelsPage object
	 */
	public static AddLabelsPage getAddLabelsPage(WebDriver driver, String ipClient) {
		return new AddLabelsPage(driver, ipClient);
	}
	
	/**
	 * get GlobalDictionaryPage
	 * @param driver
	 * @param ipClient
	 * @return GlobalDictionaryPage object
	 */
	public static GlobalDictionaryPage getGlobalDictionaryPage(WebDriver driver, String ipClient) {
		return new GlobalDictionaryPage(driver, ipClient);
	}
	
}
