package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

public class SearchHotel_AllFields extends BaseClass {
	
	public SearchHotel_AllFields() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Login lp;
	Home hp;
	
	@Test
	public void MAHA_TC03_TC_SearchHotel_AllFieldsTest() throws Exception {
		Log.startTestCase("User_is_able_to_Search_Hotel");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_Search_Hotel");
		Log.info("Initializing the app..");
		
		//Initializing the application
		initApp(rno);
		
		//Creating an object of login page
		lp=new Login();
		Log.info("Logging in...");
		
		//Logging into the application and verifying
		boolean login=lp.login(rno);
		Assert.assertTrue(login);
		
		hp=new Home();
		
		//Searching for the hotel with the input
		boolean search=hp.searchHotel(rno);
		Assert.assertTrue(search);
		
		//Clicking on search button
		boolean searchclick=hp.clickOnSearch();
		Assert.assertTrue(searchclick);
		
		
		Log.endTestCase("User_is_able_to_Search_Hotel");	
		
		
	}

}
