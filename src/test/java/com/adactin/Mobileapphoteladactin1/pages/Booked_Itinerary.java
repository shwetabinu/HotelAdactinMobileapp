package com.adactin.Mobileapphoteladactin1.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	//Hotel list items
	@FindBy(xpath = "//android.view.View[contains(@text,'hotel_name')]")
	List<WebElement> hotel_listitems;
	
	public int hotel_list_size,hotel_size;
	int new_hotellist_size;

	
	
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
			hotel_list_size=hotel_listitems.size();
			int index = ExcelUtil.readExcel('c', "Booked Itinerary id");
			String entry_no = ExcelUtil.getCellData(rno, index);
			int entryno = Integer.parseInt(entry_no);
			hotel_listitems.get(entryno).click();
			
			Log.info("The number of hotels in this list is"+hotel_list_size);
			if(hotel_listitems.size()==0)
				result=false;
			
		} catch (Exception r) {
			result = false;
			r.printStackTrace();
			Log.error("Exception occurred while reading entry");
		}
		return result;
	}
	
	
	/**
	 * Method to check if the hotel is cancelled by verifying the number of hotel list items
	 */
	public boolean checkCanceled()
	{
		//Explicitly waiting for all the hotel list items to be visible
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(hotel_listitems));
		//Determining the size of the hotel list
		new_hotellist_size=hotel_listitems.size();
		Log.info("The modified hotel list is"+new_hotellist_size);
		Log.info("The previous size is"+hotel_list_size);
		//Comparing the previous and new size of the list
		if(new_hotellist_size==hotel_list_size-1)
			return true;
		else
			return false;
	}

}
