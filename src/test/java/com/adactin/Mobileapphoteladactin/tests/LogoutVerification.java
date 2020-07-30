package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Dashboard;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.pages.My_Account;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

/**
 * Test case to verify if user can logout successfully.
 * The presence and enabling of login button is checked after successful logout
 */
public class LogoutVerification extends BaseClass{

	public LogoutVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp,lp1;
	static My_Account acc;
	static Dashboard db;

	/**
	 * Test case to verify if user can successfully log out
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_logout() throws Exception
	{
		Log.startTestCase("User_is_able_to_logout");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_logout");
		initApp(rno);
		
		//Logging into the application
		lp=new Login();
		boolean login_result=lp.login(rno);
		//Logging to the report
		if(login_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");		
		Assert.assertTrue(login_result);
		
		//Clicking on My Account button
		db=new Dashboard();
		boolean myaccountnav=db.viewAccount(rno);
		//Logging to the report
		if(myaccountnav==true)
			ExtentTestManager.getTest().log(Status.PASS,"The My Account page navigation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The My Account page navigation was unsuccessful");			
		Assert.assertTrue(myaccountnav);
		
		//Logging out of the application and checking if successful login is possible
		acc=new My_Account();
		boolean logout_result=acc.Logging_out();
		//Logging to the report
		if(logout_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Logout was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Logout was unsuccessful");			
		Assert.assertTrue(logout_result);
		
		//Checking if login button is present to log into the application again
		lp1=new Login();
		boolean login_conf=lp1.checkIfLoginButtonPresent();
		//Logging to the report
		if(login_conf==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Logout validation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Logout validation was unsuccessful");			
		Assert.assertTrue(login_conf);
	
		Log.endTestCase("User_is_able_to_logout");
		
	}
	
	
}
