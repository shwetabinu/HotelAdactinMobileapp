package com.adactin.Mobileapphoteladactin1.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.adactin.Mobileapphoteladactin1.util.ScreenshotCapture;
import com.adactin.Mobileapphoteladactin1.util.ScrollUtil;

public class Book_Hotel extends BaseClass {

	ScreenshotCapture screen;
	public Book_Hotel() throws Exception {
		PageFactory.initElements(driver, this);
		screen=new ScreenshotCapture();
	}

	// Enter first name text box
	@FindBy(xpath = "//android.widget.EditText[@text='Enter First Name']")
	private WebElement firstName;

	// Enter last name text box
	@FindBy(xpath = "//android.widget.EditText[@text='Enter Last Name']")
	private WebElement lastName;

	// Enter billing address text box
	@FindBy(xpath = "//android.widget.EditText[@text='Enter Billing Address']")
	private WebElement billingAddress;

	// Enter Credit card number text box
	@FindBy(xpath = "//android.widget.EditText[@text='Enter Card Number']")
	private WebElement ccnumber;

	// Enter credit card type text box
	@FindBy(xpath = "//android.widget.EditText[@text='Select Credit Card Type']")
	private WebElement cctype;

	// Credit card type drop down options
	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View")
	List<WebElement> cctypeoption;

	// cancel button
	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	WebElement cancel_btn;

	// Select expiry date picker
	@FindBy(xpath = "//android.widget.EditText[@text='Select Expiry Month & Year']")
	private WebElement ccexpiry;

	// Done button
	@FindBy(xpath = "//android.widget.Button[@text='Done']")
	private WebElement done_btn;

	// Enter CVV text box
	@FindBy(xpath = "//android.widget.EditText[@text='Enter CVV Number']")
	private WebElement cvv;

	// Book now button
	@FindBy(xpath = "//android.widget.Button[@text='Book Now']")
	WebElement booknow_btn;

	// back button
	@FindBy(xpath = "//android.widget.Button[@text='Back']")
	WebElement back_btn;
	
