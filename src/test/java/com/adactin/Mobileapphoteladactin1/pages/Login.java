package com.adactin.Mobileapphoteladactin1.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;

/**
 * Login class has methods to login, click on forget password link and sign up as a new user
 * MobileElements username, password, sign in, sign up and forgot password links are identified
 * 
 *
 */
public class Login extends BaseClass{

	
	public Login() throws Exception
	{		
		PageFactory.initElements(driver, this);
		
	}

	
	public void initialising(int i) throws IOException
	{
		try {
			initApp(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error("Unable to initialize the app");
		}
	}
	
/**
 * Method to login to the application
 * @param i
 * @throws Exception
 */
	public void Logging_in(int i) throws Exception
	{	
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String username=ExcelUtil.getCellData(i,5);
		String password=ExcelUtil.getCellData(i,6);

		MobileElement userid= (MobileElement) driver.findElement(By.name("Username"));
		MobileElement passw= (MobileElement) driver.findElement(By.name("Password"));
		MobileElement submit= (MobileElement) driver.findElement(By.name("Login"));

		userid.click();
		userid.sendKeys(username);
		passw.click();
		passw.sendKeys(password);
		passw.sendKeys(Keys.RETURN);
		submit.click();
	
			
	}
	
	public void clickOnForgotpassword()
	{
		MobileElement forgotpassw;
		forgotpassw=(MobileElement) driver.findElement(By.name("Forgot password"));
		forgotpassw.click();
	}
	
	public void clickOnSignup()
	{	MobileElement signup;
		signup=(MobileElement) driver.findElement(By.name("Not a member yet? Sign Up"));
		signup.click();
	}
	
	public boolean checkIfLoginButtonPresent()
	{
		MobileElement submit= (MobileElement) driver.findElement(By.name("Login"));
		Boolean f;
		if(submit.isEnabled()==true)
			return true;
		else
			return false;		
			
	}
	
	public void checkErrorMessage(int i) throws Exception
	{
		int flag=0;
		String Errormessage=ExcelUtil.getCellData(i,27);
		MobileElement ok_btn=(MobileElement) driver.findElement(By.name("OK"));
		MobileElement err_message=(MobileElement)driver.findElement(By.name("failure_alert Invalid Login Credentials"));
		Assert.assertEquals(err_message.getText(), Errormessage);
		ok_btn.click();
		
		
	}
/*	public void checkErrorMessage(int i) throws Exception
	{
		int flag=0;
		String Errormessage=ExcelUtil.getCellData(i,27);
		MobileElement ok_btn=(MobileElement) driver.findElement(By.name("Ok"));
		MobileElement err_message=(MobileElement)driver.findElement(By.name("Failure"));
		Assert.assertEquals(err_message.getText(), Errormessage);
		ok_btn.click();
		
		
	}*/
	
	
	
}
