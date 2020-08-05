package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Home;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

/**
 * Test case to validate adults per room drop down in Search Hotel page
 * @author shwetabinu
 *
 */
public class AdultsPerRoomVerification extends BaseClass{
	
	

	public AdultsPerRoomVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login lp;
	Home hp;
	Select_Hotel sp;

	/**
	 * Test case to validate adults per room dropdown in Search Hotel page
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_view_the_list_in_the_Adults_per_Room_drop_down_menu() throws Exception
	{
		Log.startTestCase("User_is_able_to_view_the_list_in_the_Adults_per_Room_drop_down_menu");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_view_the_list_in_the_Adults_per_Room_drop_down_menu");
		
		Log.info("Initializing the app..");
		
		//Initializing the application
		initApp(rno);
		
		//Creating an object of login page
		lp=new Login();
		Log.info("Logging in...");
		
		//Logging into the application and verifying
		boolean login=lp.login(rno);
		//Logging to the report
		if(login==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
		Assert.assertTrue(login);
		
		hp=new Home();
		//Verifying the adults per room drop down items
		boolean apr=hp.validateAdultsPerRoom(rno);
		
		
		//Logging to the report
		if(apr==true)
			ExtentTestManager.getTest().log(Status.PASS,"The adults per room was selected");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The adults per room selection was unsuccessful");	
		
		Assert.assertTrue(apr);
		
		if((login && apr)==true)
			ExcelUtil.setCellData("PASSED", rno, 0);
		else
			ExcelUtil.setCellData("FAILED", rno, 0);
		
		Log.endTestCase("User_is_able_to_view_the_list_in_the_Adults_per_Room_drop_down_menu");	
		
	}
	
}
