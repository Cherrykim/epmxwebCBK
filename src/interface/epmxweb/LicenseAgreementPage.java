package epmxweb;

import org.openqa.selenium.By;

public class LicenseAgreementPage {

	//==================================Static Controls========================================//
	public static By welcomeMessage = By.xpath("//tr/td[@class='SmallText']/div");
	
	// ==================================Dynamic Controls========================================//
	public static String dynamicRadioButton = "//input[@type='radio' and @value='%s']";
	public static String dynamicButtonByValue = "//input[@type='button' and @value='%s']";
}
