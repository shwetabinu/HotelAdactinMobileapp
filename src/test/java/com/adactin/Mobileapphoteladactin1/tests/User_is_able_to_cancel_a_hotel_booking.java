package com.adactin.Mobileapphoteladactin1.tests;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Itinerary;

public class User_is_able_to_cancel_a_hotel_booking extends BaseClass {

	public User_is_able_to_cancel_a_hotel_booking() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Booked_Itinerary bi;
	
	public void User_is_able_to_cancel_a_hotel_booking() throws Exception
	{
		bi=new Booked_Itinerary();
		bi.viewFirstBookedHotelDetails();
		
	}
	

}
