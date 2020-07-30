package com.adactin.Mobileapphoteladactin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.adactin.Mobileapphoteladactin.util.ScreenshotCapture;

/**
 * Forgot password page web elements and methods
 * @author shwetabinu
 *
 */
public class Forgot_Password extends BaseClass {

	ScreenshotCapture screen;
	public Forgot_Password() throws Exception {
		//Initializing the elements of Forgot Password page
		PageFactory.initElements(driver, this);
		//Initializing an object of ScreenshotCapture class
		screen=new ScreenshotCapture();
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath ="//android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View")
	WebElement enter_email;
	
	@FindBy(xpath = "//android.widget.Button[1]")
	WebElement submit_email;

	@FindBy(id = "Reset")
	WebElement reset_email;

	@FindBy(xpath = "//android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]")
	WebElement frame_fp;

	@FindBy(xpath="//android.view.View[@content-desc=\"Go back to Login page\"]/android.widget.TextView")
	WebElement goback;
	
	int email_index;
	String emailaddr;
	
	/**
	 * 
	 * Method to enter the email in the enter email text box
	 * 
	 * @param rno Row number where test case is read from
	 * @throws Exception Exception while entering email
	 * @return boolean result of the execution
	 */
	public boolean enterEmail(int rno) throws Exception {
		boolean result=true;
		
		//Reading the email to which reset link is to be sent
		email_index=ExcelUtil.readExcel('c', "Email Address");
		emailaddr=ExcelUtil.getCellData(rno, email_index);
		
		//Explicitly waiting for the email id text-box to be loaded and clickable
		WebDriverWait wai1t=new WebDriverWait(driver,20);
		wai1t.until(ExpectedConditions.elementToBeClickable(enter_email));
		
		//Clicking on the email link and entering the email id
		enter_email.clear();
		enter_email.click();
		
		//Explicitly waiting so that the required data is inputted correctly
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(enter_email));
		//Entering the email address in the textbox
		driver.getKeyboard().sendKeys(emailaddr);
		
		//Taking the screenshot of tha page
		screen.takeScreenshot("Forgot Password page");
		return result;

	}

	/**
	 * Method to click on email the password link
	 * @return boolean result of the method
	 */
	public boolean emailPassword() {
		boolean result=true;
		try{
			//Submitting the email
			submit_email.click();
		}catch(Exception e)
		{
			result=false;
			e.printStackTrace();
			Log.error("Error occurred while clicking on Email password link");
			
		}
		return result;
	}

	/**
	 * Method to go back to login page
	 * @return boolean result of the method
	 */
	public boolean goBackToLogin()
	{
		boolean result=true;
		try{
			//Clicking on go back link
			goback.click();
		}catch(Exception e)
		{
			result=false;
			e.printStackTrace();
			Log.error("Error occurred while going back to login page");
		}
		return result;
	}

	/**
	 * Method to reset details
	 * 
	 */
	public void resetDetails() {
		try {
			//Clicking on reset email link
			reset_email.click();
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occurred while resetting email");
		}

	}
}
