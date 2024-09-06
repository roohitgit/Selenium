package rohit.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 
{
	
	public static  WebDriver driver;
	String url = "https://the-internet.herokuapp.com/";
	
	@BeforeSuite
	static void oneTimeSetUp()
	{
		WebDriverManager.chromedriver().setup();
	}


	@BeforeTest
	static void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));
		driver.manage().window().maximize();
	}
	
	
	@AfterTest
	static void endTest()
	{
		driver.close();
	}
	
	@AfterSuite
	static void oneTimeEndTest()
	{
		driver.quit();
	}
	
			
	
	
	
	
	
	
	
}
