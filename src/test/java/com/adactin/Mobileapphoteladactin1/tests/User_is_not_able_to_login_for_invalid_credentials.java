package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * Test case to check if a user can login to the application with invalid user id and password
 * It validates the error message which pops up
 *
 */
public class User_is_not_able_to_login_for_invalid_credentials extends BaseClass{

	public User_is_not_able_to_login_for_invalid_credentials() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp;
	
	
	
	@Test(groups = { "sfunctionalTest" })
	public void User_is_not_able_to_login_for_invalid_credentials() throws Exception
	{
		Log.startTestCase("User_is_not_able_to_login_for_invalid_credentials");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_not_able_to_login_for_invalid_credentials");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		lp.checkErrorMessage(rno);
		Log.endTestCase("User_is_not_able_to_login_for_invalid_credentials");
		
		
	}
	

}
