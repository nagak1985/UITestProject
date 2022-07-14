package pages.custombdd.pages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.common.io.Files;

import io.cucumber.core.api.Scenario;

public class WebDriverManager {
	public ExtentTest extentTest;
	public static WebDriver driver;
	private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverManager.class);
	public Properties defaultProp;
	
	public WebDriver getDriver(String sValue) throws MalformedURLException {
		driver = startDriver(sValue, 120);
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeDriver(Scenario scenario) throws Throwable {
		if (driver != null) {
			try {
				LOGGER.info("Trying to quit the WebDriver (" + driver.getTitle() + ")");
				LOGGER.info("-------------------------------------------------------------------------");
				takeScreenShot(scenario);
				driver.close();
			} catch (Exception ex) {
				LOGGER.info("Error when quitting the WebDriver: " + ex.getMessage());
				LOGGER.info("-------------------------------------------------------------------------");
				driver.quit();
			}
		}
	}

	public void takeScreenShot(Scenario scenario)throws Exception{
		LOGGER.info("Scenario Status" + scenario.getStatus());
		System.out.println("Scenario Status" + scenario.getStatus());
		String status = scenario.getStatus().toString().trim();
	
	if (scenario.isFailed() || status.contains("PASSED")) {
		System.out.println("Scenario Status");
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		screenshotName = scenario.getName()+timeStamp;
		LOGGER.info(screenshotName+"  screenshotName");
		System.out.println("screenshotName" + screenshotName);
		try {
			File directory = new File("test-output/Screenshots");
			FileUtils.forceMkdir(directory);
			
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			
			String workingDir = System.getProperty("user.dir");
			String defaultAssetPath = workingDir+"/test-output/Screenshots/"+screenshotName+".png";

			File destinationPath = new File(defaultAssetPath);
			Files.copy(sourcePath, destinationPath);
	        
			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(destinationPath.toString());
			
		} catch (IOException e) {
		} 
	  }
	}	
	
	/*
	 *  Set parameters for the webDriver
	*/

	private WebDriver startDriver(String type, int timeout) throws MalformedURLException {
		if(type.equals("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			/*DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(type);
			capabilities.setCapability("seleniumProtocol", "WebDriver");
			capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			*/
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driverConfig/chrome/chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		}
		return driver;
	}

}