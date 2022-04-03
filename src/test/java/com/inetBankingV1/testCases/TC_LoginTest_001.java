package com.inetBankingV1.testCases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.AddNewCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException, HeadlessException, AWTException {

		LoginPage lp = new LoginPage(driver);		
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
			
			lp.clickLogOut();

		}

	}

}
