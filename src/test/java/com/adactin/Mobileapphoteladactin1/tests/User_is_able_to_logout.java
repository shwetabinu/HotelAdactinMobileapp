package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.pages.My_Account;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

public class User_is_able_to_logout extends BaseClass{

	public User_is_able_to_logout() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp,lp1;
	static My_Account acc;

	@Test
	public void User_is_able_to_logout() throws Exception
	{
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_able_to_book_a_hotel");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		acc=new My_Account();
		//Log.info(driver.getTitle());
		//method to click on my account tab
		acc.Logging_out();
		lp1=new Login();
		lp1.checkIfLoginButtonPresent();
		
	}
	
	
}
