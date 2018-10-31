
/**
 * @author shreya.upadhyay
 * This page is Home page from where we can navigate to various other Pages
 *
 */

package Portal_Pages;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sun.awt.windows.WLightweightFramePeer;

public class HomePage {

	 WebDriver driver;	
	 By AccountOpt=By.id("__text7");
//	 By BillingOpt=By.id("__text10");
//	 By OrderOpt=By.id("__text8");
	 
//	 @FindBy(id="__text7")
//	 WebElement AccountOpt;
//	 	 
	 @FindBy(id="__text10")
	 WebElement BillingOpt;
	 
	 @FindBy(id="__text8")
	 WebElement OrderOpt;


	 
	 public HomePage(WebDriver driver)
	 	{
	        this.driver = driver;
	        
	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);


	    }
	 
	 public String GetMyAccountLink()
	 {
		 WebDriverWait waiting = new WebDriverWait(driver,320);
//	     waiting.until(ExpectedConditions.presenceOfElementLocated(AccountOpt));
//		 waiting.until(ExpectedConditions.visibilityOf(AccountOpt));
		 waiting.until(elementIdentified(AccountOpt));        
	     return driver.findElement(AccountOpt).getText();
	  }
	 
	 public void ClickBillingsSection()
	 {
		 WebDriverWait waitg = new WebDriverWait(driver, 280);
	     waitg.until(elementIdentified(By.id("__text10")));
	     if(BillingOpt.isDisplayed())
	     {
	    	 System.out.println("Billing Tab is displayed");
	    	 BillingOpt.click();
	     }
//	     WebDriverWait wait = new WebDriverWait(driver, 180);
//	     wait.until(elementIdentified(By.id("__text10")));
//	     
//	     return driver.findElement(By.id("__text10")).getText();
	 }
	 
	
	 public String ClickOrdersTab()
	 {
		 WebDriverWait waiting = new WebDriverWait(driver, 130);
	     waiting.until(ExpectedConditions.visibilityOf(OrderOpt));
	     if(OrderOpt.isDisplayed())
	     {
	    	 System.out.println("Order Tab is displayed");
	        OrderOpt.click();
	     }
		return OrderOpt.getText();
	     
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
