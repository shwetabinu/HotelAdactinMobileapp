package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin1.pages.Dashboard;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * Test case to verify if the user can cancel a hotel booking.
 * The cancel button is clicked from one of the entries in the booked itinerary
 * After successful cancellation, the booked itinerary is checked again to see if
 * the canceled entry is present
 * 
 *
 */
public class BookingCancelationVerification extends BaseClass {

	public BookingCancelationVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp;
	static Booked_Itinerary bi,bi1;
	static Dashboard db,db1;
	static Booked_Hotel_Details bhd;
	
	/**
	 * Test case to verify cancellation of the hotel booked
	 * @throws Exception
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_cancel_a_hotel_booking() throws Exception
	{
		Log.startTestCase("User_is_able_to_cancel_a_hotel_booking");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_cancel_a_hotel_booking");
		initApp(rno);
		
		//Logging into the application
		lp=new Login();
		boolean login_result=lp.login(rno);
		Assert.assertTrue(login_result);
		
		//Validating the Navigation to the booked itinerary page
		db=new Dashboard();
		boolean result=db.viewBookedItinerary();
		Assert.assertTrue(result);
		
		//Viewing the hotel booking to be canceled and validating the same
		bi=new Booked_Itinerary();	
		boolean booked_result=bi.viewBookedHotel(rno);
		Assert.assertTrue(booked_result);
		
		//Canceling the booking and validating the cancellation
		bhd=new Booked_Hotel_Details();		
		boolean cancel_result=bhd.cancelBooked_itinerary();
		Assert.assertTrue(cancel_result);
		
		//Cross-checking the number of entries in the booked itinerary page 
		boolean cancel_outcome=bi.checkCanceled();
		Assert.assertTrue(cancel_outcome);
		Log.endTestCase("User_is_able_to_cancel_a_hotel_booking");
		
	}
	

}
