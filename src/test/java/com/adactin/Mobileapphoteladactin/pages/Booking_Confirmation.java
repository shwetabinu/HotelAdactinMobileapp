package com.adactin.Mobileapphoteladactin.pages;

import java.io.IOException;

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
 * Booking Confirmation page web elements and methods to perform actions on these web elements
 * @author shwetabinu
 *
 */
public class Booking_Confirmation extends BaseClass {

	ScreenshotCapture screen;
	public Booking_Confirmation() throws Exception {
		//Initializing the elements in Booking Confirmation page
		PageFactory.initElements(driver, this);
		//Initializing an object of ScreenshotCapture class
		screen=new ScreenshotCapture();
	}

	//Hotel Name
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[2]/android.view.View")
	WebElement hotelname;
	
	//Location
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[4]/android.view.View")
	WebElement location;
			
	//Room Type
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[6]/android.view.View")
	WebElement roomtype;
	
	//Arrival date
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[8]/android.view.View")
	WebElement arrdate;
	
	//Departure Date
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[10]/android.view.View")
	WebElement  depdate;
	
	//Total Rooms
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[12]/android.view.View")
	WebElement totrooms;
	
	//Adults per room
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[14]/android.view.View")
	WebElement apr;
	
	//Children per room
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[16]/android.view.View")
	WebElement cpr;
	
	//Price per night
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[18]/android.view.View")
	WebElement pricepn;
	
	//Total price
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[20]/android.view.View")
	WebElement totp;
	
	//GST
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[22]/android.view.View")
	WebElement gst;
	//Scroll down
	
	//First Name
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[12]/android.view.View")
	WebElement fname;
	
	//Last Name
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[14]/android.view.View")
	WebElement lname;
	
	//Billing Address
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[16]/android.view.View")
	WebElement baddr;
	
	//Order ID
	@FindBy(xpath="//android.view.View[2]/android.widget.ScrollView/android.view.View[18]/android.view.View")
	WebElement ordid;
	
	// Done button
	@FindBy(xpath = "//android.widget.Button[@text='Done']")
	WebElement done_btn;
	
	//Close button
	@FindBy(xpath="//android.view.View[2]/android.widget.Button")
	WebElement close_btn;
	
	String expected_fname,expected_lname,expected_billaddress,expected_location,expected_hotel,
	expected_roomtype,expected_nofrooms,expected_adultsperroom,expected_childrenperroom;
	
	public static String order_id;

