package com.adactin.Mobileapphoteladactin1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.adactin.Mobileapphoteladactin1.util.ScrollUtil;

import io.appium.java_client.MobileElement;

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

	@FindBy(xpath = "//android.view.View[@text='Home']")
	WebElement home_btn;

	@FindBy(xpath = "//android.view.View[@text='Booked Itinerary']")
	WebElement booked_itinerary;

	/**
	 * Method to check the welcome message of a user
	 * 
	 * @param rno
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
	 * Method to check the location drop down for the entries
	 * 
	 * @param i
	 */
	public void checkLocationdropdown(int i) {
		String[] expectedlocation = null;
		try {
			expectedlocation = ExcelUtil.getCellData(i, 7).split(",");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Unable to read from the excel sheet");
			e.printStackTrace();
		}
		List<MobileElement> location = driver.findElementsByAccessibilityId("Select Location");
		int n = 0;
		for (MobileElement ele : location) {
			Assert.assertEquals(ele.getText(), expectedlocation[n]);
			// assert.assertEquals(ele.getText(), expectedlocation[i]);
			n++;
		}

	}

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
				// expected_location=ExcelUtil.getCellData(i,7);
				int expected_location_index = ExcelUtil.readExcel('c', "Location");
				expected_location = ExcelUtil.getCellData(i, expected_location_index);

				int expected_hotel_index = ExcelUtil.readExcel('c', "Hotels");
				expected_hotel = ExcelUtil.getCellData(i, expected_hotel_index);

				int expected_roomtype_index = ExcelUtil.readExcel('c', "Room Type");
				expected_roomtype = ExcelUtil.getCellData(i, expected_roomtype_index);

				int expected_roomno_index = ExcelUtil.readExcel('c', "Number of Rooms");
				expected_nofrooms = ExcelUtil.getCellData(i, expected_roomno_index);

				int expected_adultno_index = ExcelUtil.readExcel('c', "Adults per Room");
				expected_adultsperroom = ExcelUtil.getCellData(i, expected_adultno_index);

				int expected_childno_index = ExcelUtil.readExcel('c', "Children per Room");
				expected_childrenperroom = ExcelUtil.getCellData(i, expected_childno_index);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.error(e.getCause().toString());
				e.printStackTrace();
			}

			selectlocation.click();

			for (int j = 0; j < location_optns.size(); j++) {
				System.out.println(location_optns.get(j).getText());
				if (location_optns.get(j).getText().contains(expected_location)) {
					for (int k = 0; k < 2; k++)
						location_optns.get(j).click();
					break;
					// Thread.sleep(1000);
				}
			}

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

			// ScrollUtil.pageScrollToText("Search");

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

		boolean result=true;
		try{
			boolean search_result=ScrollUtil.pageScrollToText("Search");
			if(search_result==false)
				result=false;
			search_btn.click();
		}catch(Exception e)
		{
			result=false;
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
			reset_btn.click();

			if (selectlocation.getText().equalsIgnoreCase("Select Location"))
				count++;

			if (select_hotel.getText().equalsIgnoreCase("Select Hotel"))
				count++;

			if (select_roomtype.getText().equalsIgnoreCase("Select Room Type"))
				count++;

			if (children_per_room.getText().equalsIgnoreCase("Select Children per Room"))
				count++;

			if (count == 4)
				result = true;
			else
				result = false;
		} catch (Exception e) {
			Log.info("Exception occurred while performing reset");
			result = false;
		}

		return result;
	}

	/**
	 * Method to search for hotel with hotel and location provided
	 * 
	 * @param i
	 * @throws Exception
	 */
	public void searchHotel_Hotel_location(int i) throws Exception {

		String expected_location = new String();
		String expected_hotel = new String();

		int expected_location_index = ExcelUtil.readExcel('c', "Location");
		expected_location = ExcelUtil.getCellData(i, expected_location_index);

		int expected_hotel_index = ExcelUtil.readExcel('c', "Hotels");
		expected_hotel = ExcelUtil.getCellData(i, expected_hotel_index);

		selectlocation.click();

		for (int j = 0; j < location_optns.size(); j++) {
			System.out.println(location_optns.get(j).getText());
			if (location_optns.get(j).getText().contains(expected_location)) {
				for (int k = 0; k < 2; k++)
					location_optns.get(j).click();
				break;
				// Thread.sleep(1000);
			}
		}

		select_hotel.click();

		for (int j = 0; j < hotel_optns.size(); j++) {
			if (hotel_optns.get(j).getText().contains(expected_hotel)) {
				for (int k = 0; k < 2; k++)
					hotel_optns.get(j).click();
				break;
			}
		}

	}

	/**
	 * Method to search for hotel with only location field entered
	 * 
	 * @param i
	 * @throws Exception
	 */
	public void searchHotel_Location_only(int i) throws Exception {
		String expected_location = new String();

		int expected_location_index = ExcelUtil.readExcel('c', "Location");
		expected_location = ExcelUtil.getCellData(i, expected_location_index);

		selectlocation.click();

		for (int j = 0; j < location_optns.size(); j++) {
			System.out.println(location_optns.get(j).getText());
			if (location_optns.get(j).getText().contains(expected_location)) {
				for (int k = 0; k < 2; k++)
					location_optns.get(j).click();
				break;

			}
		}

	}
}
