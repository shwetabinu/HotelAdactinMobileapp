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

/**
 * Home page has methods to initialize the home page.
 * It has methods to search hotel 
 * @author aswinvijayan
 *
 */
public class Home extends BaseClass {
	public Home() throws Exception
	{		
		PageFactory.initElements(driver, this);

	}
/**
 * Method to check the welcome message of a user
 * @param rno
 * @throws Exception
 */
	public void checkWelcomeMessage(int rno) throws Exception
	{
		MobileElement welcomemsg;

		String expectedusername,expectedmsg;
		//expectedusername=ExcelUtil.getCellData(rno,5);
		expectedmsg="welcome_user";
		welcomemsg= (MobileElement)driver.findElement(By.name("welcome_user"));

		Assert.assertEquals(welcomemsg.getText(),expectedmsg);
	}

/**
 * Method to check the location drop down for the entries
 * @param i
 */
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

	/**
	 * Method to search for hotel with all the input fields entered
	 * 
	 * @param i
	 * @throws Exception
	 */
	public void searchHotel(int i) throws Exception
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


		String xpathtoscrollto="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]";
		String xpath1_of_date_picker1="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]\n" + 
				"";
		String xpath2_of_date_picker1="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]\n" + 
				"";
		String xpath3_of_date_picker1="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]\n" + 
				"";
		MobileElement locationdropdown=(MobileElement) driver.findElement(By.xpath("//android.view.View[4]/android.widget.EditText"));
		locationdropdown.click();
		List<MobileElement> selected_location=(List<MobileElement>) driver.findElements(By.xpath("//android.view.View[2]/android.view.View[1]/android.view.View"));
		for(int j=0;j<selected_location.size();j++)
			{
			System.out.println(selected_location.get(j).getText());
			if(selected_location.get(j).getText().contains(expected_location))
				{
				selected_location.get(j).click();
				selected_location.get(j).click();
				Thread.sleep(1000);
				}
			}
		/*MobileElement hoteldropdown=(MobileElement) driver.findElement(By.xpath("//android.view.View[6]/android.widget.EditText"));
		//selected_location.click();
		hoteldropdown.click();
		List<MobileElement> selected_hotel=(List<MobileElement>) driver.findElements(By.xpath("//android.view.View[2]/android.view.View/android.view.View/android.view.View"));
		for(int j=0;j<selected_location.size();j++)
		{
		if(selected_hotel.get(j).toString().equalsIgnoreCase(expected_location))
			{
			selected_hotel.get(j).click();
			break;
			}
		}

		MobileElement roomtypedropdown=(MobileElement) driver.findElement(By.xpath("//android.view.View[8]/android.widget.EditText"));
		iOSScrollDown(xpathtoscrollto);
		roomtypedropdown.click();
		List<MobileElement> selected_roomtype=(List<MobileElement>) driver.findElements(By.xpath("//android.view.View[2]/android.view.View/android.view.View/android.view.View"));
		for(int j=0;j<selected_location.size();j++)
		{
		if(selected_hotel.get(j).toString().equalsIgnoreCase(expected_location))
			{
			selected_hotel.get(j).click();break;
			}
		}


		/*MobileElement noofroomsdropdown=(MobileElement) driver.findElement(By.name("Select Number of Rooms"));
		//iOSScrollToElement();
		noofroomsdropdown.click();
		MobileElement selected_noofrooms=(MobileElement) driver.findElement(By.name(expected_nofrooms));
		selected_noofrooms.click();

		iOSScrollDown(xpathtoscrollto);
		MobileElement adultsperroomdropdown=(MobileElement) driver.findElement(By.name("Select Adults per Room"));
		adultsperroomdropdown.click();
		MobileElement selected_adultsperroom=(MobileElement) driver.findElement(By.name(expected_adultsperroom));
		selected_adultsperroom.click();

		MobileElement childrenperroomdropdown=(MobileElement) driver.findElement(By.name("Select Children per Room"));
		childrenperroomdropdown.click();
		MobileElement selected_childrenperroomm=(MobileElement) driver.findElement(By.name(expected_childrenperroom));
		selected_childrenperroomm.click();
		//clickOnSearch();*/
		

	}
	
	/**
	 * Method to click on Search button
	 */
	public void clickOnSearch()
	{
		MobileElement search=(MobileElement) driver.findElement(By.name("Search"));
		search.click();
	}
	
	/**
	 * Method to perform reset of the fields entered
	 */
	public void doReset()
	{
		int count=0;
		MobileElement reset=(MobileElement) driver.findElement(By.name("Reset"));
		reset.click();
		String xpathtoscrollto="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]";
		
		iOSScrollUp(xpathtoscrollto);

		MobileElement locationdropdown=(MobileElement) driver.findElement(By.name("Select Location"));

		if(locationdropdown.getText().equalsIgnoreCase("Select Location"))
			count++;

		MobileElement hoteldropdown=(MobileElement) driver.findElement(By.name("Select Hotel"));
		if(hoteldropdown.getText().equalsIgnoreCase("Select Hotel"))
			count++;
		
		MobileElement roomtypedropdown=(MobileElement) driver.findElement(By.name("Select Room Type"));
		if(roomtypedropdown.getText().equalsIgnoreCase("Select Room Type"))
			count++;
		iOSScrollDown(xpathtoscrollto);
	
		MobileElement childrenperroomdropdown=(MobileElement) driver.findElement(By.name("Select Children per Room"));
		if(childrenperroomdropdown.getText().equalsIgnoreCase("Select Children per Room"))
			count++;
		
		Assert.assertEquals(count,4);
		
		
	}
	
	
	/**
	 * Method to search for hotel with hotel and location provided
	 * @param i
	 * @throws Exception
	 */
	public void searchHotel_Hotel_location(int i) throws Exception
	{
		String xpathtoscrollto="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]";
		String expected_location = null,expected_hotel=null;
		expected_location=ExcelUtil.getCellData(i,7);
		expected_hotel=ExcelUtil.getCellData(i,8);
		
		MobileElement locationdropdown=(MobileElement) driver.findElement(By.name("Select Location"));
		locationdropdown.click();
		MobileElement selected_location=(MobileElement) driver.findElement(By.name(expected_location));
		selected_location.click();

		MobileElement hoteldropdown=(MobileElement) driver.findElement(By.name("Select Hotel"));
		hoteldropdown.click();
		MobileElement selected_hotel=(MobileElement) driver.findElement(By.name(expected_hotel));
		selected_hotel.click();
		iOSScrollDown(xpathtoscrollto);
		iOSScrollDown(xpathtoscrollto);
	
			
		MobileElement search=(MobileElement) driver.findElement(By.name("Search"));
		search.click();
		
		
	}
	
	/**
	 * Method to search for hotel with only location field enteed
	 * @param i
	 * @throws Exception
	 */
	public void searchHotel_Location_only(int i) throws Exception
	{
		String xpathtoscrollto="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]";
		String expected_location = null,expected_hotel=null;
		expected_location=ExcelUtil.getCellData(i,7);
		
		MobileElement locationdropdown=(MobileElement) driver.findElement(By.name("Select Location"));
		locationdropdown.click();
		MobileElement selected_location=(MobileElement) driver.findElement(By.name(expected_location));
		selected_location.click();
		iOSScrollDown(xpathtoscrollto);
		iOSScrollDown(xpathtoscrollto);
		MobileElement search=(MobileElement) driver.findElement(By.name("Search"));
		search.click();
		
	}
}
