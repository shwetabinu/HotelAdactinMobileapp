package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileElement;

public class Booked_Hotel_Details extends BaseClass {
	
	public Booked_Hotel_Details() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public void cancelBooked_itinerary()
	{
		MobileElement cancel_btn=(MobileElement)driver.findElement(By.name("Cancel"));
		cancel_btn.click();
		MobileElement cancel_btn_conf=(MobileElement)driver.findElement(By.name("cancel_booking_ok_button"));
		cancel_btn_conf.click();
		
		MobileElement success_btn=(MobileElement)driver.findElement(By.name("success_alert_button"));
		success_btn.click();
	}
	

}
