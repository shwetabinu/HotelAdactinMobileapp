package com.adactin.Mobileapphoteladactin.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin.base.BaseClass;
import com.adactin.Mobileapphoteladactin.pages.ForgotPassword_Page2;
import com.adactin.Mobileapphoteladactin.pages.Forgot_Password;
import com.adactin.Mobileapphoteladactin.pages.Login;
import com.adactin.Mobileapphoteladactin.reportgeneration.ExtentTestManager;
import com.adactin.Mobileapphoteladactin.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin.util.Log;
import com.aventstack.extentreports.Status;
/**
 * Test case for forgot password verification
 * @author shwetabinu
 *
 */
public class ForgotPasswordVerification extends BaseClass {
	
	public ForgotPasswordVerification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Forgot_Password fp;
	static Login lp;
	static ForgotPassword_Page2 fp2;
	
	/**
	 * Test case to verify if user can send link to reset password when he has forgotten password
	 * @throws Exception Exception during test execution
	 */
	@Test(groups = { "functionalTest" })
	public void User_is_able_to_send_email() throws Exception
	{
		Log.startTestCase("User_is_able_to_send_email");
		int rno;
		String ordid;
		//Reading the test case row number where the data is to be read
		ExcelUtil.setExcelFileSheet("Testcases");
		rno=ExcelUtil.readExcel('r',"User_is_able_to_send_email");
		
		//Initializing the app
		initApp(rno);
		lp=new Login();
		
		//Clicking on email password link
		boolean login=lp.clickOnForgotpassword();
		//Logging to the report
		if(login==true)
			ExtentTestManager.getTest().log(Status.PASS,"The forgot password link click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The forgot password link click was unsuccessful");		
		
		Assert.assertTrue(login);
		
		fp=new Forgot_Password();
		//Enterting email to which link is to be sent
		boolean emailenter=fp.enterEmail(rno);
		//Logging to the report
		if(emailenter==true)
			ExtentTestManager.getTest().log(Status.PASS,"The email entry was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The  email entry was unsuccessful");		
		Assert.assertTrue(emailenter);
		
		//Clicking on email password link
		boolean email=fp.emailPassword();
		//Logging to the report
		if(email==true)
			ExtentTestManager.getTest().log(Status.PASS,"The email password link click was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The  email password link click was unsuccessful");		
		Assert.assertTrue(email);
		
		fp2=new ForgotPassword_Page2();
		//Verifying the text confirming that the password link is sent
		boolean verifytext=fp2.verifyText(rno);
		//Logging to the report
		if(verifytext==true)
			ExtentTestManager.getTest().log(Status.PASS,"The verification text validation was successful");
		else
			ExtentTestManager.getTest().log(Status.FAIL,"The  verification text validation was unsuccessful");			
		Assert.assertTrue(verifytext);
		
		Log.endTestCase("User_is_able_to_send_email");
		
		
	}
	
	/**
	 * Closing the app
	 */
	@AfterTest(groups = { "functionalTest" })
	public void closeSession()
	{
		//Closing the app
		closeApp();
	}


}
