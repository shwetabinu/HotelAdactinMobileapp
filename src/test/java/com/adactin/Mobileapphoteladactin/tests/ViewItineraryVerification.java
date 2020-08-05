package com.adactin.Mobileapphoteladactin.tests;
import org.testng.Assert;
import org.testng.ITestContext;
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
 * Test case to view the booked itinerary 
 * It also validates the entry present within the booked itinerary with the Testdata file details
 * 
 *
 */
public class ViewItineraryVerification  extends BaseClass{

	public ViewItineraryVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	static Login lp;
	static Booked_Itinerary bi;
	static Booked_Hotel_Details bhd;
	static Dashboard db;
	
	/**
	 * Test case to view the booked itinerary
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_view_itinerary() throws Exception
	{
		Log.startTestCase("User_is_able_to_view_itinerary");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		
		//Reading the test data for the test case
		rno=ExcelUtil.readExcel('r',"User_is_able_to_view_itinerary");
		//Initializing the app
		initApp(rno);
		
		lp=new Login();
		
		//Logging into the application
		boolean login_result=lp.login(rno);
		//Logging to the report
		if(login_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
		//Validating the login
		Assert.assertTrue(login_result);
		
		db=new Dashboard();
		//Viewing the booked itinerary
		boolean viewbooked=db.viewBookedItinerary();
		//Logging to the report
		if(viewbooked==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Booked itinerary navigation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Booked itinerary navigation was unsuccessful");	
		//Validating the booked itinerary page
		Assert.assertTrue(viewbooked);
		
		bi=new Booked_Itinerary();
		//Viewing a booked hotel
		boolean booked_hotel=bi.viewBookedHotel(rno);
		//Logging to the report
		if(booked_hotel==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Booked hotel details page navigation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Booked hotel details page navigation was unsuccessful");	
		//Verifying if the boooked hotel is displayed
		Assert.assertTrue(booked_hotel);
	
		if((login_result  && viewbooked && booked_hotel
				)==true)
			ExcelUtil.setCellData("PASSED", rno, 0);
		else
			ExcelUtil.setCellData("FAILED", rno, 0);
		Log.endTestCase("User_is_able_to_view_itinerary");
	}

}
