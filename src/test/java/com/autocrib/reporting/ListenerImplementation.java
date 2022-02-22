package com.autocrib.reporting;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.autocrib.initiateTest.initClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerImplementation implements ITestListener{

	WebDriver driver=null;
	public static ExtentReports reports=ExtentReporter.getExtentReport();
	public ExtentTest test;
   //public static ExtentReports reports=initClass.extentreports; //its not working reports is null,it called beforeTest
	
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	  System.out.println("Inside on test start");
	  test= reports.createTest(result.getName());
	 
	 
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("inside on Test success");
		test.log(Status.PASS, "Test case success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, "failure");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 test.log(Status.SKIP, "skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	public static void putReport()
	{
		System.out.println("report publishing");
		reports.flush();
	}

	
	
}
