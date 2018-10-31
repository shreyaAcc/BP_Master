package BP.SISP.Portal.PortalPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SettingPage {
	
	
	 WebDriver driver;
	@FindBy(className="sapMPageHeader")
	WebElement popupHeader;
	
	@FindBy(id="userSettingCancelButton")
	WebElement CancelButton;
	
	@FindBy(id="userSettingSaveButton")
	WebElement SaveButton;
	

	 
	 public  SettingPage(WebDriver driver)
	 	{
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 public void CheckPage()
	 {
		

		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.visibilityOf(popupHeader));
		
		  System.out.println(popupHeader.getText());
		  
		  List<WebElement> list = driver.findElements(By.className("sapMSLITitleDiv"));
			 System.out.println("Menu Items of the Setting Section");
			 for(int i=0;i<list.size();i++)
			 {
				 System.out.println(list.get(i).getText());
				 list.get(i).click();
			 }
			 
		System.out.println("Validate if Save and Cancel button is available");
		if(SaveButton.isDisplayed() && CancelButton.isDisplayed())
		{
			System.out.println("It is present:"+SaveButton.getText()+"   "+CancelButton.getText());
		}
		else
		{
			System.out.println("Buttons not present");
		}
	    }
	 }
