package common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.uncommons.reportng.ReportMetadata;

import config.ProviderConfiguration;
import common.Constant;

public class BrowserManager {

	/**
	 * open browser and navigate to url
	 * 
	 * @param browser
	 * @param port
	 * @param ipClient
	 * @return driver
	 */
	protected WebDriver openBrowser(String browser, String port, String ipClient) {
		driver = launch(browser, port, ipClient);
		if (driver.toString().toLowerCase().contains("chrome") || driver.toString().toLowerCase().contains("firefox") || driver.toString().toLowerCase().contains("internetexplorer")) {
			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.focus();");
		}
		DriverManager.setWebDriver(driver);
		return driver;
	}

	/**
	 * open browser on SauceLabs and navigate to url
	 * 
	 * @param browser
	 * @param browserVersion
	 * @param platform
	 * @return driver
	 */
	protected WebDriver openSauceLabsBrowser(String browser, String browserVersion, String platform) {
		driver = launchSauceLabs(browser, browserVersion, platform);
		if (driver.toString().toLowerCase().contains("chrome") || driver.toString().toLowerCase().contains("firefox") || driver.toString().toLowerCase().contains("internetexplorer")) {
			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.focus();");
		}
		DriverManager.setWebDriver(driver);
		return driver;
	}

	/**
	 * Close browser and kill chromedriver.exe process
	 */
	protected void closeBrowser() {
		try {
			driver.close();
			driver.quit();
			System.gc();
			if (driver.toString().toLowerCase().contains("chrome") && !System.getProperty("os.name").toLowerCase().contains("mac")) {
				String cmd = "taskkill /f /t /IM chromedriver.exe";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * open browser with grid/nongrid
	 * 
	 * @param browser
	 * @param port
	 * @param ipClient
	 * @return driver
	 */
	public WebDriver launch(String browser, String port, String ipClient) {
		try {
			provider.loadInstance("Mailosaur");
			Thread.sleep(1000);
			final String url = ProviderConfiguration.getProvider().getInstance().getUrl();
			final String grid = ProviderConfiguration.getProvider().getInstance().getGrid();
			ReportMetadata.link = "AUT url: " + url;
			Constant.PathConfig.GRID = grid;
			Constant.PathConfig.HOME_URL = url;

			if (grid.toLowerCase().equals("no")) {
				if (browser.equals("firefox")) {
					driver = new FirefoxDriver();
				} else if (browser.equals("internetexplorer")) {
					DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
					ieCapabilities.setCapability("nativeEvents", false);
					ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
					ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
					ieCapabilities.setCapability("disable-popup-blocking", true);
					ieCapabilities.setCapability("enablePersistentHover", true);
					startIEDriver();
					driver = new InternetExplorerDriver(ieCapabilities);
				} else if (browser.equals("chrome")) {
					if (System.getProperty("os.name").toLowerCase().contains("mac")) {
						startChromeDriverOnMac();
					}else if(System.getProperty("os.name").toLowerCase().contains("win")) {
						startChromeDriver();
					}else{
						startChromeDriverOnLinux();
					}
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--test-type");
					driver = new ChromeDriver(options);
				} else if (browser.equals("Ipad")) {
					DesiredCapabilities capability = DesiredCapabilities.ipad();
					capability.setJavascriptEnabled(true);
					driver = new RemoteWebDriver(new URL("http://localhost:3001/wd/hub"), capability);
				} else {
					driver = new SafariDriver();
				}
			} else {
				DesiredCapabilities capability = null;
				if (browser.equalsIgnoreCase("firefox")) {
					capability = DesiredCapabilities.firefox();
					capability.setBrowserName("firefox");
					capability.setPlatform(org.openqa.selenium.Platform.ANY);
					capability.setJavascriptEnabled(true);
				} else if (browser.equalsIgnoreCase("chrome")) {
					startChromeDriver();
					capability = DesiredCapabilities.chrome();
					capability.setBrowserName("chrome");
					capability.setPlatform(org.openqa.selenium.Platform.ANY);
					capability.setJavascriptEnabled(true);
				} else if (browser.equalsIgnoreCase("internetexplorer")) {
					startIEDriver();
					capability = DesiredCapabilities.internetExplorer();
					capability.setBrowserName("internetexplorer");
					capability.setPlatform(org.openqa.selenium.Platform.ANY);
					capability.setJavascriptEnabled(true);
				} else if (browser.equalsIgnoreCase("safari")) {
					capability = DesiredCapabilities.safari();
					capability.setBrowserName("safari");
					capability.setJavascriptEnabled(true);
					capability.setPlatform(org.openqa.selenium.Platform.MAC);
				}
				try {
					driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipClient, port)), capability);
				} catch (MalformedURLException e) {
					System.out.print(e.getMessage());
				}
			}
			driver.get(url);
			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				driver.manage().window().setPosition(new Point(0, 0));
				java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
				driver.manage().window().setSize(dim);
				// driver.get(url);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return driver;
	}

	/**
	 * open browser on saucelabs
	 * 
	 * @param browser
	 * @param browserVersion
	 * @param platform
	 * @return driver
	 */
	public WebDriver launchSauceLabs(String browser, String browserVersion, String platform) {
		try {
			provider.loadInstance("Mailosaur");
			Thread.sleep(1000);
			final String url = ProviderConfiguration.getProvider().getInstance().getUrl();
			final String grid = ProviderConfiguration.getProvider().getInstance().getGrid();
			final String username = ProviderConfiguration.getProvider().getInstance().getUsername();
			final String accessKey = ProviderConfiguration.getProvider().getInstance().getAccessKey();
			ReportMetadata.link = "AUT url: " + url;
			Constant.PathConfig.GRID = grid;
			Constant.PathConfig.HOME_URL = url;
			String SauceLabsUrl = "http://" + username + ":" + accessKey + "@ondemand.saucelabs.com:80/wd/hub";

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.BROWSER_NAME, browser);
			caps.setCapability(CapabilityType.VERSION, browserVersion);
			caps.setCapability(CapabilityType.PLATFORM, platform);
			caps.setCapability("name", "Run on " + browser);

			driver = new RemoteWebDriver(new URL(SauceLabsUrl), caps);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.get(url);

			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				driver.manage().window().setPosition(new Point(0, 0));
				java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
				driver.manage().window().setSize(dim);
				driver.get(url);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return driver;
	}

	public void takeScreenshot(String name) {
		TakesScreenshot view = TakesScreenshot.class.cast(driver);
		File screenshot = view.getScreenshotAs(OutputType.FILE);
		File destination = new File(name + ".png");
		try {
			FileUtils.copyFile(screenshot, destination);
			log.info("Screenshot saved to " + destination.getAbsolutePath());
		} catch (IOException e) {
			log.error("Failed to write screenshot to " + destination.getAbsolutePath(), e);
		}
	}

	/**
	 * Start chrome driver
	 */
	public void startChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "..\\selenium\\src\\resource\\chromedriver.exe");
	}

	/**
	 * Start chrome driver on Mac
	 */
	public void startChromeDriverOnMac() {
		System.setProperty("webdriver.chrome.driver", "../selenium/src/resource/chromedriverMac");
	}

	/**
	 * Start chrome driver on linux
	 */
	public void startChromeDriverOnLinux(){
		System.setProperty("webdriver.chrome.driver", "../selenium/src/resource/chromedriverLinux");
	}
	/**
	 * start IE driver
	 */
	public void startIEDriver() {
		System.setProperty("webdriver.ie.driver", "..\\selenium\\src\\resource\\IEDriverServer.exe");
	}

	/**
	 * close new window/tab
	 */
	public void closeNewWindow() {
		if (openWindowHandles.size() < 1) {
			log.error("Called close new window when only the main browser was open.");
		} else {
			driver.close();
			driver.switchTo().window(openWindowHandles.pop());
		}
	}

	/**
	 * Refresh a page
	 */
	public void refresh() {
		driver.navigate().refresh();

	}

	/**
	 * back to previous page
	 */
	public void back() {
		driver.navigate().back();
	}

	/**
	 * switch Other Window
	 * 
	 * @return webdriver
	 */
	public WebDriver switchOtherWindow() {
		WebDriver tmp = driver;
		for (String winHandle : driver.getWindowHandles()) {
			tmp = driver.switchTo().window(winHandle);
		}
		return tmp;
	}

	/**
	 * get Current Driver
	 * 
	 * @return window handle
	 */
	public String getCurrentDriver() {
		return driver.getWindowHandle();
	}

	/**
	 * switch Current Driver
	 * 
	 * @param currentHandle
	 * @return webdriver for old window
	 */
	public WebDriver switchCurrentDriver(String currentHandle) {
		try {
			driver.close();
			return driver.switchTo().window(currentHandle);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return driver;
	}

	/**
	 * get title of page
	 * 
	 * @return title of page
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * clear cookie
	 */
	public void clearCookie() {
		driver.manage().deleteAllCookies();
	}

	/**
	 * refresh browser
	 */
	protected void refreshBrowser() {
		driver.navigate().refresh();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private WebDriver driver = null;
	private final Stack<String> openWindowHandles = new Stack<String>();
	private static final Log log = LogFactory.getLog(BrowserManager.class);
	private final ProviderConfiguration provider = ProviderConfiguration.getProvider();
	protected int waitControlTimeout = 3;
}
