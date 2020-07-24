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
//import com.adactin.Mobileapphoteladactin1.util.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
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
	
	//protected static AppiumDriver<MobileElement> driver;
	protected static AndroidDriver<MobileElement> driver;
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
		//Setting the platform name
		caps.setCapability("platformName", platformName);
		//Setting the device name
		caps.setCapability("deviceName",deviceName);
		//Setting the platform version
		caps.setCapability("platformVersion", platformVersion);
		//Setting the automation name
		caps.setCapability("automationName", "UiAutomator2");
		//Setting the app package
		caps.setCapability("appPackage", "com.adactin.education.hotelbooking");
		//Setting the main activity
		caps.setCapability("appActivity", "com.adactin.education.hotelbooking."
				+ "MainActivity");

		//Setting the URL Address where the device is present
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		//Initializing the driver
		//driver=new AppiumDriver<MobileElement>(url,caps);
		driver=new AndroidDriver(url, caps);

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
		//Setting the platform name
		caps.setCapability("platformName",platformName);
		//Setting the device name
		caps.setCapability("deviceName",deviceName);
		//Setting the platform version
		caps.setCapability("platformVersion", platformVersion);
		//Setting the automation name
		caps.setCapability("automationName", "XCUITest");
		//Setting the flag to connect to hardware keyboard
		caps.setCapability("connectHardwareKeyboard", "true");
		caps.setCapability("simpleIsVisibleCheck", "true");
	
		//Setting the app capability according to OS type
		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			caps.setCapability("app", currentDir + "/src/test/resources/apps/Runner.app"); 
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			caps.setCapability("app", currentDir + "\\src\\test\\resources\\apps\\Runner.app"); 
		}
		
		//Initializing and setting the URL to the address where device is present
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		//Initializing the driver with the set capabilities
		//driver=new IOSDriver<MobileElement>(url,caps);
		
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

		//Reading the column with the title: Environment 
		int env_col=ExcelUtil.readExcel('c',"Environment");
		
		//Assigning the cell data corresponding to the row and column to dev
		dev=ExcelUtil.getCellData(rno,env_col);
		Log.info(dev);
		
		//Reading the column with the title: Platform_name 
		int pf_col=ExcelUtil.readExcel('c',"Platform_name");
		//Reading the cell data corresponding to the row and column
		platformName=ExcelUtil.getCellData(rno,pf_col);
		
		//Reading the column with the title: Device_Name
		int devicename_col=ExcelUtil.readExcel('c',"Device_name");	
		//Reading the cell data corresponding to the rown and column
		deviceName=ExcelUtil.getCellData(rno,devicename_col);
		
		int pfversion_col=ExcelUtil.readExcel('c',"Platform_Version");	
		platformVersion=ExcelUtil.getCellData(rno,pfversion_col);

		//Calling the method corresponding to the device settings
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
		//Reading the property file for simulator configuration
		if(Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			 fis=new FileInputStream(currentDir + "//src//test//resources//configsimulator.properties");
		}
		else if(Platform.getCurrent().toString().contains("WIN")) {
			fis=new FileInputStream(currentDir + "\\src\\testresources\\configsimulator.properties");
		}
		
		//loading the properties file
		p.load(fis);
		//Reading the respective properties in the file and storing them
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
