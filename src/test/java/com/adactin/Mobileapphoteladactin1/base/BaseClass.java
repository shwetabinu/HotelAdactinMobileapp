package com.adactin.Mobileapphoteladactin1.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

import com.adactin.Mobileapphoteladactin1.util.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * Base class intializes the app for android as well as iOS platforms
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
		//Log.info("invoking baseclass constructor");
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
		//DesiredCapabilities caps=new DesiredCapabilities();
		//caps.setCapability("platformName", "ANDROID");
		caps.setCapability("platformName", platformName);
		caps.setCapability("deviceName",deviceName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.adactin.education.hotelbooking");
		caps.setCapability("appActivity", "com.adactin.education.hotelbooking.MainActivity");
		//caps.setCapability(capabilityName, value);

		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,caps);
		//driver=new AndroidDriver<MobileElement>(url,caps);
		
		
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
		//driver=new AppiumDriver<MobileElement>(url,caps);
		driver=new IOSDriver<MobileElement>(url,caps);
		
	}
	
	public void android_emulator_setup()
	{
		
	}
	
	public void ios_device_setup()
	{
		
	}

/**
 * Initializes the app with the capabilities mentioned in the Test Data file
 * @param i rown number
 * @throws Exception
 */
	public void initApp(int i) throws Exception
	{
		String platformName,deviceName,platformVersion,dev;
		
		/**
		 * Code to read the properties from a properties file.
		 */
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
		dev=ExcelUtil.getCellData(i,1);
		Log.info(dev);
		platformName=ExcelUtil.getCellData(i,2);
		deviceName=ExcelUtil.getCellData(i,3);
		platformVersion=ExcelUtil.getCellData(i,4);
		
		
		if(dev.equalsIgnoreCase("android_device"))
			android_device_setup(platformName,deviceName,platformVersion);
		else if(dev.equalsIgnoreCase("simulator"))
			simulator_setup(platformName,deviceName,platformVersion);
		else if(dev.equalsIgnoreCase("emulator"))
			android_emulator_setup();
		else if(dev.equalsIgnoreCase("ios_device"))
			ios_device_setup();
		
		
	}
/**
 * Method to perform Scroll down operation in iOS
 * @param xpath identifier of the parent element in which scroll action takes place
 */
	public void iOSScrollDown(String xpath) {
		RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.xpath(xpath));
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", parentID);
		scrollObject.put("direction", "down");
		
		driver.executeScript("mobile:scroll", scrollObject);
	}

/**
* Method to perform Scroll to a particular element in iOS
*  @param xpath identifier of the parent element in which scroll action takes place
*/
	public void iOSScrollToElement(String xpath,String name)
	{
		Log.info("I am now in the scrolltoelement method");
		RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.xpath(xpath));
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", parentID);
		//scrollObject.put("name", "Search");
		scrollObject.put("predicateString", "label == 'Search'");
		driver.executeScript("mobile:scroll", scrollObject);
	}
	
/**
 * Method to perform Scroll up operation in iOS
 * @param xpath identifier of the parent element in which scroll action takes place
 */
	public void iOSScrollUp(String xpath) {
		RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.xpath(xpath));
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", parentID);
		scrollObject.put("direction", "up");
		
		driver.executeScript("mobile:scroll", scrollObject);
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
		//iOSScrollToElement(xpath1);
		driver.findElement(By.name("Done")).click();
		
		
		
	}
/**
 * Method to close all the open sessions	
 */
	public void closeApp()
	{
		driver.quit();
	}
	

}
