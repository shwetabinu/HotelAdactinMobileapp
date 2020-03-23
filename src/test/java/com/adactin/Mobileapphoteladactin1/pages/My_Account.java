package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileElement;

public class My_Account extends BaseClass{

	public My_Account() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public void Logging_out()
	{
		MobileElement myaccount_btn=(MobileElement)driver.findElement(By.name("Account"));
		myaccount_btn.click();
		MobileElement Logout_btn=(MobileElement)driver.findElement(By.name("Logout"));
		Logout_btn.click();
	}
	
	
	
}
