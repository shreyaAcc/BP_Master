package BP.SISP.Portal.PortalPages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SupplierUpdateDetailsPage {
	//*[@id="shellAppTitle"]
	
	 WebDriver driver;
	 
//		By PageHeader=By.id("shellAppTitle");
		@FindBy(id="shellAppTitle")
		WebElement PageHeader;
		
		 public  SupplierUpdateDetailsPage(WebDriver driver)
		 	{
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		    }
		 public void CheckCurrentPage()
		 {
//			 String CheckPage;
			 for(int i=0; i<=5;i++){
		    	 try{
			 WebDriverWait waiting = new WebDriverWait(driver,280);
		     waiting.until(ExpectedConditions.visibilityOf(PageHeader));
			 Assert.assertEquals(driver.getTitle(),"Supplier Update Details");
			 Assert.assertEquals(PageHeader.getText(),"Supplier Update Details");
			 System.out.println("Assertion Passed: At Supplier Update Details");
			 break;
		    	 }
		    	  catch(Exception e){
		    	     System.out.println(e.getMessage());
		    				
		    	  } 
			 }
		 }
		 
		 
		 public void ClickOnSubmitButton()
		 {

				WebElement SubmitBtn=driver.findElement(By.xpath("//*[contains(@id,'Submit')]"));
			 WebDriverWait waiting = new WebDriverWait(driver,280);
			 waiting.until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			 if(SubmitBtn.isDisplayed())
			 {
				 SubmitBtn.click();
				 System.out.println("Submiting the form");
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
