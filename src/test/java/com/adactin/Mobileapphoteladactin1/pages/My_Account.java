package com.adactin.Mobileapphoteladactin1.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.Log;

import io.appium.java_client.MobileElement;

public class My_Account extends BaseClass{

	public My_Account() throws Exception {
		PageFactory.initElements(driver, this);
	}

	//Logout button
	@FindBy(xpath="//android.widget.Button[@text='Logout']")
	WebElement logout_btn;
	
	//Disabled user name field
	@FindBy(xpath="//android.view.View[@text='user_textfield']")
	WebElement username_disable;
	
	/**
	 * Method to logout of the mobile app
	 */
	public boolean Logging_out()
	{
		boolean result=true;
		try{
			logout_btn.click();
		}catch(Exception e) {
			e.printStackTrace();
			Log.error("Exception occurred while trying to logout");
			result=false;
		}
		return result;
	}
	
	
	
}
