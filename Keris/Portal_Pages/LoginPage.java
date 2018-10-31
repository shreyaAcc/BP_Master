/**
 * 
 * 
 * @author shreya.upadhyay
 * 
 * 	This is the Initial Login page to get LoggedIn the portal
 *
 *
 **/
 
package Portal_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import parallelTest.Constant;


public class LoginPage {
	 WebDriver driver;	
//	 By LnkRegion=By.linkText(Constant.Region);
//	 By EdtUserName=By.xpath("//input[@name='username']");
//	 By EdtPassWord=By.xpath("//input[@name='password']");
//	 By BtnLogin=By.tagName("Button");
//	
	 @FindBy(linkText=Constant.Region)
	 WebElement LnkRegion;
	 
	 @FindBy(xpath="//input[@name='username']")
	 WebElement EdtUserName;
	 
	 @FindBy(xpath="//input[@name='password']")
	 WebElement EdtPassWord;
	 
	 @FindBy(tagName="Button")
	 WebElement BtnLogin;
	 
	 
	 public LoginPage(WebDriver driver)
	 	{
	        this.driver = driver;
	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	 
	 //Select the region to Login
	 public void ClickOnRegionToLogin(String strRegion)
	 {
//		 driver.findElement(By.linkText(strRegion)).click();
		 LnkRegion.click();
	 }
	 
	 //Set user name and Password in text box 
	 
	 public void setCredential(String strUserName,String strPassword){

	     	EdtUserName.sendKeys(strUserName);
	        EdtPassWord.sendKeys(strPassword);

	    }

	  //Click on login button

	    public void clickLogin(){

	    BtnLogin.click();

	    }
	 
	    

	    //Get the Account Section if available

	    public String getLoginTitle(){

	     return   driver.findElement(By.id("__text7")).getText();

	    }

	    /**

	     * This POM method will be exposed in test case to login in the application

	     * @param strUserName

	     * @param strPasword

	     * @return

	     */

	    public void LoginToPortal(String strRegion, String strUserName,String strPasword){
	    	
	    	 driver.manage().window().maximize();
	    	WebDriverWait wait1 = new WebDriverWait(driver,320);
		    wait1.until(ExpectedConditions.visibilityOf(LnkRegion));
	    	this.ClickOnRegionToLogin(strRegion);
	    	
	    	for (String handle1 : driver.getWindowHandles()) 
		        {
	    		 	driver.switchTo().window(handle1);
		         }
	    	
	    	  WebDriverWait wait = new WebDriverWait(driver,320);
		      wait.until(ExpectedConditions.visibilityOf(EdtUserName));
		        
	    	this.setCredential(strUserName,strPasword);
	    	
	        //Click Login button
	        this.clickLogin(); 
	       
       

	    }

	}

