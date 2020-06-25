package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ScrollUtil;

import io.appium.java_client.MobileElement;

public class Booking_Confirmation extends BaseClass{

	public Booking_Confirmation() throws Exception {
		PageFactory.initElements(driver, this);
	}
/**
 * Method to confirm the booking by clicking on the Done button
 */
	public void confirm_Booking()
	{
		//String xpath="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]\n" + 
		//		"";
		//iOSScrollToElement(xpath);
		//iOSScrollToElement(xpath);
		ScrollUtil.pageScrollToText("Done");
		MobileElement done_button=(MobileElement)driver.findElement(By.xpath("//android.widget.Button[@text='Done']"));
		done_button.click();
		
	}

/**
 * Method to fetch the order id from the order id mobile element
 * @return
 */
	public String getOrderId()
	{
		ScrollUtil.pageScrollToText("Order No.");
		MobileElement ordid=(MobileElement)driver.findElement(By.xpath("//android.view.View[18]/android.view.View"));
		return ordid.getText();
	}

}
