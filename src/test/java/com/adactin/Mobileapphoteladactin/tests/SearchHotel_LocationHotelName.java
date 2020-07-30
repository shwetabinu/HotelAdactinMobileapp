package com.adactin.Mobileapphoteladactin.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Home;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

/**
 * Test case to verify if the user can search for hotel with location and hotel name provided as input
 * Each of the hotel entry displayed is verified for different room types
 *
 *
 */
public class SearchHotel_LocationHotelName extends BaseClass{

	static Login lp;
	static Home hp;
	static Select_Hotel sp;
	

	public SearchHotel_LocationHotelName() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Test case to validate searching hotel with location and hotel name
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_search_hotel_with_location_and_hotelname() throws Exception
	{
		Log.startTestCase("User_is_able_to_search_hotel_with_location_and_hotelname");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_search_hotel_with_location_and_hotelname");
		Log.info("Initializing the app..");
		
		//Initializing the application
		initApp(rno);
		
		//Creating an object of login page
		lp=new Login();
		Log.info("Logging in...");
		
		//Logging into the application and verifying
		boolean login=lp.login(rno);
		//Logging to the report
		if(login==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
		Assert.assertTrue(login);
		
		hp=new Home();
		
		//Searching for the hotel with the input
		boolean search=hp.searchHotel(rno);
		//Logging to the report
		if(search==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Search hotel fields entry was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Search hotel fields entry was unsuccessful");	
		
		Assert.assertTrue(search);
		
		//Clicking on search button
		boolean searchclick=hp.clickOnSearch();
		//Logging to the report
		if(searchclick==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Search button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Search button click was unsuccessful");	
		
		Assert.assertTrue(searchclick);
		
		sp=new Select_Hotel();
		boolean hotel_result=sp.readHotelName(rno);
		//Logging to the report
		if(hotel_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Select Hotel page validation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Select Hotel page validation was unsuccessful");	
		
		Assert.assertTrue(hotel_result);
		
		Log.endTestCase("User_is_able_to_search_hotel_with_location_and_hotelname");	
		
	
	}

}
