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

public class CheckoutDateValidation extends BaseClass{
	
	

	public CheckoutDateValidation() throws Exception {
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
	public void User_should_be_able_to_enter_date_in_the_Check_out_date_field() throws Exception
	{
		Log.startTestCase("User_should_be_able_to_enter_date_in_the_Check_out_date_field");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_should_be_able_to_enter_date_in_the_Check_out_date_field");
		
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
		boolean checkoutdate=hp.validateCheckoutDate();
		
		
		//Logging to the report
		if(checkoutdate==true)
			ExtentTestManager.getTest().log(Status.PASS,"The checkout date was selected");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The checkout date selection was unsuccessful");	
		
		boolean doneclick=hp.clickonDone();
		if(doneclick==true)
			ExtentTestManager.getTest().log(Status.PASS,"The done button was clicked to select the check-in date");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The done button click was unsuccessful");	
		
		Assert.assertTrue(doneclick);
		
		if((login && checkoutdate && doneclick
				)==true)
			ExcelUtil.setCellData("PASSED", rno, 0);
		else
			ExcelUtil.setCellData("FAILED", rno, 0);
		
		Log.endTestCase("User_should_be_able_to_enter_date_in_the_Check_out_date_field");	
		
	}
	
}
