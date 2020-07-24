package com.adactin.Mobileapphoteladactin1.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

public class ForgotPassword_Page2 extends BaseClass{
	public ForgotPassword_Page2() throws Exception {
		PageFactory.initElements(driver, this);
		
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
	 * @param rno
	 * @throws Exception
	 */
	public boolean verifyText(int rno) throws Exception {
		boolean result=true;
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//Reading the confirmation text from the Test data file
		resetpwtext_index=ExcelUtil.readExcel('c', "Email Verification Text");
		resetpwtext=ExcelUtil.getCellData(rno, resetpwtext_index);
		
		//Comparing the text with the expected text
		if(resetpwtext.equalsIgnoreCase(resetpwlink.getText()))
			result=true;
		else
			result=false;
		return result;
	}
	
	/**
	 * Method to login
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

