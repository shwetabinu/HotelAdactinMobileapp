package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Book_Hotel;
import com.adactin.Mobileapphoteladactin.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin.pages.Booking_Confirmation;
import com.adactin.Mobileapphoteladactin.pages.Dashboard;
import com.adactin.Mobileapphoteladactin.pages.Home;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin.pages.Selected_Hotel_Detail;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

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
	
	/**
	 * Test case to verify if a user can book a hotel successfully with the details present in the Testdata file
	 * 
	 *@throws Exception Exception during test execution
	 */
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
		//Logging to the report
		if(loginresult==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login button click was unsuccessful");	
		
		Assert.assertTrue(loginresult);
		
		//Navigating to the dash-board and to the booked itinerary
		db=new Dashboard();
		boolean viewbooked=db.viewBookedItinerary();
		//Logging to the report
		if(viewbooked==true)
			ExtentTestManager.getTest().log(Status.PASS,"The booked itinerary click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The booked itinerary click was unsuccessful");		
		
		Assert.assertTrue(viewbooked);
		
		bi=new Booked_Itinerary();
		//Calculating the total list of hotels
		bi.calcHotelSize(rno);
		
		//Navigating back to home
		db.viewHome(rno);	
		hp=new Home();
		
		//Searching for the hotel with the test data and validating the same
		boolean searchresult=hp.searchHotel(rno);
		//Logging to the report
		if(searchresult==true)
			ExtentTestManager.getTest().log(Status.PASS,"The hotel list in the Search hotel page validation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The hotel list in the Search hotel page validation was unsuccessful");		
		
		
		Assert.assertTrue(searchresult);
		
		//Validating the search for the hotel
		boolean search=hp.clickOnSearch();
		//Logging to the report
		if(search==true)
			ExtentTestManager.getTest().log(Status.PASS,"The hotel search click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The hotel search click was unsuccessful");		
		
		
		Assert.assertTrue(search);
		
		//Validating select hotel function
		sp=new Select_Hotel();
		boolean selecthotel=sp.select_hotel(rno,0);
		//Logging to the report
		if(selecthotel==true)
			ExtentTestManager.getTest().log(Status.PASS,"The hotel selection was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The hotel selection was unsuccessful");		
		
		
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
		//Logging to the report
		if(selected_hotel==true)
			ExtentTestManager.getTest().log(Status.PASS,"The selected hotel details validation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The selected hotel details validation unsuccessful");		
			
		Assert.assertTrue(selected_hotel);
		
		//Booking hotel and validating the same
		bh=new Book_Hotel();
		bh.readExpectedData(rno);
		boolean booking=bh.enterBookingDetails(rno);
		//Logging to the report
		if(booking==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Hotel details entry in the book hotel page was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The  Hotel details entry in the book hotel page was unsuccessful");		
			
		Assert.assertTrue(booking);
		
		//Clicking on book now button
		boolean booknow=bh.clickBookNow();
		//Logging to the report
		if(booknow==true)
			ExtentTestManager.getTest().log(Status.PASS,"The book now button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The  book now button click was unsuccessful");		
			
		Assert.assertTrue(booknow);
				
		
		//Validating the booking confirmation page
		bc=new Booking_Confirmation();
		boolean bookresult=bc.validateBookingConfirmationDetails();
		//Logging to the report
		if(bookresult==true)
			ExtentTestManager.getTest().log(Status.PASS,"The validation of booking confirmation details was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The  validation of booking confirmation details was unsuccessful");		
			
		Assert.assertTrue(bookresult);
		bc.getOrderId();
		
		//Confirming the booking and validating the same
		boolean book_confirm=bc.confirm_Booking();
		//Logging to the report
		if(book_confirm==true)
			ExtentTestManager.getTest().log(Status.PASS,"The confirm button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The  confirm button click was unsuccessful");		
			
		Assert.assertTrue(book_confirm);
		
		//Navigating to the Booked itinerary
		db=new Dashboard();
		boolean gotobooked=db.viewBookedItinerary();
		//Logging to the report
		if(gotobooked==true)
			ExtentTestManager.getTest().log(Status.PASS,"The booked itinerary navigation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The booked itinerary navigation was unsuccessful");			
		Assert.assertTrue(gotobooked);
	
		//Checking the number of booked hotels and verifying if the total entries have increased
		boolean booked_result=bi.checkBooked();
		//Logging to the report
		if(booked_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The booked itinerary verification was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The booked itinerary verification was unsuccessful");			
		Assert.assertTrue(booked_result);
		if((loginresult && searchresult && search && selecthotel
				&& selected_hotel && booknow && bookresult && book_confirm && gotobooked 
				&& booked_result)==true)
			ExcelUtil.setCellData("PASSED", rno, 0);
		else
			ExcelUtil.setCellData("FAILED", rno, 0);
		Log.endTestCase("User_is_able_to_book_a_hotel");
		
		
	}
	/**
	 * Closing the app
	 */
	@AfterTest(groups = { "functionalTest" })
	public void closeSession()
	{
		//Close the app
		closeApp();
	}

}
