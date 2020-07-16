package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.Log;

public class Dashboard extends BaseClass{
	
	public Dashboard() throws Exception {
		
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//android.view.View[@text='Home']")
	WebElement home_btn;

	@FindBy(xpath = "//android.view.View[@text='Booked Itinerary']")
	WebElement booked_itinerary;

	@FindBy(xpath="//android.view.View[@text='Account']")
	WebElement account_btn;
	
	/**
	 * Method to view the booked itinerary from the search hotel page
	 * @param rno Row where the test case is present in Test Data file
	 * @return
	 */
	public boolean viewBookedItinerary()
	{
		boolean result=true;
		try {
			//Clicking on booked itinerary button
			booked_itinerary.click();
		}catch(Exception e)
		{
			//Printing error message for exception
			Log.info("Error occurred while viewing booked itinerary");
			result=false;
			e.printStackTrace();
		}
		
		return result;
	}
	

	/**
	 * Method to view the account page
	 * @param rno Row where the test case is present in Test Data file
	 * @return
	 */
	public boolean viewAccount(int rno)
	{
		boolean result=true;
		try {
			//Clicking on Account button
			account_btn.click();
		}catch(Exception e)
		{
			//Printing error message for exception
			Log.info("Error occurred while viewing account page");
			result=false;
			e.printStackTrace();
		}
		
		return result;
	}
	

	/**
	 * Method to view Home / Search hotel page
	 * @param rno Row where the test case is present in Test Data file
	 * @return
	 */
	public boolean viewHome(int rno)
	{
		boolean result=true;
		try {
			//Clicking on Home button
			home_btn.click();
		}catch(Exception e)
		{
			//Printing error message for exception
			Log.info("Error occurred while viewing home page");
			result=false;
			e.printStackTrace();
		}
		
		return result;
	}

}
