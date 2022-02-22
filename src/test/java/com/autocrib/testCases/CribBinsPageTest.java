package com.autocrib.testCases;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.autocrib.initiateTest.initClass;

public class CribBinsPageTest  extends initClass{

	private static final Logger LOGGER =LoggerFactory.getLogger(CribBinsPageTest.class);
	
	@Test
	public void assignExistingItemToRoboCribBin() throws InterruptedException
	{
	
		LOGGER.info("assignExistingItemToRoboCribBin testcase started ");
		
		loginPage.setUserName("dmaster-qa");
		//Thread.sleep(4000);
		loginPage.setPassword("1111");
		loginPage.clickSubmit();
		boolean errMsg=loginPage.checkAlertAvailability();
		if(errMsg)
		{
			//Reporter.log(errMsg, true);
			//Assert.assertFalse(true);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loginPage.clickSubmit();
			Assert.assertEquals(loginPage.getTitle(),"Autocrib :: AutoCrib :: Home", "User is not successfully logged in");
			Reporter.log("User is successfully logged in and redirected to Home Page "+loginPage.getTitle(),true);
			loginPage.closeNotification();
		}
			
		cribBinPage.clickWebApiAutomationSite();
		cribBinPage.navigateToCribsClickBins();
	
		boolean b=cribBinPage.isAllCribDisplayed();
	 	Assert.assertTrue(b, "All Cribs title is not displayed");
	 	
	 	cribBinPage.clickRoboCrib();
	 	cribBinPage.clickRoboView();
		
		
		
	}
	
	
		
	
}
