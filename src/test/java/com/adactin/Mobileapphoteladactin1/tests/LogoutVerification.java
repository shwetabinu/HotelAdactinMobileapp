package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.pages.My_Account;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * Test case to verify if user can logout successfully.
 * The presence and enablement of login button is checked after successful logout
 */
public class LogoutVerification extends BaseClass{

	public LogoutVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp,lp1;
	static My_Account acc;

	@Test(groups = { "functionalTest" })
	public void User_is_able_to_logout() throws Exception
	{
		Log.startTestCase("User_is_able_to_logout");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_logout");
		initApp(rno);
		lp=new Login();
		lp.login(rno);
		acc=new My_Account();
		acc.Logging_out();
		lp1=new Login();
		Assert.assertEquals(lp1.checkIfLoginButtonPresent(), true);
		Log.endTestCase("User_is_able_to_logout");
		
	}
	
	
}
