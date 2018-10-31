package BP.SISP.Portal.PortalPages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
	 WebDriver driver;
//	 
//	 @FindBy(id="__xmlview1--loginIcon")
//	 WebElement LnkLogin;
	 By LnkLogin=By.id("__xmlview1--loginIcon");
	 
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
	 
	public void ClickOnLinkToLOgin()
	{
		 driver.findElement(LnkLogin).click();
		    	
	}
	 

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

	    public void LoginToPortal(String strUserName,String strPasword){
	    	
	    	 driver.manage().window().maximize();
	    	WebDriverWait wait1 = new WebDriverWait(driver,420);
		    wait1.until(elementIdentified(LnkLogin));
		    for(int i=0; i<=6;i++){
		    	 try{
		    			this.ClickOnLinkToLOgin();
		    		 break;
		    	 }
		    	  catch(Exception e){
		    	     System.out.println(e.getMessage());
		    				
		    	  }  	 }
	    
	    	
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
	    private static Function<WebDriver,WebElement> elementIdentified(final By locator) {
		    return new Function<WebDriver, WebElement>() {
		        @Override
		        public WebElement apply(WebDriver driver) {
		            return driver.findElement(locator);
		        }
		    };
		}

	

}
