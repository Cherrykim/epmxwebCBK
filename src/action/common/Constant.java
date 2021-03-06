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
		public static final String USERNAME_CBK = "04137";
		public static final String PASSWORD = "Password123!";
		public static final String MASTER_PASSWORD = "minimax";
		//Database: epmxdata_7dc
//		public static final String USERNAME = "pnorcross";
		//Database: epmxdata_aac
		public static final String USERNAME_AAC = "cmulcahy";
		public static final String USERNAME_HSW = "SB";
		public static final String USERNAME_NG = "ADM";
	}

	public static class DefaultValue {
		public static final String COMPANY_NAME = "Cherry's Test Site";
		public static final String CORPORATION = "General Services Department";
		public static final String URL_CSV_FILENAME = "ePMX UI Pages.csv";
//		public static final String URL_CSV_FILENAME = "ePMX UI Pages - Copy.csv";
		public static final String CURRENT_DATABASE = "cherry_cbk_monthly_01Jan16";
		public static final String AAC_DATABASE = "cherry_aac_weekly_03Dec16";
		public static final String HSW_DATABASE = "cherry_hsw_daily_09Dec16";
		public static final String NG_DATABASE = "cherry_ng_weekly_10Dec16";
		public static final String CURRENT_BRANCH = "cbk";
	}
	
	public static class PageUrl {
		public static final String TEST_PAGE_URL = "https://cherry.epmxweb.com";
		public static final String TOOL_PAGE_URL = "http://tool.cherry.epmxweb.com/";
	}

	public static class MainNavigationTab {
		public static final String LOGOUT = "Logout";
	}

	public static WebDriver driver = null;

}
