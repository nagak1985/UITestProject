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

public class LoginPage extends UtilClass {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;

	@FindBy(how = How.ID, using = "user-name")
	private WebElement txtUsername;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement txtPassword;
	
	@FindBy(how = How.ID, using = "login-button")
	private WebElement loginBtn;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Sorry, this user has been locked out.')]")
	private WebElement txtErrorMsg;
	
	/* Constructor */
	public LoginPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, 60);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Login Page of Swag Labs.");
		driverWait.until(ExpectedConditions.titleContains("Swag Labs"));
	}

	/* Page Elements */
	public boolean verifyLoginPage() throws InterruptedException {
		LOGGER.info("Checking for Login Page Load...!!! ");
		boolean flag = false;
		if (flag == false) {
			driverWait.until(ExpectedConditions.visibilityOf(loginBtn));
			LOGGER.info("Login Page loaded successfully....!!!! ");
			flag = true;
		}
		return flag;
	}

	public void set_UserName(String userName) throws InterruptedException {
		LOGGER.info("Enter Username :" + userName);
		setText(driver, txtUsername, userName);	
	}

	public void set_Password(String password) throws InterruptedException {
		LOGGER.info("Enter Password :" + password);
		setText(driver, txtPassword, password);	
	}
	public void clickLoginBtn() {
		LOGGER.info("Clicking Login Btn...!!! ");
		clickElement(driver, loginBtn);
	}
	
	public boolean verifyErrorPage() throws InterruptedException {
		try {
				LOGGER.info("Checking for Error Message for locked-out user...!!! ");
				boolean flag = false;
					if (flag == false) {
						driverWait.until(ExpectedConditions.visibilityOf(txtErrorMsg));
						LOGGER.info("Error Message loaded successfully....!!!! ");
						flag = true;
					}
				return flag;
		}catch(Exception e) {
			LOGGER.info("Executing Catch Block. Error in try-block code.");
			e.printStackTrace();
			return false;
		}
	}
}
