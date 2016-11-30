package epmxweb;

import org.openqa.selenium.By;

public class RequisitionPage {

	//==================================Static Controls========================================//
	public static By welcomeMessage = By.xpath("//tr/td[@class='SmallText']/div");
	
	// ==================================Dynamic Controls========================================//
	public static String dynamicSubMenuButton = "//div[@id='%s']//li/a[text()=\"%s\"]";
}
