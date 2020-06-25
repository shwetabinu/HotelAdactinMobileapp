package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * Test case to verify if the user can cancel a hotel booking.
 * The cancel button is clicked from one of the entries in the booked itinerary
 * After successful cancelation, the booked itinerary is checked again to see if
 * the canceled entry is present
 * 
 *
 */
public class User_is_able_to_cancel_a_hotel_booking extends BaseClass {

	public User_is_able_to_cancel_a_hotel_booking() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp;
	static Booked_Itinerary bi,bi1;
	static Booked_Hotel_Details bhd;
	
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_cancel_a_hotel_booking() throws Exception
	{
		Log.startTestCase("User_is_able_to_cancel_a_hotel_booking");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_able_to_cancel_a_hotel_booking");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		bi=new Booked_Itinerary();
		String bhd_id;
		bhd_id=bi.readWhichEntry(rno);
		bi.viewBookedHotelDetails();
		bhd=new Booked_Hotel_Details();
		bhd.cancelBooked_itinerary();
		bi1=new Booked_Itinerary();
		Assert.assertEquals(bi1.checkIfCanceled(bhd_id), false);
		Log.endTestCase("User_is_able_to_cancel_a_hotel_booking");
		
	}
	

}
