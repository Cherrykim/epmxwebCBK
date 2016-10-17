package common;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static class PathConfig {
		public static final String AUTOMATION_CONFIG_XML = "src/configuration/automation.config.xml";
		public static final String DATA_TEST_XML = "src/configuration/dataTest.xml";
		public static final String CAPTURE_SCREENSHOT = "\\test-output\\screenshots";
		public static final String FOLDER_DOWNLOAD_ON_WIN = "C:\\Users\\%s\\Downloads\\";
		public static String HOME_URL = "";
		public static String GRID = "";
	}

	public static class LoginData {
		//Database: epmxdata_nydoh
//		public static final String USERNAME = "tls15";
//		public static final String PASSWORD = "password";
		//Database: epmxdata_7dc
		public static final String USERNAME = "pnorcross";
		public static final String PASSWORD = "password";
	}

	public static class DefaultValue {
		public static final String COMPANY_NAME = "Cherry's Test Site";
		public static final String URL_CSV_FILENAME = "ePMX UI Pages.csv";
	}

	public static class MainNavigationTab {
		public static final String LOGOUT = "Logout";
	}

	public static WebDriver driver = null;

}