package com.adactin.Mobileapphoteladactin1.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

/**
 * Login class identifies all the elements in the Login Page. 
 * It has methods to login, click on forgot password link, click on sign up link
 * check if login button is present, validate error messages for blank user name/password
 * and invalid login credentials
 * 
 */
public class Login extends BaseClass {

	public Login() throws Exception {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//android.view.View[2]/android.widget.EditText")
	public WebElement userid;

	@FindBy(xpath = "//android.view.View[3]/android.widget.EditText")
	public WebElement passw;

	@FindBy(xpath = "//android.view.View[4]/android.widget.Button")
	public WebElement submit;

	@FindBy(xpath = "//android.view.View[@text='Sign Up']")
	public WebElement signup;

	@FindBy(xpath = "//android.view.View[@text='Forgot password']")
	public WebElement forgotpw;

	@FindBy(xpath = "//android.view.View[contains(@text,'click here')]")
	public WebElement clickhere;

	@FindBy(xpath = "//android.view.View[contains(@text,'valid username')]")
	public WebElement error_username;

	@FindBy(xpath = "//android.view.View[contains(@text,'valid password')]")
	public WebElement error_password;

	@FindBy(xpath = "//android.view.View[contains(@text,'Invalid Login')]")
	public WebElement errormessage_invalidlogin;

	@FindBy(xpath = "//android.view.View[contains(@text,'OK')]")
	public WebElement error_alert_ok;

	@FindBy(xpath = "//android.view.View[contains(@text,'Failure')]")
	private WebElement error_alert_title;

	
	/**
	 * Method to login to the application
	 * 
	 * @param i Row# with the test case name
	 * @throws Exception
	 */
	public boolean login(int i) throws Exception {

		boolean result=true;
		try{		
		
		//reading user name and password from the TestData file
		int username_cno=ExcelUtil.readExcel('c', "Username");
		int passw_cno=ExcelUtil.readExcel('c', "Password");
		String username = ExcelUtil.getCellData(i, username_cno);
		String password = ExcelUtil.getCellData(i, passw_cno);
		
		//providing implicit wait for page to load
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		//Clearing the user name textbox and clicking on it
		userid.clear();
		userid.click();
		
		//Explicitly waiting for the user name text box to be clickable
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(userid));

		//Entering user name into the user id text box
		driver.getKeyboard().sendKeys(username);
		
		//Entering password into the password text box
		passw.click();
		driver.getKeyboard().sendKeys(password);
	
		//Clicking on Login button
		submit.click();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=false;
			
		}
		
		//returns true if no exception occurs and false if any exception occurs
		return result;

	}

	/**
	 * Method to click on the Forgot password link present in the Login page
	 */
	public boolean clickOnForgotpassword() {
		boolean result=true;
		try {
		forgotpw.click();
		}catch(Exception e) {
			result=false;
			e.printStackTrace();
		}
		//returns true if no exception occurs and false if any exception occurs
		return result;
	}

	
	/**
	 * Method to click on the SignUp link present in the Login page
	 */
	public boolean clickOnSignup() {
		boolean result=true;
		try
		{
			signup.click();
		}catch(Exception e)
		{
			result=false;
			e.printStackTrace();
		}
		//returns true if no exception occurs and false if any exception occurs
		return result;
	}

	/**
	 * Method to check if Login button is present in the Login page
	 */
	public boolean checkIfLoginButtonPresent() {
		if (submit.isEnabled() == true)
			return true;
		else
			return false;
	}

	/**
	 * Method to validate error message when a user tries to login without
	 * providing user name and/or password
	 */
	public boolean checkBlankFieldsError(int i) {
		boolean result;
		try {
		//Reading expected user name error and password error from Test Data sheet
		int erroruname_cno=ExcelUtil.readExcel('c', "Error message for blank username");
		int errorpassw_cno=ExcelUtil.readExcel('c', "Error message for blank password");
			
		String username_error = ExcelUtil.getCellData(i, erroruname_cno);
		String password_error = ExcelUtil.getCellData(i, errorpassw_cno);
		
		if(username_error.isEmpty())
		{
			//Validating the actual error text with the expected content
			if(error_password.getText().equalsIgnoreCase(password_error))
				result=true;
			else
				result=false;
		}
		
		else if(password_error.isEmpty())
		{
			//Validating the actual error text with the expected content
			if(error_username.getText().equalsIgnoreCase(username_error))
				result=true;
			else
				result=false;
		}
		
		//Validating the expected error messages with the actual error messages
		else if(error_username.getText().equalsIgnoreCase(username_error)
				&& error_password.getText().equalsIgnoreCase(password_error))
			result=true;
		else
			result=false;
		
		}catch(Exception e)
		{
			result=false;
		}
		//returns true if no exception occurs and the result of validation is true
		//and false if any exception occurs
		return result;
		
	}

		

	/**
	 * Method to validate error message when a user tries to login with
	 * invalid login credentials
	 */
	public boolean checkInvalidLoginError(int i) {
		boolean result;
		try {
			//Reading the expected error message for invalid credentials from testdata file
			int invaliderror_cno=ExcelUtil.readExcel('c', "Error message for invalid username and password");
			
			String invalid_error = ExcelUtil.getCellData(i,invaliderror_cno);
			
			//Writing the contents of the alert message (title, content and ok text
			//into an array)
			String error_content[] = invalid_error.split(",");
	
			//Validating the contents of the alert error pop up
			if(error_alert_title.getText().equalsIgnoreCase(error_content[0]) &&
					errormessage_invalidlogin.getText().equalsIgnoreCase(error_content[1]) &&
						error_alert_ok.getText().equalsIgnoreCase(error_content[2]))
				result=true;
			else
				result=false;
			error_alert_ok.click();

		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		
		//returns true if no exception occurs and the result of validation is true
		//and false if any exception occurs
		return result;

	}

}
