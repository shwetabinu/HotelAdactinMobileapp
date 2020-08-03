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
 * Test case to verify if all the hotels are present in the hotel drop down in the search
 * hotel page
 *
 */
public class HotelDropdownVerification extends BaseClass{
	
	

	public HotelDropdownVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login lp;
	Home hp;
	Select_Hotel sp;

	/**
	 * Test case to validate hotel dropdown options in Search Hotel page
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_view_list_of_hotels_in_the_drop_down_menu() throws Exception
	{
		Log.startTestCase("User_is_able_to_view_list_of_hotels_in_the_drop_down_menu");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_view_list_of_hotels_in_the_drop_down_menu");
		
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
		boolean hotitems=hp.viewHotelDropdown(rno);
		
		//Logging to the report
		if(hotitems==true)
			ExtentTestManager.getTest().log(Status.PASS,"All The hotel drop down options are present in the Search hotel page");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"All the hotel drop down options are not present in the Search Hotel page");	
		
		Assert.assertTrue(hotitems);
		
		
		Log.endTestCase("User_is_able_to_view_list_of_hotels_in_the_drop_down_menu");	
		
	}
	
}






