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
import com.adactin.Mobileapphoteladactin1.pages.Forgot_Password;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin1.pages.Selected_Hotel_Detail;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

public class ForgotPasswordVerification extends BaseClass {
	
	public ForgotPasswordVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Forgot_Password fp;
	static Login lp;
	
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_send_email() throws Exception
	{
		Log.startTestCase("User_is_able_to_send_email");
		int rno;
		String ordid;
		//Reading the test case row number where the data is to be read
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_send_email");
		
		//Initializing the app
		initApp(rno);
		lp=new Login();
		lp.clickOnForgotpassword();
		fp=new Forgot_Password();
		//fp.switchToWebView();
		fp.emailPassword(rno);
		
		Log.endTestCase("User_is_able_to_book_a_hotel");
		
		
	}
	
	@AfterTest(groups = { "functionalTest" })
	public void closeSession()
	{
		closeApp();
	}


}
