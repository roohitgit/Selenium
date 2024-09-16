package test.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.hc.client5.*;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import PageObjects.HerokuAppPageObject;
import utilities.BaseClass;
import utilities.ReadExcel;

@Test
public class InternetHerokuAppTests extends BaseClass {
	HerokuAppPageObject page;

	@Test(enabled = false)
	public void ABTesting() throws InterruptedException {

		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnABTesting();
		page.getTextAfterABTestingClick();
		test.log(Status.INFO, "Expected Text is displayed.");
	}

	@Test(enabled = false)
	public void AddRemoveElements() {
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnAddRemoveElements();
		page.clickOnAddElementBtn(1);
		page.clickOnDeleteBtn();
		page.clickOnAddElementBtn(3);
		Assert.assertEquals(page.checkNoOfDeleteButtons(), 3);
		test.log(Status.INFO, "Added and deleted successfully.");

	}

	@Test(enabled = false)
	public void checkBrokenImages() throws IOException {

		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnBrokenImages();
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());

		for (WebElement img : imageList) {
			if (img != null) {
				String imgUrl = img.getAttribute("src");
				URL url = new URL(imgUrl);
				HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
				httpConn.setConnectTimeout(3000);
				httpConn.connect();

				if (httpConn.getResponseCode() != 200) {
					System.out.println("Broken Image: " + imgUrl + " - " + httpConn.getResponseMessage());
					test.log(Status.INFO, imgUrl + "is a broken image");
				} else {
					System.out.println("Valid Image: " + imgUrl);
					test.log(Status.INFO, imgUrl + "is a valid image");
				}

			}
		}

	}

	@Test(enabled = false)
	public void checkBox() throws IOException {
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnCheckBoxes();
		List<WebElement> checkboxes = page.checkCheckBoxes();
		test.log(Status.INFO, "Before clicking image",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		for (WebElement box : checkboxes) {
			if (!box.isSelected()) {
				box.click();
			}

		}
		test.log(Status.INFO, "AFter clicked image",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
	}

	@Test(enabled = false)
	public void dragAndDrop() throws IOException, InterruptedException {
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnDragAndDrop();
		Actions action = new Actions(driver);

		test.log(Status.INFO, "Before drag and drop",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());

		action.dragAndDrop(page.source, page.target).build().perform();

		test.log(Status.INFO, "After drag and drop",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());

	}

	@Test(enabled = false)
	public void dropDown() throws IOException, InterruptedException {

		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnDropDown();
		Select dropDown = new Select(page.dropDownList);

		WebElement firstElement = dropDown.getFirstSelectedOption();
		System.out.println("first selected option - " + firstElement);
		test.log(Status.INFO, "Before select by visible text",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());

		dropDown.selectByVisibleText("Option 1");

		test.log(Status.INFO, "Before select by index",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());

		dropDown.selectByIndex(2);
		test.log(Status.INFO, "Before select by value",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());

		dropDown.selectByValue("1");
		test.log(Status.INFO, "After select by value",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());

	}

	@Test(enabled = false)
	public void entryAd() throws IOException, InterruptedException

	{
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnEntryAd();
		test.log(Status.INFO, "Before modal close",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		page.clickOnCloseEntryModalWindow();
		test.log(Status.INFO, "After modal close",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());

	}

	@Test(enabled = false)
	public void floatingMenu() {
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnFloatingMenu();
		driver.findElement(By.cssSelector("a[href='#home']")).click();
		Assert.assertEquals("https://the-internet.herokuapp.com/floating_menu#home", driver.getCurrentUrl());
		test.log(Status.PASS, "clicked on home");
		driver.findElement(By.cssSelector("a[href='#news']")).click();
		Assert.assertEquals("https://the-internet.herokuapp.com/floating_menu#news", driver.getCurrentUrl());
		test.log(Status.PASS, "clicked on news");
		driver.findElement(By.cssSelector("a[href='#contact']")).click();
		Assert.assertEquals("https://the-internet.herokuapp.com/floating_menu#contact", driver.getCurrentUrl());
		test.log(Status.PASS, "clicked on contact");
		driver.findElement(By.cssSelector("a[href='#about']")).click();
		Assert.assertEquals("https://the-internet.herokuapp.com/floating_menu#about", driver.getCurrentUrl());
		test.log(Status.PASS, "clicked on about");
	}

	@Test(enabled = false)
	public void Geolocation() {
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnGeoLocation();
		page.clickOnWhereAmI();
		test.log(Status.INFO, "Geolocation latitude - " + page.getLatitude());
		test.log(Status.INFO, "Geolocation longitude - " + page.getLongitude());

	}

	@Test(enabled = false)
	public void HorizontalSlider() throws IOException, InterruptedException {
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnHorizontalSlider();
		test.log(Status.INFO, "Before",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		Thread.sleep(1000);
		page.setHorizontalSliderValue(50);
		test.log(Status.INFO, "After",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		test.log(Status.INFO, "value is " + page.slider.getAttribute("value"));

	}

	@Test(enabled = false)
	public void NestedFrames() {
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnNestedFrames();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		driver.switchTo().frame(driver.findElement(By.name("frame-top")));

		driver.switchTo().frame(driver.findElement(By.name("frame-left")));
		String leftFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))).getText();
		test.log(Status.INFO, "Left frame text is - " + leftFrame);
		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		String middleFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content"))).getText();
		test.log(Status.INFO, "Middle frame text is - " + middleFrame);
		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.name("frame-right")));
		String rightFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))).getText();
		test.log(Status.INFO, "Right frame text is - " + rightFrame);
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));
		String bottomFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))).getText();
		test.log(Status.INFO, "Bottom frame text is - " + bottomFrame);

	}

	@Test
	public void MultipleWindows() throws IOException {
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnMultipleWindows();
		page.clickOnWindowClickHere();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		
		String window1 = iterator.next();
		String window2 = iterator.next();
		
		test.log(Status.INFO, "First window url is " + driver.getCurrentUrl());
		test.log(Status.INFO, "First window title is " + driver.getTitle());
		test.log(Status.INFO, "Switching window to 2");
		driver.switchTo().window(window2);
		
		test.log(Status.INFO, "Second window url is " + driver.getCurrentUrl());
		test.log(Status.INFO, "Second window title is " + driver.getTitle());
		
		driver.switchTo().window(window1);
		test.log(Status.INFO, "Switching window to 1");
		test.log(Status.INFO, "Again First window url is " + driver.getCurrentUrl());
		test.log(Status.INFO, "Again First window title is " + driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com");
		if(driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed())
		{
			test.log(Status.INFO, "new tab opened and google is loaded");
		}
		else
		{
			test.log(Status.INFO, "new tab error", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
			
		}
		

	}

}
