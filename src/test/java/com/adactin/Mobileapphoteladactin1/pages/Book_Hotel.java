package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.adactin.Mobileapphoteladactin1.util.ScrollUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.ios.IOSDriver;
public class Book_Hotel extends BaseClass{

	public Book_Hotel() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
/**
 * Method to enter the booking details to the Book Hotel page
 * Clicks on Book now after all the fields are entered
 * @param i row number
 * @throws Exception
 */
	public void enterBookingDetails(int i) throws Exception
	{

		String xpath_scrollable="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]";
		
		//String xpath_month="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]";
		//String xpath_year="//XCUIElementTypeApplication[@name=\"Adactin Hotel App”]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]";
		String xpath_year="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]\n" + "";
		String fname=ExcelUtil.getCellData(i,15);
		String lname=ExcelUtil.getCellData(i,16);
		String billaddress=ExcelUtil.getCellData(i,17);
		String ccnumber=ExcelUtil.getCellData(i,18);
		String cctype=ExcelUtil.getCellData(i,19);
		//String ccexpiry=ExcelUtil.getCellData(i,20);
		String cvvnumber=ExcelUtil.getCellData(i,21);
		
		ScrollUtil.pageScrollToText("Enter First Name");
		
		MobileElement firstName=(MobileElement)driver.findElement(By.xpath("//android.widget.EditText[@text='Enter First Name']"));
		firstName.click();
		driver.getKeyboard().sendKeys(fname);
		
		ScrollUtil.pageScrollToText("Enter Last Name");
		
		MobileElement lastName=(MobileElement)driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Last Name']"));
		lastName.click();
		//lastName.sendKeys(lname);
		driver.getKeyboard().sendKeys(lname);
		driver.getKeyboard().sendKeys(Keys.RETURN);
		//lastName.sendKeys(Keys.RETURN);
		
		ScrollUtil.pageScrollToText("Enter Billing Address");
		
		MobileElement billingAddress=(MobileElement)driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Billing Address']"));
		//billingAddress.sendKeys(billaddress);
		driver.getKeyboard().sendKeys(billaddress);
		
		ScrollUtil.pageScrollToText("Enter Card Number");
		
		MobileElement CCNumber=(MobileElement)driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Card Number']"));
		CCNumber.click();
		driver.getKeyboard().sendKeys(ccnumber);
	//	CCNumber.sendKeys(ccnumber);

		
		//iOSScrollToElement(xpath_scrollable);
		ScrollUtil.pageScrollToText("Select Credit Card Type");
		
		MobileElement CCType=(MobileElement)driver.findElement(By.xpath("//android.widget.EditText[@text='Select Credit Card Type']"));
		CCType.click();
		
		MobileElement ccard_type_option=(MobileElement) driver.findElement(By.xpath("//android.view.View[@text=\""+cctype+"\"]"));
		Log.info(ccard_type_option.getText());
		ccard_type_option.click();
		ccard_type_option.click();
		
		MobileElement CCExpiry=(MobileElement)driver.findElement(By.xpath("//android.widget.EditText[@text='Select Expiry Month & Year']"));
		CCExpiry.click();
		
		//driver.switchTo().frame(1);
		//driver.switchTo().frame((MobileElement)driver.findElement(By.xpath("//android.view.View/android.widget.SeekBar[2]")));
		ScrollUtil.calendarScroll();
		
		MobileElement done_button=(MobileElement)driver.findElement(By.xpath("//android.widget.Button[@text='Done']"));
		done_button.click();
		
		ScrollUtil.calendarScroll();
		done_button.click();
		
		MobileElement CVV=(MobileElement)driver.findElement(By.xpath("//android.widget.EditText[@text='Enter CVV Number']"));				
		CVV.click();
		driver.getKeyboard().sendKeys(cvvnumber);
		
		driver.getKeyboard().sendKeys(Keys.RETURN);
		
		MobileElement bookNow=(MobileElement)driver.findElement(By.xpath("//android.widget.Button[@text='Book Now']"));
		bookNow.click();

		
	}

}
