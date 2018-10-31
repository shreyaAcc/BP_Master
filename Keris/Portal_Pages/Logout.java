

/**
 * @author shreya.upadhyay
 * This page is LogOut page from where we can SignOut from the application
 *
 */


package Portal_Pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	
	 WebDriver driver;
//	 By UserSection= By.xpath("//*[@id='meAreaHeaderButton']");
	 By EdtUserName=By.xpath("//input[@name='username']");
	 By LogOutBtn=By.xpath("//*[@id='logoutBtn']");
//	 By UserSection= By.xpath("//*[@id='meAreaHeaderButton']");
//	 @FindBy(xpath="//*[@id='meAreaHeaderButton']")
//	 WebElement UserSection;
	 
	 public Logout(WebDriver driver)
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
	     driver.findElement(By.xpath("//*[@id='__mbox-btn-0-inner']")).click();
	     
	     WebDriverWait waiti = new WebDriverWait(driver, 120);
	     waiti.until(ExpectedConditions.presenceOfElementLocated(EdtUserName));
	     if(driver.getTitle().contains("login"))
	     {
	    	 System.out.println("Logout Done Successfully"); 
	     }
	    
	 }
	 

}
