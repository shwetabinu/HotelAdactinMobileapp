package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.adactin.Mobileapphoteladactin1.util.ScreenshotCapture;
import com.adactin.Mobileapphoteladactin1.util.ScrollUtil;

public class Booked_Hotel_Details extends BaseClass {

	ScreenshotCapture screen;
	public Booked_Hotel_Details() throws Exception {
		PageFactory.initElements(driver, this);
		screen=new ScreenshotCapture();
		
	}
	
	//Page xpath
	String scrollpage="//android.view.View[2]/android.widget.ScrollView";
	
	// order id web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[2]/android.view.View")
	WebElement ord_id;

	// hotel name web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[4]/android.view.View")
	WebElement hotelname;

	// location web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[6]/android.view.View")
	WebElement location;

	// no: of rooms web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[8]/android.view.View")
	WebElement no_rooms;

	// first name web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[10]/android.view.View")
	WebElement fname;

	// last name web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[12]/android.view.View")
	WebElement lname;

	// arrival date web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[14]/android.view.View")
	WebElement arr_date;

	// departure date web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[16]/android.view.View")
	WebElement dep_date;

	// number of days web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[18]/android.view.View")
	WebElement no_days;

	// scrolldown after this

	// rooms type web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[20]/android.view.View")
	WebElement rooms_type;

	// price per night web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[22]/android.view.View")
	WebElement pricenight;

	// total price web element
	@FindBy(xpath = "//android.view.View[2]/android.widget.ScrollView/android.view.View[19]/android.view.View")
	WebElement tot_price;

	// cancel button web element
	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	WebElement cancel_btn;

	// back button web element
	@FindBy(xpath = "//android.widget.Button[@text='Back']")
	WebElement back_btn;

	// cancel alert web alement
	@FindBy(xpath = "//android.view.View[@text='Cancel']")
	WebElement alert_cancel;

	// ok alert web element
	@FindBy(xpath = "//android.view.View[@text='OK']")
	WebElement alert_ok;

	String expected_location, expected_hotel, expected_fname, expected_lname, expected_roomtype, expected_nofrooms;
	String expected_orderid, expected_roomno, expected_arrdate, expected_depdate, expected_dayno, expected_ppn,
			expected_tp;

