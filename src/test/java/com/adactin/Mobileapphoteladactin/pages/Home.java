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
import com.adactin.Mobileapphoteladactin.util.ScrollUtil;

/**
 * Home page has methods to initialize the home page. It has methods to search
 * hotel
 *
 */
public class Home extends BaseClass {

	ScreenshotCapture screen;

	public Home() throws Exception {
		// Initializing the elements in the Home page
		PageFactory.initElements(driver, this);
		// Initializing an object of ScreenshotCapture class
		screen = new ScreenshotCapture();

	}

	// Welcome message
	@FindBy(xpath = "//android.view.View[1][contains(@text,'welcome')]")
	WebElement welcome_msg;

	// Search Hotel title
	@FindBy(xpath = "//android.view.View[@text='search_hotel']")
	WebElement search_hotel_title;

	// Select Location text box
	@FindBy(xpath = "//android.widget.EditText[@text='Select Location']")
	WebElement selectlocation;

	// Location drop down options
	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> location_optns;

	// Cancel button
	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	WebElement cancel_btn;

	// Select hotel text box
	@FindBy(xpath = "//android.widget.EditText[@text='Select Hotel']")
	WebElement select_hotel;

	// Hotel drop down options
	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> hotel_optns;

	// Select room type text box
	@FindBy(xpath = "//android.widget.EditText[@text='Select Room Type']")
	WebElement select_roomtype;

	// Room type drop down options
	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> roomtype_optns;

	// No: of rooms text box
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Number of Rooms')]")
	WebElement no_of_rooms;

	// Room number drop down options
	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> roomno_optns;

	// after scroll

	// Check in date
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Check-in Date')]")
	WebElement checkin_date;

	// check in date picker items
	@FindBy(xpath = "//android.widget.SeekBar")
	List<WebElement> checkin_datepicker;

	// check out date
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Check-out Date')]")
	WebElement checkout_date;

	// Check out date picker
	@FindBy(xpath = "//android.widget.SeekBar")
	List<WebElement> checkout_datepicker;

	// Cancel date option
	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	WebElement canceldate;

	// Done button in date picker
	@FindBy(xpath = "//android.widget.Button[@text='Done']")
	WebElement donedate;

	// Adults per room drop down
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Adults per Room')]")
	WebElement adults_per_room;

	// Adults per room drop down options
	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> adultsroom_optns;

	// Children per room drop down
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Children per Room')]")
	WebElement children_per_room;

	// Children per room drop down options
	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> childrensroom_optns;

	// Search button
	@FindBy(xpath = "//android.widget.Button[@text='Search']")
	WebElement search_btn;

	// Reset Button
	@FindBy(xpath = "//android.widget.Button[@text='Reset']")
	WebElement reset_btn;

	// alert box
	@FindBy(xpath = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
	List<WebElement> alert;

	// Alert ok button
	@FindBy(xpath = "//android.view.View[@text='OK']")
	WebElement alert_okbtn;

	@FindBy(xpath = "//android.view.View[4]/android.widget.EditText/android.view.View")
	WebElement inlineerr;

	int error_index, inline_errorindex;
	String error, inline_error;
	public static String expected_location, expected_hotel, expected_roomtype, expected_nofrooms,
			expected_adultsperroom, expected_childrenperroom;
	String text;

	/**
	 * Method to check the welcome message of a user
	 * 
	 * @param rno Row where the test case is present in Test Data file
	 * @return boolean result of the method
	 */
	public boolean checkWelcomeMessage(int rno) {
		boolean result;
		try {
			// Assigning Expected Message to be verified
			String expectedmsg;
			expectedmsg = "welcome_user";

			// Explicitly waiting for welcome message to be displayed
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(welcome_msg));

			// Capturing the screenshot
			screen.takeScreenshot("Checking Welcome Message");

			// Verifying the actual message with the expected message
			// and assigning the result of validation to result
			if (welcome_msg.getText().equalsIgnoreCase(expectedmsg))
				result = true;
			else
				result = false;

		} catch (Exception e) {
			result = false;
		}
		// returning the value of result depending on the outcome of execution
		return result;

	}

