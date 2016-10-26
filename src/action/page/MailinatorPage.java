package page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

public class MailinatorPage extends AbstractPage {

	public MailinatorPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	// ==============================Action Methods===========================//
	
	/**
	 * Open Mailbox
	 * @param emailAddress
	 */
	public void openMailbox(String emailAddress){
		type(driver, epmxweb.MailinatorPage.mailAddressTextfield, emailAddress);
		click(driver, epmxweb.MailinatorPage.goButton);
		sleep(3);
	}
	
	/**
	 * Open email by it's title
	 * @param emailTitle
	 */
	public void openMailByTitle(String emailTitle){
		click(driver, epmxweb.MailinatorPage.dynamicMailLink, emailTitle);
		sleep(3);
	}
	
	/**
	 * Open email by it's title
	 * @param emailTitle
	 */
	public void openResetPasswordPage(){
		switchToFrame(driver, epmxweb.MailinatorPage.mailFrame);
		clickLinkButtonByItsText(driver, "Set New Password");
		switchToTopWindowFrame(driver);
		sleep(3);
	}
	
	/**
	 * Open email by it's title
	 * @param emailTitle
	 */
	public void openNewPasswordPage(){
		switchToFrame(driver, epmxweb.MailinatorPage.mailFrame);
		clickLinkButtonByItsText(driver, "New Password.");
		switchToTopWindowFrame(driver);
		sleep(3);
	}
	
	public void inputEmailAddress(String emailAddress){
		type(driver, epmxweb.MailinatorPage.emailAdress, emailAddress);
	}
	
	public void inputPassword(String password){
		type(driver, epmxweb.MailinatorPage.password, password);
	}
	
	public void inputRecipient(String recipient){
		type(driver, epmxweb.MailinatorPage.recipientTextarea, recipient);
	}
	
	public void inputSubject(String subject){
		type(driver, epmxweb.MailinatorPage.subjectBox, subject);
	}
	
//	public void inputMessage(String message){
////		type(driver, epmxweb.MailinatorPage.messageBody, message);
//		click(driver, epmxweb.MailinatorPage.messageBody);
//		sleep();
//		setClipboardData(message);
//		Robot robot;
//		try {
//			robot = new Robot();
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void clickOnNextButton(){
		click(driver, epmxweb.MailinatorPage.nextButton);
		sleep();
	}
	
	public void clickOnSignInButton(){
		click(driver, epmxweb.MailinatorPage.signInButton);
		sleep();
	}
	
	public void clickOnComposeButton(){
		click(driver, epmxweb.MailinatorPage.composeButton);
		sleep();
	}
	
	public void clickOnAttachFileButton(){
		click(driver, epmxweb.MailinatorPage.attachFile);
		sleep();
	}
	
	public void clickOnSendButton(){
		click(driver, epmxweb.MailinatorPage.sendButton);
		sleep();
	}
	
	public void loginGmail(String emailAddress, String emailPassword){
		inputEmailAddress(emailAddress);
		clickOnNextButton();
		inputPassword(emailPassword);
		clickOnSignInButton();
	}
	
//	public void sendEmail(String recipient, String subject, String message, String fileName){
//		clickOnComposeButton();
//		inputRecipient(recipient);
//		inputSubject(subject);
//		inputMessage(message);
//		clickOnAttachFileButton();
//		setClipboardData(fileName);
//		Robot robot;
//		try {
//			robot = new Robot();
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		sleep(10);
//		clickOnSendButton();
//		sleep(10);
//	}

	private WebDriver driver;
	private String ipClient;
}
