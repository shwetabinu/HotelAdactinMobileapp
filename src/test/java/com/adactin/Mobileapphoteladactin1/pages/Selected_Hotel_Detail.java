package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

import io.appium.java_client.MobileElement;

public class Selected_Hotel_Detail extends BaseClass{

	public Selected_Hotel_Detail() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	int count=0;
	int mod_count=0;
	public void click_on_select()
	{
		String xpath="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]\n" + 
				"";
		iOSScrollToElement(xpath);
		MobileElement select_click=(MobileElement)driver.findElement(By.name("Select"));
		select_click.click();
	}
	
	public int check_If_correct_details_roomtype(int i,String roomtype) throws Exception
	{
		
		int c=0;
		String xpath="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]\n" + 
				"";
		String expected_location,expected_hotel;
		expected_location=ExcelUtil.getCellData(i,7);
		expected_hotel=ExcelUtil.getCellData(i,8);
		MobileElement loc=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"hotel_location\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(loc.getText().equalsIgnoreCase(expected_location))
			{Log.info(loc.getText());
			//count=count+1;
			++count;
			Log.info("Checking count"+count);
			}
		
		MobileElement hotel=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"hotel_name\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(hotel.getText().equalsIgnoreCase(expected_hotel))
			{Log.info(hotel.getText());
			//count=count+1;
			++count;
		Log.info("Checking count"+count);
			}
		iOSScrollToElement(xpath);
		//iOSScrollToElement(xpath);
		MobileElement rooms_type=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"hotel_room_type\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(rooms_type.getText().equalsIgnoreCase(roomtype))
			{Log.info(rooms_type.getText());
			//count=count+1;
			++count;
		Log.info("Checking count"+count);
			}
		
		//mod_count=count;
		
		return count;
		
	}
	public int check_If_correct_details_hotel(int i,String expected_hotel) throws Exception
	{
		
		int c=0;
		String xpath="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]\n" + 
				"";
		String expected_location,expected_roomtype;
		expected_location=ExcelUtil.getCellData(i,7);
		expected_roomtype=ExcelUtil.getCellData(i,9);
		MobileElement loc=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"hotel_location\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(loc.getText().equalsIgnoreCase(expected_location))
			{Log.info(loc.getText());
			//count=count+1;
			++count;
			Log.info("Checking count"+count);
			}
		
		MobileElement hotel=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"hotel_name\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(hotel.getText().equalsIgnoreCase(expected_hotel))
			{Log.info(hotel.getText());
			//count=count+1;
			++count;
		Log.info("Checking count"+count);
			}
		iOSScrollToElement(xpath);
		//iOSScrollToElement(xpath);
		MobileElement rooms_type=(MobileElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"hotel_room_type\"]\n" + 
				"/following-sibling::XCUIElementTypeOther"));
		if(rooms_type.getText().equalsIgnoreCase(expected_roomtype))
			{Log.info(rooms_type.getText());
			//count=count+1;
			++count;
		Log.info("Checking count"+count);
			}
		
		//mod_count=count;
		
		return count;
		
	}
	public void goback()
	{
		MobileElement back_btn=(MobileElement)driver.findElement(By.name("Back"));
		back_btn.click();
	}
	public String[] getRoomTypes(int i) throws Exception
	{
		String[] expected_roomtype;
		expected_roomtype=ExcelUtil.getCellData(i,9).split(",");
		return expected_roomtype;
		
	}
	
	public String[] getHotelNames(int i) throws Exception
	{
		String[] expected_hotelnames;
		expected_hotelnames=ExcelUtil.getCellData(i,8).split(",");
		return expected_hotelnames;
	}
	
}
