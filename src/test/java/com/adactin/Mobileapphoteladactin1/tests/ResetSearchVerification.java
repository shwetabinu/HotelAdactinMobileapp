package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.aventstack.extentreports.Status;

import reportgeneration.ExtentTestManager;

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
		boolean login_result=lp.login(rno);
		if(login_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
		
		Assert.assertTrue(login_result);
		
		hp=new Home();
		boolean searchhotel=hp.searchHotel(rno);
		if(searchhotel==true)
			ExtentTestManager.getTest().log(Status.PASS,"The search hotel field entry was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The search hotel field entry was unsuccessful");	
	
		Assert.assertTrue(searchhotel);
		
		boolean reset=hp.doReset();
		if(reset==true)
			ExtentTestManager.getTest().log(Status.PASS,"The search hotel page reset was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The search hotel page reset was unsuccessful");	
	
		Assert.assertTrue(reset);
		
		Log.endTestCase("User_is_able_to_reset_the_search_criteria");
		


	}
}
