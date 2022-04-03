package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnSubmit;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logoutLink;
	
	public void setUserName(String uname)
	{
		
		txtUserName.clear();
		txtUserName.sendKeys(uname);
		
		
	}
	public void setPassword(String pwd)
	{
		
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		
		
	}
	
	public void clickButton()
	{
		
		btnSubmit.click();
		
		
	}
	
	public void clickLogOut()
	{
		
		logoutLink.click();
		
	}

}
