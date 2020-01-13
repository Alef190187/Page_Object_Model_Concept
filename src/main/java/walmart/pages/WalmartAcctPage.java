package walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class WalmartAcctPage extends TestBase {
	
	@FindBy(xpath="//span[@class='o_a o_v a9_f']")
	WebElement AcctText;
	
	@FindBy(xpath="//div[contains(text(),'Sign In')]")
	WebElement signInBtn;
	
	public WalmartAcctPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkAcctText() {
		return AcctText.isDisplayed();
	}
	
	public String chectTitleOfAcct() {
		return driver.getTitle();
	}
  
	public WalmartLoginPage clickOnSignInBtn() {
		signInBtn.click();
		return new WalmartLoginPage();
	}
}
