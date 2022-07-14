package pages.custombdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cucumber.helper.UtilClass;

public class HomePage extends UtilClass {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//div[@class='app_logo']")
	private WebElement lblLogo;
	
	@FindBy(how = How.ID, using = "react-burger-menu-btn")
	private WebElement btnMenu;
	
	@FindBy(how = How.ID, using = "logout_sidebar_link")
	private WebElement btnLogout;
	
	/* Constructor */
	public HomePage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, 60);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Login Page of Swag Labs.");
		driverWait.until(ExpectedConditions.titleContains("Swag Labs"));
		driverWait.until(ExpectedConditions.visibilityOf(lblLogo));
	}

	/* Page Elements */

	public boolean verifyHomePage() throws InterruptedException {
		LOGGER.info("Checking for Menu Button in Home Page...!!! ");
		boolean flag = false;
		if (flag == false) {
			driverWait.until(ExpectedConditions.visibilityOf(btnMenu));
			LOGGER.info("Home Page loaded successfully....!!!! ");
			flag = true;
		}
		return flag;
	}

	public boolean verifyApplicationFromHomePage() throws InterruptedException {
		LOGGER.info("Checking for Application Logo in Home Page...!!! ");
		boolean flag = false;
		if (flag == false) {
			driverWait.until(ExpectedConditions.visibilityOf(lblLogo));
			LOGGER.info("Logo found successfully....!!!! ");
			flag = true;
		}
		return flag;
	}

	public void clickMenuBtn() {
		LOGGER.info("Clicking Menu Btn...!!! ");
		clickElement(driver, btnMenu);
	}

	public void clickLogoutBtn() {
		LOGGER.info("Clicking Logout Btn...!!! ");
		clickElement(driver, btnLogout);
	}
}
