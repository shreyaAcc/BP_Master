package BP.SISP.Portal.PortalPages;

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

public class HomePage {
	
	 WebDriver driver;	
//	 By AccountOpt=By.id("__xmlview1--loginGreeting-bdi");
//	 @FindBy(id="__xmlview1--loginGreeting-bdi")
//	 WebElement AccountOpt;
	 @FindBy(id="__item0")
	 WebElement SupplierStatuslabel;
	 
	 @FindBy(id="__item1")
	 WebElement ReferenceMaterials;
	 
	 @FindBy(id="__item2")
	 WebElement VenderInfo;
	
	 @FindBy(id="userSettingsBtn")
	 WebElement SettingBtn;
	 @FindBy(id="shell-header-hdr-shell-title")
	 WebElement WelcomePage;
	 
	 @FindBy(id="__text0")
	 WebElement Home;
	 
	 @FindBy(id="__text1")
	 WebElement Register;
	 
	 @FindBy(id="__text2")
	 WebElement ForgotPassword;
	 
	 @FindBy(xpath="//*[contains(@class,'sapUshellHeadTitle')]")
	 WebElement Title;
	 
	 public HomePage(WebDriver driver)
	 	{
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);


	    }
	 public String GetMyAccountLink()
	 {
		    
	WebElement account = null;
	     driver.navigate().refresh();
	     driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		 for(int i=0; i<=5;i++){
	    	 try{
	    		 By AccountOpt= By.id("__xmlview1--loginGreeting-bdi");
	    		 WebDriverWait waiting = new WebDriverWait(driver,320);
	    		 waiting.until(elementIdentified(AccountOpt));
	    		 account=driver.findElement(AccountOpt);
	    		  if(account.isDisplayed())
	    			  System.out.println("Account displayed");
	    		  break;
	    	    
	    	 }
	    	  catch(Exception e){
	    	     System.out.println(e.getMessage());
	    				
	    	  } 
		 }
	    	 return account.getText();
	  }
	 
	 public void ClickOnSuppliersInvoiceStatus()
	 {
		 WebDriverWait waiting = new WebDriverWait(driver,320);
		 waiting.until(ExpectedConditions.visibilityOf(SupplierStatuslabel));
		 driver.findElement(By.xpath("//*[@id='__item0']/div/div[2]/a")).click();
		 
	 }
	 
	 public void ClickONReferenceMaterial()
	 {
		 WebDriverWait waiting = new WebDriverWait(driver,320);
		 waiting.until(ExpectedConditions.visibilityOf(ReferenceMaterials));
		 driver.findElement(By.xpath("//*[@id='__item1']/div/div[2]/a")).click();
	 }
	 
	 
	 
	 public void ClickOnAdditionalVenderInfo()
	 {
		 WebDriverWait waiting = new WebDriverWait(driver,320);
		 waiting.until(ExpectedConditions.visibilityOf(VenderInfo));
		 driver.findElement(By.xpath("//*[@id='__item2']/div/div[2]/a")).click();
	 }
	 
	 
	 
	 public void ClickOnSettings() throws InterruptedException
	 {
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
	     wait.until(ExpectedConditions.visibilityOf(SettingBtn));
	     SettingBtn.click(); 
	     Thread.sleep(2000);
	     System.out.println("Setting page launched");
	 }
	 
	 
	 private static Function<WebDriver,WebElement> elementIdentified(final By locator) {
		    return new Function<WebDriver, WebElement>() {
		        @Override
		        public WebElement apply(WebDriver driver) {
		            return driver.findElement(locator);
		        }
		    };
		}
	 
	 public String CheckCurrentPage() {
			WebDriverWait waiting = new WebDriverWait(driver, 100);
			waiting.until(ExpectedConditions.visibilityOf(WelcomePage));
//			if(((WebElement) WelcomePage).isDisplayed()) {
			if(WelcomePage.isDisplayed())
			{
				System.out.println("BP Supplier Invoice Status Portal page is displayed");
			}
	
			return WelcomePage.getText();
		 }	
		 
		 public void ClickForgotPassword() { 
			 WebDriverWait waiting = new WebDriverWait(driver, 130);
		     waiting.until(ExpectedConditions.visibilityOf(ForgotPassword));
		     if(ForgotPassword.isDisplayed()) {
		    	 System.out.println("Forgot Password link is displayed in BP Supplier Portal page");
		         ForgotPassword.click();
		     }
		 }
		 
		 public void ClickRegister() { 
			 WebDriverWait waiting = new WebDriverWait(driver, 130);
		     waiting.until(ExpectedConditions.visibilityOf(Register));
		     if(Register.isDisplayed()) {
		    	 System.out.println("Register link is displayed in BP Supplier Portal page");
		    	 Register.click();
		     }
		 }
		 
		 public void ClickHome() { 
			 WebDriverWait waiting = new WebDriverWait(driver, 130);
		     waiting.until(ExpectedConditions.visibilityOf(Home));
		     if(Home.isDisplayed()) {
		    	 System.out.println("Home link is displayed in BP Supplier Portal page");
		    	 Home.click();
		     }
		     driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		     System.out.println("Check if title of page Home is opened");  
			 Assert.assertEquals(driver.getTitle(),"Home");	     
		 }


}
