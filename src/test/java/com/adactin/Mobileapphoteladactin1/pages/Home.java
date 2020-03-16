package com.adactin.Mobileapphoteladactin1.pages;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

import io.appium.java_client.MobileElement;

public class Home extends BaseClass {
	public Home() throws Exception
	{		
		PageFactory.initElements(driver, this);
		
	}
	
	public void checkWelcomeMessage(String expectedmsg)
	{
		MobileElement welcomemsg;
		
		
		welcomemsg= (MobileElement)driver.findElement(By.name("welcome_user"));
		
		Assert.assertEquals(welcomemsg,expectedmsg);
	}
	
	public void checkLocationdropdown(int i)
	{
		String[] expectedlocation=null;
		try {
			expectedlocation=ExcelUtil.getCellData(i,7).split(",");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Unable to read from the excel sheet");
			e.printStackTrace();
		}
		List<MobileElement> location=driver.findElementsByAccessibilityId("Select Location");
		int n=0;
		for(MobileElement ele:location)
		{
			Assert.assertEquals(ele.getText(), expectedlocation[n]);
			//assert.assertEquals(ele.getText(), expectedlocation[i]);
			n++;
		}
		
	}
	
	public void searchHotel(int i)
	{
		String expected_location = null,expected_hotel=null,expected_roomtype=null,expected_nofrooms=null,expected_checkin=null;
		String expected_checkout=null,expected_adultsperroom=null,expected_childrenperroom=null;
		try {
			expected_location=ExcelUtil.getCellData(i,7);
			expected_hotel=ExcelUtil.getCellData(i,8);
			expected_roomtype=ExcelUtil.getCellData(i,9);
			expected_nofrooms=ExcelUtil.getCellData(i,10);
			expected_checkin=ExcelUtil.getCellData(i,11);
			expected_checkout=ExcelUtil.getCellData(i,12);
			expected_adultsperroom=ExcelUtil.getCellData(i,13);
			expected_childrenperroom=ExcelUtil.getCellData(i,14);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error(e.getCause().toString());
			e.printStackTrace();
		}
		
		/*Select hotel_location=new Select((MobileElement) driver.findElementsByAccessibilityId("Select Location"));
		hotel_location.selectByValue(expected_location);
		Select actual_hotel=new Select((MobileElement) driver.findElementsByAccessibilityId("Select Hotel"));
		actual_hotel.selectByValue(expected_hotel);*/
		
		MobileElement locationdropdown=(MobileElement) driver.findElement(By.name("Select Location"));
		locationdropdown.click();
		MobileElement selected_location=(MobileElement) driver.findElement(By.name(expected_location));
		selected_location.click();
		MobileElement hoteldropdown=(MobileElement) driver.findElement(By.name("Select Hotel"));
		hoteldropdown.click();
		MobileElement selected_hotel=(MobileElement) driver.findElement(By.name(expected_hotel));
		selected_hotel.click();
		
		RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.className("XCUIElementTypeTable"));
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", parentID);
		scrollObject.put("name", "Select Room Type");
		driver.executeScript("mobile:scroll", scrollObject);
		// (driver).scrollTo("Room Type");
		MobileElement roomtypedropdown=(MobileElement) driver.findElement(By.name("Select Room Type"));
		roomtypedropdown.click();
		
		MobileElement selected_roomtype=(MobileElement) driver.findElement(By.name(expected_roomtype));
		selected_roomtype.click();
		scrollObject.put("element", parentID);
		scrollObject.put("name", "Select Number of Rooms");
		driver.executeScript("mobile:scroll", scrollObject);
		MobileElement noofroomsdropdown=(MobileElement) driver.findElement(By.name("Select Number of Rooms"));
		noofroomsdropdown.click();
		MobileElement selected_noofrooms=(MobileElement) driver.findElement(By.name(expected_nofrooms));
		selected_noofrooms.click();
		scrollObject.put("name", "Select Check-in Date");
		driver.executeScript("mobile:scroll", scrollObject);
		MobileElement checkindatedropdown=(MobileElement) driver.findElement(By.name("Select Check-in Date"));
		checkindatedropdown.click();
		MobileElement selected_checkindate=(MobileElement) driver.findElement(By.name(expected_checkin));
		selected_checkindate.click();
		scrollObject.put("name", "Select Check-out Date");
		driver.executeScript("mobile:scroll", scrollObject);
		MobileElement checkoutdatedropdown=(MobileElement) driver.findElement(By.name("Select Check-out Date"));
		checkoutdatedropdown.click();
		MobileElement selected_checkoutdate=(MobileElement) driver.findElement(By.name(expected_checkout));
		selected_checkoutdate.click();
		scrollObject.put("name", "Select Adults per Room");
		driver.executeScript("mobile:scroll", scrollObject);
		MobileElement adultsperroomdropdown=(MobileElement) driver.findElement(By.name("Select Adults per Room"));
		adultsperroomdropdown.click();
		MobileElement selected_adultsperroom=(MobileElement) driver.findElement(By.name(expected_checkout));
		selected_adultsperroom.click();
		scrollObject.put("name", "Select Children per Room");
		driver.executeScript("mobile:scroll", scrollObject);
		MobileElement childrenperroomdropdown=(MobileElement) driver.findElement(By.name("Select Children per Room"));
		childrenperroomdropdown.click();
		MobileElement selected_childrenperroomm=(MobileElement) driver.findElement(By.name(expected_checkout));
		selected_childrenperroomm.click();
		
}
}
