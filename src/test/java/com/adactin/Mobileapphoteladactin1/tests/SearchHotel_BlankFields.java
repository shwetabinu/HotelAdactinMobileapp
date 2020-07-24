package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

public class SearchHotel_BlankFields extends BaseClass {
	
	public SearchHotel_BlankFields() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Login lp;
	Home hp;
	
	@Test
	public void MAHA_TC03_TC_SearchHotel_BlankFieldsTest() throws Exception {
		Log.startTestCase("User_is_able_to_view_error_Search_No_Input");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_view_error_Search_No_Input");
		Log.info("Initializing the app..");
		
		//Initializing the application
		initApp(rno);
		
		//Creating an object of login page
		lp=new Login();
		Log.info("Logging in...");
		
		//Logging into the application and verifying
		boolean login=lp.login(rno);
		Assert.assertTrue(login);
		
		hp=new Home();
		//Clicking on search button
		boolean searchclick=hp.clickOnSearch();
		Assert.assertTrue(searchclick);
		
		//Validating the alert popup message
		boolean alertresult=hp.verifyAlertPopupMessage(rno);
		Assert.assertTrue(alertresult);
		
		//Validating the in-line error messages on the home screen
		boolean inlineerror=hp.verifyInlineError(rno);
		Assert.assertTrue(inlineerror);
		
		Log.endTestCase("User_is_able_to_view_error_Search_No_Input");	
		
		
	}



}
