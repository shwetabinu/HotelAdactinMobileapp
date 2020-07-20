package com.adactin.Mobileapphoteladactin1.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

public class Selected_Hotel_Detail extends BaseClass {

	public Selected_Hotel_Detail() throws Exception {
		// super();
		PageFactory.initElements(driver, this);
	}

	// hotel name
	@FindBy(xpath = "(//android.view.View[2]/android.view.View)[2]")
	WebElement hotel_name;

	// location
	@FindBy(xpath = "//android.view.View[4]/android.view.View")
	WebElement location;

	// rooms
	@FindBy(xpath = "//android.view.View[6]/android.view.View")
	WebElement room_no;

	// arrival date
	@FindBy(xpath = "//android.view.View[8]/android.view.View")
	WebElement arrival_date;

	// departure date
	@FindBy(xpath = "//android.view.View[10]/android.view.View")
	WebElement depart_date;

	// No: of days
	@FindBy(xpath = "//android.view.View[12]/android.view.View")
	WebElement day_no;

	// Rooms type
	@FindBy(xpath = "//android.view.View[14]/android.view.View")
	WebElement rooms_type;

	// Price per Night
	@FindBy(xpath = "//android.view.View[16]/android.view.View")
	WebElement price_night;

	// Total price
	@FindBy(xpath = "//android.view.View[18]/android.view.View")
	WebElement tot_price;

	// Select button
	@FindBy(xpath = "//android.widget.Button[@text='Select']")
	WebElement select_btn;

	// Go back button
	@FindBy(xpath = "//android.widget.Button[@text='Back']")
	WebElement go_back;

	int count = 0;
	public static String expected_hotel, expected_location, room_nu, arr_date, dep_dat, dayno, room_ty;
	public static String ppn;
	public static String acttotal_price;
	public static int tot_pri;
	public static int dayNo;

	/**
	 * Method to click on the select button
	 */
	public boolean click_on_select() {
		boolean result = true;
		try {
			select_btn.click();
		} catch (Exception e) {
			Log.error("Error occured while selecting the hotel");
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/**
	 * Method to calculate the total days between arrival and departure date if they
	 * are in the same month
	 * 
	 * @param rno Row number where the test case is present
	 */
	public boolean dayNoCalculate(int rno) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		boolean result=true;
		try {
		// Splitting the arrival date to extract the day,month and year
		String a_date[] = arr_date.split("/");
		int a_day = Integer.parseInt(a_date[0]);
		int a_month = Integer.parseInt(a_date[1]);
		int a_year = Integer.parseInt(a_date[2]);

		// Splitting the departure date to extract the day,month and year
		String d_date[] = dep_dat.split("/");
		int d_day = Integer.parseInt(d_date[0]);
		int d_month = Integer.parseInt(d_date[1]);
		int d_year = Integer.parseInt(d_date[2]);

		// Calculating the total days by subtracting the date
		if (a_month == d_month && a_year == d_year)
			dayNo = d_day - a_day;
		Log.info("The day number is"+dayNo);

		}catch(Exception e)
		{
			Log.error("Error occurred during day calculation");
			result=false;
		}
		return result;
	}

	/**
	 * Method to calculate the price per night and the total price for different
	 * hotels and different room types
	 * 
	 * @param rno
	 */
	public boolean priceCalculation(int rno) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		boolean result = true;
		// Calculating the price per night for Standard room type
		try {
			if (room_ty.equalsIgnoreCase("Standard")) {
				if (expected_hotel.equalsIgnoreCase("Hotel Creek"))
					ppn = "AUD $100";
				if (expected_hotel.equalsIgnoreCase("Hotel Sunshine"))
					ppn = "AUD $125";
				if (expected_hotel.equalsIgnoreCase("Hotel Hervey"))
					ppn = "AUD $150";
				if (expected_hotel.equalsIgnoreCase("Hotel Cornice"))
					ppn = "AUD $175";
			}

			// Calculating the price per night for Double room type
			if (room_ty.equalsIgnoreCase("Double")) {
				if (expected_hotel.equalsIgnoreCase("Hotel Creek"))
					ppn = "AUD $200";
				if (expected_hotel.equalsIgnoreCase("Hotel Sunshine"))
					ppn = "AUD $225";
				if (expected_hotel.equalsIgnoreCase("Hotel Hervey"))
					ppn = "AUD $250";
				if (expected_hotel.equalsIgnoreCase("Hotel Cornice"))
					ppn = "AUD $275";
			}

			// Calculating the price per night for Deluxe room type
			if (room_ty.equalsIgnoreCase("Deluxe")) {
				if (expected_hotel.equalsIgnoreCase("Hotel Creek"))
					ppn = "AUD $300";
				if (expected_hotel.equalsIgnoreCase("Hotel Sunshine"))
					ppn = "AUD $325";
				if (expected_hotel.equalsIgnoreCase("Hotel Hervey"))
					ppn = "AUD $350";
				if (expected_hotel.equalsIgnoreCase("Hotel Cornice"))
					ppn = "AUD $375";
			}

			// Calculating the price per night for Super Deluxe room type
			if (room_ty.equalsIgnoreCase("Super Deluxe")) {
				if (expected_hotel.equalsIgnoreCase("Hotel Creek"))
					ppn = "AUD $400";
				if (expected_hotel.equalsIgnoreCase("Hotel Sunshine"))
					ppn = "AUD $425";
				if (expected_hotel.equalsIgnoreCase("Hotel Hervey"))
					ppn = "AUD $450";
				if (expected_hotel.equalsIgnoreCase("Hotel Cornice"))
					ppn = "AUD $475";
			}

			// Extracting the price alone from the price per night
			String modified_ppn = ppn.substring(5);

			// Calculating the total price with the formula
			tot_pri = (Integer.parseInt(modified_ppn)) * dayNo + 10;
			String total = Integer.toString(tot_pri);
			acttotal_price = "AUD $";

			// Formatting the total price with the currency type
			acttotal_price = acttotal_price.concat(total);
			Log.info("Total price" + acttotal_price);
		} catch (Exception e) {
			Log.error("Error occurred during price calculation");
			result = false;
		}

		return result;
	}

