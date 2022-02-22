package com.autocrib.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CribBinsPage {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	@FindBy(xpath="(//ul[@class='box-inner-listing-menu']/li/a)[14]")
	public WebElement webAPIAutomation;
	
	@FindBy(xpath="(//i[@class='pull-right']/span[@class='plus'])[1]")
	public WebElement cribsLink;
	
	@FindBy(xpath="(//i[@class='fa fa-caret-right'])[3]")
	public WebElement binsLink;

	@FindBy(xpath="//h2[@class=' form-head']")
	public WebElement allCribs;
	
	@FindBy(xpath="//div[text()='RoboCrib']")
	public WebElement roboCrib;

	@FindBy(id="btnViewBin")
	public WebElement roboViewLink;
	
	
   public CribBinsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
	   wait=new WebDriverWait(driver,10);
	   act=new Actions(driver);
	}


  public void clickWebApiAutomationSite()
   {
	  
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)");
	   wait.until(ExpectedConditions.elementToBeClickable(webAPIAutomation));
	   this.webAPIAutomation.click();
	   System.out.println("site clicked");
   }

  public void navigateToCribsClickBins()
  {
	 
	  wait.until(ExpectedConditions.elementToBeClickable(cribsLink));
	  act.moveToElement(cribsLink).click().perform();
	  wait.until(ExpectedConditions.elementToBeClickable(binsLink));
	  act.moveToElement(binsLink).click().perform();
  }
  
   public boolean isAllCribDisplayed()
   {
	   if(allCribs.isDisplayed())
	   {
		 return true;
	   }
	    return false;
   }
   
   public void clickRoboCrib()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(roboCrib));
	   this.roboCrib.click();
   }
   
   public void clickRoboView()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(roboViewLink));
	   this.roboViewLink.click();
   }
  
   
   


}


