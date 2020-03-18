package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileElement;

public class Booking_Confirmation extends BaseClass{

	public Booking_Confirmation() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public void confirm_Booking()
	{
		MobileElement done_button=(MobileElement)driver.findElement(By.name("Done"));
		done_button.click();
		
	}

}
