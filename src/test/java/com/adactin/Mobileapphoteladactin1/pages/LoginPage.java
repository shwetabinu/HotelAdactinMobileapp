package com.adactin.Mobileapphoteladactin1.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileElement;

public class LoginPage extends BaseClass{
	
	/*@FindBy(xpath="//XCUIElementTypeTextView[@name=\"username_textformfield Username\"]")
	WebElement userid;
	
	@FindBy(xpath="//XCUIElementTypeTextView[@name=\"password_textformfield Password\"]")
	WebElement passw;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name=\"Login\"]")
	WebElement submit;*/
	
	public LoginPage() throws IOException
	{		
		PageFactory.initElements(driver, this);
		
	}

	@BeforeTest
	public void initialising() throws IOException
	{
		initBrowser();
	}
	
	@Test
	public void Logging_in()
	{	//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	MobileElement userid = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
		//MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextView[@name=\"username_textformfield Username\"]");
		//MobileElement el1 = (MobileElement) driver.findElementByName("username_textformfield Username");
		userid.click();
	userid.sendKeys("testusersbin");
	
	//el1.clear();
		//MobileElement userid = (MobileElement) driver.findElementByName("username_textformfield Username");
		//userid.sendKeys("testusersbin");
		
		//driver.f
	//userid.sendKeys("testusersbin");
		//passw.sendKeys("4K26ZC");
		//submit.click();
	}
	
}
