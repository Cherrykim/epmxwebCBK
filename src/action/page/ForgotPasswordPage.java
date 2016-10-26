package page;

import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends AbstractPage {

	public ForgotPasswordPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	public boolean isWelcomeMessageDisplayed(){
		return getText(driver, epmxweb.HomePage.welcomeMessage).contains("Welcome");
	}
	
	public String getVerficationCode(){
		return getText(driver, epmxweb.ForgotPasswordPage.verficationCode);
	}
	private WebDriver driver;
	private String ipClient;
}
