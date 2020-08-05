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
 * Test case to validate error alert when no input is provided while Searching Hotel
 * @author aswinvijayan
 *
 */
public class SearchHotel_BlankFields extends BaseClass {
	
	public SearchHotel_BlankFields() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Login lp;
	Home hp;
	
	/**
	 * Test case to validate error alert when no input is provided while Searching Hotel
	 * @throws Exception Exception during test execution
	 */
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
		//Logging to the report
		if(login==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");			
		Assert.assertTrue(login);
		
		hp=new Home();
		//Clicking on search button
		boolean searchclick=hp.clickOnSearch();
		//Logging to the report
		if(searchclick==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Search button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Search button click was unsuccessful");			
		Assert.assertTrue(searchclick);
		
		//Validating the alert popup message
		boolean alertresult=hp.verifyAlertPopupMessage(rno);
		//Logging to the report
		if(alertresult==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Alert popup verification was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Alert popup verification was unsuccessful");		
		Assert.assertTrue(alertresult);
		
		//Validating the in-line error messages on the home screen
		boolean inlineerror=hp.verifyInlineError(rno);
		//Logging to the report
		if(inlineerror==true)
			ExtentTestManager.getTest().log(Status.PASS,"The inline error verification was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The inline error verification was unsuccessful");			
		Assert.assertTrue(inlineerror);
		if((login && alertresult && searchclick && inlineerror
				)==true)
			ExcelUtil.setCellData("PASSED", rno, 0);
		else
			ExcelUtil.setCellData("FAILED", rno, 0);
		
		
		Log.endTestCase("User_is_able_to_view_error_Search_No_Input");	
		
		
	}



}
