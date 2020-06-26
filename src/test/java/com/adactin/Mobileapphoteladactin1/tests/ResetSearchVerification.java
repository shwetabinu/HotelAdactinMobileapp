package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * Testcase to verify if user can reset the fields in the Search Hotel page through the Reset buttoon
 * The fields in the Search Hotel page is selected. 
 * Following which reset button is clicked, then the fields are checked again to see if they are empty
 *
 */
public class ResetSearchVerification extends BaseClass {

	public ResetSearchVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	static Login lp;
	static Home hp;
	
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_reset_the_search_criteria() throws Exception
	{
		Log.startTestCase("User_is_able_to_reset_the_search_criteria");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_reset_the_search_criteria");
		initApp(rno);
		lp=new Login();
		lp.login(rno);
		hp=new Home();
		hp.searchHotel(rno);
		hp.doReset();
		Log.endTestCase("User_is_able_to_reset_the_search_criteria");
		


	}
}
