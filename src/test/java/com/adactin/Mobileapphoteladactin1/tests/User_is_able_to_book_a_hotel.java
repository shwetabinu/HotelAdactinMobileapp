package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

public class User_is_able_to_book_a_hotel extends BaseClass{
	
	public User_is_able_to_book_a_hotel() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Home hp;
	static Login lp;
	
	@Test
	public void User_is_able_to_book_a_hotel() throws Exception
	{
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_able_to_book_a_hotel");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		hp=new Home();
		hp.searchHotel(rno);
		
	}

}
