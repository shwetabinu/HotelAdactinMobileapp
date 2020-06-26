package com.adactin.Mobileapphoteladactin1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.adactin.Mobileapphoteladactin1.util.ScrollUtil;

import io.appium.java_client.MobileElement;

/**
 * Home page has methods to initialize the home page.
 * It has methods to search hotel 
 *
 */
public class Home extends BaseClass {
	public Home() throws Exception
	{		
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath="//android.view.View[1][contains(@text,'welcome')]")
	WebElement welcome_msg;
/**
 * Method to check the welcome message of a user
 * @param rno
 * @throws Exception
 */
	public boolean checkWelcomeMessage(int rno) throws Exception
	{
		boolean result;
		try {	
		//Assigning Expected Message to be verified
		String expectedmsg;
		expectedmsg="welcome_user";
		//Verifying the actual message with the expected message
		//and assigning the result of validation to result
		if(welcome_msg.getText().equalsIgnoreCase(expectedmsg))
			result=true;
		else
			result=false;
			
		}catch(Exception e) {
			result=false;
		}
		//returning the value of result depending on the outcome of execution
		return result;
		
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

		MobileElement locationdropdown=(MobileElement) driver.findElement(By.xpath("//android.view.View[4]/android.widget.EditText"));
		locationdropdown.click();
		List<MobileElement> selected_location=(List<MobileElement>) driver.findElements(By.xpath("//android.view.View[2]/android.view.View[1]/android.view.View"));
		for(int j=0;j<selected_location.size();j++)
			{
			System.out.println(selected_location.get(j).getText());
			if(selected_location.get(j).getText().contains(expected_location))
				{
				selected_location.get(j).click();
				break;
				//Thread.sleep(1000);
				}
			}
		List<MobileElement> selected_location1=(List<MobileElement>)driver.findElements(By.xpath("//android.view.View[2]/android.view.View/android.view.View/android.view.View"));
		for(int j=0;j<selected_location1.size();j++)
		{
		System.out.println(selected_location1.get(j).getText());
		if(selected_location1.get(j).getText().contains(expected_location))
			{
			selected_location1.get(j).click();
			break;
			//Thread.sleep(1000);
			}
		}
		MobileElement hoteldropdown=(MobileElement) driver.findElement(By.xpath("//android.view.View[6]/android.widget.EditText"));
		//selected_location.click();
		hoteldropdown.click();
		List<MobileElement> selected_hotel=(List<MobileElement>) driver.findElements(By.xpath("//android.view.View[2]/android.view.View/android.view.View/android.view.View"));
		for(int j=0;j<selected_hotel.size();j++)
		{
		if(selected_hotel.get(j).getText().contains(expected_hotel))
			{
			selected_hotel.get(j).click();
			break;
			}
		}

		List<MobileElement> hoteldropdown1=(List<MobileElement>)driver.findElements(By.xpath("//android.view.View[2]/android.view.View/android.view.View/android.view.View"));
		for(int j=0;j<hoteldropdown1.size();j++)
		{
		System.out.println(hoteldropdown1.get(j).getText());
		if(hoteldropdown1.get(j).getText().contains(expected_hotel))
			{
			hoteldropdown1.get(j).click();
			break;
			//Thread.sleep(1000);
			}
		}
		
		MobileElement roomtypedropdown=(MobileElement) driver.findElement(By.xpath("//android.view.View[8]/android.widget.EditText"));
		//iOSScrollDown(xpathtoscrollto);
		roomtypedropdown.click();
		List<MobileElement> selected_roomtype=(List<MobileElement>) driver.findElements(By.xpath("//android.view.View[2]/android.view.View/android.view.View/android.view.View"));
		for(int j=0;j<selected_roomtype.size();j++)
		{
		if(selected_roomtype.get(j).getText().contains(expected_roomtype))
			{
			selected_roomtype.get(j).click();break;
			}
		}

		List<MobileElement> roomtypedropdown1=(List<MobileElement>)driver.findElements(By.xpath("//android.view.View[2]/android.view.View/android.view.View/android.view.View"));
		for(int j=0;j<roomtypedropdown1.size();j++)
		{
		System.out.println(roomtypedropdown1.get(j).getText());
		if(roomtypedropdown1.get(j).getText().contains(expected_roomtype))
			{
			roomtypedropdown1.get(j).click();
			break;
			//Thread.sleep(1000);
			}
		}

		boolean result=ScrollUtil.pageScrollToText("Search");
		System.out.println("The result of scrolling"+result);
		Thread.sleep(1000);
		//clickOnSearch();
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
		MobileElement search=(MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='Search']"));
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
		
		//iOSScrollUp(xpathtoscrollto);

		MobileElement locationdropdown=(MobileElement) driver.findElement(By.name("Select Location"));

		if(locationdropdown.getText().equalsIgnoreCase("Select Location"))
			count++;

		MobileElement hoteldropdown=(MobileElement) driver.findElement(By.name("Select Hotel"));
		if(hoteldropdown.getText().equalsIgnoreCase("Select Hotel"))
			count++;
		
		MobileElement roomtypedropdown=(MobileElement) driver.findElement(By.name("Select Room Type"));
		if(roomtypedropdown.getText().equalsIgnoreCase("Select Room Type"))
			count++;
		//iOSScrollDown(xpathtoscrollto);
	
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
		//iOSScrollDown(xpathtoscrollto);
		//iOSScrollDown(xpathtoscrollto);
	
			
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
		//iOSScrollDown(xpathtoscrollto);
		//iOSScrollDown(xpathtoscrollto);
		MobileElement search=(MobileElement) driver.findElement(By.name("Search"));
		search.click();
		
	}
}
