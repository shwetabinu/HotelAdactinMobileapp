package com.adactin.Mobileapphoteladactin1.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

import io.appium.java_client.MobileElement;

public class Select_Hotel extends BaseClass {

	public Select_Hotel() throws Exception {
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	public int checkNumberOfEntries()
	{
		int tot_number=0;
		tot_number=driver.findElements(By.xpath("(//XCUIElementTypeOther[@name=\"hotel_list_item\"])")).size();
		return tot_number;
	}
	
	public void select_hotel(int i)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement hotel=(MobileElement)driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"hotel_list_item\"])["+i+"]"));
		hotel.click();
	}
	

}
