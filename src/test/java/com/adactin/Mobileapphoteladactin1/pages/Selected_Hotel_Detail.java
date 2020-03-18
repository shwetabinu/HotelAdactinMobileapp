package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileElement;

public class Selected_Hotel_Detail extends BaseClass{

	public Selected_Hotel_Detail() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void click_on_select()
	{
		String xpath="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]\n" + 
				"";
		iOSScrollToElement(xpath);
		MobileElement select_click=(MobileElement)driver.findElement(By.name("Select"));
		select_click.click();
	}
	
}
