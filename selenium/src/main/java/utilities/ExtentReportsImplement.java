package utilities;



import java.io.File;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportsImplement {
	
	public static ExtentReports extent;
    public static ExtentTest test;
	
	@BeforeSuite
	public void extentImplement()
	{
		System.getProperty("user.dir");
		File reportDir = new File("reports");
		if (!reportDir.exists()) {
		    reportDir.mkdir(); // Create directory
		}

		ExtentSparkReporter spark = new ExtentSparkReporter(new File(reportDir, "extentReport.html"));
		
		spark.config().setReportName("Automation Test Report");
		spark.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Rohit Badole");
        extent.setSystemInfo("Browser", "Chrome");
		
		
	}
	
	


}
