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
	 * get MasterFilesPage
	 * @param driver
	 * @param ipClient
	 * @return MasterFilesPage object
	 */
	public static MasterFilesPage getMasterFilesPage(WebDriver driver, String ipClient) {
		return new MasterFilesPage(driver, ipClient);
	}
	
	/**
	 * get POPage
	 * @param driver
	 * @param ipClient
	 * @return POPage object
	 */
	public static POPage getPOPage(WebDriver driver, String ipClient) {
		return new POPage(driver, ipClient);
	}
	
	/**
	 * get ReceivingPage
	 * @param driver
	 * @param ipClient
	 * @return ReceivingPage object
	 */
	public static ReceivingPage getReceivingPage(WebDriver driver, String ipClient) {
		return new ReceivingPage(driver, ipClient);
	}
	
	/**
	 * get RequisitionPage
	 * @param driver
	 * @param ipClient
	 * @return RequisitionPage object
	 */
	public static RequisitionPage getRequisitionPage(WebDriver driver, String ipClient) {
		return new RequisitionPage(driver, ipClient);
	}
}
