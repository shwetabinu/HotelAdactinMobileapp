package com.adactin.Mobileapphoteladactin1.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * Base class initializes the application for android as well as iOS platforms
 * It sets the desired capabilities as per the device/simulator
 * It reads the configuration details from the Excel sheet and sets the properties of the device
 * It also has method to implement scrolling
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
		Log.info("invoking baseclass constructor");
		ExcelUtil.setExcelFileSheet("TestCases");
		
	}
	
	/**
	 * Sets the capability for a real android device
	 * @param platformName
	 * @param deviceName
	 * @param platformVersion
	 * @throws MalformedURLException
	 */
	public void android_device_setup(String platformName,String deviceName,String platformVersion) throws MalformedURLException
	{
		caps.setCapability("platformName", platformName);
		caps.setCapability("deviceName",deviceName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.adactin.education.hotelbooking");
		caps.setCapability("appActivity", "com.adactin.education.hotelbooking.MainActivity");

		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,caps);

	}
	
	/**
	 * Sets the capability for an iOS simulator
	 * @param platformName
	 * @param deviceName
	 * @param platformVersion
	 * @throws MalformedURLException
	 */
	public void simulator_setup(String platformName,String deviceName,String platformVersion) throws MalformedURLException
	{
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("platformName",platformName);
		caps.setCapability("deviceName",deviceName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("connectHardwareKeyboard", "true");
		caps.setCapability("simpleIsVisibleCheck", "true");
	
		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			caps.setCapability("app", currentDir + "/src/test/resources/apps/Runner.app"); 
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			caps.setCapability("app", currentDir + "\\src\\test\\resources\\apps\\Runner.app"); 
		}
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new IOSDriver<MobileElement>(url,caps);
		
	}
	
	public void emulator_setup()
	{
		
	}
	
	public void ios_device_setup()
	{
		
	}

	/**
	 * Initializes the application with the capabilities mentioned in the Test Data file
	 * @param i row/column number
	 * @throws Exception
	 */
	public void initApp(int rno) throws Exception
	{
		String platformName,deviceName,platformVersion,dev;

		int env_col=ExcelUtil.readExcel('c',"Environment");
		dev=ExcelUtil.getCellData(rno,env_col);
		Log.info(dev);
		
		int pf_col=ExcelUtil.readExcel('c',"Platform_name");	
		platformName=ExcelUtil.getCellData(rno,pf_col);
		
		int devicename_col=ExcelUtil.readExcel('c',"Device_name");	
		deviceName=ExcelUtil.getCellData(rno,devicename_col);
		
		int pfversion_col=ExcelUtil.readExcel('c',"Platform_Version");	
		platformVersion=ExcelUtil.getCellData(rno,pfversion_col);

		
		if(dev.equalsIgnoreCase("android_device"))
			android_device_setup(platformName,deviceName,platformVersion);
		else if(dev.equalsIgnoreCase("simulator"))
			simulator_setup(platformName,deviceName,platformVersion);
		else if(dev.equalsIgnoreCase("emulator"))
			emulator_setup();
		else if(dev.equalsIgnoreCase("ios_device"))
			ios_device_setup();
		
		
	}

	/**
	 * Code to read the properties from a properties file.
	 * @throws IOException 
	 */
	public void propertyfileReader() throws IOException
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
		
		p.load(fis);
		platformName=p.getProperty("platformName");
		deviceName=p.getProperty("deviceName");
		platformVersion=p.getProperty("platformVersion");
		dev=p.getProperty("environment");
		
	}
	
	/**
	 * Method to close all the open sessions	
	 */
	@AfterTest
	public void closeApp()
	{
		driver.quit();
	}
	

}
