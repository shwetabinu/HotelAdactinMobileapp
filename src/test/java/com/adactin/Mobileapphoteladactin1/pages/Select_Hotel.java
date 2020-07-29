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
import com.adactin.Mobileapphoteladactin1.util.ScreenshotCapture;

public class Select_Hotel extends BaseClass {

	ScreenshotCapture screen;
	public Select_Hotel() throws Exception {

	
		PageFactory.initElements(driver, this);
		screen=new ScreenshotCapture();
		// TODO Auto-generated constructor stub
	}

	//Hotel list
	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
	List<WebElement> hotel_list;
	
	String expected_hotel;
	String expectedlist;
	String[] expected_hotelslist = new String[100];

	/**
	 * Method to check the number of entries in the Select Hotel page
	 * 
	 * @return
	 */
	public int checkNumberOfEntries() {
		int tot_number = 0;
		// Determines the size of the hotel entry list
		tot_number = hotel_list.size();
		
		return tot_number;
	}

	/**
	 * Method to click on a specific element in the Select Hotel page
	 * 
	 * @param i The row where hotel to be selected is present in the test data file
	 */
	public boolean select_hotel(int rno,int hotel) {
		boolean result = true;
		try {
			// Reads the hotel to be selected from the test data file
			int hotel_index = ExcelUtil.readExcel('c', "Hotels");
			expected_hotel = ExcelUtil.getCellData(rno, hotel_index);
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfAllElements(hotel_list));
			screen.takeScreenshot("Select Hotel page");
			hotel_list.get(hotel).click();
				
		} catch (Exception e) {
			// Prints error message in case of exception
			e.printStackTrace();
			Log.error("Error occurred while selecting hotel");
			result = false;
			
		}
		return result;
	}

	/**
	 * Method to read the hotel names displayed when searching with just location
	 * The method verifies that list item is present for each type of hotel and
	 * checks if the total no: of list item is 4
	 * 
	 * @param i
	 * @return
	 */
	public boolean readHotelName(int i) {
		boolean result = true;
		try {
			// Creating list of expected hotels and assigning values to it			
			int hotellist_index = ExcelUtil.readExcel('c', "Hotel List");
			expectedlist = ExcelUtil.getCellData(i, hotellist_index);
			expected_hotelslist = expectedlist.split(",");
			// Checks if all the expected hotels are present and if the total size 		
			if (expected_hotelslist.length == hotel_list.size())
				result = true;
			else
				result = false;

		} catch (Exception e) {
			// Prints error message in case of exception
			e.printStackTrace();
			Log.error("Error occurred while selecting hotel");
			result = false;
		}
		return result;

	}
}