	/**
	 * method to read expected data
	 * @return boolean result of reading expected data
	 * @param rno Row number where the data is read from
	 */
	public boolean readExpectedData(int rno)
	{
		boolean result=true;
		try {
		int fname_index = ExcelUtil.readExcel('c', "First Name");
		expected_fname = ExcelUtil.getCellData(rno, fname_index);		
		//Count is incremented in order to determine the number of in-line errors
		
		// Reading last name
		int lname_index = ExcelUtil.readExcel('c', "Last Name");
		expected_lname = ExcelUtil.getCellData(rno, lname_index);
		
		// Reading billing address
		int ba_index = ExcelUtil.readExcel('c', "Billing Address");
		expected_billaddress = ExcelUtil.getCellData(rno, ba_index);
		
		//Reading location
		int expected_location_index = ExcelUtil.readExcel('c', "Location");
		expected_location = ExcelUtil.getCellData(rno, expected_location_index);

		// Reading the Expected hotel from the Test Data file
		int expected_hotel_index = ExcelUtil.readExcel('c', "Hotels");
		expected_hotel = ExcelUtil.getCellData(rno, expected_hotel_index);

		// Reading the Expected Room Type from the Test Data file
		int expected_roomtype_index = ExcelUtil.readExcel('c', "Room Type");
		expected_roomtype = ExcelUtil.getCellData(rno, expected_roomtype_index);

		// Reading the Expected Room Number from the Test Data file
		int expected_roomno_index = ExcelUtil.readExcel('c', "Number of Rooms");
		expected_nofrooms = ExcelUtil.getCellData(rno, expected_roomno_index);

		// Reading the Expected Adults per room Number from the Test Data file
		int expected_adultno_index = ExcelUtil.readExcel('c', "Adults per Room");
		expected_adultsperroom = ExcelUtil.getCellData(rno, expected_adultno_index);

		// Reading the Expected Children per room Number from the Test Data file
		int expected_childno_index = ExcelUtil.readExcel('c', "Children per Room");
		expected_childrenperroom = ExcelUtil.getCellData(rno, expected_childno_index);
		}catch(Exception e)
		{e.printStackTrace();
		Log.error("Error occurred while reading the expected data");
		result=false;
		}
		return result;
	}
	
	
	/**
	 * Method to validate booking details
	 * @throws IOException Exception while taking screenshot
	 * @return boolean result of validating booking confirmation
	 */
	public boolean validateBookingConfirmationDetails() throws IOException
	{
		//Explicitly waiting until the hotel list items are visible
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(hotelname));
		//Taking Screenshot
		screen.takeScreenshot("Booking confirmatin page");
		boolean result=true;
		try{
		int count=0;
		//Validating price per night
		Log.info(pricepn.getText());
		Log.info("The expected price per night is"+Selected_Hotel_Detail.ppn);
		if(pricepn.getText().equalsIgnoreCase(Selected_Hotel_Detail.ppn))
			{
			Log.info(pricepn.getText());
			count++;
			}
		//Validating hotel name
		Log.info(hotelname.getText());
		Log.info("The expected hotel name is"+Selected_Hotel_Detail.expected_hotel);
		if(hotelname.getText().equalsIgnoreCase(Selected_Hotel_Detail.expected_hotel))
			{Log.info(hotelname.getText());
			count++;
			}
		//Validating location
		Log.info(location.getText());
		Log.info("The expected location is"+Selected_Hotel_Detail.expected_location);
		if(location.getText().equalsIgnoreCase(Selected_Hotel_Detail.expected_location))
			{Log.info(location.getText());
			count++;
			}
		//Validating room type
		Log.info(roomtype.getText());
		Log.info("The expected room type is"+Selected_Hotel_Detail.room_ty);
		if(roomtype.getText().equalsIgnoreCase(Selected_Hotel_Detail.room_ty))
			{
			Log.info(roomtype.getText());
			count++;
			}
		//Validating arrival date
		Log.info(arrdate.getText());
		Log.info("The expected arrival date is"+Selected_Hotel_Detail.arr_date);
		if(arrdate.getText().equalsIgnoreCase(Selected_Hotel_Detail.arr_date))
			{
			Log.info(arrdate.getText());
			count++;
			}
		//Validating departure date
		Log.info(depdate.getText());
		Log.info("The expected departure date is"+Selected_Hotel_Detail.dep_dat);
		if(depdate.getText().equalsIgnoreCase(Selected_Hotel_Detail.dep_dat))
			{
			Log.info(depdate.getText());
			count++;
			}
		//Validating total room number
		Log.info("The actual total rooms is"+totrooms.getText());
		Log.info("The expected room number is"+Selected_Hotel_Detail.room_nu);
		if(Selected_Hotel_Detail.room_nu.charAt(0)==(totrooms.getText().charAt(0)))
			{
			Log.info(totrooms.getText());
			count++;
			}
		//Validating adults per room
		Log.info("The actual adults per room is"+apr.getText().charAt(0));
		Log.info("The expected adults per room is"+Home.expected_adultsperroom);
		if(Home.expected_adultsperroom.charAt(0)==(apr.getText().charAt(0)))
			{
			Log.info(apr.getText());
			count++;
			}
		//Validating children per room
		Log.info(cpr.getText());
		Log.info("The expected children per room is"+Home.expected_childrenperroom);
		if(Home.expected_childrenperroom.contains(cpr.getText()))
			{
			Log.info(cpr.getText());
			count++;
			}
		//Validating total price
		Log.info("The actual total price is "+ totp.getText());
		Log.info("The expected total price is "+Selected_Hotel_Detail.acttotal_price);
		if(totp.getText().equalsIgnoreCase(Selected_Hotel_Detail.acttotal_price))
			{
			Log.info(totp.getText());
			count++;
			}
	
		//Scrolling till First name
		ScrollUtil.pageScrollToText("First Name");
		screen.takeScreenshot("Booking confirmation page_2");
		//Validating first name
		if(fname.getText().equalsIgnoreCase(Book_Hotel.expected_fname))
		{	Log.info(fname.getText());
			count++;
		}
		//Validating last name
		if(lname.getText().equalsIgnoreCase(Book_Hotel.expected_lname))
		{Log.info(lname.getText());
			count++;
		}
		//Validating bill address
		if(baddr.getText().equalsIgnoreCase(Book_Hotel.expected_billaddress))
			{
			count++;
			Log.info(baddr.getText());
			}
		Log.info("The total count is"+count);
		
		//Validating the total count
		if(count==13)
			result=true;
		else
			result=false;
		}catch(Exception e)
		{
			e.printStackTrace();
			Log.error("Error occurred while validating data");
		}
		return result;
	}
	/**
	 * Method to confirm the booking by clicking on the Done button
	 * @return boolean result of the method
	 */
	public boolean confirm_Booking() {
		boolean result = true;
		try {
			//Scrolls down till the Done button and clicks on it
			ScrollUtil.pageScrollToText("Done");
			//Taking the relevant screenshot
			screen.takeScreenshot("Booking Confirmation");
			//Clicking on done button
			done_btn.click();
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occurred while scrolling and clicking on done button");
			result = false;
		}
		return result;
	}

	/**
	 * Method to fetch the order id from the order id mobile element
	 * 
	 * @return boolean result of the method
	 */
	public boolean getOrderId() {
		boolean result = true;
		try {
			//Extracts the order id in the booking confirmation page and
			//stores in a global variable
			ScrollUtil.pageScrollToText("Order No.");
			order_id = ordid.getText();
			//Verifying if order id field has a value
			if(ordid.getText().isEmpty())
				result=false;
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error occurred while storing the order id");
			result=false;
		}
		return result;
	}

}
