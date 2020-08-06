package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Home;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin.pages.Selected_Hotel_Detail;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

/**
 * Test case to validate going back to the result of the search hotel screen
 * 
 * @author shwetabinu
 *
 */
public class SelectedHotelGoBack extends BaseClass {

	public SelectedHotelGoBack() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login lp;
	Home hp;
	Select_Hotel sp;
	Selected_Hotel_Detail shd;

	/**
	 * Test case to validate going back to the result of the search hotel screen
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_go_back_to_the_result_of_the_search_hotel_screen_by_clicking_the_back_arrow_button() throws Exception
	{
		Log.startTestCase("User_is_able_to_go_back_to_the_result_of_the_search_hotel_screen_by_clicking_the_back_arrow_button");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_go_back_to_the_result_of_the_search_hotel_screen_by_clicking_the_back_arrow_button");
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
		
		//Searching for the hotel with the input
		boolean search=hp.searchHotel(rno);
		//Logging to the report
		if(search==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Search hotel fields entry was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Search hotel fields entry was unsuccessful");	
		
		Assert.assertTrue(search);
		
		//Clicking on search button
		boolean searchclick=hp.clickOnSearch();
		//Logging to the report
		if(searchclick==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Search button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Search button click was unsuccessful");	
		
		Assert.assertTrue(searchclick);
		
		//Selecting the hotel
		sp=new Select_Hotel();
		boolean select=sp.select_hotel(rno, 0);
		if(select==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Search button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Search button click was unsuccessful");	
		
		Assert.assertTrue(select);
		//Going back to the previous page and validating
		shd=new Selected_Hotel_Detail();
		boolean goback=shd.goBack();
		if(goback==true)
			ExtentTestManager.getTest().log(Status.PASS,"The goback validation to Search Hotel page was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The goback validation to Search Hotel page was unsuccessful");	
		Assert.assertTrue(goback);
		//Writing to the Test Data sheet
		if((login && search && searchclick && select && goback
				)==true)
			ExcelUtil.setCellData("PASSED", rno, 0);
		else
			ExcelUtil.setCellData("FAILED", rno, 0);
		
		Log.endTestCase("User_is_able_to_go_back_to_the_result_of_the_search_hotel_screen_by_clicking_the_back_arrow_button");	
		
	}
	
}


