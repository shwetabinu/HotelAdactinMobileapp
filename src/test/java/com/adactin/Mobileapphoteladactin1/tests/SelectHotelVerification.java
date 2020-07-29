package com.adactin.Mobileapphoteladactin1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Home;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin1.pages.Selected_Hotel_Detail;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.aventstack.extentreports.Status;

import reportgeneration.ExtentTestManager;

public class SelectHotelVerification extends BaseClass{

	public SelectHotelVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Login lp;
	static Home hp;
	static Select_Hotel sp;
	static Selected_Hotel_Detail shd;
	
	/**
	 * Test case to verify if the user can select the hotel depending on the input data specified
	 * Validates the data in the selected hotel details page
	 * @throws Exception
	 */
	@Test
	public void User_is_able_to_select_hotel() throws Exception
	{
		Log.startTestCase("User_is_able_to_select_hotel");
		int rno;
		
		//Reading test data from the TestData file
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_select_hotel");
		Log.info("Initializing the app..");
		
		//Initializing the application
		initApp(rno);
		
		//Creating an object of login page
		lp=new Login();
		Log.info("Logging in...");
		
		//Logging into the application and verifying
		boolean login=lp.login(rno);
		if(login==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login was unsuccessful");	
		Assert.assertTrue(login);
		
		hp=new Home();
		
		//Searching for the hotel with the input
		boolean search=hp.searchHotel(rno);
		if(search==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Search hotel fields entry was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Search hotel fields entry was unsuccessful");	
		
		Assert.assertTrue(search);
		
		//Clicking on search button
		boolean searchclick=hp.clickOnSearch();
		if(searchclick==true)
			ExtentTestManager.getTest().log(Status.PASS,"The Search button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The Search button click was unsuccessful");	
		
		Assert.assertTrue(searchclick);
		
		sp=new Select_Hotel();
		
		//Selecting the first hotel displayed
		boolean select=sp.select_hotel(rno,0);
		if(select==true)
			ExtentTestManager.getTest().log(Status.PASS,"The select hotel list was successfully validated");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The select hotel list validation was unsuccessful");
		
		Assert.assertTrue(select);
		
		//Reading the expected data to be verified in the selected hotel details page
		shd=new Selected_Hotel_Detail();	
		shd.readExpectedData(rno);
		
		//Calculating the total number of days for which hotel was booked
		boolean daycalculate=shd.dayNoCalculate(rno);
		if(daycalculate==true)
			ExtentTestManager.getTest().log(Status.PASS,"The no: of days calculation was successfully validated");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The  no: of days calculation was unsuccessful");
		
		Assert.assertTrue(daycalculate);
		
		//Calculating the total price for the hotel room booked
		boolean pricecalculate=shd.priceCalculation(rno);
		if(pricecalculate==true)
			ExtentTestManager.getTest().log(Status.PASS,"The price calculation was successfully validated");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The  price calculation was unsuccessful");
		
		Assert.assertTrue(pricecalculate);
		
		//Validating the details in the hotel details page
		boolean valid_result=shd.validateDetails();
		if(valid_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The selected hotel details validation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The selected hotel details validation was unsuccessful");
		
		Assert.assertTrue(valid_result);
		
		//Selecting the hotel
		boolean select_result=shd.click_on_select();
		if(select_result==true)
			ExtentTestManager.getTest().log(Status.PASS,"The selection button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The selection button click was unsuccessful");
		
		Assert.assertTrue(select_result);
			
		Log.endTestCase("User_is_able_to_search_hotel_with_location_and_hotelname");	
		
	
	}
}
