package com.adactin.Mobileapphoteladactin1.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

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

	/**
	 * Method to view the Booked hotel details
	 */
	public void viewBookedHotelDetails() throws Exception
	{

		MobileElement booked_itinerary_btn = (MobileElement)driver.findElement(By.xpath("//android.view.View[2][@text='Booked Itinerary']"));
		booked_itinerary_btn.click();
		
				
		MobileElement booked_hotel_details=(MobileElement)driver.findElement(By.xpath("//android.view.View[1]/android.view.View/android.view.View[contains(@text,'hotel_name')]"));
		//MobileElement booked_hotel_details=(MobileElement)driver.findElement(By.xpath("(//XCUIElementTypeOther[@name="+name+"]"));
		booked_hotel_details.click();
		Thread.sleep(1000);
	
	}
	
	
	
	/**
	 * Method to read which entry of the booked itinerary
	 * @param rno
	 * @return
	 * @throws Exception
	 */
	public String readWhichEntry(int rno) throws Exception
	{
		String booked_itinerary_id;
		return booked_itinerary_id=ExcelUtil.getCellData(rno,22);
		
	}
	
	/**
	 * Method to check if the booked hotel is canceled or not
	 * @param i
	 * @return
	 */
	public boolean checkIfCanceled(String i)
	{
		MobileElement booked_hotel_details=(MobileElement)driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"hotel_list_item\"])["+i+"]"));
		
		return booked_hotel_details.isDisplayed();
		
	}
	
	
	
}
