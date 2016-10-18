package page;

import org.openqa.selenium.WebDriver;

import common.Constant;

public class ConfigPage extends AbstractPage {

	public ConfigPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public void selectBranchAndDatabase(String branch, String dataBase){
		openLink(driver, Constant.PageUrl.TOOL_PAGE_URL);
		selectComboxboxItem(driver, epmxweb.ConfigPage.selectBranch, branch);
		sleep(2);
		if(!isControlDisplayed(driver, epmxweb.ConfigPage.dynamicUsingDatabese, dataBase))
		click(driver, epmxweb.ConfigPage.dynamicDatabaseUseButton, dataBase);
		sleep(2);
		openLink(driver, Constant.PageUrl.TEST_PAGE_URL);
	}
	
	
	private WebDriver driver;
	private String ipClient;
}
