package PageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptException;

public class HerokuAppPageObject {

	WebDriver driver;

	public HerokuAppPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "A/B Testing")
	private WebElement abTesting;

	@FindBy(xpath = "//h3[contains(text(), 'A/B')]")
	private WebElement abTestingControl;

	@FindBy(css = "a[href='/add_remove_elements/']")
	private WebElement addRemoveElements;

	@FindBy(css = "button[onclick='addElement()']")
	private WebElement addElementBtn;

	@FindBy(css = ".added-manually")
	private WebElement deleteBtn;

	@FindBy(xpath = "//*[text()='Basic Auth']")
	private WebElement basicAuth;
	
	@FindBy(css = "a[href='/broken_images']")
	private WebElement brokenImages;
	
	@FindBy(xpath = "//a[normalize-space()='Checkboxes']")
	private WebElement checkBoxes;
	
	@FindBy(css = "a[href='/drag_and_drop']")
	private WebElement dragAndDrop;
	
	@FindBy(xpath = "//header[normalize-space()='A']")
	public WebElement source;
	
	@FindBy(xpath = "//header[normalize-space()='B']")
	public WebElement target;
	
	@FindBy(xpath = "//a[normalize-space()='Dropdown']")
	public WebElement dropDown;
	
	@FindBy(id = "dropdown")
	public WebElement dropDownList;
	
	@FindBy(css = "a[href='/entry_ad']")
	public WebElement entryAd;
	
	@FindBy(css = "#restart-ad")
	public WebElement restartAd;
	
	@FindBy(xpath = "//p[normalize-space()='Close']")
	public WebElement entryAdModalClose;
	
	@FindBy(css = "a[href='/floating_menu']")
	public WebElement floatingMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Geolocation']")
	public WebElement geolocation;
	
	@FindBy(css = "button[onclick='getLocation()']")
	public WebElement whereAmIBtn;
	
	@FindBy(id = "lat-value")
	public WebElement latitude;
	
	@FindBy(id = "long-value")
	public WebElement longitude;
	
	@FindBy(css = "a[href='/horizontal_slider']")
	public WebElement horizontalSlider;
	
	@FindBy(xpath = "//input[@type='range']")
	public WebElement slider;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickOnABTesting() {
		abTesting.click();
	}

	public String getTextAfterABTestingClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(abTestingControl));

		return abTestingControl.getText();
	}

	public void clickOnAddRemoveElements() {
		addRemoveElements.click();
	}

	public void clickOnAddElementBtn(int num) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(addElementBtn));

		for (int i = 1; i <= num; i++) {
			addElementBtn.click();
		}
	}

	public void clickOnDeleteBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		deleteBtn.click();
	}

	public int checkNoOfDeleteButtons() {
		WebElement ele = driver.findElement(By.xpath("//div[@id='elements']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
		return ele.findElements(By.tagName("button")).size();

	}
	
	public void clickOnBasicAuth()
	{
		basicAuth.click();
	}
	
	public void clickOnBrokenImages()
	{
		brokenImages.click();
	}
	
	public void clickOnCheckBoxes()
	{
		checkBoxes.click();
	}
	
	public List<WebElement> checkCheckBoxes()
	{
		return driver.findElements((By.xpath("//input[@type='checkbox']")));
	}
	
	public void clickOnDragAndDrop()
	{
		dragAndDrop.click();
	}
	
	public void clickOnDropDown()
	{
		dropDown.click();
	}
	
	public void clickOnDropDownList()
	{
		dropDownList.click();
	}
	
	public void clickOnEntryAd()
	{
		entryAd.click();
	}
	
	public void clickOnRestartEntryAd()
	{
		restartAd.click();
	}
	
	public void clickOnCloseEntryModalWindow()
	{
		entryAdModalClose.click();
	}
	
	public void clickOnFloatingMenu()
	{
		floatingMenu.click();
	}
	
	public void clickOnGeoLocation()
	{
		geolocation.click();
	}
	
	public void clickOnWhereAmI()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(whereAmIBtn)).click();
		
	}

	public String getLatitude()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(latitude));
		return latitude.getText();
	}
	
	public String getLongitude()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(longitude));
		return longitude.getText();
	}
	
	public void clickOnHorizontalSlider()
	{
		horizontalSlider.click();
	}
	
	public void setHorizontalSliderValue(int n)
	{
		Actions move = new Actions(driver);
		move.dragAndDropBy(slider,n,0).build().perform();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
