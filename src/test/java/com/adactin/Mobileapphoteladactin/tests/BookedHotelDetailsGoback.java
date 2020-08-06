package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin.pages.Dashboard;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

/**
 * Test case to validate going back from booked hotel details page
 * @author shwetabinu
 *
 */
public class BookedHotelDetailsGoback extends BaseClass {
	
	public BookedHotelDetailsGoback() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	static Login lp;
	static Booked_Itinerary bi;
	static Booked_Hotel_Details bhd;
	static Dashboard db;
	
	/**
	 * Test case to validate going back from booked hotel details page
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_view_itinerary() throws Exception
	{
		Log.startTestCase("User_is_able_to_navigate_back_to_the_booked_itinerary_screen_by_clicking_the_back_arrow_link_");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		//Reading testdata
		rno=ExcelUtil.readExcel('r',"User_is_able_to_navigate_back_to_the_booked_itinerary_screen_by_clicking_the_back_arrow_link_");
		//Initialising app
		initApp(rno);
		
		//Logging into the application
		lp=new Login();
		boolean login_result=lp.login(rno);
		//Logging to the report
		if(login_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
		//Validating login
		Assert.assertTrue(login_result);
		
		//Navigating to the booked itinerary
		db=new Dashboard();
		boolean viewbooked=db.viewBookedItinerary();
		//Logging to the report
		if(viewbooked==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Booked itinerary navigation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Booked itinerary navigation was unsuccessful");	
		//Validating the navigation
		Assert.assertTrue(viewbooked);
		
		//Viewing the booked hotel from the itinerary
		bi=new Booked_Itinerary();
		boolean booked_hotel=bi.viewBookedHotel(rno);
		//Logging to the report
		if(booked_hotel==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Booked hotel details page navigation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Booked hotel details page navigation was unsuccessful");	
		//Validating the result of viewing the hotel
		Assert.assertTrue(booked_hotel);
		
		bhd=new Booked_Hotel_Details();
		//Reading the expected data
		bhd.readExpectedData(rno);
		
		//going back from the booked hotel details page
		boolean bhd_goback=bhd.goBack();
		//Logging to the report
		if(bhd_goback==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Booked hotel details validation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Booked hotel details validation was unsuccessful");	
		//Verifying the booked hotel details
		Assert.assertTrue(bhd_goback);
		
		if((login_result  && viewbooked && booked_hotel && bhd_goback
				)==true)
			ExcelUtil.setCellData("PASSED", rno, 0);
		else
			ExcelUtil.setCellData("FAILED", rno, 0);
		
		
		Log.endTestCase("User_is_able_to_navigate_back_to_the_booked_itinerary_screen_by_clicking_the_back_arrow_link_");
	}

}



