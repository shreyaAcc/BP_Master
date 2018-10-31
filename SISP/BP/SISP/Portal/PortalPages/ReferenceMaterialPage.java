package BP.SISP.Portal.PortalPages;


import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReferenceMaterialPage {
	

		 WebDriver driver;
		 
		By PageHeader=By.id("shellAppTitle");
		
//		@FindBy(partialLinkText="Registration")
//		WebElement Doc_SelfRegistration;
//		
		@FindBy(linkText="Legal Notice.pdf")
		WebElement Doc_LegalNotice;
		
		@FindBy(partialLinkText="test")
		WebElement Doc_Test;
		
		 
	 public  ReferenceMaterialPage(WebDriver driver)
		 	{
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		    }
	 
	 
	 public void CheckCurrentPage()
	 {
//		 String CheckPage;
		 WebDriverWait waiting = new WebDriverWait(driver,280);
	     waiting.until(elementIdentified(PageHeader));
		 Assert.assertEquals(driver.getTitle(),"Documents");
		 System.out.println("Assertion Passed: At Refrence Materials Page");
		 
	 }
	 
//	 public void ClickOnDocuments() throws InterruptedException
//	 {
//		 WebDriverWait waiting = new WebDriverWait(driver,280);
//	     waiting.until(ExpectedConditions.visibilityOf(Doc_LegalNotice));
//	     Doc_LegalNotice.click();
//	    	 Thread.sleep(90000);
//		
//		for (String handle3 : driver.getWindowHandles()) 
//		        {
//	    		 	driver.switchTo().window(handle3);
//	    		 	System.out.println(handle3);
//			         }
//			System.out.println("Check if PDF or Txt file is attached");
//			ExpectedCondition<Boolean> pageLoadCondition = new   ExpectedCondition<Boolean>() { 
//		    	                   public Boolean apply(WebDriver driver) { 
//		    	                      return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"); 
//		    	                  } 
//		    	              }; 
//		    	     WebDriverWait wait = new WebDriverWait(driver,120); 
//		    	     wait.until(pageLoadCondition); 
//
//			
//			System.out.println("Check the title of page"+driver.getTitle());
//			Assert.assertEquals(driver.getTitle(),"Legal Notice.PDF");
//			
//			driver.close();
//		
//		for (String handle4 : driver.getWindowHandles()) 
//     {
//		 	driver.switchTo().window(handle4);
//		 	System.out.println(handle4);
//		 	
//      }
//	 }
	 
	 private static Function<WebDriver,WebElement> elementIdentified(final By locator) {
		    return new Function<WebDriver, WebElement>() {
		        @Override
		        public WebElement apply(WebDriver driver) {
		            return driver.findElement(locator);
		        }
		    };
		}


}
