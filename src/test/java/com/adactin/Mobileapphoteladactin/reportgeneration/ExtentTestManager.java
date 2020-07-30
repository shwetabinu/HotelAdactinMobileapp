package com.adactin.Mobileapphoteladactin.reportgeneration;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * This class has methods to get the Test which is running currently.
 * It also has methods to create the Test in the report and to end the Test and log 
 * the same in the report after its execution.
 * @author shwetabinu
 *
 */
public class ExtentTestManager {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentReportGenerator.getInstance();

	/**
	 * Method to get the current Test thread
	 * @return ExtentTest object
	 */
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	/**
	 * The method adds and appends content to the report after each test
	 * is run
	 */
	public static synchronized void endTest() {
		extent.flush();
	}

	/**
	 * The method creates an entry for each test at the start of the test with
	 * the testcase name
	 * @param testName Name of the testcase
	 * @return ExtentTest object
	 */
	public static synchronized ExtentTest startTest(String testName) {
		
		ExtentTest test = extent.createTest (testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
}
