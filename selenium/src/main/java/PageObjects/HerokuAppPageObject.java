package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HerokuAppPageObject {
	
	WebDriver driver;
	
	
	public HerokuAppPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "A/B Testing")
    private WebElement abTesting;
	
	@FindBy(xpath = "//*[text()='A/B Test Control']")
    private WebElement abTestingControl;
	
	

	public void clickOnABTesting()
	{
		abTesting.click();	
	}
	
	public String getTextAfterABTestingClick ()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.visibilityOf(abTestingControl));
		
	     return abTestingControl.getText();
	}
	
	

}
