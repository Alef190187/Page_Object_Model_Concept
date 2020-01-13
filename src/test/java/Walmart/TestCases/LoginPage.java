package Walmart.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import walmart.pages.WalmartHomePage;
import walmart.pages.WalmartLoginPage;

public class LoginPage extends TestBase {
	WalmartLoginPage walmartloginpage;
	WalmartHomePage homepage;
	
	public LoginPage() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		walmartloginpage= new WalmartLoginPage();
		
	}
	@Test
	public void loginpageTitleTest() {
		String title= walmartloginpage.chechtitleOfLoginpage();	
		System.out.println(title);
		
	}
	
	@Test
	public void clickOnSignInBtn() {
		homepage = walmartloginpage.clickOnLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
