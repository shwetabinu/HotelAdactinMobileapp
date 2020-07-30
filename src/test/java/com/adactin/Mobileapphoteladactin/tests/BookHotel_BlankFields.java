package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.Book_Hotel;
import com.adactin.Mobileapphoteladactin.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin.pages.Booking_Confirmation;
import com.adactin.Mobileapphoteladactin.pages.Dashboard;
import com.adactin.Mobileapphoteladactin.pages.Home;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.pages.Select_Hotel;
import com.adactin.Mobileapphoteladactin.pages.Selected_Hotel_Detail;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;

/**
 * Test case to verify hotel booking without any input
 * @author shwetabinu
 *
 */
public class BookHotel_BlankFields extends BaseClass{
	
	public BookHotel_BlankFields() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	
	static Login lp;
	static Home hp;
	static Select_Hotel sp;
	static Selected_Hotel_Detail shd;
	static Book_Hotel bh;
	static Booking_Confirmation bc;
	static Dashboard db;
	static Booked_Itinerary bi;
	static Booked_Hotel_Details bhd;
	
	/**
	 * Test case to verify hotel booking without any input
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_view_error_Book_No_Input() throws Exception
	{
		Log.startTestCase("User_is_able_to_view_error_Book_No_Input");
		int rno;
		
		//Reading the test case row number where the data is to be read
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_view_error_Book_No_Input");
		
		//Initializing the app
		initApp(rno);
		lp=new Login();
		boolean loginresult=lp.login(rno);		
		//Logging to the report
		if(loginresult==true)
			ExtentTestManager.getTest().log(Status.PASS,"The login button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The login button click was unsuccessful");
		//Validating logging in
		Assert.assertTrue(loginresult);		
		hp=new Home();
		
		//Searching for the hotel with the test data and validating the same
		boolean searchresult=hp.searchHotel(rno);		
		//Logging to the report
		if(searchresult==true)
			ExtentTestManager.getTest().log(Status.PASS,"The search hotel page was successfully filled");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The search hotel page filling was unsuccessful");
		//Validating search result
		Assert.assertTrue(searchresult);
			
		//Validating the search for the hotel
		boolean search=hp.clickOnSearch();	
		//Logging to the report
		if(search==true)
			ExtentTestManager.getTest().log(Status.PASS,"The search button click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The search button click was unsuccessful");
		//Validating search button click
		Assert.assertTrue(search);
		
		//Validating select hotel function
		sp=new Select_Hotel();
		boolean selecthotel=sp.select_hotel(rno,0);
		//Logging to the report
		if(selecthotel==true)
			ExtentTestManager.getTest().log(Status.PASS,"The select hotel list was successfully validated");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The select hotel list validation was unsuccessful");
		//Validating selection of hotel
		Assert.assertTrue(selecthotel);
		
		//Validating selected hotel details
		shd=new Selected_Hotel_Detail();
		boolean selected_hotel=shd.click_on_select();
		//Logging to the report
		if(selected_hotel==true)
			ExtentTestManager.getTest().log(Status.PASS,"The selected hotel details was successfully validated");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The selected hotel details validation was unsuccessful");	
		//Validating select button click
		Assert.assertTrue(selected_hotel);
		
		bh=new Book_Hotel();
		//Clicking on book now button
		boolean booknow=bh.clickBookNow();
		//Logging to the report
		if(booknow==true)
			ExtentTestManager.getTest().log(Status.PASS,"The book now button was successfully validated");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The book now button validation  was unsuccessful");		
		//Validating book now button click
		Assert.assertTrue(booknow);
		
		//Validating alert popup message
		boolean verifyalert=bh.verifyAlertPopupMessage(rno);
		//Logging to the report
		if(verifyalert==true)
			ExtentTestManager.getTest().log(Status.PASS,"The alert popup message was successfully validated");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The alert popup message validation  was unsuccessful");		
		//Validating the alert message
		Assert.assertTrue(verifyalert);
		
		//Validating in-line error message
		boolean inlineerror=bh.verifyInlineError(rno);
		//Logging to the report
		if(inlineerror==true)
			ExtentTestManager.getTest().log(Status.PASS,"The inline error message was successfully validated");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The inline error message validation  was unsuccessful");		
		//Validating the inline error
		Assert.assertTrue(inlineerror);
		
		Log.endTestCase("User_is_able_to_view_error_Book_No_Input");
		
		
	}
	/**
	 * Closing app after test
	 */
	@AfterTest(groups = { "functionalTest" })
	public void closeSession()
	{
		closeApp();
	}

}
