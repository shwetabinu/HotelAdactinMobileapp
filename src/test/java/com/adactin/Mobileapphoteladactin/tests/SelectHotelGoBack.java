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
 * Test case to validate going back from select hotel page
 * @author shwetabinu
 *
 */
public class SelectHotelGoBack extends BaseClass {

	public SelectHotelGoBack() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login lp;
	Home hp;
	Select_Hotel sp;

	/**
	 * Test case to validate going back to search hotel page from the result page
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_go_back_to_the_search_hotel_home_page_by_clicking_on_the_back_arrow_link() throws Exception
	{
		Log.startTestCase("User_is_able_to_go_back_to_the_search_hotel_home_page_by_clicking_on_the_back_arrow_link");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_go_back_to_the_search_hotel_home_page_by_clicking_on_the_back_arrow_link");
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
		//Going back to the previous page
		boolean goback=sp.goBack();
		if(goback==true)
			ExtentTestManager.getTest().log(Status.PASS,"The goback validation to Search Hotel page was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The goback validation to Search Hotel page was unsuccessful");	
		Assert.assertTrue(goback);
		//Writing the test status to the Test data sheet
		if((login && search && searchclick && goback
				)==true)
			ExcelUtil.setCellData("PASSED", rno, 0);
		else
			ExcelUtil.setCellData("FAILED", rno, 0);
		
		Log.endTestCase("User_is_able_to_go_back_to_the_search_hotel_home_page_by_clicking_on_the_back_arrow_link");	
		
	}
	
}