	public void readExpectedData(int rno) {

		try {

			// Reading the expected data for Select hotel detail page from the Test data
			// file
			int hotelindex = ExcelUtil.readExcel('c', "Hotels");
			expected_hotel = ExcelUtil.getCellData(rno, hotelindex);
			Log.info("Expected hotel is" + expected_hotel);
			int location_index = ExcelUtil.readExcel('c', "Location");
			expected_location = ExcelUtil.getCellData(rno, location_index);
			int room_no = ExcelUtil.readExcel('c', "Number of Rooms");
			room_nu = ExcelUtil.getCellData(rno, room_no);
			int arrdate_index = ExcelUtil.readExcel('c', "Check-in Date");
			arr_date = ExcelUtil.getCellData(rno, arrdate_index);
			int dep_index = ExcelUtil.readExcel('c', "Check-out Date");
			dep_dat = ExcelUtil.getCellData(rno, dep_index);
			int rtype_index = ExcelUtil.readExcel('c', "Room Type");
			room_ty = ExcelUtil.getCellData(rno, rtype_index);

		} catch (Exception e) {
			Log.error("Error occurred while reading expected data from the test data file");
		}

	}

	/**
	 * Method to check if the correct details are entered for each room type
	 * 
	 * @param i        row number
	 * @param roomtype
	 * @return
	 * @throws Exception
	 */
	public boolean validateDetails() throws Exception {

		boolean result = true;
		try {
			
			//Validating the location in the Selected hotel details page
			if (location.getText().equalsIgnoreCase(expected_location)) {
				Log.info(location.getText());
				++count;
				Log.info("Checking count" + count);
			}

			//Validating the hotel name in the Selected hotel details page
			if (hotel_name.getText().equalsIgnoreCase(expected_hotel)) {
				Log.info(hotel_name.getText());
				++count;
				Log.info("Checking count" + count);
			}

			//Validating the room number in the Selected hotel details page
			if (room_no.getText().equalsIgnoreCase(room_nu)) {
				Log.info(room_no.getText());
				++count;
				Log.info("Checking count" + count);
			}

			//Validating the arrival date in the Selected hotel details page
			if (arrival_date.getText().equalsIgnoreCase(arr_date)) {
				Log.info(arrival_date.getText());
				++count;
				Log.info("Checking count" + count);
			}
			
			//Validating the departure date in the Selected hotel details page
			if (depart_date.getText().equalsIgnoreCase(dep_dat)) {
				Log.info(depart_date.getText());
				++count;
				Log.info("Checking count" + count);
			}

			//Validating the number of days in the Selected hotel details page
			if (Integer.parseInt(day_no.getText()) == dayNo) {
				Log.info(day_no.getText());
				++count;
				Log.info("Checking count" + count);
			}

			//Validating the room type in the Selected hotel details page
			if (rooms_type.getText().equalsIgnoreCase(room_ty)) {
				Log.info(rooms_type.getText());
				++count;
				Log.info("Checking count" + count);
			}
			
			//Validating the price per night in the Selected hotel details page
			if (price_night.getText().equalsIgnoreCase(ppn)) {
				Log.info(price_night.getText());
				++count;
				Log.info("Checking count" + count);
			}
			
			//Validating the total price in the Selected hotel details page
			if (tot_price.getText().equalsIgnoreCase(acttotal_price)) {
				Log.info(tot_price.getText());
				++count;
				Log.info("Checking count" + count);
			}

			if (count == 9)
				result = true;
			else
				result = false;
		} catch (Exception e) {
			Log.error("Error occurred while validating the data in the select hotel page");
			result = false;
		}
		return result;
	}

	/**
	 * Method to go back to the previous page
	 */
	public void goback() {
		go_back.click();
	}
}
