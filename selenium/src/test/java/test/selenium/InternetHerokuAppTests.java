package test.selenium;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.List;

import org.apache.hc.client5.*;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

		for(WebElement img : imageList)
		{
			if(img!=null)
			{
				String imgUrl = img.getAttribute("src");
				URL url = new URL(imgUrl);
				HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
				httpConn.setConnectTimeout(3000);
				httpConn.connect();
				
				if (httpConn.getResponseCode() != 200) {
                    System.out.println("Broken Image: " + imgUrl + " - " + httpConn.getResponseMessage());
                    test.log(Status.INFO, imgUrl+"is a broken image");
                } else {
                    System.out.println("Valid Image: " + imgUrl);
                    test.log(Status.INFO, imgUrl+"is a valid image");
                }
				
				
				
				
				
			}
		}
		
		
		
		
		
	}
	
	public void checkBox() throws IOException
	{
		HerokuAppPageObject page = new HerokuAppPageObject(driver);
		page.clickOnCheckBoxes();
		List<WebElement> checkboxes = page.checkCheckBoxes();
		test.log(Status.INFO,"Before clicking image" ,MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		for(WebElement box:checkboxes)
		{
			if(!box.isSelected())
			{
				box.click();
			}	

		}
		test.log(Status.INFO,"AFter clicked image" ,MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
	}
	
	
}
