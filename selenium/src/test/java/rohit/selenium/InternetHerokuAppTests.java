package rohit.selenium;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import PageObjects.HerokuAppPageObject;
import utilities.BaseClass;

@Test
public class InternetHerokuAppTests extends BaseClass {

	HerokuAppPageObject page;
	 
	@BeforeClass
	    public void setUp() {
	        page = new HerokuAppPageObject(driver);
	    }

	@Test
	public void ABTesting() {

		page.clickOnABTesting();
		Assert.assertEquals("A/B Test Control",page.getTextAfterABTestingClick ());
		test.log(Status.INFO, "A/B Test Control text is displayed successfully");
	

	}

	@Test
	public void testMethod2() {

//		driver.get("https://www.google.com");
//		System.out.println("Google page opened");
//		test.log(Status.PASS, "comment");

	}

}
