package com.inetBankingV1.testCases;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBankingV1.pageObjects.AddNewCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;


public class TC_AddCustomerTest_001 extends BaseClass{

	@Test
	public void addCustomerTest() throws HeadlessException, IOException, AWTException {

		LoginPage lp = new LoginPage(driver);
		AddNewCustomerPage addCust = new AddNewCustomerPage(driver);
		lp.setUserName(userName);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickButton();
		logger.info("clicked on loginbutton");
		if (isAlertPresent() == true) {
			captureScreenShotRobo("loginTest");
			String alertMessage = driver.switchTo().alert().getText();
			logger.info(alertMessage + "|| Login test Failed");
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
		}

		else {
			Assert.assertTrue(true);
			logger.info("Login test Passed");
			addCust.clickAddNewCustomer();
	//		addCust.clickCloseLink();
			addCust.custName("Pawan");
			addCust.custGender("male");
			addCust.custDob("02", "10", "1980");
			addCust.custAddr("INDIA");
			addCust.custCity("HYD");
			addCust.custState("Telangana");
			addCust.custPincode("500034");
			addCust.custMobileno("9822220000");
			addCust.custEmail(dynamicEmailid()+"@gmail.com");
			addCust.custPwd("Helloworld");
			addCust.clickSubmit();
	//		if(addCust.customerStatus().equals("Customer Registered Successfully!!!"))
			boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
			if(res==true)
			{
				System.out.println("Customer Created Successfuly");
				captureScreenShotRobo("addCustomerTest");
				
				
			}
			else
			{
				
				System.out.println("Customer not Created");
				
				
			}
			
	//		scrollPageDown();
			
			By locator=By.xpath("//a[text()='Log out']");
			
			WebElement waitforElementClickable = WaitforElementClickable(locator, 30);
			js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", waitforElementClickable);
		//	lp.clickLogOut();

		}
	}

}
