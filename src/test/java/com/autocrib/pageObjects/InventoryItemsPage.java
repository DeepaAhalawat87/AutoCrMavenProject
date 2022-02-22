package com.autocrib.pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryItemsPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	Select s;
	Alert alert;

	@FindBy(xpath="//i[@class='icon inventory-icon']/following-sibling::span")
	public WebElement inventoryLink;
	
	
	@FindBy(xpath="//a[@href='/Inventory/Item']/span[@class='anchor-element']")
	public WebElement itemsLink;
	
	
	@FindBy(xpath="//ul[@class='treeview-menu treeview-submenu']/li/a[@href='/Inventory/Item/Add']")
	public WebElement addItemLink;
	
	@FindBy(xpath="(//ul[@class='box-inner-listing-menu']/li/a)[14]")
	public WebElement webAPIAutomation;
	
	@FindBy(id="btnSubmit")
	public WebElement saveBtn;
	
	@FindBy(id="Code")
	public WebElement item;
	
	@FindBy(name="Description1")
	public WebElement description1;
	
	@FindBy(name="Description2")
	public WebElement  description2;
	
	@FindBy(name="ItemType")
	public WebElement selectItemType;
	
	@FindBy(id="Vendor")
	public WebElement selectSupplier;
	
	@FindBy(name="VendorItem")
	public WebElement supplierItem;
	
	@FindBy(id="Cost")
	public WebElement unitCost;
	
	@FindBy(id="AvgUnitCost")
	public WebElement unitPrice;
	
	@FindBy(id="IssueCost")
	public WebElement issueCost;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	public WebElement notificationMsg;
	
	
	@FindBy(xpath="(//div[@class='jqx-grid-column-menubutton jqx-icon-arrow-down'])[1]")
	public WebElement itemIconArrowDown;
	
	@FindBy(xpath="//input[contains(@class,'filtertext1grdAllItem')]")
	public WebElement filterItemTxtBox;
	
	@FindBy(id="filterbuttongrdAllItem")
	public WebElement filterBtn;
	
	@FindBy(xpath="//div[@id='row0grdAllItem']")
	public WebElement searchItemRow;
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	public WebElement deleteBtn;
	
	@FindBy(xpath="(//ul[@class='form-details-tablist pull-right']/li)[3]")
	public WebElement binsItemMenu;
	
	@FindBy(id="contentgrdBin")
	public WebElement BinItemGrid;
	
	@FindBy(xpath="//span[contains(text(),'No data to display')]")
	public WebElement noDataDisplay;
	
	@FindBy(xpath="(//ul[@class='form-details-tablist pull-right']/li)[2]")
	public WebElement detailBtn;
	
	@FindBy(xpath="(//i[@class='fa fa-floppy-o'])[2]")
	public WebElement editBtn;
	
	
	
	public InventoryItemsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    wait=new WebDriverWait(driver,15);
	}

	public void clickInventoryLink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(inventoryLink));
		this.inventoryLink.click();
	}
	
	public void clickItemsLink()
	{
	wait.until(ExpectedConditions.elementToBeClickable(itemsLink));
	this.itemsLink.click();
	}
	
	public void clickAddItem()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addItemLink));
		this.addItemLink.click();
		System.out.println("add item clicked");
	}
	
	 public void clickWebApiAutomationSite()
	   {
		  
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,200)");
		   wait.until(ExpectedConditions.elementToBeClickable(webAPIAutomation));
		   this.webAPIAutomation.click();
		   System.out.println("site clicked");
	   }
	 
	 public void clickSaveButton()
	 {
         JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,600)");
		 try
		 {
		 wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		 this.saveBtn.click();
		 }
		 catch(TimeoutException e)
		 {
		  e.printStackTrace(); 
		 }
		 catch(NoSuchElementException e)
		 {
		  e.printStackTrace();
		 }
	 }
	 
	 public void enterItem(String itemNum)
	 {
		
		wait.until(ExpectedConditions.visibilityOf(item));
		this.item.clear();
		this.item.sendKeys(itemNum); 
	 }

	 public void enterDescription1(String description1)
	 {
		 this.description1.clear();
		 this.description1.sendKeys(description1);
	 }
	 
	 public void enterDescription2(String description2)
	 {
		this.description2.clear();
		this.description2.sendKeys(description2); 
	 }
	 
	 public void enterItemType(String itemType)   //Expandable
	 {
		wait.until(ExpectedConditions.visibilityOf(selectItemType));
	    s=new Select(selectItemType);
		s.selectByVisibleText(itemType);
	 }
	 
	 public void enterSupplier(String supplierIndex)
	 {
		int index=Integer.valueOf(supplierIndex);
		wait.until(ExpectedConditions.visibilityOf(selectSupplier));
		s=new Select(selectSupplier);
		s.selectByIndex(index);
	 }
	 
	 public void enterSupplierItem(String suppItem)
	 {
		
		wait.until(ExpectedConditions.visibilityOf(supplierItem));
		this.supplierItem.clear();
		this.supplierItem.sendKeys(suppItem); 
	 }
	 
	 public void enterUnitCost(String unitCost)
	 {
		
		wait.until(ExpectedConditions.visibilityOf(this.unitCost));
		this.unitCost.clear();
		this.unitCost.sendKeys(unitCost); 
	 }
	 public void enterUnitPrice(String unitPrice)
	 {
		
		wait.until(ExpectedConditions.visibilityOf(this.unitPrice));
		this.unitPrice.clear();
		this.unitPrice.sendKeys(unitPrice); 
	 }
	 
	 public void enterIssueCost(String issueCost)
	 {
		 
		 wait.until(ExpectedConditions.visibilityOf(this.issueCost));
		 this.issueCost.clear();
		 this.issueCost.sendKeys(issueCost);
	 }
	 
	 public String getNotificationMsg()
	 {
		wait.until(ExpectedConditions.visibilityOf(notificationMsg));
		return this.notificationMsg.getText();
	 }
	 
	 public void clickArrowDownIcon() 
	 {
		wait.until(ExpectedConditions.elementToBeClickable(itemIconArrowDown));
	    this.itemIconArrowDown.click(); 
	 }
	 
	 public void filterItemTextBox(String itemNo)
	 {
		wait.until(ExpectedConditions.visibilityOf(filterItemTxtBox));
	    this.filterItemTxtBox.sendKeys(itemNo);
	 }
	 
	 public void clickFilterButton()
	 {
		 this.filterBtn.click();
		
	 }
	 
	 public void clickSearchedItem()
	 {
		 
		 wait.until(ExpectedConditions.visibilityOf(searchItemRow));
		 this.searchItemRow.click();
		 System.out.println("search item clicked");
	 }
	 
	 public void clickDelete()
	 {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,600)");
		 this.deleteBtn.click();
		 
		 wait.until(ExpectedConditions.alertIsPresent());
		 alert=driver.switchTo().alert();
		 alert.accept();
		 
	 }
	 
	 public boolean clickBinscheckIsDisplayed()
	 {
		 wait.until(ExpectedConditions.elementToBeClickable(binsItemMenu));
		 this.binsItemMenu.click();
		 wait.until(ExpectedConditions.visibilityOf(BinItemGrid));
		 return BinItemGrid.isDisplayed();
		 
	 }
	 
	 public boolean checkNoItem()
	 {
		 wait.until(ExpectedConditions.visibilityOf(noDataDisplay));
		 System.out.println(noDataDisplay.getText());
		  if(noDataDisplay.getText().equalsIgnoreCase("No data to display"))
			  return true;
		  else 
			  return false;
		
		 
	}
	 
	 public void clickDetailButton()
	 {
		 wait.until(ExpectedConditions.elementToBeClickable(detailBtn));
		 this.detailBtn.click();
	 }
	 
	 public void clickEditButton()
	 {
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		this.editBtn.click();
	 }
	 
	 public void clickUpdateButton()
	 {
		 clickSaveButton(); 
	 }
	
	 
	 
}
