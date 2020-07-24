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
		String ordid;
		//Reading the test case row number where the data is to be read
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_book_a_hotel");
		
		//Initializing the app
		initApp(rno);
		lp=new Login();
		//Validating logging in
		boolean loginresult=lp.login(rno);
		Assert.assertTrue(loginresult);
		

		db=new Dashboard();
		boolean viewbooked=db.viewBookedItinerary();
		Assert.assertTrue(viewbooked);
		
		bi=new Booked_Itinerary();
		bi.calcHotelSize(rno);
		
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
		
		shd.readExpectedData(rno);
		shd.dayNoCalculate(rno);	
		shd.priceCalculation(rno);
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
		
		db=new Dashboard();
		boolean gotobooked=db.viewBookedItinerary();
		Assert.assertTrue(gotobooked);
		
		bi=new Booked_Itinerary();
		bi.calcHotelSize(rno);
	//	Assert.assertTrue(viewhotel);
		
		bhd=new Booked_Hotel_Details();
		bhd.goBack();
			
		//bi1=new Booked_Itinerary();
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
