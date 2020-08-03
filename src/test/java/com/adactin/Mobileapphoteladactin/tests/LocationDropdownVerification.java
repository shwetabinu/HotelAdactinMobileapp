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
import com.aventstack.extentreports.Status;

/**
 * Test case to verify if all the locations are present in the location drop down in the search
 * hotel page
 *
 */
public class LocationDropdownVerification extends BaseClass{
	
		

			public LocationDropdownVerification() throws Exception {
				super();
				// TODO Auto-generated constructor stub
			}
			
			Login lp;
			Home hp;
			Select_Hotel sp;

			/**
			 * Test case to validate location drop down options
			 * @throws Exception Exception during test execution
			 */
			@Test(groups = { "functionalTest" })
			public void User_is_able_to_view_the_drop_down_list_in_locations() throws Exception
			{
				Log.startTestCase("User_is_able_to_view_the_drop_down_list_in_locations");
				int rno;
				
				//Reading test data from the TestData file
				ExcelUtil.setExcelFileSheet("Testcases");
				rno=ExcelUtil.readExcel('r',"User_is_able_to_view_the_drop_down_list_in_locations");
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
				//Verifying the location drop down items
				boolean locitems=hp.viewLocationDropdown(rno);
				
				//Logging to the report
				if(locitems==true)
					ExtentTestManager.getTest().log(Status.PASS,"All The location drop down options are present in the Search hotel page");
				else
					ExtentTestManager.getTest().log(Status.FAIL,"All the location drop down options are not present in the Search Hotel page");	
				
				Assert.assertTrue(locitems);
				
				
				Log.endTestCase("User_is_able_to_view_the_drop_down_list_in_locations");	
				
			}
			
		}





