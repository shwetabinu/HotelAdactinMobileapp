package com.adactin.Mobileapphoteladactin.util;


import org.apache.log4j.Logger;

/**
 * This class provides logging capabilities
 * @author shwetabinu
 *
 */
public class Log {
		 
		// Initialize Log4j logs
		 
		private final static Logger Log=Logger.getLogger(Log.class.getName());
		 
			
		 /**
		  * Prints the log for the start of the test case
		  * @param sTestCaseName Name of the test case
		  */
		 public static void startTestCase(String sTestCaseName){
			
		 Log.info("****************************************************************************************");
		 
		 Log.info("****************************************************************************************");
		 
		 Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		 
		 Log.info("****************************************************************************************");
		 
		 Log.info("****************************************************************************************");
		 
		 }
		 
		 
		 /**
		  * Prints the log for the end of the test case
		  * @param sTestCaseName Name of the test case
		  */
		 public static void endTestCase(String sTestCaseName){
		 
		 Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		 
		 Log.info("X");
		 
		 Log.info("X");
		 
		 Log.info("X");
		 
		 Log.info("X");
		 
		 }
		 
		/**
		 * Prints log message for type:info
		 * @param message Name of the test case
		 */	 
		 public static void info(String message) {
		 
		 Log.info(message);
		 
		 }
		 
		/**
		 * Prints log message for type:warn
		 * @param message Name of the test case
		 */
		 public static void warn(String message) {
		 
		    Log.warn(message);
		 
		 }
		 
		 /**
		 * Prints log message for type:error
		 * @param message Name of the test case
		 */
		 public static void error(String message) {
		 
		    Log.error(message);
		 
		 }
		 
		 /**
		  * Prints log message for type:fatal
		  * @param message Name of the test case
		  */
		 public static void fatal(String message) {
		 
		    Log.fatal(message);
		 
		 }
		 
		 /**
		  * Prints log message for type:debug
		  * @param message Name of the test case
		  */
		 public static void debug(String message) {
		 
		    Log.debug(message);
		 
		 }
		 
		}



