package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileElement;

public class My_Account extends BaseClass{

	public My_Account() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void Logging_out()
	{
		MobileElement Logout_btn=(MobileElement)driver.findElement(By.name("Logout"));
		Logout_btn.click();
	}
	
	
	
}
