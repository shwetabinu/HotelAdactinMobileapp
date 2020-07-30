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
 * Forgot Password Page -2 Web elements and methods
 * @author shwetabinu
 *
 */
public class ForgotPassword_Page2 extends BaseClass{
	
	ScreenshotCapture screen;
	
	public ForgotPassword_Page2() throws Exception {
		//Initializing the Forgot password page 2 elements
		PageFactory.initElements(driver, this);
		//Initializing the ScreenshotCapture class
		screen=new ScreenshotCapture();
		
	}
	
	@FindBy(xpath="//android.widget.TextView[@text=\"An email has been sent to your email address containing Username and Password. Please check your email.\"]")
	WebElement resetpwlink;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Click here to login\"]/android.widget.TextView")
	WebElement loginlink;
	
	int resetpwtext_index;
	String resetpwtext;
	
	/**
	 * 
	 * Method to verify the confirmation message displayed after sending the email
	 * 
	 * @param rno Row number where test data is present
	 * @throws Exception Exception while verifying text
	 * @return result of verifying text
	 */
	public boolean verifyText(int rno) throws Exception {
		boolean result=true;
				
		//Reading the confirmation text from the Test data file
		resetpwtext_index=ExcelUtil.readExcel('c', "Email Verification Text");
		resetpwtext=ExcelUtil.getCellData(rno, resetpwtext_index);
		
		//Explicitly waiting for the reset password link to appear
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(resetpwlink));
		
		//Taking the relevant screenshot
		screen.takeScreenshot("Email sent verification page");
		
		//Comparing the text with the expected text
		if(resetpwtext.equalsIgnoreCase(resetpwlink.getText()))
			result=true;
		else
			result=false;
		return result;
	}
	
	/**
	 * Method to login
	 * @return boolean result of the method
	 */
	public boolean clickOnLogin()
	{
		boolean result=true;
		try
		{
			//Clicking on login link
			loginlink.click();
			
		}catch(Exception e)
		{
			e.printStackTrace();Log.error("Error occurred while clicking on login");
		}
		return result;
	}
	
}

