package com.adactin.Mobileapphoteladactin1.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

public class User_is_able_to_login_into_the_application extends BaseClass{
	
	static Login lp;
	public User_is_able_to_login_into_the_application() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		//ExcelUtil.setExcelFileSheet("Testcases");
	}

	@Test
	public void User_is_able_to_login_into_the_application() throws Exception
	{
		//Login lp = null;
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_able_to_login_into_the_application");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
	}

	@AfterTest
	public void closingapp()
	{
		closeApp();
	}
}
