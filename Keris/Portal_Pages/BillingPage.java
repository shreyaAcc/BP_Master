/**
 * 
 * 
 * @author shreya.upadhyay
 *This Class is having all elements involved in Billing Tab and various operation to be performed in Billing page
 *
 *
 */
package Portal_Pages;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import parallelTest.Constant;


public class BillingPage {
	
	 WebDriver driver;
	 WebElement st;
//
//	 By BillingOpt=By.id("__text10");
//	 By StatementsTab=By.xpath("//*[contains(@id,'statements')]");
	 @FindBy(id="__text10")
	 WebElement BillingOpt;
	 
	 @FindBy(xpath="//*[contains(@id,'statements')]")
	 WebElement StatementsTab;
	 
	 @FindBy(xpath="//*[@id='combobox-1042-inputEl']")
	 WebElement SoldToParty;
	 
	 @FindBy(xpath="//*[@id='ext-gen1227']")
	 WebElement SelectCalender;

	 
	 By MonthList=By.xpath("//*[@class='x-monthpicker-item x-monthpicker-month']//a[@class='x-monthpicker-item-inner']");
	 By YearList=By.xpath("//*[@class='x-monthpicker-item x-monthpicker-year']//a[@class='x-monthpicker-item-inner']");
	 By GenerateStatementBtn=By.xpath("//*[@id='button-1047-btnIconEl']");
	 By OptionSTP=By.className("x-boundlist-item");
	 
	 
	 public BillingPage(WebDriver driver)
	 	{
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	 public void CheckCurrentPage()
	 {
//		 String CheckPage;
		 WebDriverWait waiting = new WebDriverWait(driver,280);
	     waiting.until(ExpectedConditions.visibilityOf(BillingOpt));
		 Assert.assertEquals(driver.getTitle(),"Billing");
		 
	 }
	 
	 public void ToggleScreen()
	 {
		 String title=driver.getTitle();
		 Assert.assertEquals(title,"Billing");
		 driver.switchTo().frame("__xmlview2--extApp");	 
		 WebDriverWait waiting = new WebDriverWait(driver, 240);
	     waiting.until(ExpectedConditions.visibilityOf(StatementsTab));
	     
	     for(int i=0; i<=8;i++){
	    	 try{
	    		 StatementsTab.click();
	    		 break;
	    	 }
	    	  catch(Exception e){
	    	     System.out.println(e.getMessage());
	    				
	    	  }  	 }
	   			
		Assert.assertEquals(driver.getTitle(),"Statements");
	 }
	 
	 
	 
	 public void GenerateStatement() throws InterruptedException
	 {
		 WebDriverWait waiting = new WebDriverWait(driver,220);
	     waiting.until(ExpectedConditions.visibilityOf(SoldToParty));
	     driver.manage().window().maximize();
//	     for(int i=0; i<=3;i++){
//	    	  try{
	    		 SoldToParty.click();
//	    	     break;
//	    	  }
//	    	  catch(Exception e){
//	    	     System.out.println(e.getMessage());
//	    	  }
//	 }
	     
   
	     
	     List<WebElement> list = driver.findElements(OptionSTP);
	     list.get(1).click();
	     
	     SelectCalender.click();
		 List<WebElement> ls = driver.findElements(MonthList);
		 for(int i=0;i<ls.size();i++)
		 {
			if(ls.get(i).getText().equalsIgnoreCase(Constant.Month))
				{
					ls.get(i).click();
					break;
				}
		 }
		 
		 List<WebElement> ys = driver.findElements(YearList);
		 for(int i=0;i<ys.size();i++)
		 {
			if(ys.get(i).getText().equalsIgnoreCase(Constant.year))
				{
					ys.get(i).click();
					break;
				}
		 }
		 
		List<WebElement> ls1= driver.findElements(By.xpath("//*[@id='button-1191-btnIconEl']"));
		ls1.get(0).click();
		
		 WebDriverWait wait = new WebDriverWait(driver, 250);
		 wait.until(elementIdentified(GenerateStatementBtn));  
		
		 driver.findElement(GenerateStatementBtn).click();
		 
		Thread.sleep(40000);
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
	
		for (String handle3 : driver.getWindowHandles()) 
		        {
	    		 	driver.switchTo().window(handle3);
	    		 	System.out.println(handle3);
			         }
			System.out.println("Check if PDF file is attached");
			Assert.assertEquals(driver.getTitle(),"PDF");
			
			driver.close();
		
		for (String handle4 : driver.getWindowHandles()) 
        {
		 	driver.switchTo().window(handle4);
		 	System.out.println(handle4);
		 	
         }
	 }
	
	 private static Function<WebDriver,WebElement> elementIdentified(final By locator) {
		    return new Function<WebDriver, WebElement>() {
		        @Override
		        public WebElement apply(WebDriver driver) {
		            return driver.findElement(locator);
		        }
		    };
		}
	 
}
