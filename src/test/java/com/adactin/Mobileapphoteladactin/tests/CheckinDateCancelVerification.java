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

public class CheckinDateCancelVerification extends BaseClass{
	
	

	public CheckinDateCancelVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login lp;
	Home hp;
	Select_Hotel sp;

	/**
	 * Test case to validate check in date in Search Hotel page
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_click_cancel_link_in_the_check_in_date() throws Exception
	{
		Log.startTestCase("User_is_able_to_click_cancel_link_in_the_check_in_date");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_click_cancel_link_in_the_check_in_date");
		
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
		boolean checkindate=hp.validateCheckinDate();
		
		
		//Logging to the report
		if(checkindate==true)
			ExtentTestManager.getTest().log(Status.PASS,"The checkin date was selected");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The checkin date selection was unsuccessful");	
		
		boolean cancelclick=hp.clickonCancel();
		if(cancelclick==true)
			ExtentTestManager.getTest().log(Status.PASS,"The cancel button was clicked to select the check-in date");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The cancel button click was unsuccessful");	
		
		Assert.assertTrue(checkindate);
		if((login && checkindate && cancelclick
				)==true)
			ExcelUtil.setCellData("PASSED", rno, 0);
		else
			ExcelUtil.setCellData("FAILED", rno, 0);
		
		Log.endTestCase("User_is_able_to_click_cancel_link_in_the_check_in_date");	
		
	}
	
}







