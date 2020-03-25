package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

public class User_is_not_able_to_login_for_invalid_credentials extends BaseClass{

	public User_is_not_able_to_login_for_invalid_credentials() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp;
	
	
	
	@Test
	public void User_is_not_able_to_login_for_invalid_credentials() throws Exception
	{
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_not_able_to_login_for_invalid_credentials");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		lp.checkErrorMessage(rno);
		
		
	}
	

}
