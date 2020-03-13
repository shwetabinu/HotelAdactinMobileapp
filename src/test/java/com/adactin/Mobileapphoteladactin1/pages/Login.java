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
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

import io.appium.java_client.MobileElement;

public class Login extends BaseClass{
	
	/*@FindBy(accessibilityid="")
	MobileElement username;
	
	@FindBy(xpath="//XCUIElementTypeTextView[@name=\"password_textformfield Password\"]")
	WebElement passw;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name=\"Login\"]")
	WebElement submit;*/
	
	public Login() throws Exception
	{		
		PageFactory.initElements(driver, this);
		
	}

	@BeforeTest
	public void initialising() throws IOException
	{
		try {
			initApp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error("Unable to initialize the app");
		}
	}
	
	@Test
	public void Logging_in() throws Exception
	{	//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	//MobileElement userid = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
		//MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextView[@name=\"username_textformfield Username\"]");
		//MobileElement el1 = (MobileElement) driver.findElementByName("username_textformfield Username");
		String username=ExcelUtil.getCellData(1,5);
		String password=ExcelUtil.getCellData(1,6);
		MobileElement userid,passw,submit;
		userid= (MobileElement) driver.findElement(By.name("Username"));
		passw= (MobileElement) driver.findElement(By.name("Password"));
		submit= (MobileElement) driver.findElement(By.name("Login"));
		userid.click();
		userid.sendKeys(username);
		passw.click();
		passw.sendKeys(password);
		submit.click();
	//el1.clear();
		//MobileElement userid = (MobileElement) driver.findElementByName("username_textformfield Username");
		//userid.sendKeys("testusersbin");
		
		//driver.f
	//userid.sendKeys("testusersbin");
		//passw.sendKeys("4K26ZC");
		//submit.click();
	}
	
}
