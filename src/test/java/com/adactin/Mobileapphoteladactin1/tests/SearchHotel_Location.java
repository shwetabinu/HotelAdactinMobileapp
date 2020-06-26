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
	
	static Login lp;
	static Home hp;
	static Select_Hotel sp,sp1;
	static Selected_Hotel_Detail shd;

	@Test(groups = { "functionalTest" })
	public void User_is_able_to_Search_Hotel_with_Location() throws Exception
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
		hp.searchHotel_Location_only(rno);
		hp.clickOnSearch();
		sp=new Select_Hotel();
		n=sp.checkNumberOfEntries();
		sp.select_hotel(1);
		shd=new Selected_Hotel_Detail();
		String[] hoteltype= shd.getHotelNames(rno);
		for(int i=0;i<hoteltype.length;i++)
		{
			Log.info(hoteltype[i]);
			count=shd.check_If_correct_details_hotel(rno, hoteltype[i]);
			Log.info("Count for each is"+count);
			shd.goback();
			if(i<3)
			{sp1=new Select_Hotel();
			sp1.select_hotel(i+2);
			}

		}
		//Log.info("Count is"+count);
		Log.info("n is"+n);
		Assert.assertTrue(count==12 && n==4);
		Log.endTestCase("User_is_able_to_Search_Hotel_with_Location");
		
	}
	
}
