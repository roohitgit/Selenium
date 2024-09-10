package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports extent = ExtentReportsImplement.createInstance("Reports/extentReport.html");
	private static String url = "https://the-internet.herokuapp.com/";

	public static String getUrl() {
		return url;
	}

	public String captureScreenShot(WebDriver driver) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date now = new Date();
		String date = sdf.format(now);
		TakesScreenshot scr = (TakesScreenshot) driver;
		File source = scr.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\Screenshots\\screenshot" + date + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