	/**
	 * Method to verify alert popup when user tries to search with no input
	 * 
	 * @return boolean result of the method
	 * @param rno Row number of the testcase
	 */
	public boolean verifyAlertPopupMessage(int rno) {
		boolean result = true;
		try {
			// Reading the expected alert message from the test data file
			error_index = ExcelUtil.readExcel('c', "Alert message for invalid search");
			error = ExcelUtil.getCellData(rno, error_index);
			// Comparing the expected and the actual alert message
			if ((alert.get(0).getText().equalsIgnoreCase("Missing Data"))
					&& (alert.get(1).getText().equalsIgnoreCase(error))) {
				result = true;
				// Clicking on alert ok button
				alert_okbtn.click();
			} else
				result = false;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			Log.error("Error occurred while verifying alert");

		}
		return result;
	}

	/**
	 * Method to enter check-in date in the Home page
	 */
	public boolean validateCheckinDate() {
		boolean result = true;
		try {
			// Scroll till check in date field
			ScrollUtil.pageScrollToText("Check-in Date");
			// Clicks on check-in date
			checkin_date.click();
			screen.takeScreenshot("Checkin date validation");

		} catch (Exception e) {
			result = false;

		}
		return result;
	}

	/**
	 * Method to click on Done button to select the date
	 * 
	 * @return boolean result
	 */
	public boolean clickonDone() {
		boolean result = true;
		try {
			for (int i = 0; i < 2; i++) {// Scrolls to select the date
				ScrollUtil.calendarScroll();
				// Clicks on done button
				donedate.click();
				screen.takeScreenshot("Done button");
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			Log.error("Error occurred while clicking on Done");
		}
		return result;

	}

	/**
	 * Method to click on Cancel button to select the date
	 * 
	 * @return boolean result
	 */
	public boolean clickonCancel() {
		boolean result = true;
		try {
			for (int i = 0; i < 2; i++)

			{
				// Scrolls to select the date
				ScrollUtil.calendarScroll();
				// Clicks on Cancel button
				canceldate.click();
				screen.takeScreenshot("Cancelation");
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			Log.error("Error occurred while clicking on Cancel");
		}
		return result;

	}

	/**
	 * Method to enter check-out date in the Home page
	 */
	public boolean validateCheckoutDate() {
		boolean result = true;
		try {
			// Scroll till check out date field
			ScrollUtil.pageScrollToText("Check-out Date");
			// Clicks on check-out date
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(checkout_date));
			checkout_date.click();
			screen.takeScreenshot("Checkout Date");

		} catch (Exception e) {
			result = false;

		}
		return result;
	}

	/**
	 * Method to enter Adults per room in the Home page
	 * 
	 * @throws IOException Exception while taking screenshot
	 */
	public boolean validateAdultsPerRoom(int rno) throws IOException {
		boolean result = true;
		try {

			int expected_adultno_index = ExcelUtil.readExcel('c', "Adults per Room");
			expected_adultsperroom = ExcelUtil.getCellData(rno, expected_adultno_index);
			// Scroll till adults per room field
			ScrollUtil.pageScrollToText("Adults per Room");
			// Clicks on Adults per room field
			adults_per_room.click();

			String apr[] = expected_adultsperroom.split(",");
			Log.info("The adults per room in the test data sheet is" + apr[0]);
			Log.info(apr[1]);
			int count = 0;
			int k = 0;
			// Comparing the expected and actual adults per room options
			for (int j = 0; j < adultsroom_optns.size(); j++) {
				System.out.println(adultsroom_optns.get(j).getText());
				if (adultsroom_optns.get(j).getText().equalsIgnoreCase(apr[k])) {
					{
						count++;
						k++;
					}
				}
			}
			Log.info("The total number of adults per room is" + count);
			// Verifying the count of matched adults per rooms
			if (count == 4)
				result = true;
			else
				result = false;

		} catch (Exception e) {
			result = false;

		}
		screen.takeScreenshot("Adults per room validation");

		return result;
	}

	/**
	 * Method to enter Children per room in the Home page
	 * 
	 * @throws IOException Exception while taking screenshot
	 */
	public boolean validateChildrenPerRoom(int rno) throws IOException {
		boolean result = true;
		try {

			int expected_childno_index = ExcelUtil.readExcel('c', "Children per Room");
			expected_childrenperroom = ExcelUtil.getCellData(rno, expected_childno_index);

			// Scroll till adults per room field
			ScrollUtil.pageScrollToText("Children per Room");
			// Clicks on Adults per room field
			children_per_room.click();

			String cpr[] = expected_childrenperroom.split(",");
			Log.info("The adults per room in the test data sheet is" + cpr[0]);
			Log.info(cpr[1]);
			int count = 0;
			int k = 0;
			// Comparing the expected and actual adults per room options
			for (int j = 0; j < childrensroom_optns.size(); j++) {
				System.out.println(childrensroom_optns.get(j).getText());
				if (childrensroom_optns.get(j).getText().equalsIgnoreCase(cpr[k])) {
					{
						count++;
						k++;
					}
				}
			}
			Log.info("The total number of children per room is" + count);
			// Verifying the count of matched adults per rooms
			if (count == 4)
				result = true;
			else
				result = false;

		} catch (Exception e) {
			result = false;

		}
		screen.takeScreenshot("Children per room validation");

		return result;
	}

	/**
	 * Method to verify in-line error when user first tries to search with no input
	 * 
	 * @return boolean result of the method
	 * @param rno Row number where the test case is present
	 */
	public boolean verifyInlineError(int rno) {
		boolean result = true;
		try {
			// Reading the expected in-line error message for invalid search
			inline_errorindex = ExcelUtil.readExcel('c', "Error message for invalid search");
			inline_error = ExcelUtil.getCellData(rno, inline_errorindex);
			// Scrolling till the error message is found
			ScrollUtil.pageScrollToText(inline_error);
			// Comparing the actual and expected error message
			if (inlineerr.getText().equalsIgnoreCase(inline_error))
				result = true;
			else
				result = false;

		} catch (Exception r) {
			result = false;
			r.printStackTrace();
			Log.error("Error occurred while verifying the inline error");
		}
		return result;
	}

	/**
	 * Method to search for a hotel with all input fields
	 * 
	 * @param i Row where the test case is present in Test Data file
	 * @return boolean result of the method
	 * 
	 */
	public boolean searchHotel(int i) {
		boolean result = true;
		try {
			expected_location = new String();
			expected_hotel = new String();
			expected_roomtype = new String();
			expected_nofrooms = new String();
			expected_adultsperroom = new String();
			expected_childrenperroom = new String();

			try {
				// Reading the Expected location from the Test Data file
				int expected_location_index = ExcelUtil.readExcel('c', "Location");
				expected_location = ExcelUtil.getCellData(i, expected_location_index);

				// Reading the Expected hotel from the Test Data file
				int expected_hotel_index = ExcelUtil.readExcel('c', "Hotels");
				expected_hotel = ExcelUtil.getCellData(i, expected_hotel_index);

				// Reading the Expected Room Type from the Test Data file
				int expected_roomtype_index = ExcelUtil.readExcel('c', "Room Type");
				expected_roomtype = ExcelUtil.getCellData(i, expected_roomtype_index);

				// Reading the Expected Room Number from the Test Data file
				int expected_roomno_index = ExcelUtil.readExcel('c', "Number of Rooms");
				expected_nofrooms = ExcelUtil.getCellData(i, expected_roomno_index);

				// Reading the Expected Adults per room Number from the Test Data file
				int expected_adultno_index = ExcelUtil.readExcel('c', "Adults per Room");
				expected_adultsperroom = ExcelUtil.getCellData(i, expected_adultno_index);

				// Reading the Expected Children per room Number from the Test Data file
				int expected_childno_index = ExcelUtil.readExcel('c', "Children per Room");
				expected_childrenperroom = ExcelUtil.getCellData(i, expected_childno_index);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.error(e.getCause().toString());
				e.printStackTrace();
			}

			// Selecting the location from the location drop down
			selectlocation.click();

			for (int j = 0; j < location_optns.size(); j++) {
				System.out.println(location_optns.get(j).getText());
				if (location_optns.get(j).getText().contains(expected_location)) {
					for (int k = 0; k < 2; k++)
						location_optns.get(j).click();
					break;
				}
			}

			// Selects the Hotel mentioned in the test data file
			if (!expected_hotel.isEmpty()) {
				select_hotel.click();

				for (int j = 0; j < hotel_optns.size(); j++) {
					if (hotel_optns.get(j).getText().contains(expected_hotel)) {
						for (int k = 0; k < 2; k++)
							hotel_optns.get(j).click();
						break;
					}
				}
			}

			// Selects the room type mentioned in the test data file
			if (!expected_roomtype.isEmpty()) {
				select_roomtype.click();
				for (int j = 0; j < roomtype_optns.size(); j++) {
					System.out.println(roomtype_optns.get(j).getText());
					if (roomtype_optns.get(j).getText().contains(expected_roomtype)) {
						for (int k = 0; k < 2; k++)
							roomtype_optns.get(j).click();
						break;

					}
				}
			}

			// Selects the room no: mentioned in the test data file
			if (!expected_nofrooms.isEmpty()) {
				no_of_rooms.click();
				for (int j = 0; j < roomno_optns.size(); j++) {
					if (roomno_optns.get(j).getText().contains(expected_nofrooms)) {
						for (int k = 0; k < 2; k++)
							roomno_optns.get(j).click();
						break;
					}
				}
			}

			// Selects the adult room no: mentioned in the test data file
			if (!expected_adultsperroom.isEmpty()) {
				ScrollUtil.pageScrollToText("Adults per Room");
				adults_per_room.click();
				for (int j = 0; j < adultsroom_optns.size(); j++) {
					if (adultsroom_optns.get(j).getText().contains(expected_adultsperroom)) {
						for (int k = 0; k < 2; k++)
							adultsroom_optns.get(j).click();
						break;
					}
				}
			}

			// Selects the children room no: mentioned in the test data file
			if (!expected_childrenperroom.isEmpty()) {
				ScrollUtil.pageScrollToText("Children per Room");
				children_per_room.click();
				for (int j = 0; j < childrensroom_optns.size(); j++) {
					if (childrensroom_optns.get(j).getText().contains(expected_childrenperroom)) {
						for (int k = 0; k < 2; k++)
							childrensroom_optns.get(j).click();
						break;
					}
				}
			}
			// Capturing the screenshot
			screen.takeScreenshot("Searching hotel");
		} catch (Exception e) {
			Log.info("Exception occured while searching hotel");
			result = false;
		}
		return result;
	}

	/**
	 * Method to click on Search button
	 * 
	 * @return boolean result of the method
	 */
	public boolean clickOnSearch() {

		boolean result = true;
		try {
			// Scrolls till the search button and clicks on it
			boolean search_result = ScrollUtil.pageScrollToText("Search");
			if (search_result == false)
				result = false;
			search_btn.click();
		} catch (Exception e) {
			result = false;
		}
		return result;

	}

	/**
	 * Test case to validate the locations present in the location drop down
	 * 
	 * @param rno Row number where the test case data is present
	 * @return boolean result of execution
	 * @throws Exception Exception while reading test data file
	 */
	public boolean viewLocationDropdown(int rno) throws Exception {
		int expected_location_index = ExcelUtil.readExcel('c', "Location");
		expected_location = ExcelUtil.getCellData(rno, expected_location_index);
		int count = 0;
		boolean result = true;
		try {
			// Selecting the location
			selectlocation.click();
			// Extracting the expected locations in the dropdown
			String location[] = expected_location.split(",");
			int k = 0;
			// Comparing the expected and actual locations
			for (int j = 0; j < location_optns.size(); j++) {
				System.out.println(location_optns.get(j).getText());
				if (location_optns.get(j).getText().equalsIgnoreCase(location[k])) {
					{
						count++;
						k++;
					}
				}
				Log.info("The total number of locations is" + count);
				// Verifying the count of matched locations
				if (count == 8)
					result = true;
				else
					result = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occurred while viewing location drop down");
		}
		return result;
	}

	/**
	 * Test case to validate the locations present in the hotel drop down
	 * 
	 * @param rno Row number where the test case data is present
	 * @return boolean result of execution
	 * @throws Exception Exception while reading test data file
	 */
	public boolean viewHotelDropdown(int rno) throws Exception {
		// Reading the expected hotel dropdown options
		int expected_hotel_index = ExcelUtil.readExcel('c', "Hotels");
		expected_hotel = ExcelUtil.getCellData(rno, expected_hotel_index);
		int count = 0;
		boolean result = true;
		try {
			// Selecting the hotel
			select_hotel.click();
			// Reading the expected hotels
			String hotel[] = expected_hotel.split(",");
			int k = 0;
			// Comparing the actual and expected hotels
			for (int j = 0; j < hotel_optns.size(); j++) {
				System.out.println(hotel_optns.get(j).getText());
				if (hotel_optns.get(j).getText().equalsIgnoreCase(hotel[k])) {
					{
						count++;
						k++;
					}
				}
				// Validating the count of hotels in the dropdown
				Log.info("The total number of hotels is" + count);
				if (count == 4)
					result = true;
				else
					result = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occurred while viewing hotel drop down");
		}
		return result;
	}

	/**
	 * Test case to validate the roomtype options present in the roomtype dropdown
	 * 
	 * @param rno Row number where the test case data is present
	 * @return boolean result of execution
	 * @throws Exception Exception while reading test data file
	 */
	public boolean viewRoomtypeDropdown(int rno) throws Exception {
		// Reading the expected room type dropdown options
		int expected_roomtype_index = ExcelUtil.readExcel('c', "Room Type");
		expected_roomtype = ExcelUtil.getCellData(rno, expected_roomtype_index);
		int count = 0;
		boolean result = true;
		try {
			// Selecting the roomtype
			select_roomtype.click();
			// Reading the expected room types
			String rtype[] = expected_roomtype.split(",");
			int k = 0;
			// Comparing the actual and expected room types
			for (int j = 0; j < roomtype_optns.size(); j++) {
				System.out.println(roomtype_optns.get(j).getText());
				if (roomtype_optns.get(j).getText().equalsIgnoreCase(rtype[k])) {
					{
						count++;
						k++;
					}
				}
				// Validating the count of room types in the dropdown
				Log.info("The total number of hotels is" + count);
				if (count == 4)
					result = true;
				else
					result = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occurred while viewing room type drop down");
		}
		return result;
	}

	/**
	 * Test case to validate the room number options present in the room number drop
	 * down
	 * 
	 * @param rno Row number where the test case data is present
	 * @return boolean result of execution
	 * @throws Exception Exception while reading test data file
	 */
	public boolean viewRoomnoDropdown(int rno) throws Exception {
		// Reading the Expected Room Number from the Test Data file
		int expected_roomno_index = ExcelUtil.readExcel('c', "Number of Rooms");
		expected_nofrooms = ExcelUtil.getCellData(rno, expected_roomno_index);

		int count = 0;
		boolean result = true;
		try {
			// Selecting the room number
			no_of_rooms.click();
			// Reading the expected room number options
			String rrno[] = expected_nofrooms.split(",");
			int k = 0;
			// Comparing the actual and expected room number
			for (int j = 0; j < roomno_optns.size(); j++) {

				if (roomno_optns.get(j).getText().equalsIgnoreCase(rrno[k])) {
					{
						count++;
						k++;
					}
				}
			}
			boolean scroll = ScrollUtil.pageScrollToText("10 - Ten");
			if (scroll == true)
				count++;

			// Validating the count of room number in the dropdown
			Log.info("The total number of hotels is" + count);
			if (count == 10)
				result = true;
			else
				result = false;

		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occurred while viewing room type drop down");
		}
		return result;
	}

	/**
	 * Method to perform reset of the fields entered
	 * 
	 * @return boolean result of the method
	 */
	public boolean doReset() {
		boolean result;

		try {
			int count = 0;
			result = true;

			// Clicking on reset button
			reset_btn.click();

			// Checks if the location drop down is cleared by checking for the default text
			ScrollUtil.pageScrollToText("Select Location");
			// Taking the screenshot after reset
			screen.takeScreenshot("After Search Reset");
			if (selectlocation.getText().equalsIgnoreCase("Select Location")) {
				Log.info("Count is incremented" + count);
				count++;
			}

			// Checks if the hotel drop down is cleared by checking for the default text
			if (select_hotel.getText().equalsIgnoreCase("Select Hotel")) {
				Log.info("Count is incremented" + count);
				count++;
			}

			// Checks if the room type drop down is cleared by checking for the default text
			if (select_roomtype.getText().equalsIgnoreCase("Select Room Type")) {
				Log.info("Count is incremented" + count);
				count++;
			}

			Log.info("Number of rooms displayed is" + no_of_rooms.getText());
			if (no_of_rooms.getText().equalsIgnoreCase("1 - One, Select Number of Rooms")) {
				// Log.info(no_of_rooms.getText());
				Log.info("Count is incremented" + count);
				count++;
			}

			ScrollUtil.pageScrollToText("Adults per Room");
			screen.takeScreenshot("After Search Reset_2");
			Log.info("Adults per room displayed is " + adults_per_room.getText());
			if (adults_per_room.getText().equalsIgnoreCase("1 - One, Select Adults per Room")) {
				Log.info("Count is incremented" + count);
				count++;
			}

			// Checks if the children per room drop down is cleared by checking for the
			// default text
			ScrollUtil.pageScrollToText("Select Children per Room");
			screen.takeScreenshot("After Reset_Img_2");
			if (children_per_room.getText().equalsIgnoreCase("Select Children per Room")) {
				Log.info("Count is incremented" + count);
				count++;
			}

			Log.info("Count is" + count);
			if (count == 6)
				result = true;
			else
				result = false;
		} catch (Exception e) {
			Log.info("Exception occurred while performing reset");
			e.getCause();
			e.printStackTrace();
			result = false;
		}

		return result;
	}

}
