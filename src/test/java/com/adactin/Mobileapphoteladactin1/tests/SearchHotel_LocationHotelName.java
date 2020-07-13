package com.adactin.Mobileapphoteladactin1.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin1.pages.Selected_Hotel_Detail;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

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
		Assert.assertTrue(login);
		
		hp=new Home();
		
		//Searching for the hotel with the input
		boolean search=hp.searchHotel(rno);
		Assert.assertTrue(search);
		
		//Clicking on search button
		boolean searchclick=hp.clickOnSearch();
		Assert.assertTrue(searchclick);
		
		sp=new Select_Hotel();
		boolean hotel_result=sp.readHotelName(rno);
		Assert.assertTrue(hotel_result);
		
		Log.endTestCase("User_is_able_to_search_hotel_with_location_and_hotelname");	
		
	
	}

}
