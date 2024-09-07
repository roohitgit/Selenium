package utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;




public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentTest test;
	ExtentReports extent = ExtentReportsImplement.createInstance("Reports/extentReport.html");
	String url = "https://the-internet.herokuapp.com/";


@BeforeTest
public void setUp() {
    
    driver = new ChromeDriver();
    driver.navigate().to(url);
    driver.manage().window().maximize();
}

@AfterTest
public void tearDown() {
    if (driver != null) {
        driver.quit();
        test.log(Status.INFO, "Browser closed successfully.");
    }
}
	


public String Capture(WebDriver driver) throws IOException
{
	TakesScreenshot scr = (TakesScreenshot) driver;
	File source = scr.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\screenshot.png";
	FileUtils.copyFile(source, new File(destinationFile));
	return destinationFile;
	
}
	
	
}
