package com.autocrib.testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.autocrib.initiateTest.initClass;
import com.autocrib.utilities.ExcelFileUtil;
import com.autocrib.utilities.PropertyFileUtil;

public class InventoryItemPageTest extends initClass {

	ExcelFileUtil xl;
	String outpath="C:\\Users\\deepa\\eclipse-workspace\\AutocribMavenProject\\TestOutPut\\TestResult.xlsx";
	String itemNo;
	
	@Test(groups= {"Item"})
	public void createAnExpandableItem() throws Throwable 
	{
			
		verifyLogin();
		inventoryItemPage.clickWebApiAutomationSite();
		inventoryItemPage.clickInventoryLink();
		inventoryItemPage.clickItemsLink();
		inventoryItemPage.clickAddItem();
		
		xl=new ExcelFileUtil("C:\\Users\\deepa\\eclipse-workspace\\AutocribMavenProject\\TestInputData\\ItemData.xlsx");
		int rowCount=xl.rowCount("ExpandableItem");
		int columns=xl.cellCount("ExpandableItem");
		System.out.println("row and column count : "+rowCount +":"+columns);
		for(int i=1;i<=rowCount;i++)
		{
		         itemNo=xl.getCellData("ExpandableItem", i, 0);
		 String description1=xl.getCellData("ExpandableItem", i, 1);
		 String description2=xl.getCellData("ExpandableItem",i ,2);
		 String itemType=xl.getCellData("ExpandableItem", i, 3);
		 String supplier=xl.getCellData("ExpandableItem",i, 4);
		 String supplierItem=xl.getCellData("ExpandableItem", i, 5);
		 String unitCost=xl.getCellData("ExpandableItem",i, 6);
		 String unitPrice=xl.getCellData("ExpandableItem", i, 7);
		 String issueCost=xl.getCellData("ExpandableItem", i, 8);
		
		try
		{
		inventoryItemPage.enterItem(itemNo);
		inventoryItemPage.enterDescription1(description1);
		inventoryItemPage.enterDescription2(description2);
		inventoryItemPage.enterItemType(itemType);
		inventoryItemPage.enterSupplier(supplier);
		inventoryItemPage.enterSupplierItem(supplierItem);
		inventoryItemPage.enterUnitCost(unitCost);
		inventoryItemPage.enterUnitPrice(unitPrice);
		inventoryItemPage.enterIssueCost(issueCost);
		inventoryItemPage.clickSaveButton();
	    Assert.assertTrue(inventoryItemPage.getNotificationMsg().contains("Item added successfully!")); //Item added successfully
	    xl.setCellData("ExpandableItem", i, 9, "PASS", outpath);
		}
		catch(AssertionError e)
		{
		System.out.println("Assertion error");
		 xl.setCellData("ExpandableItem", i, 9, "FAIL", outpath);
		}
		catch(Exception e)
		{
		System.out.println("exception caught");
		xl.setCellData("ExpandableItem", i, 9, "FAIL", outpath);
			
		}
		finally
		{
		 loginPage.clickLogOut();
		}
	  }//for loop
   } //Test Method
	
	public void verifyLogin() throws InterruptedException
	{

		loginPage.setUserName("dmaster-qa");
		loginPage.setPassword("1111");
		loginPage.clickSubmit();
		boolean errMsg=loginPage.checkAlertAvailability();
		if(errMsg)
		{
			Thread.sleep(3000);
			loginPage.clickSubmit();
		}
	}
	
	
	@Test(groups= {"delete"})
	public void deleteAnItem() throws Throwable
	{
	  try {
	  verifyLogin();
	  inventoryItemPage.clickWebApiAutomationSite();
	  inventoryItemPage.clickInventoryLink();
	  inventoryItemPage.clickItemsLink();
	  inventoryItemPage.clickArrowDownIcon();
	  inventoryItemPage.filterItemTextBox(PropertyFileUtil.getPropertyValue("itemNoDelete"));
	  inventoryItemPage.clickFilterButton();
	 // Assert.assertTrue(inventoryItemPage.clickFilterButton(), "Item not present");
	  
	  inventoryItemPage.clickSearchedItem();
	 // Assert.assertTrue(inventoryItemPage.clickSearchedItem(),"Item is not present in list");
	
	  Assert.assertTrue(inventoryItemPage.clickBinscheckIsDisplayed(), "Bin is not displayed");
	  Assert.assertTrue(inventoryItemPage.checkNoItem(), "There are no Items to display in Bin");
	  System.out.println("Item is not assigned to bin : No data to display");
	  
	  inventoryItemPage.clickDetailButton();
	  inventoryItemPage.clickDelete();
	  Assert.assertTrue(inventoryItemPage.getNotificationMsg().contains("Item deleted successfully!"));
	  Reporter.log("Item deleted",true);
	  }
	  
	  catch(AssertionError e)
	  {
		System.out.println(e.getMessage());  
	  }
	  catch(Exception e)
	  {
		 System.out.println(e.getMessage()); 
	  }
	  
	  finally
		{
		 loginPage.clickLogOut();
		}
	  }//Test Method end
	
	
	@Test(groups= {"Item"},enabled=false)
	public void editItem()
	{
		try
		{
		verifyLogin();
		inventoryItemPage.clickWebApiAutomationSite();
		inventoryItemPage.clickInventoryLink();
	    inventoryItemPage.clickItemsLink();
	    inventoryItemPage.clickArrowDownIcon();
		inventoryItemPage.filterItemTextBox(PropertyFileUtil.getPropertyValue("itemNoEdit"));
	    inventoryItemPage.clickFilterButton();
	    inventoryItemPage.clickSearchedItem();
	    inventoryItemPage.clickEditButton();
		
	    inventoryItemPage.enterDescription1("EditT0110011234");
		inventoryItemPage.enterDescription2("Edit2T0110011234");
		inventoryItemPage.enterUnitCost("10.00");
		inventoryItemPage.enterUnitPrice("20.00");
		inventoryItemPage.clickUpdateButton();
		Assert.assertTrue(inventoryItemPage.getNotificationMsg().contains("Item updated successfully!"));
		Reporter.log("Item edited and updated", true);
		loginPage.clickLogOut();
	    }catch(Exception e)
		{
	     System.out.println(e.getMessage());
		}
		
	}

}




