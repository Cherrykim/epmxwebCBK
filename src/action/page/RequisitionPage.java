package page;

import org.openqa.selenium.WebDriver;

public class RequisitionPage extends AbstractPage {

	public RequisitionPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public boolean isWelcomeMessageDisplayed(){
		return getText(driver, epmxweb.MainPage.welcomeMessage).contains("Welcome");
	}
	
	private WebDriver driver;
	private String ipClient;
}
