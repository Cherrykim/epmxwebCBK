package epmxweb;

import org.openqa.selenium.By;

public class RfqPage {

	//==================================Static Controls========================================//
	public static By welcomeMessage = By.xpath("//tr/td[@class='SmallText']/div");
	public static By iframeAttachment =  By.xpath("//iframe[@id='ifr_Attachments']");
	public static By deleteFirstAttachment = By.xpath("//*[@id='tabOptions0']/img[1]");
	// ==================================Dynamic Controls========================================//
	public static String dynamicSubMenuButton = "//div[@id='%s']//li/a[text()=\"%s\"]";
	public static String dynamicAttachment = "//tr[contains(@id,'tr_ListAttachments')]//span[contains(text(),'%s')]";
	public static String dynamicVendorRecord = "//table[@id='rowVendorTable']//tr[td[span[contains(.,'%s')] and span[contains(.,'%s')]]]";
	
}
