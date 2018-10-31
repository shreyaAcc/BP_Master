
/**
 * 
 * 
 * 
 * @author shreya.upadhyay
 * This is the Test Case which performs various task to Login,Switch to Statements section select Sold To party and the Date and then generate PDF statement for the same.
 * It calls all various pages involved to perform the functionality
 *
 */
package Portal_Tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Portal_Pages.BillingPage;
import Portal_Pages.HomePage;
import Portal_Pages.LoginPage;
import Portal_Pages.Logout;
import parallelTest.Constant;

public class TC001_GenerateStatement
{
	
	WebDriver driver;
	HomePage hm,Hm1;
	LoginPage lp;
	
	DesiredCapabilities caps = new DesiredCapabilities();
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser)throws Exception
	{
		if(browser.equalsIgnoreCase("Chrome"))
			{

//			driver=new ChromeDriver();
//			System.setProperty("Webdriver.chrome.driver","C:/Program Files/Java/chromedriver.exe");
			System.out.println("Launching Chrome");
				caps.setCapability("name","TC001_GenerateStatement");
				caps.setCapability("platform", "Windows 10");	
				caps.setCapability("browserName","chrome");
				caps.setCapability("version", "latest");
				caps.setCapability("passed",true);
				caps.setCapability("build","CrossBrowser_Test_Build1"); 
				driver = new RemoteWebDriver(new URL(Constant.SauceLabsURL),caps);
			}
		DesiredCapabilities caps1 = DesiredCapabilities.internetExplorer();
		if(browser.equalsIgnoreCase("InternetExplorer1"))
		{
			System.out.println("Launching IE");
			caps1.setCapability("name","IETest");
			caps1.setCapability("platformName", "Windows 7");
			caps1.setCapability("version","11.0");
			caps1.setCapability("passed",true);
			caps1.setCapability("build","CrossBrowser_Test_Build1");
			driver = new RemoteWebDriver(new URL(Constant.SauceLabsURL),caps1);
		}
		
		if(browser.equalsIgnoreCase("Firefox"))
		{
			System.out.println("Launching Firefox");	
			caps.setCapability("name","TestFirefox");
			caps.setCapability("platform", "Windows 10");	
			caps.setCapability("browserName","Firefox");
			caps.setCapability("version", "latest");
			caps.setCapability("passed",true);
			caps.setCapability("build","CrossBrowser_Pilot"); 
			driver = new RemoteWebDriver(new URL(Constant.SauceLabsURL),caps);
		}
		driver.get(Constant.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=0)

	public void TestLogin()
	{
			String MyAccount;
			lp=new LoginPage(driver);
			lp.LoginToPortal(Constant.Region,Constant.Username,Constant.Password);
			hm=new HomePage(driver);
			MyAccount=hm.GetMyAccountLink();
		   if(!MyAccount.isEmpty())
		   {
			   System.out.println("LoggedIn Successfully");
		   }
	}
	
	@Test(priority=1)
	
	public void CheckBillingSection()
	{
		Hm1=new HomePage(driver);
		Hm1.ClickBillingsSection();
		BillingPage bp=new BillingPage(driver);
		bp.CheckCurrentPage();
		bp.ToggleScreen();
	}
	
	@Test(priority=2)
	public void GenerateStatement() throws InterruptedException {
		BillingPage bp1=new BillingPage(driver);
		bp1.GenerateStatement();
	}
	
	 
	@Test(priority=3)
	public void ClosingBrowser() throws InterruptedException
		{  	
			Logout lg=new Logout(driver);
			lg.LogOut();
		}
	
	
	
}


