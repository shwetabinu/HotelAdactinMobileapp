package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Book_Hotel;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin1.pages.Booking_Confirmation;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin1.pages.Selected_Hotel_Detail;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

public class User_is_able_to_book_a_hotel extends BaseClass{
	
	public User_is_able_to_book_a_hotel() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	
	static Login lp;
	static Home hp;
	static Select_Hotel sp;
	static Selected_Hotel_Detail shd;
	static Book_Hotel bh;
	static Booking_Confirmation bc;
	static Booked_Itinerary bi;
	
	
	@Test
	public void User_is_able_to_book_a_hotel() throws Exception
	{
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_able_to_book_a_hotel");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		hp=new Home();
		hp.searchHotel(rno);
		sp=new Select_Hotel();
		sp.select_hotel();
		shd=new Selected_Hotel_Detail();
		shd.click_on_select();
		bh=new Book_Hotel();
		bh.enterBookingDetails(rno);
		bc=new Booking_Confirmation();
		bc.confirm_Booking();
		bi=new Booked_Itinerary();
		bi.viewFirstBookedHotelDetails();
		
		
		
	}

}
