package walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class WalmartLoginPage extends TestBase{
	
	@FindBy(xpath="//input[@id='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In' and @type='submit']")
	WebElement loginBtn;
	
	public WalmartLoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String chechtitleOfLoginpage() {
		return driver.getTitle();
	}
	
	public WalmartHomePage clickOnLoginBtn(String un, String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		loginBtn.click();
		return new WalmartHomePage();
		
	}
}
