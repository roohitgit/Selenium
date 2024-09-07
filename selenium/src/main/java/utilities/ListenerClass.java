package utilities;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;



@Test
public class ListenerClass extends BaseClass implements ITestListener, ISuiteListener {

	
  
	


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		  test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
		test.log(Status.WARNING, "onTestFailedButWithinSuccessPercentage: " + result.getThrowable());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		  test.log(Status.FAIL, "onTestFailedWithTimeout: " + result.getThrowable());
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
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onSuiteFinish");
		extent.flush();

	}

	}
	
	
	
	
	
	
	


