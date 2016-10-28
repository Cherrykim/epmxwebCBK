package page;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

	public MainPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public boolean isWelcomeMessageDisplayed(){
		return getText(driver, epmxweb.MainPage.welcomeMessage).contains("Welcome");
	}
	
	public boolean isSubMenuButtonDisplayed(String menuID, String buttonName){
		return isControlDisplayed(driver, epmxweb.MainPage.dynamicSubMenuButton, menuID, buttonName);
	}
	private WebDriver driver;
	private String ipClient;
}
