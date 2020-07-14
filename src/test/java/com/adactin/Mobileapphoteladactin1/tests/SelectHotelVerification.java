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

public class SelectHotelVerification extends BaseClass{

	public SelectHotelVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Login lp;
	static Home hp;
	static Select_Hotel sp;
	static Selected_Hotel_Detail shd;
	
	/**
	 * Test case to verify if the user can select the hotel depending on the input data specified
	 * Validates the data in the selected hotel details page
	 * @throws Exception
	 */
	@Test
	public void User_is_able_to_select_hotel() throws Exception
	{
		Log.startTestCase("User_is_able_to_select_hotel");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_select_hotel");
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
		//boolean hotel_result=sp.readHotelName(rno);
		//Assert.assertTrue(hotel_result);
		
		//Selecting the first hotel displayed
		boolean select=sp.select_hotel(rno,0);
		Assert.assertTrue(select);
		
		//Reading the expected data to be verified in the selected hotel details page
		shd=new Selected_Hotel_Detail();	
		shd.readExpectedData(rno);
		
		//Calculating the total number of days for which hotel was booked
		boolean daycalculate=shd.dayNoCalculate(rno);
		Assert.assertTrue(daycalculate);
		
		//Calculating the total price for the hotel room booked
		boolean pricecalculate=shd.priceCalculation(rno);
		Assert.assertTrue(pricecalculate);
		
		//Validating the details in the hotel details page
		boolean valid_result=shd.validateDetails();
		Assert.assertTrue(valid_result);
		
		//Selecting the hotel
		boolean select_result=shd.click_on_select();
		Assert.assertTrue(select_result);
			
		Log.endTestCase("User_is_able_to_search_hotel_with_location_and_hotelname");	
		
	
	}
}
