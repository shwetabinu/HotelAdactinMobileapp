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

/**
 * Test case to verify if user can search for hotel with location alone as the input
 * Here each of the hotel entry in the list is verified for hotel name
 *
 */
public class SearchHotel_Location extends BaseClass {

	public SearchHotel_Location() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login lp;
	Home hp;
	Select_Hotel sp,sp1;
	Selected_Hotel_Detail shd;

	@Test(groups = { "functionalTest" })
	public void MAHA_TC04_TC_SearchHotel_LocationTest() throws Exception
	{
		Log.startTestCase("User_is_able_to_Search_Hotel_with_Location");
		int rno,count = 0,n;
		String ordid;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_Search_Hotel_with_Location");
		initApp(rno);
		lp=new Login();
		lp.login(rno);
		hp=new Home();
		hp.searchHotel(rno);
		hp.clickOnSearch();
		sp=new Select_Hotel();
		boolean hotel_result=sp.readHotelName(rno);
		Assert.assertTrue(hotel_result);
		Log.endTestCase("User_is_able_to_Search_Hotel_with_Location");
		
	}
	
}
