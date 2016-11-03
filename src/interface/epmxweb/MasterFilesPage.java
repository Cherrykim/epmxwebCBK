package epmxweb;

import org.openqa.selenium.By;

public class MasterFilesPage {

	//==================================Static Controls========================================//
	public static By defaultDisplayName = By.xpath("//table//tr[@class='OddRow']/td[1]");
	public static By defaultShortName = By.xpath("//table//tr[@class='OddRow']/td[2]");
	public static By requiredRadioButton = By.xpath("//table//tr[@class='OddRow']/td[5]/input");
	public static By optionalRadioButton = By.xpath("//table//tr[@class='OddRow']/td[6]/input");
	public static By firstCatalogItem =  By.xpath("//div[@id='div_Item0']/..//script");
	// ==================================Dynamic Controls========================================//
	public static String dynamicLanguageExample = "//pre[@id='%s']";
	public static String dynamicFirstCatalogItem = "//div[@id='div_Item0']/..//script";
}
