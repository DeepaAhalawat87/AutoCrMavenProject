package com.autocrib.reporting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	
	public static ExtentReports getExtentReport()
	{
		
		htmlReporter =new ExtentHtmlReporter("./Extent_Report/ExtentReport_"+generateDate()+".html");
		htmlReporter.config().setReportName("Automation-Report");
		htmlReporter.config().setDocumentTitle("Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("operatingSystem", "window 10");
		extent.setSystemInfo("Tester", "Deepa");
		
		return extent;
		
		
	}
	
	public static String generateDate()
	{
		
		 Date d=new Date();
		 DateFormat df= new SimpleDateFormat("yyyy-MM-dd-hhmmss");
		 return  df.format(d);
		 
	}
	
	
	
}
