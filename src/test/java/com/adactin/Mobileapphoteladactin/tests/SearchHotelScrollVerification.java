package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Home;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.adactin.Mobileapphoteladactin.util.ScrollUtil;
import com.aventstack.extentreports.Status;

/**
 * Test case to verify if user can scroll in the search hotel page
 *
 */
public class SearchHotelScrollVerification extends BaseClass{
	
	

		public SearchHotelScrollVerification() throws Exception {
			super();
			// TODO Auto-generated constructor stub
		}
		
		Login lp;
		Home hp;
		Select_Hotel sp;

		/**
		 * Test case to verify if scrolling is working in Search Hotel page
		 * @throws Exception Exception during test execution
		 */
		@Test(groups = { "functionalTest" })
		public void User_is_able_to_scroll_down_and_up_on_the_search_hotel_screen() throws Exception
		{
			Log.startTestCase("User_is_able_to_scroll_down_and_up_on_the_search_hotel_screen");
			int rno;
			
			//Reading test data from the TestData file
			ExcelUtil.setExcelFileSheet("Testcases");
			rno=ExcelUtil.readExcel('r',"User_is_able_to_scroll_down_and_up_on_the_search_hotel_screen");
			Log.info("Initializing the app..");
			
			//Initializing the application
			initApp(rno);
			
			//Creating an object of login page
			lp=new Login();
			Log.info("Logging in...");
			
			//Logging into the application and verifying
			boolean login=lp.login(rno);
			//Logging to the report
			if(login==true)
				ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
			else
				ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
			Assert.assertTrue(login);
			
			hp=new Home();
			//Verifying the scroll functionality
			boolean scrollresult=ScrollUtil.pageScrollToText("Search");
			
			//Logging to the report
			if(scrollresult==true)
				ExtentTestManager.getTest().log(Status.PASS,"The Search hotel page is scrollable");
			else
				ExtentTestManager.getTest().log(Status.FAIL,"The Search hotel is not scrollable");	
			
			Assert.assertTrue(scrollresult);
			
			if((login  && scrollresult
					)==true)
				ExcelUtil.setCellData("PASSED", rno, 0);
			else
				ExcelUtil.setCellData("FAILED", rno, 0);
			
			
			Log.endTestCase("User_is_able_to_scroll_down_and_up_on_the_search_hotel_screen");	
			
		}
		
	}


