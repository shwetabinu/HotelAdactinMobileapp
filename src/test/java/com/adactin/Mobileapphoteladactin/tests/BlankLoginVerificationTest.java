package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

/**
 * Test case to verify error messages displayed when user logs in without any
 * user name and/or password
 *
 *
 */
public class BlankLoginVerificationTest extends BaseClass {

	public BlankLoginVerificationTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp;
	
	/**
	 * Test case to verify error messages displayed when user logs in without any
	 * user name and/or password
	 *
	 *@throws Exception any exception while executing the test
	 */
	@Test
	public void MAHA_TC02_TC_BlankLoginVerificationTest() throws Exception {
		
		Log.startTestCase("User_is_shown_error_message_when he_logins_without_"
				+ "username_or/and_password");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_shown_error_message_when he_logins_"
				+ "without_username_or/and_password");
		Log.info("Initializing the app..");
		
		//Initializing the application
		initApp(rno);
		
		
		//Logging into the application
		lp=new Login();
		Log.info("Logging in...");	
		boolean login=lp.login(rno);
		//Validating the login
		Assert.assertTrue(login);
		//Report logging
		if(login==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login button click was unsuccessful");
		
	
		Log.info("Checking for invalid credentials error messages...");
		boolean blankerror=lp.checkBlankFieldsError(rno);
		//Report logging
		if(blankerror==true)
			ExtentTestManager.getTest().log(Status.PASS,"The blank login showed the error message");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The blank login validation was unsuccessful");
		//Validating if blank login credentials error message is displayed
		Assert.assertTrue(blankerror);
		
		Log.endTestCase("User_is_shown_error_message_when he_logins_without_username_"
				+ "or/and_password");		
		
	}
}
