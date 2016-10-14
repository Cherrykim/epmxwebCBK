package Mailosaur;
import org.openqa.selenium.By;

public class AbstractPage {
	
	//==================================Static Controls========================================//
	public static By userDropdown = By.xpath("//div[@id='ms-navbar']/ul[contains(@class,'navbar-right')]/li[contains(@class,'dropdown')]/a");
	public static By logoutLink = By.xpath("//div[@id='ms-navbar']/ul[contains(@class,'navbar-right')]/li[contains(@class,'dropdown')]/ul/li/a[text()='Log out']");
	public static By mailboxesDropdown = By.xpath("//div[@id='ms-navbar']/ul[1]//a[contains(.,'Mailboxes')]");
	public static By newMailboxLink = By.xpath("//div[@id='ms-navbar']/ul[1]//a[text()='New Mailbox']");
	public static By siteTopMenu = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	public static By  siteBottomMenu = By.xpath("//footer/section");
	public static By siteLogo = By.xpath("//img[contains(@src,'logo.svg')]");
	public static By closeChatSection = By.xpath("//div[@class='intercom-sheet-header-button-icon']");
	
	
	// ==================================Dynamic Controls========================================//
	public static String dynamicText = "//*[contains(text(),'%s')]";
	public static String dynamicPageHeader = "//h1[contains(text(),'%s')]";
	public static String dynamicPageLegend = "//legend[contains(text(),'%s')]";
	public static String dynamicRegularButtonByName = "//button[contains(text(),'%s')]";
	public static String dynamicLinkButtonByName = "//a[contains(@class,'btn') and contains(text(),'%s')]";
	public static String dynamicLinkByLinkName = "//a[contains(text(),'%s')]";
	public static String dynamicTextFieldByTextfieldLabel = "//div[label[contains(text(),'%s')]]//input";
	public static String dynamicValidateMessagebyTextfieldLabel = "//div[label[contains(text(),'%s')]]//span[@class = 'help-block']";
	public static String dynamicAlertMessage = "//div[@role='alert']/p[contains(text(),\"%s\")]";

}
