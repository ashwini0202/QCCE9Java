package demo.actiTime.GenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import demo.actiTime.pom.HomePage;
import demo.actiTime.pom.LoginPage;

public class BaseClass {
	
	WebDriver driver = null;
	PropertyUtils pUtils = new PropertyUtils();

	
	@BeforeSuite
	public void configBS() {
		//database connection
	}
	
	@BeforeTest
	public void configBT() {
		//parallel testing codes
	}
	
	@BeforeClass
	public void configBC() {
		//open the browser
		String browserName = pUtils.getPropertyData("./src/test/resource/actiTimeCommonData.properties", "browser");
		String url = pUtils.getPropertyData("./src/test/resource/actiTimeCommonData.properties", "url");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			throw new SessionNotCreatedException("Browser is not Supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@BeforeMethod
	public void configBM() {
		
	//login to the site
		LoginPage loginPage = new LoginPage(driver);
		String username = pUtils.getPropertyData("./src/test/resource/actiTimeCommonData.properties", "username");
		String password = pUtils.getPropertyData("./src/test/resource/actiTimeCommonData.properties", "password");

		loginPage.login(username, password);		
	}
	
	@AfterMethod
	public void configAM() {
		
	//logout from the site
		HomePage homePage = new HomePage(driver);
		homePage.clickOnlogout();
	}
	
	@AfterClass
	public void configAC() {
		
	//close the browser
		driver.quit();
	}
	
	
	@AfterTest
	public void configAT() {
		//close all the parallel connection
	}
	
	@AfterSuite
	public void configAS() {
		//close data connection
	}
}
