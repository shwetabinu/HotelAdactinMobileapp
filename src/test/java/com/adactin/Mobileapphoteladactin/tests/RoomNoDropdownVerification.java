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
 * Class to do verifications of the dropdown elements in Room -Number dropdown of Search hotel page
 * @author shwetabinu
 *
 */
public class RoomNoDropdownVerification extends BaseClass{
	
	

	public RoomNoDropdownVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login lp;
	Home hp;
	Select_Hotel sp;

	/**
	 * Test case to validate room number drop down options
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_view_the_list_of_options_in_the_Number_of_Rooms_drop_down_menu() throws Exception
	{
		Log.startTestCase("User_is_able_to_view_the_list_of_options_in_the_Number_of_Rooms_drop_down_menu");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_view_the_list_of_options_in_the_Number_of_Rooms_drop_down_menu");
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
		//Verifying the room number drop down items
		boolean locitems=hp.viewRoomnoDropdown(rno);
		
		//Logging to the report
		if(locitems==true)
			ExtentTestManager.getTest().log(Status.PASS,"All The room number drop down options are present in the Search hotel page");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"All the room number drop down options are not present in the Search Hotel page");	
		
		Assert.assertTrue(locitems);
		
		
		Log.endTestCase("User_is_able_to_view_the_list_of_options_in_the_Number_of_Rooms_drop_down_menu");	
		
	}
	
}