	/**
	 * Method to cancel the Booked itinerary Navigates to the booked itinerary list,
	 * clicks on a list item and clicks the cancel button Clicks on the success
	 * alert button when prompt pops up
	 */
	public boolean cancelBooked_itinerary() {
		boolean result = true;

		try {
			// Clicking on cancel button at the bottom of the page
			cancel_btn.click();
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(alert_ok));
			screen.takeScreenshot("Cancel Alert popup");
			// Clicking on 'Ok' in the alert popup displayed
			alert_ok.click();
			// Clicking on Ok again in the success popup
			alert_ok.click();
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occured while canceling the booking");
			result = false;
		}
		return result;
	}

	/**
	 * Method to read the expected data to match the booked hotel details page
	 * 
	 * @param rno row number where the test case is present
	 * @return result of the method execution
	 */
	public boolean readExpectedData(int rno) {
		boolean result = true;
		try {

			// Reading the expected order id from the Test data file
			int orderid_index = ExcelUtil.readExcel('c', "order id");
			expected_orderid = ExcelUtil.getCellData(rno, orderid_index);

			// Reading the expected hotel from the test data file
			int hotel_index = ExcelUtil.readExcel('c', "Hotels");
			expected_hotel = ExcelUtil.getCellData(rno, hotel_index);

			// Reading the location from the test data file
			int location_index = ExcelUtil.readExcel('c', "Location");
			expected_location = ExcelUtil.getCellData(rno, location_index);

			// Reading the room no from the test data file
			int roomno_index = ExcelUtil.readExcel('c', "Number of Rooms");
			expected_roomno = ExcelUtil.getCellData(rno, roomno_index);

			// Reading the first name from the test data file
			int fname_index = ExcelUtil.readExcel('c', "First Name");
			expected_fname = ExcelUtil.getCellData(rno, fname_index);

			// Reading the last name from the test data file
			int lname_index = ExcelUtil.readExcel('c', "Last Name");
			expected_lname = ExcelUtil.getCellData(rno, lname_index);

			// Reading the arrival date from the test data file
			int arrivaldate_index = ExcelUtil.readExcel('c', "Check-in Date");
			expected_arrdate = ExcelUtil.getCellData(rno, arrivaldate_index);

			// Reading the departure date from the test data file
			int depdate_index = ExcelUtil.readExcel('c', "Check-out Date");
			expected_depdate = ExcelUtil.getCellData(rno, depdate_index);

			// Reading the no. of days from the test data file
			int dayno_index = ExcelUtil.readExcel('c', "No. Of Days");
			expected_dayno = ExcelUtil.getCellData(rno, dayno_index);

			// Reading the price per night from the test data file
			int ppn_index = ExcelUtil.readExcel('c', "Price Per Night");
			expected_ppn = ExcelUtil.getCellData(rno, ppn_index);

			// Reading the total price from the test data file//
			int tp_index = ExcelUtil.readExcel('c', "Total Price");
			expected_tp = ExcelUtil.getCellData(rno, tp_index);

			// Reading the room type from the test data file//
			int roomtype_index = ExcelUtil.readExcel('c', "Room Type");
			expected_roomtype = ExcelUtil.getCellData(rno, roomtype_index);

		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occurred while reading expected data");
			result = false;
		}
		return result;
	}

	/**
	 * 
	 * Validates if the Booked Hotel Details are as per the data in the test data
	 * sheet
	 * 
	 * @param i   Row number
	 * @param oid Order ID
	 * @return
	 * @throws Exception
	 */
	public boolean checkBookedHotelDetails(int i) throws Exception {

		boolean result = true;
		String oid;
		try {
			int count = 0;
			if (Booking_Confirmation.order_id == null)
				oid = expected_orderid;
			else
				oid=Booking_Confirmation.order_id;

			//Comparing the expected and actual order id and incrementing the count if they match
			Log.info("The order id in booking confirmation page"+ oid);
			Log.info("The order id in the hotel details page" + ord_id.getText());
			if (ord_id.getText().equalsIgnoreCase(oid))
				count++;

			//Comparing the expected and actual hotel name and incrementing the count if they match
			Log.info("The hotel name inputted" + expected_hotel);
			Log.info("The hotel name in the hotel details page" + hotelname.getText());
			if (hotelname.getText().equalsIgnoreCase(expected_hotel))
				count++;

			//Comparing the expected and actual location and incrementing the count if they match
			Log.info("The location name inputted" + expected_location);
			Log.info("The location name in the hotel details page" + location.getText());
			if (location.getText().equalsIgnoreCase(expected_location))
				count++;

			Log.info("Expected room number"+expected_roomno);
			Log.info("Actual room number"+no_rooms.getText());
			//Comparing the expected and actual number of rooms and incrementing the count if they match
			if (expected_roomno.contains(no_rooms.getText()))
				{
				Log.info("Expected room number"+expected_roomno);
				Log.info("Actual room number"+no_rooms.getText());
				count++;
				}

			//Comparing the expected and actual first name and incrementing the count if they match
			Log.info("The first name inputted" + expected_fname);
			Log.info("The first name in the hotel details page" + fname.getText());
			if (fname.getText().equalsIgnoreCase(expected_fname))
				count++;

			//Comparing the expected and actual last name and incrementing the count if they match
			Log.info("The last name inputted" + expected_lname);
			Log.info("The first name in the hotel details page" + lname.getText());
			if (lname.getText().equalsIgnoreCase(expected_lname))
				count++;

			//Comparing the expected and actual arrival date and incrementing the count if they match
			if (arr_date.getText().equalsIgnoreCase(expected_arrdate))
				{
				Log.info("Expected arrival date"+expected_arrdate);
				Log.info("Actual arrival date"+arr_date.getText());count++;
				}
			
			//Comparing the expected and actual departure date and incrementing the count if they match
			if (dep_date.getText().equalsIgnoreCase(expected_depdate))
				{
				Log.info("Expected dep date"+expected_depdate);
				Log.info("Actual dep date"+dep_date.getText());
				count++;
				}

			//Comparing the expected and actual number of days and incrementing the count if they match
			if (no_days.getText().equalsIgnoreCase(expected_dayno))
				{
				Log.info("Expected day number"+expected_dayno);
				Log.info("Actual day number"+no_days.getText());count++;
				}
			
			//Comparing the expected and actual room type and incrementing the count if they match
			Log.info("The room type inputted" + expected_roomtype);
			Log.info("The room type in the hotel details page" + rooms_type.getText());
			if (rooms_type.getText().equalsIgnoreCase(expected_roomtype))
				count++;

			//Comparing the expected and actual price per night and incrementing the count if they match
			if(expected_ppn.isEmpty())
				{
				Log.info("The price per night inputted"+Selected_Hotel_Detail.ppn);
				Log.info("The price per night in the hotel details page" + pricenight.getText());
				if (pricenight.getText().equalsIgnoreCase(Selected_Hotel_Detail.ppn))
					count++;
				}
			
			else	
				{Log.info("The price per night inputted" + expected_ppn);
				Log.info("The price per night in the hotel details page" + pricenight.getText());
				if (pricenight.getText().equalsIgnoreCase(expected_ppn))
					count++;
				}
			
			
			screen.takeScreenshot("Booked hotel details_1");
			//Scrolling to the total price element
			//driver.lockDevice();
			//ScrollUtil.pageScrollEnd();
			ScrollUtil.pageScroll("Total Price (incl. GST)",scrollpage);
			if(expected_tp.isEmpty())
			{
				Log.info("The total price inputted" + Selected_Hotel_Detail.acttotal_price);
				if (tot_price.getText().equalsIgnoreCase(Selected_Hotel_Detail.acttotal_price))
					count++;
			}
			else
				{
				Log.info("The total price inputted" + expected_tp);
				Log.info("The total price in the hotel details page" + tot_price.getText());
				 if (tot_price.getText().equalsIgnoreCase(expected_tp))
						count++;
				}
			
			screen.takeScreenshot("Booked hotel details_2");
			//Comparing the expected and actual total price and incrementing the count if they match
			
			Log.info("The total count is"+count);
			if (count == 12)
				result = true;
			else
				result = false;
		} catch (Exception e) {
			Log.error("Error occured while validating the details");
			e.printStackTrace();
			result = false;
		}
		return result;

	}
	
	public boolean goBack()
	{
		boolean result=true;
		try {
			back_btn.click();
		}catch(Exception e)
		{
			result=false;
			e.printStackTrace();
			Log.error("Error occurred while going back");
		}
		return result;
	}
	/**
	 * Method to validate the order id
	 * @param ordid Order ID
	 * @return true if valid, false otherwise
	 */
	public boolean validateOrderID(String ordid) {

		if (ord_id.getText().equalsIgnoreCase(ordid))
			return true;
		else
			return false;
	}

}
