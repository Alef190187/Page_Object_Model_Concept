package Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestBase {
	public FileInputStream file;
	public static  Properties prop;
	public static WebDriver driver=null;
	public TestBase() {
	  prop = new Properties();
		try {
			file= new FileInputStream("C:\\Users\\alef1\\eclipse-workspace\\Page_Object_Model_Concept\\"
					+ "src\\main\\java\\walmart\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	
	public static void initialization() {
		String browser=prop.getProperty("browsername");
		if(browser.equalsIgnoreCase("chrome")) {
		/*System.setProperty("webdriver.chrome.driver","C:\\SeleniumDocuments\\WebDriver\\"
				+ "chromedriver_win32 (2)\\chromedriver.exe");*/
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			/*System.setProperty("webdriver.gecho.driver","C:\\SeleniumDocuments\\WebDriver\\"
					+ "chromedriver_win32 (2)\\gechodriver.exe");*/
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("ie")){
			/*System.setProperty("webdriver.ie.driver","C:\\SeleniumDocuments\\WebDriver\\"
					+ "chromedriver_win32 (2)\\internetExplorerdriver.exe");*/
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	      

}
