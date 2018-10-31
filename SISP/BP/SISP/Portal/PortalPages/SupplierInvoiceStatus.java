package BP.SISP.Portal.PortalPages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class SupplierInvoiceStatus {
	 WebDriver driver;
	 
	By PageHeader=By.id("shellAppTitle");
 
 public SupplierInvoiceStatus(WebDriver driver)
	 	{
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
 
 
 public void CheckCurrentPage()
 {

	 WebDriverWait waiting = new WebDriverWait(driver,280);
     waiting.until(elementIdentified(PageHeader));
	 Assert.assertEquals(driver.getTitle(),"Supplier Invoice Status");
	 System.out.println("Assertion Passed: At supplier Invoice Page");
	 
 }
 
 public void ClickOnSearchOnvoice()
 {
	 
	 WebElement searchBtn=driver.findElement(By.xpath("//*[contains(@id,'searchButton')]"));
	 WebDriverWait waiting = new WebDriverWait(driver,280);
	 waiting.until(ExpectedConditions.elementToBeClickable(searchBtn));
	 if(searchBtn.isDisplayed())
	 {
		 searchBtn.click();
		 System.out.println("Searching the invoice");
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
