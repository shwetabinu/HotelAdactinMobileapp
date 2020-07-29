package reportgeneration;


import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.Log;
import com.adactin.Mobileapphoteladactin1.util.ScreenshotCapture;

/**
 * This class has methods to print logging statements for different conditions: When the execution has
 * started, when test execution has started/failed/passed/skipped. It also takes screenshots when a
 * test case fails and prints the same on the report.
 * @author shwetabinu
 *
 */
public class TestListener implements ITestListener {

	/**
	 * The method defines the actions to be done at the start of test suite
	 * Here the testcase name is displayed at the start of the test with the message
	 * that it is started
	 */
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	/**
	 * The method defines the actions to be done at the end of the test suite
	 * It generates the report through the flush statement
	 */
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentReportGenerator.getInstance().flush();
	}

	/**
	 * The method defines the actions to be done on the start of each Test.
	 * It starts the test with the test case name
	 */
	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getTestContext().getName());
	}

	/**
	 * The method defines the actions to be completed when a test passes
	 * It prints Test passed statement in the report logs
	 */
	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	/**
	 * The method defines the actions to be completed when a test fails.
	 * It takes a screenshot and attaches to the failed step and embeds the
	 * screenshot in the report. It also provide logs indicating that the test failed 
	 * in the report
	 * 
	 */
	public void onTestFailure(ITestResult result) {
		
		String timeStamp;
		
		Log.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		String testClassName = result.getTestContext().getName().toString().trim();
		Log.info(testClassName);
		ScreenshotCapture sc=null;
		try {
			sc = new ScreenshotCapture();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		timeStamp=ScreenshotCapture.getDateInStringFormat(new Date(),1);
		String testMethodName = result.getMethod().getMethodName().toString().trim();
				
		Log.info(testMethodName);
		String screenShotName = "Error"+testMethodName +"_"+timeStamp+ ".png";
		String fileSeperator = System.getProperty("file.separator");
		String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport";
		
		sc.getErrorScreenshots(reportsPath, fileSeperator, testClassName, screenShotName);
	
		Log.info("Screen shots reports path - " + reportsPath);

		// Attach screenshots to the report
		try {
			ExtentTestManager.getTest().fail("Error Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(screenShotName).build());
		} catch (IOException e) {
			Log.info("An exception occured while taking screenshot " + e.getCause());
		}
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		//String bstackurl="https://automate.browserstack.com/dashboard/v2/builds/"+EnvSetup.build_id+"/sessions/"+EnvSetup.session_id;
		//ExtentTestManager.getTest().log(Status.INFO,"The session id for this Browerstack session is: "+EnvSetup.session_id);
		//ExtentTestManager.getTest().log(Status.INFO,"Please find the detailed browserstack reports for this session in the following link: "+"<a href="+bstackurl+">Browserstack session link</a>");
		
	}

	/**
	 * The method defines the actions to be executed in case a test skipped.
	 * It prints a statement that the Test with the testcase name is skipped.
	 * It also adds the required Log statement in the report.
	 */
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	/**
	 * The method defines the actions to be completed if a Test failed but is
	 *  within Success Percentage
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}


}