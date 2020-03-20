package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileElement;
/**
 * This Booked Itinerary class displays all the bookings done by the user
 * It has method to click on the Booked hotel to view its details
 * 
 *
 */
public class Booked_Itinerary extends BaseClass{

	public Booked_Itinerary() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public void viewFirstBookedHotelDetails() throws InterruptedException
	{
		MobileElement booked_itinerary_btn = (MobileElement)driver.findElement(By.name("Booked Itinerary"));
		booked_itinerary_btn.click();
		MobileElement booked_hotel_details=(MobileElement)driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"hotel_list_item\"])[1]"));
		booked_hotel_details.click();
		Thread.sleep(1000);
	
	}
	
	
}
