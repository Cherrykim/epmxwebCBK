package epmxweb;

import org.openqa.selenium.By;

public class AddLabelsPage {

	//==================================Static Controls========================================//
	public static By welcomeMessage = By.xpath("//tr/td[@class='SmallText']/div");
	
	// ==================================Dynamic Controls========================================//
	public static String dynamicLanguageExample = "//pre[@id='%s']";
}
