package com.adactin.Mobileapphoteladactin1.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

public class Forgot_Password extends BaseClass {

	public Forgot_Password() throws Exception {
		PageFactory.initElements(driver, this);
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
	 * @param rno
	 * @throws Exception
	 */
	public boolean enterEmail(int rno) throws Exception {
		boolean result=true;
		
		//Reading the email to which reset link is to be sent
		email_index=ExcelUtil.readExcel('c', "Email Address");
		emailaddr=ExcelUtil.getCellData(rno, email_index);
		
		//Clicking on the email link and entering the email id
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		enter_email.click();	
		driver.getKeyboard().sendKeys("abc"+emailaddr + Keys.RETURN);
	
		return result;

	}

	/**
	 * Method to click on email the password link
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
	 */
	public void resetDetails(int rno) {
		try {
			//Clicking on reset email link
			reset_email.click();
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occurred while resetting email");
		}

	}
}
