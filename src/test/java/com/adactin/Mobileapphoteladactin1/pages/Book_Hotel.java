package com.adactin.Mobileapphoteladactin1.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.adactin.Mobileapphoteladactin1.util.ScrollUtil;

public class Book_Hotel extends BaseClass {

	public Book_Hotel() throws Exception {
		PageFactory.initElements(driver, this);
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
	private WebElement booknow_btn;

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


			// Reading creditcard type
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
		cctype.click();

		for (int j = 0; j < cctypeoption.size(); j++)
			if (cctypeoption.get(j).getText().equalsIgnoreCase(expected_cctype)) {
				for (int l = 0; l < 2; l++)
					cctypeoption.get(j).click();
			}

		// Selects the CC Expiry date
		ccexpiry.click();
		for (int k = 0; k < 2; k++) {
			ScrollUtil.calendarScroll();
			done_btn.click();
		}

		// Enters the CVV Number mentioned in the test data file
		cvv.click();
		driver.getKeyboard().sendKeys(expected_cvvnumber);
		driver.getKeyboard().sendKeys(Keys.RETURN);

		// Clicking on book now button
		booknow_btn.click();
		}catch(Exception e)
		{
			e.printStackTrace();
			result=false;
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
