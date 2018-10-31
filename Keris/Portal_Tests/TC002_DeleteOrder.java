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
import Portal_Pages.OrderPage;
import parallelTest.Constant;

public class TC002_DeleteOrder {
	
	WebDriver driver;
	HomePage hm,Hm1;
	LoginPage lp;
	
	DesiredCapabilities caps = new DesiredCapabilities();
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser)throws Exception
	{
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
	
	public void SearchOrder()
	{
		Hm1=new HomePage(driver);
		Hm1.ClickOrdersTab();
		OrderPage op=new OrderPage(driver);		
		op.CheckPage();
		op.SearchOrderOverview();
	}
	
	@Test(priority=2)
	public void CheckOrderStatus()
	{
		OrderPage op1=new OrderPage(driver);
		op1.CheckOrdersResult();
	}
	
}