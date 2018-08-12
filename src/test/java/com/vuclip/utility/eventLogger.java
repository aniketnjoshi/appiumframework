package com.vuclip.utility;

import com.aventstack.extentreports.Status;

public class eventLogger {

	
	    public static void startTestCase(final String sTestCaseName) {
	    	
		    Init.testInfo = Init.reports.createTest(sTestCaseName);
		    Init.testInfo.log(Status.INFO, "Starting test case - "+ sTestCaseName);
		    
		    info("****************************************************************************************");
	        info("$$$$$$$$$$$$$$$$$$$$$  " + sTestCaseName + "  $$$$$$$$$$$$$$$$$");
	        info("****************************************************************************************");
	       
	    }

	    public static void endTestCase(final String sTestCaseName) {
	        info("****************************************************************************************");
	        info("XXXXXXXXXXXXXXXXXXXXXXX  " + "--TESTCASE-"+sTestCaseName+"-END--" + "  XXXXXXXXXXXXXX");
	        info("****************************************************************************************");
	        Init.testInfo.log(Status.INFO, "Ending test case - "+ sTestCaseName);
	    }

	    public static void info(final String message) {
	    	Init.logWriter.info(message);
	    	System.out.println(message);
	    	
	    	Init.testInfo.log(Status.INFO, "Info - "+ message);
	    }

	    public static void warn(final String message) {
	    	Init.logWriter.warn(message);
	        System.out.println(message);
	        Init.testInfo.log(Status.WARNING, "Warning - "+ message);
	    }

	    public static void error(final String message) {
	    	Init.logWriter.error(message);
	        System.out.println(message);
	        Init.testInfo.log(Status.ERROR, "Error - "+ message);
	    }

	    public static void fatal(final String message) {
	    	Init.logWriter.fatal(message);
	    }

	    public static void debug(final String message) {
	    	Init.logWriter.debug(message);
	        Init.testInfo.log(Status.DEBUG, "Debug - "+ message);
	    }
	    
	    public static void debugInit(final String message) {
	    	Init.logWriter.debug(message);
	       // Init.testInfo.log(Status.DEBUG, "Debug - "+ message);
	    }
}
