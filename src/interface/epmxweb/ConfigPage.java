package epmxweb;

import org.openqa.selenium.By;

public class ConfigPage {

	//==================================Static Controls========================================//
	public static By selectBranch = By.xpath("//select[@ng-model='branchInfo.current']");
	
	// ==================================Dynamic Controls========================================//
	public static String dynamicDatabaseUseButton = "//tr[td[contains(text(),'%s')]]//button[contains(text(),'Use')]";
	public static String dynamicUsingDatabese = "//div[h3[contains(text(),'ePMX Setup')]]//label[contains(text(),'%s')]";
	
}
