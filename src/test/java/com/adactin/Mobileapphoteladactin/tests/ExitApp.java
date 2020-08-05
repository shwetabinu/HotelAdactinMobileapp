package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

/**
 * Testcase to verify if user can exit the app
 * @author shwetabinu
 *
 */
public class ExitApp extends BaseClass{

	public ExitApp() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Login lp;
	
	/**
	 * Test case to check if a user can login to the application with invalid user
	 * id and password
	 * It validates the error message which pops up
	 *
	 *@throws Exception Exception during test execution
	 */
	@Test(groups = { "sfunctionalTest" })
	public void User_is_able_to_exit_the_application_when_he_clicks_on_the_back_button_of_the_phone() throws Exception
	{
		Log.startTestCase("User_is_able_to_exit_the_application_when_he_clicks_on_the_back_button_of_the_phone");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_exit_the_application_when_he_clicks_on_the_back_button_of_the_phone");
		Log.info("Initializing the app..");
		
		//Initializing the application
		initApp(rno);
		
		//Logging into the application
		driver.navigate().back();
		
			ExcelUtil.setCellData("PASSED", rno, 0);
	
		Log.endTestCase("User_is_able_to_exit_the_application_when_he_clicks_on_the_back_button_of_the_phone");		
	}
	

}

