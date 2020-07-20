package com.adactin.Mobileapphoteladactin1.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

public class Forgot_Password extends BaseClass {

	public Forgot_Password() throws Exception {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="emailadd_span")
	WebElement enter_email;
	
	@FindBy(id="Submit")
	WebElement submit_email;
	
	@FindBy(id="Reset")
	WebElement reset_email;
	
	@FindBy(xpath="//android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]")
	WebElement frame_fp;
	/**
	 * Method to enter the email when forgot password link is clicked
	 * @param rno
	 * @throws Exception
	 */
	public void emailPassword(int rno) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.switchTo().frame(frame_fp);
		enter_email.click();
		enter_email.sendKeys("Email id");
		submit_email.click();		
		
	}
	
	public void switchToWebView()
	{
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		
		//driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

		//do some web testing
		//String myText = driver.findElement(By.cssSelector(".green_button")).click();

		
		//driver.context("NATIVE_APP");
	}
}
