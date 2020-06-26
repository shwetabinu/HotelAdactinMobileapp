package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Book_Hotel;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin1.pages.Booking_Confirmation;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin1.pages.Selected_Hotel_Detail;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * Testcase to verify if a user can book a hotel successfully with the details present in the Testdata file
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
	static Booked_Itinerary bi;
	static Booked_Hotel_Details bhd;
	
	
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_book_a_hotel() throws Exception
	{
		Log.startTestCase("User_is_able_to_book_a_hotel");
		int rno;
		String ordid;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_book_a_hotel");
		initApp(rno);
		lp=new Login();
		lp.login(rno);
		hp=new Home();
		hp.searchHotel(rno);
		hp.clickOnSearch();
		sp=new Select_Hotel();
		sp.select_hotel(1);
		shd=new Selected_Hotel_Detail();
		shd.click_on_select();
		bh=new Book_Hotel();
		bh.enterBookingDetails(rno);
		bc=new Booking_Confirmation();
		ordid=bc.getOrderId();
		bc.confirm_Booking();
		bi=new Booked_Itinerary();
		//String bhd_id=bi.readWhichEntry(rno);
		bi.viewBookedHotelDetails();
		
		bhd=new Booked_Hotel_Details();
		boolean result=bhd.validateOrderID(ordid);
		Assert.assertTrue(result);
		int count=bhd.checkBookedHotelDetails(rno, ordid);
		Assert.assertEquals(count,6);
		Log.endTestCase("User_is_able_to_book_a_hotel");
		
		
	}
	
	@AfterTest(groups = { "functionalTest" })
	public void closeSession()
	{
		closeApp();
	}

}
