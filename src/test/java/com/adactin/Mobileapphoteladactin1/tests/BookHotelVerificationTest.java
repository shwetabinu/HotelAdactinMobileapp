package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Book_Hotel;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin1.pages.Booking_Confirmation;
import com.adactin.Mobileapphoteladactin1.pages.Dashboard;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin1.pages.Selected_Hotel_Detail;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * Test case to verify if a user can book a hotel successfully with the details present in the Testdata file
 * 
 *
 */
public class BookHotelVerificationTest extends BaseClass{
	
	public BookHotelVerificationTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	
	static Login lp;
	static Home hp;
	static Select_Hotel sp;
	static Selected_Hotel_Detail shd;
	static Book_Hotel bh;
	static Booking_Confirmation bc;
	static Dashboard db;
	static Booked_Itinerary bi,bi1;
	static Booked_Hotel_Details bhd;
	
	
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_book_a_hotel() throws Exception
	{
		Log.startTestCase("User_is_able_to_book_a_hotel");
		int rno;
		//Reading the test case row number where the data is to be read
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_book_a_hotel");
		
		//Initializing the app
		initApp(rno);
		lp=new Login();
		//Validating logging in
		boolean loginresult=lp.login(rno);
		Assert.assertTrue(loginresult);
		
		//Navigating to the dash-board and to the booked itinerary
		db=new Dashboard();
		boolean viewbooked=db.viewBookedItinerary();
		Assert.assertTrue(viewbooked);
		
		bi=new Booked_Itinerary();
		//Calculating the total list of hotels
		bi.calcHotelSize(rno);
		
		//Navigating back to home
		db.viewHome(rno);	
		hp=new Home();
		
		//Searching for the hotel with the test data and validating the same
		boolean searchresult=hp.searchHotel(rno);
		Assert.assertTrue(searchresult);
		
		//Validating the search for the hotel
		boolean search=hp.clickOnSearch();
		Assert.assertTrue(search);
		
		//Validating select hotel function
		sp=new Select_Hotel();
		boolean selecthotel=sp.select_hotel(rno,0);
		Assert.assertTrue(selecthotel);
		
		//Validating selected hotel details
		shd=new Selected_Hotel_Detail();
		
		//Reading the expected data
		shd.readExpectedData(rno);
		
		//Calculating total number of days
		shd.dayNoCalculate(rno);	
		
		//Calculating total price
		shd.priceCalculation(rno);
		
		//Selecting the hotel
		boolean selected_hotel=shd.click_on_select();
		Assert.assertTrue(selected_hotel);
		
		//Booking hotel and validating the same
		bh=new Book_Hotel();
		bh.readExpectedData(rno);
		boolean booking=bh.enterBookingDetails(rno);
		Assert.assertTrue(booking);
		
		//Clicking on book now button
		boolean booknow=bh.clickBookNow();
		Assert.assertTrue(booknow);
				
		
		//Validating the booking confirmation page
		bc=new Booking_Confirmation();
		boolean bookresult=bc.validateBookingConfirmationDetails();
		Assert.assertTrue(bookresult);
		bc.getOrderId();
		
		//Confirming the booking
		boolean book_confirm=bc.confirm_Booking();
		Assert.assertTrue(book_confirm);
		
		//Navigating to the Booked itinerary
		db=new Dashboard();
		boolean gotobooked=db.viewBookedItinerary();
		Assert.assertTrue(gotobooked);
	
		//Checking the number of booked hotels and verifying if the total entries have increased
		boolean booked_result=bi.checkBooked();
		Assert.assertTrue(booked_result);
	
		Log.endTestCase("User_is_able_to_book_a_hotel");
		
		
	}
	
	@AfterTest(groups = { "functionalTest" })
	public void closeSession()
	{
		closeApp();
	}

}
