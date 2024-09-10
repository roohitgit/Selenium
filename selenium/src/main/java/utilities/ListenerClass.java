package utilities;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenerClass extends BaseClass implements ITestListener, ISuiteListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		test = extent.createTest(result.getMethod().getMethodName());
		driver = new ChromeDriver();
		driver.navigate().to(getUrl());
		driver.manage().window().maximize();

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		test.log(Status.PASS, "Test Passed");
		driver.close();

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
		try {
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
		driver.close();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
		test.log(Status.WARNING, "onTestFailedButWithinSuccessPercentage: " + result.getThrowable());
		driver.close();
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		test.log(Status.FAIL, "onTestFailedWithTimeout: " + result.getThrowable());
		driver.close();
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");

	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onSuiteStart");
		WebDriverManager.chromedriver().setup();
		System.out.println("Setup WebDriverManager");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onSuiteFinish");
		extent.flush();
	}

}
