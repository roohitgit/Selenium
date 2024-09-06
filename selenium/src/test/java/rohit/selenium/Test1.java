package rohit.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

@Test
public class Test1 extends BaseClass {
	

	
	
	@Test
	public void testMethod1() {
		driver.navigate().to(url);
		test.log(Status.INFO, "This is logged");
	
	
	
	}
	
	
	

}
