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

public class User_is_able_to_search_hotel_with_location_and_hotelname extends BaseClass{

	static Login lp;
	static Home hp;
	static Select_Hotel sp,sp1;
	static Selected_Hotel_Detail shd;

	public User_is_able_to_search_hotel_with_location_and_hotelname() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void User_is_able_to_search_hotel_with_location_and_hotelname() throws Exception
	{
		int rno,count = 0,n;

		//String[] roomtype= {"Standard","Double","Deluxe","Super Deluxe"};

		String ordid;
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readexcel("User_is_able_to_search_hotel_with_location_and_hotelname");
		initApp(rno);
		lp=new Login();
		lp.Logging_in(rno);
		hp=new Home();
		hp.searchHotel_Hotel_location(rno);
		sp=new Select_Hotel();
		n=sp.checkNumberOfEntries();
		sp.select_hotel(1);
		shd=new Selected_Hotel_Detail();
		String[] roomtype= shd.getRoomTypes(rno);
		for(int i=0;i<roomtype.length;i++)
		{
			Log.info(roomtype[i]);
			count=shd.check_If_correct_details_roomtype(rno, roomtype[i]);
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

	}

}
