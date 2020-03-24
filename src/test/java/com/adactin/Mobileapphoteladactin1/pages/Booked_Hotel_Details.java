package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

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

	
	public int checkBookedHotelDetails(int i,String oid) throws Exception {
		String expected_location,expected_hotel,fname,lname,expected_roomtype,expected_nofrooms;
		String bhd_xpath="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]\n" + 
				"";
		int count=0;
		expected_location=ExcelUtil.getCellData(i,7);
		expected_hotel=ExcelUtil.getCellData(i,8);
		fname=ExcelUtil.getCellData(i,15);
		lname=ExcelUtil.getCellData(i,16);
		expected_roomtype=ExcelUtil.getCellData(i,9);
		

		MobileElement ord_id=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"order_id\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(ord_id.getText().equalsIgnoreCase(oid))
			count++;
		
		MobileElement location=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"hotel_location\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(location.getText().equalsIgnoreCase(expected_location))
			count++;
		
		MobileElement hot_name=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"hotel_name\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(hot_name.getText().equalsIgnoreCase(expected_hotel))
			count++;
		
		MobileElement first_name=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"first_name\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(first_name.getText().equalsIgnoreCase(fname))
			count++;
		
		iOSScrollToElement(bhd_xpath);
		
		MobileElement last_name=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"last_name\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(last_name.getText().equalsIgnoreCase(lname))
			count++;
		
		MobileElement rooms_type=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"hotel_room_type\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(rooms_type.getText().equalsIgnoreCase(expected_roomtype))
			count++;
		
		return count;
		
		
		
		
	}

}
