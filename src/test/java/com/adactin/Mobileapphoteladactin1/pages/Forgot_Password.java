package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;

public class Forgot_Password extends BaseClass {

	public Forgot_Password() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * Method to enter the email when forgot password link is clicked
 * @param rno
 * @throws Exception
 */
	public void enterEmail(int rno) throws Exception
	{
		WebElement enter_email=driver.findElement(By.name("emailadd_recovery"));
		WebElement submit=driver.findElement(By.name("Submit"));
		WebElement reset=driver.findElement(By.id("Reset"));
		
		String email;
		email=ExcelUtil.getCellData(rno,23);
		enter_email.sendKeys(email);
		submit.click();
		
	}
}
