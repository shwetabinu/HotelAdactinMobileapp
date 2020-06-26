package com.adactin.Mobileapphoteladactin1.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Hotel_Details;
import com.adactin.Mobileapphoteladactin1.pages.Booked_Itinerary;
import com.adactin.Mobileapphoteladactin1.pages.Login;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * Test case to view the booked itinerary 
 * It also validates the entry present within the booked itinerary with the Testdata file details
 * 
 *
 */
public class ViewItineraryVerification  extends BaseClass{

	public ViewItineraryVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	static Login lp;
	static Booked_Itinerary bi;
	static Booked_Hotel_Details bhd;
	
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_view_itinerary() throws Exception
	{
		Log.startTestCase("User_is_able_to_view_itinerary");
		int rno;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_view_itinerary");
		initApp(rno);
		lp=new Login();
		lp.login(rno);
		bi=new Booked_Itinerary();
		String bhd_id;
		bhd_id=bi.readWhichEntry(rno);
		bi.viewBookedHotelDetails();
		bhd=new Booked_Hotel_Details();
		int count=bhd.checkBookedHotelDetails(rno, bhd.readOrderId(rno));
		Assert.assertEquals(count,6);
		Log.endTestCase("User_is_able_to_view_itinerary");
	}

}
