package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

public class User_is_able_to_cancel_a_hotel_booking extends BaseClass {

	public User_is_able_to_cancel_a_hotel_booking() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp;
	static Booked_Itinerary bi,bi1;
	static Booked_Hotel_Details bhd;
	
	@Test
	public void User_is_able_to_cancel_a_hotel_booking() throws Exception
	{
		
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_able_to_book_a_hotel");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		bi=new Booked_Itinerary();
		String bhd_id;
		bhd_id=bi.readWhichEntry(rno);
		bi.viewBookedHotelDetails(bhd_id);
		bhd=new Booked_Hotel_Details();
		bhd.cancelBooked_itinerary();
		bi1=new Booked_Itinerary();
		bi1.viewBookedHotelDetails(bhd_id);
		
	}
	

}
