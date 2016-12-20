package epmxweb;

import org.openqa.selenium.By;

public class POPage {

	//==================================Static Controls========================================//
	public static By orderDate = By.xpath("//span[@id='PoDate']");
	
	// ==================================Dynamic Controls========================================//
	public static String dynamicSubMenuButton = "//div[@id='%s']//li/a[text()=\"%s\"]";
}
