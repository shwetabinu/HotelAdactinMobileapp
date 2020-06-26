package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

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
	 *
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
		Assert.assertTrue(login);
		
		//Validating if blank login credentials error message is displayed
		Log.info("Checking for invalid credentials error messages...");
		boolean blankerror=lp.checkBlankFieldsError(rno);
		Assert.assertTrue(blankerror);
		
		Log.endTestCase("User_is_shown_error_message_when he_logins_without_username_"
				+ "or/and_password");		
		
	}
}
