package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.ScrollUtil;

import io.appium.java_client.MobileElement;

public class Booked_Hotel_Details extends BaseClass {

	public Booked_Hotel_Details() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	//order id
	//android.view.View[2]/android.view.View
	
	
	//hotel name
	//android.view.View[4]/android.view.View
	
	//location
	//android.view.View[6]/android.view.View
	
	//android.view.View[8]/android.view.View
	
	//android.view.View[10]/android.view.View
	
	//android.view.View[12]/android.view.View
	
	//android.view.View[14]/android.view.View
	
	//android.view.View[16]/android.view.View
	
	//android.view.View[18]/android.view.View
	
	//android.view.View[20]/android.view.View
	
	//android.view.View[22]/android.view.View
/**
 * Method to cancel the Booked itinerary
 * Navigates to the booked itinerary list, clicks on a list item and clicks the cancel button
 * Clicks on the success alert button when prompt pops up
 */
	public void cancelBooked_itinerary()
	{
		MobileElement cancel_btn=(MobileElement)driver.findElement(By.name("Cancel"));
		cancel_btn.click();
		MobileElement cancel_btn_conf=(MobileElement)driver.findElement(By.name("cancel_booking_ok_button"));
		cancel_btn_conf.click();

		MobileElement success_btn=(MobileElement)driver.findElement(By.name("success_alert_button"));
		success_btn.click();
	}

/**
 * 
 * Validates if the Booked Hotel Details are as per the data in the testdata sheet
 * @param i Row number
 * @param oid Order ID
 * @return
 * @throws Exception
 */
	
	public int checkBookedHotelDetails(int i,String oid) throws Exception {
		String expected_location,expected_hotel,fname,lname,expected_roomtype,expected_nofrooms;
		
		int count=0;
		expected_location=ExcelUtil.getCellData(i,7);
		expected_hotel=ExcelUtil.getCellData(i,8);
		fname=ExcelUtil.getCellData(i,15);
		lname=ExcelUtil.getCellData(i,16);
		expected_roomtype=ExcelUtil.getCellData(i,9);
		

		MobileElement ord_id=(MobileElement)driver.findElement(By.xpath("//android.view.View[2]/android.view.View"));
		System.out.println("The order id in booking confirmation page"+oid);
		System.out.println("The order id in the hotel details page"+ord_id.getText());
		if(ord_id.getText().equalsIgnoreCase(oid))
			count++;
		
		MobileElement hot_name=(MobileElement)driver.findElement(By.xpath("//android.view.View[4]/android.view.View"));
		System.out.println("The hotel name inputted"+expected_hotel);
		System.out.println("The hotel name in the hotel details page"+hot_name.getText());
		if(hot_name.getText().equalsIgnoreCase(expected_hotel))
			count++;
		
		MobileElement location =(MobileElement)driver.findElement(By.xpath("//android.view.View[6]/android.view.View"));
		System.out.println("The location name inputted"+expected_location);
		System.out.println("The location name in the hotel details page"+location.getText());
		if(location.getText().equalsIgnoreCase(expected_location))
			count++;
		
		MobileElement first_name=(MobileElement)driver.findElement(By.xpath("//android.view.View[10]/android.view.View"));
		System.out.println("The first name inputted"+fname);
		System.out.println("The first name in the hotel details page"+first_name.getText());
		if(first_name.getText().equalsIgnoreCase(fname))
			count++;
		
		//iOSScrollDown(bhd_xpath);
		
		MobileElement last_name=(MobileElement)driver.findElement(By.xpath("//android.view.View[12]/android.view.View"));
		System.out.println("The last name inputted"+lname);
		System.out.println("The first name in the hotel details page"+last_name.getText());
		if(last_name.getText().equalsIgnoreCase(lname))
			count++;
		
		ScrollUtil.pageScrollToText("Cancel");
		MobileElement rooms_type=(MobileElement)driver.findElement(By.xpath("//android.view.View[20]/android.view.View"));
		System.out.println("The room type inputted"+expected_roomtype);
		System.out.println("The room type in the hotel details page"+rooms_type.getText());
		if(rooms_type.getText().equalsIgnoreCase(expected_roomtype))
			count++;
		
		return count;
		
		
		
		
	}

	public boolean validateOrderID(String ordid)
	{
		MobileElement ord_id=(MobileElement)driver.findElement(By.xpath("//android.view.View[2]/android.view.View"));
		if(ord_id.getText().equalsIgnoreCase(ordid))
			return true;
		else
			return false;
	}
	
/**
 * Reads the order id from the test data sheet
 * @param i Row number
 * @return
 * @throws Exception
 */
	public String readOrderId(int i) throws Exception
	{
		String ordid=null;
		ordid=ExcelUtil.getCellData(i,23);
		return ordid;
	}
	
	

}
