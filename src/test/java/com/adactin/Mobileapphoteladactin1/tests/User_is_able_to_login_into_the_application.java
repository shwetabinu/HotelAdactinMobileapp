package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * Test case to verify if user can login to the application using valid login credentials
 * The Welcome message in the Home page is checked to verify successful user login
 */
public class User_is_able_to_login_into_the_application extends BaseClass{
	
	static Login lp;
	static Home hp;
	public User_is_able_to_login_into_the_application() throws Exception {
		super();

	}

	@Test(groups = { "functionalTest" })
	public void User_is_able_to_login_into_the_application() throws Exception
	{
		Log.startTestCase("User_is_able_to_login_into_the_application");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_able_to_login_into_the_application");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		hp=new Home();
		hp.checkWelcomeMessage(rno);
		Log.endTestCase("User_is_able_to_login_into_the_application");
		
	}

	
}
