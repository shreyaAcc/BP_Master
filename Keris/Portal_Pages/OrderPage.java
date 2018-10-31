/**
 * 
 * 
 * @author shreya.upadhyay
 *This Class is having all elements involved in Orders Tab and various operation to be performed in Orders page
 *
 *
 */

package Portal_Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import parallelTest.Constant;

public class OrderPage {
	
	String ChkPage;
	 WebDriver driver;
//	 	By OrderCreationDate=By.id("combobox-1027-inputEl");
//		By Setlimit=By.id("ux_form_field_limitcombo-1028-inputEl");
//		By Search=By.id("button-1031");
//		By OrderOpt=By.id("__text8");
		By SearchResult=By.xpath("//*[@id='button-1031-btnIconEl']");
		By CreationTimeFilter=By.className("x-boundlist-item");
		By CheckRows=By.xpath("//*[contains(@id,'record')]");
//		By CancelOrder=By.xpath("//*[@id='button-1096-btnIconEl']");
		
		@FindBy(id="combobox-1027-inputEl")
		 WebElement OrderCreationDate;
		
		@FindBy(id="ux_form_field_limitcombo-1028-inputEl")
		 WebElement Setlimit;
		
		@FindBy(id="button-1031")
		 WebElement Search;
		
		@FindBy(id="__text8")
		 WebElement OrderOpt;
		

		@FindBy(xpath="//*[@id='button-1096-btnIconEl']")
		 WebElement CancelOrder;
		
		
		 
		
		 
 public OrderPage(WebDriver driver)
 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
 	}
	
 public void CheckPage()
 {
	 WebDriverWait waiting = new WebDriverWait(driver, 60);
     waiting.until(ExpectedConditions.visibilityOf(OrderOpt));
     Assert.assertEquals(driver.getTitle(),"Orders");
     
 }

 public void SearchOrderOverview()
 {

	 String title=driver.getTitle();
	 Assert.assertEquals(title,"Orders");
	 driver.switchTo().frame("__xmlview2--extApp");	
	 
	 WebDriverWait waiting = new WebDriverWait(driver, 160);
     waiting.until(ExpectedConditions.visibilityOf(OrderCreationDate));
	
     for(int i=0; i<=3;i++){
    	 try{
    		OrderCreationDate.click();
    		 break;
    	 }
    	  catch(Exception e){
    	     System.out.println(e.getMessage());
    				
    	  }  	 }
   			
	 
	  List<WebElement> ls = driver.findElements(CreationTimeFilter);
		 for(int i=0;i<ls.size();i++)
		 {
			if(ls.get(i).getText().equalsIgnoreCase(Constant.OrderCreationTime))
				{
					ls.get(i).click();
					System.out.println("Order Creation date is selected");
					break;
				}
		 }
		 

	     for(int i=0; i<=3;i++){
	    	 try{
	    		Setlimit.click();
	    		 break;
	    	 }
	    	  catch(Exception e){
	    	     System.out.println(e.getMessage());
	    				
	    	  }  	 }
	   			
//		 List<WebElement> list = driver.findElements(CreationTimeFilter);
//		 for(int i=0;i<ls.size();i++)
//		 {
//			if(list.get(i).getText().equalsIgnoreCase(Constant.SetOrderLimit))
//				{
//					ls.get(i).click();
//					System.out.println("Limit is Set");
//					break;
//				}
//		 }
//		 
		 driver.findElement(SearchResult).click();
 }	 
		public void CheckOrdersResult()
		{
//			if(driver.findElement(By.className("txt")).isDisplayed())
//				{
//				System.out.println("No Results Found for the Order Filter");
//				
//				}
			
			 List<WebElement> RowSize = driver.findElements(CheckRows);
			 List<WebElement> tableCols = RowSize.get(0).findElements(By.tagName("td"));
			 String cellValue = tableCols.get(6).getText();
			 tableCols.get(6).click();
			 System.out.println(cellValue);
			 if(cellValue.equalsIgnoreCase("Open"))
			 {
				 System.out.println("Order is in Openned Status");
				 
				 assertTrue(CancelOrder.isEnabled());
			 }
			 
			 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			 
			 		 if(!cellValue.equalsIgnoreCase("Open"))
			 {

				 if(CancelOrder.isEnabled()) 
				 {
					 System.out.println("Cancel button is still enabled");
				 }
				 
				 assertFalse(CancelOrder.isEnabled());
				 
			 }


		}
		 
		 
 }
