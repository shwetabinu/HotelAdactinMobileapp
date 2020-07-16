package com.adactin.Mobileapphoteladactin1.util;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidMobileCommandHelper;


public class ScrollUtil extends BaseClass {

	public ScrollUtil() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to scroll to an element with a particular text and clicks on the
	 * element
	 * 
	 * @param scrollableList resource id of the scrollable element.
	 * @param text           to which the scroll needs to be performed
	 */
	public static boolean scrollToElementUsingScrollIntoView(String scrollableList, String text) {

		boolean result = true;

		try {
			// Scrolling to a particular element
			MobileElement element = driver

					.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceid(\""
							+ scrollableList + "\")).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"))"));

			// Clicking on the element
			element.click();
		} catch (NoSuchElementException e) {
			result = false;
		}

		return result;

	}

	/**
	 * Method to scroll till a particular text on a page
	 * 
	 * @param text Text up to which scroll action is to be performed
	 * @return Result of scrolling
	 */
	public static boolean pageScrollToText(String text) {
		boolean result = true;
		try {
			// Scrolling till a particular text
			MobileElement el = driver

					.findElement(MobileBy.AndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches(\""
									+ text + "\"));"));

			System.out.println("The text in the element" + el.getText());
			//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		} catch (NoSuchElementException e) {
			result = false;
		}

		return result;

	}

	public static boolean pageScrollEnd()
	{
		boolean result = true;
		try {
			// Scrolling till a particular text
		
			//StepDefs.driver.findElement(MobileBy.AndroidUIAutomator(“new UiScrollable(new UiSelector().scrollable(true))”+".scrollToEnd(55);"));
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).flingForward());");
			//UIScrollable obj=new UiScrollable(new UiSelector().scrollable(true).instance(0));
			//System.out.println("The text in the element" + el.getText());
			//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		} catch (NoSuchElementException e) {
			result = false;
		}

		return result;
	}
	/**
	 * Method to scroll till the last element with the help of touch action
	 * 
	 */
	public static void calendarScroll() {
		//MobileElement seek_bar = driver.findElement(By.xpath("//android.view.View/android.widget.SeekBar[2]"));
		MobileElement seek_bar = driver.findElement(By.xpath("//android.widget.ScrollView"));
		
		// get start co-ordinate of seek bar
		int startx = seek_bar.getLocation().getX();
		
		int starty = seek_bar.getLocation().getY();
		// Get width and height of seekbar
		int endx = seek_bar.getSize().getWidth();
		int endy = seek_bar.getSize().getHeight();
		endx=0;
		endy=2074;

		try {
			// Defining touch action for scrolling
			TouchAction touchAction = new TouchAction(driver);
			// Setting the start and end point to scroll
			PointOption pointStart = PointOption.point(startx, starty);
			PointOption pointEnd = PointOption.point(endx, endy);
			//PointOption pointEnd = PointOption.point(startx, endy);
			// Setting the wait duration
			WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
			// Scrolling action after wait
			touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
