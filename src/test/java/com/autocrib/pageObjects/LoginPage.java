package com.autocrib.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class LoginPage{

	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(id="txtLoginName")
	public WebElement username;
	
	
	@FindBy(id="Password")
	public WebElement password;
	
	@FindBy(id="btnLoginSubmit")
	public WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='validation-summary-errors']")
	public WebElement errorMsg;
	
	@FindBy(id="LoginDropDownIcon")
	public WebElement dropDownIcon;
	
	@FindBy(xpath="//i[@class='fa fa-power-off']")
	public WebElement logoutLink;
	
	@FindBy(xpath="(//i[@class='fa fa-angle-right'])[14]")
	public WebElement reportSite;
	
	@FindBy(xpath="//a[@class='close']")
	public WebElement notification;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String username)
	{
		this.username.clear();
		this.username.sendKeys(username);
		
	}
	
	public void setPassword(String password)
	{
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		this.submitBtn.click();
		
	}
	
	public String getTitle()
	{
		
		return driver.getTitle();
	}
	
	public void clickLogOut()
	{
		this.dropDownIcon.click();
		this.logoutLink.click();
	}
	
	public boolean checkAlertAvailability()
	{
		wait= new WebDriverWait(driver,5);
		try
		{
		if(wait.until(ExpectedConditions.alertIsPresent())!=null)
		{
			driver.switchTo().alert().accept();
			return true;
		}
		else
		return false;
		}
		catch(Exception e)
		{
			return false;
			
		}
		
	}
	
	
	public void clickReports()
	{
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		this.reportSite.click();
		
		 
	}
	
	
	public void closeNotification()
	{
		this.notification.click();
	}
	
	
}

