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
	
	/**
	 * Method to check the number of entries in the Select Hotel page
	 * @return
	 */
	public int checkNumberOfEntries()
	{
		int tot_number=0;
		tot_number=driver.findElements(By.xpath("(//XCUIElementTypeOther[@name=\"hotel_list_item\"])")).size();
		return tot_number;
	}
	
	/**
	 * Method to click on a specific element in the Select Hotel page
	 * @param i the element to be selected
	 */
	public void select_hotel(int i)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement hotel=(MobileElement)driver.findElement(By.xpath("//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View"));
		hotel.click();
	}
	

}
