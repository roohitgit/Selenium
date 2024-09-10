package rohit.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import PageObjects.HerokuAppPageObject;
import utilities.BaseClass;

@Test
public class InternetHerokuAppTests extends BaseClass {
	HerokuAppPageObject page;

	@Test
	public void method1() throws InterruptedException {

		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnABTesting();
		page.getTextAfterABTestingClick();
		test.log(Status.INFO, "Expected Text is displayed.");
	}

	@Test
	public void method2() {

		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnAddRemoveElements();
		page.clickOnAddElementBtn(1);
		page.clickOnDeleteBtn();
		page.clickOnAddElementBtn(3);
		Assert.assertEquals(page.checkNoOfDeleteButtons(), 2);
		test.log(Status.INFO, "Added and deleted successfully.");
	}
}
