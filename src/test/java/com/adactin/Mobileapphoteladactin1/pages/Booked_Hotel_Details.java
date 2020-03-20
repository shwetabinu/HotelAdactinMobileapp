package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileElement;

public class Booked_Hotel_Details extends BaseClass {
	
	public Booked_Hotel_Details() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cancelBooked_itinerary()
	{
		MobileElement cancel_btn=(MobileElement)driver.findElement(By.name("Cancel"));
		cancel_btn.click();
	}
	

}
