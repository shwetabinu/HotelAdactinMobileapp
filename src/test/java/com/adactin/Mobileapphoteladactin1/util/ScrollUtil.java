package com.adactin.Mobileapphoteladactin1.util;

import java.time.Duration;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class ScrollUtil extends BaseClass {

	public ScrollUtil() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to scroll to an element with a particular text and clicks on the element
	 * 
	 * @param scrollableList resource id of the scrollable element.
	 * @param text to which the scroll needs to be performed
	 */
	public static boolean scrollToElementUsingScrollIntoView(String scrollableList, String text) {
		
		boolean result=true;

		try
		{
			MobileElement element = driver
		
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceid(\""
						+ scrollableList + "\")).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"))"));

		element.click();
		}catch(NoSuchElementException e)
		{
			result=false;
		}
		
		return result;
		
	}
	
	public static boolean pageScrollToText(String text)
	{
		boolean result=true;
				try{
			MobileElement el = driver
		
			    .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches(\""+ text + "\"));"));
			
			System.out.println("The text in the element"+el.getText());
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//el.click();
			   
			    }
			    catch(NoSuchElementException e)
				{
					result=false;
				}
				
				return result;
				
			    
	}
	
	public static void calendarScroll(String year)
	{
		MobileElement seek_bar=driver.findElement(By.xpath("//android.view.View/android.widget.SeekBar[2]"));
		// get start co-ordinate of seekbar
		int startx=seek_bar.getLocation().getX();
		int starty=seek_bar.getLocation().getY();
		//Get width of seekbar
		int endx=seek_bar.getSize().getWidth();
		int endy=seek_bar.getSize().getHeight();
		//get location of seekbar vertically
		
		
		//Log.info("scroll from : startX " +start + ", startY "+ start+ ", to  endX "+ end+ ",endY "+ endY);
		  try {
		    TouchAction touchAction = new TouchAction(driver);
		    PointOption pointStart = PointOption.point(startx, starty);
		    PointOption pointEnd = PointOption.point(endx, endy);
		    WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
		    touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();
		  }catch (Exception e){
		    //log.error("scroll from : startX " +startX + ", startY "+ startY+ ", to  endX "+ endX+ ",endY "+ endY);
		    e.printStackTrace();
		  }
		
	}
}
