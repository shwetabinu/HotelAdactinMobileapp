package com.adactin.Mobileapphoteladactin.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.adactin.Mobileapphoteladactin.base.BaseClass;

/**
 * The class has methods to take step by step screenshots and also to take screenshots when any
 * error occurs. It also has a method to get Date in String format.
 * @author shwetabinu
 *
 */
public class ScreenshotCapture extends BaseClass {
	public ScreenshotCapture() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}


	public String tc;
	public String screenshot_fullname;

	/**
	 * Method to capture the screenshot and save it with the filename
	 * 
	 * @param name Name of the file where screenshot is saved
	 * @throws IOException Exception occurred while reading/writing Input/Output
	 */

	public void takeScreenshot(String name) throws IOException {
		File scrFile;
		
		//tc = .testcase_name;
		
		String folder_name = BaseClass.testcasename;
		
		String fileSeperator = System.getProperty("file.separator");
		
		String screenShotName = name + "_"+getDateInStringFormat(new Date(),2)+".png";
		
		String folderpath = System.getProperty("user.dir") + fileSeperator + "Screenshots"+ fileSeperator + folder_name;
		try {
			File destfolder = new File(folderpath); // Set screenshots folder
			//Creates a destination folder if it does not exist
			if (!destfolder.exists()) {
				if (destfolder.mkdirs()) {
					Log.info("Directory: " + destfolder.getAbsolutePath() + " is created!");
				} else {
					Log.info("Failed to create directory: " + destfolder.getAbsolutePath());
				}

			}
			//Takes screenshot
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String targetLocation;
			targetLocation = folderpath + fileSeperator + screenShotName;
			//Stores the screenshot in the target location
			File targetFile = new File(targetLocation);
			//Copies the original file to the target file
			FileHandler.copy(scrFile, targetFile);
		}
			catch (FileNotFoundException e) {
				Log.info("File not found exception occurred while taking screenshot " + e.getMessage());
			} catch (Exception e) {
				Log.info("An exception occurred while taking screenshot " + e.getCause());
			}
	}

	/**
	 * Method to take screenshots when testcase fails and attach to the Test Report
	 * @param reportsPath path of the Test Report
	 * @param fileSeperator File separator to be used
	 * @param testClassName Testcase name
	 * @param screenShotName Name of the screenshot
	 * @return String: targetlocation
	 */
	public String getErrorScreenshots(String reportsPath, String fileSeperator, String testClassName,
			String screenShotName) {

		String targetLocation = null;

		try {
			File file = new File(reportsPath); 		
			//creating a file if it does not exist
			if (!file.exists()) {
				if (file.mkdirs()) {
					Log.info("Directory: " + file.getAbsolutePath() + " is created!");
				} else {
					Log.info("Failed to create directory: " + file.getAbsolutePath());
				}

			}
			//Takes the screenshot
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		
			//Determining the target location
			targetLocation = reportsPath + fileSeperator + screenShotName;										
			//Creating a file at the target location
			File targetFile = new File(targetLocation);
			Log.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
			Log.info("Target File location - " + targetFile.getAbsolutePath());
			//Copies the screenshot file to the target file
			FileHandler.copy(screenshotFile, targetFile);

		} catch (FileNotFoundException e) {
			Log.info("File not found exception occurred while taking screenshot " + e.getMessage());
		} catch (Exception e) {
			Log.info("An exception occurred while taking screenshot " + e.getCause());
		}
		
		return targetLocation;
	}
	
	
	/**
	 * Method to get the current Time stamp to be appended to screenshots
	 * @param date Current Date
	 * @param format The format to be followed for the date
	 * @return String Date in String format
	 */
	public static String getDateInStringFormat(Date date, int format)
	{
		StringBuffer retBuf = new StringBuffer();
		DateFormat df = null;
		if(date==null)
		{
			date = new Date();
		}
		//Multiple formats of timestamps depending on the requirement
		if(format==1)
			df = new SimpleDateFormat("dd-MM-yyyy HHmmss");
		else if(format==2)
			df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		retBuf.append(df.format(date));
		return retBuf.toString();
	}

}
