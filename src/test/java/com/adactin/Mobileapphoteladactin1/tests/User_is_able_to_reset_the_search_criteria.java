package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

public class User_is_able_to_reset_the_search_criteria extends BaseClass {

	public User_is_able_to_reset_the_search_criteria() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	static Login lp;
	static Home hp;
	
	@Test
	public void User_is_able_to_reset_the_search_criteria() throws Exception
	{
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_able_to_reset_the_search_criteria");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		hp=new Home();
		hp.searchHotel(rno);
		hp.doReset();
		


	}
}
