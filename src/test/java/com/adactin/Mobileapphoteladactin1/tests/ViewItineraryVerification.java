package com.adactin.Mobileapphoteladactin1.tests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin1.pages.Dashboard;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.aventstack.extentreports.Status;

import reportgeneration.ExtentTestManager;

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
	
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_view_itinerary(final ITestContext testContext) throws Exception
	{
		Log.startTestCase("User_is_able_to_view_itinerary");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_view_itinerary");
		initApp(rno);
		
		lp=new Login();
		boolean login_result=lp.login(rno);
		if(login_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
		Assert.assertTrue(login_result);
		
		db=new Dashboard();
		boolean viewbooked=db.viewBookedItinerary();
		if(viewbooked==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Booked itinerary navigation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Booked itinerary navigation was unsuccessful");	
		Assert.assertTrue(viewbooked);
		
		bi=new Booked_Itinerary();
		boolean booked_hotel=bi.viewBookedHotel(rno);
		if(booked_hotel==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Booked hotel details page navigation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Booked hotel details page navigation was unsuccessful");	
		Assert.assertTrue(booked_hotel);
	
		Log.endTestCase("User_is_able_to_view_itinerary");
	}

}
