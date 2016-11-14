package epmxweb;
import org.openqa.selenium.By;

public class AbstractPage {
	
	//==================================Static Controls========================================//
	public static By clearButton = By.xpath("//img[@id='imgClr']");
	public static By searchButton = By.xpath("//img[@id='imgSrch']");

	
	// ==================================Dynamic Controls========================================//
	public static String dynamicText = "//*[contains(text(),'%s')]";
	public static String dynamicDiv = "//div[contains(text(),'%s')]";
	public static String dynamicElementByValue = "//*[@value='%s']";
	public static String dynamicElementByID = "//*[@id='%s']";
	public static String dynamicElementByTitle = "//*[@title='%s']";
	public static String dynamicElementByText = "//*[contains(text(),'%s')]";
	public static String dynamicElementByClass = "//*[@class='%s']";
	public static String dynamicRegularButtonByName = "//button[contains(text(),'%s')]";
	public static String dynamicLinkButtonByName = "//a[contains(@class,'btn') and contains(text(),'%s')]";
	public static String dynamicLinkByLinkName = "//a[contains(text(),'%s')]";
	public static String dynamicLinkByLinkNamePrecisely = "//a[text()='%s']";
	public static String dynamicLinkByLinkNameWithIndex = "(//a[contains(text(),'%s')])[%s]";
	public static String dynamicTextFieldByTextfieldLabel = "//div[label[contains(text(),'%s')]]//input";
	public static String dynamicSelectFieldByID = "//select[@id='%s']";
	public static String dynamicSelectFieldByClass = "//select[@class='%s']";
	public static String dynamicSelectFieldByName = "//select[@name='%s']";
	public static String dynamicTextFieldByID = "//input[@id='%s']";
	public static String dynamicTextAreaByID = "//textarea[@id='%s']";
	public static String dynamicTextFieldByName = "//input[@name='%s']";
	public static String dynamicTableByIDContainsText = "//table[contains(@id,'%s')]//tr[td[contains(.,'%s')]]";
	public static String dynamicCheckboxByItsName = "//tr[td[@class='LabelText' and contains(text(),'%s')]]//input";
	public static String dynamicImgByItsSrc = "//img[contains(@src,'%s')]";
	public static String dynamicImgByItsSrcWithIndex = "(//img[contains(@src,'%s')])[%s]";
	public static String dynamicRadioButtonByName = "//td[contains(.,'%s')]/input[@type='radio']";
	public static String dynamicSelectedListByID = "//select[@id='%s']/option[contains(text(),'%s')]";
	public static String dynamicSuggestionDropdownByID = "//div[@id='%s']/..//script";
}
