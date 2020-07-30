package com.adactin.Mobileapphoteladactin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.adactin.Mobileapphoteladactin.util.ScreenshotCapture;

/**
 * My Account web elements and methods
 * @author shwetabinu
 *
 */
public class My_Account extends BaseClass{

	ScreenshotCapture screen;
	
	public My_Account() throws Exception {
		//Initializing the elements of My Account page
		PageFactory.initElements(driver, this);
		//Initializing an object of ScreenshotCapture class
		screen=new ScreenshotCapture();
	}

	//Logout button
	@FindBy(xpath="//android.widget.Button[@text='Logout']")
	WebElement logout_btn;
	
	//Disabled user name field
	@FindBy(xpath="//android.view.View[@text='user_textfield']")
	WebElement username_disable;
	
	/**
	 * Method to logout of the mobile app
	 * @return boolean result of the method
	 */
	public boolean Logging_out()
	{
		boolean result=true;
		try{
			//Explicitly waiting until logout button is displayed
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(logout_btn));
			//Taking screenshot of Account page
			screen.takeScreenshot("Account page");
			//Clicking on logout button
			logout_btn.click();
		}catch(Exception e) {
			e.printStackTrace();
			Log.error("Exception occurred while trying to logout");
			result=false;
		}
		return result;
	}
	
	
	
}