	//alert title+content
	@FindBy(xpath="//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
	List<WebElement>alert;
	
	//alert ok
	@FindBy(xpath="//android.view.View[@text='OK']")
	WebElement alert_okbtn;
	
	//error messages
	@FindBy(xpath="//android.view.View[contains(@text,'Please')]")
	List<WebElement>errormessage;
	
	
	
	public static String expected_fname, expected_lname, expected_billaddress, expected_ccnumber, expected_cctype, expected_cvvnumber;
	String expected_alertmessage;
	int count;
	int error_index;
	String error;
	/**
	 * Method to read the expected data from the TestData file
	 * 
	 * @param rno
	 */
	public boolean readExpectedData(int rno) {
		boolean result = true;
		try {
			// Reading first name
			int fname_index = ExcelUtil.readExcel('c', "First Name");
			expected_fname = ExcelUtil.getCellData(rno, fname_index);		
			//Count is incremented in order to determine the number of in-line errors
			if(expected_fname.isEmpty())
				count++;

			// Reading last name
			int lname_index = ExcelUtil.readExcel('c', "Last Name");
			expected_lname = ExcelUtil.getCellData(rno, lname_index);
			if(expected_lname.isEmpty())
				count++;

			// Reading billing address
			int ba_index = ExcelUtil.readExcel('c', "Billing Address");
			expected_billaddress = ExcelUtil.getCellData(rno, ba_index);
			if(expected_billaddress.isEmpty())
				count++;

			// Reading credit card number
			int ccn_index = ExcelUtil.readExcel('c', "CC Number");
			expected_ccnumber = ExcelUtil.getCellData(rno, ccn_index);
			if(expected_ccnumber.isEmpty())
				count++;


			// Reading credit card type
			int cctype_index = ExcelUtil.readExcel('c', "CC Type");
			expected_cctype = ExcelUtil.getCellData(rno, cctype_index);
			if(expected_cctype.isEmpty())
				count++;


			// Reading cvv
			int cvv_index = ExcelUtil.readExcel('c', "CVV");
			expected_cvvnumber = ExcelUtil.getCellData(rno, cvv_index);
			if(expected_cvvnumber.isEmpty())
				count++;
			
			//Reading blank alert message
			int blank_alert_index=ExcelUtil.readExcel('c', "Alert message for booking details");
			expected_alertmessage=ExcelUtil.getCellData(rno, blank_alert_index);
			
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			Log.error("Error occurred while reading the test data");
		}

		return result;
	}

	/**
	 * Method to enter the booking details to the Book Hotel page Clicks on Book now
	 * after all the fields are entered
	 * 
	 * @param i row number
	 * @throws Exception
	 */
	public boolean enterBookingDetails(int i) throws Exception
	{
		boolean result=true;
		try {
		// Scroll to the First name text box and enters the expected first name from
		// test data file
		ScrollUtil.pageScrollToText("Enter First Name");
		screen.takeScreenshot("Book Hotel page");
		firstName.click();
		driver.getKeyboard().sendKeys(expected_fname);

		// Scroll to the Last name text box and enters the expected Last name from test
		// data file
		ScrollUtil.pageScrollToText("Enter Last Name");
		lastName.click();
		driver.getKeyboard().sendKeys(expected_lname);
		driver.getKeyboard().sendKeys(Keys.RETURN);

		// Scroll to the Billing Address text box and enters the same from test data
		// file
		ScrollUtil.pageScrollToText("Enter Billing Address");
		driver.getKeyboard().sendKeys(expected_billaddress);

		// Scroll to the CC Number text box and enters the same from test data file
		ScrollUtil.pageScrollToText("Enter Card Number");
		ccnumber.click();
		driver.getKeyboard().sendKeys(expected_ccnumber);

		// Selects the CCTYpe drop down and selects the option specified in the test
		// data file
		ScrollUtil.pageScrollToText("Select Credit Card Type");
		screen.takeScreenshot("Book Hotel page_2");
		cctype.click();

		for (int j = 0; j < cctypeoption.size(); j++)
			if (cctypeoption.get(j).getText().equalsIgnoreCase(expected_cctype)) {
				for (int l = 0; l < 2; l++)
					cctypeoption.get(j).click();
			}

		// Selects the CC Expiry date
		ScrollUtil.pageScrollToText("Select Expiry Month & Year");
		ccexpiry.click();
		for (int k = 0; k < 2; k++) {
			ScrollUtil.calendarScroll();
			done_btn.click();
		}

		// Enters the CVV Number mentioned in the test data file
		cvv.click();
		driver.getKeyboard().sendKeys(expected_cvvnumber);
		driver.getKeyboard().sendKeys(Keys.RETURN);

		//screen.takeScreenshot("Enter booking details");
		
		}catch(Exception e)
		{
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	
	/**
	 * Method to verify alert popup when user tries to search with no input
	 */
	public boolean verifyAlertPopupMessage(int rno)
	{
		boolean result=true;
		try {
			//Reading the alert pop-up message to be compared
			error_index=ExcelUtil.readExcel('c', "Alert message for booking details");			
			error=ExcelUtil.getCellData(rno, error_index);
			//Comparing the expected alert message with the actual alert text
			if((alert.get(0).getText().equalsIgnoreCase("Missing Data")) && (alert.get(1).getText().contains(error)))
				{
				result=true;
				//Clicking on ok button in the alert
				screen.takeScreenshot("Verifying alert popup message");
				alert_okbtn.click();
				}
			else
				result=false;
		
		}catch(Exception e)
		{
			result=false;
			e.printStackTrace();
			Log.error("Error occurred while verifying alert");
			
		}
		return result;
	}
	/**
	 * Method to click on book now button
	 * @return
	 */
	public boolean clickBookNow()
	{
		
		boolean result=true;
		try {
			driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
			//Scrolling down till the book now button
			ScrollUtil.pageScrollToText("Book Now");
			screen.takeScreenshot("Book now button");
			//Clicking on the book now button
			booknow_btn.click();
		}catch(Exception e)
		{
			result=false;
			e.printStackTrace();
			Log.error("Error occurred while clicking on book now");
		}
		return result;
	}
	
	/**
	 * Method to verify the in-line error messages when booking a hotel with no inputs
	 */
	public boolean verifyInlineError(int rno)
	{
		
		boolean result=true;
		try {
			int size=0;
			//Counts the total set of in-line error messages
			int count=0;
			//Counting the first set of error messages in the top
			ScrollUtil.pageScrollToText("Please enter your first name");
			screen.takeScreenshot("Inline errors");
			Log.info("The error messages size when scrolled to the top till first name is"+ errormessage.size());
			if(errormessage.size()==3||errormessage.size()==4)
				{Log.info("Error messages count is"+errormessage.size());
				size=errormessage.size();
				count++;
				}
			//Scrolling till the end and counting the total number of inline errors
			ScrollUtil.pageScrollToText("Book Now");
			screen.takeScreenshot("Inline errors_2");
			Log.info("The error messages size when scrolled till book now is"+ errormessage.size());
			if(errormessage.size()==5)
				{
				Log.info("Error messages size is"+errormessage.size());
				size=size+errormessage.size();
				count++;
				}
			//Verifying the total count
			Log.info("Total number of error messages"+size);
			Log.info("Count is"+count);
			if(count==2)
				result=true;
			else
			result=false;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			result=false;
			Log.error("Error occurred while verifying inline error");
		}
		return result;
	}
	
	
	/**
	 * Method to go back to the previous page
	 */
	public boolean goBack()
	{
		boolean result=true;
		try {
			//Clicking on go back button
			back_btn.click();
		}catch(Exception e)
		{
			e.printStackTrace();
			Log.error("Error occurred while navigating back to the previous page");
			result=false;
		}
		return result;
	}
	
	/**
	 * Method to validate alert message when user enters no/invalid input and clicks on book now
	 */
	public boolean validateAlertMessage(int rno)
	{
		boolean result=true;
		try {
			//Compares the content of the alert with the expected alert message
			if(alert.get(1).getText().equalsIgnoreCase(expected_alertmessage))
					result=true;
			else
				result=false;
			
			
		}catch(Exception e)
		{
			Log.error("Error occurred while validating alert messages");
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	
	/**
	 * Method to validate in-line error messages
	 */
	public boolean validateErrorMessages(int rno) {
		boolean result=true;
		try {
			//Compares the count of the error messages with expected count
			if(errormessage.size()==count)
				result=true;
			else
				result=false;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			Log.error("Error occurred while validating error messages");
			result=false;
		}
		return result;
	}
	
}
