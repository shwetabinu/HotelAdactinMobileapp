package com.adactin.Mobileapphoteladactin1.util;


import org.apache.log4j.Logger;

public class Log {
		 
		// Initialize Log4j logs
		 
		private final static Logger Log=Logger.getLogger(Log.class.getName());
		 
			
		 /**
		  * Prints the log for the start of the test case
		  * @param sTestCaseName
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
		  * @param sTestCaseName
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
		 * @param message
		 */	 
		 public static void info(String message) {
		 
		 Log.info(message);
		 
		 }
		 
		/**
		 * Prints log message for type:warn
		 * @param message
		 */
		 public static void warn(String message) {
		 
		    Log.warn(message);
		 
		 }
		 
		 /**
		 * Prints log message for type:error
		 * @param message
		 */
		 public static void error(String message) {
		 
		    Log.error(message);
		 
		 }
		 
		 /**
		  * Prints log message for type:fatal
		  * @param message
		  */
		 public static void fatal(String message) {
		 
		    Log.fatal(message);
		 
		 }
		 
		 /**
		  * Prints log message for type:debug
		  * @param message
		  */
		 public static void debug(String message) {
		 
		    Log.debug(message);
		 
		 }
		 
		}



