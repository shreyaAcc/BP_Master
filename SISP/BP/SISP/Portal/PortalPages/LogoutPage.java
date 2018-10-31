package BP.SISP.Portal.PortalPages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogoutPage {

	 WebDriver driver;
	 By LogOutBtn=By.xpath("//*[@id='logoutBtn']");
	 By CheckLogout=By.linkText("Sign in again");
	 
	 public  LogoutPage(WebDriver driver)
	 	{
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	
	 public void LogOut() throws InterruptedException {
		
		 System.out.println(driver.getCurrentUrl());	 	  
		 driver.navigate().refresh();
		 driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		 for(int i=0; i<=5;i++){
	    	 try{
	    		 By UserSection= By.xpath("//*[@id='meAreaHeaderButton']");
	    		 WebDriverWait waiting = new WebDriverWait(driver,60);
	    	     waiting.until(ExpectedConditions.elementToBeClickable(UserSection));
	    		     		 
	    	     driver.findElement(UserSection).click();
	    	     System.out.println("Able to click on User Section");
	    		 break;
	    	 }
	    	  catch(Exception e){
	    	     System.out.println(e.getMessage());
	    				
	    	  }  	 }
		 WebDriverWait wait = new WebDriverWait(driver,230);
	     wait.until(ExpectedConditions.presenceOfElementLocated(LogOutBtn));
	     driver.findElement(LogOutBtn).click(); 
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id='__mbox-btn-0-content']")).click();
	     WebDriverWait wait1 = new WebDriverWait(driver,230);
	     wait1.until(ExpectedConditions.presenceOfElementLocated(CheckLogout));
	     Assert.assertEquals(driver.findElement(CheckLogout).getText(),"Sign in again");	
	     System.out.println("Logout Successfully");
	    
	 }
	 

	
	
}
