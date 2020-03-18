package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileElement;

public class Select_Hotel extends BaseClass {

	public Select_Hotel() throws Exception {
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	public void select_hotel_notselected()
	{
		
	}
	
	public void select_hotel()
	{
		MobileElement hotel=(MobileElement)driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"hotel_list_item\"])[1]"));
		hotel.click();
	}
	

}
