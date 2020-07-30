package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Home;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

/**
 * Test case to verify reset hotel in search hotel page
 *
 */
public class ResetSearchVerification extends BaseClass {

	public ResetSearchVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	static Login lp;
	static Home hp;
	
	/**
	 * Test case to verify if user can reset the fields in the Search Hotel page through the Reset buttoon
	 * The fields in the Search Hotel page is selected. 
	 * Following which reset button is clicked, then the fields are checked again to see if they are empty
	 *@throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_reset_the_search_criteria() throws Exception
	{
		Log.startTestCase("User_is_able_to_reset_the_search_criteria");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_reset_the_search_criteria");
		initApp(rno);
		
		//Logging into the application
		lp=new Login();
		boolean login_result=lp.login(rno);
		//Logging to the report
		if(login_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
		//Validating the login
		Assert.assertTrue(login_result);
		
		hp=new Home();
		//Searching for hotel
		boolean searchhotel=hp.searchHotel(rno);
		//Logging to the report
		if(searchhotel==true)
			ExtentTestManager.getTest().log(Status.PASS,"The search hotel field entry was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The search hotel field entry was unsuccessful");	
		//Validating the hotel search
		Assert.assertTrue(searchhotel);
		
		//Performing reset
		boolean reset=hp.doReset();
		//Logging to the report
		if(reset==true)
			ExtentTestManager.getTest().log(Status.PASS,"The search hotel page reset was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The search hotel page reset was unsuccessful");	
		//Validating the reset
		Assert.assertTrue(reset);
		
		Log.endTestCase("User_is_able_to_reset_the_search_criteria");
		


	}
}
