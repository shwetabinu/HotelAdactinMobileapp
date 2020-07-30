package com.adactin.Mobileapphoteladactin.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.adactin.Mobileapphoteladactin.util.ScreenshotCapture;

/**
 * This Booked Itinerary class displays all the bookings done by the user It has
 * method to click on the Booked hotel to view its details
 * 
 *
 */
public class Booked_Itinerary extends BaseClass {

	ScreenshotCapture screen;

	public Booked_Itinerary() throws Exception {
		// Initializing the page elements
		PageFactory.initElements(driver, this);
		// Initializing the object of ScreenshotCapture class
		screen = new ScreenshotCapture();
	}

	// Hotel list items
	@FindBy(xpath = "//android.view.View[contains(@text,'hotel_name')]")
	List<WebElement> hotel_listitems;

	public int hotel_list_size, hotel_size;
	int new_hotellist_size;

	/**
	 * Method to calculate the total number of hotels in the list
	 * 
	 * @param rno Row number of test case
	 * @throws Exception Exception while taking screenshot
	 */
	public void calcHotelSize(int rno) throws Exception {
		// Calculating the total hotel list size
		hotel_list_size = hotel_listitems.size();
		// Taking screenshot
		screen.takeScreenshot("Booked itinerary in the beginning");
		Log.info("The hotels in the list is" + hotel_list_size);
	}

	/**
	 * Method to read which entry of the booked itinerary
	 * 
	 * @param rno Row number of the test case
	 * @return boolean result of execution
	 * 
	 */
	public boolean viewBookedHotel(int rno) {
		boolean result = true;
		try {

			// Reading the index of the booked hotel
			int index = ExcelUtil.readExcel('c', "Booked Itinerary id");
			String entry_no = ExcelUtil.getCellData(rno, index);
			int entryno = Integer.parseInt(entry_no);

			// Explicitly waiting for all elements to be loaded
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(hotel_listitems));

			// Taking screenshot
			screen.takeScreenshot("Booked Itinerary details");
			// Selecting the booked hotel
			hotel_listitems.get(entryno).click();

			// Log.info("The number of hotels in this list is"+hotel_list_size);

			// If no entries are present, returning false
			if (hotel_listitems.size() == 0)
				result = false;

		} catch (Exception r) {
			result = false;
			r.printStackTrace();
			Log.error("Exception occurred while reading entry");
		}
		return result;
	}

	/**
	 * Method to check if the hotel is cancelled by verifying the number of hotel
	 * list items
	 * 
	 * @throws IOException while taking screenshot
	 * @return boolean result of the method
	 */
	public boolean checkCanceled() throws IOException {
		// Explicitly waiting for all the hotel list items to be visible
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(hotel_listitems));
		// Taking screenshot for cancelation
		screen.takeScreenshot("Checking cancelation");
		// Determining the size of the hotel list
		new_hotellist_size = hotel_listitems.size();
		Log.info("The modified hotel list is" + new_hotellist_size);
		Log.info("The previous size is" + hotel_list_size);
		// Comparing the previous and new size of the list
		if (new_hotellist_size == hotel_list_size - 1)
			return true;
		else
			return false;
	}

	/**
	 * Method to check if a hotel is booked by comparing the number of hotels in the
	 * hotel list
	 * 
	 * @return boolean result of the method
	 * @throws IOException Exception whilt taking screenshot
	 */
	public boolean checkBooked() throws IOException {
		Log.info("Entering method to check if booked");
		// Explicitly waiting for all the hotel list items to be visible
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(hotel_listitems));
		// Taking screenshot
		screen.takeScreenshot("Checking booked");
		// Determining the size of the hotel list
		new_hotellist_size = hotel_listitems.size();
		Log.info("The modified hotel list is" + new_hotellist_size);
		Log.info("The previous size is" + hotel_list_size);
		// Comparing the previous and new size of the list
		if (new_hotellist_size == hotel_list_size + 1)
			return true;
		else
			return false;
	}
}
