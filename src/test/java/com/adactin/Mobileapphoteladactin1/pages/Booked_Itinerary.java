package com.adactin.Mobileapphoteladactin1.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

/**
 * This Booked Itinerary class displays all the bookings done by the user It has
 * method to click on the Booked hotel to view its details
 * 
 *
 */
public class Booked_Itinerary extends BaseClass {

	public Booked_Itinerary() throws Exception {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.view.View[contains(@text,'hotel_name')]")
	List<WebElement> hotel_listitems;
	
	int hotel_list_size;

	/**
	 * Method to read which entry of the booked itinerary
	 * 
	 * @param rno
	 * @return
	 * @throws Exception
	 */
	public boolean viewBookedHotel(int rno) throws Exception {
		boolean result = true;
		try {
			int index = ExcelUtil.readExcel('c', "Booked Itinerary id");
			String entry_no = ExcelUtil.getCellData(rno, index);
			int entryno = Integer.parseInt(entry_no);
			hotel_listitems.get(entryno).click();
			if(hotel_listitems.size()==0)
				result=false;
			
		} catch (Exception r) {
			result = false;
			r.printStackTrace();
			Log.error("Exception occurred while reading entry");
		}
		return result;
	}

	
	

}
