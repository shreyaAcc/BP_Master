/**
 * 
 * @author avinash.bl
 * Validate Forgot Password
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
import BP.SISP.Portal.PortalPages.Register;
import Library.ExcelUtils;
import BP.SISP.Portal.PortalPages.HomePage;




public class TC008_RegistrationScenario
{
	WebDriver driver;
	HomePage Hm;
	public static final String Path_TestData = System.getProperty("user.home");
	public static final String File_TestData = "\\InputSheet.xlsx";			
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
				caps.setCapability("name","TC008_RegistrationScenario");
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
	public void WelcomePage() {
		Hm=new HomePage(driver);
		Hm.CheckCurrentPage();			
	}
	
	@Test(priority=1)
	public void Register() {
		Hm=new HomePage(driver);
		Hm.ClickRegister();
	}
	
	@Test(priority=2)
	public void LegalNoticeTab() throws InterruptedException {
		Register RG=new Register(driver);
		RG.LegalNoticeTab();
	}
	
	@Test(priority=3)
	public void SupplierRegistration() throws InterruptedException {
		Register RG=new Register(driver);
		RG.SupplierRegistration();
	}
	
}

