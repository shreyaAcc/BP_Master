/*
 * 
 * @author Shreya.Upadhyay
 * This Script is to login,Click on  Reference Material App and then check Reference Material Page and validating the title of the Page
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
import BP.SISP.Portal.PortalPages.ReferenceMaterialPage;

public class TC002_CheckRefrenceMaterials {



	public static final String Path_TestData = System.getProperty("user.home");
	public static final String File_TestData = "\\InputSheet.xlsx";
	WebDriver driver;
	HomePage hm,Hm1;
	LoginPage lp;
	
	DesiredCapabilities caps = new DesiredCapabilities();
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser)throws Exception
	{
		ExcelUtils.setExcelFile(Path_TestData + File_TestData,"Sheet1");
		ExcelUtils.getCellData();
		if(browser.equalsIgnoreCase("Chrome"))
			{

//			driver=new ChromeDriver();
//			System.setProperty("Webdriver.chrome.driver","C:/Program Files/Java/chromedriver.exe");
			System.out.println("Launching Chrome");
				caps.setCapability("name","TC002_CheckRefrenceMaterials");
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
	public void ClickOnReferenceMaterial() throws InterruptedException
	{
		HomePage home=new HomePage(driver);
		home.ClickONReferenceMaterial();
		ReferenceMaterialPage ref=new ReferenceMaterialPage(driver);
		ref.CheckCurrentPage();
	
	
	}
	

	
}
