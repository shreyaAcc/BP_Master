/*
 * 
 * @author Shreya.Upadhyay
 * This Script is to check if User is able to SignIn Successfully and click on Request additional vender number and Check if the Paghe header,Page title is valid and then check
 * If submission button is enable and clickable
 * 
 */

package BP.SISP.Portal.PortalTests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Library.ExcelUtils;
import BP.SISP.Portal.PortalPages.HomePage;
import BP.SISP.Portal.PortalPages.LoginPage;
import BP.SISP.Portal.PortalPages.SupplierUpdateDetailsPage;

public class TC003_RequestAdditionalVenderNumber {
	

	WebDriver driver;
	HomePage hm,Hm1;
	LoginPage lp;
	public static final String Path_TestData = System.getProperty("user.home");
	public static final String File_TestData = "\\InputSheet.xlsx";
	DesiredCapabilities caps = new DesiredCapabilities();
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser)throws Exception
	{
		if(browser.equalsIgnoreCase("Chrome"))
			{
			ExcelUtils.setExcelFile(Path_TestData + File_TestData,"Sheet1");
			ExcelUtils.getCellData();

//			driver=new ChromeDriver();
//			System.setProperty("Webdriver.chrome.driver","C:/Program Files/Java/chromedriver.exe");
			System.out.println("Launching Chrome");
				caps.setCapability("name","TC003_RequestAdditionalVenderNumber");
				caps.setCapability("platform", "Windows 10");	
				caps.setCapability("browserName","chrome");
				caps.setCapability("version", "latest");
				caps.setCapability("passed",true);
				caps.setCapability("build","SISP_Portal"); 
				driver = new RemoteWebDriver(new URL("https://" + ExcelUtils.SUSERNAME + ":" + ExcelUtils.SACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub"),caps);
			}
		driver.get(ExcelUtils.URL);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	@Test(priority=0)

	public void TestLogin() throws Exception
	{
		ExcelUtils.setExcelFile(Path_TestData + File_TestData,"Sheet1");
		ExcelUtils.getCellData();
		String MyAccount;
		lp=new LoginPage(driver);
		lp.LoginToPortal(ExcelUtils.Username,ExcelUtils.Password);
		hm=new HomePage(driver);
		MyAccount=hm.GetMyAccountLink();
	   if(MyAccount.equalsIgnoreCase("AD2 SISPortal"))
	   {
		   System.out.println("LoggedIn Successfully");
	   }
	}
	
	@Test(priority=1)
	public void ClickOnRequestAdditionalInfo() throws InterruptedException
	{
		HomePage home=new HomePage(driver);
		home.ClickOnAdditionalVenderInfo();
		SupplierUpdateDetailsPage update=new SupplierUpdateDetailsPage(driver);
		update.CheckCurrentPage();
		update.ClickOnSubmitButton();
	
	
	}
	


}
