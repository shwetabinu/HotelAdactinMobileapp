package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.aventstack.extentreports.Status;

import reportgeneration.ExtentTestManager;

/**
 * Test case to check if a user can login to the application with invalid user id and password
 * It validates the error message which pops up
 *
 */
public class InvalidLoginVerificationTest extends BaseClass{

	public InvalidLoginVerificationTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp;
	
	/**
	 * Test case to check if a user can login to the application with invalid user
	 * id and password
	 * It validates the error message which pops up
	 *
	 */
	@Test(groups = { "sfunctionalTest" })
	public void MAHA_TC01_TC_InvalidLoginVerification() throws Exception
	{
		Log.startTestCase("User_is_shown_an_error_message_when_he_enters_incorrect_"
				+ "username_or_password");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_shown_an_error_message_when_he_enters_incorrect_"
				+ "username_or_password");
		Log.info("Initializing the app..");
		
		//Initializing the application
		initApp(rno);
		
		//Logging into the application
		lp=new Login();
		Log.info("Logging in...");
		
		boolean login=lp.login(rno);
		if(login==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login button click was unsuccessful");	
		
		Assert.assertTrue(login);
		
		//Validating if invalid login credentials error message is displayed
		Log.info("Checking for invalid login credentials alert popup...");
		boolean invaliderror=lp.checkInvalidLoginError(rno);
		if(invaliderror==true)
			ExtentTestManager.getTest().log(Status.PASS,"The invalid error validation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The invalid error validation was unsuccessful");	
		
		Assert.assertTrue(invaliderror);
		
		Log.endTestCase("User_is_shown_an_error_message_when_he_enters_incorrect_"
				+ "username_or_password");		
	}
	

}
