package common;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import config.VerificationFailures;

public abstract class AbstractTest extends BrowserManager {

	/**
	 * Print comment on console to NGreport
	 */
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	/**
	 * verify True
	 * 
	 * @param condition
	 * @param halt
	 * @return passed/failed
	 */
	protected boolean verifyTrue(boolean condition, boolean halt) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		boolean pass = true;
		if (halt == false) {
			try {
				if (condition == true)
					log.info("<font color='green'>".concat("===PASSED=== ").concat("</font>"));
				else
					log.info("<font color='red'>".concat("===FAILED=== ").concat("</font>"));
				Assert.assertTrue(condition);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				String script = Common.getCommon().captureAndConvertImageToURI(getClass().toString().replace("class ", ""), Constant.PathConfig.CAPTURE_SCREENSHOT);

				Reporter.log(script);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertTrue(condition);
		}
		return pass;
	}

	/**
	 * verify true
	 * 
	 * @param condition
	 * @return true/false
	 */
	protected boolean verifyTrue(boolean condition) {
		return verifyTrue(condition, false);
	}

	/**
	 * verify false
	 * 
	 * @param condition
	 * @param halt
	 * @return passed/failed
	 */
	protected boolean verifyFalse(boolean condition, boolean halt) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		boolean pass = true;
		if (halt == false) {
			try {
				if (condition == false)
					log.info("<font color='green'>".concat("===PASSED=== ").concat("</font>"));
				else
					log.info("<font color='red'>".concat("===FAILED=== ").concat("</font>"));
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				String script = Common.getCommon().captureAndConvertImageToURI(getClass().toString().replace("class ", ""), Constant.PathConfig.CAPTURE_SCREENSHOT);
				Reporter.log(script);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertFalse(condition);
		}
		return pass;
	}

	/**
	 * verify false
	 * 
	 * @param condition
	 * @return true/false
	 */
	protected boolean verifyFalse(boolean condition) {
		return verifyFalse(condition, false);
	}

	/**
	 * verify equal
	 * 
	 * @param actual
	 * @param expected
	 * @param halt
	 * @return passed/failed
	 */
	protected boolean verifyEquals(Object actual, Object expected, boolean halt) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		boolean pass = true;
		if (halt == false) {
			try {
				if (actual.equals(expected))
					log.info("<font color='green'>".concat("===PASSED=== ").concat("</font>"));
				else
					log.info("<font color='red'>".concat("===FAILED=== ").concat("</font>"));
				Assert.assertEquals(actual, expected);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				String script = Common.getCommon().captureAndConvertImageToURI(getClass().toString().replace("class ", ""), Constant.PathConfig.CAPTURE_SCREENSHOT);

				Reporter.log(script);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertEquals(actual, expected);
		}
		return pass;
	}

	/**
	 * verify equal
	 * 
	 * @param actual
	 * @param expected
	 * @return true/false
	 */
	protected boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);
	}

	/**
	 * GetData from data file
	 * 
	 * @param tagName
	 * @return content of tag
	 */
	protected String getDataSet(String tagName) {
		String result = "";
		String testModuleName = new Throwable().getStackTrace()[1].getClassName().replace(".", "/").split("/")[1];
		result = Common.getCommon().getDataSet(testModuleName, tagName);
		return result;
	}

	public String getUniqueNumber(){
	    long date = new Date().getTime()/1000;
	    return Long.toString(date);
	}
	
	protected final Log log;
	protected WebDriver driver;
	protected String ipClient;
	protected AutomationControl control = new AutomationControl();
}
