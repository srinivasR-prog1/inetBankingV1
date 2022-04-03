package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver driver;

	public AddNewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
    @FindBy(how=How.XPATH,using="//a[text()='New Customer']")
    @CacheLookup
    WebElement lnkAddNewCustomer;
    
    @FindBy(how=How.XPATH,using="//span[text()='Close']")
    @CacheLookup
    WebElement lnkCloseAdv;
    
    
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtCustName;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement txtCustDob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtCustAddr;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtCustCity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtCustState;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement txtCustPincode;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txtCustMobileno;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtCustEmailid;
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtCustPassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how=How.XPATH,using="//table[@id='customer']//p")
    @CacheLookup
    WebElement getCustomerStatus;
	
	
	public void clickAddNewCustomer()
	{
		
		lnkAddNewCustomer.click();
		
		
	}
	
	public void custName(String cname)
	{
		txtCustName.clear();
		txtCustName.sendKeys(cname);		
		
	}
	public void custGender(String cgender)
	{
		rdGender.click();		
		
	}
	public void custDob(String mm,String dd,String yy)
	{
		txtCustDob.click();
		txtCustDob.sendKeys(mm);
		txtCustDob.sendKeys(dd);
		txtCustDob.sendKeys(yy);
		
	}
	public void custAddr(String caddress)
	{
		txtCustAddr.clear();
		txtCustAddr.sendKeys(caddress);
		
	}
	public void custCity(String ccity)
	{
			txtCustCity.clear();
			txtCustCity.sendKeys(ccity);
		
	}
	public void custState(String cstate)
	{
		txtCustState.clear();
		txtCustState.sendKeys(cstate);		
		
	}
	public void custPincode(String cpincode)
	{
		txtCustPincode.clear();
		txtCustPincode.sendKeys(String.valueOf(cpincode));		
		
	}
	public void custMobileno(String cmobileno)
	{
		txtCustMobileno.clear();
		txtCustMobileno.sendKeys(String.valueOf(cmobileno));		
		
	}
	public void custEmail(String cemaild)
	{
		txtCustEmailid.clear();
		txtCustEmailid.sendKeys(cemaild);		
		
	}
	public void custPwd(String cpassword)
	{
		txtCustPassword.clear();
		txtCustPassword.sendKeys(cpassword);		
		
	}
	
	public void clickSubmit()
	{
		
		btnSubmit.click();
		
	}
	
	public String customerStatus()
	{
		
		String status=getCustomerStatus.getText();
		return status;
		
	}
	
	
	public void clickCloseLink()
	{
		
		lnkCloseAdv.click();
		
	}
	
	

}
