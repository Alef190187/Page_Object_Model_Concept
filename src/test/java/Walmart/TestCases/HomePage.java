package Walmart.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import walmart.pages.WalmartAcctPage;
import walmart.pages.WalmartHomePage;
import walmart.pages.WalmartLoginPage;

public class HomePage extends TestBase{
	WalmartHomePage homepage;
	WalmartAcctPage acctPage;
	WalmartLoginPage walmartloginpage;
	public HomePage(){
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		walmartloginpage= new WalmartLoginPage();
		homepage= walmartloginpage.clickOnLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
		//homepage = new WalmartHomePage();
		
	}
	
	@Test(priority=8)
	public void homepageTitleTest() {
		String title = homepage.homepageTitle();
		Assert.assertEquals(title,"Walmart.com | Save Money. Live Better.");
	}
	
	@Test(priority=7)
	public void homepageLogoTest() {
		boolean b= homepage.walmartLogo();
		Assert.assertTrue(b);
	}
	
	@Test(priority=2)
	public void clickOnAcctTest() {
		acctPage= homepage.clickOnacctBtn();
	}
	
	@Test(priority = 4)
	public void checkAcctPageTitle() {
		String title = acctPage.chectTitleOfAcct();
		System.out.println(title);
	}
	
	@Test(priority= 6)
	public void chechAcctTextTest() {
		boolean text= acctPage.checkAcctText();
		Assert.assertTrue(text);
	}
	 
	@Test(priority= 5)
	public void clickOnSignInBtn() {
		walmartloginpage = acctPage.clickOnSignInBtn();	
	}
	
	@Test(priority=3)
	public void loginpageTitleTest() {
		String title1 =walmartloginpage.chechtitleOfLoginpage();
		System.out.println(title1);
	}
	@Test(priority= 1)
	public void clickOnLoginBtn() {
		homepage= walmartloginpage.clickOnLoginBtn(prop.getProperty("username"), prop.getProperty("password"));	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
