package Mailosaur;

import org.openqa.selenium.By;

public class LoginPage {
	//==================================Static Controls========================================//
	public static By usernameTextbox = By.id("txt_UserName");
	public static By passwordTextbox = By.id("txt_Password");
	public static By loginButton = By.id("button3");
	public static By errorMessage = By.xpath("//td[@class='Alert']");
	
	//==================================Dynamic Controls========================================//
}
