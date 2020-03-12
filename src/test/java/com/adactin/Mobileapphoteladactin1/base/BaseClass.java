package com.adactin.Mobileapphoteladactin1.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.Platform;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class BaseClass {
	
	protected static AppiumDriver<MobileElement> driver;
	DesiredCapabilities caps=new DesiredCapabilities();
	public static final String currentDir = System.getProperty("user.dir");

	public BaseClass() throws IOException
	{
		//Log.info("invoking baseclass constructor");
		
	}

	public void device_setup(String platformName,String deviceName,String platformVersion) throws MalformedURLException
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
		//driver=new IOSDriver<MobileElement>(url,caps);
	}
	
	public void simulator_setup(String platformName,String deviceName,String platformVersion) throws MalformedURLException
	{
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("platformName",platformName);
		caps.setCapability("deviceName",deviceName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("connectHardwareKeyboard", "true");
		//caps.setCapability("app", "//src/test/resources/apps/Runner.app");
		//caps.setCapability("app", "/Users/aswinvijayan/Documents/Shweta/adactinhotelapp-master/build/ios/iphonesimulator/Runner.app");
	
		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			caps.setCapability("app", currentDir + "/src/test/resources/apps/Runner.app"); 
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			caps.setCapability("app", currentDir + "\\src\\test\\resources\\apps\\Runner.app"); 
		}
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,caps);
	}
	
	public void android_emulator_setup()
	{
		
	}
	
	public void ios_device_setup()
	{
		
	}
	
	public void initBrowser() throws IOException
	{
		String platformName,deviceName,platformVersion,dev;
		FileInputStream fis = null;
		Properties p=new Properties();
		if(Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			 fis=new FileInputStream(currentDir + "//src//test//resources//configsimulator.properties");
		}
		else if(Platform.getCurrent().toString().contains("WIN")) {
			fis=new FileInputStream(currentDir + "\\src\\testresources\\configsimulator.properties");
		}
		
		//FileInputStream fis=new FileInputStream("/Users/aswinvijayan/Documents/Shweta/hoteladactinapp/hoteladactin-workplace/Mobileapphoteladactin1/src/test/resources/configsimulator.properties");
		
		//FileReader fis=new FileReader("/config.properties");
		p.load(fis);
		platformName=p.getProperty("platformName");
		deviceName=p.getProperty("deviceName");
		platformVersion=p.getProperty("platformVersion");
		dev=p.getProperty("environment");
		if(dev.equalsIgnoreCase("device"))
			device_setup(platformName,deviceName,platformVersion);
		else if(dev.equalsIgnoreCase("simulator"))
			simulator_setup(platformName,deviceName,platformVersion);
		
		
	}
	
	
	public void teardown()
	{
		driver.close();
	}

}
