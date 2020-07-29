package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.aventstack.extentreports.Status;

import reportgeneration.ExtentTestManager;

/**
 * Test case to verify if user can login to the application using valid login credentials
 * The Welcome message in the Home page is checked to verify successful user login
 */
public class ValidLoginVerificationTest extends BaseClass{
	
	static Login lp;
	static Home hp;
	public ValidLoginVerificationTest() throws Exception {
		super();

	}

	/**
	 * Test case to verify if user can login to the application using valid login credentials
	 * The Welcome message in the Home page is checked to verify successful user login
	 */
	@Test(groups = { "functionalTest" })
	public void MAHA_TC03_TC_ValidLoginVerificationTest() throws Exception
	{
		
		Log.startTestCase("User_is_able_to_login_into_the_application");
		int rno;
		//Reading the TestData from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_login_into_the_application");
		
		//Initializing Hotel Adactin Mobile Application
		Log.info("Initalizing the application..");
		initApp(rno);
		
		//Logging into the application
		lp=new Login();
		
		//Verifying if the login is successful
		boolean login=lp.login(rno);
		if(login==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
		Assert.assertTrue(login);
		
		//Launching the Home page
		hp=new Home();
		
		//Checking the welcome message to validate login
		boolean welcomemsg= hp.checkWelcomeMessage(rno);
		if(welcomemsg==true)
			ExtentTestManager.getTest().log(Status.PASS,"The welcome message validation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The welcome message validation was unsuccessful");
		Assert.assertTrue(welcomemsg);
		
		Log.endTestCase("User_is_able_to_login_into_the_application");
		
	}

	
}
