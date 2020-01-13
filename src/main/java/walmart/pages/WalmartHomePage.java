package walmart.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class WalmartHomePage extends TestBase{
	
	@FindBy(xpath="//a[@id='vh-home-link']")
	WebElement logo;
	
	@FindBy(xpath="//span[text()='Account' and @data-tl-id= 'GlobalHeaderBubblesNav-BubbleButton']")
	WebElement acctBtn;

	public WalmartHomePage() {
		PageFactory.initElements(driver, this);
	
}
   public boolean walmartLogo() {
	  return logo.isDisplayed();
	  
   }
   public String homepageTitle() {
	 return  driver.getTitle();
   }
   
   public WalmartAcctPage clickOnacctBtn() {
	   acctBtn.click();
	   return new WalmartAcctPage();
	   
   }
   
}
