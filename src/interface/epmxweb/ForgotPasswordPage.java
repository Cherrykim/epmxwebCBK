package epmxweb;

import org.openqa.selenium.By;

public class ForgotPasswordPage {

	//==================================Static Controls========================================//
	public static By welcomeMessage = By.xpath("//tr/td[@class='SmallText']/div");
	public static By verficationCode = By.xpath("//tr[td[contains(text(),'Verfication code')]]/td[2]");	
	
	// ==================================Dynamic Controls========================================//
	public static String dynamicLanguageExample = "//pre[@id='%s']";
}
