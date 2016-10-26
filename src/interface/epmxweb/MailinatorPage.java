package epmxweb;

import org.openqa.selenium.By;

public class MailinatorPage {

	//==================================Static Controls========================================//
	public static By mailAddressTextfield = By.xpath("//input[@id='inboxfield']");
	public static By goButton = By.xpath("//button[contains(text(),'Go!')]");
	public static By mailFrame = By.xpath("//iframe[@id='publicshowmaildivcontent']");
	public static By emailAdress = By.xpath("//input[@id='Email']");
	public static By nextButton = By.xpath("//input[@id='next']");		
	public static By password = By.xpath("//input[@placeholder='Password']");
	public static By signInButton = By.xpath("//input[@id='signIn']");		
	public static By composeButton = By.xpath("//div[text()='COMPOSE']");
	public static By recipientTextarea = By.xpath("(//tr[contains(.,'To')]//textarea)[1]");
	public static By subjectBox = By.xpath("//input[@name='subjectbox']");
	public static By messageBody = By.xpath("//div[@aria-label='Message Body']");
	public static By attachFile = By.xpath("//div[@aria-label='Attach files']/div/div/div");
	public static By sendButton = By.xpath("//div[text()='Send']");
	
	// ==================================Dynamic Controls========================================//
	public static String dynamicMailLink = "//div[contains(text(),'%s')]";
}
