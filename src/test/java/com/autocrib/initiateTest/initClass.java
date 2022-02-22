package com.autocrib.initiateTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.autocrib.pageObjects.CribBinsPage;
import com.autocrib.pageObjects.InventoryItemsPage;
import com.autocrib.pageObjects.LoginPage;
import com.autocrib.utilities.PropertyFileUtil;
import com.aventstack.extentreports.ExtentReports;

public class initClass {
	
	public WebDriver driver;
	protected LoginPage loginPage;
	protected CribBinsPage cribBinPage;
	protected InventoryItemsPage inventoryItemPage;
	public static ExtentReports extentreports;
	
	
	@BeforeTest
	public void display()
	{
		System.out.println("Before test");
	}
	@BeforeClass
	public void launchBrowser() throws Throwable 
	{
		System.out.println("inside before class");
		if(PropertyFileUtil.getPropertyValue("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//CommonDrivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else
		{
			System.out.println("firefox driver");
		}
		driver.manage().window().maximize();
		//extentreports=ExtentReporter.getExtentReport();
		createObjects();
		//driver.get(PropertyFileUtil.getPropertyValue("url"));
		

     }
	
	@BeforeMethod
	public void launchUrl() throws Throwable
	{
		driver.get(PropertyFileUtil.getPropertyValue("url"));
		System.out.println("before test method");
	}
	
	
	public void createObjects()
	{
		loginPage = new LoginPage(driver);
		cribBinPage=new CribBinsPage(driver);
		inventoryItemPage=new InventoryItemsPage(driver);
		System.out.println("launch");
	}
	
	
	/*@AfterClass
	public void putReport()
	{
		
		ListenerImplementation.putReport();
		System.out.println("published");
		
	}*/
	
	@AfterClass
	public void tearDown()
	{
		//ListenerImplementation.putReport();
		//extentreports.flush();
		//driver.close();
		System.out.println("after class");
	}
	
	
	
	
	
}
