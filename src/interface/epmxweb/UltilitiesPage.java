package epmxweb;

import org.openqa.selenium.By;

public class UltilitiesPage {

	//==================================Static Controls========================================//
	public static By controlFileExpand = By.xpath("//td[text()='Control File']/img");
	public static By allocationMaintain = By.xpath("//tr[td[text()='Allocations']]//input[@value='Maintain']");
	
	// ==================================Dynamic Controls========================================//
	public static String dynamicSubMenuButton = "//div[@id='%s']//li/a[text()=\"%s\"]";
}
