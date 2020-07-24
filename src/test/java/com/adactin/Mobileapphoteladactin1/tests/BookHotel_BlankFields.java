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

public class BookHotel_BlankFields extends BaseClass{
	
	public BookHotel_BlankFields() throws Exception {
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
	static Booked_Itinerary bi;
	static Booked_Hotel_Details bhd;
	
	
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_view_error_Book_No_Input() throws Exception
	{
		Log.startTestCase("User_is_able_to_view_error_Book_No_Input");
		int rno;
		
		//Reading the test case row number where the data is to be read
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_view_error_Book_No_Input");
		
		//Initializing the app
		initApp(rno);
		lp=new Login();
		//Validating logging in
		boolean loginresult=lp.login(rno);
		Assert.assertTrue(loginresult);
		
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
		boolean selected_hotel=shd.click_on_select();
		Assert.assertTrue(selected_hotel);
		
		bh=new Book_Hotel();
		//Clicking on book now button
		boolean booknow=bh.clickBookNow();
		Assert.assertTrue(booknow);
		
		//Validating alert popup message
		boolean verifyalert=bh.verifyAlertPopupMessage(rno);
		Assert.assertTrue(verifyalert);
		
		//Validating in-line error message
		boolean inlineerror=bh.verifyInlineError(rno);
		Assert.assertTrue(inlineerror);
		
		Log.endTestCase("User_is_able_to_view_error_Book_No_Input");
		
		
	}
	
	@AfterTest(groups = { "functionalTest" })
	public void closeSession()
	{
		closeApp();
	}

}
