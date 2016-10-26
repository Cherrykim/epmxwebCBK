package epmxweb;
import org.openqa.selenium.By;

public class AbstractPage {
	
	//==================================Static Controls========================================//
	public static By clearButton = By.xpath("//img[@id='imgClr']");
	public static By searchButton = By.xpath("//img[@id='imgSrch']");

	
	// ==================================Dynamic Controls========================================//
	public static String dynamicText = "//*[contains(text(),'%s')]";
	public static String dynamicElementByID = "//*[@id='%s']";
	public static String dynamicElementByTitle = "//*[@title='%s']";
	public static String dynamicRegularButtonByName = "//button[contains(text(),'%s')]";
	public static String dynamicLinkButtonByName = "//a[contains(@class,'btn') and contains(text(),'%s')]";
	public static String dynamicLinkByLinkName = "//a[contains(text(),'%s')]";
	public static String dynamicLinkByLinkNameWithIndex = "(//a[contains(text(),'%s')])[%s]";
	public static String dynamicTextFieldByTextfieldLabel = "//div[label[contains(text(),'%s')]]//input";
	public static String dynamicSelectFieldByID = "//select[@id='%s']";
	public static String dynamicTextFieldByID = "//input[@id='%s']";
	public static String dynamicTableByIDContainsText = "//table[contains(@id,'%s')]//tr[td[contains(.,'%s')]]";
	

}
