package com.adactin.Mobileapphoteladactin1.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.adactin.Mobileapphoteladactin1.util.ScrollUtil;

/**
 * Home page has methods to initialize the home page. It has methods to search
 * hotel
 *
 */
public class Home extends BaseClass {
	public Home() throws Exception {
		PageFactory.initElements(driver, this);

	}

	String text;

	@FindBy(xpath = "//android.view.View[1][contains(@text,'welcome')]")
	WebElement welcome_msg;

	@FindBy(xpath = "//android.view.View[@text='search_hotel']")
	WebElement search_hotel_title;

	@FindBy(xpath = "//android.widget.EditText[@text='Select Location']")
	WebElement selectlocation;

	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> location_optns;

	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	WebElement cancel_btn;

	@FindBy(xpath = "//android.widget.EditText[@text='Select Hotel']")
	WebElement select_hotel;

	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> hotel_optns;

	@FindBy(xpath = "//android.widget.EditText[@text='Select Room Type']")
	WebElement select_roomtype;

	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> roomtype_optns;

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Number of Rooms')]")
	WebElement no_of_rooms;

	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> roomno_optns;

	// after scroll

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Check-in Date')]")
	WebElement checkin_date;

	@FindBy(xpath = "//android.widget.SeekBar")
	List<WebElement> checkin_datepicker;

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Check-out Date')]")
	WebElement checkout_date;

	@FindBy(xpath = "//android.widget.SeekBar")
	List<WebElement> checkout_datepicker;

	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	WebElement canceldate;

	@FindBy(xpath = "//android.widget.Button[@text='Done']")
	WebElement donedate;

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Adults per Room')]")
	WebElement adults_per_room;

	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> adultsroom_optns;

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Children per Room')]")
	WebElement children_per_room;

	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> childrensroom_optns;

	@FindBy(xpath = "//android.widget.Button[@text='Search']")
	WebElement search_btn;

	@FindBy(xpath = "//android.widget.Button[@text='Reset']")
	WebElement reset_btn;

	
	
	/**
	 * Method to check the welcome message of a user
	 * 
	 * @param rno Row where the test case is present in Test Data file
	 * @throws Exception
	 */
	public boolean checkWelcomeMessage(int rno) throws Exception {
		boolean result;
		try {
			// Assigning Expected Message to be verified
			String expectedmsg;
			expectedmsg = "welcome_user";

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
	 * Method to search for a hotel with all input fields
	 * 
	 * @param i Row where the test case is present in Test Data file
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchHotel(int i) throws InterruptedException {
		boolean result = true;
		try {
			String expected_location = new String();
			String expected_hotel = new String();
			String expected_roomtype = new String();
			String expected_nofrooms = new String();
			String expected_adultsperroom = new String();
			String expected_childrenperroom = new String();

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

		} catch (Exception e) {
			Log.info("Exception occured while searching hotel");
			result = false;
		}
		return result;
	}

	/**
	 * Method to click on Search button
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
	 * Method to perform reset of the fields entered
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
			
			if (selectlocation.getText().equalsIgnoreCase("Select Location"))
				{
				Log.info("Count is incremented"+count);
				count++;
				}

			// Checks if the hotel drop down is cleared by checking for the default text
			if (select_hotel.getText().equalsIgnoreCase("Select Hotel"))
			{
				Log.info("Count is incremented"+count);
				count++;
				}

			// Checks if the room type drop down is cleared by checking for the default text
			if (select_roomtype.getText().equalsIgnoreCase("Select Room Type"))
			{
				Log.info("Count is incremented"+count);
				count++;
				}

			Log.info("Number of rooms displayed is"+no_of_rooms.getText());
			if (no_of_rooms.getText().equalsIgnoreCase("1 - One, Select Number of Rooms"))
			{
				//Log.info(no_of_rooms.getText());
				Log.info("Count is incremented"+count);
				count++;
				}
			
			ScrollUtil.pageScrollToText("Adults per Room");

			Log.info("Adults per room displayed is "+ adults_per_room.getText());
			if (adults_per_room.getText().equalsIgnoreCase("1 - One, Select Adults per Room"))
			{
				Log.info("Count is incremented"+count);
				count++;
				}

			// Checks if the children per room drop down is cleared by checking for the
			// default text
			ScrollUtil.pageScrollToText("Select Children per Room");
			if (children_per_room.getText().equalsIgnoreCase("Select Children per Room"))
			{
				Log.info("Count is incremented"+count);
				count++;
				}

			Log.info("Count is"+count);
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
