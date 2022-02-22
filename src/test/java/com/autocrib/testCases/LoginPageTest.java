package com.autocrib.testCases;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.autocrib.initiateTest.initClass;

//@Listeners(com.autocrib.reporting.ListenerImplementation.class)
public class LoginPageTest extends initClass {

private static final Logger LOGGER= LoggerFactory.getLogger(LoginPageTest.class);
	
	@Test(priority=0,groups= {"Login"})
	public void testLoginPage() throws Throwable
	{
 		LOGGER.info("TestLoginPage testcase started ");
		loginPage.setUserName("dmaster-qa");
		//Thread.sleep(4000);
		loginPage.setPassword("1111");
		loginPage.clickSubmit();
		boolean errMsg=loginPage.checkAlertAvailability();
		if(errMsg)
		{
			//Reporter.log(errMsg, true);
			//Assert.assertFalse(true);
			Thread.sleep(3000);
			loginPage.clickSubmit();
			verifyUser();
		}
				
		loginPage.clickReports();
		Reporter.log("clicked Reports", true);
		LOGGER.info("testLoginPage test case ends");
		//loginPage.clickLogOut();
	   
		
	
	}
	
	
	public void verifyUser()
	{
		
		Assert.assertEquals(loginPage.getTitle(),"Autocrib :: AutoCrib :: Home", "User is not successfully logged in");
		Reporter.log("User is successfully logged in and redirected to Home Page "+loginPage.getTitle(),true);
		
	}
	
	
	
	/*
	@Test(dependsOnMethods="testLoginPage")
	public void logOut()
	{
		 LOGGER.info("logout test case started");
		 loginPage.clickLogOut();
		 LOGGER.info("logout test case ends");
		
	}
	*/
	
	
}
