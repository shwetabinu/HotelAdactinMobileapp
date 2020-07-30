package com.adactin.Mobileapphoteladactin.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Base class initializes the application for android as well as iOS platforms
 * It sets the desired capabilities as per the device/simulator It reads the
 * configuration details from the Excel sheet and sets the properties of the
 * device It also has method to implement scrolling
 * 
 *
 */
public class BaseClass {

	protected static AndroidDriver<MobileElement> driver;
	DesiredCapabilities caps = new DesiredCapabilities();
	public static final String currentDir = System.getProperty("user.dir");
	public static final String testDataExcelFileName = "testdata.xlsx";
	public static String env, platformName, deviceName, platformVersion,testcasename;

	public BaseClass() throws Exception {
		Log.info("invoking baseclass constructor");
		ExcelUtil.setExcelFileSheet("TestCases");

	}
	
	/**
	 * Method to read the environmental configuration details from the properties file
	 * It also sets the environmental configuration prior to the execution of tests
	 * @throws IOException Exception while reading files
	 * @param envconfigname Environment Configurations file
	 * @param testContext Context of the test script
	 */
	@BeforeClass(alwaysRun = true)
	@org.testng.annotations.Parameters(value = { "config" })
	public static void propertyfileReader(String envconfigname,final ITestContext testContext) throws IOException {

		
		testcasename=testContext.getName();
		String EnvConfigpath=new String();
		
		//Setting the Env configuration properties file path
		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			EnvConfigpath = currentDir + "//src//test//resources//";
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			EnvConfigpath = currentDir + "\\src\\test\\resources\\";
		}
		try {
			// Open the Properties file
			FileInputStream fis = new FileInputStream(EnvConfigpath + envconfigname);
			Properties p = new Properties();
			p.load(fis);
			
			// Reading the respective properties in the file and storing them
			platformName = p.getProperty("Platform_name");
			Log.info(platformName);
			deviceName = p.getProperty("Device_name");
			Log.info(deviceName);
			platformVersion = p.getProperty("Platform_Version");
			Log.info(platformVersion);
			env = p.getProperty("Environment");
			Log.info(env);
		} catch (Exception e) {
			try {
				throw (e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	
	}

	/**
	 * Sets the capability for a real android device
	 *
	 * @throws MalformedURLException Exception occurring due to invalid URL
	 */
	public void android_device_setup()
			throws MalformedURLException {
		// Setting the platform name
		caps.setCapability("platformName", platformName);
		// Setting the device name
		caps.setCapability("deviceName", deviceName);
		// Setting the platform version
		caps.setCapability("platformVersion", platformVersion);
		// Setting the automation name
		caps.setCapability("automationName", "UiAutomator2");
		// Setting the app package
		caps.setCapability("appPackage", "com.adactin.education.hotelbooking");
		// Setting the main activity
		caps.setCapability("appActivity", "com.adactin.education.hotelbooking." + "MainActivity");

		// Setting the URL Address where the device is present
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		// Initializing the driver
		// driver=new AppiumDriver<MobileElement>(url,caps);
		driver = new AndroidDriver(url, caps);

	}

	/**
	 * Sets the capability for an iOS simulator
	 * 
	 *@throws MalformedURLException Exception occurring due to invalid URL
	 */
	public void simulator_setup()
			throws MalformedURLException {
		// Setting the platform name
		caps.setCapability("platformName", platformName);
		// Setting the device name
		caps.setCapability("deviceName", deviceName);
		// Setting the platform version
		caps.setCapability("platformVersion", platformVersion);
		// Setting the automation name
		caps.setCapability("automationName", "XCUITest");
		// Setting the flag to connect to hardware keyboard
		caps.setCapability("connectHardwareKeyboard", "true");
		caps.setCapability("simpleIsVisibleCheck", "true");

		// Setting the app capability according to OS type
		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			caps.setCapability("app", currentDir + "/src/test/resources/apps/Runner.app");
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			caps.setCapability("app", currentDir + "\\src\\test\\resources\\apps\\Runner.app");
		}

		// Initializing and setting the URL to the address where device is present
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		// Initializing the driver with the set capabilities
		// driver=new IOSDriver<MobileElement>(url,caps);

	}

	/**
	 * Method to set the capability for android emulator
	 */
	public void emulator_setup() {

	}


	/**
	 * Initializes the application with the capabilities mentioned in the Test Data
	 * file
	 * 
	 * @param rno row/column number
	 * @throws Exception Exception during app initialization
	 */
	public void initApp(int rno) throws Exception {
		
		// Calling the method corresponding to the device settings
		if (env.equalsIgnoreCase("android_device"))
			android_device_setup();
		else
			emulator_setup();
	}


	/**
	 * Method to close all the open sessions
	 */
	@AfterTest
	public void closeApp() {
		driver.quit();
	}

}
