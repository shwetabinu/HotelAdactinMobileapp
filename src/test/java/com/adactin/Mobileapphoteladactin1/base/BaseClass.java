package com.adactin.Mobileapphoteladactin1.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.Platform;import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

import com.adactin.Mobileapphoteladactin1.util.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Base class intializes the app for android as well as iOS platforms
 * It sets the desired capabilities as per the device/simulator
 * It reads the configuration details from the Excel sheet and sets the properties of the device
 * It also has method to implement scroll to
 * 
 *
 */
public class BaseClass {
	
	protected static AppiumDriver<MobileElement> driver;
	DesiredCapabilities caps=new DesiredCapabilities();
	public static final String currentDir = System.getProperty("user.dir");
	public static final String testDataExcelFileName="testdata.xlsx";

	public BaseClass() throws Exception
	{
		//Log.info("invoking baseclass constructor");
		ExcelUtil.setExcelFileSheet("TestCases");
		
	}

	public void android_device_setup(String platformName,String deviceName,String platformVersion) throws MalformedURLException
	{
		//DesiredCapabilities caps=new DesiredCapabilities();
		//caps.setCapability("platformName", "ANDROID");
		caps.setCapability("platformName", platformName);
		caps.setCapability("deviceName",deviceName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.adactin.hotelapp");
		caps.setCapability("appActivity", "com.adactin.hotelapp.MainActivity");
		

		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,caps);
		//driver=new AndroidDriver<MobileElement>(url,caps);
		
		
	}
	
	public void simulator_setup(String platformName,String deviceName,String platformVersion) throws MalformedURLException
	{
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("platformName",platformName);
		caps.setCapability("deviceName",deviceName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("connectHardwareKeyboard", "true");
		caps.setCapability("simpleIsVisibleCheck", "true");
		//caps.setCapability("app", "//src/test/resources/apps/Runner.app");
		//caps.setCapability("app", "/Users/aswinvijayan/Documents/Shweta/adactinhotelapp-master/build/ios/iphonesimulator/Runner.app");
	
		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			caps.setCapability("app", currentDir + "/src/test/resources/apps/Runner.app"); 
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			caps.setCapability("app", currentDir + "\\src\\test\\resources\\apps\\Runner.app"); 
		}
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		//driver=new AppiumDriver<MobileElement>(url,caps);
		driver=new IOSDriver<MobileElement>(url,caps);
		
	}
	
	public void android_emulator_setup()
	{
		
	}
	
	public void ios_device_setup()
	{
		
	}
	
	public void initApp(int i) throws Exception
	{
		String platformName,deviceName,platformVersion,dev;
		/*FileInputStream fis = null;
		Properties p=new Properties();
		if(Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			 fis=new FileInputStream(currentDir + "//src//test//resources//configsimulator.properties");
		}
		else if(Platform.getCurrent().toString().contains("WIN")) {
			fis=new FileInputStream(currentDir + "\\src\\testresources\\configsimulator.properties");
		}
		
		p.load(fis);
		platformName=p.getProperty("platformName");
		deviceName=p.getProperty("deviceName");
		platformVersion=p.getProperty("platformVersion");
		dev=p.getProperty("environment");*/
		//ExcelUtil.setExcelFileSheet("TestCases");
		dev=ExcelUtil.getCellData(1,1);
		Log.info(dev);
		platformName=ExcelUtil.getCellData(1,2);
		deviceName=ExcelUtil.getCellData(1,3);
		platformVersion=ExcelUtil.getCellData(1,4);
		
		
		if(dev.equalsIgnoreCase("android_device"))
			android_device_setup(platformName,deviceName,platformVersion);
		else if(dev.equalsIgnoreCase("simulator"))
			simulator_setup(platformName,deviceName,platformVersion);
		else if(dev.equalsIgnoreCase("emulator"))
			android_emulator_setup();
		else if(dev.equalsIgnoreCase("ios_device"))
			ios_device_setup();
		
		
	}
	
	public void iOSScrollToElement(String xpath) {
		RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.xpath(xpath));
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", parentID);
		scrollObject.put("direction", "down");
		
		driver.executeScript("mobile:scroll", scrollObject);
	}
	
	
	public void scrollingInDate(String xpath,String date)
	{
		RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.xpath(xpath));
		
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", parentID);
		 
		// Use the predicate that provides the value of the label attribute
		 
		scrollObject.put("predicateString", "value == "+ date);
		driver.executeScript("mobile:scroll", scrollObject);  // scroll to the target element
	}
	public void datePicker(String date,String xpath1,String xpath2,String xpath3)
	{
		String[] new_date=date.split("/");
		
		List<MobileElement> date_values= driver.findElementsByXPath(xpath1);
		for(int i=0;i<date_values.size();i++)
		{
			Log.info(date_values.get(i).getText());
		}
		
		date_values.get(0).click();
		scrollingInDate(xpath1,new_date[0]);
		//date_values.set(0, element)
		//date_values.get(0).sendKeys(new_date[0]);
		
		
		List<MobileElement> month_values= driver.findElementsByXPath(xpath2);
		scrollingInDate(xpath2,new_date[1]);
		//month_values.get(0).sendKeys(new_date[1]);
		
		List<MobileElement> year_values=driver.findElementsByXPath(xpath3);
		scrollingInDate(xpath3,new_date[2]);
		//year_values.get(0).sendKeys(new_date[2]);
		
		
		
	}
	
	public void closeApp()
	{
		driver.quit();
	}
	

}
